// *Mapper interface for converting between SchoolCalendar entity and its corresponding DTOs

@Mapper(componentModel = "spring")
public interface SchoolCalendarListMapper {

    SchoolCalendarListResponseDTO toDto(SchoolCalendar entity);

    // Prevents MapStruct compilation warnings for unmapped target properties during build
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "basedOnCalendarId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "publishedAt", ignore = true)
    @Mapping(target = "rules", ignore = true)
    @Mapping(target = "days", ignore = true)
    SchoolCalendar toEntity(SchoolCalendarCreateRequestDTO dto);
}