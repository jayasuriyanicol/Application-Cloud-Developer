/**
 * FE After (Day.js, XSS-Safe Payload and Native CSS)
 *
 * The code was refactored by standardizing parsing with `dayjs`. 
 * The warning message was structured as an object to allow Angular 
 * to safely render partial variables, delegating the bold formatting 
 * to the official Bootstrap `.fw-bold` class.
 */


// AFTER (TypeScript): Standardized parsing and XSS-safe structured object
import dayjs from 'dayjs';

private checkRuleAgainstLocalList(newRule: SchoolCalendarRuleDTO) {
    // ... logic loop
    if (newRule.singleDate === existing.singleDate) {
        return {
            prefix: "ATTENZIONE ! Esiste già una regola identica per la data ",
            highlight: dayjs(newRule.singleDate).format('DD/MM/YYYY'), // Day.js implementation
            suffix: "."
        };
    }
    // ...
}
