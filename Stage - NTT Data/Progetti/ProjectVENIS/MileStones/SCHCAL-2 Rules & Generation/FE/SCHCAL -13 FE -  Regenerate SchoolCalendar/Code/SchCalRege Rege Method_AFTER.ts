 // *METHOD: Generation of calendar
  onGenerateCalendar(): void {
    if (!this.isCalendarValidForGeneration || !this.calendarId) return;

    this.isGenerating = true;
    this.hasError = false;
    this.errorMessage = '';

    this.calendarService.generateSchoolCalendarDays(this.calendarId)
      .pipe(
        switchMap(() => this.calendarService.getSchoolCalendarById(this.calendarId)),
        finalize(() => this.isGenerating = false)
      )
      .subscribe({
        next: (response: any) => {
          if (response && response.data) {
            if (response.data.id) {
              this.calendar = response.data;
            } else if (this.calendar && Array.isArray(response.data)) {
              this.calendar.generatedDays = response.data;
            }

            if (this.calendar) {
              const days = response.data.generatedDays || response.data.days || (Array.isArray(response.data) ? response.data : null);
              if (days) {
                this.calendar.generatedDays = days;
              }
            }
          } else {
            this.handleActionError("ATTENZIONE ! Errore durante la rigenerazione dei giorni del calendario.");
          }
        },
        error: (err) => {

          const backendMsg = err?.error?.message || err?.error?.detail;
          this.handleActionError(backendMsg || "Errore interno durante la generazione dei giorni.");
        }
      });