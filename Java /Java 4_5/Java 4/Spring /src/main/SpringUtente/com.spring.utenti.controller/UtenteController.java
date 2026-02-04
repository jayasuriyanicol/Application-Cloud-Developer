package com.spring.utenti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.utenti.entity.Utente;
import com.spring.utenti.service.UtenteService;


/* * UtenteController - REST API Controller
    ? Acts as the entry point for web requests, mapping HTTP endpoints to Java methods and delegating business logic to the 'UtenteService'.

    ! 1. salva(@RequestBody ...), deserializes the incoming JSON payload into an 'Utente' object to perform registration.
    ! 2. visualizza(@PathVariable ...) / cercaPerNome(...), utilizes path variables to extract dynamic parameters directly from the URL for targeted search operations.
    ! 3. lista() / getNomiUtenti(), exposes endpoints that return collections, which Spring automatically serializes into JSON arrays.
    ! 4. cancella(...) / emailAggiorna(...), triggers state-changing operations via specific URL patterns (mapped here to GET for demonstration purposes).
*/



//Method used to initialize the web request handling components or bean after all bean properties have been set.
@RestController 
@RequestMapping(path="/utenti")
public class UtenteController {
	
	private UtenteService service  = new UtenteService();
	
	@GetMapping(path="/salva", consumes= "application/json")
	
	public boolean salva(@RequestBody Utente utente) {
		
		return service.registra(utente);
		
	}
	



/* * Spring Annotations Reference
    ? Technical breakdown of the metadata used to configure the web layer behavior.

    ! 1. @RestController -> marks this class as a web controller where every method inherits @ResponseBody. This means return values are written directly to the HTTP response body (usually as JSON) rather than resolving to a templated view (HTML).
    ! 2. @RequestMapping(path="/utenti") -> establishes the base URI prefix for the entire class. All endpoints defined inside will be relative to "localhost:8080/utenti".
    ! 3. @GetMappin ->  a specialized shortcut for @RequestMapping(method = RequestMethod.GET). It instructs Spring to route only HTTP GET requests matching the specified path to the annotated method.
*/


	
	@GetMapping(path="/cerca/{idUtente}", produces = "application/json")
	public Utente visualizza(@PathVariable int idUtente) {
		
		return service.cercaPerId(idUtente);
	}
	
	
	@GetMapping(path="/lista", produces = "application/json")
	public ArrayList<Utente> lista() {
		
		return service.selectAll();
	}
	
	
	@GetMapping(path="/cancella/{idUtente}", produces ="application/json")
	public Utente cancella(@PathVariable int idUtente) {
		
		return service.cancellaUtente(idUtente);
	}
	
	
	@GetMapping(path="/emailAggiorna/{idUtente}", produces ="application/json")
	public Utente emailAggiorna(@PathVariable int idUtente, String mail) {
		
		return service.modificaMail(idUtente, mail);
	}
	
	
	
	@GetMapping(path="/numeroUtenti", produces="application/json")
	public int numeroUtenti() {
		
		return service.numeroUtenti();
	}
	
	
	@GetMapping(path="/getNomiUtenti", produces="application/json")
	public List<String> getNomiUtenti() {
		
		return service.getNomiUtenti();
	}
	
	@GetMapping(path="/cercaPerNome/{nomeDaCercare}", produces="application/json")
    public List<Utente> cercaPerNome(@PathVariable String nomeDaCercare) {
    	
        
        return service.cercaPerNome(nomeDaCercare);
    }
		
	
	

	

}
