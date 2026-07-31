# Java Spring Boot & Angular – School Calendar Rules Table & Detail Integration

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

## Feature Description (Calendar Rules Table & Detail Integration)

The goal of this feature is to finalize the UI Shell integration for managing school calendar exceptions/rules (`NON_WORKING_DAY`, `NON_WORKING_RANGE`, etc.) via `CalendarRulesTableComponent` and seamlessly persist all configuration updates (headers, weekly patterns, and exception rules) through `SchoolCalendarDetailComponent`.

Through the Backoffice detail view, users can configure operational metadata, weekly working patterns, and exception rules. The frontend validates incoming changes and synchronizes them via refactored backend service methods.

```text
User Input (UI Shell) ──> Form/Table Validation ──> buildUpdatePayload Helper ──> GateService PUT ──> REST Backoffice Endpoint ──> JPA Persistence

```

### Business Rules & Constraints

* **DATE Validation:** Every exception rule must satisfy `endDate >= startDate`. Any date range inversion must be caught and blocked on the client side with visual inline feedback.

* **Service Standardization:** All API communications must route through standardized service methods (`getSchoolCalendarById` and `updateSchoolCalendar`), using `buildUpdatePayload` to aggregate nested changes.

* **Read-Only Guards:** Published calendars or read-only states (`isReadOnly`) must disable editing capabilities across all sub-components (Header, Weekly Pattern, and Rules Table).

---

## Initial Architectural Gaps (Why the Rules & Detail Integration Failed)

Prior to this integration, updating calendar details and managing tabular rules presented three critical operational roadblocks:

1. **DEPRECATED API METHODS:** `SchoolCalendarDetailComponent` relied on legacy service signatures (`find` and `update`), which caused runtime and type mismatch issues following the backend refactoring to `getSchoolCalendarById` and `updateSchoolCalendar`.

2. **BROKEN UNIT TESTS & TEMPLATES:** State property mismatches (e.g., missing or misnamed `isLoading` / `isSaving` properties) and incorrect template path references caused failure in automated `.spec.ts` Angular test suites.

3. **UNVALIDATED RULE DATES:** The exception rule input lacked client-side dynamic validation, allowing invalid date ranges (`endDate < startDate`) to be emitted to the payload builder and sent to the backend.

---

## Structural Root Cause Analysis

An inspection of the frontend and service layer revealed structural misalignments across the integration pipeline:

1. **DISCONNECTED DTO MODELS:** Frontend data structures for exception rules lacked rigid typing synchronization with `SchoolCalendarRuleDTO` and `SchoolCalendarDetailResponseDTO`, risking payload drops during updates.
2. **MANUAL PAYLOAD ASSEMBLY:** Assembling update payloads manually in components created inconsistent request bodies, missing critical fields like default working patterns or academic year metadata.
3. **UNHANDLED TEST STATES:** Standalone directive configurations and specs failed to mock dynamic UI flags (`isLoading`, `isSaving`) accurately, breaking component lifecycle tests.

---

## Testing and Verification Strategy

To guarantee stability and zero-regression, comprehensive frontend unit tests and end-to-end integration validations were executed:

* **Frontend Unit Tests (`.spec.ts`):** Validated component instantiation, standalone directive declarations, and state flags (`isLoading`, `isSaving`). All component specs passed at 100%.
* **Validation & UI Tests:** Verified that inline date validation blocks invalid range entries (`endDate < startDate`) and that `buildUpdatePayload` correctly constructs full request bodies for backend persistence.

---

## Technologies Used

* Angular (Standalone Components, Reactive & Driven Forms)
* RxJS (Pipes, Map, Finalize)
* TypeScript
* HTML5 / CSS3 (Mobile-Responsive Design)
* Jasmine / Karma (Unit Testing Suite)

---

## Conclusion

This implementation finalizes the UI Shell integration for the Backoffice School Calendar module. By synchronizing client models with backend DTOs (`SchoolCalendarDetailResponseDTO`, `SchoolCalendarRuleDTO`), centralizing payload construction via `buildUpdatePayload`, and resolving spec property alignments, the calendar detail and rules management workflow is now stable, maintainable, and aligned with enterprise frontend standards.