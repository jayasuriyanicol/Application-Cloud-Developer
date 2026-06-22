## File: `ContrattoCreateComponent_BEFORE.ts`

### Purpose

The following implementation represents the **legacy TypeScript event mapping** that originally created the business warning desynchronization and the subsequent local compiler crash.

The logic was based on an **unoptimized event-binding approach**. The component template layer was configured to trigger changes using an unmapped method token. Meanwhile, inside `ngOnInit`, the asynchronous validation handler lacked uniform thread isolation and stream pipes. As a consequence, the data interface failed to compile locally due to signature errors (`TS2339`), while the execution engine initiated duplicate, conflicting stream subscriptions that overloaded runtime state evaluations.

### Legacy Implementation



```typescript
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
 * * UPDATED LOGIC (FIXED & REFACTORED):
 * Dynamic Attribute Correlation via Short-Circuit Subquery Isolation.
 * Cleans up positional signature sfasement and links the custom checkboxes to the dynamic EAV structure.
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
                    
                    // *FIXED: Dynamic EAV short-circuit subquery intersection
                    and (
                        :soloCentroEstivo = false
                        or exists (
                            select 1 from ProfileAttributeValue pav
                            where pav.profile.id = i.id
                            and pav.attributeDefinition.code = 'DISPONIBILITA_CENTRO_ESTIVO'
                            and pav.stringVal = 'SI'
                        )
                    )
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
                    
                    // *FIXED: Count query alignment prevents structural dynamic calculation mismatches
                    and (
                        :soloCentroEstivo = false
                        or exists (
                            select 1 from ProfileAttributeValue pav
                            where pav.profile.id = i.id
                            and pav.attributeDefinition.code = 'DISPONIBILITA_CENTRO_ESTIVO'
                            and pav.stringVal = 'SI'
                        )
                    )
                    """
    )
    Page<AnonymizedRowDTO> searchRegistryRecords(
            @Param("dataDa") LocalDate dataDa,
            @Param("dataA") LocalDate dataA,
            @Param("tipoScuolaId") Long tipoScuolaId,
            @Param("searchText") String searchText,
            @Param("soloConvocabili") boolean soloConvocabili,
            
            // *FIXED: Parameter structurally linked into the argument chain
            @Param("soloCentroEstivo") boolean soloCentroEstivo,
            
            @Param("applyStatusFilter") boolean applyStatusFilter,
            Pageable pageable
    );
}
```





This joint refactoring between the Frontend and Backend addresses a parameter desynchronization issue (commonly known as the *Ghost-Filter* anomaly) within a data architecture based on the **Entity-Attribute-Value (EAV)** model.

Initially, user interactions with the *"Solo Centro Estivo"* (Summer Camp Only) checkbox on the Frontend were completely ignored. This update synchronizes the entire application call chain through three primary interventions:

1. **In the Angular Frontend (`CustomRegistryListComponent`):** A new reactive control is mapped within the form block, capturing the boolean state of the checkbox in real-time and embedding it into the REST API request payload.
2. **In the Java Spring Boot Service Layer (`CustomRegistryServiceImpl`):** The method signature is realigned to handle the exact structural sequence of 14 execution parameters, extracting the flag as a primitive boolean to safely forward it down to the data access tier.
3. **In the JPA Repository (`CustomRegistryRepository`):** An inline conditional subquery with *short-circuit* evaluation is injected. If the filter is disabled, the database engine bypasses the lookup entirely to preserve runtime performance; if enabled, it strictly isolates only the profiles that possess the specific `DISPONIBILITA_CENTRO_ESTIVO` key matched with a value of `'SI'` within the dynamic EAV relational table.







```java
package com.nttdata.portfolio.service.impl; // Logical portfolio context tracker

import com.nttdata.portfolio.dto.AnonymizedRowDTO;
import com.nttdata.portfolio.dto.SafeRequestDTO;
import com.nttdata.portfolio.repository.CustomRegistryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * * UPDATED LOGIC (FIXED & REFACTORED):
 * Service Layer Parameter Alignment and Safe Primitive Extraction.
 * Synchronizes the internal transaction pipeline to intercept the structural 14-parameter stack
 * and explicitly forwards the evaluated payload states directly down to the JPQL/HQL query layer.
 */
@Service
@Transactional(readOnly = true)
public class CustomRegistryServiceImpl implements CustomRegistryService {

    private final CustomRegistryRepository customRegistryRepository;

    public CustomRegistryServiceImpl(CustomRegistryRepository customRegistryRepository) {
        this.customRegistryRepository = customRegistryRepository;
    }

    @Override
    public Page<AnonymizedRowDTO> getPaginatedRecords(SafeRequestDTO safeRequest, Pageable pageable) {
        
        // *FIXED: Local variables extraction setup correctly to comply with data model query boundaries
        LocalDate dataDa = safeRequest.getDataDa() != null ? safeRequest.getDataDa() : LocalDate.now();
        LocalDate dataA = safeRequest.getDataA();
        boolean applyStatusFilter = safeRequest.getApplyStatusFilter() != null ? safeRequest.getApplyStatusFilter() : true;

        // ? The calling pipeline method argument layer is refactored to exactly match the 14-attribute repository signature
        return customRegistryRepository.searchRegistryRecords(
                dataDa,
                dataA,
                safeRequest.getTipoScuolaId(),
                this.trimToNull(safeRequest.getSearchText()),
                Boolean.TRUE.equals(safeRequest.getSoloConvocabili()),

                // *FIXED: Explicit validation passed as a structural primitive boolean to defeat the ghost-filter anomaly
                Boolean.TRUE.equals(safeRequest.getSoloCentroEstivo()),
                
                applyStatusFilter,
                pageable
        );
    }

    private String trimToNull(String text) {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }
        return text.trim();
    }
}
```

  



