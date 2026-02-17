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


/* * EcommerceController - Order Lifecycle API - LEVEL 2 REST
    ? The primary RESTful interface for the E-commerce module, responsible for handling customer order operations. It manages the entire state transition flow of an order, from creation to delivery or cancellation, by delegating to the `OrderService`.

    ! 1. Semantic Verb Usage, distinguishes between resource creation (`@PostMapping`) and partial state modification (`@PatchMapping`). The use of PATCH specifically for status updates highlights a granular approach to resource modification, avoiding full object overwrites.
    ! 2. State-Based Dispatching, the `aggiornaStatoOrdine` method functions as a logic router. Instead of separate endpoints for every action (e.g., /ship, /cancel), it accepts a status string and dynamically dispatches the request to the appropriate service method based on the desired target state.
    ! 3. Response Status Management, explicitly annotates creation methods with `@ResponseStatus(code = HttpStatus.CREATED)`. This ensures the API returns the correct HTTP 201 code, adhering to strict REST standards for resource generation.
*/



@RequestMapping(path = "/ecommerce")
@RestController
public class EcommerceController {


	@Autowired
	OrderService service;


    //Creation, adding the manipulation of the STATUS ORDER
	@ResponseStatus(code = HttpStatus.CREATED)
    
    //Working now in the LEVEL 2 of REST, so adding the '@PostMaopping' and no more the '@GetMapping'
	@PostMapping(path ="/nuovoOrdine",consumes = "application/json", produces = "application/json")
	
	public OrderResponseDTO creaNuovoOrdine(@RequestBody OrderCreateRequestDTO nuovoOrdine) {
		
		return service.creaOrdine(nuovoOrdine);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "/crea/{listaOrdini}", consumes = "application/json", produces = "application/json")
	
	public List<OrderResponseDTO> creaListaOrdini(@RequestBody List<OrderCreateRequestDTO> listaOrdini) {
		return service.creaListaOrdini(listaOrdini);
	}

	@GetMapping(path = "/cerca/{idOrdine}", produces = "application/json")
	
	public OrderResponseDTO cercaOrdineID(@PathVariable int orderId) {
		return service.cercaOrdineID(orderId);
	}

	@GetMapping(path = "/statoOrdine/{statoOrdine}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Collection<OrderResponseDTO> getOrdineStato (String statoOrdine) {
		
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

	
	@PatchMapping(path = "/{ordineId}", produces = "application/json")
	
	public OrderResponseDTO aggiornaStatoOrdine (@PathVariable int ordineId, String statoOrdine) {
		
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

