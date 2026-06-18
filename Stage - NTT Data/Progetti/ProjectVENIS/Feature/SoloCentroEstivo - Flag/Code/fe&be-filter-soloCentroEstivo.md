## 💻 File: `Repository_BEFORE.java`

### Purpose

The following implementation represents the **legacy database query mapping** that originally created and after caused the custom attribute filtering defect.

The logic was based on an **incomplete parameter-binding approach**. Although the UI checkbox parameter was captured by the service layer (pre-building it), it was completely ignored within the repository query execution. As a consequence, the data layer failed to restrict rows based on dynamic teacher profiles, causing the interface to display all records indiscriminately.

### Legacy Implementation

```java
package com.nttdata.portfolio.repository;

import com.nttdata.portfolio.dto.AnonymizedRowDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * * LEGACY LOGIC (ERRONEOUS):
 * Ghost-filter approach.
 * The query execution completely ignores the 'soloCentroEstivo' parameter.
 * Missing input bindings and EAV dynamic structural lookup.
 */
@Repository
public interface CustomRegistryRepository extends JpaRepository<CustomRegistry, Long> {

    @Query(
            value = """
                    select new com.nttdata.portfolio.dto.AnonymizedRowDTO(
                        r.id, i.id, i.nome, i.cognome, i.codiceFiscale, r.posizione
                    )
                    from CustomRegistry r
                    join r.profile i
                    where r.status = 'ACTIVE'
                    and (:tipoScuolaId is null or r.tipoScuolaId = :tipoScuolaId)
                    and (
                        :searchText is null
                        or lower(i.nome) like lower(concat('%', :searchText, '%'))
                        or lower(i.cognome) like lower(concat('%', :searchText, '%'))
                    )
                    -- MISSING: Dynamic attribute subquery lookup was completely absent here
                    """,
            countQuery = """
                    select count(r.id)
                    from CustomRegistry r
                    join r.profile i
                    where r.status = 'ACTIVE'
                    and (:tipoScuolaId is null or r.tipoScuolaId = :tipoScuolaId)
                    and (
                        :searchText is null
                        or lower(i.nome) like lower(concat('%', :searchText, '%'))
                        or lower(i.cognome) like lower(concat('%', :searchText, '%'))
                    )
                    """
    )
    Page<AnonymizedRowDTO> searchRegistryRecords(
            @Param("dataDa") LocalDate dataDa,
            @Param("dataA") LocalDate dataA,
            @Param("tipoScuolaId") Long tipoScuolaId,
            @Param("searchText") String searchText,
            @Param("soloConvocabili") boolean soloConvocabili,
            // MISSING PARAMETER: The interface method was also desynchronized 
            // with the total argument count requested by the invocation stack
            @Param("applyStatusFilter") boolean applyStatusFilter,
            Pageable pageable
    );
}

```

### Generated SQL Predicate

Because the parameter was missing from both the signature and the logical processing filters, Hibernate executed a standard relational block:

```sql
WHERE r.status = 'ACTIVE'
  AND ( ? IS NULL OR r.tipo_scuola_id = ? )
  AND ( ? IS NULL OR LOWER(i.nome) LIKE LOWER(?) ... )

```

### Why This Approach Was Incorrect

The query engine had no structural instruction to query the dynamic dynamic attribute mapping layer. It treated the query execution as a static dataset extraction.

#### Example Scenario

* **UI State Filter:** Checkbox checked (`soloCentroEstivo = true`).
* **Target Sandbox Row:** Record active with key-value data `DISPONIBILITA_CENTRO_ESTIVO = 'SI'`.

The database returned all profiles because the data access object was completely blind to the dynamic parameter context, passing unfiltered datasets straight back to the UI interface engine.
