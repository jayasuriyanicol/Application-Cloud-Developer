if (!this.calendar || this.isReadOnly || this.isSaving) return;

    this.isSaving = true;
    this.hasError = false;
    this.errorMessage = '';

    // *UPDATE: rules given and automatically processed
    this.calendarService.updateSchoolCalendarRules(this.calendarId, updatedRules)
      .pipe(
        finalize(() => this.isSaving = false)
      )
      .subscribe({
        next: (response) => {
          if (response && response.data) {
            this.calendar = response.data;
          } else {
            this.hasError = true;
            this.errorMessage = "ATTENZIONE ! Errore durante il salvataggio delle regole del calendario.";
          }
        },
        error: (err) => {
          this.hasError = true;
          if (err.status === 400 && err.error?.message) {
            this.errorMessage = `Errore di validazione: ${err.error.message}`;
          } else {
            this.errorMessage = "Impossibile salvare le regole del calendario. Riprova più tardi.";
          }
        }
      });
  }
}