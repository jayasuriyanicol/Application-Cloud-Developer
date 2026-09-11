
    // ?TEST: to check if the Publish Calendar in modality DRAFT is valid
    @Test
    void publishCalendar_shouldPublishValidDraftCalendar() {
        SchoolCalendar calendar = buildCalendar(SchoolCalendarStatus.DRAFT);
        calendar.getDays().add(buildGeneratedDay(calendar));

        when(schoolCalendarRepository.findById(1L)).thenReturn(Optional.of(calendar));
        when(schoolCalendarRepository.existsByAcademicYearAndStatusAndIdNot("2025/2026", SchoolCalendarStatus.PUBLISHED, 1L))
            .thenReturn(false);

        SchoolCalendarDetailResponseDTO response = service.publishCalendar(1L);

        assertNotNull(response);
        assertEquals(SchoolCalendarStatus.PUBLISHED, calendar.getStatus());
        verify(schoolCalendarRepository).save(calendar);
    }

    // ?TEST: mock test to reject NOT VALID calendar
    @Test
    void publishCalendar_shouldRejectMissingCalendar() {
        when(schoolCalendarRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(CalendarNotFoundException.class,
            () -> service.publishCalendar(99L));
        verify(schoolCalendarRepository, never()).save(any());
    }

    // ?TEST: mock test to reject NOT DRAFT calendar
    @Test
    void publishCalendar_shouldRejectNonDraftCalendar() {
        when(schoolCalendarRepository.findById(1L))
            .thenReturn(Optional.of(buildCalendar(SchoolCalendarStatus.PUBLISHED)));

        assertThrows(CalendarValidationException.class,
            () -> service.publishCalendar(1L));
        verify(schoolCalendarRepository, never()).save(any());
    }

     // ?TEST: mock test to reject NO GENERATED DAYS calendar
    @Test
    void publishCalendar_shouldRejectCalendarWithoutGeneratedDays() {
        SchoolCalendar calendar = buildCalendar(SchoolCalendarStatus.DRAFT);
        calendar.getDays().clear();

        when(schoolCalendarRepository.findById(1L)).thenReturn(Optional.of(calendar));

        assertThrows(CalendarValidationException.class,
            () -> service.publishCalendar(1L));
        verify(schoolCalendarRepository, never()).save(any());
    }

    // ?TEST: mock test to reject SAME EXISTING calendar
    @Test
    void publishCalendar_shouldRejectIfAnotherPublishedCalendarExistsForSameAcademicYear() {
        SchoolCalendar calendar = buildCalendar(SchoolCalendarStatus.DRAFT);
        calendar.getDays().add(buildGeneratedDay(calendar));

        when(schoolCalendarRepository.findById(1L)).thenReturn(Optional.of(calendar));
        when(schoolCalendarRepository.existsByAcademicYearAndStatusAndIdNot("2025/2026", SchoolCalendarStatus.PUBLISHED, 1L))
            .thenReturn(true);

        assertThrows(CalendarValidationException.class,
            () -> service.publishCalendar(1L));
        verify(schoolCalendarRepository, never()).save(any());
    }

   // ?TEST: mock test to UPDATE reject eventually NOT DRAFT calendar
    @Test
    void updateDraft_shouldRejectNonDraftCalendar() {
        when(schoolCalendarRepository.findById(1L))
            .thenReturn(Optional.of(buildCalendar(SchoolCalendarStatus.PUBLISHED)));

        assertThrows(CalendarValidationException.class,
            () -> service.updateDraft(1L, buildValidRequest()));
        verify(schoolCalendarRepository, never()).save(any());
        verify(schoolCalendarDayRepository, never()).deleteByCalendarId(any());
        verify(calendarGenerationService, never()).generateDays(any());
    }

    // ?TEST: mock test to UPDATE reject eventually NOT DRAFT calendar
    @Test
    void updateRules_shouldRejectNonDraftCalendar() {
        when(schoolCalendarRepository.findById(1L))
            .thenReturn(Optional.of(buildCalendar(SchoolCalendarStatus.PUBLISHED)));

        assertThrows(CalendarValidationException.class,
            () -> service.updateRules(1L, List.of()));
        verify(schoolCalendarRepository, never()).save(any());
    }

    // ?TEST: mock test to GENERATE reject eventually NOT DRAFT calendar
    @Test
    void generateDays_shouldRejectNonDraftCalendar() {
        when(schoolCalendarRepository.findById(1L))
            .thenReturn(Optional.of(buildCalendar(SchoolCalendarStatus.PUBLISHED)));

        assertThrows(CalendarValidationException.class,
            () -> service.generateDays(1L));
        verify(calendarGenerationService, never()).generateDays(any());
    }