---

## 💻 File: `Specification_BEFORE.java`

### Purpose

The following implementation represents the **legacy filtering logic** that originally caused the date-range filtering defect described in **Bug Report TC-016**.

The logic was based on a **closed-container approach**, requiring a record's entire validity period to be fully contained within the user-selected filter boundaries.

As a consequence, records whose validity period only partially overlapped the requested date range were incorrectly excluded from the result set.

### Legacy Implementation

```java
package com.nttdata.portfolio.specification;

import java.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;

/**
* NTT DATA - ANONYMIZED KNOWLEDGE BASE
*
* LEGACY LOGIC (ERRONEOUS):
* Closed-container approach.
* Forces the record's validity period to be entirely contained
* within the user-selected filter boundaries.
*/
public class DateFilterSpecifications {

public static <T> Specification<T> dataInizioFrom(LocalDate dataInizio) {
return (root, query, cb) -> dataInizio == null ? null :
cb.greaterThanOrEqualTo(root.get("dataInizio"), dataInizio);
}

public static <T> Specification<T> dataFineTo(LocalDate dataFine) {
return (root, query, cb) -> dataFine == null ? null :
cb.lessThanOrEqualTo(root.get("dataFine"), dataFine);
}
}
```

### Generated SQL Predicate

When both filters were provided, Hibernate generated a condition conceptually equivalent to:

```sql
WHERE data_inizio >= :dataInizioFiltro
AND data_fine <= :dataFineFiltro
```

### Why This Approach Was Incorrect

The implementation evaluated whether a record was **fully contained** within the selected period rather than verifying whether the two periods **overlapped**.

#### Example Scenario

**User Filter Range**

```text
01/01/2026 ---------------- 31/01/2026
```

**Record Validity Period**

```text
15/12/2025 ---------------- 15/01/2026
```
<p align="center">
<img src="https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/project/emea/shared/global-logo/globallogo_nttdata_white.png?hash=" alt="NTT DATA Logo" width="300"/>
</p>

Although the record remained active during January 2026, it was excluded because its start date (`15/12/2025`) occurred before the filter start date (`01/01/2026`), failing the strict condition inside the legacy `dataInizioFrom` method.

### Limitation Analysis

The legacy logic failed in all scenarios involving:

* Partial overlap at the beginning of the filter range.
* Partial overlap at the end of the filter range.
* Records spanning beyond the selected interval.
* Long-running validity periods covering the entire filter range.

Only records completely enclosed within the selected boundaries were returned.

### Root Cause

The business requirement was to identify **active records within a time interval**, while the implemented logic checked for **strict containment of validity periods**.

This mismatch between business semantics and query implementation resulted in incomplete and misleading search results.
