# BEFORE: Monolithic & Inefficient Logic, Missing UI Controls & Global Style Leakage

---

## 1. Component Architecture & Backend Refactoring (`Java` & `TypeScript`)

In the initial implementation, the logic to evaluate whether a contract extension exceeded the school calendar limits was architecturally disaligned. Both domain and calculation services fetched the entire collection of school calendars from the database into JVM memory to perform application-side stream filtering. Furthermore, the frontend dialog component lacked proper class encapsulation, causing compilation issues during local file imports.

```typescript
// proroga-warning-dialog.component.ts (Legacy Monolithic & Broken Import Approach)
import { Component, ViewEncapsulation } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-proroga-warning-dialog',
  standalone: true,
  imports: [MatButtonModule, MatIconModule],
  templateUrl: './proroga-warning-dialog.component.html',
  styles: [`
    /* Dangerous unencapsulated global overlay modification overrides */
    .cdk-overlay-pane:has(.custom-modern-alert) {
      max-width: 440px !important;
      width: 440px !important;
    }
    .cdk-overlay-pane:has(.custom-modern-alert) mat-dialog-container {
      padding: 0 !important;
      border-radius: 16px !important;
    }
  `]
})
// Missing the 'export' keyword, declaring the component locally and breaking external wizard modules
public class ProrogaWarningDialogComponent {
  constructor(public readonly dialogRef: MatDialogRef<ProrogaWarningDialogComponent>) {}
}

```

```java
// ContrattoProrogaDomainService.java (Legacy In-Memory Filtering Approach)
@Service
@RequiredArgsConstructor
public class ContrattoProrogaDomainService {
    private final SchoolCalendarRepository schoolCalendarRepository;

    public ProrogaCalculationResult calculate(...) {
        // Hydrating all records into memory to find a single entry
        List<SchoolCalendar> allCalendars = schoolCalendarRepository.findAll();
        
        SchoolCalendar activeCalendar = allCalendars.stream()
            .filter(c -> c.getStatus() == SchoolCalendarStatus.PUBLISHED)
            .max(Comparator.comparing(SchoolCalendar::getEndDate))
            .orElseThrow(() -> new BusinessRuleException("CALENDARIO_PUBBLICATO_NOT_FOUND", "..."));
            
        // Subsequent extension checking logic...
    }
}

```

---

## 2. Layout Integration & Missing UI Controls (`HTML` & `CSS`)

The initial UI completely lacked any validation or preview execution buttons for contract extensions, making it impossible to handle temporary fallbacks. To bridge this gap, custom extension controls were integrated; however, the styles were injected directly within the component's style scope without structural boundaries. This caused severe global style leakage, shifting layout components and warping the dimensions, paddings, and border-radii of every unrelated Angular Material dialog window across the application ecosystem.

```html
<!-- proroga-dialog.component.html (Legacy Form - Missing Execution Controls) -->
<div class="proroga-container">
  <mat-form-field appearance="outline" class="date-field">
    <mat-label>Nuova data fine (senza ferie)*</mat-label>
    <input matInput [matDatepicker]="picker" [(ngModel)]="nuovaDataFineSenzaFerie">
    <mat-datepicker-toggle matIconSuffix [for]="picker"></mat-datepicker-toggle>
    <mat-datepicker #picker></mat-datepicker>
  </mat-form-field>

  <!-- Legacy Layout: No preview button or validation logic actions existed here -->
  <div class="actions-row">
    <button mat-button (click)="close()">Annulla</button>
    <button mat-button [disabled]="true">Avanti</button>
  </div>
</div>

```

---