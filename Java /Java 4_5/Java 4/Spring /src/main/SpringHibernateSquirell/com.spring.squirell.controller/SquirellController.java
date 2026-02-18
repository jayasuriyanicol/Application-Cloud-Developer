package com.spring.squirell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pokemon.dto.PokemonDTO;
import com.spring.pokemon.service.PokemonService;

/* * SquirellController - Hibernate-Powered REST API
    ? A REST controller that manages the 'Squirrel' resource lifecycle. It acts as the web-tier interface, exposing endpoints to perform CRUD operations that are ultimately persisted via Hibernate and JPA.

    ! 1. Resource Routing, defines a structured URI hierarchy under `/pokemon`. By utilizing standard HTTP methods like `@PostMapping` for registration, `@GetMapping` for retrieval, and `@DeleteMapping` for removal, it follows the REST architectural style for predictable API interaction.
    ! 2. DTO-Centric Communication, strictly interacts with the `SquirellDTO` rather than the internal Hibernate Entity. This prevents the "Leaky Abstraction" anti-pattern, ensuring that the database schema and JSON structure can evolve independently without breaking the client contract.
    ! 3. Service Layer Delegation, maintains a thin controller implementation by injecting `SquirellService`. This allows the controller to focus on HTTP concerns—like path variables and content types—while leaving the complex transaction management and data mapping to the service layer.
*/



@RestController
@RequestMapping(path="/pokemon")
public class SquirellController {
	
	@Autowired
	private SquirellService service;
	
	@PostMapping(path="/registra", consumes = "application/json")
	public void registra(@RequestBody SquirellDTO dto) {
		
		service.registra(dto);
	}
	
	
	@GetMapping(path="/{id}", produces ="application/json")
	public SquirellDTO cercaPerId(@PathVariable int id) {
		
		return service.cercaPerID(id);
	}
	
	
	//Cerca tutti e elimina per id
	
	
	@GetMapping(path="/cercaTutti", produces="application/json")
	public List<SquirellDTO> cercaTutti() {
		
		  return service.cercaTutti();
		  
	}
	
	
	
	@DeleteMapping(path="/eliminaId/{id}", produces="application/json")
	public void eliminaPerId(@PathVariable int id) {
		
		service.eliminaPerId(id);
	}

}
