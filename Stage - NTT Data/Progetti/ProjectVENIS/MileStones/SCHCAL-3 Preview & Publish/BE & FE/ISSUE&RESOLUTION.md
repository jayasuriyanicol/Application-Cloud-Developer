
## Solution: Refactored Architecture & Expected Behavior

The application lifecycle, service layers, and frontend components were refactored for complete end-to-end reliability:

### A. REST Separation & Backend Domain Guards (`SchoolCalendarCommandServiceImpl`)

Back-Office REST controllers were separated from public read-only resources. Domain service rules enforce non-draft shielding and single-published-calendar rules per academic year.

```java
// *Architectural highlight of Domain Guards and Publication Logic in Backend
@Service
@Transactional
public class SchoolCalendarCommandServiceImpl implements SchoolCalendarCommandService {

    private final SchoolCalendarRepository calendarRepository;

    @Override
    public SchoolCalendarDetailResponseDTO publishSchoolCalendar(Long id) {
        SchoolCalendar calendar = calendarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Calendario scolastico non trovato con ID: " + id));

        // *GUARD 1: Strict DRAFT status requirement
        if (calendar.getStatus() != CalendarStatus.DRAFT) {
            throw new CalendarValidationException("Impossibile pubblicare: il calendario non si trova in stato BOZZA.");
        }

        // *GUARD 2: Verification of non-empty generated days
        if (calendar.getGeneratedDays() == null || calendar.getGeneratedDays().isEmpty()) {
            throw new CalendarValidationException("Impossibile pubblicare: generare i giorni del calendario prima di proseguire.");
        }

        // *GUARD 3: Year-uniqueness check for PUBLISHED status
        boolean alreadyExists = calendarRepository.existsByAcademicYearAndStatusAndIdNot(
                calendar.getAcademicYear(), 
                CalendarStatus.PUBLISHED, 
                id
        );

        if (alreadyExists) {
            throw new CalendarValidationException("Esiste già un calendario PUBBLICATO per l'anno accademico " + calendar.getAcademicYear());
        }

        // State Transition
        calendar.setStatus(CalendarStatus.PUBLISHED);
        calendar.setPublishedAt(LocalDateTime.now());

        return SchoolCalendarMapper.toDetailDTO(calendarRepository.save(calendar));
    }

    @Override
    public SchoolCalendarDetailResponseDTO updateDraft(Long id, SchoolCalendarUpdateRequestDTO dto) {
        SchoolCalendar calendar = calendarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Calendario non trovato"));

        // *GUARD: Shield mutations on non-draft entities
        if (calendar.getStatus() != CalendarStatus.DRAFT) {
            throw new CalendarValidationException("Operazione negata: Il calendario non è modificabile in quanto già pubblicato.");
        }

        // Proceed with update payload mapping...
        return SchoolCalendarMapper.toDetailDTO(calendarRepository.save(calendar));
    }
}

```

### B. Angular Detail Component & Lifecycle Handlers (`SchoolCalendarDetailComponent`)

The frontend component handles the new publication lifecycle, disables controls dynamically when `isReadOnly` is active, and prevents concurrent double-submissions via dedicated state flags (`isPublishing`, `isDeleting`).

```typescript
// *FEAT: Publication and Read-Only Guards in SchoolCalendarDetailComponent
export class SchoolCalendarDetailComponent implements OnInit {
  isPublishing = false;
  isDeleting = false;
  calendar: SchoolCalendarDetailResponseDTO | null = null;

  get isReadOnly(): boolean {
    return this.calendar?.status !== 'DRAFT';
  }

  get isCalendarValidForPublish(): boolean {
    if (!this.calendar || !this.calendarId || this.isReadOnly || this.isPublishing || this.isGenerating || this.isSaving) {
      return false;
    }
    return !!(this.calendar.generatedDays && this.calendar.generatedDays.length > 0);
  }

  onPublishCalendar(): void {
    if (!this.isCalendarValidForPublish || !this.calendarId) return;

    this.isPublishing = true;
    this.hasError = false;

    this.calendarService.publishSchoolCalendar(this.calendarId)
      .pipe(finalize(() => this.isPublishing = false))
      .subscribe({
        next: (response) => {
          if (response?.data) {
            this.calendar = response.data; // Response reflects new 'PUBLISHED' status
          } else {
            this.handleActionError("ATTENZIONE ! Errore durante la pubblicazione del calendario.");
          }
        },
        error: (err) => {
          const backendMsg = err?.error?.message || err?.error?.detail;
          this.handleActionError(backendMsg || "Impossibile pubblicare il calendario. Riprova più tardi.");
        }
      });
  }
}

```

---

## Testing and Verification Summary

Unit tests, backend integration suites, and Postman API verifications confirm 100% logic coverage and exact execution behavior.

### A. Backend Unit & Validation Impact

Unit tests were written and executed covering 100% of the newly added publishing and mutation guard logic:


Impact tests on **IMPACT FE**:

![SchCalDef ImpactFE](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/d3d4728ce25516c3d3ec8bb5e628cc52e1cb4db1/Stage%20-%20NTT%20Data/assets/images/SchoolCalendar%20Definition%20-%20IMPACTBE.png)

---

Gived test of FE:

![SchCalDef TestFE](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/d3d4728ce25516c3d3ec8bb5e628cc52e1cb4db1/Stage%20-%20NTT%20Data/assets/images/SchoolCalendar%20Definition%20-%20TESTBe.png)

### B. Postman Integration Payload Verification

API behavior, HTTP 200/400 status codes, and JSON response DTO structures were validated via Postman for the publication endpoint (`POST /api/supplenti-bo/school-calendars/{id}/publish`):


![SchCalDef PostManPayLoad](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/d3d4728ce25516c3d3ec8bb5e628cc52e1cb4db1/Stage%20-%20NTT%20Data/assets/images/SchoolCalendar%20Definition%20-%20ResultJSON.png)

---

### Test Results

| Integration Layer | Validation Context | Expected Outcome | Status | Verification Note |
| --- | --- | --- | --- | --- |
| **Unit Tests (JUnit 5)** | Execution of `publishSchoolCalendar()` guards | `100% Guard Coverage` | ✅ PASSED | Correctly throws `CalendarValidationException` on missing days or non-draft status. |
| **Academic Year Guard** | Duplicate `PUBLISHED` status check | Exception Triggered | ✅ PASSED | `existsByAcademicYearAndStatusAndIdNot` blocks duplicate active calendars. |
| **Postman API Test** | `POST /api/supplenti-bo/school-calendars/{id}/publish` | `HTTP 200 OK` + Status Update | ✅ PASSED | Status updated to `PUBLISHED`, returning updated entity structure. |
| **FE Mutation Shield** | Attempted header/rules edit post-publish | Inputs Disabled | ✅ PASSED | `isReadOnly` evaluation locks UI forms and action buttons completely. |
| **FE Integration** | Integration of SCHCAL-14 & SCHCAL-15 | Clean Unified Build | ✅ PASSED | End-to-end alignment verified between BE resource endpoints and FE services. |

---

## Conclusion & Next Steps

This task completes the core lifecycle management and API security layer for the School Calendar module. By isolating Back-Office endpoints, introducing strict domain publication guards, and enforcing read-only states in the UI shell, the system provides a robust, collision-free calendar workflow.


