
# Angular & Java Spring Data JPA – Codice Graduatoria Uniqueness Validation Feature

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


## Problem Description (FEATURE 'Codice Graduatoria Uniqueness Validation')

A new requirement was identified to prevent the creation of duplicate ranking systems (*graduatorie*) by enforcing a strict uniqueness validation on the *Codice Graduatoria* input field during the creation wizard stage.

Previously, the application lacked an end-to-end mechanism to validate whether an inserted code was already assigned to an existing record before submitting the final payload. Furthermore, users could accidentally bypass manual uniqueness constraints by simply entering matching codes disguised with different casing or internal/external trailing spaces (e.g., entering `G   0 1` when `G-01` or `G01` was already in the database).


This behavior allowed invalid or redundant ranking data to hit the persistence layer, jeopardizing data integrity.



### Impact

* Duplicate records could accidentally be pushed to the database due to a lack of automated validation.
* Subtle layout variations (such as trailing whitespaces or lowercase variants) bypassed standard duplicate verification checks.
* The system needed an optimized, user-friendly validation flow that would block invalid progress early in the creation wizard without degrading interface performance.

---

## ❌ Initial Erroneous Logic (Absent Validation Architecture)

In the original prototype implementation, the application completely lacked any form of duplicate verification or input checking at the persistence layer.

Users were free to insert any string value into the input field. The system blindly accepted every submission, creating a high risk of redundant entries and data corruption.

### Conceptual Representation

```text
User Input (Every Type of Data) ──> Form Submission (No Check) 
                                           │
                                           ▼
Database Server <── Blind Acceptance ── Legacy Frontend Bridge (No Input Sanitization)

```

Under this legacy behavior:

* **Zero Duplication Protection:** If a ranking code already existed in the system, the application would still allow identical submissions without prompting any warning or validation error.

* **No Input Cleaning:** Raw text strings containing messy spacing and mismatched casing were sent directly to the database, completely bypassing basic data hygiene rules and leading to a fragmented, unstandardized dataset.
Under this legacy logic:

* **HTTP Flooding:** Typing a single 10-character code triggered up to 10 immediate asynchronous HTTP requests to the backend, overloading the network layer.

* **UI Flickering:** The rapid feedback loop caused the form state to toggle erratically, locking or flashing error indicators while the operator was still in the middle of typing.

* **No Input Cleaning:** The frontend passed raw string inputs containing spaces directly to the server, which failed to match existing clean codes stored in the database.

---

## Root Cause Analysis

The overall system optimization issue stemmed from two main flaws across the application stack:

1. **Suboptimal UX Validation Trigger:** The validation architecture relied on an immediate real-time feedback loop (`valueChanges` or instant async form validators) instead of an event-driven, decoupled action boundary.

2. **Database Spacing Vulnerability:** The persistence check performed a literal string equality matching. If a record existed as `TEST-001`, a search query for `test-001` or `TEST  001` returned a false negative, masking the duplicate and bypassing the system rules.


---

## Expected Behavior

The validation mechanism must run smoothly and seamlessly across both layers:

* **Frontend Action Boundary:** The system must remain passive while the operator writes inside the form. The uniqueness check must execute **on-demand** only when the user clicks the "Continua" action button to progress past Step 1.

* **Space & Case Insensitivity:** The validation query must normalize both the user input and the database records dynamically. The system must strip all internal/external spaces and force uppercase matching, identifying duplicates even if typed with trailing spaces or different casing.

* **UI Flow Interception:** If a duplicate is found, the application must immediately halt the wizard, mark the form input as invalid, and notify the user. If the code is completely fresh, it must unlock the stepper navigation and seamlessly transition to Step 2.

---

## ✅ Resolution Overview

The validation architecture was fully refactored across the stack into a clean, event-driven solution:

1. **Sanitized Payload Mapping:** Enhanced `GraduatoriService` to normalize the input parameters using native encoding (`encodeURIComponent`), passing a highly predictable, clean payload to the backend routes.


2. **Database-Level Hardening:** Embedded standard SQL formatting functions (`REPLACE` and `UPPER`) inside the custom `@Query` layer of `GraduatoriaInfoRepository`. This ensures that data evaluation completely strips spaces and forces uppercase matching natively on the server side, preventing any duplicate bypasses.

3. **Concurrent Thread Guarding:** Bound an `isCheckingCodice` loading state to the user interface, instantly disabling action triggers during the REST round-trip to prevent double-click submissions.

---

## Technologies

* Angular (TypeScript)
* Java
* Spring Boot
* Spring Data JPA
* REST APIs
* PostgreSQL / SQL (String Manipulation & Data Normalization)

---

## Conclusion

The issue was successfully resolved by decoupling the validation triggers and migrating from a continuous reactive checking model to a streamlined, on-demand action strategy.

The new implementation provides:

* Optimal layout performance with zero HTTP request flooding.
* Total space and case insensitivity, guaranteeing absolute data integrity.
* A robust UX flow that blocks invalid data on-demand while preventing submission race-conditions.

This approach demonstrates a highly effective pattern for handling strict record uniqueness rules within multi-step enterprise entry wizards.