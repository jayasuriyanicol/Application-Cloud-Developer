/*AFTER: Implementation & Codebase Refactoring

The system was fully hardened by introducing an event-driven *on-demand* check on the Frontend, paired with a robust database-level string normalization query on the Backend.

Backend Implementation (Java)

1. Data Access Layer (`GraduatoriaInfoRepository.java`)

We injected a custom JPQL query using native SQL `UPPER` and `REPLACE` functions. This strips out all spaces and neutralizes casing discrepancies directly during the database lookup.

*/

package com.venis.supplenti.repository;

import com.venis.supplenti.domain.GraduatoriaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GraduatoriaInfoRepository extends JpaRepository<GraduatoriaInfo, Long> {

    @Query("SELECT COUNT(g) > 0 FROM GraduatoriaInfo g WHERE UPPER(REPLACE(g.codice, ' ', '')) = :codice")
    boolean existsByCodice(@Param("codice") String codice);
}


/* 2. Business Logic Layer (`GraduatoriaService.java`)

Before saving the final payload, the service invokes the repository check as a backend safety guard, throwing a dedicated business exception if an invalid code tries to bypass the UI layer.
*/


public GraduatoriaDTO save(GraduatoriaDTO graduatoriaDTO) {
    if (graduatoriaDTO.getCodice() != null) {
        String sanitizedCode = graduatoriaDTO.getCodice().toUpperCase().replaceAll("\\s+", "");
        
        if (graduatoriaInfoRepository.existsByCodice(sanitizedCode)) {
            throw new BusinessException("The ranking code is already in use within the system.");
        }
    }
    return proceedWithSave(graduatoriaDTO);
}

