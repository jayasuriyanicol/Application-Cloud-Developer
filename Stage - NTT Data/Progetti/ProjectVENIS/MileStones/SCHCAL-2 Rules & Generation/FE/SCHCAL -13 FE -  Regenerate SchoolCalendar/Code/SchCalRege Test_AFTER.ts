 private static class TestLatestVisitView implements VisiteMedicheRepository.LatestVisitView {
        private final Long insegnanteId;
        private final LocalDate dataUltimaVisita;

        public TestLatestVisitView(Long insegnanteId, LocalDate dataUltimaVisita) {
            this.insegnanteId = insegnanteId;
            this.dataUltimaVisita = dataUltimaVisita;
        }

        @Override
        public Long getInsegnanteId() {
            return insegnanteId;
        }

        @Override
        public LocalDate getDataUltimaVisita() {
            return dataUltimaVisita;
        }
    }

/**---------------------------------------------------------- */




  // ?TEST
  describe('SCHCAL-13 Feature Checks', () => {
    it('isCalendarValidForGeneration validates required fields correctly', () => {
      // *Valid calendar
      component.calendar = buildCalendar();
      expect(component.isCalendarValidForGeneration).toBe(true);

      // *Missing dates
      component.calendar = { ...buildCalendar(), startDate: '' };
      expect(component.isCalendarValidForGeneration).toBe(false);

      // *Missing or empty pattern
      component.calendar = { ...buildCalendar(), pattern: undefined as any };
      expect(component.isCalendarValidForGeneration).toBe(false);

      // *During generation
      component.calendar = buildCalendar();
      component.isGenerating = true;
      expect(component.isCalendarValidForGeneration).toBe(false);

      component.isGenerating = false;
      component.calendar.status = 'PUBLISHED';
      expect(component.isCalendarValidForGeneration).toBe(false);
    });

    it('regenerates calendar days successfully and reloads updated details', () => {
      const initialCalendar = buildCalendar();
      const generatedDaysMock = [
        { date: '2026-09-01', workingDay: true, type: 'WORKING_DAY', reason: null }
      ];
      const reloadedCalendar = { ...initialCalendar, generatedDays: generatedDaysMock };

    service.generateSchoolCalendarDays.mockReturnValue(of({ data: generatedDaysMock, meta: buildMeta() }));
    service.getSchoolCalendarById.mockReturnValue(of({ data: reloadedCalendar, meta: buildMeta() }));

    component.calendarId = 7;
    component.calendar = initialCalendar;

    component.onGenerateCalendar();

    expect(service.generateSchoolCalendarDays).toHaveBeenCalledWith(7);
    expect(service.getSchoolCalendarById).toHaveBeenCalledWith(7);
    expect(component.calendar?.generatedDays.length).toBe(1);
    expect(component.isGenerating).toBe(false);
    expect(component.hasError).toBe(false);
  });

    it('extracts backend message and preserves calendar UI state on generation error', () => {
      const initialCalendar = buildCalendar();
      const errorResponse = new HttpErrorResponse({
        status: 400,
        error: { message: 'Pattern settimanale vuoto o non specificato per le date selezionate.' }
      });

    service.generateSchoolCalendarDays.mockReturnValue(throwError(() => errorResponse));

      component.calendarId = 7;
      component.calendar = initialCalendar;

    component.onGenerateCalendar();

      expect(service.generateSchoolCalendarDays).toHaveBeenCalledWith(7);
      expect(component.hasError).toBe(true);
      expect(component.errorMessage).toBe('Pattern settimanale vuoto o non specificato per le date selezionate.');
      expect(component.isGenerating).toBe(false);
      expect(component.calendar).not.toBeNull();
      expect(component.calendar).toEqual(initialCalendar);
    });

    it('blocks generation if isCalendarValidForGeneration is false', () => {
      component.calendarId = 7;
      component.calendar = { ...buildCalendar(), status: 'PUBLISHED' };

    component.onGenerateCalendar();

    expect(service.generateSchoolCalendarDays).not.toHaveBeenCalled();

      component.calendar = { ...buildCalendar(), startDate: '' };

    component.onGenerateCalendar();

      expect(service.generateSchoolCalendarDays).not.toHaveBeenCalled();
    });
  });