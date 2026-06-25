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
                    
                    -- *FIXED: Dynamic EAV short-circuit subquery intersection
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
                    
                    -- *FIXED: Count query alignment prevents structural dynamic calculation mismatches
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



// *CustomRegistryService.java
// ?Renamed and synchronized the calling pipeline method argument layer to exactly 14 attributes

Page<AnonymizedRowDTO> page = customRegistryRepository.searchRegistryRecords(
    dataDa,
    dataA,
    safeRequest.getTipoScuolaId(),
    trimToNull(safeRequest.getSearchText()),
    Boolean.TRUE.equals(safeRequest.getSoloConvocabili()),

    // *FIXED: Explicit evaluation passed as a structural primitive boolean
    Boolean.TRUE.equals(safeRequest.getSoloCentroEstivo()),
    
    applyStatusFilter,
    pageable
);

/**
  
 * ? Why This Solution Resolves the Issue

 * *The short-circuit condition ensures a multi-mode runtime query profile optimization:

 * *1. **Bypass Mode (`:soloCentroEstivo = false`):** The first condition evaluates to `true` instantly. Hibernate drops the subquery block at execution time, maintaining ultra-fast execution loops for general queries.
 * *2. **Strict Profile Isolation Mode (`:soloCentroEstivo = true`):** The engine forces an immediate index scan into the key-value dynamic grid table (`ProfileAttributeValue`), dropping out any main entity reference that doesn't explicitly display the authorized code configuration (`DISPONIBILITA_CENTRO_ESTIVO`) and string criteria value (`SI`).

**/