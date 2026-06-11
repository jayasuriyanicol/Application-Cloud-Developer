package it.corso.bootcamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	
	@GetMapping("\status")
	public String statusController() {
		
		return "STATUS ATTIVO";
		
		
	}
	
	

}
