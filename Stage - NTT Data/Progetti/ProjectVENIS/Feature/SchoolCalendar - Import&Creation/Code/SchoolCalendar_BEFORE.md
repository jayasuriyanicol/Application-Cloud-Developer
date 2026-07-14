##  Initial Erroneous Logic & Environmental Roadblocks

In the initial state, the application exhibited a series of architectural rigidities and configuration misalignments that prevented the successful bootstrap of the new academic year, systematically blocking the Maven build (`mvn test`) in local development environments.

### Conceptual Representation

```text
       ┌────────────────────────────────────────────────────────┐
       │             Maven Build (Local Environment)            │
       └───────────────────────────┬────────────────────────────┘
                                   │
         ┌─────────────────────────┴─────────────────────────┐
         ▼                                                   ▼
┌─────────────────────────────────┐       ┌─────────────────────────────────┐
│     SupplentiApplicationTests   │       │   CalendarGenerationServiceTest │
└────────────────┬────────────────┘       └────────────────┬────────────────┘
                 │ (Context Load)                          │ (Assertion Check)
                 ▼                                         ▼
   [FAIL] Connection Refused                 [FAIL] expected: <true> but was: <false>
 (MySQL Server Offline / Port 3306)          (Stale Academic Year 2025-2026)

```

Under this legacy behavior, the system suffered from four main issues:

### 1. Hardcoded Seeding & Resource Exclusion

The `SchoolCalendarBootstrap` class featured a `@Value` annotation configured with a static fallback value, targeting exclusively the previous academic year's resource:

```java
@Value("${application.school-calendar.bootstrap.resource:calendars/calendar-2025-2026.json}")
private String resourcePath;

```

In the absence of a dynamically injected property within local configuration files, the system completely ignored the existence of the newly added `calendar-2026-2027.json` file, preventing the automatic seeding of the new calendar records into the development database at runtime.


### 2. Temporal Coupling in Unit Tests (AssertionFailedError)

The calendar day generation test suite (`CalendarGenerationServiceTest`) contained test methods (specifically `generateDays_shouldMarkConfiguredRedDayAsTrueWhenNonWorking`) whose mocks and input parameters were hardcoded to date ranges of the legacy academic year `"2025-2026"` (e.g., Christmas 2025).
As soon as the core business logic or configuration JSONs were updated to support the new academic dates, this temporal misalignment caused the generation engine to return `redDay = false`, triggering JUnit assertion failures:

```text
[ERROR] generateDays_shouldMarkConfiguredRedDayAsTrueWhenNonWorking -- Time elapsed: 0.017 s <<< FAILURE!
org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
    at org.junit.jupiter.api.Assertions.assertTrue(Assertions.java:183)
    at com.venis.supplenti.service.calendar.CalendarGenerationServiceTest.generateDays_shouldMarkConfiguredRedDayAsTrueWhenNonWorking(CalendarGenerationServiceTest.java:176)
```
