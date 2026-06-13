package com.nttdata.portfolio.specification;

import java.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * * UPDATED LOGIC (FIXED): Period Overlapping / Intersection Approach.
 * Correctly evaluates if the record's lifespan intersects the user's filter window.
 */
public class DateFilterSpecifications {

    public static <T> Specification<T> dataInizioFrom(LocalDate dataInizio) {
        return (root, query, cb) -> dataInizio == null ? null :
                // FIXED: The record must end AFTER or ON the filter's start date
                cb.greaterThanOrEqualTo(root.get("dataFine"), dataInizio);
    }

    public static <T> Specification<T> dataFineTo(LocalDate dataFine) {
        return (root, query, cb) -> dataFine == null ? null :
                // FIXED: The record must start BEFORE or ON the filter's end date
                cb.lessThanOrEqualTo(root.get("dataInizio"), dataFine);
    }
}