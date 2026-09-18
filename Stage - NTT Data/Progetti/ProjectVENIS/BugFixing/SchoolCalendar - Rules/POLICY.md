# Java Spring Boot | Angular – Fullstack Duplicate Rule Validation (School Calendar)

<p align="center">
  <img src="https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/project/emea/shared/global-logo/globallogo_nttdata_white.png?hash=" alt="NTT DATA Logo" width="300"/>
</p>


## ⚠️ Corporate Disclaimer & Privacy Policy

> **PROPERTY OF NTT DATA Italia - Gov&Tech**
> This repository is strictly **private** and intended exclusively for internal knowledge sharing, technical documentation, and personal educational tracking.
> All code snippets and examples contained herein have been deliberately **anonymized, de-contextualized, and sanitized** to remove any proprietary business logic, domain-specific entities, package structures, client references, or sensitive implementation details.
> No confidential information, production credentials, customer data, intellectual property, or security-sensitive content belonging to NTT DATA or its clients is disclosed in this repository.
> The content is published in full compliance with applicable corporate security standards, confidentiality agreements, GDPR requirements, and internal data protection policies.

---

## Problem Description (Refactor Report: PR-043)

A code review and testing phase identified severe data consistency vulnerabilities and UX/UI issues within the School Calendar Rules configuration module.

When users configured exceptions for the calendar (e.g., holidays, non-working intervals, working overrides), the system lacked adequate validation against exact duplicates. This allowed the insertion of multiple identical rules, leading to backend generation conflicts. Furthermore, the frontend utilized fragile manual date parsing and unsafe inline CSS that violated the project's coding standards and triggered Angular sanitization warnings.

### Impact

* **Data Corruption Risk:** Inserting rules with identical dates, ranges, or `sortOrder` values corrupted the calendar generation engine's chronological hierarchy.
* **Unnecessary Server Load:** Without client-side pre-validation, invalid duplicate payloads were sent directly to the server, unnecessarily consuming backend resources.
* **Architectural Disalignment:** Date formatting relied on manual string manipulation (`split('-')`) instead of the project's globally configured `dayjs` library.
* **UI Style Leakage & XSS Risks:** Highlighting warning text was attempted via raw HTML binding and inline `!important` styles, breaking Angular View Encapsulation and prompting security sanitization blocks.

---

## ❌ Initial Erroneous Logic (Manual Parsing & Inline Styling)

The original implementation formatted dates manually and attempted to force UI styling using hardcoded CSS overrides directly inside the component's HTML template:

```typescript
// Inefficient and fragile manual date parsing
private formatDate(dateString: string): string {
  if (!dateString) return '';
  const parts = dateString.split('-');
  return parts.length === 3 ? `${parts[2]}/${parts[1]}/${parts[0]}` : dateString;
}

```

```html
<!-- Unsafe inline styling violating Best Practices -->
<span class="fw-bold" style="font-weight: 700 !important;">{{ warningText }}</span>

```

This approach bypassed the centralized formatting engine, making the component fragile to date standard changes, while the inline `!important` rule violated strict CSS encapsulation protocols.

---

## Root Cause Analysis

The implementation initially lacked a cohesive fullstack validation strategy.
From an enterprise architecture perspective, data integrity should be guarded at the domain level (Backend), but UX demands immediate, pre-flight interception at the client level (Frontend). Additionally, the frontend warning mechanism attempted to inject raw HTML strings into the DOM, which Angular correctly intercepted and sanitized, stripping away the intended bold formatting.

---

## Expected Behavior

1. **Backend Domain Guards:** The system must evaluate calendar rules via `HashSet` to block identical `sortOrder`, exact identical single dates, and identical ranges, while logically permitting nested/overlapping rules (e.g., a specific holiday falling inside a wider closing range).
2. **Frontend Pre-Validation:** The Angular component must intercept these duplicates locally before any API call is dispatched, alerting the user immediately.
3. **Standardized Date Handling:** All date parsing must be delegated to the `dayjs` library.
4. **XSS-Safe Styling:** Warning highlights must be structured as object properties (`prefix`, `highlight`, `suffix`) to leverage native Angular interpolation and standard Bootstrap CSS classes (`fw-bold`) without inline style attributes.

---

## Resolution Overview

The backend was fortified with a `SchoolCalendarRuleValidator` utilizing O(1) `HashSet` lookups to instantly detect exact collisions during the save transaction.

On the frontend, a highly optimized `checkRuleAgainstLocalList` method was developed. Instead of returning raw HTML strings, it returns a structured interface:

```typescript
// Structured warning payload avoiding XSS sanitization
{ 
  prefix: "ATTENZIONE ! L'ordinamento '", 
  highlight: `${newRule.ruleOrder}`, 
  middle: `' è già utilizzato dalla regola: "`,
  highlight2: `${existing.reason}`,
  suffix: `".` 
}

```

Dates are now parsed cleanly using `dayjs(newRule.startDate).format('DD/MM/YYYY')`. Finally, the HTML template dynamically binds these properties to safe `<span>` elements using pure `.fw-bold` CSS classes, entirely eliminating `!important` tags.

---

## Technologies

* Java 17
* Spring Boot
* Angular (Standalone Components)
* TypeScript
* Vitest (Frontend Unit Testing)
* Day.js
* Bootstrap / CSS3

---

## Conclusion

The School Calendar Rule configuration was successfully refactored into a highly robust, fullstack validated module.

The finalized refactoring ensures:

* **Zero Data Duplication:** Exact collisions are blocked instantly both on client and server sides.
* **Strict Style Encapsulation:** Warning alerts are styled cleanly using native framework directives with zero DOM pollution.
* **Standardized Formatting:** `dayjs` fully handles internationalization and string mapping.
* **100% Test Coverage:** The frontend validation logic is completely locked down via comprehensive Vitest `.spec.ts` assertions.

---
