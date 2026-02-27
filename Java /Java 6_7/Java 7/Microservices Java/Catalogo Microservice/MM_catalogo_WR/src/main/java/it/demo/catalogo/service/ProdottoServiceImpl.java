package it.demo.catalogo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.demo.catalogo.dto.ProdottoDTO;
import it.demo.catalogo.entity.Prodotto;
import it.demo.catalogo.mapper.MapperProdotto;
import it.demo.catalogo.repository.ProdottoRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class ProdottoServiceImpl implements ProdottoService {
	
	@Autowired
	ProdottoRepository dao;

	@Override
	public ProdottoDTO registraProdotto(ProdottoDTO prodotto) {
		
		Prodotto p = MapperProdotto.ProdottoDTOToEntity(prodotto);
			
		dao.save(p);
		
		
		//Adding the flush to sinchronize the data in the Database
		dao.flush();
		
		return MapperProdotto.ProdottoEntityToDTO(p);
		
		
	}

	@Override
	public ProdottoDTO getProdotto(Integer idProdotto) {
		
		Optional<Prodotto> prod = dao.findById(idProdotto);
		
		if(prod.isPresent()) {
			
			Prodotto prodottoTrovato = prod.get();
			
			return MapperProdotto.ProdottoEntityToDTO(prodottoTrovato);
			
		}
		
		throw new RuntimeException("ATTENZIONE ! Non vi è un prodotto con il seguente ID " + idProdotto);
	}

	@Override
	public List<ProdottoDTO> getProdottiList() {
		
	    List<Prodotto> listaEntity = dao.findAll();
	    
	    if(listaEntity.isEmpty()) {
	    	
	    	throw new RuntimeException("ATTENZIONE ! La lista di prodotti è vuota ");
	    }
	    
	    return (List<ProdottoDTO>) MapperProdotto.ListProdottoEntityToListProdottoDTO(listaEntity);
	}
	
	

	@Override
	public int getVersionProdotto(Integer idProdotto) {
		
		Optional<Prodotto> prod = dao.findById(idProdotto);
		
		if(prod.isPresent()) {
			
			Prodotto prodottoTrovato = prod.get();
			
			return prodottoTrovato.getVersione();
		}
		
		throw new RuntimeException("ATTENZIONE ! Non vi è un prodotto con il seguente ID " + idProdotto);
		
		
		
	}

	@Override
	public ProdottoDTO modificaQuantita(Integer idProdotto, Integer nuovaQuantita) {
		
		Optional<Prodotto> prod = dao.findById(idProdotto);
		
		if(prod.isPresent()) {
			
				
			 Prodotto prodottoTrovato = prod.get();
			
			 prodottoTrovato.setVersione(nuovaQuantita);
			 
			 return MapperProdotto.ProdottoEntityToDTO(prodottoTrovato) ;
			
		
	}
		
		throw new RuntimeException("ATTENZIONE ! Non vi è un prodotto con il seguente ID " + idProdotto);
	}
	

	@Override
	public ProdottoDTO eliminaProdotto(Integer idProdotto) {
		
		Optional<Prodotto> prod = dao.findById(idProdotto);
		
		if(prod.isPresent()) {
			
				
			 Prodotto prodottoTrovato = prod.get();
			 
			 dao.delete(prodottoTrovato);
			 
			 return MapperProdotto.ProdottoEntityToDTO(prodottoTrovato) ;
			
			 
	}
		throw new RuntimeException("ATTENZIONE ! Non vi è un prodotto con il seguente ID " + idProdotto);
	}
	

}
