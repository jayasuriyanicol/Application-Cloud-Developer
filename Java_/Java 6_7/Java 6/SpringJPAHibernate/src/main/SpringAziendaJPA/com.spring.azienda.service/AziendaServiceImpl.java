package com.spring.azienda.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.azienda.dto.AziendaDTO;
import com.spring.azienda.dto.AziendaInfoDTO;
import com.spring.azienda.entity.Azienda;
import com.spring.azienda.mapper.MapperAzienda;
import com.spring.azienda.repository.AziendaDAO;

import jakarta.transaction.Transactional;

/* * AziendaServiceImpl - Business Logic Engine
    ? This class is the operational heart of the company management system. It implements the 'AziendaService' contract, orchestrating the interaction between the persistence layer (AziendaDAO) and the data transport layer (MapperAzienda) to execute complex corporate workflows and analytical calculations.

    ! 1. Transactional State Integrity, utilizes the '@Transactional' annotation at the class level. This ensures that every method execution—especially operations like 'cancellaAziendaNoDipendenti'—is atomic; if any database error occurs mid-process, the system automatically rolls back changes to prevent data corruption.
    ! 2. Functional Analytics & Streams, implements 'visualizzaMaggioreCapitaleAzienda' using the Java Stream API. By leveraging 'Comparator.comparing' on the list of entities, the service identifies the company with the highest social capital in a single pass, demonstrating efficient in-memory processing of business intelligence.
    ! 3. Conditional Logic & Validation, enforces strict business rules such as the "Safe Delete" policy. In 'cancellaAziendaNoDipendenti', the service verifies that the company's employee roster is empty before calling the repository delete method, providing a critical safety net that prevents accidental deletion of active organizational structures.
*/


@Service
@Transactional 
public class AziendaServiceImpl implements AziendaService {
	
	@Autowired
	AziendaDAO aziendaDAO;

	@Override
	public void inserisciNuovaAzienda(AziendaDTO azienda) {
		
		Azienda entity = MapperAzienda.AziendaDTOToEntity(azienda);
		
		aziendaDAO.save(entity);

	}

	@Override
	public AziendaDTO visualizzaDatiAzienda(Integer IdAzienda) {
		
		Optional<Azienda> azi = aziendaDAO.findById(IdAzienda);
		
		if (azi.isPresent()) {
			
			Azienda azienda = azi.get();
			return MapperAzienda.AziendaToDTO(azienda);
		}
		return null;
		
	}

	@Override
	public AziendaDTO visualizzaDatiBase(Integer IdAzienda) {
		
		Optional<Azienda> azi = aziendaDAO.findById(IdAzienda);
		
		if (azi.isPresent()) {
			
			Azienda aziendaPresente = azi.get();
			
			 AziendaDTO azienda = MapperAzienda.AziendaToDTO(aziendaPresente);
			 
			 azienda.setListaDipendenti(null);
			 
			 return azienda;
			
		}
		return null;
	}

	@Override
	public List<AziendaDTO> visualizzaTutteAziende() {
		
		
		List<Azienda> azi = aziendaDAO.findAll();
		
		List<AziendaDTO> listaAziende = (List<AziendaDTO>) MapperAzienda.CollectionAziendaToDTO(azi);
		
		return listaAziende;
		
	}

	@Override
	public AziendaInfoDTO visualizzaNomeNumDip(Integer IdAzienda) {
		
		Optional<Azienda> azi = aziendaDAO.findById(IdAzienda);
		
		if (azi.isPresent()) {
			
			Azienda aziendaPresente = azi.get();
			
			 AziendaInfoDTO azienda = MapperAzienda.AziendaInfoToDTO(aziendaPresente);
			 
			 azienda.setNumeroDipendenti(azienda.getListaDipendenti().size());
			 azienda.setCapitaleSociale(null);
			 azienda.setListaDipendenti(null);
			 
			 return azienda;
			
		}
		
		return null;
		
	    
	}
	
	@Override
	public AziendaInfoDTO visualizzaMaggioreCapitaleAzienda() {
		
		List<Azienda> listaAziende = aziendaDAO.findAll();
		
		Azienda aziendaMaxCap = listaAziende.stream()
				.max(Comparator.comparing(Azienda::getCapitaleSociale))
				.orElseThrow(() -> new RuntimeException("ATTENZIONE ! Nessuna azienda trovata !"));
		
		AziendaInfoDTO dto = MapperAzienda.AziendaInfoToDTO(aziendaMaxCap);
		
		dto.setNumeroDipendenti(aziendaMaxCap.getListaDipendenti().size());
		
		return dto;
	    
		
		
		
	}

	@Override
	public AziendaDTO modificaCapitaleAzienda(Integer IdAzienda,Double CapitaleNuovo) {
		
		Optional<Azienda> azi = aziendaDAO.findById(IdAzienda);
		
		if (azi.isPresent()) {
			
			Azienda aziendaPresente = azi.get();
			
			 AziendaDTO azienda = MapperAzienda.AziendaToDTO(aziendaPresente);
			 
			 azienda.setCapitaleSociale(CapitaleNuovo);

			 
			 return azienda;
			
		}
		
		return null;
		
	    
		
	}

	@Override
	public AziendaDTO modificaIntestazioneAzienda(Integer IdAzienda, String nuovaIntestazione) {
		
		Optional<Azienda> azi = aziendaDAO.findById(IdAzienda);
		
		if (azi.isPresent()) {
			
			Azienda aziendaPresente = azi.get();
			
			 AziendaDTO azienda = MapperAzienda.AziendaToDTO(aziendaPresente);
			 
			 azienda.setIntestazione(nuovaIntestazione);

			 
			 return azienda;
			
		}
		
		return null;
		
		
		
	}

	@Override
	public AziendaDTO cancellaAziendaNoDipendenti(Integer IdAzienda) {
		
		Optional<Azienda> azi = aziendaDAO.findById(IdAzienda);
		
		if (azi.isPresent()) {
		
			
			Azienda aziendaPresente = azi.get();
			
			if(aziendaPresente.getListaDipendenti().isEmpty()) {
			
				AziendaDTO azienda = MapperAzienda.AziendaToDTO(aziendaPresente);
			 
			aziendaDAO.delete(aziendaPresente); 
				
	
			 return azienda;
			
		} 		
	}
		return null;
	}
}
		

		
	
