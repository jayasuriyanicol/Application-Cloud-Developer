import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SchoolCalendarService } from '@app/services/school-calendar.service';
import { SchoolCalendarDetailResponseDTO } from '@app/models/scuola.model';
import { finalize } from 'rxjs/operators';
import { CommonModule } from '@angular/common'

@Component({
    selector: 'app-school-calendar-detail',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './school-calendar-detail.component.html',
    styleUrls: ['./school-calendar-detail.component.css']
  }
)
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




  