import { Component, OnInit, OnDestroy } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup } from '@angular/forms';
import { TeacherManagementRegistryService, AnonymizedRowDTO } from '@app/services/teacher-registry.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * * REFACTORED STATE & LAYOUT (SUCCESSFUL):
 * Viewport-relative global actions architecture.
 * Removes top header 'Cancel' and absolute bottom 'Save' static buttons.
 * Introduces dynamic reactive stream tracking linked to the global floating bar module.
 */
@Component({
  selector: 'app-teacher-management-registry',
  standalone: true,
  templateUrl: './teacher-management-registry.component.html',
  styleUrls: ['./teacher-management-registry.component.css']
})
export class TeacherManagementRegistryComponent implements OnInit, OnDestroy {
  
  registryRecords: AnonymizedRowDTO[] = [];
  searchForm: UntypedFormGroup;
  isLoading = false;
  errorMessage = '';
  
  // Controls the viewport rendering lifecycle of the modern sticky banner container
  isBannerVisible = false;
  
  private readonly destroy$ = new Subject<void>();
  private initialFormStateSnapshot: any;

  constructor(
    private readonly registryService: TeacherManagementRegistryService,
    private readonly fb: UntypedFormBuilder
  ) {
    this.searchForm = this.fb.group({
      tipoScuolaId: [null],
      searchText: [null],
      soloConvocabili: [false],
      // *FIXED: Structurally bound dynamic EAV filter parameter 
      soloCentroEstivo: [false],
      applyStatusFilter: [true]
    });
  }

  ngOnInit(): void {
    this.loadInitialRegistry();
    this.trackFormLifecycleChanges();
    this.subscribeToGlobalBannerState();
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  /**
   * *FIXED: Global mass-submission handler executed straight from the sticky panel vector
   */
  public onGlobalBannerSave(): void {
    this.isLoading = true;
    this.registryService.bulkSaveTeacherMutations(this.registryRecords)
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: () => {
          this.isLoading = false;
          this.registryService.setGlobalModificationState(false); // Hide banner on success
          this.initialFormStateSnapshot = this.searchForm.getRawValue(); // Re-index form baseline
        },
        error: (err) => {
          this.errorMessage = err.message;
          this.isLoading = false;
        }
      });
  }

  /**
   * *FIXED: Global rollback reset handler executed instantly from the sticky panel vector
   */
  public onGlobalBannerCancel(): void {
    // Restores structural state values safely back to baseline without viewport disruption
    this.searchForm.reset(this.initialFormStateSnapshot, { emitEvent: false });
    this.registryService.setGlobalModificationState(false);
    this.loadInitialRegistry();
  }

  private trackFormLifecycleChanges(): void {
    // Captures user adjustments across all matrix entries on the fly
    this.searchForm.valueChanges
      .pipe(takeUntil(this.destroy$))
      .subscribe((currentState) => {
        const isDirty = JSON.stringify(currentState) !== JSON.stringify(this.initialFormStateSnapshot);
        this.registryService.setGlobalModificationState(isDirty);
      });
  }

  private subscribeToGlobalBannerState(): void {
    this.registryService.isPageDirty$
      .pipe(takeUntil(this.destroy$))
      .subscribe((isDirty) => {
        this.isBannerVisible = isDirty;
      });
  }

  private loadInitialRegistry(): void {
    this.isLoading = true;
    this.registryService.searchRegistryRecords(null, null, this.searchForm.value, 0, 10)
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (response) => {
          this.registryRecords = response.content;
          if (!this.initialFormStateSnapshot) {
            this.initialFormStateSnapshot = this.searchForm.getRawValue();
          }
          this.isLoading = false;
        },
        error: (err: HttpErrorResponse) => {
          this.errorMessage = err.message;
          this.isLoading = false;
        }
      });
  }
}

// *Static extremes are bypassed. Primary submission actions are bound contextually inside a `position: fixed` floating view overlay component:

/*
<div class="teacher-grid-scroll-container">
  </div>

<div class="global-floating-action-banner" *ngIf="isBannerVisible">
  <div class="banner-actions-wrapper">
    <button class="btn-cancel" (click)="onGlobalBannerCancel()">Annulla</button>
    <button class="btn-save" (click)="onGlobalBannerSave()">Salva Modifiche</button>
  </div>
</div>
*/
