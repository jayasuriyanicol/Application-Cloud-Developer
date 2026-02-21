package com.spring.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.ecommerce.dto.ProdottoDTO;
import com.spring.ecommerce.dto.VenditoreDTO;
import com.spring.ecommerce.entity.Prodotto;
import com.spring.ecommerce.entity.Venditore;
import com.spring.ecommerce.exception.PasswordNotComunicatedException;
import com.spring.ecommerce.exception.ProdottoNotFoundException;
import com.spring.ecommerce.exception.VenditoreNotFoundException;
import com.spring.ecommerce.mapper.MapperEcommerce;
import com.spring.ecommerce.repository.ProdottoDAO;
import com.spring.ecommerce.repository.VenditoreDAO;

import jakarta.transaction.Transactional;

/* * EcommerceServiceImpl - Marketplace Business Orchestration
    ? The functional heart of the E-commerce module. This class coordinates the interaction between Sellers and Products, enforcing business rules such as mandatory password presence and ensuring that every product added is correctly linked to a valid vendor profile.

    ! 1. Relational Integrity Enforcement, specifically in 'aggiungiProdottoVend', it ensures the bidirectional link is maintained. By retrieving the 'Venditore' entity and manually attaching the new 'Prodotto', it leverages JPA's persistence context to save the entire updated aggregate in a single transactional stroke.
    ! 2. Defensive Resource Validation, utilizes 'Optional' combined with custom exceptions (VenditoreNotFoundException, ProdottoNotFoundException) to provide robust error handling. This prevents the application from processing invalid IDs and ensures the API returns descriptive, user-friendly error messages rather than technical stack traces.
    ! 3. Privacy-Conscious Data Shaping, the 'visualizzaDatiVend' method demonstrates a "View" strategy by explicitly setting the 'listaProdotti' to null. This allows the service to reuse existing DTOs while satisfying specific use cases where only personal vendor data—and not the entire catalog—should be exposed to the client.
*/

@Service
@Transactional
public class EcommerceServiceImpl implements EcommerceService {

   
	@Autowired
	ProdottoDAO Prodottodao;
	
	@Autowired
	VenditoreDAO Venditoredao;



	@Override
	public void inserisciVenditore(VenditoreDTO venditore, String password) {
		
		if(password == null || password.isBlank()) 
			
			throw new PasswordNotComunicatedException("ATTENZIONE ! Errore REGISTRAZIONE VENDITORE\nDato che: la password non risulta inserita !");

		Venditore entity = MapperEcommerce.VenditoreDTOToVenditore(venditore);
		entity.setPassword(password);
		
		Venditoredao.save(entity);
		
	}

	@Override
	public VenditoreDTO visualizzaVendID(Integer idVenditore) {
		
		Optional<Venditore> vend = Venditoredao.findById(idVenditore);
		
		if(vend.isPresent()) {
			
			Venditore vendPresente = vend.get();
			return MapperEcommerce.VenditoreEntityToDTO(vendPresente);
			
			}
		
		throw new VenditoreNotFoundException("ATTENZIONE ! Errore RICERCA FALLITA sul VENDITORE.\nDato che: non risulta essere presente un VENDITORE con questo ID -> " + idVenditore);
	
		
	}

	@Override
	public VenditoreDTO visualizzaDatiVend(Integer idVenditore) {
		
		Optional<Venditore> vend = Venditoredao.findById(idVenditore);
		
		if(vend.isPresent()) {
			
			Venditore vendPresente = vend.get();
			VenditoreDTO venditoreDati = MapperEcommerce.VenditoreEntityToDTO(vendPresente);
			//Only show the data, not the products
			venditoreDati.setListaProdotti(null);
			return venditoreDati;
	}
		
		throw new VenditoreNotFoundException("ATTENZIONE ! Errore non è POSSIBILE VISUALIZZARE I DATI del VENDITORE.\nDato che: non risulta essere presente un VENDITORE con questo ID -> " + idVenditore);
		
		
	}

	@Override
	public VenditoreDTO modificaPassVend(Integer idVenditore, String nuovaPassword) {
		
		Optional<Venditore> vend = Venditoredao.findById(idVenditore);
		
		if(vend.isPresent()) {
			
			Venditore vendIndividuato = vend.get();
			vendIndividuato.setPassword(nuovaPassword);
			
			Venditore aggiornato = Venditoredao.save(vendIndividuato);
			return MapperEcommerce.VenditoreEntityToDTO(aggiornato);
			
		}
		
		throw new VenditoreNotFoundException("ATTENZIONE ! Errore non è possibile soddisfare la sua richiesta di CAMBIO PASSWORD VENDITORE\nDato che: non risulta essere presente un VENDITORE con questo ID -> " + idVenditore);
	}

	@Override
	public void aggiungiProdottoVend(Integer idVenditore, ProdottoDTO prodottoDTO) {
		
		Optional<Venditore> vend = Venditoredao.findById(idVenditore);
		
		if(vend.isPresent()) {
			
			Venditore vendIndividuato = vend.get();
			Prodotto prodotto = MapperEcommerce.ProdottoDTOToEntity(prodottoDTO);
			prodotto.setVenditore(vendIndividuato);
			vendIndividuato.getListaProdotti().add(prodotto);
			
			Venditoredao.save(vendIndividuato);
			
			return;
		}
		
		throw new VenditoreNotFoundException("ATTENZIONE ! Errore non è possibile AGGIUNGERE un NUOVO PRODOTTO sul VENDITORE\nDato che: non risulta essere presente un VENDITORE con questo ID -> " + idVenditore);
		
		
	}

	@Override
	public ProdottoDTO modificaQuantitàProd(Integer idProdotto, Integer nuovaQuantità) {
		
		Optional<Prodotto> prod = Prodottodao.findById(idProdotto);
		
		if(prod.isPresent()) {
			
			 Prodotto prodIndividuato = prod.get();
			
			 prodIndividuato.setQuantità(nuovaQuantità);
			 
			 Prodotto prodSalvato = Prodottodao.save(prodIndividuato);
			 
			 return MapperEcommerce.ProdottoEntityToDTO(prodSalvato);
			
			 
			 
			 
			 
		}
		throw new ProdottoNotFoundException("ATTENZIONE ! Errore non è possibile MODIFICARE LA QUANTITÀ DEL PRODOTTO\nDato che: non risulta essere presente un PRODOTTO con questo ID -> " + idProdotto);
	}

}
