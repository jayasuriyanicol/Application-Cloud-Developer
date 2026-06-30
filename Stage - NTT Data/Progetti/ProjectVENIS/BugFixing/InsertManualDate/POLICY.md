# Angular Material & Day.js – Strict Date Parsing & Manual Entry Bug Fix

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

## Problem Description (Bug Report: TC-017)

A regression defect was identified in the custom date utility component used across the application's forms (e.g., contract creation wizards and calendar configurations).

When users attempted to manually input dates inside the datepicker fields, the utility exhibited two critical edge-casbe failures:

1. **Locale Manipulation Defect:** The component inadvertently converted manually typed slashes (`/`) causing date formatting to flip inconsistently between Italian (`DD/MM/YYYY`) and English (`MM/DD/YYYY`) standards.

2. **Lazy Insertion Ambiguity:** When typing string numerals without separators (e.g., `3062026`), the system failed to correctly parse end-of-month dates, misinterpreting the token sequence.

3. **Strict Formatting Rejection:** Manually inserting dates with valid slashes but without leading zeros (e.g., `3/11/2026`) triggered an application validation lock, forcing the control to return an invalid state (`null`).

### Impact

* Form fields unexpectedly mutated entered values (e.g., converting June 5th into May 6th).
* Input inputs for lazy-entered text led to erroneous chronological representations.
* Strict validation structures rejected readable user inputs, disabling wizard submission flows.
* The processing behavior disrupted the expected user experience for quick numeric form completion.

---

## ❌ Initial Erroneous Logic (Strict Token Incompatibility)

The original utility stripped non-numeric strings and relied on rigid index splitting or straight-to-adapter passing via Day.js initialized in a strict operational mode:

```typescript
const dataNormalizzata = dayjs(cleanValue, formatiDateAccettate, true);

```

While the strict configuration parameter (`true`) was necessary to prevent native Day.js calendar overflowing (e.g., rolling February 30th into March 2nd), it generated an rigid constraint when facing unstructured manual entry.

### Conceptual Representation

```text
User Manual Token Input
|--- 3 ---| / |--- 11 ---| / |------ 2026 ------|  (Length mismatch for DD)

Day.js Strict Requirement Map
|--- DD --| / |--- MM ---| / |------ YYYY ------|  (Expects: 03/11/2026)

```

Under this constraint, if an input did not match the strict positional token length:

* `3/11/2026` failed validation because `3` lacks the matching padding zero required by `DD`.
* `3062026` (7 digits) evaluated a positional flag checking for zero at the second character position, causing a complete parsing collision between a single-digit day (`3 / 06 / 2026`) and a double-digit day (`30 / 6 / 2026`).

---

## Root Cause Analysis

The implementation lacked an intermediate processing layer capable of homogenizing heterogeneous keyboard inputs before handing them to the immutable parsing lifecycle of Day.js.

The utility evaluated data strings purely against static format schemas. It failed to account for mathematical token ambiguities when strings varied between 5 and 7 characters, and omitted structural zero-padding operations when manual slashes were typed by the operator.

---

## Expected Behavior

The validation utility must standardize any user input into a fully qualified Italian string layout (`DD/MM/YYYY`) dynamically before execution.

The transformation requirements can be summarized as:

* **Literal Stability:** `05/06/2026` must remain immutable as `05/06/2026`.
* **Zero-Padding Insertion:** Unpadded structures like `3/11/2026` must automatically prepend zeros to isolate individual date components as `03/11/2026`.
* **Business-Precedence Resolution:** Numeric-only patterns representing dual possibilities must dynamically favor real-world expiration scenarios (e.g., prioritizing Day `30` over Day `03` if followed by a logical layout).

---

## Resolution Overview

The system architecture was refactored by centralizing temporal formatting behaviors directly into a standardized parsing function and optimizing its distribution across the UI components ecosystem via a unified custom provider layer.

The core parsing routine was reconfigured to separate strings into two distinct operational flows: numeric-only sequences grouped by precise text lengths, and manually delimited inputs sanitized via component-wise slicing arrays. This approach guarantees that Day.js continually processes optimal strings while retaining its protective strict boundaries.

---

## Technologies

* TypeScript
* Angular Material
* Day.js (Advanced Parsing & Custom Token Adapters)
* RxJS Reactive Forms
* Git & Version Control Operations

