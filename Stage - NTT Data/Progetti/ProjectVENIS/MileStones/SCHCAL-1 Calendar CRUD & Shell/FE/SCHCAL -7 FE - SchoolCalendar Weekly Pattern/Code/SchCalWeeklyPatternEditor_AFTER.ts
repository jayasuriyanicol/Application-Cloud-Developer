import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

interface DayToggle {
  key: string;
  label: string;
  value: boolean;
}

@Component({
  selector: 'app-weekly-pattern-editor',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './weekly-pattern-editor.component.html',
  styleUrls: ['./weekly-pattern-editor.component.css']
})
export class WeeklyPatternEditorComponent implements OnChanges {
  // *FEAT:
  // ?pattern -> the week pattern give to us
  // ?isReadOnly -> for PUBLISHED calendars
  // ?onPatternSave -> data saver
  @Input() pattern: any = null;
  @Input() isReadOnly: boolean = false;
  @Output() onPatternSave = new EventEmitter<any>();

  // *TOGGLE: requested toggle monday to sunday
  days: DayToggle[] = [
    { key: 'monday', label: 'Lunedì', value: true },
    { key: 'tuesday', label: 'Martedì', value: true },
    { key: 'wednesday', label: 'Mercoledì', value: true },
    { key: 'thursday', label: 'Giovedì', value: true },
    { key: 'friday', label: 'Venerdì', value: true },
    { key: 'saturday', label: 'Sabato', value: false },
    { key: 'sunday', label: 'Domenica', value: false }
  ];

  // ?CHECK: all type of changes in the form weekly pattern
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['pattern'] && this.pattern) {
      this.mapDtoToToggles(this.pattern);
    }
  }

  // ?MAP: print all the day week in according to the pattern
  private mapDtoToToggles(dto: any): void {
    this.days.forEach(day => {
      // *ADAPT: correctly the data to the for Each print, by the correct name
      if (dto.hasOwnProperty(day.key)) {
        day.value = !!dto[day.key];
      }
    });
  }

  // *SAVE: saving the data of the pattern
  savePattern(): void {
    if (this.isReadOnly) return;

    const updatedPattern: any = {};
    this.days.forEach(day => {
      updatedPattern[day.key] = day.value;
    });

    this.onPatternSave.emit(updatedPattern);
  }
}