
# Angular – School Calendar Shell dedicated Page
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

## Feature Description (Creation of DRAFT Calendar)

The goal of this feature is to create a dedicated page to manage existing calendars in order to update it, in real time call API via DB.
Only in call with `DRAFT` SchoolCalendar and `PUBLISHED` calendar to interrupt it.

Through it you can dinamically update and see in real time the data present on it.

```text
DB ──> API ──> Validation ──> Convert ──> FE page 

```

### Business Rules & Constraints

* **DRAFT constraint:** Every type of calendar you can update it only in `DRAFT` mode
* **DATA:** Cohesion with the given data, present on DB row
* **CHECK & VALIDATION:** Every field in the Shell is validated to avoid any type of inconsistence.

---

## Initial Architectural Gaps (Why the Draft Feature Failed)

The initial system architecture no supported the read-only/update page for existing calendars. Transitioning to a write model highlighted three core missing components:

1. **NO ENDPOINT:** The `SchoolCalendar Page` lacked of a dedicated ENDPOINT with the no possibility of UPDATE  SchoolCalendar in DRAFT mode.
2. **NO VALIDATION:** The incoming parameters had no syntactic sanitization, allowing empty strings, null dates, or incomplete weekly patterns to reach the database layer.

---

## Structural Root Cause Analysis

An inspection of the structural layers showed that the write-path needed a complete alignment:

1. **DTO Unique:** report all the BE present DTO to Angular interface.
2. **VALIDATION:** Directly saving mapped entities without transactional encapsulation or explicitly forcing the `DRAFT` state risked creating inconsistent calendars that bypassed the lifecycle rules (e.g., creating pre-published calendars).
3. **ANNOTATIONS:** Auto-generated target properties on the JPA entity triggered compiler alerts because MapStruct by default flags any target property that isn't explicitly mapped or ignored.

---

## Refactored Architecture & Expected Behavior

The system has been updated to handle the write-path gracefully through a robust multi-layered architecture:

### A. Report BE (DTO)

```ts
export interface DefaultWorkingPatternDTO {
  monday: boolean;
  tuesday: boolean;
  wednesday: boolean;
  thursday: boolean;
  friday: boolean;
  saturday: boolean;
  sunday: boolean;
}

export interface SchoolCalendarRuleDTO {
  id: number;
  ruleType: string;
  ruleOrder: number;
  startDate?: string;
  endDate?: string;
  singleDate?: string;
  reason: string;
}

export interface PublishedSchoolCalendarDayDTO {
  calendarDate: string;
  workingDay: boolean;
  redDay: boolean;
  sourceType: string;
  reason?: string;
  generatedFromRule?: number;
}

export interface SchoolCalendarDetailResponseDTO {
  id: number;
  schoolYear: string;
  name: string;
  startDate: string;
  endDate: string;
  status: 'DRAFT' | 'PUBLISHED' | 'ARCHIVED';
  basedOnCalendarId?: number;
  createdAt?: string;
  updatedAt?: string;
  publishedAt?: string;

  pattern: DefaultWorkingPatternDTO;
  rules: SchoolCalendarRuleDTO[];
  generatedDays: PublishedSchoolCalendarDayDTO[];
}

```

#### BE Persistence & Business Logic (Service Implementation)

To avoid database constraint violations (`DataIntegrityViolationException`) during updates, the backend logic ensures that existing days are deleted and immediately pushed to the persistent layer before new entries are re-generated.

```java
@Transactional
@Override
public SchoolCalendarResponseDTO update(Long id, SchoolCalendarUpdateDTO dto) {
    // 1. Fetch current entity
    SchoolCalendar calendar = schoolCalendarRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Calendar not found"));
    
    // 2. Clear previously generated days to prevent Unique Key conflicts
    schoolCalendarDayRepository.deleteByCalendarId(id);
    schoolCalendarDayRepository.flush(); // Forces synchronous execution on DB
    
    // 3. Map new data and re-generate days
    calendarMapper.updateEntityFromDto(dto, calendar);
    this.generateCalendarDays(calendar);
    
    return calendarMapper.toResponseDto(schoolCalendarRepository.save(calendar));
}

```

### B. SERVICE METHOD Dedicated to search and update the calendars

```ts
constructor(private gateService: GateService, private http: HttpClient) {}

// ?FEAT: method used to gain the calendar from DB and transformed into DTO
find(id: number): Observable<ServiceResponse<SchoolCalendarDetailResponseDTO>> {
  const endpointTemplate = environment.getSchoolCalendarById;
  const url = endpointTemplate.replace(':id', id.toString());

  // *Used a pipeline to process correctly the data as the system security want, otherwise ERROR
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

// ?FEAT: PUT method to update both Header details and Weekly Pattern configurations
update(id: number, payload: any): Observable<ServiceResponse<SchoolCalendarDetailResponseDTO>> {
  const endpointTemplate = environment.updateSchoolCalendar; 
  const url = endpointTemplate.replace(':id', id.toString());

  // Explicitly passing true for Authorization parameters through GateService wrapper
  return this.gateService.put<SchoolCalendarDetailResponseDTO>(url, payload, true).pipe(
    map(dto => ({
      data: dto,
      meta: {
        success: true,
        timestamp: new Date().toISOString()
      }
    }))
  );
}

```

### C. SchoolCalendarDetailComponent validation of SERVICE

```ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SchoolCalendarService } from '@app/services/school-calendar.service';
import { SchoolCalendarDetailResponseDTO } from '@app/models/scuola.model';
import { finalize } from 'rxjs/operators';
import { CommonModule } from '@angular/common';
import { SchoolCalendarHeaderFormComponent } from '@app/pages/configurazioni/scuole/components/school-calendar-header-form/school-calendar-header-form.component';
import { WeeklyPatternEditorComponent } from '@app/pages/configurazioni/scuole/components/weekly-pattern-editor/weekly-pattern-editor.component';

@Component({
  selector: 'app-school-calendar-detail',
  standalone: true,
  imports: [
    CommonModule, 
    SchoolCalendarHeaderFormComponent, 
    WeeklyPatternEditorComponent
  ], // Forms modules omitted in parent shell to avoid redundant imports on architecture
  templateUrl: './school-calendar-detail.component.html',
  styleUrls: ['./school-calendar-detail.component.css']
})
export class SchoolCalendarDetailComponent implements OnInit {
  calendarId!: number;
  calendar: SchoolCalendarDetailResponseDTO | null = null;

  // *Managing the page cases MESSAGES
  isLoading = false;
  hasError = false;
  isNotFound = false; // Distinguishes 404 resource errors from global state failures
  errorMessage = '';

  constructor(
    private route: ActivatedRoute,
    private calendarService: SchoolCalendarService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params: any) => {
      const idParam = params['id'];

      // Protection block against invalid or non-numeric path IDs (e.g. /abc)
      if (!idParam || isNaN(Number(idParam))) {
        this.isNotFound = true;
        this.handleError('ID calendario non valido.');
        return;
      }

      this.calendarId = +idParam;
      if (this.calendarId) {
        this.loadCalendarDetails();
      }
    });
  }

  loadCalendarDetails(): void {
    this.isLoading = true;
    this.hasError = false;
    this.isNotFound = false;

    this.calendarService.find(this.calendarId)
      .pipe(
        finalize(() => this.isLoading = false)
      )
      .subscribe({
        next: (response: any) => {
          if (response && response.data) {
            this.calendar = response.data;
          } else {
            this.handleError('ERRORE ! I dati inseriti non risultano validi !.');
          }
        },
        error: (err: any) => {
          if (err.status === 404) {
            this.isNotFound = true;
            this.handleError('Nessun calendario trovato con l\'ID specificato.');
          } else {
            this.hasError = true;
            this.handleError('ERRORE nel caricamento del calendario o calendario NON ESISTENTE');
          }
        }
      });
  }

  private handleError(message: string): void {
    this.errorMessage = message;
    this.calendar = null;
  }

  // *FEAT: service method to handle the TESTATA calendar, passing the payload and update it
  handleHeaderSave(updatedValues: any): void {
    if (!this.calendar) return;
    this.isLoading = true;
    this.hasError = false;

    const payload = {
      name: updatedValues.name,
      academicYear: updatedValues.schoolYear,
      startDate: updatedValues.startDate,
      endDate: updatedValues.endDate,
      defaultWorkingPattern: this.calendar.pattern || null
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
            this.handleError("ATTENZIONE ! Errore durante il salvataggio dei dati della testata.");
          }
        },
        error: (_err: any) => {
          this.hasError = true;
          this.handleError("Impossibile aggiornare il calendario. Controlla i dati inseriti.");
        }
      });
  }

  // *FEAT: service method to handle the WEEKLY PATTERN component output toggle
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
}

```

---

## Testing and Verification Strategy

To guarantee zero-regression, a complete testing suite:

1. *IMPACT FE*: To test if all the data correctly match and run 

---

## Technologies Used

* Java 17 / Spring Boot 3
* Spring Data JPA / Hibernate
* MapStruct (Component Model Spring)
* Jakarta Validation API (JSR-380)
* PostgreSQL
* Lombok
* Angular / TypeScript / RxJS

---

## Conclusion

This implementation completes the design pattern used in our enterprise architecture. By separating the read models from the write models, introducing explicit MapStruct mapping exclusions, and enforcing transactional service-level validations, the calendar generation path is now stable, safe, and perfectly aligned with our team's coding standard.

```

```