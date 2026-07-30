## Solution: UI Creation & Integration Calendar Header SHELL

In order to create and resolve the authorization blocks (`401 Unauthorized`), eliminate payload mapping mismatches, and establish the Angular UI Shell integration, dedicated Backoffice endpoints were exposed and client-side communication adapters were introduced.

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

1. Here the sum-up of the IMPACT test **ALL PASSED:** 

![SchCalShe IMPACT](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/b7d7adca0cac17499994b19d934863eb70af5b37/Sistemi%20Digitali_/SchoolCalendarShell%20Header%20-%20ImpactFE.png)

---

2. Here the Correct Test's of Header Insertion, to TEST the **ERRORE INLINE:**

![SchCalShe Err1](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/b7d7adca0cac17499994b19d934863eb70af5b37/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20Header%20-%20Error1.png)


---

3. The second error inlinem to check the insertion of **NO CALENDAR NAME:**

![SchCalShe Err2](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/b7d7adca0cac17499994b19d934863eb70af5b37/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20Header%20-%20Error2.png)

---

4. In all this cases, we have the **BUTTON UNTOGGLED**, to prevent any type of incorrect INSERTION:

![SchCalShe Button](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/b7d7adca0cac17499994b19d934863eb70af5b37/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20Header%20-%20UnToggle%20Button.png)

---

5. Result of passed data, **PAYLOAD passed CORRECTLY:**

![SchCalShe ResPayload](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/b7d7adca0cac17499994b19d934863eb70af5b37/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20Header%20-%20ResultPayLoad.png)

---

6. UX Header calendar show up, **FEATURE HEADER INFO:**

![SchCalShe ResHeadUx](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/b7d7adca0cac17499994b19d934863eb70af5b37/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20Header%20-%20Result%20UX.png)

--- 

7. UX/UI In the SchoolCalendarShell, showed up in the page: 

![SchCalShe CalShell](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/b7d7adca0cac17499994b19d934863eb70af5b37/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20Header%20-%20ResultShell.png)

---

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