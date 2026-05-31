package Spring.introduzione;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/* * DataController - REST Controller
    ? A Spring RestController that manages date-related HTTP requests under the "/data" path, automatically serializing LocalDate objects to JSON.

    ! 1. getToday(), handles GET requests at "/data/oggi" returning the current system date.
    ! 2. getDate(int anno, int mese, int giorno), handles GET requests at "/data/pers", accepting year, month, and day as parameters to construct and return a specific LocalDate.
*/


@RestController
@RequestMapping(path = "/data")
public class DataController {
	@GetMapping(path = "/oggi")
	public LocalDate getToday() {
		return LocalDate.now();
	}

	@GetMapping(path = "/pers")
	public LocalDate getDate(int anno, int mese, int giorno) {
		return LocalDate.of(anno, mese, giorno);
	}
}