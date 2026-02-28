package it.demo.catalogo.service;

import java.util.List;


import it.demo.catalogo.dto.ProdottoDTO;

public interface ProdottoService {

	ProdottoDTO mostraProdottoId(Integer idProdotto);
	List<ProdottoDTO> visualizzaProdotti();
	
}
