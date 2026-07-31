
##  SOLUTION: Created the link from BE to FE button

The system was updated across both backend and frontend layers to guarantee atomic, lifecycle-compliant calendar regenerations:

### A. Dedicated REST Endpoint & Service Lifecycle Guard (BE)

A dedicated Backoffice endpoint was introduced, routing requests into `SchoolCalendarCommandServiceImpl` where a strict status check guarantees execution only on `DRAFT` entities:

```java
@RestController
@RequestMapping("/api/supplenti-bo/school-calendars")
@Validated
public class SchoolCalendarBackOfficeResource {

    private final SchoolCalendarService schoolCalendarService;

    public SchoolCalendarBackOfficeResource(SchoolCalendarService schoolCalendarService) {
        this.schoolCalendarService = schoolCalendarService;
    }

    @PostMapping("/{id}/regenerate")
    public ResponseEntity<ServiceResponse<SchoolCalendarDetailResponseDTO>> regenerateCalendar(@PathVariable("id") Long id) {
        SchoolCalendarDetailResponseDTO regeneratedCalendar = schoolCalendarService.regenerateCalendarDays(id);
        return ResponseEntity.ok(ServiceResponse.success(regeneratedCalendar));
    }
}

```

```java
@Override
@Transactional
public SchoolCalendarDetailResponseDTO regenerateCalendarDays(Long calendarId) {
    SchoolCalendar calendar = schoolCalendarRepository.findById(calendarId)
            .orElseThrow(() -> new EntityNotFoundException("ATTENZIONE! Calendario non trovato"));

    // *GUARD: Reject regeneration if calendar is already PUBLISHED
    if (SchoolCalendarStatus.PUBLISHED.equals(calendar.getStatus())) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ATTENZIONE! Impossibile rigenerare un calendario già PUBBLICATO.");
    }

    // *PURGE: Delete existing daily records and flush persistence context
    calendarDayRepository.deleteByCalendarId(calendarId);
    calendarDayRepository.flush();

    // *REGENERATE: Re-apply operational patterns & rules to generate new daily entries
    calendar.regenerateSchedule();
    SchoolCalendar saved = schoolCalendarRepository.save(calendar);

    return schoolCalendarMapper.toDetailDto(saved);
}

```

### B. Angular Service Method & UI Shell Action (FE)

The client-side service was extended to expose the regeneration endpoint through `GateService`, while `SchoolCalendarDetailComponent` handles the action trigger, managing loading spinners and error feedback:

```typescript
// *FEAT: Dedicated Angular service call for schedule regeneration
@Injectable({ providedIn: 'root' })
export class SchoolCalendarService {
  constructor(private gateService: GateService) {}

  regenerateCalendar(id: number): Observable<ServiceResponse<SchoolCalendarDetailResponseDTO>> {
    const endpointTemplate = `${environment.apiBaseUrl}/api/supplenti-bo/school-calendars/:id/regenerate`;
    const url = endpointTemplate.replace(':id', id.toString());

    return this.gateService.post<SchoolCalendarDetailResponseDTO>(url, {}).pipe(
      map(dto => ({
        data: dto,
        meta: { success: true, timestamp: new Date().toISOString() }
      }))
    );
  }
}

```

```typescript
// *FEAT: UI Shell regeneration action handler with state protection
handleRegenerateCalendar(): void {
  if (!this.calendar || this.isSaving || this.calendar.status === 'PUBLISHED') return;

  this.isSaving = true;
  this.hasError = false;

  this.calendarService.regenerateCalendar(this.calendar.id)
    .pipe(finalize(() => this.isSaving = false))
    .subscribe({
      next: (response) => {
        if (response && response.data) {
          this.calendar = response.data;
        } else {
          this.handleError("ATTENZIONE! Errore durante la rigenerazione del calendario. Riprova.");
        }
      },
      error: () => {
        this.handleError("Impossibile completare la rigenerazione del calendario. Riprova.");
      }
    });
}

```

---

## Testing and Verification Strategy

To verify the integrity of the regeneration workflow, all unit test suites and build pipelines were updated and executed:

--- 

TEST IMPACT:


![SchCalRegBut ImpactFE](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/c17bc6d937deb9b116a859d5b3aed80f1866826d/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarRegenerate%20-%20ImpactFE.png)
---

TEST FE INTERNAL:

![SchCalRegBut TestFE](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/c17bc6d937deb9b116a859d5b3aed80f1866826d/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarRegenerate%20-%20TestFE.png)


---

RESULT FE:

![SchCalRegBut ResultFE](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/c17bc6d937deb9b116a859d5b3aed80f1866826d/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarRegenerate%20-%20ResultFE.png)



### Test Results

| Integration Layer | Validation Context | Expected Outcome | Status | Verification Note |
| --- | --- | --- | --- | --- |
| **Angular Unit Tests** | `ng test` execution across updated specs | `100% Passed` | ✅ PASSED | All component and service spec suites passed cleanly without unhandled rejections |
| **Angular Production Build** | `ng build --configuration production` | Compilation Success | ✅ PASSED | Build completed with zero type errors, template warnings, or missing dependencies |
| **Backend Integration Tests** | `JUnit 5 / MockMvc` POST `/{id}/regenerate` | `200 OK` on DRAFT | ✅ PASSED | Confirms old day entries are purged and new schedule is computed as expected |
| **Status Guard Check** | Trigger regeneration on `PUBLISHED` entity | `400 Bad Request` | ✅ PASSED | Request is correctly blocked by service guard prior to database deletion |
| **FE UI UX Validation** | User clicks "Rigenera Calendario" in UI Shell | UI updates & re-renders | ✅ PASSED | Loading state activates, API returns recalculated DTO, and table views refresh dynamically |
