# Solution: Optimized Fallback & Encapsulated Warning Logic

To resolve the issue, the calendar lookup mechanism was refactored to evaluate a targeted **database-level lookup of active periods** rather than relying on an inefficient in-memory collection stream.

The application now correctly computes the contract extension preview using standard summer working day patterns when the target date exceeds the current school year. If the user decides to proceed from the warning modal, the frontend performs a validation check; if the extension successfully bypasses the chronological block but extends out of bounds, an informative `MatSnackBar` notification is triggered as a final confirmation that the extension resides outside the standard school calendar.

---

## Boundary Logic Explained

### Date Chronology Validation (`nuovaDataFineSenzaFerie`)

The contract extension start date behaves as a **strict chronological threshold**. The system blocks any extension request where the new end date is prior to or exactly matches the current contract's final day, ensuring a progressive temporal sequence.

**Condition:**

```java
if (nuovaDataFineSenzaFerie.isBefore(dataInizioNuovoContratto)) {
    throw new IllegalArgumentException("nuovaDataFineSenzaFerie deve essere uguale o successiva alla data inizio della proroga");
}

```

This ensures that only logically consecutive contract periods are processed by the backend engine.

### Calendar Exceedance Verification (`checkOltreFineAnnoScolastico`)

The published calendar's final date acts as a **soft boundary**. It does not block data generation but flags the record when the calculated extension spills into unmapped school intervals.

**Condition:**

```java
if (valueFineAnnoScolastico != null && nuovaDataFineSenzaFerie.isAfter(valueFineAnnoScolastico)) {
    checkOltreFineAnnoScolastico = true;
}

```

This guarantees that whenever a contract outpaces the `PUBLISHED` calendar limits, the frontend is explicitly notified via the payload to trigger the fallback warning workflow and subsequent toast alerts.

---

## Validation Tests

After implementing the fix using **Spring Data Derived Queries**, Hibernate generated the expected dynamic lookup:

```sql
SELECT sc1_0.id, sc1_0.end_date, sc1_0.status, ... 
FROM school_calendar sc1_0 
WHERE sc1_0.status = ? 
ORDER BY sc1_0.end_date DESC 
LIMIT 1

```

The solution was validated using a test school calendar with the following validity period:

| Calendar Start Date | Calendar End Date | Current Contract End Date |
| --- | --- | --- |
| 08/09/2025 | 30/06/2026 | 29/07/2026 |

# Results

## Result on the FE


### Action calculation of preview

#### 1. Tested the calculation with a in range date of contract, error line:


![ErrorLine ContrattoProroga](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/ProrogaContratto%20-%20Errorline.png?raw=true)

---
#### 2. Tested the calculation with not a range date of contract, success calculation:


![Preview ContrattoProroga](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/ProrogaContratto%20-%20SuccessPreview.png?raw=true)

---


### After consequences of calculation preview

---
#### 3. Tested the calculation after clicking 'avanti', with a date after SchoolCalendar end date:


![Alert After End Date](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/ProrogaContratto%20-%20SnackBarAlert.png?raw=true)

    Here, when we click 'PROCEDI' will accept the case of a contratto end of school year so 'soloCentroEstivo' one.
---

---
#### 4. Tested the calculation after clicking 'Annula', with a date after SchoolCalendar end date:


![Alert Annula Preview](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/ProrogaContratto%20-%20EmptyData.png?raw=true)

    Here, when we click 'ANNULLA' will deny the case of a contratto end of school year so 'soloCentroEstivo' one with reset of all the data written before.
---









### Test Results

| Input Date Passed | Expected Result | Actual Result | Status | Notes |
| --- | --- | --- | --- | --- |
| **25/07/2026** | Inline Red Block Error | Inline Red Block Error | ✅ PASSED | Correctly blocked; date is prior to contract expiration. |
| **29/07/2026** | Inline Red Block Error | Inline Red Block Error | ✅ PASSED | Boundary condition blocked; extension must be progressive. |
| **30/07/2026** | Warning Modal Triggers | Warning Modal Triggers | ✅ PASSED | Chronology passed; exceeds June 30 limit, prompting user confirmation. |
| **31/07/2026** | Warning Modal Triggers | Warning Modal Triggers | ✅ PASSED | Summer standard fallback calculated correctly. |
| **Click "Procedi" (30/07)** | Form Unlocked & SnackBar Fired | Form Unlocked & SnackBar Fired | ✅ PASSED | SnackBar alerts user that the extension is out of standard calendar bounds. |
| **Click "Annulla" (30/07)** | Form Closed & Data Empty |  Form Closed & Data Empty | ✅ PASSED | SnackBar closing and return to the first page ( data empty)  |
| **Other Modals Check** | Standard Layout Maintained | Standard Layout Maintained | ✅ PASSED | CSS encapsulation validated; no layout leakage onto unrelated panels. |

---

## ✅ Outcome

The implementation now flawlessly handles all contract extension scenarios, including:

* Strict validation blocking against invalid or overlapping past contract dates.
* O(1) database-level filtering that completely removes JVM memory overhead.
* Isolated styling rules compounded under `.cdk-overlay-pane.modern-floating-panel` preventing DOM pollution.
* Clear visual feedback via unified warning modals and specific asynchronous `MatSnackBar` toasts when operating outside standard parameters.

This approach ensures robust data consistency, high-performance query execution, and an ergonomic user experience aligned with enterprise development standards.