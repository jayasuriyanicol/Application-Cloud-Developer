# Spring Boot & Angular – School Calendar Publication & Read-Only Lifecycle Integration

---

<p align="center">
  <img src="https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/project/emea/shared/global-logo/globallogo_nttdata_white.png?hash=" alt="NTT DATA Logo" width="300"/>
</p>

---

## ⚠️ Corporate Disclaimer & Privacy Policy

> **PROPERTY OF NTT DATA Italia - Gov&Tech**
> This repository/documentation is strictly **private** and intended exclusively for internal knowledge sharing, technical documentation, and personal educational tracking.

> All code snippets, architecture flows, and examples contained herein have been deliberately **anonymized, de-contextualized, and sanitized** to remove any proprietary business logic, sensitive package structures, client references, or credentials.

---

## Feature Description (Publication & Read-Only Lifecycle Integration)

The goal of this task is to enforce a strict publication lifecycle for the **School Calendar Management System**, separating Back-Office operations from Public queries, securing entity state mutations, and updating the Angular UI Shell to respect Read-Only constraints post-publication.

Through robust backend domain guards, REST API separation, and frontend state synchronization, this update prevents illegal state transitions, guarantees single-published-calendar uniqueness per academic year, and secures the application against concurrent edits.

```text
Draft State ──> Days Generation ──> Publish Guard Checks ──> State = PUBLISHED ──> Read-Only UI Shell (Mutations Shielded)

```

### Business Rules & Constraints

* **REST API Separation:** Public interfaces must be isolated under `/api/school-calendars` (read-only endpoints), while Back-Office management endpoints must reside under `/api/supplenti-bo/school-calendars`.

* **State Transition Eligibility:** A calendar can be published via `POST /{id}/publish` **only** if it is currently in `DRAFT` status and contains at least one generated day in its preview payload.

* **Academic Year Uniqueness:** Only **one** calendar can hold the `PUBLISHED` status for a specific academic year. The system must validate uniqueness using domain queries prior to confirming state persistence.
* **Mutation Shielding (Read-Only Enforcement):** Once a calendar transitions to `PUBLISHED`, all mutation operations (`updateDraft`, `updateRules`, `generateDays`) must be rejected with a `CalendarValidationException`.
* **UI State Protection:** The frontend must enforce strict button disabling and view-only forms when `calendar.status !== 'DRAFT'`, shielding mutation triggers before network requests are initiated.

---

## Initial Architectural Gaps (Why the Refinement Was Needed)

Prior to these updates, the application lacked proper lifecycle encapsulation and read-only protections across both application layers:

1. **UNCHECKED MUTATIONS:** The backend allowed rule updates and header edits regardless of the calendar's lifecycle status, risking corruptive overrides on active academic calendars.
2. **ACADEMIC YEAR CONFLICTS:** There was no strict uniqueness check prohibiting multiple published calendars for the same academic year, leading to potential data ambiguity for downstream public services.
3. **API & RESPONSIBILITY OVERLAP:** Public read-only queries were mixed with Back-Office administrative mutations under the same controller namespaces.
4. **UNSYNCHRONIZED UI ACTIONS:** The UI action panel lacked dedicated handlers and guards for the `Pubblica Calendario` (Publish) and `Elimina Bozza` (Delete Draft) lifecycle flows.

---

## Structural Root Cause Analysis

A deeper analysis highlighted structural vulnerabilities requiring systematic refactoring:

1. **LACK OF LIFECYCLE GUARDS:** `SchoolCalendarCommandServiceImpl` lacked an explicit validation pipeline before persisting state changes, trusting incoming requests without verifying pre-conditions (e.g., status check and generated days existence).
2. **DATA PERSISTENCE RISKS:** Allowing updates on non-draft entities compromised historical calendar consistency used by teacher availability and contract management modules.

---

## Technologies Used

* **Backend:** Java 17, Spring Boot, Spring Data JPA, JUnit 5 / AssertJ, Postman (Integration Testing)
* **Frontend:** Angular, RxJS (`finalize`, `map`), Bootstrap 5, TypeScript (Strict Typing, Control Flow `@if` / `@for`)

---
