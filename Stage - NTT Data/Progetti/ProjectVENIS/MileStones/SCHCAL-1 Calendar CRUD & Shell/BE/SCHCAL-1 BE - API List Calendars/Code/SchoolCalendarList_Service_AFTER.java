// *Here the method Service that call the method to gain the calendars and convert with MapStruct to List
    @Override
    @Transactional(readOnly = true)
    public List<SchoolCalendarListResponseDTO> getAllCalendarsForBackoffice() {

        List<SchoolCalendar> calendars = schoolCalendarRepository.findAllByOrderByAcademicYearDesc();
        return schoolCalendarListMapper.toDtoList(calendars);
    }




// ?MAPPER

    @Mapper(componentModel = "spring")
    public interface SchoolCalendarListMapper {

        // *This to point from the domain/entity 'academicYear' to his alias 'schoolYear'
        @Mapping(source = "academicYear", target = "schoolYear")
        SchoolCalendarListResponseDTO toDto(SchoolCalendar schoolCalendar);

        List<SchoolCalendarListResponseDTO> toDtoList(List<SchoolCalendar> schoolCalendars);
    }