
# Java DTO Weekly pattern & SchoolCalendarShell Weekly Pattern

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

## Feature Description (UI Integration Calendar SHELL)

The goal of this feature is to deliver an end-to-end Weekly pattern for the  **School Calendar Shell**. In order to show the Weekly pattern in FE to change dinamically the days.

Through the Backoffice interface, administrators can create manage directly this situation changing it in a very simple way.

```text
Angular UI Shell ──> GateService (Bearer Token) ──> Gateway / API ──> SchoolCalendarBackOfficeResource ──> RxJS Map Wrapper ──> UI Render

```
---
## Business & Rules
---
### Frontend (FE)

* **Modular Isolation:** Keep the weekly pattern management isolated within the dedicated `weekly-pattern-editor.component`.

* **Clean Standalone Imports:** Keep `SchoolCalendarDetailComponent` lean by removing redundant modules (`FormsModule`, `ReactiveFormsModule`) and importing only the necessary child components (`SchoolCalendarHeaderFormComponent`, `WeeklyPatternEditorComponent`).

* **RxJS Data Normalization:** Every backend API call must normalize the incoming response using the `map` operator, ensuring raw DTOs are wrapped into the standard `ServiceResponse<T>` structure.

* **Gateway Routing:** All REST calls for calendar details must route through `GateService`, utilizing the base URL configured in the environment files to prevent authentication failures.
---

### Backend (BE)

* **Data Consistency & Flush Policy:** To update weekly patterns and avoid primary key/uniqueness constraint violations (`DataIntegrityViolationException`), old associated records must be explicitly deleted and flushed before inserting the new data.
* **Transaction Boundary:** Deletion via `deleteByCalendarId` and subsequent day regeneration must occur within the same transactional context, triggering an explicit `flush()` on the `EntityManager`.

---