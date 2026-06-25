
# Angular & Java Spring Data JPA – Dynamic Attribute Filtering Bug Fix (EAV Model)

<p align="center">
  <img src="https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/project/emea/shared/global-logo/globallogo_nttdata_white.png?hash=" alt="NTT DATA Logo" width="300"/>
</p>


---

## ⚠️ Corporate Disclaimer & Privacy Policy

> **PROPERTY OF NTT DATA Italia - Gov&Tech**
> This repository is strictly **private** and intended exclusively for internal knowledge sharing, technical documentation, and personal educational tracking.

> All code snippets and examples contained herein have been deliberately **anonymized, de-contextualized, and sanitized** to remove any proprietary business logic, domain-specific entities, package structures, client references, or sensitive implementation details.

> No confidential information, production credentials, customer data, intellectual property, or security-sensitive content belonging to NTT DATA or its clients is disclosed in this repository.

> The content is published in full compliance with applicable corporate security standards, confidentiality agreements, GDPR requirements, and internal data protection policies.

---

## Problem Description (FEATURE filter 'Solo Centro Estivo')

A defect was identified in the advanced filtering panel within the teacher listing and availability views.

When users activated the *"Solo Centro Estivo"* (Summer Camp Only) checkbox filter on the Frontend, the application continued to return the complete set of records, completely ignoring the selection.

As a consequence, teachers without the specific active attribute were incorrectly included in the result set, making it impossible to isolate targeted professional profiles.

### Impact

* UI checkbox state changes had no effect on the retrieved dataset.
* The backend search logic bypassed the dynamic custom flag.
* The filtering behavior failed to align with the enterprise business requirements for dynamic profile categorization.

---

## ❌ Initial Erroneous Logic (Ghost-Filter Approach)

The original implementation lacked parameter binding and mapping conditions within the custom query's `WHERE` clause.

Although the Frontend TypeScript bridge layer was correctly capturing the UI interaction and forwarding the updated request payload (`soloCentroEstivo: true`), the backend repository layer lacked the proper clause to intercept it. This caused a compilation failure during local alignment due to a mismatched argument length and syntax artifacts (`F` token orphaning).

### Conceptual Representation

```text
Frontend UI Event (Toggle Active) ──> TS Bridge (State Captured: true)
                                              │
                                              ▼
Database Output <── Repository Query (Parameter Ignored / Absent in WHERE)

```

Under this logic, a record was returned regardless of the filter state because the custom attribute definition was never queried, acting as an invisible "ghost filter" that allowed all data rows to pass unfiltered.

---

## Root Cause Analysis

The implementation issue stemmed from three distinct layers of the application stack:

1. **Repository Parameter Mismatch:** The data layer interface method signatures were desynchronized with the service calling layer, requesting a different number of parameters and including syntax syntax refusals.

2. **Missing Query Predicate:** The monolithic `@Query` definition (both `value` and `countQuery`) entirely lacked the logical verification block for the `:soloCentroEstivo` variable.

3. **Dynamic EAV Architecture:** The target property was not a static table column but a dynamic key-value row inside an Entity-Attribute-Value (EAV) relationship grid. The query did not implement a conditional subquery to inspect this dynamic map.

This lack of structural intersection between the interface methods and the JPQL/HQL query logic led to a total filtering failure.

---

## Expected Behavior

A record should be filtered dynamically based on the checkbox status:

* If `soloCentroEstivo` is `false`, the system must skip the filter and display all valid records.

* If `soloCentroEstivo` is `true`, the system must restrict the result set to include **only** records having an entry in the dynamic attribute value table matching the specific configuration code (`DISPONIBILITA_CENTRO_ESTIVO`) with a value of `'SI'`.

---

## ✅ Resolution Overview

The filtering framework was refactored end-to-end across the stack:

1. **Frontend Synchronization:** Maintained the TypeScript component bridge logic to channel the checkbox payload state down to the API service.

2. **Method Signature Refactoring:** Aligned argument lists to 14 parameters across both `DisponibilitaDocentiService.java` and `GraduatoriaRepository.java`, fixing syntax anomalies.

3. **EAV Subquery Integration:** Embedded an `exists` subquery in both the primary data query and the pagination count query to properly intercept the dynamic table values.

This solution completely aligns the frontend state changes with dynamic backend SQL execution, matching the business behavior required for profile evaluation.

---

## Technologies

* Angular (TypeScript)
* Java
* Spring Boot
* Spring Data JPA
* Hibernate ORM
* JPQL / HQL
* PostgreSQL / SQL (EAV Architecture)

---

## Conclusion

The issue was successfully resolved by introducing an isolation strategy via subqueries for the dynamic dynamic attribute mapping layer.

The new implementation provides:

* Instant user-driven table filtering.
* Seamless Frontend-to-Backend data bridge.
* Accurate integration of the EAV data model with paginated Spring Data queries.

This represents a clean and standard approach to handling dynamic user attributes inside structural relational enterprise architectures.

