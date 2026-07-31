# Java Spring Boot & Angular – School Calendar Regeneration (DRAFT Mode)

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

## Feature Description (Calendar Regeneration in DRAFT Mode)

The goal of this feature is to allow the re-calculation and regeneration of all daily records (`CalendarDay` entity instances) associated with an existing **School Calendar** that is currently in `DRAFT` status.

When administrative parameters (such as the base date ranges, weekly working patterns, or exception rules) undergo structural modifications, administrators can trigger the regeneration process via a dedicated UI action. The system recalculates the full academic schedule according to the updated configuration before persisting the new daily records.

```text
User Action (Regenerate) ──> Angular Service ──> REST PUT/POST Endpoint ──> Lifecycle Guard Check ──> DB Delete/Flush & Day Recalculation

```

### Business Rules & Constraints

* **Strict Lifecycle Lock:** Regeneration is exclusively permitted for calendars in `DRAFT` status (`SchoolCalendarStatus.DRAFT`). Any attempt to regenerate a calendar that is `PUBLISHED` must be intercepted and rejected with a `400 Bad Request` or `409 Conflict`.
* **Atomic Daily Clear:** Prior to recreating daily calendar records, all existing day instances associated with the given calendar ID must be explicitly purged to avoid entity constraint violations or stale data.
* **Service Standardization:** API communication must route through the Backoffice endpoint namespace (`/api/supplenti-bo/school-calendars/{id}/regenerate`) using standard `GateService` dynamic token injection.

---

## Initial Architectural Gaps (Why the Regeneration Feature Failed)

Prior to implementing this feature, updating structural calendar parameters resulted in operational bottlenecks and persistence errors:

1. **MISSING DEDICATED ENDPOINT:** The backend lacked a specialized REST resource for handling schedule regeneration explicitly, forcing developers to rely on generic updates that did not trigger day recalculations.
2. **CONSTRAINT VIOLATIONS:** Modifying calendar date ranges or weekly patterns without purging existing calendar day entries led to database duplicate key exceptions (`DataIntegrityViolationException`).
3. **UNGUARDED LIFECYCLE STATES:** The backend lacked a service-level guard to prevent post-publication schedule regenerations, risking unintended mutations on live `PUBLISHED` calendars.

---

## Structural Root Cause Analysis

An analysis of the backend service layer and database lifecycle highlighted two key technical deficiencies:

1. **PERSISTENCE CONTEXT STALENESS:** Hibernate's first-level cache retained previously generated daily entities in memory. Calling `save()` on regenerated days without an explicit `flush()` after deleting old entries triggered primary/foreign key conflict errors.
2. **FRONTEND UI UNBALANCED STATE:** The frontend lacked specialized loading states and action handlers for the regeneration workflow, leading to unhandled errors during asynchronous processing.

---

## Technologies Used

* Java 17 / Spring Boot 3
* Spring Data JPA / Hibernate (`EntityManager` Explicit Flush)
* Angular 17+ (Standalone Components, Reactive State Management)
* RxJS (Pipes, Dynamic Mapping, Finalize)
* GateService Authentication Module (Bearer Token Injection)

---

## Conclusion & Current Status

This task successfully delivers the end-to-end calendar schedule regeneration feature for `DRAFT` calendars. By combining explicit JPA flush operations with lifecycle guards on the backend, alongside typed RxJS pipelines and state-protected components on the frontend, the feature guarantees schedule consistency without compromising database integrity.

