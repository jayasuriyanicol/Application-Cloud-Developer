## Solution: Creation & Implementatiom

To resolve the problem of no list consulting, we created a DTO provate to encapsulate data.

```java
@Getter
@Setter
public class SchoolCalendarListResponseDTO {

    private Long id;
    private String schoolYear;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private SchoolCalendarStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

```

## Service with Logic

### 1. Method Service  

Manage the logic of gain the calendar from the BE:

```java
// *Here the method Service that call the method to gain the calendars and convert with MapStruct to List
    @Override
    @Transactional(readOnly = true)
    public List<SchoolCalendarListResponseDTO> getAllCalendarsForBackoffice() {

        List<SchoolCalendar> calendars = schoolCalendarRepository.findAllByOrderByAcademicYearDesc();
        return schoolCalendarListMapper.toDtoList(calendars);
    }
```

### 2. Mapper

```java
    // *This to point from the domain/entity 'academicYear' to his alias 'schoolYear'
    @Mapping(source = "academicYear", target = "schoolYear")
    SchoolCalendarListResponseDTO toDto(SchoolCalendar schoolCalendar);
```

---

## TEST

### Result on the BE

Impact tests, implemented with the others MOCK test approved all

![ListSchCal IMPACT](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendarList%20-%20ImpactSuccess.png?raw=true)

So applying the changes into all the BE system, here the check to validate:

![ListSchCal BE](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/SchoolCalendaList%20-%20SuccessBE.png?raw=true)



## ✅ Outcome

The system successfully now have the possibility in the BE to have the consult of list calendars, now is necessary adapt it in the VISIBLE data in FE. 

With this changes with a good structural process of validating the payload of calendar not duplicate, now we have a optmized system usefull to construct the FE.