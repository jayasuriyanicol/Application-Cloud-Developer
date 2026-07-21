// * SchoolCalendarDetailComponent: This component is responsible for displaying the details of a specific school calendar.

export class SchoolCalendarDetailComponent implements OnInit {
  calendarId!: number;
  calendar: SchoolCalendarDetailResponseDTO | null = null;

  // *Managing the page cases MESSAGES
  isLoading = false;
  hasError = false;
  errorMessage = '';

  constructor(
    private route: ActivatedRoute,
    private calendarService: SchoolCalendarService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.calendarId = +params['id'];
      if (this.calendarId) {
        this.loadCalendarDetails();
      }
    });
  }

  loadCalendarDetails(): void {
    this.isLoading = true;
    this.hasError = false;

    this.calendarService.find(this.calendarId)
      .pipe(
        finalize(() => this.isLoading = false)
      )
      .subscribe({
        next: (response) => {
          if (response && response.data) {
            this.calendar = response.data;
          } else {
            this.hasError = true;
            this.handleError('ERRORE ! I dati inseriti non risultano validi !.');
          }
        },
        error: (err) => {
          this.hasError = true;
          this.handleError('ERRORE nel caricamento del calendario o calendario NON ESISTENTE');
        }
      });
  }

  private handleError(message: string): void {
    this.hasError = true;
    this.errorMessage = message;
    this.calendar = null;
  }
}