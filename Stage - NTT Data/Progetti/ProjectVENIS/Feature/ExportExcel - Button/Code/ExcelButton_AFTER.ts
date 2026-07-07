// *AFTER: Decoupled & Service-Driven Architecture

// ? The presentation layer was fully streamlined. The local `ExcelJS` imports were removed, and the file creation task was completely delegated to the centralized `ExcelExportService`,
// ? keeping the component clean and lightweight.


// scuole-list.component.ts (Optimized Service-Driven Approach)
import { Component, OnInit } from '@angular/core';
import { ExcelExportService } from '@app/shared/services/excel-export.service'; // Shared utility injection

@Component({
  selector: 'app-scuole-list',
  templateUrl: './scuole-list.component.html'
})
export class ScuoleListComponent implements OnInit {
  visibleScuole: Scuola[] = [];
  isLoading = false;

  constructor(
    private readonly excelExportService: ExcelExportService // *Injected via Dependency Injection
  ) {}

  // ? The exportToExcel method is now a clean, single-responsibility function that delegates the actual export logic to the centralized service.
  async exportToExcel(): Promise<void> {
    const targetData = this.visibleScuole;
    if (!targetData.length) return;

    // *Clean routing to the specific centralized service method
    await this.excelExportService.exportScuoleList(targetData);
  }
}

