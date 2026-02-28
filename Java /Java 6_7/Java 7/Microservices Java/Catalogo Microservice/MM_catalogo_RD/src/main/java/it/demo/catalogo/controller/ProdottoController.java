package it.demo.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.demo.catalogo.dto.ProdottoDTO;
import it.demo.catalogo.service.ProdottoService;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {

	@Autowired
	private ProdottoService service;
	
	
	@GetMapping(path="/mostraProd/{idProdotto}", produces="application/json", consumes="application/json")
	
	//Insertion of CREATED to clarify the registration of the Product Successfully,
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProdottoDTO mostraProdottoId(@PathVariable Integer idProdotto) {
		
		return service.mostraProdottoId(idProdotto);
	}
	
	@GetMapping(path="/mostraListProd", produces="application/json")
	public List<ProdottoDTO> visualizzaProdotti() {
		
		return service.visualizzaProdotti();
	}
	
	
	

	
}
