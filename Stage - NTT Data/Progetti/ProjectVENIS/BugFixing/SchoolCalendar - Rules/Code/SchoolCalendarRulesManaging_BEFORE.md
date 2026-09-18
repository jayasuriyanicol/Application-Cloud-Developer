# BEFORE BE & FE previously 

## 1. BE Before (Lack of structured duplication validation)


*Prior to the refactoring, the system saved rules without verifying sort order collisions or exact dates, allowing the insertion of duplicated or conflicting data into the database.*

```java
// BEFORE: Basic save operation without strict duplication domain guards
public void updateSchoolCalendarRules(Long calendarId, List<SchoolCalendarRuleDTO> rules) {
    SchoolCalendar calendar = repository.findById(calendarId)
        .orElseThrow(() -> new EntityNotFoundException("Calendar not found"));
    
    // Clearing old rules and direct insertion (Risk of duplication)
    calendar.getRules().clear();
    for (SchoolCalendarRuleDTO dto : rules) {
        calendar.addRule(mapper.toEntity(dto));
    }
    
    repository.save(calendar);
}

```


##  2. FE Before (Manual Date Parsing and Unsafe Inline Styles)

*The original frontend code relied on highly fragile manual string manipulation and violated Angular's encapsulation by using `style="!important"` attributes directly within the DOM (a practice prone to XSS security warnings).*

```typescript
// BEFORE (TypeScript): Fragile manual parsing
private formatDate(dateString: string): string {
  const parts = dateString.split('-');
  return parts.length === 3 ? `${parts[2]}/${parts[1]}/${parts[0]}` : dateString;
}

```

```html
<!-- BEFORE (HTML): Unsafe inline CSS overriding global styles -->
<div class="alert alert-warning" *ngIf="warningText">
   Attention: <span style="font-weight: 700 !important;">{{ warningText }}</span>
</div>

```
