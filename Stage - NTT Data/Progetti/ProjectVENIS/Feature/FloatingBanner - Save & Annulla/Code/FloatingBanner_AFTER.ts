/**
 * NTT DATA - ANONYMIZED KNOWLEDGE BASE
 * * MODULE: Teacher Management - Global State Actions & EAV Filtering Bridge
 * FILE: teacher-management-registry.service.ts
 * * REFACTORED LOGIC:
 * Dynamic state tracking via global action streams. Implements structural 
 * reactive payload filtering to map the 'Solo Centro Estivo' checkbox state 
 * into the dynamic multi-parameter EAV API query contract.
 */

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Observable, BehaviorSubject, throwError } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

export interface AnonymizedRowDTO {
  id: number;
  profileId: number;
  firstName: string;
  lastName: string;
  taxCode: string;
  position: number;
}

export interface RegistrySearchRequest {
  dataDa?: string; // ISO string format (YYYY-MM-DD)
  dataA?: string;   // ISO string format (YYYY-MM-DD)
  tipoScuolaId: number | null;
  searchText: string | null;
  soloConvocabili: boolean | null;
  
  // *FIXED: Structurally added to intercept UI state changes for the summer camp EAV attribute
  soloCentroEstivo: boolean | null;
  
  applyStatusFilter: boolean;
  page: number;
  size: number;
}

export interface PaginatedResponse<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}

@Injectable({
  providedIn: 'root'
})
export class TeacherManagementRegistryService {
  private readonly baseUrl = '/api/custom-registry';

  // State Management for Global Floating Action Banner
  private readonly isPageDirtySubject = new BehaviorSubject<boolean>(false);
  public readonly isPageDirty$: Observable<boolean> = this.isPageDirtySubject.asObservable();

  constructor(private readonly http: HttpClient) {}

  /**
   * Updates the dirty state lifecycle of the view grid container.
   * Controls when the global floating action banner is toggled visible.
   */
  public setGlobalModificationState(isDirty: boolean): void {
    this.isPageDirtySubject.next(isDirty);
  }

  /**
   * *FIXED: Synchronized and mapped the API routing parameters.
   * Structural binding contract channels the EAV filter variable cleanly down to the HTTP protocol.
   */
  public searchRegistryRecords(
    dataDa: string | null,
    dataA: string | null,
    request: RegistrySearchRequest,
    page: number,
    size: number
  ): Observable<PaginatedResponse<AnonymizedRowDTO>> {
    
    // Constructing query string map - aligned parameter signatures with backend API layers
    let params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString())
      .set('applyStatusFilter', String(request.applyStatusFilter));

    if (dataDa) params = params.set('dataDa', dataDa);
    if (dataA) params = params.set('dataA', dataA);
    if (request.tipoScuolaId) params = params.set('tipoScuolaId', request.tipoScuolaId.toString());
    
    const sanitizedSearch = this.trimToNull(request.searchText);
    if (sanitizedSearch) params = params.set('searchText', sanitizedSearch);

    // Explicit evaluation passed as structural primitive booleans
    params = params.set('soloConvocabili', String(!!request.soloConvocabili));
    
    // *FIXED: Payload attribute is explicitly mapped and serialized into the backend route
    params = params.set('soloCentroEstivo', String(!!request.soloCentroEstivo));

    return this.http.get<PaginatedResponse<AnonymizedRowDTO>>(`${this.baseUrl}/search`, { params }).pipe(
      tap(() => console.log('=== API REGISTRY METADATA DISPATCHED ===')),
      catchError(this.handleOperationError)
    );
  }

  /**
   * Cleans string spaces to prevent corrupted backend relational operations.
   */
  private trimToNull(value: string | null): string | null {
    if (!value) return null;
    const trimmed = value.trim();
    return trimmed.length === 0 ? null : trimmed;
  }

  private handleOperationError(error: HttpErrorResponse) {
    console.error('Frontend Data Bridge Stream Refusal:', error);
    return throwError(() => new Error(error.error?.message || 'Server data extraction failure.'));
  }
}