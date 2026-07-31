// ?TEST: updateSchoolCalendarRules and handleRulesChange
  it('saves updated rules successfully and refreshes the calendar state', () => {
    const mockRules: SchoolCalendarRuleDTO[] = [
      { ruleType: 'NON_WORKING_DAY', ruleOrder: 1, singleDate: '2026-12-25', reason: 'Natale' }
    ];
    const updatedCalendar = { ...buildCalendar(), rules: mockRules };

    service.updateSchoolCalendarRules.mockReturnValue(of({ data: updatedCalendar, meta: buildMeta() }));
    component.calendarId = 7;
    component.calendar = buildCalendar();

    component.handleRulesChange(mockRules);

    expect(service.updateSchoolCalendarRules).toHaveBeenCalledTimes(1);
    expect(service.updateSchoolCalendarRules).toHaveBeenCalledWith(7, mockRules);
    expect(component.calendar).toEqual(updatedCalendar);
    expect(component.calendar?.rules.length).toBe(1);
    expect(component.isSaving).toBe(false);
  });

  it('handles validation errors when saving rules', () => {
    const mockRules: SchoolCalendarRuleDTO[] = [];
    const errorResponse = new HttpErrorResponse({
      status: 400,
      error: { message: 'ATTENZIONE ! La data inserita non rientra nell\'anno scolastico' }
    });

    service.updateSchoolCalendarRules.mockReturnValue(throwError(() => errorResponse));
    component.calendarId = 7;
    component.calendar = buildCalendar();

    component.handleRulesChange(mockRules);

    expect(component.hasError).toBe(true);
    expect(component.errorMessage).toContain('ATTENZIONE ! La data inserita non rientra');
    expect(component.isSaving).toBe(false);
  });

  it('blocks rules save if calendar is PUBLISHED (read-only) or currently saving', () => {
    const mockRules: SchoolCalendarRuleDTO[] = [];
    component.calendarId = 7;
    component.calendar = { ...buildCalendar(), status: 'PUBLISHED' };

    component.handleRulesChange(mockRules);

    expect(service.updateSchoolCalendarRules).not.toHaveBeenCalled();
  });
