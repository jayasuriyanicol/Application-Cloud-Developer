# Angular – Teacher Management Workspace Optimization & Global Floating Action Banner
---



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

## Problem Description (FEATURE: Global Save/Cancel Floating Banner UI)

During the usability testing and structural refactoring of the **Teacher Management** module, a critical layout defect was identified that heavily compromised the administrative user experience and operational workflow speed:

1. **Extreme Vertical Scrolling Penalty:** The layout configuration forced key interactive triggers into separate, far extremes of the page. The "Cancel" button was anchored inside the header component at the absolute top of the page, whereas the "Save changes" button sat underneath long data rows at the absolute bottom floor of the grid container.
2. **Operator Interface Friction:** To commit a quick row modification or roll back a mistaken input edit, operators were forced to execute heavy wheel-scroll loops back and forth across dozens of active records just to reach the required action trigger.

### Impact

* Severe operational delays due to excessive vertical navigation.
* Poor control layout discoverability, leading to accidental uncommitted changes or data entry frustration.
* Lack of a persistent workspace confirmation scope synchronized with the active user viewport.

---

## ❌ Initial Erroneous Logic (Fragmented Layout Scope)

In the legacy setup, the page framework lacked a viewport-aware container layer. Confirmation execution mechanisms were hard-coded onto static, far-flung positions of the DOM tree. The moment data became reactive or modified, the user interface provided zero structural visual guidance within the active scroll view.

### Conceptual Representation

```text
User Event (Edit Row Data) ──> Form Flag Set to Dirty
                                        │
                                        ▼
[No Viewport Monitor] ──> Actions Fragmented Across Layout Extremes
                                        │
                                        ▼
Top Header Viewport <── [Scroll Up for Cancel]  ||  [Scroll Down for Save] ──> Data Grid Floor

```

---

## Root Cause Analysis

The workspace accessibility issue stemmed from a complete isolation of the primary actions from the user's active viewpoint:

1. **Static Dom Anchoring:** Buttons were bound directly to the layout grid elements rather than matching the modern user workflow interface standards.

2. **Fragmented UI Lifecycle:** The "Cancel" and "Save changes" buttons were decoupled and distributed into independent UI zones, destroying the layout cohesion.

3. **Missing Fixed Viewport Container:** The interface layer did not implement a container component capable of listening to state shifts and staying pinned to the browser base view, leaving long tables with infinite-scroll zones structurally broken.

---

## Expected Behavior

* **Global Action Scope (Floating Banner):** Any modification across the teacher data matrix must instantly activate a unified, sticky action bar anchored dynamically at the bottom of the visible viewport (`position: fixed`).

* **Unified Action Center:** This floating control bar must cluster the global **"Save changes"** and **"Cancel"** triggers into a single component strip. It must follow the operator's viewport seamlessly across deep vertical rows, erasing scrolling penalties entirely, and keeping data execution safe, clean, and zero-friction.