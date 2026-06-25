## File: `ContrattoCreateComponent_BEFORE.ts`

### Purpose

The following implementation represents the **legacy TypeScript event mapping** that originally created the business warning desynchronization and the subsequent local compiler crash.

The logic was based on an **unoptimized event-binding approach**. The component template layer was configured to trigger changes using an unmapped method token. Meanwhile, inside `ngOnInit`, the asynchronous validation handler lacked uniform thread isolation and stream pipes. As a consequence, the data interface failed to compile locally due to signature errors (`TS2339`), while the execution engine initiated duplicate, conflicting stream subscriptions that overloaded runtime state evaluations.

### Legacy Implementation



```typescript
import { Component, OnInit, OnDestroy } from '@angular/core';
import { UntypedFormBuilder, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * LEGACY IMPLEMENTATION (BROKEN & UNOPTIMIZED)
 * * This file demonstrates the orphaned handlers and stream duplication leading to TS2339 compiler errors.
 */
@Component({
  selector: 'app-contratto-create-legacy',
  template: ``
})
export class ContrattoCreateComponentLegacy implements OnInit, OnDestroy {
  private readonly destroy$ = new Subject<void>();
  visualizzaWarningCE: boolean = false;
  convocazione: any = { id: 1, insegnanteId: 120 };

  form = this.fb.group({
    mainData: this.fb.group({
      dataInizio: [null, Validators.required]
    })
  });

  constructor(private fb: UntypedFormBuilder, private contractsService: any) {}

  ngOnInit(): void {

    // ❌ ERROR: Stream duplication without performance constraints or parameter synchronization
    this.form.get('mainData.dataInizio')?.valueChanges.subscribe(() => {
      this.valutaWarningCentroEstivoRealTime();
    });

    // ❌ ERROR: Second concurrent subscription onto the same control creates race conditions
    this.form.get('mainData.dataInizio')?.valueChanges.pipe(
      takeUntil(this.destroy$)
    ).subscribe(() => {
      // Missing contract parsing logic
    });
  }

  valutaWarningCentroEstivoRealTime(): void {
    const dataInizio = this.form.get('mainData.dataInizio')?.value;
    
    // ❌ ERROR: Legacy signature mismatch. Passing old redundant identifier 'insegnanteId'
    // directly down to an endpoint that was refactored to handle boolean triggers.
    this.contractsService.checkCentroEstivoWarning(dataInizio, this.convocazione.insegnanteId).subscribe({
      next: (ris: any) => {
        this.visualizzaWarningCE = ris.warningCE;
      }
    });
  }

  // ❌ ERROR: The HTML template binds to 'intercettaModificheDate($event)' but it's completely missing here,
  // throwing critical signature compilation errors (TS2339) during development builds.

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
```



This joint refactoring between the Frontend and Backend addresses a parameter desynchronization issue (commonly known as the *Ghost-Filter* anomaly) within a data architecture based on the **Entity-Attribute-Value (EAV)** model.

Initially, user interactions with the *"Solo Centro Estivo"* (Summer Camp Only) checkbox on the Frontend were completely ignored. This update synchronizes the entire application call chain through three primary interventions:

1. **In the Angular Frontend (`CustomRegistryListComponent`):** A new reactive control is mapped within the form block, capturing the boolean state of the checkbox in real-time and embedding it into the REST API request payload.

2. **In the Java Spring Boot Service Layer (`CustomRegistryServiceImpl`):** The method signature is realigned to handle the exact structural sequence of 14 execution parameters, extracting the flag as a primitive boolean to safely forward it down to the data access tier.

3. **In the JPA Repository (`CustomRegistryRepository`):** An inline conditional subquery with *short-circuit* evaluation is injected. If the filter is disabled, the database engine bypasses the lookup entirely to preserve runtime performance; if enabled, it strictly isolates only the profiles that possess the specific `DISPONIBILITA_CENTRO_ESTIVO` key matched with a value of `'SI'` within the dynamic EAV relational table.







```java
package com.nttdata.portfolio.repository;

import com.nttdata.portfolio.dto.AnonymizedRowDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * LEGACY DATA ACCESS LAYER (BROKEN & UNOPTIMIZED)
 * * ❌ BUG: Ghost-Filter Anomaly.
 * The 'soloCentroEstivo' parameter is completely missing from the query logic.
 * Relational EAV attributes are ignored, causing user interactions on the UI 
 * checkbox to have zero impact on the persistence state evaluation.
 */
@Repository
public interface CustomRegistryRepository extends JpaRepository<CustomRegistry, Long> {

    @Query(
            value = """
                    select new com.nttdata.portfolio.dto.AnonymizedRowDTO(
                        r.id, i.id, i.nome, i.cognome, i.codiceFiscale, r.posizione
                    )
                    from CustomRegistry r
                    join r.profile i
                    where r.status = 'ACTIVE'
                    and (:tipoScuolaId is null or r.tipoScuolaId = :tipoScuolaId)
                    and (
                        :searchText is null
                        or lower(i.nome) like lower(concat('%', :searchText, '%'))
                        or lower(i.cognome) like lower(concat('%', :searchText, '%'))
                    )
                    """,
            countQuery = """
                    select count(r.id)
                    from CustomRegistry r
                    join r.profile i
                    where r.status = 'ACTIVE'
                    and (:tipoScuolaId is null or r.tipoScuolaId = :tipoScuolaId)
                    and (
                        :searchText is null
                        or lower(i.nome) like lower(concat('%', :searchText, '%'))
                        or lower(i.cognome) like lower(concat('%', :searchText, '%'))
                    )
                    """
    )
    Page<AnonymizedRowDTO> searchRegistryRecords(
            @Param("dataDa") LocalDate dataDa,
            @Param("dataA") LocalDate dataA,
            @Param("tipoScuolaId") Long tipoScuolaId,
            @Param("searchText") String searchText,
            @Param("soloConvocabili") boolean soloConvocabili,
            
            // ❌ ERROR: The parameter stack is truncated. It does not accept 'soloCentroEstivo'
            // causing signature sfasement and failing to map dynamic EAV relational values.
            
            @Param("applyStatusFilter") boolean applyStatusFilter,
            Pageable pageable
    );
}
```

  



