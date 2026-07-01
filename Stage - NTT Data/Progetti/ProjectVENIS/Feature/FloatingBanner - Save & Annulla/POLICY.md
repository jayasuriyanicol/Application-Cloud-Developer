# Angular & Java Spring – Teacher Management Global Actions & Dynamic EAV Filtering


<p align="center">
  <img src="https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/project/emea/shared/global-logo/globallogo_nttdata_white.png?hash=" alt="NTT DATA Logo" width="300"/>
</p>

---

## ⚠️ Corporate Disclaimer & Privacy Policy

> **PROPERTY OF NTT DATA Italia - Gov&Tech** > This repository is strictly **private** and intended exclusively for internal knowledge sharing, technical documentation, and personal educational tracking.

> All code snippets and examples contained herein have been deliberately **anonymized, de-contextualized, and sanitized** to remove any proprietary business logic, domain-specific entities, package structures, client references, or sensitive implementation details.

> No confidential information, production credentials, customer data, intellectual property, or security-sensitive content belonging to NTT DATA or its clients is disclosed in this repository.

> The content is published in full compliance with applicable corporate security standards, confidentiality agreements, GDPR requirements, and internal data protection policies.

---

## Problem Description (FEATURE: Global Save/Cancel Banner & EAV Filtering)

During the refactoring of the **Teacher Management** module, two major critical issues were identified that compromised both user experience and data consistency:

1. **Absence of a Global Modification State:** When the administrative operator modified teacher records or activated advanced filtering suites, the application lacked a centralized control layout to mass-commit or roll back operations, leaving the presentation layer in an unstable state.
2. **Ghost-Filter on Summer Camp Availability:** Activating the *"Solo Centro Estivo"* (Summer Camp Only) checkbox filter on the Frontend properly captured the UI state (`true`/`false`), but the Backend repository completely ignored the parameter. Teachers without this specific attribute were incorrectly included in the data stream, as the property resides inside a dynamic Entity-Attribute-Value (EAV) mapping grid that wasn't being evaluated by the legacy query.

### Impact

* Lack of a unified interaction layer ("Save changes" / "Cancel") to safeguard or restore the global page state scope.
* UI state changes on the custom checkbox filter had no filtering effect on the actual dataset returned by the database.

---

## ❌ Initial Erroneous Logic (Ghost-Filter & Missing Global Scope)

In the legacy approach, the underlying repository query for the teacher ranking and availability records lacked the parameter binding logic within its `WHERE` clause. Even though the TypeScript bridge chaneled the updated payload, the database layer omitted the variable. Furthermore, the layout completely lacked a sticky graphical element to manage the lifecycle of ongoing multi-row updates.

### Conceptual Representation

```text
User Event (Edit/Filter) ──> TS Component Bridge (State Captured)
                                      │
                                      ▼
[No Global Action Banner] ──> Repository Query (Parameter Absent in WHERE)
                                      │
                                      ▼
Database Output (Dynamic EAV Attributes Ignored -> Complete Dataset Returned)

```

---

## Root Cause Analysis

The architecture defect stemmed from a misalignment between the frontend view state management and the backend relational database structure:

1. **Missing Global Layout Container:** The user interface did not centralize submission vectors, making persistence actions scattered, fragmentary, and entirely disconnected from the page lifecycle.
2. **Method Signature Desynchronization:** The method argument signatures between `DisponibilitaDocentiService.java` and `GraduatoriaRepository.java` were mismatched, causing argument length errors.
3. **Dynamic EAV Architecture Isolation:** The *Summer Camp Availability* property is not a static column on the main `Insegnante` table, but a dynamic key-value row inside the `InsegnanteAttributoValore` mapping table. The original query failed to implement the conditional subquery needed to inspect this dynamic table array.

---

## Expected Behavior

* **Global Action Scope (Floating Banner):** Any edit or advanced filtering operation within the Teacher Management section must trigger a persistent, floating action banner anchored at the bottom of the viewport. This banner hosts the global **"Save changes"** and **"Cancel"** actions. Clicking "Cancel" must roll back all temporary UI adjustments and refresh to initial records, while "Save changes" commits mutations massivel to the DB.
* **Conditional EAV Subquery:** If `soloCentroEstivo` is passed as `false`, the database engine must bypass the filter entirely. If passed as `true`, the dataset must be constrained to include **only** teacher profiles possessing the configuration attribute code `'DISPONIBILITA_CENTRO_ESTIVO'` with an explicit value of `'SI'`.
