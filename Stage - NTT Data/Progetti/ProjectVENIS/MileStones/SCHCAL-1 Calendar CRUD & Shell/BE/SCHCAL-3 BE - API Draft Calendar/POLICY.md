# Java Spring Boot & Angular – School Calendar DRAFT & Validation 

---

## ⚠️ Corporate Disclaimer & Privacy Policy

> **PROPERTY OF NTT DATA Italia - Gov&Tech**
> This repository/documentation is strictly **private** and intended exclusively for internal knowledge sharing, technical documentation, and personal educational tracking.

> All code snippets, architecture flows, and examples contained herein have been deliberately **anonymized, de-contextualized, and sanitized** to remove any proprietary business logic, sensitive package structures, client references, or credentials.

---

## Feature Description (Creation of DRAFT Calendar)

The goal of this feature is to allow the possibilty to configure and initialize a new **School Calendar** in a preliminary `DRAFT` state.

Through a dedicated panel on the Frontend, users can define the calendar's structural metadata (academic year, descriptive name, date ranges, and the weekly operational pattern). Once persisted, this configuration serves as the structural baseline before the system triggers the automated calendar day-generation process.

```text
FE TO implement ... ──> REST POST (DTO) ──> Validation ──> MapStruct (Entity) ──> Database (Saved as DRAFT)

```

### Business Rules & Constraints

* **DRAFT solution:** Every newly created calendar must be hardcoded to `SchoolCalendarStatus.DRAFT`.

* **DATE status:** The operational end date (`endDate`) must be greater than or equal to the start date (`startDate`). Any inversion must be rejected.

* **Pass the tests:** All incoming payload fields must undergo strict syntactic and structural validation at the REST entrypoint.

---

## Initial Architectural Gaps (Why the Draft Feature Failed)

The initial system architecture only supported read-only views for existing calendars. Transitioning to a write model highlighted three core missing components:

1. **NO ENDPOINT:** The `SchoolCalendarBackOfficeResource` lacked a `POST` with the no possibility of creation of SchoolCalendar in DRAFT mode.

2. **NO VALIDATION:** The incoming parameters had no syntactic sanitization, allowing empty strings, null dates, or incomplete weekly patterns to reach the database layer.

3. **NO MAPPER:** The existing mapping configuration (`SchoolCalendarListMapper`) would trigger compilation warnings due to unmapped database-managed fields (such as `id`, `status`, and timestamps).

---

##  Structural Root Cause Analysis

An inspection of the structural layers showed that the write-path needed a complete alignment:

1. **DTO Unique:** The read-path was using a generic output DTO. A dedicated creation payload (`SchoolCalendarCreateRequestDTO`) to manage separatly all the attributes (like `id`, `createdAt`, and `publishedAt`).

2. **VALIDATION:** Directly saving mapped entities without transactional encapsulation or explicitly forcing the `DRAFT` state risked creating inconsistent calendars that bypassed the lifecycle rules (e.g., creating pre-published calendars).

3. **ANNOTATIONS:** Auto-generated target properties on the JPA entity triggered compiler alerts because MapStruct by default flags any target property that isn't explicitly mapped or ignored.

---

## Refactored Architecture & Expected Behavior

The system has been updated to handle the write-path gracefully through a robust multi-layered architecture:

### A. Strict Input Validation (DTO)

The incoming request body is strictly checked using JSR-380 (Jakarta Validation) annotations. All operational weekly days are explicitly typed as `Boolean` objects to catch missing payload flags:

```java
@Data
public class SchoolCalendarCreateRequestDTO {

    @NotBlank(message = "ATTENZIONE! L'anno scolastico è obbligatorio")
    private String academicYear;

    @NotBlank(message = "ATTENZIONE! Il nome del calendario è obbligatorio")
    private String name;

    @NotNull(message = "ATTENZIONE! La data di inizio è obbligatoria")
    private LocalDate startDate;

    @NotNull(message = "ATTENZIONE! La data di fine è obbligatoria")
    private LocalDate endDate;

    @NotNull(message = "Il flag Lunedì è obbligatorio")
    private Boolean workingMonday;

    @NotNull(message = "Il flag Martedì è obbligatorio")
    private Boolean workingTuesday;

    @NotNull(message = "Il flag Mercoledì è obbligatorio")
    private Boolean workingWednesday;

    @NotNull(message = "Il flag Giovedì è obbligatorio")
    private Boolean workingThursday;

    @NotNull(message = "Il flag Venerdì è obbligatorio")
    private Boolean workingFriday;

    @NotNull(message = "Il flag Sabato è obbligatorio")
    private Boolean workingSaturday;

    @NotNull(message = "Il flag Domenica è obbligatorio")
    private Boolean workingSunday;
}

```

### B. MapStruct Warnings Mitigation

We decorated `SchoolCalendarListMapper` with explicit `@Mapping` declarations to instruct MapStruct to ignore entity-managed targets, preventing compilation warnings during Maven builds:

```java
@Mapper(componentModel = "spring")
public interface SchoolCalendarListMapper {

    SchoolCalendarListResponseDTO toDto(SchoolCalendar entity);

    // *Prevents MapStruct compilation warnings for unmapped target properties during build
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "basedOnCalendarId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "publishedAt", ignore = true)
    @Mapping(target = "rules", ignore = true)
    @Mapping(target = "days", ignore = true)
    SchoolCalendar toEntity(SchoolCalendarCreateRequestDTO dto);
}

```

### C. Coherence Checks inside Business Service

The `CalendarLifecycleServiceImpl` handles the state assignment and temporal validation within a transactional context:

```java
@Override
@Transactional
public SchoolCalendarListResponseDTO createCalendarDraft(SchoolCalendarCreateRequestDTO requestDto) {

    // *VALIDATION: Checking end date >= start date
    if (requestDto.getEndDate().isBefore(requestDto.getStartDate())) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ATTENZIONE! La data di fine non può essere antecedente alla data di inizio");
    }

    SchoolCalendar calendar = schoolCalendarListMapper.toEntity(requestDto);
    
    // ?Forcing default lifecycle status
    calendar.setStatus(SchoolCalendarStatus.DRAFT);

    SchoolCalendar savedCalendar = schoolCalendarRepository.save(calendar);
    
    return schoolCalendarListMapper.toDto(savedCalendar);
}

```

---

##  Testing and Verification Strategy

To guarantee zero-regression, a complete testing suite has been implemented:

* **IMPACT & JUnit:** Verifies that a valid payload is successfully stored as `DRAFT` and that any date inversion throws a `ResponseStatusException` (Bad Request) prior to database execution.

* **REST Integration Tests (`MockMvc`):** Assures that missing properties trigger a `400 Bad Request` status with validation alert payloads, while correct structures yield `200 OK` (wrapped in the `ServiceResponse` wrapper).

---

## Technologies Used

* Java 17 / Spring Boot 3
* Spring Data JPA / Hibernate
* MapStruct (Component Model Spring)
* Jakarta Validation API (JSR-380)
* PostgreSQL
* Lombok

---

## Conclusion

This implementation completes the design pattern used in our enterprise architecture. By separating the read models from the write models, introducing explicit MapStruct mapping exclusions, and enforcing transactional service-level validations, the calendar generation path is now stable, safe, and perfectly aligned with our team's coding standard.