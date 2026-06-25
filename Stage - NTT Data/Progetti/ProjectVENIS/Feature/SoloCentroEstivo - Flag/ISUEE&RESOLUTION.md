# Solution: Dynamic Attribute Correlation Logic

To resolve the issue, a conditional subquery block was manually structured and injected into the `@Query` fields of the data repository layer.

## Boundary Logic Explained

The custom filter block intercepts the incoming parameter using an `OR` bypass short-circuit condition, ensuring that filtering triggers only when explicitly requested.

**Condition:**

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

### Short-Circuit Evaluation (`:soloCentroEstivo = false`)

When the checkbox is empty, this condition evaluates to `true`. The database engine skips evaluating the heavy `EXISTS` clause entirely, preventing performance degradation and ensuring backward compatibility with standard listings.

### Bouncer Filtering (`:soloCentroEstivo = true`)

When activated, the condition forces a lookup into the dynamic mapping table (`InsegnanteAttributoValore`), acting as a strict bouncer. It keeps the collection clean by filtering out rows lacking the exact key-value record requirement.

---

## Validation Tests 

Following parameter cleanups and subquery injection, Hibernate compiled and executed the updated query parameters correctly:

```sql
WHERE ( ? = 0 OR EXISTS (
    SELECT 1 FROM insegnante_attributo_valore jav
    WHERE jav.insegnante_id = i.id 
      AND jav.codice_attributo = 'DISPONIBILITA_CENTRO_ESTIVO' 
      AND jav.valore_string = 'SI'
))

```

The solution was verified against a real sandbox record setup (Target Record ID: 14 / Attribute Set to 'SI'):

### Test Results

| Checkbox State | Search Text | Expected Result | Actual Result | Status | Notes |
| --- | --- | --- | --- | --- | --- |
| **DISABLED** | *None* | Display All Records | Display All Records | ✅ PASSED | Default listing operates without restriction |
| **ENABLED** | *None* | Display Isolated Record | Display Isolated Record | ✅ PASSED | Table narrows down instantly to target profile |
| **ENABLED** | "Costa" | Display Isolated Record | Display Isolated Record | ✅ PASSED | Combining text search with dynamic flag works |
| **ENABLED** | "Esposito" | Empty Result Set | Empty Result Set | ✅ PASSED | Record safely excluded (missing EAV 'SI' value) |

### Result on the FE

![Flag Centro Estivo Visible](./assets/images/FlagCentroEstivo.png))

## ✅ Outcome

The software architecture now cleanly bridges state changes from the user view down to relational entity attributes. It preserves full consistency across text filters, pagination counts, and dynamic flag parameters without breaking Hibernate's startup verification routines.