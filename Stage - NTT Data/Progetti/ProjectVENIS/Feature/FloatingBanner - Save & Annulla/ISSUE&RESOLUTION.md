## Solution: Floating Action Banner & Dynamic Subquery Injection

### 1. Frontend: Implementation of the Global Floating Action Banner

A custom, sticky footer banner component was engineered to actively monitor the `dirty` (modified) state of the teacher management view grid.

* **Save Changes Action:** Aggregates the ongoing form/filter parameters and triggers bulk service persistence routines.
* **Cancel Action:** Clears the temporary UI buffers, flushes reactive form controls, and reverts the interface seamlessly to the baseline state.

---

### 2. Backend: Dynamic Correlation Logic (Short-Circuit Subquery)

Repository method signatures were synchronized to 14 parameters across all layers, and a conditional subquery block with short-circuit capabilities was successfully injected into the `@Query` fields of the data repository layer:

```sql
AND (
    :soloCentroEstivo = false
    OR EXISTS (
        SELECT 1 FROM InsegnanteAttributoValore jav
        WHERE jav.insegnante.id = i.id
          AND jav.attributoDefinizione.codice = 'DISPONIBILITA_CENTRO_ESTIVO'
          AND jav.valoreString = 'SI'
    )
)

```

* **Short-Circuit Evaluation (`:soloCentroEstivo = false`):** When the checkbox is empty, the statement evaluates to `true`. Hibernate completely skips executing the heavy internal `EXISTS` subquery, avoiding processing overhead on standard paginated listings.
* **Bouncer Filtering (`:soloCentroEstivo = true`):** When toggled active, it forces an isolation lookup against the EAV table (`InsegnanteAttributoValore`), acting as a strict filter to keep the returned data restricted exclusively to profiles matching the required availability matrix.

---

## Validation Tests

The architecture patch was thoroughly verified against a real database sandbox environment setup (Target Record ID: 14 / Custom Attribute configured as 'SI').

### Test Results

| Checkbox State | Search Text Filter | Expected Result | Actual Result | Status | Notes |
| --- | --- | --- | --- | --- | --- |
| **DISABLED** | *None* | Display All Records | Display All Records | ✅ PASSED | Default listing operates without restrictions |
| **ENABLED** | *None* | Display Isolated Record | Display Isolated Record | ✅ PASSED | Table narrows down instantly to target profiles |
| **ENABLED** | "Costa" | Display Isolated Record | Display Isolated Record | ✅ PASSED | Text query combines perfectly with dynamic EAV logic |
| **ENABLED** | "Esposito" | Empty Result Set | Empty Result Set | ✅ PASSED | Record safely excluded (missing EAV 'SI' flag) |

### Visual Feedback on FE

![Floating Banner](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/FloatingBanner.png?raw=true)

The Floating Action Banner displays dynamically when modifications are present, and the main dataset renders in full alignment with the custom EAV flag state:

![Floating Banner Page](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/FloatingBannerPage.png?raw=true)
---

## Technologies

* Angular 17+ (Reactive Forms & Standalone Components)
* Java 17 / Spring Boot 3
* Spring Data JPA / Hibernate ORM
* PostgreSQL / HQL & JPQL (EAV Model - Entity-Attribute-Value)
* Tailwind CSS / Bootstrap (Layout & Viewport Fixed Positioning)

---

## ✅ Outcome

The refactoring introduces a unified and robust state lifecycle through the **Global Action Banner Container**. Simultaneously, the adjustments made to the JPQL/HQL repository predicates guarantee absolute data consistency across text search filters, calculation counts, and dynamic relational mapping fields without breaking Hibernate's strict startup verification routines.