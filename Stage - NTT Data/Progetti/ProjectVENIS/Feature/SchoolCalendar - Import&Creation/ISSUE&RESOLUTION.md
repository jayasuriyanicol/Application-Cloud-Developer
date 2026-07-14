# Solution: Calendar Generation & Test Verification Logic

To create the calendar initialization gap and aligning local test suite, some changes was structured on the backend, paired with an automated schema-seeding bootstrap mechanism (already had in the BE).

## Boundary Logic Explained

The calendar generation logic is executed through a multi-stage pipeline that processes a raw date grid, applies regional public holidays (*Red Days*), and overlays customized operational rules sorted by business priority.

**Service Processing Logic (Java Mock Setup):**

```java
// Mocking the rule matching order for the December 2026 holiday period
when(schoolCalendarRuleRepository.findByCalendarIdOrderByRuleOrderAscIdAsc(1L))
    .thenReturn(List.of(buildSingleDateRule(
        30L,
        0,
        SchoolCalendarRuleType.NON_WORKING_DAY,
        LocalDate.of(2026, 12, 25)
    )));

```

### Multi-Stage Generation Processing

Instead of saving static configurations, the `CalendarGenerationService` calculates the operational day records dynamically:

* **Temporal Grid Initialization**: Loops through every date from `startDate` (September 8, 2026) to `endDate` (June 30, 2027) and applies the default working week pattern.

* **Red Day Mapping**: Parses the `redDays` array from the `calendar-2026-2027.json` file and overlays `redDay = true` and `workingDay = false` on matching calendar days.

* **Database-Persisted Rules (`RuleOrder` Priority)**: Retrieves rules via `findByCalendarIdOrderByRuleOrderAscIdAsc` and applies manual overrides (e.g., forcing a holiday to be a working day or vice versa), executing them sequentially so that higher-priority rules cleanly override previous states.

---

## Validation Tests

Following the integration of the `calendar-2026-2027.json` file and the updating of the JUnit parameters, Maven successfully compiled, linked the active local database, and executed the entire test suite:

```text
[INFO] Results:
[INFO] 
[INFO] Tests run: 158, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

```

The generation engine and the bootstrap logic were fully verified against multiple edge cases, rule priorities, and database states:

### Test Results

| Scenario Tested | Input Calendar Parameters / Date | Trigger Action | Expected Result | Actual Result | Status |
| --- | --- | --- | --- | --- | --- |
| **IMPACT TESTS** | Academic Year `2026-2027` (Sept 8 – June 30) | Run `./mvnw test` | 156 GREEN TESTS | ✅ PASSED |
| **BE TEST** | MVN tests and Mockijto one | Test JUnit & Mockijto | Run `mvn run compile` | ALL TEST PASSED | ✅ PASSED |
| **FE TEST** | Angular/Vite tests| Test run Angular and Mockijto | Run `npm run build` | Rule forces day to remain non-working | ✅ PASSED |

---

# Result on the DB & Console

Tested pipeline executing successfully on startup:

### Action calculation of preview

#### 1. TEST ON IMPACT:


![Success IMPACT](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendar%20-%20ImpactSuccess.png?raw=true)

---
#### 2. TEST ON BE:


![Success BE](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendar%20-%20SuccessBE.png?raw=true)

---

---
#### 3. TEST ON FE:


![Success FE](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendar%20-%20SuccessFE.png?raw=true)

---

#### 4. TEST OF CREATION CALENDAR ON DB by JPA/Hibernate:



```text
2026-07-14 10:11:42.189 INFO  [main] [] c.v.s.c.SchoolCalendarBootstrap - Bootstrap calendario completato da resource calendars/calendar-2026-2027.json

```

---

Active development database (MySQL Workbench) showing the imported calendar and generated days successfully persisted:

```text
+----+---------------+---------------------+------------+------------+--------+
| id | academic_year | name                | start_date | end_date   | status |
+----+---------------+---------------------+------------+------------+--------+
| 1  | 2026-2027     | Calendario scol...  | 2026-09-08 | 2027-06-30 | DRAFT  |
+----+---------------+---------------------+------------+------------+--------+
1 row in set (0.01 sec)

```

---

## Outcome

The backend architecture now seamlessly processes the physical calendar generation rules from a static JSON definition down to individual relational records. It avoids local integration compile failures by ensuring local database availability during testing, and guarantees complete temporal integrity for the 2026-2027 schedule.