// ? ENDPOINT: to get the list of school calendars for the backoffice, it returns a list of SchoolCalendarListResponseDTO objects

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/supplenti-bo/school-calendars")
public class SchoolCalendarBackOfficeResource {

    private final SchoolCalendarQueryService schoolCalendarQueryService;

    // *GET Rest method to gain all the calendars list
    @GetMapping
    public ServiceResponse<List<SchoolCalendarListResponseDTO>> getAllSchoolCalendars() {

        List<SchoolCalendarListResponseDTO> calendars = schoolCalendarQueryService.getAllCalendarsForBackoffice();
        return ServiceResponse.success(calendars);
    }
}