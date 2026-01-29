package Spring.introduzione;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/* * CalcolatriceController - REST Controller
    ? A Spring RestController designated for basic arithmetic operations, mapped to the "/calcolo" base path.

    ! 1. CalcolatriceController(), default constructor.
    ! 2. somma(int n1, int n2), handles GET requests at "/calcolo/somma", accepting two integer parameters to calculate and return their sum.
*/


@RestController
@RequestMapping(path = "/calcolo")
public class CalcolatriceController {
	public CalcolatriceController() {
	}

	@GetMapping(path = "/somma")
	public int somma(int n1, int n2) {
		return n1 + n2;
	}
}