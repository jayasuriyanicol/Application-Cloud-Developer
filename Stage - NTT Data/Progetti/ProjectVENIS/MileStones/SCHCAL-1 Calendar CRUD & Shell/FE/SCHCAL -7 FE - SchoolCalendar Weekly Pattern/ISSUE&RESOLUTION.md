## Solution: UI Creation & Integration Weekly Toggle Form SHELL

In order to resolve data persistence conflicts during weekly pattern updates (`DataIntegrityViolationException`), ensure secure token propagation through the Gateway (`401 Unauthorized`), and enable interactive day toggles in the Angular UI Shell, dedicated Backoffice updates were applied and standalone Angular components were integrated with client-side mapping adapters.

```typescript
// *Architectural highlight of WeeklyPatternEditorComponent handling reactive day toggles and output events
@Component({
  selector: 'app-weekly-pattern-editor',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './weekly-pattern-editor.component.html',
  styleUrls: ['./weekly-pattern-editor.component.css']
})
export class WeeklyPatternEditorComponent implements OnChanges {
  @Input() pattern: any = null;
  @Input() isReadOnly: boolean = false;
  @Output() onPatternSave = new EventEmitter<any>();

  days: DayToggle[] = [
    { key: 'monday', label: 'Lunedì', value: true },
    { key: 'tuesday', label: 'Martedì', value: true },
    { key: 'wednesday', label: 'Mercoledì', value: true },
    { key: 'thursday', label: 'Giovedì', value: true },
    { key: 'friday', label: 'Venerdì', value: true },
    { key: 'saturday', label: 'Sabato', value: false },
    { key: 'sunday', label: 'Domenica', value: false }
  ];

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['pattern'] && this.pattern) {
      this.mapDtoToToggles(this.pattern);
    }
  }

  private mapDtoToToggles(dto: any): void {
    this.days.forEach(day => {
      if (dto.hasOwnProperty(day.key)) {
        day.value = !!dto[day.key];
      }
    });
  }

  savePattern(): void {
    if (this.isReadOnly) return;

    const updatedPattern: any = {};
    this.days.forEach(day => {
      updatedPattern[day.key] = day.value;
    });

    this.onPatternSave.emit(updatedPattern);
  }
}

```

---

## Architectural Cleanup Explained

### 1. Database Flush & Backoffice Persistence Policy (BE)

Updating the weekly working pattern and regenerating calendar days previously raised a `DataIntegrityViolationException` due to duplicate key constraints on existing calendar day entries.

To resolve this, the backend persistence service explicitly executes a `deleteByCalendarId(calendarId)` operation paired with an immediate `flush()` call via `EntityManager` before inserting the updated payload, preserving relational integrity across the transaction.

```java
@Transactional
public SchoolCalendarDetailResponseDTO updateWeeklyPattern(Long calendarId, SchoolCalendarUpdateRequestDTO dto) {
    SchoolCalendar calendar = schoolCalendarRepository.findById(calendarId)
            .orElseThrow(() -> new EntityNotFoundException("Calendar not found"));

    if (calendar.isPublished()) {
        throw new IllegalStateException("Cannot modify a PUBLISHED calendar");
    }

    // Explicit flush to clear stale daily entries prior to pattern regeneration
    calendarDayRepository.deleteByCalendarId(calendarId);
    calendarDayRepository.flush();

    calendar.updatePatternAndRegenerateDays(dto.getDefaultWorkingPattern());
    return schoolCalendarMapper.toDetailDto(schoolCalendarRepository.save(calendar));
}

```

### 2. Angular Service Adapter & GateService Integration (FE)

To eliminate `401 Unauthorized` responses and resolve route mappings dynamically, `SchoolCalendarService` delegates all HTTP requests to `GateService`. Custom RxJS `map` pipelines transform raw backend DTOs into standard `ServiceResponse<T>` envelopes.

```typescript
// *FEAT: Service methods to handle detail retrieval and weekly pattern mutation through GateService
@Injectable({ providedIn: 'root' })
export class SchoolCalendarService {
  constructor(private gateService: GateService) {}

  find(id: number): Observable<ServiceResponse<SchoolCalendarDetailResponseDTO>> {
    const endpointTemplate = environment.getSchoolCalendarById;
    const url = endpointTemplate.replace(':id', id.toString());

    return this.gateService.get<SchoolCalendarDetailResponseDTO>(url).pipe(
      map(dto => ({
        data: dto,
        meta: {
          success: true,
          timestamp: new Date().toISOString()
        }
      }))
    );
  }

  update(id: number, payload: any): Observable<ServiceResponse<SchoolCalendarDetailResponseDTO>> {
    const endpointTemplate = environment.updateSchoolCalendar;
    const url = endpointTemplate.replace(':id', id.toString());

    return this.gateService.put<SchoolCalendarDetailResponseDTO>(url, true, payload).pipe(
      map(dto => ({
        data: dto,
        meta: {
          success: true,
          timestamp: new Date().toISOString()
        }
      }))
    );
  }
}

```

### 3. Shell Event Handling & Reactive State Updates (FE)

The parent Shell container processes the `onPatternSave` output event emitted by `WeeklyPatternEditorComponent`. It constructs the full mutation payload and invokes `calendarService.update()`, managing loading and error states reactively.

```typescript
// *FEAT: Parent Shell handler managing pattern save event emission and UI state synchronization
handlePatternSave(updatedPattern: any): void {
  if (!this.calendar) return;

  this.isLoading = true;
  this.hasError = false;

  const payload = {
    name: this.calendar.name,
    academicYear: this.calendar.schoolYear,
    startDate: this.calendar.startDate,
    endDate: this.calendar.endDate,
    defaultWorkingPattern: updatedPattern
  };

  this.calendarService.update(this.calendarId, payload)
    .pipe(
      finalize(() => this.isLoading = false)
    )
    .subscribe({
      next: (response: any) => {
        if (response && response.data) {
          this.calendar = response.data;
        } else {
          this.handleError("ATTENZIONE ! Errore durante l'aggiornamento del pattern settimanale.");
        }
      },
      error: (_err: any) => {
        this.hasError = true;
        this.handleError("Impossibile aggiornare il pattern settimanale del calendario.");
      }
    });
}

```

---

## TEST

1. Here the sum-up of the IMPACT test **ALL PASSED:**

1A. FE TEST:

![SchCalWeek IMPACTFE](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/1943796688e300bf3e97bed3f7094843d57f5024/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20Week-%20ImpactFE.png)


---
1B.  BE TEST:

![SchCalWeek IMPACTBE](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/1943796688e300bf3e97bed3f7094843d57f5024/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20Week-%20ImpactBE.png)

---

2. Here the RESULT on FE:

![SchCalWeek ViewCalShell](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/1943796688e300bf3e97bed3f7094843d57f5024/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20Week-%20ResultFE.png)


---

3. TEST BE, result:

![SchCalWeek TESTBE](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/1943796688e300bf3e97bed3f7094843d57f5024/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20Week-%20TestBE.png)

---


### Result on the FE & Security Gateway

Unit tests executed across all modified Angular components verified module integrity and provider stability:

Console and browser diagnostics confirmed active Bearer Token injection via `GateService` without requiring backend security changes:

### Test Results

| Integration Layer | Validation Context | Expected Outcome | Status | Verification Note |
| --- | --- | --- | --- | --- |
| **Frontend Unit Tests** | `WeeklyPatternEditorComponent` & Service updates | `100% Passed` | ✅ PASSED | All standalone components and services instantiate cleanly without dependency errors |
| **Console & Security** | Token generation via `GateService` | Dynamic Bearer Token injected | ✅ PASSED | Request authorized without altering backend `WebSecurityConfig` |
| **RxJS Data Adapter** | `find()` & `update()` execution | Raw DTO converted to `ServiceResponse` | ✅ PASSED | Client-side mapping populates `meta` success flags and wraps payload in `data` |
| **UI Shell Route** | Weekly pattern toggle & save emission | State updated & persisted to DB | ✅ PASSED | Real-time toggle binding updates state and triggers `handlePatternSave()` without DB errors |

---

## Outcome

The system successfully unblocks end-to-end communication for the Backoffice School Calendar Weekly Toggle module. By coupling explicit backend `EntityManager` flushing with standalone Angular components (`WeeklyPatternEditorComponent`) and dynamic `GateService` routing, the integration eliminates constraint violations and authorization failures while delivering a reactive UI experience.

The complete codebase updates were aggregated into a singular feature commit, keeping historical source control branches optimal and fully integrated within remote staging pipelines.