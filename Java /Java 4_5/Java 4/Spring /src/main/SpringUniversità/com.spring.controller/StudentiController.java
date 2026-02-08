package com.spring.controller;



import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.StudentiDTO;
import com.spring.entity.Studente;
import com.spring.service.StudentiService;


/* * StudentiController - Student Management API
    ? The REST controller responsible for handling HTTP requests related to the 'Studente' entity. It bridges the gap between external web clients and the internal 'StudentiService'.

    ! 1. registraStudente(@RequestBody ...), handles student enrollment by accepting a DTO (Data Transfer Object), ensuring that the internal entity structure is decoupled from the input JSON.
    ! 2. cercaPerMatricola / cancellaStudente, implements ID-based operations using path variables to locate specific records for retrieval or removal.
    ! 3. listaGiovStu / listaVechStu, exposes specialized endpoints that return HashMaps, representing aggregated data (e.g., mapping surnames to specific years) for reporting on the youngest or oldest students.
*/

/* * Spring Annotations Reference
    ? Technical breakdown of the metadata used to configure the web layer behavior.

    ! 1. @RestController, designates this class as a specialized web controller. It ensures that return values (Objects, Lists, Maps) are automatically serialized into JSON and written to the HTTP response body, rather than being interpreted as HTML view names.
    ! 2. @RequestMapping(path = "/studenti"), sets the base URI for all endpoints in this class. Accessing any method here requires the prefix "/studenti" (e.g., "localhost:8080/studenti/listaStu").
    ! 3. @GetMapping, maps HTTP GET requests to specific methods. Note: In this implementation, @GetMapping is used for all operations (including registration and deletion), whereas standard REST best practices typically reserve GET for data retrieval only.
*/


@RestController
@RequestMapping(path = "/studenti")
public class StudentiController {

	private StudentiService stuService = new StudentiService();

	@GetMapping(path = "/registraStu", consumes = "application/json")
	public boolean registraStudente(@RequestBody StudentiDTO studente) {
		return stuService.registraStudente(studente);
	}

	@GetMapping(path = "/cercaStu/{idStu}", produces = "application/json")
	public StudentiDTO cercaPerMatricola(@PathVariable int idStu) {
		return stuService.cercaPerMatricola(idStu);
	}

	@GetMapping(path = "/cancellaStu/{idStu}", produces = "application/json")
	public Studente cancellaStudente(@PathVariable int idStu) {
		return stuService.eliminaStudente(idStu);
	}

	@GetMapping(path = "/listaStu", produces = "application/json")
	public List<Studente> listaStudenti() {
		return stuService.tuttiStudenti();
	}

	@GetMapping(path = "/aggiornaStu/{idStu}/{nuovoIndirizzo}", produces = "application/json")
	public Studente aggiorna(@PathVariable int idStu,@PathVariable String nuovoIndirizzo) {
		return stuService.aggiornaEmail(idStu, nuovoIndirizzo);
	}

	@GetMapping(path = "/elencoStu")
	public List<String> elencoNomiStudenti() {
		return stuService.elencoNomiStudenti();
	}

	@GetMapping(path = "/listaGiovStu")
	public HashMap<String,String> listaCognomeAnnoStudenteGiovane() {
		return stuService.listaCognomeAnnoStudenteGiovane();
	}

	@GetMapping(path = "/listaVechStu", produces = "application/json")
	public HashMap<String,String>  istaCognomeAnnoIscrizioneStudenteVecchio() {
		return stuService.listaCognomeAnnoIscrizioneStudenteVecchio();
	}

}
