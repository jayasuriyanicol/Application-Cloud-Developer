import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ApiResponse } from '../../core/models/api-response.model';
import { SchoolCalendarDetailResponseDTO } from '../models/school-calendar.dto';

@Injectable({
  providedIn: 'root'
})
export class SchoolCalendarService {
  
  // *Endpoint aligned with the backend API for school calendar operations
  private readonly API_URL = `${environment.apiUrl}/api/supplenti-bo/school-calendars`;

  constructor(private http: HttpClient) {}

  // ? Recover the details of a specific school calendar by its ID
  getCalendarDetail(id: number): Observable<ApiResponse<SchoolCalendarDetailResponseDTO>> {
    return this.http.get<ApiResponse<SchoolCalendarDetailResponseDTO>>(`${this.API_URL}/${id}/detail`);
  }
}