# Angular Reactive Forms – Real-Time Business Validation Warning Bug Fix

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

## Problem Description (FEATURE 'Warning Centro Estivo')

A desynchronization defect was identified in the reactive validation flow of the contract wizard (`ContrattoCreateComponent`).

The business requirement states that when a specific contract date triggers an out-of-bounds condition, the system must immediately query the backend and show an inline contextual warning banner (`visualizzaWarningCE = true`). This alert informs the operator that the selected teacher has denied or not expressed availability for the Summer Camp (*Centro Estivo*).

The application failed to trigger this warning dynamically. Furthermore, a legacy codebase update left behind orphaned code artifacts and duplicated listeners, resulting in critical TypeScript compilation errors (`TS2339`) that blocked local development server builds.

### Impact

* UI notification state changes failed to trigger dynamically upon form interactions.
* Mismatched component bindings caused immediate local development compilation failures (`TS2339`).
* Asynchronous value-change streams lacked optimization, causing redundant backend payload dispatches.

---

##  Initial Erroneous Logic (Orphaned Handlers & Stream Duplication)

The original implementation suffered from event handling redundancy. 

The HTML template called event bindings that were missing from the TypeScript class, causing the Angular compiler to halt the build process. Additionally, recursive value-change listeners were attached to the same reactive form control without memory-leak protection, leading to stream collisions and build-time schema errors.

### Conceptual Representation

```text
Form Interaction ──> Reactive Value Changes Event
                          │
                          ▼
              Angular Template Pipeline
                          │
        ┌─────────────────┴─────────────────┐
        ▼                                   ▼
[HTML Linkage Error]               [Duplicated Stream]
Property 'intercetta...'           Unprotected .subscribe()
missing inside component           causes race condition conflicts
        │                                   │
        └─────────────────┬─────────────────┘
                          ▼
            ❌ BUILD COMPILATION FAILURE