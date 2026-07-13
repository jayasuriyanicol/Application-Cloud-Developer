// ?proroga-warning-dialog.component.ts (Refactored Component Architecture)
import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-proroga-warning-dialog',
  standalone: true,
  imports: [MatButtonModule, MatIconModule],
  templateUrl: './proroga-warning-dialog.component.html',
  styles: [`
    /* Clean, encapsulated local component layouts with no global DOM leakage */
    .custom-modern-alert {
      display: flex;
      flex-direction: column;
      background: #ffffff;
      box-sizing: border-box;
    }
    .alert-main-body {
      display: flex;
      gap: 16px;
      padding: 24px 24px 20px 24px;
    }
  `]
})
// ?FIXED: Explicitly exported as a TypeScript module to allow seamless compilation across layout layers
export class ProrogaWarningDialogComponent {
  constructor(public readonly dialogRef: MatDialogRef<ProrogaWarningDialogComponent>) {}
}




// ?HTML:proroga-warning-dialog.component.html (Refactored Component Architecture)

/* <!-- proroga-dialog.component.html (Refactored Form with Functional Preview Controls) -->
<div class="proroga-container">
  <mat-form-field appearance="outline" class="date-field">
    <mat-label>Nuova data fine (senza ferie)*</mat-label>
    <input matInput [matDatepicker]="picker" [(ngModel)]="nuovaDataFineSenzaFerie">
    <mat-datepicker-toggle matIconSuffix [for]="picker"></mat-datepicker-toggle>
    <mat-datepicker #picker></mat-datepicker>
  </mat-form-field>

  <!-- Added: Dedicated validation execution interface control button -->
  <button mat-button class="btn-calculate-preview" (click)="onCalcolaPreview()">
    Calcola preview
  </button>

  <div class="actions-row">
    <button mat-button (click)="close()">Annulla</button>
    <button mat-button [disabled]="!isPreviewCalculated" color="primary">Avanti</button>
  </div>
</div>
*/