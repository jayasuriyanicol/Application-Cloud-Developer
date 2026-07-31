# Angular – School Calendar Rules & Detail Integration Refinement

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

## Feature Description (Rules & Detail Integration Refinement)

The goal of this task is to enforce strict type safety, optimize Angular change detection, and secure the component lifecycle within the **School Calendar Detail** and **Rules Table** views.

Through proactive frontend validations, immutable state management, and double-submit guards, this update fortifies the UI Shell against invalid inputs, unpredictable mutation side-effects, and concurrent API requests.

```text
Route Param Validation ──> Guard Checks (isSaving/isReadOnly) ──> Immutable Array Updates ──> Secure API Payload Emission

```

### Business Rules & Constraints

* **Route Sanitization:** Calendar IDs extracted from routing parameters must be strictly evaluated as positive integers. Fractional (e.g., '1.5') or invalid string IDs must be rejected before triggering backend network calls.

* **Double-Submit Prevention:** Operations that mutate data (Header or Pattern saves) must be guarded against multiple consecutive clicks using explicit `isSaving` and `isReadOnly` state evaluations.

* **UX Consistency:** All functional and routing errors must display a standardized message containing explicit retry guidance ("Riprova") to ensure a uniform user experience.

---

## Initial Architectural Gaps (Why the Refinement Was Needed)

Prior to these updates, the integration exhibited vulnerabilities regarding type strictness, UI rendering, and request handling:

1. **TYPE-UNSAFE CASTING:** `CalendarRulesTableComponent` utilized force-casting (`as SchoolCalendarRuleDTO`) to bypass TypeScript compiler checks, masking potentially missing fields or incompatible object shapes.

2. **MUTATION SIDE-EFFECTS:** The rules array was being modified in place (e.g., via `push()` or `splice()`). This violates Angular's reactive data-flow principles, causing change detection mechanisms to fail to re-render the rules table correctly.

3. **UNGUARDED ROUTES & FORMS:** `SchoolCalendarDetailComponent` did not sanitize its URL parameters (allowing decimal or malformed IDs) and lacked debounce or locking mechanisms on save buttons, leading to potential duplicate network requests.

---

## Structural Root Cause Analysis

A deeper code review highlighted that state management and parameter parsing needed to be explicitly typed and strictly guarded:

1. **CHANGE DETECTION FAILURES:** Angular's default change detection relies on object reference changes. Mutating an array in-place keeps the same reference, meaning the DOM fails to reflect the newly added or deleted rules.
2. **API OVERHEAD:** Attempting to fetch a calendar with an ID of `'1.5'` or `'abc'` resulted in unnecessary HTTP 400 errors from the backend. This validation should logically occur at the frontend routing layer.

---

## Technologies Used

* Angular (Component Lifecycle, Change Detection Strategies)
* TypeScript (Strict Typing, Immutability via Spread Syntax)
* Vitest (Unit Testing Suite)

---

## Conclusion & Next Steps

This task completes the architectural refinement of the School Calendar integration. By eliminating type coercion, enforcing Angular immutability standards, and layering protective component guards, the frontend effectively shields the Backoffice APIs from malformed data and redundant processing.

**Current Status:** **TASK COMPLETED**. The codebase is currently pending test branch approval, anticipating formal MERGE into the `sviluppo` (development) branch.