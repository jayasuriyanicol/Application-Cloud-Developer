
# Java Spring Boot & JPA – School Calendar 2026-2027 Import & Day Generation Feature

---


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

## Problem Description (FEATURE 'Calendario Scolastico 2026-2027')

A new School Calendar was requested, by the 'Comune di Venezia' to support the academic year **2026-2027** by providing a comprehensive system to parse, import, and generate the daily operational grid (*SchoolCalendarDay*) for the school calendar as in the year **2025-2026**.

Previously, the application lacked the configuration dataset for the 2026-2027 academic term. Furthermore, attempting to execute the build or perform the runtime initialization on local development environments failed due to environmental discrepancies. Specifically, database-dependent integration tests and scheduled background tasks would fail during context startup because of unreachable database connections, and existing calendar generation unit tests were tightly coupled to outdated academic years, throwing assertion failures.


Under this legacy behavior:

* **Resource Absence:** No configuration resource existed for `calendar-2026-2027.json`, meaning any business workflow requesting the upcoming calendar definition resulted in a resource-not-found error.

* **JDBC Meta Failure:** The application's smoke tests (`SupplentiApplicationTests`) and background scheduling routines attempted to connect to a real MySQL instance during the test phase. If the server was unreachable, Hibernate went into fatal failure: `Unable to create requested service [JdbcEnvironment] due to: Unable to determine Dialect without JDBC metadata`.

* **Temporal Assertion Mismatch:** Unit tests (`CalendarGenerationServiceTest`) mocked calendar generation rules using legacy academic year values (e.g., `"2025-2026"`). When testing generation logic with the new business rules or date boundaries, the assertions checking the `redDay` status failed (`expected: <true> but was: <false>`).

---

## Root Cause Analysis

The build and bootstrap failures stemmed from three main issues across the application codebase:

1. **Environmental Integration Test Dependency:** The overall application smoke test was configured to boot a fully active ApplicationContext which automatically scanned and triggered scheduled tasks and database connections without a fallback profile or mock environment, crashing if local services were offline.
2. **Temporal Coupling in Unit Tests:** Test methods in `CalendarGenerationServiceTest` mocked rules specifically tied to legacy years and dates (e.g., Christmas 2025), which resulted in failing assertions when the underlying code matched against newer business logic constraints.
3. **Single-File Hardcoded Seeding:** The class `SchoolCalendarBootstrap` was configured to load only a single, hardcoded default file (`calendars/calendar-2025-2026.json`) via a `@Value` annotation unless overridden by explicit environment properties.

---

## Expected Behavior

The import and generation mechanism must run smoothly and seamlessly across all layers:

* **Clean Maven Build:** All 158 tests, including the global integration test context load and the calendar-specific tests, must pass successfully under a unified, real, and clean test cycle.
* **Dynamic Data Generation:** Given a start and end date (September 8, 2026, to June 30, 2027), the system must generate a continuous grid of daily records. Each record must be initialized with the correct working day boolean flag mapped against the calendar's default weekly pattern.
* **Accurate Holiday & Rule Overrides:** The generator must apply holiday overrides (marking configured *Red Days* as non-working) and custom rules (such as manual closures or extraordinary Saturday openings) according to their execution priority.

---

## ✅ Resolution Overview

The calendar implementation and the test infrastructure were refactored to achieve an absolute, clean, and green build:

1. **Anonymized Resource Parsing:** Created and integrated the `calendar-2026-2027.json` file containing the specific 2026-2027 academic grid, regional public holidays (*redDays*), and local educational custom rules.
2. **Refactored Calendar Unit Tests:** Updated `CalendarGenerationServiceTest` to align its parameters with the correct academic year `"2026-2027"` and updated holiday mock date verifications to target December 2026 holidays. This aligned assertions with the logical mapping of the calendar file, restoring test verification to 100% green.
3. **Bootstrap Configuration & Runtime Seeding:** Structured `SchoolCalendarBootstrap` to properly leverage local YAML config overrides. By declaring the application property `application.school-calendar.bootstrap.resource: "calendars/calendar-2026-2027.json"`, the system automatically parses and imports the new calendar definition to the persistent database schema in `DRAFT` status at application start.
4. **CI/CD Build Cleanliness:** Performed a complete local history restore, discarded IDE-specific configurations (`.idea/`, `.patch`, and temporary shelves) to maintain clean commits, and verified the successful build execution through a direct `./mvnw clean test` run against the local target.

---

## Technologies

* Java 17 / Spring Boot
* Spring Data JPA & Hibernate
* JUnit 5 & Mockito (Unit testing)
* Maven (Build & Dependency management)
* PostgreSQL / MySQL (Relational persistence layer)
* Jackson ObjectMapper (JSON Resource Deserialization)

---

## Conclusion

The 2026-2027 academic calendar was successfully integrated and verified. By maintaining strict test design principles, we avoided modifying internal testing frameworks and instead ensured the application and database environments were correctly aligned.

The resulting codebase ensures:

* Total build stability with all 158 unit and integration tests executing flawlessly.
* Dynamic, multi-stage day generation from September 2026 to June 2027.
* A clean, decoupled, and production-ready Merge Request featuring zero local configuration noise.