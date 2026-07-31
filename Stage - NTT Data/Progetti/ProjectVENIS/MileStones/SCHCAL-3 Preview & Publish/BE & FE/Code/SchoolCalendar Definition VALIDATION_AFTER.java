// *PUBLISH: validation for the insertion of a new calendar
    @Override
    @Transactional
    public SchoolCalendarDetailResponseDTO publishCalendar(Long id) {
        SchoolCalendar calendar = schoolCalendarRepository.findById(id)
            .orElseThrow(() -> new CalendarNotFoundException(
                "Calendario scolastico non trovato con id: " + id
            ));

        // *VERIFY: the status of DRAFT of the SchoolCalendar
        if (calendar.getStatus() != SchoolCalendarStatus.DRAFT) {
            throw new CalendarValidationException(
                "Il calendario non è pubblicabile perché non è in stato DRAFT"
            );
        }

        // *VALIDATION: SchoolCalendar year
        if (!StringUtils.hasText(calendar.getAcademicYear())) {
            throw new CalendarValidationException(
                "Impossibile pubblicare il calendario: anno scolastico mancante"
            );
        }

        if (calendar.getStartDate() == null || calendar.getEndDate() == null) {
            throw new CalendarValidationException(
                "Impossibile pubblicare il calendario: date di inizio e fine obbligatorie"
            );
        }

        if (calendar.getStartDate().isAfter(calendar.getEndDate())) {
            throw new CalendarValidationException(
                "Impossibile pubblicare il calendario: la data fine deve essere maggiore o uguale alla data inizio"
            );
        }

        // *VALIDATION: DTO pattern weekly
        if (calendar.getWorkingMonday() == null || calendar.getWorkingTuesday() == null
            || calendar.getWorkingWednesday() == null || calendar.getWorkingThursday() == null
            || calendar.getWorkingFriday() == null || calendar.getWorkingSaturday() == null
            || calendar.getWorkingSunday() == null) {
            throw new CalendarValidationException(
                "Impossibile pubblicare il calendario: pattern settimanale incompleto"
            );
        }

        // *VALIDATION: days check
        if (calendar.getDays() == null || calendar.getDays().isEmpty()) {
            throw new CalendarValidationException(
                "Impossibile pubblicare il calendario: occorre generare i giorni prima della pubblicazione"
            );
        }

        // *VALIDATION: Uniqueness
        boolean publishedExists = schoolCalendarRepository.existsByAcademicYearAndStatusAndIdNot(
            calendar.getAcademicYear(),
            SchoolCalendarStatus.PUBLISHED,
            calendar.getId()
        );

        if (publishedExists) {
            throw new CalendarValidationException(
                "Esiste già un calendario pubblicato per l'anno scolastico " + calendar.getAcademicYear()
            );
        }

        // *TRANSITION: from DRAFT to PUBLISHED
        calendar.setStatus(SchoolCalendarStatus.PUBLISHED);
        calendar.setPublishedAt(LocalDateTime.now());

        SchoolCalendar saved = schoolCalendarRepository.save(calendar);

        return toDetailResponse(saved);
    }