// *Impl of the '@PostMapping' method to create a new SchoolCalendar Draft
@PostMapping("/school-calendars")
public ResponseEntity<ServiceResponse<SchoolCalendarListResponseDTO>> createSchoolCalendarDraft(
    @Valid @RequestBody SchoolCalendarCreateRequestDTO requestDto
) {
    log.debug("REST request to create SchoolCalendar Draft : {}", requestDto);
    SchoolCalendarListResponseDTO createdCalendar = calendarLifecycleService.createCalendarDraft(requestDto);
    return ResponseEntity.ok(ServiceResponse.success(createdCalendar));
}