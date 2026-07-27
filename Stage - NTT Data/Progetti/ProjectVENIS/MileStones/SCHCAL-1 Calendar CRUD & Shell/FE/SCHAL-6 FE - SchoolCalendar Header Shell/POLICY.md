
# Java Spring Boot & Angular – School Calendar Shell Integration

---

<p align="center">
  <img src="https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/project/emea/shared/global-logo/globallogo_nttdata_white.png?hash=" alt="NTT DATA Logo" width="300"/>
</p>

---

## ⚠️ Corporate Disclaimer & Privacy Policy

> **PROPERTY OF NTT DATA Italia - Gov&Tech**
> This repository/documentation is strictly **private** and intended exclusively for internal knowledge sharing, technical documentation, and personal educational tracking.

> All code snippets, architecture flows, and examples contained herein have been deliberately **anonymized, de-contextualized, and sanitized** to remove any proprietary business logic, sensitive package structures, client references, or credentials.

---

## Feature Description (UI Integration Calendar SHELL)

The goal of this feature is to deliver an end-to-end validated Backoffice module for managing the **School Calendar Shell**. This includes exposing dedicated Backoffice endpoints, resolving frontend authentication and response-mapping blocks during detail retrieval, and integrating a prototype UI Shell in Angular.

Through the Backoffice interface, administrators can create preliminary `DRAFT` calendar configurations and navigate directly into the calendar detail shell to manage generated operational days.

```text
Angular UI Shell ──> GateService (Bearer Token) ──> Gateway / API ──> SchoolCalendarBackOfficeResource ──> RxJS Map Wrapper ──> UI Render

```

### Business Rules & Constraints

* **DRAFT Creation Endpoint:** Creation requests must be processed under `/api/supplenti-bo/school-calendars`, protected by `@Valid` annotations, and returned within the standard `ServiceResponse.success()` payload.
* **Gateway & Bearer Authentication:** All detail retrieval calls (`GET /{id}`) originating from Angular must pass through `GateService` using dynamic environment configurations to enforce automated Bearer Token injection without altering `WebSecurityConfig`.
* **Standardized Payload Alignment:** Pure DTOs returned directly by Hibernate persistence queries must be safely wrapped on the frontend to match the application's generic `ServiceResponse` contract.

---

## Initial Architectural Gaps (Why the Shell Integration Failed)

During the initial integration of the frontend calendar shell with the Backoffice backend, three critical architectural blockers were identified:

1. **401 UNAUTHORIZED ERRORS:** `SchoolCalendarService` in Angular was invoking direct backend URLs instead of routing through `GateService`, bypassing automatic Bearer Token injection.
2. **DATA MAPPING MISMATCH:** The backend `GET /{id}` endpoint returned a pure DTO entity directly from Hibernate, whereas the Angular service expected a wrapped `ServiceResponse<T>` object, causing runtime parsing errors.
3. **MISSING BACKOFFICE ROUTE:** The Angular routing module lacked dedicated mappings for the new Backoffice endpoints under `/api/supplenti-bo/school-calendars`.

---

## Structural Root Cause Analysis

An inspection across the API Gateway and Angular service layers highlighted the need for structural alignment:

1. **Hardcoded Service URLs:** Bypassing environment-driven gateway routing meant credentials and tokens were not attached to HTTP request headers.
2. **Contract Asymmetry:** The `POST` endpoint returned a `ServiceResponse` wrapper, but the `GET` detail endpoint returned a unwrapped DTO. Enforcing a unified UI model required handling this asymmetry on the client side.
3. **UI Layout Prototype Status:** The shell view required an initial implementation to support navigation and data fetching, while remaining modular for upcoming UI/UX pattern refinements.

---

## Refactored Architecture & Expected Behavior

The system has been updated to provide seamless end-to-end integration across the API Gateway, Angular Services, and UI components:

### A. Backoffice Resource Exposure (`SchoolCalendarBackOfficeResource`)

The REST entrypoint exposes dedicated endpoints protected by Jakarta Validation and wrapped in the standard enterprise response envelope:

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

### B. Angular Service & RxJS Data Adapter (`school-calendar.service.ts`)

`SchoolCalendarService` was refactored to route requests via `GateService` for automated Bearer Token injection. An RxJS `map` operator wraps the unwrapped backend DTO on the fly:

```typescript
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { GateService } from '@app/core/gate.service';
import { environment } from '@env/environment';
import { ServiceResponse } from '@app/models/service-response.model';
import { SchoolCalendar } from '@app/models/school-calendar.model';

@Injectable({
  providedIn: 'root'
})
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

### C. UI Shell Integration & Route Mapping

The Angular router and detail shell component were updated to consume the wrapped response model and display the active calendar status:

```typescript
@Component({
  selector: 'app-school-calendar-shell',
  templateUrl: './school-calendar-shell.component.html',
  styleUrls: ['./school-calendar-shell.component.scss']
})
export class SchoolCalendarShellComponent implements OnInit {
  calendarDetail?: SchoolCalendar;
  isLoading = true;

  constructor(
    private route: ActivatedRoute,
    private calendarService: SchoolCalendarService
  ) {}

  ngOnInit(): void {
    const calendarId = this.route.snapshot.paramMap.get('id');
    if (calendarId) {
      this.calendarService.getCalendarDetail(calendarId).subscribe({
        next: (response: ServiceResponse<SchoolCalendar>) => {
          this.calendarDetail = response.data;
          this.isLoading = false;
        },
        error: () => {
          this.isLoading = false;
        }
      });
    }
  }
}

```

---

## Testing and Verification Strategy

To guarantee zero-regression and confirm successful end-to-end integration, the following validation steps were completed:

* **Frontend Unit Tests:** Executed test suites across all created and modified components (`ng test` via Vitest) to ensure complete component instantiation and service coverage.
* **Console & Security Diagnostics:** Verified in browser developer tools that requests pass through `GateService`, injecting dynamic Bearer Tokens without requiring modifications to backend `WebSecurityConfig`.
* **Shell Verification:** Confirmed that the preliminary UI Shell renders correctly when bound to active routes, safely transforming pure backend DTOs into expected frontend models.

---

## Technologies Used

* Java 17 / Spring Boot 3
* Spring Data JPA / Hibernate
* Jakarta Validation API (JSR-380)
* Angular 17+ / RxJS
* API Gateway Integration (`GateService`)
* Vitest / Angular Testing Module

---

## Conclusion

This update successfully completes the integration of the Backoffice School Calendar Shell. By routing requests through `GateService`, adapting API payloads with RxJS client-side transformers, and establishing valid route mappings, the system now provides a secure, fully authenticated path for creating and inspecting calendar drafts.