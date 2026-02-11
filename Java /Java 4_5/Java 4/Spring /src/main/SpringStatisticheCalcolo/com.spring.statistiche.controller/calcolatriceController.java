package com.spring.statistiche.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.statistiche.service.calcolatriceService;


/* * calcolatriceController - REST API Endpoint
    ? Acts as the Web Interface (API Layer) for the calculator application. It intercepts HTTP GET requests, extracts numerical parameters from the URL, and delegates the actual computation to the Service layer.

    ! 1. @RestController & Routing, defines the class as a web handler that returns raw data (JSON) rather than a view (HTML). The base path is set to '/calcolatrice'.
    ! 2. @PathVariable, extracts values directly from the URI segments (e.g., /somma/10/5) -> mapping them to method arguments 'a' and 'b'.
    ! 3. Service Delegation, follows the Separation of Concerns principle. The controller does not perform calculations; it forwards the input to 'calcolatriceService' and returns the result.
*/


@RestController
@RequestMapping(path="/calcolatrice")
public class calcolatriceController {
	
	@Autowired 
	private calcolatriceService calcService = new calcolatriceService();
	
	@GetMapping(path="/somma/{a}/{b}", produces="application/json")
	public double somma (@PathVariable double a, @PathVariable double b) {
		
		return calcService.somma(a, b);
		
	}
	

	@GetMapping(path="/sottrazione/{a}/{b}", produces="application/json")
	public double sottrazione ( @PathVariable double a, @PathVariable double b) {
		
		return calcService.sottrazione(a, b);
	}
	
	
	@GetMapping(path="/moltiplicazione/{a}/{b}", produces="application/json")
	public double moltlipicazione( @PathVariable double a, @PathVariable double b) {
		
		return calcService.moltiplicazione(a, b);
	}
	
	@GetMapping(path="/divisione/{a}/{b}", produces="application/json")
	public double divisione ( @PathVariable double a, @PathVariable double b) {
		
		return calcService.divisione(a, b);
	}
	
	
	
	
	
	
	
	
	

}
