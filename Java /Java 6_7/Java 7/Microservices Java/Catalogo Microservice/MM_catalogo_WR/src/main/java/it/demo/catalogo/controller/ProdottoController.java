package it.demo.catalogo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@PostMapping(path="/registraProd", produces ="application/json", consumes="application/json")
	
	//Insertion of CREATED to clarify the registration of the Product Successfully,
	@ResponseStatus(code = HttpStatus.CREATED)
	public void registraProdotto(@RequestBody ProdottoDTO prodotto) {
		
		service.registraProdotto(prodotto);
	}
	
	@GetMapping(path="/visualizzaProd/{idProdotto}", produces="application/json")
	public ProdottoDTO getProdotto(@PathVariable Integer idProdotto) {
		
		return service.getProdotto(idProdotto);
		
	}
	
	@GetMapping(path="/visualizzaListProd",  produces="application/json")
	 public List<ProdottoDTO> getProdottiList() {
	
		return service.getProdottiList();
	}
	
	@GetMapping(path="/visualizzaVersProd/{idProdotto}",  produces="application/json")
	public int getVersionProdotto(@PathVariable Integer idProdotto) {
		
		return service.getVersionProdotto(idProdotto);
		
	}
	 
	 @PatchMapping(path="/modificaQuanProd/{idProdotto}/{nuovaQuantita}",  produces="application/json")
	 public ProdottoDTO modificaQuantita(@PathVariable Integer idProdotto, @PathVariable Integer nuovaQuantita) {
		 
		 return service.modificaQuantita(idProdotto, nuovaQuantita);
	 }
	 
	 @DeleteMapping(path="/eliminaProd/{idProdotto}", produces="application/json")
	 
	 //Insertion of GONE to clarify the process of Deleted Successfully, but in common uses we can do .NO_CONTENT
	 @ResponseStatus(code = HttpStatus.GONE)
	 ProdottoDTO eliminaProdotto(Integer idProdotto) {
		 
		 return service.eliminaProdotto(idProdotto);
	 }
	
	
	
	
	
	
}

