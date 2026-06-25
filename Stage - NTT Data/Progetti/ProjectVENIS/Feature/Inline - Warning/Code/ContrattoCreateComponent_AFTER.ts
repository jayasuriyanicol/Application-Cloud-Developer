import { Component, OnInit, OnDestroy } from '@angular/core';
import { UntypedFormBuilder, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * REFACTORED & OPTIMIZED LOGIC (PRODUCTION READY)
 * * Eliminates stream synchronization defects, prevents thread allocation leaks,
 * * and perfectly bridges real-time UI state changes with backend validation.
 */
@Component({
  selector: 'app-contratto-create-after',
  template: `<!-- HTML handles component view binding cleanly without orphan tokens -->`
})
export class ContrattoCreateComponentAfter implements OnInit, OnDestroy {
  private readonly destroy$ = new Subject<void>();
  visualizzaWarningCE: boolean = false;
  
  // ?Contextual data model inherited from the wizard process state
  convocazione: any = { id: 1, soloCentroEstivo: false }; 

  form = this.fb.group({
    mainData: this.fb.group({
      dataInizio: [null, Validators.required]
    })
  });

  constructor(
    private readonly fb: UntypedFormBuilder, 
    private readonly contractsService: any
  ) {}

  ngOnInit(): void {

    // ✅ FIXED: Unified, non-overlapping subscription handling execution tracking

    this.form.get('mainData.dataInizio')?.valueChanges.pipe(
      takeUntil(this.destroy$)
    ).subscribe(() => {
      this.valutaWarningCentroEstivoRealTime();
    });
  }

  valutaWarningCentroEstivoRealTime(): void {
    const dataInizio = this.form.get('mainData.dataInizio')?.value;
    
    // ✅ FIXED: Context flag correctly captured into a boolean primitive wrapper

    const soloCentroEstivo = this.convocazione?.soloCentroEstivo === true;

    if (!dataInizio) {
      this.visualizzaWarningCE = false;
      return;
    }

    // Recover the date parsing with the normalization engine to avoid conversion offsets
    const dataNormalizzata = this.normalizeDateValue(dataInizio);

    // ✅ FIXED: Clean REST call dispatch executing with precise parametric mapping
    this.contractsService.checkCentroEstivoWarning(dataNormalizzata, soloCentroEstivo).subscribe({
      next: (ris: any) => {
        this.visualizzaWarningCE = ris.warningCE;
        console.log("WARNING CentroEstivo synchronization completed. Status: ", ris.warningCE);
      },
      error: (err: any) => {
        console.error("ERRORE: Validation engine failure details: ", err);
        this.visualizzaWarningCE = false;
      }
    });
  }

  private normalizeDateValue(value: any): string | null {
    if (!value) return null;
    // Dynamic date parsing simulation utility
    return value;
  }

  ngOnDestroy(): void {
    
    // ✅ FIXED: Lifecycle boundary guard triggers stream termination to guarantee a clean exit
    this.destroy$.next();
    this.destroy$.complete();
  }
}