package it.corso.bootcamp.controller;

import it.corso.bootcamp.dto.ProdottoResponseDTO;
import it.corso.bootcamp.service.ProdottoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProdottoController {
	private final ProdottoService prodottoService;
	
	public ProdottoController(ProdottoService ps) {
		this.prodottoService = ps;
	}
	
	
	
	@GetMapping("/api/prodotti")
	public List<ProdottoResponseDTO> findAll() {
	return prodottoService.findAll();

	
	}
	
}