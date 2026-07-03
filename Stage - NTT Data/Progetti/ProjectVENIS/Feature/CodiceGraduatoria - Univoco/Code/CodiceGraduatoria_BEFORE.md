# 🛑 BEFORE: Absent Validation Layer & Vulnerable Forms 

Previously, the application entirely lacked any verification checks to ensure the uniqueness of the *Codice Graduatoria* before persistence.

### 1. The Frontend Issue (Angular)

The `codice` control inside the `ReactiveForm` only had a basic `Validators.required` check. No asynchronous barrier or API service call was connected to the component. When clicking the button to advance the wizard, the UI would blindly transition to Step 2, completely unaware of whether the code was already assigned to another record.

```typescript
// Legacy Form Initialization - No uniqueness check connected
this.step1Form = this.fb.group({
  codice: ['', Validators.required]
});

```


### 2. The Backend Issue (Java Spring Boot)

The repository layer did not expose any custom string-manipulation queries to detect hidden duplicates. As a result, the database blindly accepted identical values, as well as duplicate codes disguised with accidental whitespaces or case variations (e.g., storing `TEST-01` alongside `test-01` or `TEST   01`), causing heavy data fragmentation.

```java
// Legacy Repository - Blindly relied on standard crud saves
public interface GraduatoriaInfoRepository extends JpaRepository<GraduatoriaInfo, Long> {
    // Missing custom validation query method
}

```
