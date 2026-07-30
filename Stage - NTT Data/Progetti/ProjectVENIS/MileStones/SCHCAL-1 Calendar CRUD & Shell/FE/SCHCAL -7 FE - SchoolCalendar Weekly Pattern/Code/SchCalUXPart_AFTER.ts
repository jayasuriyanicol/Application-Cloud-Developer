
<!-- BUTTON GESTIONE DEL PATTERN SETTIMANALE -->


<!-- Gestione PATTERN con status PUBLISHED -->
<div class="weekly-pattern-container">
  <div class="d-flex justify-content-between align-items-center border-bottom pb-2 mb-3">
    <h2 class="h5 mb-0">Configurazione Pattern Settimanale</h2>
    <span *ngIf="isReadOnly" class="badge bg-lock text-secondary border d-flex align-items-center gap-1">

    </span>
  </div>

  <p class="text-muted small mb-4">
    Seleziona i giorni lavorativi standard della settimana per questo calendario scolastico.
  </p>

  <!-- WEEK TOGGLE PER OGNI GIORNO DELLA SETTIMANA SECONDO PATTERN -->
  <div class="row g-3 my-2">
    <div class="col-6 col-sm-4 col-md-3" *ngFor="let day of days">
      <div class="form-check form-switch p-3 border rounded bg-light d-flex justify-content-between align-items-center">
        <label class="form-check-label fw-semibold ps-0" [for]="day.key">
          {{ day.label }}
        </label>
        <input
          class="form-check-input ms-0"
          type="checkbox"
          [id]="day.key"
          [(ngModel)]="day.value"
          [disabled]="isReadOnly"
        >
      </div>
    </div>
  </div>

  <!-- BUTTON SALVA MODIFICHE PATTERN SETTIMANALE  -->
  <div class="d-flex justify-content-end mt-4 pt-2 border-top" *ngIf="!isReadOnly">
    <button
      type="button"
      class="btn btn-primary d-flex align-items-center gap-2"
      (click)="savePattern()"
    >
      Salva Pattern Settimanale
    </button>
  </div>
</div>