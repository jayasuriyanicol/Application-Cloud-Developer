
      // *VALIDATION: check the number if is a positive integer
      if (
        idParam === undefined ||
        idParam === null ||
        idParam === '' ||
        isNaN(numId) ||
        !Number.isInteger(numId) ||
        numId <= 0
      ) {


        / ?UPDATE: method that update the rules of a given id SchoolCalendar
  updateSchoolCalendarRules(
    id: number,
    rules: SchoolCalendarRuleDTO[]
  ): Observable<ServiceResponse<SchoolCalendarDetailResponseDTO>> {
    // *LINKED: enviroment method to the correct method
    const endpointTemplate = environment.updateSchoolCalendarRules || '/school-calendars/:id/rules';
    const url = endpointTemplate.replace(':id', id.toString());

    const payload = this.mapRulesToPayload(rules);

    return this.gateService.put<SchoolCalendarDetailResponseDTO>(url, true, payload).pipe(
      map(dto => ({
        data: dto,
        meta: {
          success: true,
          timestamp: new Date().toISOString()
        }
      }))
    );
  }

  // *HELPER:  to help and process as the BE given payload, before sending correctly
  mapRulesToPayload(rules: SchoolCalendarRuleDTO[]): SchoolCalendarRulePayload[] {
    return rules.map((rule, index) => {
      const type = rule.ruleType;
      const isSingleDay = type === 'NON_WORKING_DAY' || type === 'WORKING_DAY_OVERRIDE';
      const isRange = type === 'NON_WORKING_RANGE' || type === 'WORKING_RANGE_OVERRIDE';

      return {
        type: type,
        date: isSingleDay ? (rule.singleDate || null) : null,
        startDate: isRange ? (rule.startDate || null) : null,
        endDate: isRange ? (rule.endDate || null) : null,
        reason: rule.reason,
        sortOrder: rule.ruleOrder ?? (index + 1)
      };
    });
  }