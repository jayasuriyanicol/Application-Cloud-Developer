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

Before saving the final payload, check the existing of a CodiceGraduatoria triming the spaces
*/



    // ?CHECK: check the existing of a CodiceGraduatoria triming the spaces
    @Transactional(readOnly = true)
    public boolean existsByCodice(String codiceGraduatoria) {
        if (codiceGraduatoria == null) {
            return false;
        }

        String sanitizedCode = codiceGraduatoria.toUpperCase().replaceAll(" ", "");

        return graduatoriaInfoRepository.existsByCodice(sanitizedCode);
    }


