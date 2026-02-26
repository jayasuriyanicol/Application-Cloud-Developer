package com.spring.azienda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.spring.azienda.dto.DipendenteDTO;
import com.spring.azienda.entity.Azienda;
import com.spring.azienda.entity.Dipendente;
import com.spring.azienda.entity.PostoAuto;
import com.spring.azienda.mapper.MapperAzienda;
import com.spring.azienda.repository.AziendaDAO;
import com.spring.azienda.repository.DipendenteDAO;
import com.spring.azienda.repository.PostoAutoDAO;

import jakarta.transaction.Transactional;


/* * DipendenteServiceImpl - Workforce Operational Logic
    ? The core implementation of the employee management service. This class orchestrates high-level business rules by coordinating three distinct repositories (Azienda, PostoAuto, and Dipendente), handling the delicate relational balancing act required for hiring, transferring, and resource allocation.

    ! 1. Relational Integrity Safeguards, utilizes 'orElseThrow' patterns to ensure that an employee is never assigned to a non-existent Company or Parking Spot. By validating these associations before calling '.save()', the service prevents "Foreign Key" constraint violations and ensures the database remains a consistent reflection of the corporate structure.
    ! 2. Atomic Resource Reassignment, implements complex logic in 'spostaImpiegatoAzienda' and 'modificaPostoAuto'. Because the class is marked with '@Transactional', these multi-step operations (fetching a record, updating a reference, and persisting) are executed as a single unit of work, guaranteeing that an employee doesn't end up "orphaned" if a part of the process fails.
    ! 3. Clean-Up & Flush Orchestration, demonstrates advanced JPA management in 'cancellaImpiegatoMatricola'. By manually nullifying references before deletion and calling '.flush()', the service ensures that the persistence context immediately synchronizes with the database, safely removing the employee record even if it was previously linked to other complex entities.
*/

@Service 
@Transactional
public class DipendenteServiceImpl implements DipendenteService {
	
	@Autowired
	AziendaDAO aziendaDAO;
	@Autowired
	PostoAutoDAO postoAutoDAO;
	@Autowired
	DipendenteDAO dipendenteDAO;
	
	@Override
	public void inserisciDipendenteSenzaPostoAuto(Integer IdAzienda,DipendenteDTO dipendente) {
		
		Azienda az = aziendaDAO.findById(IdAzienda)
				
				.orElseThrow(() -> new RuntimeException("ATTENZIONE! Azienda non trovata"));
				
				
		Dipendente dip = MapperAzienda.DipendenteDTOToEntity(dipendente);
		dip.setAziendaRiferimento(az);
		dip.setPostoAuto(null);
		dipendenteDAO.save(dip);
		
	}
	
	@Override
	public void inserisciDipendenteConPostoAuto(Integer IdAzienda, DipendenteDTO dipendente,PostoAuto postoAuto) {

		Azienda az = aziendaDAO.findById(IdAzienda)
				
				.orElseThrow(() -> new RuntimeException("ATTENZIONE! Azienda non trovata"));

		Dipendente dip = MapperAzienda.DipendenteDTOToEntity(dipendente);
		dip.setAziendaRiferimento(az);
		dip.setPostoAuto(postoAuto);
		dipendenteDAO.save(dip);
		
	}
	
	
	@Override
	public void inserisciDipendenteAssegnaPostoAuto(Integer IdAzienda,Integer IdPostoAuto,DipendenteDTO dipendente) {
		
		Azienda az = aziendaDAO.findById(IdAzienda)
				
				.orElseThrow(() -> new RuntimeException("ATTENZIONE! Azienda non trovata"));
		
		PostoAuto pa = (PostoAuto) postoAutoDAO.findById(IdPostoAuto)
				
				.orElseThrow(() -> new RuntimeException("ATTENZIONE! Azienda non trovata"));

		Dipendente dip = MapperAzienda.DipendenteDTOToEntity(dipendente);
		dip.setAziendaRiferimento(az);
		dip.setPostoAuto(pa);
		dipendenteDAO.save(dip);
		
	}
	@Override
	public List<DipendenteDTO> visualizzaDipendenti() {
		

		return (List<DipendenteDTO>) MapperAzienda.CollectionDipendenteToDTO(dipendenteDAO.findAll());
	
		
		
	}
	@Override
	public List<DipendenteDTO> visualizzaNomiCognDipendenti() {
		
		List<Dipendente> listaDipendenti = dipendenteDAO.findAll();
		
		return listaDipendenti.stream()
				.map(dip -> {
					DipendenteDTO dto = new DipendenteDTO();
					dto.setNome(dip.getNome());
					dto.setCognome(dip.getCognome());
					
					return dto;
					
		}) .collect(Collectors.toList());
		
		
	}
	
	@Override
	public List<DipendenteDTO> visualizzaDipeDatoSalario(Double salario) {
		
		List<Dipendente> lista = dipendenteDAO.findBySalarioDipendente(salario);
        return (List<DipendenteDTO>) MapperAzienda.CollectionDipendenteToDTO(lista);
	}
	
	@Override
	public DipendenteDTO cancellaImpiegato(String IdMatricola) {
		
		Optional<Dipendente> dip = dipendenteDAO.findByMatricola(IdMatricola);
		
		if(dip.isPresent()) {
			
			Dipendente dipendente  = dip.get();
			DipendenteDTO dto = MapperAzienda.DipendenteToDTO(dipendente);
			
			dipendenteDAO.delete(dipendente);
			
			return dto;
		
		
		}
		
		throw new RuntimeException("ATTENZIONE ! L'impiegato con matricola " + IdMatricola + " non trovato.");
	}
	
	
	@Override
	public DipendenteDTO cancellaImpiegatoMatricola(String IdMatricola) {
		
		Optional<Dipendente> dip = dipendenteDAO.findByMatricola(IdMatricola);
		
		if(dip.isPresent()) {
			
			Dipendente dipendente  = dip.get();
			dipendente.setAziendaRiferimento(null);
	        dipendente.setPostoAuto(null);
	        
			DipendenteDTO dto = new DipendenteDTO();
			
			dto.setNome(dipendente.getNome());
			dto.setCognome(dipendente.getCognome());
			dto.setMatricola(dipendente.getMatricola());
			
			dipendenteDAO.delete(dipendente);
			dipendenteDAO.flush();
			
			return dto;
		
		
		}
		
		throw new RuntimeException("ATTENZIONE ! L'impiegato con matricola " + IdMatricola + " non trovato.");
	}

	
	@Override
	public DipendenteDTO spostaImpiegatoAzienda(String matricola, Integer IdAzienda) {
	    
	    Dipendente dipendente = dipendenteDAO.findByMatricola(matricola)
	            .orElseThrow(() -> new RuntimeException("ATTENZIONE ! L'impiegato con matricola " + matricola + " non trovato"));

	    
	    Azienda nuovaAzienda = aziendaDAO.findById(IdAzienda)
	            .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Azienda di riferimento non è stata trovata"));

	   
	    dipendente.setAziendaRiferimento(nuovaAzienda);

	   
	    Dipendente dipendenteAggiornato = dipendenteDAO.save(dipendente);
	    
	    return MapperAzienda.DipendenteToDTO(dipendenteAggiornato);
	}
	
	
	@Override
	public DipendenteDTO modificaSalarioDipendente(String IdMatricola, Double salarioNuovo) {
		
		Dipendente dip = dipendenteDAO.findByMatricola(IdMatricola)
	            .orElseThrow(() -> new RuntimeException("ATTENZIONE ! L'impiegato con matricola " + IdMatricola + " non trovato"));

	    dip.setSalarioDipendente(salarioNuovo);

	    
	    return MapperAzienda.DipendenteToDTO(dipendenteDAO.save(dip));
		
		
		
		
	}
	@Override
	public DipendenteDTO modificaPostoAuto(String IdMatricola, Integer postoAutoNuovo) {
		
		Dipendente dip = dipendenteDAO.findByMatricola(IdMatricola)
	            .orElseThrow(() -> new RuntimeException("ATTENZIONE ! L'impiegato con matricola " + IdMatricola + " non trovato"));

	   
	    PostoAuto nuovoPosto = (PostoAuto) postoAutoDAO.findById(postoAutoNuovo)
	            .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Il Posto Auto con codice " + postoAutoNuovo + " non trovato"));

	  
	    dip.setPostoAuto(nuovoPosto);

	  
	    return MapperAzienda.DipendenteToDTO(dipendenteDAO.save(dip));
		
	}
	
	@Override
	public DipendenteDTO visualizzaSeEsistePostoAuto(String IdMatricola) {
		Dipendente dip = dipendenteDAO.findByMatricola(IdMatricola)
				
	            .orElseThrow(() -> new RuntimeException("ATTENZIONE ! L'impiegato con matricola " + IdMatricola + " non trovato");

	  
	    if (dip.getPostoAuto() == null) {
	        throw new RuntimeException("ATTENZIONE ! L'impiegato con matricola " + IdMatricola + " NON POSSIEDE un posto auto !");
	    }

	 
	    return MapperAzienda.DipendenteToDTO(dip);
	}

	
	
	

}
