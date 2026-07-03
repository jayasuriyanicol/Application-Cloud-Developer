## File: `Component_BEFORE.ts`

### Purpose

The following implementation represents the **legacy frontend component layout and state execution** that originally created the scrolling and action accessibility defects.

The layout was based on a **fragmented, static container approach**. The "Cancel" action button was isolated inside the header layout at the very top of the page, while the "Save changes" submission vector was anchored at the absolute bottom of the main content view. As a consequence, administrative operators were forced to scroll through long teacher records back and forth to perform basic confirmations, causing severe interface friction and workflow delays.

### Legacy Implementation

```typescript
import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup } from '@angular/forms';
import { TeacherManagementRegistryService, AnonymizedRowDTO } from '@app/services/teacher-registry.service';
import { HttpErrorResponse } from '@angular/common/http';

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * * LEGACY LAYOUT & STATE (ERRONEOUS):
 * Fragmented button placement causing heavy scrolling friction.
 * 'Cancel' button is statically placed in the top header.
 * 'Save' button is anchored at the absolute bottom of the long registry listing.
 * MISSING: Unified floating action banner layer.
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
      soloCentroEstivo: [false],
      applyStatusFilter: [true]
    });
  }

  ngOnInit(): void {
    this.loadInitialRegistry();
  }

  // Legacy individual save execution located exclusively at the bottom of the grid template
  onLegacyBottomSave(): void {
    this.isLoading = true;
    this.registryService.bulkSaveTeacherMutations(this.registryRecords)
      .subscribe({
        next: () => this.isLoading = false,
        error: (err) => this.errorMessage = err.message
      });
  }

  // Legacy individual cancel execution located exclusively at the top header layout
  onLegacyTopCancel(): void {
    this.searchForm.reset({ applyStatusFilter: true });
    this.loadInitialRegistry();
  }

  private loadInitialRegistry(): void {
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
}

```

### Generated Layout Signature

Because the action controls were hard-anchored onto separate vertical extremes of the DOM wrapper, the viewport forced a segmented scrolling pattern:

```html
<button (click)="onLegacyTopCancel()">Annulla</button> 

<div class="teacher-grid-scroll-container"> ... </div>

<button (click)="onLegacyBottomSave()">Salva Modifiche</button> 

```

### Why This Approach Was Incorrect

The user interface layer completely lacked viewport relative context. It treated primary confirmation workflows as static layout entries rather than matching them to the ongoing browser view state.

#### Example Scenario

* **User UI Trigger:** Operator completes quick multi-row adjustments halfway down the list.
* **Friction Points:** The operator must scroll down to find "Salva modifiche" or scroll up to find "Annulla".

The template left execution controls split across different page sections. This design allowed large gaps of white space and heavy records to hide critical action flows from the operator's current viewport view.