# Java Spring Data JPA | Angular – Proroga Contratto calculation Preview

<p align="center">
  <img src="https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/project/emea/shared/global-logo/globallogo_nttdata_white.png?hash=" alt="NTT DATA Logo" width="300"/>
</p>

---

## ⚠️ Corporate Disclaimer & Privacy Policy

> **PROPERTY OF NTT DATA Italia - Gov&Tech**
>
> This repository is strictly **private** and intended exclusively for internal knowledge sharing, technical documentation, and personal educational tracking.
>
> All code snippets and examples contained herein have been deliberately **anonymized, de-contextualized, and sanitized** to remove any proprietary business logic, domain-specific entities, package structures, client references, or sensitive implementation details.
>
> No confidential information, production credentials, customer data, intellectual property, or security-sensitive content belonging to NTT DATA or its clients is disclosed in this repository.
>
> The content is published in full compliance with applicable corporate security standards, confidentiality agreements, GDPR requirements, and internal data protection policies.

---
## Problem Description (Refactor Report: PR-042)

A critical code review identified several performance and architectural defects during the implementation of the contract extension feature.

When users attempted to extend a contract beyond the boundaries of the current school year calendar, the system was modified to show a warning dialog instead of throwing a hard blocking error, calculating a preview via a standard fallback pattern. However, the initial implementation introduced severe database performance issues, architectural disalignment and global style leakage in the user interface.

### Impact

* **High JVM Memory Consumption:** The system fetched hundreds of rows into memory to perform application-side filtering instead of leveraging database indexes.
* **Architectural Disalignment:** Two distinct domain services implemented conflicting lookup logics, creating risks of selecting unplublished (`DRAFT`) calendars.
* **UI Style Leakage:** Global Angular Material overlay styles were altered globally, threatening to break the visual layout of all other modal dialogs across the application.

---

## ❌ Initial Erroneous Logic (In-Memory Processing Approach)

The original implementation fetched the entire collection of school calendars from the database and filtered them in memory using Java Streams:

```java
// Inefficient application-side filtering
List<SchoolCalendar> allCalendars = schoolCalendarRepository.findAll();
return allCalendars.stream()
    .filter(c -> c.getStatus() == SchoolCalendarStatus.PUBLISHED)
    .max(Comparator.comparing(SchoolCalendar::getEndDate))
    .map(pattern -> countWorkingDaysByPattern(from, to, pattern))
    .orElseThrow(() -> new NoPublishedCalendarFoundException(...));

```

This approach treated the database as a raw data dump, forcing the JVM to load every historical and draft calendar record into memory just to extract a single fallback item.

### Conceptual Representation

```text
Database Table (All Records)
[Draft 2024] [Published 2024] [Draft 2025] [Published 2025 (Target)] [Draft 2026]
                      ⬇
Loaded into JVM Memory (findAll())
[Draft 2024], [Published 2024], [Draft 2025], [Published 2025], [Draft 2026]
                      ⬇
Stream Filtering & Sorting (CPU Intensive)
Result -> [Published 2025]

```

Under this logic, the query execution time and memory footprint scaled linearly with the lifecycle of the application. Furthermore, the frontend component forced structural CSS modifications globally via unencapsulated styles targeting `.cdk-overlay-pane`.

### Example

#### Filter Request

```text
Extension Date Range: 01/07/2026 ---------------- 31/07/2026

```

#### Legacy Processing Execution

The system executed a `SELECT * FROM school_calendar` query. If the database contained 500 historical or tentative calendar rows, all 500 entities were hydrated into memory, even though only the single latest `PUBLISHED` calendar was relevant to compute the fallback pattern.

---

## Root Cause Analysis

The implementation incorrectly delegated **data filtering and sorting responsibilities** to the application layer instead of the database engine.

From an enterprise architecture perspective, lookup operations should always minimize network payload and JVM hydration by utilizing database-level indexing. Additionally, a lack of precise `panelClass` targeting on the frontend resulted in component-level styles breaking Angular's view encapsulation, bleeding into the global DOM tree and affecting unrelated Material dialog elements.

---

## Expected Behavior

1. **Database-Level Lookup:** The application must query the database for exactly **one record**—the latest active calendar—by filtering on `status = 'PUBLISHED'` and sorting by `endDate` descending natively via SQL.
2. **Cohesive Domain Logic:** Both `ContrattoProrogaDomainService` and `WorkingDayCalculationServiceImpl` must leverage this identical repository query to eliminate inconsistent lookup states.
3. **Isolated Styling:** Frontend dialog resizing and border customizations must target a specific custom class wrapper, ensuring zero structural side-effects on other Angular Material overlays.
4. **Clean VCS State:** System and IDE configuration folders must be entirely excluded from version control tracking.

---

## Resolution Overview

The backend filtering strategy was refactored by replacing the inefficient list hydration with a native Spring Data JPA derived query method:

```java
SchoolCalendar publishedCalendar = schoolCalendarRepository
    .findFirstByStatusOrderByEndDateDesc(SchoolCalendarStatus.PUBLISHED)
    .orElseThrow(() -> new NoPublishedCalendarFoundException("..."));

```

This single query now executes an indexed lookup directly on the database engine, returning a single optimized record.

On the frontend, global layout overrides were extracted from the component file, scrubbed of aggressive `!important` markers, and placed into the global `styles.css` file. They were securely encapsulated by compounding the CSS rules directly to the unique dialog handle: `.cdk-overlay-pane.modern-floating-panel`. Finally, the local workspace cache was untracked via `git rm -r --cached .idea/` and blocked permanently via the root `.gitignore` file.

---

## Technologies

* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* PostgreSQL
* Angular (Standalone Components)
* Angular Material Design
* Git TypeScript

---

## Conclusion

The contract extension architecture was successfully optimized by transitioning from a costly in-memory stream filtering method to a highly targeted database-index strategy.

The finalized refactoring ensures:

* **O(1) Data Hydration:** Only the precise target record is pulled from the database.
* **Strict Style Encapsulation:** Modals are styled cleanly without global DOM side-effects.
* **Deterministic Fallback Logic:** Clear, centralized handling via unified custom exception states.
* **Clean Repository Standards:** A clutter-free project setup aligned with enterprise version control best practices.

