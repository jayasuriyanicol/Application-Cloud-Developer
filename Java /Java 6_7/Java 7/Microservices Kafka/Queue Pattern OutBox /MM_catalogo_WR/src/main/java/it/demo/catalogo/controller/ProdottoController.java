package it.demo.catalogo.controller;



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
import it.demo.catalogo.service.EntityOutboxImpl;
import it.demo.catalogo.service.ProdottoService;


@RestController 
@RequestMapping("/prodotti") 
public class ProdottoController {

    @SuppressWarnings("unused")
	private final EntityOutboxImpl entityOutboxImpl; 

    @Autowired 
    ProdottoService service;

    ProdottoController(EntityOutboxImpl entityOutboxImpl) {
        this.entityOutboxImpl = entityOutboxImpl;
    } 
     

    @PostMapping(path="/registraProd", produces ="application/json", consumes="application/json") 
    @ResponseStatus(code = HttpStatus.CREATED) 
    public void registraProdotto(@RequestBody ProdottoDTO prodotto) { 
        service.registraProdotto(prodotto); 
    } 
     
   
    @GetMapping(path="/visualizzaProd/{idProdotto}", produces="application/json") 
    public ProdottoDTO getProdotto(@PathVariable Integer idProdotto) { 
        return service.getProdotto(idProdotto); 
    } 

    
     
  
    @PatchMapping(path="/modificaQuanProd/{idProdotto}/{nuovaQuantita}",  produces="application/json") 
    public ProdottoDTO modificaQuantita(@PathVariable Integer idProdotto, @PathVariable Integer nuovaQuantita) { 
        return service.modificaQuantita(idProdotto, nuovaQuantita); 
    } 
      
 
    @DeleteMapping(path="/eliminaProd/{idProdotto}", produces="application/json") 
    @ResponseStatus(code = HttpStatus.GONE) 
    public ProdottoDTO eliminaProdotto(@PathVariable Integer idProdotto) { 
        return service.eliminaProdotto(idProdotto); 
    } 
}

