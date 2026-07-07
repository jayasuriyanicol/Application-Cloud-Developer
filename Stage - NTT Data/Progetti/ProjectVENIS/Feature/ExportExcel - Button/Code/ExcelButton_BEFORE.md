#  BEFORE: Monolithic & Redundant Logic & Broken Tags & Vertical Misalignment

---
## 1. Component Architecture Refactoring (`TypeScript`)

In the initial implementation, the Excel generation logic using `ExcelJS` was duplicated directly inside the page components. The components were heavily bloated, violating the Single Responsibility Principle and importing external libraries unnecessarily.

```typescript
// scuole-list.component.ts (Legacy Monolithic Approach)
import { Component, OnInit } from '@angular/core';
import * as ExcelJS from 'exceljs'; // Heavy third-party dependency imported locally

@Component({
  selector: 'app-scuole-list',
  templateUrl: './scuole-list.component.html'
})
export class ScuoleListComponent implements OnInit {
  visibleScuole: Scuola[] = [];
  isLoading = false;

  // Heavy data transformation and file generation inside the presentation layer
  async exportToExcel(): Promise<void> {
    const targetData = this.visibleScuole;
    if (!targetData.length) return;

    const workbook = new ExcelJS.Workbook();
    const worksheet = workbook.addWorksheet('ELENCO SCUOLE');

    worksheet.columns = [
      { header: 'ID', key: 'id', width: 10 },
      { header: 'NOME SCUOLA', key: 'nome', width: 40 },
      { header: 'TIPOLOGIA', key: 'tipoScuola', width: 25 }
    ];

    targetData.forEach((s) => {
      worksheet.addRow({ id: s.id, nome: s.nome, tipoScuola: s.tipoScuola?.descrizione });
    });

    const buffer = await workbook.xlsx.writeBuffer();
    const blob = new Blob([buffer], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = `Export_Scuole.xlsx`;
    link.click();
  }
}

```

---

## 2. Layout Integration & Spacing Optimization (`HTML`)

The initial UI, didn't have an Export Excel Button. For manage this case, we introduced refactoring the layout 'filtra', but this attempt caused critical `NG5002` template compiler crashes due to mismatched closing tags (e.g., `</div></div>` closing the parent `<section>` prematurely). Furthermore, the export button sank downwards, breaking the horizontal alignment of the search bar.

```html
<section class="card mat-elevation-z1">
  <div class="toolbar">
    <div class="toolbar-filters">
      <mat-form-field appearance="outline" class="search-field">
        <mat-label>Cerca scuola</mat-label>
        <input matInput [(ngModel)]="searchValue" />
      </mat-form-field>

      <button mat-raised-button color="primary" (click)="exportToExcel()">
        <mat-icon>file_download</mat-icon>
        <span>Esporta in Excel</span>
      </button>
    </div> 
  </div> <div class="summary-row"> <strong>{{ allScuole.length }}</strong>
  </div>
</section>

```
---