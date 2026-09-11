
    // *PUT: Update a DRAFT schoolCalendar
    @PutMapping("/{id}")
    public ServiceResponse<SchoolCalendarDetailResponseDTO> updateDraft( @PathVariable("id") Long id, @Valid @RequestBody SchoolCalendarUpdateRequestDTO requestDto) {
        SchoolCalendarDetailResponseDTO updated = schoolCalendarCommandService.updateDraft(id, requestDto);
        return ServiceResponse.success(updated);
    }

    // *PUT: Update the rules of a SchoolCalendar
    @PutMapping("/{id}/rules")
    public ServiceResponse<SchoolCalendarDetailResponseDTO> updateRules( @PathVariable("id") Long id, @Valid @RequestBody List<SchoolCalendarRuleRequestDTO> rules) {
        SchoolCalendarDetailResponseDTO updated = schoolCalendarCommandService.updateRules(id, rules);
        return ServiceResponse.success(updated);
    }

    // *POST: Update the rules of a SchoolCalendar
    @PostMapping("/{id}/generate")
    public ServiceResponse<List<PublishedSchoolCalendarDayDTO>> generateDays(@PathVariable("id") Long id) {
        List<PublishedSchoolCalendarDayDTO> generatedDays = schoolCalendarCommandService.generateDays(id);
        return ServiceResponse.success(generatedDays);
    }

    // *POST: Publish a given SchoolCalendar from modality DRAFT
    @PostMapping("/{id}/publish")
    public ServiceResponse<SchoolCalendarDetailResponseDTO> publishSchoolCalendar(@PathVariable("id") Long id) {

        SchoolCalendarDetailResponseDTO publishedCalendar = schoolCalendarCommandService.publishCalendar(id);
        return ServiceResponse.success(publishedCalendar);
    }
