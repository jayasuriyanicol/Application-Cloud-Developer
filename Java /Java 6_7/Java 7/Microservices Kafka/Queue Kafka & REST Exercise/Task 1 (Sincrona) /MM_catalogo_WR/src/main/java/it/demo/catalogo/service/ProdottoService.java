package it.demo.catalogo.service;

import java.util.List;

import it.demo.catalogo.dto.ProdottoDTO;


public interface ProdottoService {

	 ProdottoDTO registraProdotto(ProdottoDTO prodotto);
	
	 ProdottoDTO getProdotto(Integer idProdotto);
	 List<ProdottoDTO> getProdottiList();
	 int getVersionProdotto(Integer idProdotto);
	 
	 ProdottoDTO modificaQuantita(Integer idProdotto, Integer nuovaQuantita);
	 
	 ProdottoDTO eliminaProdotto(Integer idProdotto);
	
	
	
}
