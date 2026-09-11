import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { finalize } from 'rxjs/operators';
import { SchoolCalendarService } from '../../services/school-calendar.service';
import { SchoolCalendarDetailResponseDTO } from '../../models/school-calendar.dto';

@Component({
  selector: 'app-school-calendar-detail',
  templateUrl: './school-calendar-detail.component.html',
  styleUrls: ['./school-calendar-detail.component.scss']
})
export class SchoolCalendarDetailComponent implements OnInit {
  calendarId: number | null = null;
  calendar: SchoolCalendarDetailResponseDTO | null = null;
  isLoading = false;
  errorMessage = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private calendarService: SchoolCalendarService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const idParam = params.get('id');
      if (idParam) {
        this.calendarId = +idParam;
        this.loadCalendarDetail(this.calendarId);
      } else {
        this.router.navigate(['/calendari']);
      }
    });
  }

  loadCalendarDetail(id: number): void {
    this.isLoading = true;
    this.errorMessage = '';

    this.calendarService.getCalendarDetail(id)
      .pipe(finalize(() => this.isLoading = false))
      .subscribe({
        next: (response) => {
          if (response?.data) {
            this.calendar = response.data;
          }
        },
        error: (err) => {
          console.error('Errore nel caricamento del dettaglio calendario', err);
          this.errorMessage = 'Impossibile caricare i dettagli del calendario. Riprovare più tardi.';
        }
      });
  }
}