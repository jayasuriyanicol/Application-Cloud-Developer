package it.demo.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.demo.catalogo.dto.ProdottoDTO;
import it.demo.catalogo.service.client.ProdottoWRFeignClient;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProdottoServiceImpl implements ProdottoService {
	
	@Autowired
    private ProdottoWRFeignClient wrClient;

	@Override
    public ProdottoDTO mostraProdottoId(Integer idProdotto) {
       
        return wrClient.getProdotto(idProdotto);
    }

    @Override
    public List<ProdottoDTO> visualizzaProdotti() {
       
        List<ProdottoDTO> lista = wrClient.getProdottiList();
        
        if(lista == null || lista.isEmpty()) {
            throw new RuntimeException("ATTENZIONE ! La lista recuperata da WR è vuota !");
        }
        
        return lista;
    }
}

