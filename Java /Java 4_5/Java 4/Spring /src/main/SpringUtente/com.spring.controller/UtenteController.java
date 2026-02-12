package com.spring.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.ErroreDTO;
import com.spring.dto.UtenteDTO;
import com.spring.entity.Utente;
import com.spring.service.UtenteService;


/* * UtenteController - User API & Global Error Handling
    ? Acts as the RESTful interface for managing User entities. Unlike standard controllers, this class integrates a dedicated exception handler to intercept runtime errors and convert them into structured JSON responses.

    ! 1. @ExceptionHandler, a crucial mechanism that acts as a safety net for this controller. Any `RuntimeException` thrown by the service layer (e.g., "User not found") is caught here, stopping the default 500 Internal Server Error and returning a clean `ErroreDTO` instead.
    ! 2. ResponseEntity Wrapper, used within the exception handler to explicitly define the HTTP Status Code. By returning `HttpStatus.BAD_REQUEST` (400), it informs the client that the error was due to invalid input logic rather than a server crash.
    ! 3. Unconventional Method Mapping, exclusively utilizes `@GetMapping` for all CRUD operations (Create, Update, Delete). While this deviates from standard REST principles (POST/PUT/DELETE), it allows for rapid testing of state-changing logic directly via a web browser's address bar.
*/


//Method used to initialize the web request handling components or bean after all bean properties have been set.
@RestController
@RequestMapping(path = "/utenti")
public class UtenteController {
	private UtenteService service = new UtenteService();

	@GetMapping(path = "/salva", consumes = "application/json")
	public void salva(@RequestBody UtenteDTO utente) {
	 service.registra(utente);
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
	
	//Adding the @ExcpetionHandler to manage the Exception cases through the application SprignUtente

	@ExceptionHandler
	public ResponseEntity<ErroreDTO>  handler(RuntimeException ex){
			ErroreDTO errore = new ErroreDTO("");
			errore.setMessaggioErrore(ex.getMessage());
		
			return new ResponseEntity<ErroreDTO>(errore, HttpStatus.BAD_REQUEST);
	} 
}