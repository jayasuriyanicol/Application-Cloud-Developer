## File: `Component_BEFORE.ts`

### Purpose

The following implementation represents the **legacy frontend component state tracking** that originally created and afterwards caused the global view lifecycle defect.

The logic was based on an **isolated interaction approach**. Although form changes and advanced filters were captured locally, the view layer completely lacked a centralized state monitoring wrapper. As a consequence, the interface failed to toggle a global action context, processing state alterations indiscriminately without exposing explicit, unified mass-execution controls.

### Legacy Implementation

```typescript
import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup } from '@angular/forms';
import { TeacherManagementRegistryService, AnonymizedRowDTO } from '@app/services/teacher-registry.service';
import { HttpErrorResponse } from '@angular/common/http';

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * * LEGACY LOGIC (ERRONEOUS):
 * Fragmented component state lifecycle approach.
 * Modifying table grid rows or filtering options executes instantly.
 * MISSING: Global floating action banner wrapper trigger ('Save' / 'Cancel' scope).
 */
@Component({
  selector: 'app-teacher-management-registry',
  standalone: true,
  templateUrl: './teacher-management-registry.component.html',
  styleUrls: ['./teacher-management-registry.component.css']
})
export class TeacherManagementRegistryComponent implements OnInit {
  
  registryRecords: AnonymizedRowDTO[] = [];
  searchForm: UntypedFormGroup;
  isLoading = false;
  errorMessage = '';

  constructor(
    private readonly registryService: TeacherManagementRegistryService,
    private readonly fb: UntypedFormBuilder
  ) {
    this.searchForm = this.fb.group({
      tipoScuolaId: [null],
      searchText: [null],
      soloConvocabili: [false],
      // *MISSING: The dynamic EAV checkbox model was decoupled from the reactive form payload signature
      applyStatusFilter: [true]
    });
  }

  ngOnInit(): void {
    this.loadInitialRegistry();
    
    // MISSING: Global valueChanges interception to switch page state lifecycle to dirty
    this.searchForm.valueChanges.subscribe(() => {
      this.executeImmediateSearch();
    });
  }

  executeImmediateSearch(): void {
    this.isLoading = true;
    this.registryService.searchRegistryRecords(null, null, this.searchForm.value, 0, 10)
      .subscribe({
        next: (response) => {
          this.registryRecords = response.content;
          this.isLoading = false;
        },
        error: (err: HttpErrorResponse) => {
          this.errorMessage = err.message;
          this.isLoading = false;
        }
      });
  }

  private loadInitialRegistry(): void {
    this.executeImmediateSearch();
  }
}

```

### Generated State Signature

Because the global dirty state monitor was missing from the component lifecycle and the form model signature, Angular processed a completely un-managed template execution layout:

```typescript
this.isPageDirty = false; // System value remained statically locked
// UI templates evaluated local controls individually without structural coordination

```

### Why This Approach Was Incorrect

The user interface layer had no global routing instruction to trigger a viewport-anchored overlay block. It treated every data change or advanced filter switch as an instant, isolated, and auto-committed execution loop.

#### Example Scenario

* **UI State Trigger:** Administrative operator alters complex row cell values.
* **Target Interface Panel:** Global Action Banner container stays hidden (`isPageDirty = false`).

The workspace left active modifications un-monitored because the component class was completely blind to the global state lifecycle context, pushing raw volatile changes straight down the layout stack without an explicit confirmation fallback barrier.