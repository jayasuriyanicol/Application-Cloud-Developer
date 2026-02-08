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
package com.spring.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.UtenteDTO;
import com.spring.entity.Utente;
import com.spring.service.UtenteService;


@RestController
@RequestMapping(path = "/utenti")
public class UtenteController {
	private UtenteService service = new UtenteService();

	@GetMapping(path = "/salva", consumes = "application/json")
	public boolean salva(@RequestBody UtenteDTO utente) {
		return service.registra(utente);
	}

	@GetMapping(path = "/cerca/{idUtente}", produces = "application/json")
	public UtenteDTO visualizza(@PathVariable int idUtente) {
		return service.cercaPerId(idUtente);
	}

	@GetMapping(path = "/cancella/{idUtente}", produces = "application/json")
	public Utente cancellaUtente(@PathVariable int idUtente) {
		return service.eliminaUtente(idUtente);
	}

	@GetMapping(path = "/listaCompleta", produces = "application/json")
	public List<Utente> listaCompletaUtenti() {
		return service.listaUtenti();
	}

	@GetMapping(path = "/aggiornaEmail/{idUtente}/{mail}", produces = "application/json")
	public Utente changeEmail(@PathVariable int idUtente,@PathVariable String mail) {
		return service.aggiornaEmail(idUtente, mail);
	}

	@GetMapping(path = "/numeroUtenti")
	public int getNumeroUtenti() {
		return service.getNumeroUtenti();
	}

	@GetMapping(path = "/listaNomi")
	public List<String> getListaNomi() {
		return service.getNomiUtenti();
	}

	@GetMapping(path = "/cercaPerNome/{nome}", produces = "application/json")
	public List<Utente> cercaUtentiPerNome(@PathVariable String nome) {
		return service.cercaPerNome(nome);
	}

	@GetMapping(path = "/nomiNumero", produces = "application/json")
	public int getNomiNumeroUtenti() {
		return service.getNumeroUtenti();
	}
}
		
	
	

	

}
