// *ContrattoProrogaDomainService.java (Optimized Native Database Index Lookup)


@Service
@RequiredArgsConstructor
public class ContrattoProrogaDomainService {
    private final SchoolCalendarRepository schoolCalendarRepository;

    public ProrogaCalculationResult calculate(...) {
        // ?Refactored: O(1) indexed lookup retrieving a single target record from the database
        SchoolCalendar publishedCalendar = schoolCalendarRepository
            .findFirstByStatusOrderByEndDateDesc(SchoolCalendarStatus.PUBLISHED)
            .orElseThrow(() -> new NoPublishedCalendarFoundException(
                "ATTENZIONE! Impossibile procedere: nessun calendario scolastico pubblicato (PUBLISHED) presente a sistema."
            ));

        if (publishedCalendar != null) {
            LocalDate valueFineAnnoScolastico = publishedCalendar.getEndDate();
            if (valueFineAnnoScolastico != null && nuovaDataFineSenzaFerie.isAfter(valueFineAnnoScolastico)) {
                // *Triggers out-of-bounds warning parameters downstream
                checkOltreFineAnnoScolastico = true; 
            }
        }
        // TODO: Proceed with optimized generation payload...
    }
}