# Java Spring Data JPA – Date Range Overlapping Bug Fix

<p align="center">
  <img src="./assets/nttdata-logo.png" alt="NTT DATA Logo" width="300"/>
</p>

---

## ⚠️ Corporate Disclaimer & Privacy Policy

> **PROPERTY OF NTT DATA Italia - Gov&Tech**
>
> This repository is strictly **private** and intended exclusively for internal knowledge sharing, technical documentation, and personal educational tracking.
>
> All code snippets and examples contained herein have been deliberately **anonymized, de-contextualized, and sanitized** to remove any proprietary business logic, domain-specific entities, package structures, client references, or sensitive implementation details.
>
> No confidential information, production credentials, customer data, intellectual property, or security-sensitive content belonging to NTT DATA or its clients is disclosed in this repository.
>
> The content is published in full compliance with applicable corporate security standards, confidentiality agreements, GDPR requirements, and internal data protection policies.

---

## 📌 Problem Description (Bug Report: TC-016)

A defect was identified in the date-range filtering functionality used within the search and listing views.

When users specified a validity period through the `dataInizio` (start date) and `dataFine` (end date) filters, the application failed to return records whose validity period only partially overlapped the selected range.

As a consequence, valid records active during the requested interval were incorrectly excluded from the result set.

### Impact

* Records with overlapping validity periods were not displayed.
* Search results appeared incomplete and inconsistent.
* Users could not reliably retrieve active records within a specified date range.
* The filtering behavior did not align with the expected business requirements for temporal validity management.

---

## ❌ Initial Erroneous Logic (Closed-Container Approach)

The original implementation generated the following SQL predicate:

```sql
WHERE data_inizio >= :dataInizioFiltro
  AND data_fine <= :dataFineFiltro
```

This approach treated the user's filter range as a **strict container**, requiring the entire validity period of a record to be completely enclosed within the selected boundaries.

### Conceptual Representation

```text
Filter Range
|-------------------------|

Record Validity
      |-------------------------|
```

Under this logic, a record was returned only if:

* The record started on or after the filter start date.
* The record ended on or before the filter end date.

Any record that:

* Started before the filter range but remained active during it, or
* Ended after the filter range while still overlapping it,

was incorrectly excluded.

### Example

#### Filter Range

```text
01/01/2026 ---------------- 31/01/2026
```

#### Record Validity

```text
15/12/2025 ---------------- 15/01/2026
```

Although the record was clearly active during January 2026, it was discarded because its start date preceded the selected range.

---

## 🔍 Root Cause Analysis

The implementation incorrectly evaluated **full containment** rather than **period overlap**.

From a temporal logic perspective, the requirement was not to determine whether a record's validity period was entirely contained within the filter range, but rather whether the two periods intersected at any point in time.

This mismatch between business requirements and query implementation led to the exclusion of legitimate results.

---

## 🎯 Expected Behavior

A record should be considered valid whenever its validity period overlaps the user's requested interval by at least one day.

The overlap condition can be expressed as:

```text
Record End Date   >= Filter Start Date
AND
Record Start Date <= Filter End Date
```

This rule correctly identifies all overlapping scenarios, including:

* Complete containment
* Partial overlap at the beginning
* Partial overlap at the end
* Exact boundary matches
* Full coverage of the selected range

---

## ✅ Resolution Overview

The filtering logic was redesigned using Spring Data JPA Specifications to evaluate temporal intersections instead of strict containment.

The resulting query now accurately detects overlapping periods and ensures that all valid records are returned whenever their validity interval intersects the selected filter range.

This solution aligns the implementation with the intended business behavior while maintaining compatibility with Hibernate-generated dynamic SQL and enterprise-grade filtering requirements.

---

## 📚 Technologies

* Java
* Spring Boot
* Spring Data JPA
* Hibernate ORM
* JPA Specifications
* SQL

---

## 🏁 Conclusion

The issue was successfully resolved by replacing the restrictive containment-based filter with a robust period-overlap strategy.

The new implementation provides:

* Accurate temporal filtering
* Consistent user experience
* Improved reliability of search results
* Correct handling of all date-range intersection scenarios

This approach represents a standard and scalable solution for validity-period management in enterprise Java applications.
