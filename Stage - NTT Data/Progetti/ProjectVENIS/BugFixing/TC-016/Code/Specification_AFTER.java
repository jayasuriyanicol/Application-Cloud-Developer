package com.nttdata.portfolio.specification;

import java.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * * UPDATED LOGIC (FIXED & REFACTORED): 
 * Period Overlapping / Intersection Approach.
 * Clean Code Update: Methods renamed to clarify the temporal verification behavior.
 */


//*GraduatorieSpecificationsInfo.java
public class DateFilterSpecifications {


     // ? Verifies that the record is still valid after the filter's start date.
    //  ? (Checks if the expiration date is greater than or equal to the input date).
    
    public static <T> Specification<T> verifyAfterDate(LocalDate dataInizio) {
        return (root, query, cb) -> dataInizio == null ? null :

                // *FIXED: The record must end AFTER or ON the filter's start date
                cb.greaterThanOrEqualTo(root.get("dataFine"), dataInizio); 
    }

    
     // ?Verifies that the record started before the filter's maximum end date boundary.
     // ?(Checks if the inception date is less than or equal to the input date).
     
    public static <T> Specification<T> verifyBeforeDate(LocalDate dataFine) {
        return (root, query, cb) -> dataFine == null ? null :

                // *FIXED: The record must start BEFORE or ON the filter's end date
                cb.lessThanOrEqualTo(root.get("dataInizio"), dataFine); 
    }
}


//*GraduatorieServices.java

//? Renaimed the method with the correct method on the service, due to refactor
.and(GraduatoriaInfoSpecifications.verifyAfterDate(request.getDataInizio()))
.and(GraduatoriaInfoSpecifications.verifyBeforeDate(request.getDataFine()))








