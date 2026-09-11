
# Angular – School Calendar Detail Page & Architecture Refactoring (UX/IX to BE Integration)

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

## Feature Description (Dettaglio Calendario Scolastico Refactoring)

The goal of this task is to refactor the **Dettaglio Calendario Scolastico** page on the Frontend, moving its implementation logic and data binding completely from static UX/IX specifications to dynamic Backend-driven (BE) endpoints.

Through this update, we streamlined the Angular architecture, eliminated redundant intermediate component states, cleaned up unused styling, and removed obsolete action buttons (e.g., "Elimina Bozza"), ensuring a clean separation of concerns and a seamless user experience.

```text
UX/IX Legacy Mocks ──> FE Refactoring & UI Cleanup ──> BE-Driven Data Binding ──> Clean Production-Ready UI

```

### Business Rules & Constraints

* **Architecture Alignment:** Shift the core rendering of the *Dettaglio Calendario Scolastico* page from frontend-heavy static mocks/UX layers directly to dynamic backend data models via REST services.
* **Codebase & Commit History Cleanup:** Surgical elimination of redundant intermediate development branches and commit noise, enforcing a clean, linear history (maintaining strictly the final operational commits on the existing Merge Request).
* **UI Streamlining:** Removal of obsolete UI actions and cleanup of redundant elements (such as deprecated action buttons and unused styles in the Weekly Pattern Editor) across the calendar detail view.

---

## Initial Architectural Gaps (Why the Refinement Was Needed)

Prior to these updates, the implementation presented several structural bottlenecks:

1. **MIXED RESPONSIBILITIES:** The calendar detail page relied partially on experimental UX/IX layer logic rather than consuming standardized backend contracts uniformly.
2. **COMMIT BLOOM & BRANCH NOISE:** The feature branch accumulated multiple intermediate and redundant commits due to iterative exploratory work, compromising the review process for code merging.
3. **REDUNDANT UI CONTROLS:** Outdated action buttons (like legacy drafts) and unoptimized styles remained present in the UI layout, causing potential user confusion and code bloat.

---

## Structural Root Cause Analysis

A deeper analysis highlighted structural vulnerabilities requiring systematic refactoring:

1. **ARCHITECTURAL MISALIGNMENT:** Keeping view-rendering logic tied to legacy UX/IX patterns instead of strict BE mapping resulted in mapping discrepancies.
2. **GIT HISTORY DEGRADATION:** Unmerged intermediate test commits obstructed code reviews, requiring a strict history rewrite via targeted resets and force-syncing to keep the active Merge Request clean.

---

## Technologies Used

* **Frontend:** Angular, TypeScript, RxJS, Bootstrap 5 / Custom SCSS
* **Version Control:** Git, GitLab (Merge Request History Optimization)

---
