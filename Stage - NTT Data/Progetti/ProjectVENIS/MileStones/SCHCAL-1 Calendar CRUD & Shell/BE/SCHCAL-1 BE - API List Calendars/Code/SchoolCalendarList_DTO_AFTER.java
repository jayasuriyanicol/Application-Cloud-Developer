
// *Here the DTO unique for the list of school calendars, it contains only the fields that are needed for the list view
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

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
}


//