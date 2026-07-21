## Solution; Creation dedicated page 

To resolve the problem we created a dedicated page to manage the update and visualization of data calendar, as here the 
structure in *HTML* to divide the browser page into div classes.


```html

<div class="calendar-detail-container container-fluid p-4">

  <!-- CARICAMENTO PAGE -->
  <div *ngIf="isLoading" class="d-flex justify-content-center my-5">
    <div class="spinner-border text-primary" role="status">
      <span class="visually-hidden">CARICAMENTO IN CORSO ...</span>
    </div>
  </div>

  <!-- MESSAGGIO NOT FOUND O ERROR -->
  <div *ngIf="hasError && !isLoading"
       class="d-flex justify-content-center align-items-center"
       style="min-height: 60vh; width: 100%;">

    <div class="alert alert-danger text-center" role="alert" style="max-width: 500px; width: 100%;">
      <h4 class="alert-heading">ATTENZIONE NESSUN CALENDARIO TROVATO!</h4>
      <hr>
      <p>{{ errorMessage }}</p>
      <hr>
      <button class="btn btn-outline-danger btn-sm" (click)="loadCalendarDetails()">Riprova</button>
    </div>

  </div>

  <!-- TEMPLATE VISTA CALENDARIO -->
  <div *ngIf="calendar && !isLoading && !hasError" class="calendar-content animate-fade-in">

    <!-- PRIMA SEZIONE: TESTATA CALENDARIO-->
    <header class="calendar-header mb-4 p-3 bg-white border rounded shadow-sm">
      <div class="d-flex justify-content-between align-items-center">
        <div>
          <span class="badge bg-secondary mb-1">{{ calendar.status }}</span>
          <h1 class="h3 mb-0">{{ calendar.name }}</h1>
          <p class="text-muted mb-0">Anno Scolastico: {{ calendar.schoolYear }}</p>
        </div>
        <div class="calendar-dates text-end">
          <span class="d-block"><strong>Inizio:</strong> {{ calendar.startDate | date:'dd/MM/yyyy' }}</span>
          <span class="d-block"><strong>Fine:</strong> {{ calendar.endDate | date:'dd/MM/yyyy' }}</span>
        </div>
      </div>
    </header>

    <div class="row">
      <div class="col-md-8">

        <!-- SECONDA SEZIONE: PATTERN SETTIMANALE -->
        <section class="calendar-section mb-4 p-3 bg-white border rounded shadow-sm">
          <h2 class="h5 border-bottom pb-2 mb-3">Pattern Settimanale (Giorni Lavorativi)</h2>
          <div class="d-flex gap-2 flex-wrap">
            <span class="badge" [ngClass]="calendar.pattern.monday ? 'bg-success' : 'bg-light text-muted'">Lunedì</span>
            <span class="badge" [ngClass]="calendar.pattern.tuesday ? 'bg-success' : 'bg-light text-muted'">Martedì</span>
            <span class="badge" [ngClass]="calendar.pattern.wednesday ? 'bg-success' : 'bg-light text-muted'">Mercoledì</span>
            <span class="badge" [ngClass]="calendar.pattern.thursday ? 'bg-success' : 'bg-light text-muted'">Giovedì</span>
            <span class="badge" [ngClass]="calendar.pattern.friday ? 'bg-success' : 'bg-light text-muted'">Venerdì</span>
            <span class="badge" [ngClass]="calendar.pattern.saturday ? 'bg-success' : 'bg-light text-muted'">Sabato</span>
            <span class="badge" [ngClass]="calendar.pattern.sunday ? 'bg-success' : 'bg-light text-muted'">Domenica</span>
          </div>
        </section>

        <!-- TERZA SEZIONE: REGOLE / FESTIVITÀ -->
        <section class="calendar-section mb-4 p-3 bg-white border rounded shadow-sm">
          <h2 class="h5 border-bottom pb-2 mb-3">Regole e Festività ({{ calendar.rules.length }})</h2>
          <p *ngIf="calendar.rules.length === 0" class="text-muted">ATTENZIONE ! Non risulta nessuna regola configurata per questo calendario.</p>

          <ul *ngIf="calendar.rules.length > 0" class="list-group">
            <li class="list-group-item d-flex justify-content-between align-items-center" *ngFor="let rule of calendar.rules">
              <div>
                <strong>{{ rule.reason }}</strong>
                <span class="text-muted ms-2">({{ rule.ruleType }})</span>
              </div>
              <span class="badge bg-primary rounded-pill">Ordine: {{ rule.ruleOrder }}</span>
            </li>
          </ul>
        </section>

      </div>

      <div class="col-md-4">

        <!-- QUARTA SEZIONE: PREVIEW (Giorni Generati) -->
        <section class="calendar-section mb-4 p-3 bg-white border rounded shadow-sm">
          <h2 class="h5 border-bottom pb-2 mb-3">Preview Giorni Generati ({{ calendar.generatedDays.length }})</h2>
          <p *ngIf="calendar.generatedDays.length === 0" class="text-muted">I giorni per questo calendario non sono ancora stati generati.</p>
          <div *ngIf="calendar.generatedDays.length > 0" class="preview-box" style="max-height: 250px; overflow-y: auto;">
            <div class="d-flex justify-content-between p-2 border-bottom" *ngFor="let day of calendar.generatedDays">
              <span>{{ day.calendarDate | date:'dd/MM/yyyy' }}</span>
              <span class="badge" [ngClass]="day.workingDay ? 'bg-success' : 'bg-danger'">
                 {{ day.workingDay ? 'Lavorativo' : 'Festivo' }}
               </span>
            </div>
          </div>
        </section>

        <!-- TODO: SEZIONE BOTTONI ANCORA DA AGGANCIARE -->
        <section class="calendar-section mb-4 p-3 bg-white border rounded shadow-sm">
          <h2 class="h5 border-bottom pb-2 mb-3">Azioni Disponibili</h2>
          <div class="d-grid gap-2">
            <button class="btn btn-primary" [disabled]="calendar.status !== 'DRAFT'">Genera Giorni</button>
            <button class="btn btn-outline-success" [disabled]="calendar.status !== 'DRAFT'">Pubblica Calendario</button>
            <button class="btn btn-outline-danger" [disabled]="calendar.status !== 'DRAFT'">Elimina Bozza</button>
          </div>
        </section>

      </div>
    </div>

  </div>
</div>

```

## Architectural Follow up with Payload & dedicated Endpoint


### VALIDATION WITH CREATION OF PayLoad with GateService

1. To process every call, we **created a pattern payload** to process the data, in call with a `GateService`

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

```


### VALIDATION WITH CREATION OF PayLoad with GateService

2. To process every call, we **created a dedicated ENDPOINT** to process the data, in call with the `GateService`


```ts
{ path: 'scuole', component: ScuoleListComponent, data: { breadcrumb: 'Gestione scuole' } },

       // *Here the link in configurazione ROUTE, setted also the breadcrumb
      {
        path: 'school-calendars/:id',
        component: SchoolCalendarDetailComponent,
        data: { breadcrumb: 'Dettaglio Calendario Scolastico' }
      }

```

3. Dedicated Endpoint in the **enviroment**

```ts
 getSchoolCalendarById: `${baseUrlApi}/school-calendars/:id`,// GET
 createSchoolCalendar: `${baseUrlApi}/school-calendars`, // POST

```
---

## TEST

Following the implementation we verified the process in order to process correctly the call via ENDPOINT:

### Result on the FE

Impact tests, with green:

![SchCalShell IMPACT](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarList%20-%20ImpactFE.png?raw=true)

---

Result on FE, of the dedicated PAGE

![SchCalShell FE](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20-%20ResultFE.png?raw=true)

---

Tested also the functionalities of validation:

1. Empty field in  `Nome calendario`, that generate a warning inline:

![SchCalShell TEST1 ](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendaShell%20-%20TEST1.png?raw=true)

---

2. Testata calendar form search in `SchoolCalendarDetail` here the good research

![SchCalShell TEST3 ](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20-%20TEST3.png?raw=true)


---

3. Button calendar form search in `Salva Bozza`, if there are some errors like: date incongrunce, empty fields. Prevent the send of message

![SchCalShell TEST2 ](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarShell%20-%20TEST2.png?raw=true)


---

                            

### Test Results

| User Entry Payload (DTO) | Validation Context | Expected Outcome | Status | Verification Note |
| --- | --- | --- | --- | --- |
| **Complete & Valid Fields** | `startDate = 2026-09-01`, `endDate = 2027-06-30` | `200 OK` (Saved as `DRAFT`) | ✅ PASSED | Correctly persists entity and returns the response DTO |
| **`endDate` < `startDate`** | `startDate = 2026-09-01`, `endDate = 2026-08-31` | `400 BAD REQUEST` | ✅ PASSED | Service layer intercepts error; triggers custom warning |
| **Missing `schoolYear`** | `academicYear = ""` or `null` | `400 BAD REQUEST` | ✅ PASSED | `@NotBlank` constraint rejects payload at controller layer |
| **Missing `name`** | `name = ""` or `null` | `400 BAD REQUEST` | ✅ PASSED | `@NotBlank` constraint rejects payload at controller layer |
| **Null Weekly Flags** | `workingMonday = null` | `400 BAD REQUEST` | ✅ PASSED | `@NotNull` constraint enforces presence on `Boolean` wrappers |


##  Outcome

The system successfully handles every distinct backend input behavior. By combining Jakarta Bean Validation constraints with explicit service-level chronological checks, the write-path avoids inconsistent database entries while providing total operational security.

The complete codebase updates were aggregated into a singular feature commit, keeping historical source control branches optimal and fully integrated within remote staging pipelines.