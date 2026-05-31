package Spring.introduzione;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/* * HelloController - REST Controller
    ? A Spring RestController that handles HTTP requests under the "/saluto" path, demonstrating basic routing and parameter handling.

    ! 1. HelloController(), the constructor that logs a message to console to demonstrate when Spring initializes this Bean.
    ! 2. salutaMondo(), handles GET requests at "/saluto/mondo" returning a static "Hello world!!" string.
    ! 3. salutoPers(String nome), handles GET requests at "/saluto/pers", accepting a query parameter "nome" to return a personalized greeting.
*/


@RestController
@RequestMapping(path = "/saluto")
public class HelloController {
	public HelloController() {
		System.out.println("spring sta costruendo HelloController");
	}

	@GetMapping(path = "/mondo")
	public String salutaMondo() {
		System.out.println("chiama il metodo");
		return "Hello world!!";
	}

	@GetMapping(path = "/pers")
	public String salutoPers(String nome) {
		System.out.println("metodo 2");
		return "Hello " + nome;
	}
}