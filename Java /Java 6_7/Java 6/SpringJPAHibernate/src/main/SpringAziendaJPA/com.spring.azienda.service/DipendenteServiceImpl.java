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
		dip.setPostoAuto(null);
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
	public DipendenteDTO cancellaImpiegato(Integer IdMatricola) {
		
		Optional<Dipendente> dip = dipendenteDAO.findByMatricola(IdMatricola);
		
		if(dip.isPresent()) {
			
			Dipendente dipendente  = dip.get();
			DipendenteDTO dto = MapperAzienda.DipendenteToDTO(dipendente);
			
			dipendenteDAO.delete(dipendente);
			
			return dto;
		
		
		}
		
		return null;
	}
	
	
	@Override
	public DipendenteDTO cancellaImpiegatoMatricola(Integer IdMatricola) {
		
		Optional<Dipendente> dip = dipendenteDAO.findByMatricola(IdMatricola);
		
		if(dip.isPresent()) {
			
			Dipendente dipendente  = dip.get();
			DipendenteDTO dto = new DipendenteDTO();
			
			dto.setNome(dipendente.getNome());
			dto.setCognome(dipendente.getCognome());
			
			dipendenteDAO.delete(dipendente);
			
			return dto;
		
		
		}
		
		return null;
	}
	
	@Override
	public DipendenteDTO spostaImpiegatoAzienda(Integer matricola, Integer IdAzienda) {
	    
	    Dipendente dipendente = dipendenteDAO.findByMatricola(matricola)
	            .orElseThrow(() -> new RuntimeException("Impiegato con matricola " + matricola + " non trovato"));

	    
	    Azienda nuovaAzienda = aziendaDAO.findById(IdAzienda)
	            .orElseThrow(() -> new RuntimeException("Azienda di destinazione non trovata"));

	   
	    dipendente.setAziendaRiferimento(nuovaAzienda);

	   
	    Dipendente dipendenteAggiornato = dipendenteDAO.save(dipendente);
	    
	    return MapperAzienda.DipendenteToDTO(dipendenteAggiornato);
	}
	
	
	@Override
	public DipendenteDTO modificaSalarioDipendente(Integer IdMatricola, Double salarioNuovo) {
		
		Dipendente dip = dipendenteDAO.findByMatricola(IdMatricola)
	            .orElseThrow(() -> new RuntimeException("Impiegato non trovato"));

	    dip.setSalarioDipendente(salarioNuovo);

	    
	    return MapperAzienda.DipendenteToDTO(dipendenteDAO.save(dip));
		
		
		
		
	}
	@Override
	public DipendenteDTO modificaPostoAuto(Integer IdMatricola, Integer postoAutoNuovo) {
		
		Dipendente dip = dipendenteDAO.findByMatricola(IdMatricola)
	            .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

	   
	    PostoAuto nuovoPosto = (PostoAuto) postoAutoDAO.findById(postoAutoNuovo)
	            .orElseThrow(() -> new RuntimeException("Posto auto non trovato"));

	  
	    dip.setPostoAuto(nuovoPosto);

	  
	    return MapperAzienda.DipendenteToDTO(dipendenteDAO.save(dip));
		
	}
	
	@Override
	public DipendenteDTO visualizzaSeEsistePostoAuto(Integer IdMatricola) {
		Dipendente dip = dipendenteDAO.findByMatricola(IdMatricola)
				
	            .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

	  
	    if (dip.getPostoAuto() == null) {
	        throw new RuntimeException("L'impiegato non possiede un posto auto.");
	    }

	 
	    return MapperAzienda.DipendenteToDTO(dip);
	}
	
	

}
