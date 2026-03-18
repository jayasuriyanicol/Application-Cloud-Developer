package it.demo.catalogo.service;


import it.demo.catalogo.dto.ProdottoDTO;

public interface ProdottoService {
    
    ProdottoDTO registraProdotto(ProdottoDTO prodotto);
    ProdottoDTO modificaQuantita(Integer idProdotto, Integer nuovaQuantita);
    ProdottoDTO eliminaProdotto(Integer idProdotto);

   
    ProdottoDTO getProdotto(Integer idProdotto);
}
	
	
	
	
