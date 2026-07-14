
// *CalendarGenerationServiceTest.java -> generation test to verify the correctness of the generated school calendar days based on the defined rules.

package com.venis.supplenti.service.calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.venis.supplenti.domain.calendar.*;
import com.venis.supplenti.repository.SchoolCalendarRuleRepository;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalendarGenerationServiceTest {

    @Mock
    private SchoolCalendarRuleRepository schoolCalendarRuleRepository;

    @InjectMocks
    private CalendarGenerationService calendarGenerationService;

    @Test
    void generateDays_shouldMarkConfiguredRedDayAsTrueWhenNonWorking() {
        // *Given - Aligning the context test boundaries to the 2026-2027 academic year
        String academicYear = "2026-2027";
        LocalDate startDate = LocalDate.of(2026, 9, 8);
        LocalDate endDate = LocalDate.of(2027, 6, 30);

        SchoolCalendar calendar = new SchoolCalendar();
        calendar.setId(1L);
        calendar.setAcademicYear(academicYear);
        calendar.setStartDate(startDate);
        calendar.setEndDate(endDate);

        // ?Targeting Christmas 2026 as a verified mock execution date
        LocalDate christmasDay = LocalDate.of(2026, 12, 25);

        when(schoolCalendarRuleRepository.findByCalendarIdOrderByRuleOrderAscIdAsc(1L))
            .thenReturn(List.of(
                buildSingleDateRule(30L, 0, SchoolCalendarRuleType.NON_WORKING_DAY, christmasDay)
            ));

        // *When
        List<SchoolCalendarDay> generatedDays = calendarGenerationService.generateDays(calendar);

        // Then
        SchoolCalendarDay christmas = generatedDays.stream()
            .filter(day -> day.getDate().equals(christmasDay))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Christmas day not generated in the grid"));

        assertTrue(christmas.isRedDay(), "Christmas day must be flagged as a Red Day");
        assertFalse(christmas.isWorkingDay(), "Christmas day must not be a working day");
    }

    private SchoolCalendarRule buildSingleDateRule(Long id, Integer order, SchoolCalendarRuleType type, LocalDate date) {
        SchoolCalendarRule rule = new SchoolCalendarRule();
        rule.setId(id);
        rule.setRuleOrder(order);
        rule.setRuleType(type);
        rule.setTargetDate(date);
        return rule;
    }
}