// *Impl of the 'createCalendarDraft' method, where the actual business logic for creating a new SchoolCalendar Draft is implemented
@Service
@RequiredArgsConstructor
public class CalendarLifecycleServiceImpl implements CalendarLifecycleService {

    private final SchoolCalendarRepository schoolCalendarRepository;
    private final SchoolCalendarListMapper schoolCalendarListMapper;

    @Override
    @Transactional
    public SchoolCalendarListResponseDTO createCalendarDraft(SchoolCalendarCreateRequestDTO requestDto) {

        // *VALIDATION: Checking temporal coherence (EndDate >= StartDate)
        if (requestDto.getEndDate().isBefore(requestDto.getStartDate())) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "ATTENZIONE! La data di fine non può essere antecedente alla data di inizio"
            );
        }

        // ?Map request payload to domain model
        SchoolCalendar calendar = schoolCalendarListMapper.toEntity(requestDto);
        
        // ?Enforce the initial lifecycle state
        calendar.setStatus(SchoolCalendarStatus.DRAFT);

        // ?Persist entity to database
        SchoolCalendar savedCalendar = schoolCalendarRepository.save(calendar);
        
        // ?Return mapped response contract
        return schoolCalendarListMapper.toDto(savedCalendar);
    }
}