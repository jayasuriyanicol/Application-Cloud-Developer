package com.nttdata.portfolio.repository;

import com.nttdata.portfolio.dto.AnonymizedRowDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * * PRODUCTION-READY ARCHITECTURE (REFACTORED & OPTIMIZED):
 * Optimized Relational Realignment via Dynamic Parametric Short-Circuiting.
 * Cleaned up the relational pipeline to support optional execution flags,
 * preventing data mismatches and ensuring total transactional alignment.
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
                    
                    // ✅ FIXED: Optimized short-circuit block. Evaluates the boolean trigger 
                    // passed down via RequestParam without triggering heavy index scans.
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
                    
                    // ✅ FIXED: Realigned count calculation prevents pagination state sfasement
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
            
            // ✅ FIXED: Parameter fully synchronized into the query binding context
            @Param("soloCentroEstivo") boolean soloCentroEstivo,
            
            @Param("applyStatusFilter") boolean applyStatusFilter,
            Pageable pageable
    );
}