// *FEAT: SchoolCalendar PAYLOAD of rules
export interface SchoolCalendarRulePayload {
  type: string;
  date?: string | null;
  startDate?: string | null;
  endDate?: string | null;
  reason: string;
  sortOrder: number;
}