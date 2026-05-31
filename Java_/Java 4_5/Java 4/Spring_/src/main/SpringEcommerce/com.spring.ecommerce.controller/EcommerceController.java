
package com.spring.ecommerce.controller;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.spring.ecommerce.dto.OrderCreateRequestDTO;
import com.spring.ecommerce.dto.OrderResponseDTO;
import com.spring.ecommerce.exception.FieldNotValidException;
import com.spring.ecommerce.exception.StateOrderdNotValide;

import com.spring.ecommerce.service.OrderService;


/* * EcommerceController - API Gateway & Orchestrator
    ? The primary REST entry point for the application. It maps incoming HTTP requests to specific service-layer logic, handling the routing for order creation, retrieval, and lifecycle management via clear semantic endpoints.

    ! 1. Request Mapping Strategy, utilizes a mix of `@PostMapping`, `@GetMapping`, and `@PatchMapping` to adhere to RESTful principles. It strictly defines media types (`application/json`) to ensure consistent data exchange between the client and the Spring container.
    ! 2. Validation & Branching Logic, acts as a traffic controller using `switch` statements to validate URL path variables. It proactively throws custom exceptions like `FieldNotValidException` or `StateOrderdNotValide` before hitting the service layer, preventing illegal operations at the edge of the application.
    ! 3. Resource Transformation, delegates heavy lifting to the `OrderService` but controls the HTTP response status (e.g., returning `201 Created` for successful posts). It ensures that the client always receives a clean `OrderResponseDTO`, hiding internal entity complexities.
*/


@RequestMapping(path = "/ecommerce")
@RestController
public class EcommerceController {


	@Autowired
	OrderService service;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path ="/nuovoOrdine",consumes = "application/json", produces = "application/json")
	
	public OrderResponseDTO creaNuovoOrdine(@RequestBody OrderCreateRequestDTO nuovoOrdine) {
		
		return service.creaOrdine(nuovoOrdine);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "/crea", consumes = "application/json", produces = "application/json")
	
	public List<OrderResponseDTO> creaListaOrdini(@RequestBody List<OrderCreateRequestDTO> listaOrdini) {
		return service.creaListaOrdini(listaOrdini);
	}

	@GetMapping(path = "/cerca/{idOrdine}", produces = "application/json")
	
	public OrderResponseDTO cercaOrdineID(@PathVariable int idOrdine) {
		return service.cercaOrdineID(idOrdine);
	}

	@GetMapping(path = "/statoOrdine/{statoOrdine}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Collection<OrderResponseDTO> getOrdineStato (@PathVariable String statoOrdine) {
		
		if (statoOrdine == null)
			throw new FieldNotValidException("ATTENZIONE ! Il campo deve essere selezionato, NON può rimanere vuoto !");

		switch (statoOrdine.toLowerCase()) {
			case "created":
				return service.cercaOrdineCreato();

			case "confirmed":
				return service.ceracOrdineConfermato();

			case "shipped":
				return service.cercaOrdineSpedito();

			default:
				throw new FieldNotValidException(statoOrdine + "ATTENZIONE ! È stato inserito un valore non valido tra quelli presenti\nRIPROVARE !");
		}
	}

	
	@PatchMapping(path = "/aggiornaStato/{ordineId}/{statoOrdine}", produces = "application/json")
	
	public OrderResponseDTO aggiornaStatoOrdine (@PathVariable int ordineId,@PathVariable String statoOrdine) {
		
		if (statoOrdine == null)
			throw new FieldNotValidException("ATTENZIONE ! Il campo deve essere selezionato, NON può rimanere vuoto !");

		switch (statoOrdine.toLowerCase()) {
		
			case "created":
				throw new StateOrderdNotValide("ATTENZIONE ! NON può essere cambiato lo STATUS ad un ordine già CREATO !");

			case "confirmed":
				return service.confermaOrdine(ordineId);

			case "shipped":
				return service.spediciOrdine(ordineId);

			case "delivered":
				return service.inviaOrdine(ordineId);

			case "cancelled":
				return service.cancellaOrdine(ordineId);

			default:
				throw new FieldNotValidException(statoOrdine + "ATTENZIONE ! È stato inserito un valore non valido tra quelli presenti\nRIPROVARE !");
		}
	}
}

