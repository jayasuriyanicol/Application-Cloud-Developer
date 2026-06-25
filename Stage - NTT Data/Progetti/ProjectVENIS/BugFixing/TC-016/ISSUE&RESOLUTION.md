# Solution: Period Overlapping Logic

To resolve the issue, the filtering logic was refactored to evaluate the **intersection of time periods** rather than relying on strict containment criteria.

A record is now considered **active and valid** within a given filter range whenever its validity period overlaps the user's requested period by **at least one day**.

## Boundary Logic Explained

### Filter Start Date (`dataInizio`)

The start date behaves as an **open-ended window looking toward the future**. It allows records that began in the past to remain visible, provided that their validity period has not yet ended.

**Condition:**

```sql
data_fine >= :dataInizioFiltro
```

This ensures that any record still active on or after the filter start date is included in the result set.

### Filter End Date (`dataFine`)

The end date acts as a **closed boundary**. It prevents the search from extending beyond the maximum allowed date and excludes any record whose validity starts after the selected range.

**Condition:**

```sql
data_inizio <= :dataFineFiltro
```

This guarantees that only records whose validity begins before or on the filter end date are considered.

---

## Validation Tests 

After implementing the fix using **Spring Data Specifications**, Hibernate generated the expected dynamic query:

```sql
WHERE gi1_0.data_fine >= ?
  AND gi1_0.data_inizio <= ?
```

The solution was validated using a test record with the following validity period:

| Record Start Date | Record End Date |
| ----------------- | --------------- |
| 01/01/2026        | 31/01/2026      |


### Result on the FE

![Blocco Inline Warning](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/GraduatoriaFilterByDate.png?raw=true)


### Test Results

| Filter Range            | Expected Result  | Actual Result    | Status   | Notes                                    |
| ----------------------- | ---------------- | ---------------- | -------- | ---------------------------------------- |
| 10/01/2026 - 19/01/2026 | Record Displayed | Record Displayed | ✅ PASSED | Intermediate dates correctly included    |
| 01/01/2026 - 31/01/2026 | Record Displayed | Record Displayed | ✅ PASSED | Boundary dates correctly included        |
| 01/02/2026 - 28/02/2026 | Empty List       | Empty List       | ✅ PASSED | Record correctly excluded (out of range) |
| 12/01/2025 - 30/01/2026 | Record Displayed | Record Displayed | ✅ PASSED | Partial overlap correctly detected       |
| 01/01/2003 - 12/06/2026 | Record Displayed | Record Displayed | ✅ PASSED | Full overlap correctly detected          |

## ✅ Outcome

The implementation now correctly handles all overlap scenarios, including:

* Full containment
* Partial overlap at the beginning of the range
* Partial overlap at the end of the range
* Exact boundary matches
* Complete exclusion of non-overlapping periods

This approach ensures consistent and predictable filtering behavior for all date-range queries while maintaining compatibility with Spring Data Specifications and Hibernate-generated SQL.
