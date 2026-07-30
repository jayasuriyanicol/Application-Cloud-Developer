constructor(private gateService: GateService, private http: HttpClient) {}

// ?FEAT: method used to gain the calendar from DB and transformed into DTO
find(id: number): Observable<ServiceResponse<SchoolCalendarDetailResponseDTO>> {
  const endpointTemplate = environment.getSchoolCalendarById;
  const url = endpointTemplate.replace(':id', id.toString());

  // *Used a pipeline to process correctly the data as the system security want, otherwise ERROR
  return this.gateService.get<SchoolCalendarDetailResponseDTO>(url).pipe(
    map(dto => ({
      data: dto,
      meta: {
        success: true,
        timestamp: new Date().toISOString()
      }
    }))
  );
