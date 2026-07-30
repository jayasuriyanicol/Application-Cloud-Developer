  // ?FEAT: method used to gain the calendar from DB and transformed into DTO
  find(id: number): Observable<ServiceResponse<SchoolCalendarDetailResponseDTO>> {
    const endpointTemplate = environment.getSchoolCalendarById;
    const url = endpointTemplate.replace(':id', id.toString());

    return this.gateService.get<SchoolCalendarDetailResponseDTO>(url).pipe(
      map(dto => ({
        data: dto,
        meta: {
          success: true,
          timestamp: new Date().toISOString()
        }
      }))
    );
  }

    // ?FEAT: method used to update the calendar in DB and transformed into DTO
  update(id: number, payload: any): Observable<ServiceResponse<SchoolCalendarDetailResponseDTO>> {
   
    const endpointTemplate = environment.updateSchoolCalendar;
    const url = endpointTemplate.replace(':id', id.toString());

    return this.gateService.put<SchoolCalendarDetailResponseDTO>(url,true, payload).pipe(
      map(dto => ({
        data: dto,
        meta: {
          success: true,
          timestamp: new Date().toISOString()
        }
      }))
    );
  }