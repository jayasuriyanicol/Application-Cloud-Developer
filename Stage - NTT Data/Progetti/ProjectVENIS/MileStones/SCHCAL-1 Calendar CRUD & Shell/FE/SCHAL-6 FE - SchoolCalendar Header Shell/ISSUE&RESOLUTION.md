## Solution: UI Integration Calendar SHELL & Gateway Adaptation

To resolve the authorization blocks (`401 Unauthorized`), eliminate payload mapping mismatches, and establish the Angular UI Shell integration, dedicated Backoffice endpoints were exposed and client-side communication adapters were introduced.

```typescript
// *Architectural highlight of the GateService dynamic token injection & RxJS data mapping adapter
@Injectable({ providedIn: 'root' })
export class SchoolCalendarService {
  private readonly apiPath = `${environment.apiBaseUrl}/api/supplenti-bo/school-calendars`;

  constructor(private gateService: GateService) {}

  getCalendarDetail(id: string): Observable<ServiceResponse<SchoolCalendar>> {
    return this.gateService.get<SchoolCalendar>(`${this.apiPath}/${id}`).pipe(
      map((data: SchoolCalendar) => ({
        success: true,
        timestamp: new Date().toISOString(),
        data: data
      }))
    );
  }
}

```

---

## Architectural Cleanup Explained

### 1. Backoffice REST Resource & Security Alignment

The Backoffice entrypoint (`SchoolCalendarBackOfficeResource`) was mapped under `/api/supplenti-bo/school-calendars`. The `POST` endpoint enforces Jakarta Validation via `@Valid` annotations and wraps responses into `ServiceResponse.success()`.

To prevent security bypasses or modifications to `WebSecurityConfig`, the frontend was refactored to route calls dynamically through `GateService`, ensuring automated Bearer Token injection on every HTTP request.

```java
@RestController
@RequestMapping("/api/supplenti-bo/school-calendars")
@Validated
public class SchoolCalendarBackOfficeResource {

    private final SchoolCalendarService schoolCalendarService;

    public SchoolCalendarBackOfficeResource(SchoolCalendarService schoolCalendarService) {
        this.schoolCalendarService = schoolCalendarService;
    }

    @PostMapping
    public ResponseEntity<ServiceResponse<SchoolCalendarDTO>> createDraft(
            @Valid @RequestBody SchoolCalendarCreateRequestDTO requestDto) {
        
        SchoolCalendarDTO createdDraft = schoolCalendarService.createDraft(requestDto);
        return ResponseEntity.ok(ServiceResponse.success(createdDraft));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolCalendarDTO> getDetail(@PathVariable("id") Long id) {
        SchoolCalendarDTO calendarDetail = schoolCalendarService.findById(id);
        return ResponseEntity.ok(calendarDetail);
    }
}

```

### 2. RxJS Adapter & Provisional UI Shell Isolation

Because the backend `GET /{id}` detail query reads directly from Hibernate persistence and returns a raw DTO entity, an RxJS `map` operator was introduced inside `SchoolCalendarService` to encapsulate the payload into a generic `ServiceResponse<T>` on the fly.

Additionally, a provisional UI Shell component (`SchoolCalendarShellComponent`) was integrated into Angular route maps to unblock the issue, complete with dedicated loading and error fallback states.

```typescript
@Component({
  selector: 'app-school-calendar-shell',
  templateUrl: './school-calendar-shell.component.html',
  styleUrls: ['./school-calendar-shell.component.scss']
})
export class SchoolCalendarShellComponent implements OnInit {
  calendarDetail?: SchoolCalendar;
  isLoading = true;
  hasError = false;

  constructor(private route: ActivatedRoute, private calendarService: SchoolCalendarService) {}

  ngOnInit(): void {
    const calendarId = this.route.snapshot.paramMap.get('id');
    if (calendarId) {
      this.calendarService.getCalendarDetail(calendarId).subscribe({
        next: (resp) => { this.calendarDetail = resp.data; this.isLoading = false; },
        error: () => { this.hasError = true; this.isLoading = false; }
      });
    }
  }
}

```

---

## TEST

Following the completion of the GateService integration and RxJS adapter implementation, a suite of automated frontend tests, browser console security checks, and shell route validations was executed.

### Result on the FE & Security Gateway

Unit tests executed across all modified Angular components verified module integrity and provider stability:

Console and browser diagnostics confirmed active Bearer Token injection via `GateService` without requiring backend security changes:

### Test Results

| Integration Layer | Validation Context | Expected Outcome | Status | Verification Note |
| --- | --- | --- | --- | --- |
| **Frontend Unit Tests** | Component creation & updated service files | `100% Passed` | ✅ PASSED | All Angular components instantiate cleanly without dependency errors |
| **Console & Security** | Token generation via `GateService` | Dynamic Bearer Token injected | ✅ PASSED | Request authorized without altering backend `WebSecurityConfig` |
| **RxJS Data Adapter** | `GET /{id}` detail retrieval | Raw DTO converted to `ServiceResponse` | ✅ PASSED | Client-side mapping populates `success` metadata and `data` wrapper |
| **UI Shell Route** | Page navigation & layout rendering | Rendered provisional UI Shell | ✅ PASSED | Displays details properly; fallback error state handles API failures |

---

## Outcome

The system successfully unblocks end-to-end communication for the Backoffice School Calendar module. By coupling dynamic `GateService` authentication with client-side RxJS payload mapping and valid Angular route bindings, the integration eliminates authorization errors while providing an operational UI Shell baseline.

The complete codebase updates were aggregated into a singular feature commit, keeping historical source control branches optimal and fully integrated within remote staging pipelines.