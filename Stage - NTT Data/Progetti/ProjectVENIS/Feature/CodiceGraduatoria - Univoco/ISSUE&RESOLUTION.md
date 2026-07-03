# Solution: Uniqueness Validation Logic

To resolve the duplicate data vulnerability, a dedicated validation strategy was structured on the backend using an optimized query layer, paired with an event-driven action boundary on the frontend.

## Boundary Logic Explained

The uniqueness check is executed through a custom repository method that normalizes data dynamically at the database level. This guarantees that variations in spaces or casing do not bypass the system rules.

**Repository Custom Query Condition (JPQL):**

```sql
@Query("SELECT COUNT(g) > 0 FROM GraduatoriaInfo g WHERE UPPER(REPLACE(g.codice, ' ', '')) = :codice")
boolean existsByCodice(@Param("codice") String codice);

```

### Server-Side Data Normalization (`UPPER` & `REPLACE`)

Instead of doing a raw string comparison, the database engine processes the check dynamically:

* **`REPLACE(g.codice, ' ', '')`**: Strips out all internal and external spaces from the existing records on the fly.
* **`UPPER(...)`**: Converts the string to uppercase, eliminating case sensitivity.

This ensures that if a ranking system already exists with the code `TEST-001`, any new submission typed as `test-001` or `TEST   001` is instantly intercepted and flagged as a duplicate.

---

## Validation Tests

Following the integration of the custom query and frontend event mapping, Hibernate correctly compiled and executed the native SQL parameters:

```sql
SELECT count(g.id) > 0 
FROM graduatoria_info g 
WHERE UPPER(REPLACE(g.codice, ' ', '')) = ?

```

The solution was fully verified against a dedicated sandbox setup to test various edge cases and bypass attempts:

### Test Results

| Scenario Tested | Input Code Value | Trigger Action | Expected Result | Actual Result | Status |
| --- | --- | --- | --- | --- | --- |
| **Clean Entry** | `GRAD-2026-XYZ` | Click "Continua" | Form is valid; moves to Step 2 | Form is valid; moves to Step 2 | ✅ PASSED |
| **Exact Duplicate** | `TEST-001` (Existing) | Click "Continua" | Wizard blocks; field turns red | Wizard blocks; field turns red | ✅ PASSED |
| **Hidden Spaces** | `TEST   001` (Existing) | Click "Continua" | Spaces stripped; caught as duplicate | Spaces stripped; caught as duplicate | ✅ PASSED |
| **Case Variation** | `test-001` (Existing) | Click "Continua" | Evaluated as uppercase; blocked | Evaluated as uppercase; blocked | ✅ PASSED |
| **Empty Input** | `   ` (Spaces Only) | Click "Continua" | Synchronous `required` error triggers | Synchronous `required` error triggers | ✅ PASSED |

### Result on the FE


Tested line warning as Error show up: 

![Warning Codice](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/f372cccfda49de8e93f0895f2e898b19439623d6/Stage%20-%20NTT%20Data/assets/images/WarningCodice.png)

---

Page with the botton, blocked due to error in not unique code:


![Page Screen Graduation](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/f372cccfda49de8e93f0895f2e898b19439623d6/Stage%20-%20NTT%20Data/assets/images/TestedPageGraduatoria.png)







## ✅ Outcome

The software architecture now cleanly bridges state changes from the user view down to relational persistence rules. It completely eliminates HTTP request flooding by switching to an on-demand strategy, while ensuring absolute data integrity across the platform by neutralizing whitespace and casing bypass vulnerabilities.