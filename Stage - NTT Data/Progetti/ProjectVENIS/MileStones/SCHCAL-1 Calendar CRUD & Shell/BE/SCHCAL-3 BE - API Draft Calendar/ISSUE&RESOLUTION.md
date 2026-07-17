## Solution: Normalization & Adapter Isolation

To resolve the structural inconsistencies and prevent unmapped property warning leaks during compilation, the backend write-path was decoupled from the query layer, and explicit validation pipelines were introduced at the application boundaries.

```java
// *Architectural highlight of the validation and lifecycle enforcement routine
@Override
@Transactional
public SchoolCalendarListResponseDTO createCalendarDraft(SchoolCalendarCreateRequestDTO requestDto) {

    // *VALIDATION: Checking temporal coherence (EndDate >= StartDate)
    if (requestDto.getEndDate().isBefore(requestDto.getStartDate())) {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, 
            "ATTENZIONE! La data di fine non può essere antecedente alla data di inizio"
        );
    }

    SchoolCalendar calendar = schoolCalendarListMapper.toEntity(requestDto);
    calendar.setStatus(SchoolCalendarStatus.DRAFT);

    SchoolCalendar savedCalendar = schoolCalendarRepository.save(calendar);
    return schoolCalendarListMapper.toDto(savedCalendar);
}

```

## Architectural Cleanup Explained

### 1. Centralized Formats & Decoupling

The database mutation logic was completely isolated from the read-only queries by introducing `CalendarLifecycleServiceImpl` as a dedicated service interface. This architectural split prevents the bloating of `SchoolCalendarQueryServiceImpl`, ensuring that query processes (such as `getAllCalendarsForBackoffice`) remain lightweight, highly transactional, and free from state-mutation side effects.

### 2. Warn-Free Compile Mapping Protocol

The mapping contract (`SchoolCalendarListMapper`) was enhanced with compile-time mapping rules. Since database-managed entity targets like `id`, `status`, `createdAt`, `updatedAt`, `rules`, and `days` do not exist within the client request payload (`SchoolCalendarCreateRequestDTO`), MapStruct was instructed via explicit annotations to ignore these unmapped attributes. This completely eliminates compiler warnings during the Maven build phase:

```java
@Mapping(target = "id", ignore = true)
@Mapping(target = "status", ignore = true)
@Mapping(target = "rules", ignore = true)
@Mapping(target = "days", ignore = true)
// Additional structural target mappings are ignored sequentially prior to build execution

```

---

## TEST

Following the implementation of the lifecycle validation layer, a suite of automated unit and integration test blocks was executed to verify the behavior of the field constraints and the response payloads.

### Result on the BE

Impact tests, implemented with the others MOCK test approved all

![SchCalCre IMPACT](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarCreate%20-%20SuccessImpact.png?raw=true)

So applying the changes into all the BE system, here the check to validate:

![SchCalCre BE](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarCreate%20-%20SuccessBE.png?raw=true)

### Test Results

| User Entry Payload (DTO) | Validation Context | Expected Outcome | Status | Verification Note |
| --- | --- | --- | --- | --- |
| **Complete & Valid Fields** | `startDate = 2026-09-01`, `endDate = 2027-06-30` | `200 OK` (Saved as `DRAFT`) | ✅ PASSED | Correctly persists entity and returns the response DTO |
| **`endDate` < `startDate`** | `startDate = 2026-09-01`, `endDate = 2026-08-31` | `400 BAD REQUEST` | ✅ PASSED | Service layer intercepts error; triggers custom warning |
| **Missing `academicYear`** | `academicYear = ""` or `null` | `400 BAD REQUEST` | ✅ PASSED | `@NotBlank` constraint rejects payload at controller layer |
| **Missing `name`** | `name = ""` or `null` | `400 BAD REQUEST` | ✅ PASSED | `@NotBlank` constraint rejects payload at controller layer |
| **Null Weekly Flags** | `workingMonday = null` | `400 BAD REQUEST` | ✅ PASSED | `@NotNull` constraint enforces presence on `Boolean` wrappers |

##  Outcome

The system successfully handles every distinct backend input behavior. By combining Jakarta Bean Validation constraints with explicit service-level chronological checks, the write-path avoids inconsistent database entries while providing total operational security.

The complete codebase updates were aggregated into a singular feature commit, keeping historical source control branches optimal and fully integrated within remote staging pipelines.