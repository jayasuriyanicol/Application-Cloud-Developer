export interface DefaultWorkingPatternDTO {
  monday: boolean;
  tuesday: boolean;
  wednesday: boolean;
  thursday: boolean;
  friday: boolean;
  saturday: boolean;
  sunday: boolean;
}

export interface SchoolCalendarRuleDTO {
  id: number;
  ruleType: string;
  ruleOrder: number;
  startDate?: string;
  endDate?: string;
  singleDate?: string;
  reason: string;
}

export interface PublishedSchoolCalendarDayDTO {
  calendarDate: string;
  workingDay: boolean;
  redDay: boolean;
  sourceType: string;
  reason?: string;
  generatedFromRule?: number;
}

export interface SchoolCalendarDetailResponseDTO {
  id: number;
  schoolYear: string;
  name: string;
  startDate: string;
  endDate: string;
  status: 'DRAFT' | 'PUBLISHED' | 'ARCHIVED';
  basedOnCalendarId?: number;
  createdAt?: string;
  updatedAt?: string;
  publishedAt?: string;

  pattern: DefaultWorkingPatternDTO;
  rules: SchoolCalendarRuleDTO[];
  generatedDays: PublishedSchoolCalendarDayDTO[];
}