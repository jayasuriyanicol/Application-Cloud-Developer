# Solution: Excel Export Integration & Layout Alignment

To resolve the missing report extraction capabilities and fix the toolbar design inconsistencies, a centralized export strategy was structured using a dedicated utility service, paired with an aligned Flexbox action boundary on the frontend.

## Boundary Logic Explained

The data extraction check is executed through a centralized utility service method that processes data dynamically at the frontend layer. This guarantees that tables, columns, and data types are mapped uniformly without duplicating code inside individual views.

**Service Processing Method (TypeScript Architecture):**

```typescript
async exportToExcel<T>(data: T[], columns: ExportColumn<T>[], filename: string): Promise<void> {
  const workbook = new ExcelJS.Workbook();
  const worksheet = workbook.addWorksheet('Export');

  worksheet.columns = columns.map((col) => ({
    header: col.header,
    key: col.header,
    width: col.width ?? 22
  }));

  const headerRow = worksheet.getRow(1);
  headerRow.eachCell((cell) => {
    cell.font = { bold: true, color: { argb: 'FFFFFFFF' } };
    cell.fill = { type: 'pattern', pattern: 'solid', fgColor: { argb: 'FF3F51B5' } };
    cell.alignment = { vertical: 'middle', horizontal: 'center' };
    cell.border = { bottom: { style: 'thin', color: { argb: 'FF000000' } } };
  });
  headerRow.height = 22;

  for (const row of data) {
    worksheet.addRow(columns.map((col) => col.value(row) ?? ''));
  }

  await this._download(workbook, filename);
}

```

### Frontend Layout & Data Normalization (`filters-actions` & `margin-bottom`)

Instead of applying heavy styling overrides directly on the core buttons, the template engine processes the alignment via layout wrappers:

* **`div.filters-actions`**: Wraps the button inside a dedicated container, isolating it from global Material layout shifts.
* **`margin-bottom: 22px`**: Explicitly counteracts the invisible bottom padding of adjacent `mat-form-field` outline fields (reserved for error messages), restoring a perfectly straight vertical alignment.

This ensures that the button remains horizontally consistent with the "Cerca scuola" or "Stato" inputs, while inheriting the native typography and structure directly from the browser's DOM inspector.

---

## Validation Tests

Following the integration of the central service methods and the toolbar template corrections, the Angular application correctly compiled the structural tags and processed the template variables:

```html
<div class="filters-actions" style="margin-bottom: 22px;">
  <button mat-stroked-button type="button" (click)="exportToExcel()" [disabled]="isLoading || !visibleScuole.length" style="height: 48px;">
    <mat-icon role="img" aria-hidden="true">download</mat-icon>
    <span class="mdc-button__label">Esporta Excel</span>
  </button>
</div>

```

The solution was fully verified against multiple views and data states to test edge cases, performance, and responsive behaviors:

### Test Results

| Scenario Tested | Active Data State | Trigger Action | Expected Result | Actual Result | Status |
| --- | --- | --- | --- | --- | --- |
| **Standard Export** | Active records present | Click "Esporta Excel" | Generates standard layout; starts download | Generates standard layout; starts download | ✅ PASSED |
| **Empty Table** | No records found (`length === 0`) | Button view check | Button automatically disables | Button automatically disables | ✅ PASSED |
| **Filtered Search** | Query typed in search field | Click "Esporta Excel" | Exports only the active filtered dataset | Exports only the active filtered dataset | ✅ PASSED |
| **Layout Integrity** | Multiple filters active | Visual inspection | No `NG5002` errors; perfect vertical alignment | No `NG5002` errors; perfect vertical alignment | ✅ PASSED |
| **Component Sanity** | Async data loading | Toggle `isLoading = true` | Button locks instantly; prevents double clicks | Button locks instantly; prevents double clicks | ✅ PASSED |


---

# Results

## Result on the FE

### Implementation UX of the botton aligned in the 'FILTRA' form

#### 1. Tested structural button design with icon and native font label matching the application specifications, here the **GESTIONE SCUOLE**:



![Gestione Scuole](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/f3dd5a5fdf68d92ebc1b0d66030b936d28e6642a/Stage%20-%20NTT%20Data/assets/images/gestione_scuole.png)



---


#### 2. Toolbar filter container with the button perfectly aligned horizontally next to the text input fields, here the **GESTIONE TITOLI STUDIO**:





![Gestione Titoli Studio](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/f3dd5a5fdf68d92ebc1b0d66030b936d28e6642a/Stage%20-%20NTT%20Data/assets/images/gestione_titoli_studio.png)

---

# Result given from the FE

### After clicked the button the FE give to us the Excel files based on data on FE.


#### 1. Here the result of the click the button in the section **GESTIONE SCUOLE**, generated excel:



![Excel Gestione Scuole](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/7b56a6ab901d9c833ba29a60c5d4aeb593a5d946/Stage%20-%20NTT%20Data/assets/images/Excel_GestioneScuole.png)

--- 

#### 2. Here the result of the click the button in the section **GESTIONE TITOLI STUDIO**, generated excel:

![Excel Gestione Titoli Studio](https://raw.githubusercontent.com/jayasuriyanicol/Application-Cloud-Developer/7b56a6ab901d9c833ba29a60c5d4aeb593a5d946/Stage%20-%20NTT%20Data/assets/images/Excel_GestioneTitoliStudio.png)







## Outcome

The software architecture now cleanly handles client-side reporting utilities without overloading the core component files. It completely eliminates duplicated code by switching to a shared, reusable service strategy, while ensuring a premium user experience across all configuration modules by neutralizing design alignment offsets and balancing the template structure.