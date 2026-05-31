package com.spring.impiegati.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// -> IMPORT TO ALL : import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.impiegati.dto.ImpiegatoDTO;
import com.spring.impiegati.dto.ImpiegatoNomeCognomeDTO;
import com.spring.impiegati.service.ImpiegatoService;

/* * ImpiegatoController - Employee Management REST Interface
    ? The primary API entry point for the "Impiegati" module. It manages the lifecycle of employee records, handling high-level HR operations such as hiring (assunzione), data retrieval, salary updates, and terminations.

    ! 1. Semantic Endpoint Mapping, follows RESTful standards by using specific HTTP verbs for different operations. Notably, it uses `@PostMapping` for hiring new staff and `@DeleteMapping` for removal, ensuring the API is intuitive and adheres to standard web protocols.
    ! 2. Path Variable Orchestration, effectively captures dynamic data from the URL, such as IDs and salary amounts. The `aggiornaImpiegato` method demonstrates how to handle multiple `@PathVariable` inputs to perform targeted updates on specific employee records.
    ! 3. DTO-Based Response Strategy, ensures that all outgoing data is wrapped in an `ImpiegatoDTO`. This layer of abstraction prevents the internal JPA entity structure from being exposed, allowing for easier maintenance and preventing "Over-Posting" vulnerabilities.
*/

@RestController
@RequestMapping(path="/impiegato")
public class ImpiegatoController {
	
	@Autowired
	private ImpiegatoService service;
	
	
	@PostMapping(path="/aggiungiImp", consumes="application/json")
	public void registra(@RequestBody ImpiegatoDTO impiegato) {
		
		service.assunzione(impiegato);
		
	}
	
	@GetMapping(path="/ricercaId/{id}", produces="application/json")
	public ImpiegatoDTO ricercaId(@PathVariable int id) {
		
		return service.cercaMatricola(id);
		
		
	}
	
	@GetMapping(path="/listaImp", produces="application/json")
	public List<ImpiegatoDTO> listaImpiegati() {
		
		return service.listaImpiegato();
	}
	
	
	@DeleteMapping(path="/eliminaImp/{id}", produces="application/json")
	public ImpiegatoDTO eliminaImpiegato(@PathVariable int id) {
		
		return service.cancellaID(id);		
		
		
	}
	
	@GetMapping(path="/aggiornaImp/{id}/{nuovoSal}", produces="application/json")
	public ImpiegatoDTO aggiornaImpiegato(@PathVariable int id, @PathVariable double nuovoSal) {
		
		return service.aggiornaMatriSal(id, nuovoSal);
	}
	
	
	
	//Adding the EXTRA methods
	
	@DeleteMapping(path="/eliminaImpId/{matricola}", produces="application/json")
	public ImpiegatoNomeCognomeDTO eliminaMatricolaNomCogn(@PathVariable Integer matricola) {
		
		return service.eliminaMatricolaNomCogn(matricola);
	}
	
	
	@GetMapping(path="/impOrdMatr",produces="application/json")
	public List<ImpiegatoNomeCognomeDTO> listaNomCogn (){
		
		return service.listaNomCogn();
		
	}
	
	@GetMapping(path="/ImpSalTot",produces="application/json")
	public Double totaleSalari() {
		
		return service.totaleSalari();
	}
	
	@GetMapping(path="/ImpOrdCogn",produces="application/json")
	public List<ImpiegatoDTO> listaOrdCognome() {
		
		return service.listaOrdCognome();
	}
	
	@GetMapping(path="/ImpAssMax",produces="application/json")
	public ImpiegatoDTO assuntoMaxTemp() {
		
		return service.assuntoMaxTemp();
	}
	
	@GetMapping(path="/ImpSalMax/{dataSpecifica}",produces="application/json")
	public ImpiegatoDTO salarioMaxDatSPec(@PathVariable LocalDateTime dataSpecifica) {
		
		return service.salarioMaxDatSPec(dataSpecifica);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
