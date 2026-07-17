// *DTO class representing the request payload for creating a new SchoolCalendar Draft

@Data
public class SchoolCalendarCreateRequestDTO {

    @NotBlank(message = "ATTENZIONE! L'anno scolastico è obbligatorio")
    private String academicYear;

    @NotBlank(message = "ATTENZIONE! Il nome del calendario è obbligatorio")
    private String name;

    @NotNull(message = "ATTENZIONE! La data di inizio è obbligatoria")
    private LocalDate startDate;

    @NotNull(message = "ATTENZIONE! La data di fine è obbligatoria")
    private LocalDate endDate;

    @NotNull(message = "Il flag Lunedì è obbligatorio")
    private Boolean workingMonday;

    @NotNull(message = "Il flag Martedì è obbligatorio")
    private Boolean workingTuesday;

    @NotNull(message = "Il flag Mercoledì è obbligatorio")
    private Boolean workingWednesday;

    @NotNull(message = "Il flag Giovedì è obbligatorio")
    private Boolean workingThursday;

    @NotNull(message = "Il flag Venerdì è obbligatorio")
    private Boolean workingFriday;

    @NotNull(message = "Il flag Sabato è obbligatorio")
    private Boolean workingSaturday;

    @NotNull(message = "Il flag Domenica è obbligatorio")
    private Boolean workingSunday;
}