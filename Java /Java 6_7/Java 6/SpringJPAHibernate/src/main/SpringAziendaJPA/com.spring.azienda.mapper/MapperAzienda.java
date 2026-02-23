package com.spring.azienda.mapper;


import java.util.Collection;
import java.util.stream.Collectors;

import com.spring.azienda.dto.AziendaDTO;
import com.spring.azienda.dto.AziendaInfoDTO;
import com.spring.azienda.dto.DipendenteDTO;
import com.spring.azienda.dto.PostoAutoDTO;
import com.spring.azienda.entity.Azienda;
import com.spring.azienda.entity.Dipendente;
import com.spring.azienda.entity.PostoAuto;


public class MapperAzienda {
	
	public static Azienda AziendaDTOToEntity(AziendaDTO dto) {
		
		if (dto == null) return null;
	
		Azienda entity = new Azienda();
		
		entity.setIdAzienda(dto.getIdAzienda());
		entity.setIntestazione(dto.getIntestazione());
		entity.setCapitaleSociale(dto.getCapitaleSociale());
		entity.setListaDipendenti(dto.getListaDipendenti());
		
		return entity;
		
	}
	
	
	public static AziendaDTO AziendaToDTO(Azienda entity) {
		
		if (entity == null) return null;
		
		AziendaDTO dto = new AziendaDTO();
		
		dto.setIdAzienda(entity.getIdAzienda());
		dto.setIntestazione(entity.getIntestazione());
		dto.setCapitaleSociale(entity.getCapitaleSociale());
		dto.setListaDipendenti(entity.getListaDipendenti());
		
		return dto;
		
	}
	

	public static AziendaInfoDTO AziendaInfoToDTO(Azienda entity) {
		
		if (entity == null) return null;
		
		AziendaInfoDTO dto = new AziendaInfoDTO();
		
		dto.setIdAzienda(entity.getIdAzienda());
		dto.setIntestazione(entity.getIntestazione());
		dto.setCapitaleSociale(entity.getCapitaleSociale());
		dto.setListaDipendenti(entity.getListaDipendenti());
		
		return dto;
	}
	
	
		//Adding to convert any type of Collection in the service methods, same logic of the other
		public static Collection<AziendaDTO> CollectionAziendaToDTO (Collection<Azienda> entity) {
			
			if (entity == null) return null;

			return entity
					.stream()
					.map(a -> AziendaToDTO(a)).collect(Collectors.toList());
				
		}
		
		public static Collection<Azienda> CollectionAziendaDTOToEntity(Collection<AziendaDTO> dto) {
			
			if (dto == null) return null;

			return dto
					.stream()
					.map(a -> AziendaDTOToEntity(a)).collect(Collectors.toList());
				
		}

	
	
	public static Dipendente DipendenteDTOToEntity(DipendenteDTO dto ) {
		
		if(dto == null) return null;
		
		Dipendente entity = new Dipendente();
		
		entity.setMatricola(dto.getMatricola());
		entity.setNome(dto.getNome());
		entity.setCognome(dto.getCognome());
		entity.setSalarioDipendente(dto.getSalarioDipendente());
		entity.setAziendaRiferimento(dto.getAziendaRiferimento());
		entity.setPostoAuto(dto.getPostoAuto());
		
		return entity;
		
	
	}
	
	public static DipendenteDTO DipendenteToDTO (Dipendente entity ) {
		
		if( entity == null) return null;
		
		DipendenteDTO dto = new DipendenteDTO();
		
		dto.setMatricola(entity.getMatricola());
		dto.setNome(entity.getNome());
		dto.setCognome(entity.getCognome());
		dto.setSalarioDipendente(entity.getSalarioDipendente());
		dto.setAziendaRiferimento(entity.getAziendaRiferimento());
		dto.setPostoAuto(entity.getPostoAuto());
		
		return dto;
		
	
	}
	
	
	//Adding to convert any type of Collection in the service methods, same logic of the other
	public static Collection<DipendenteDTO> CollectionDipendenteToDTO (Collection<Dipendente> entity) {
		
		if (entity == null) return null;

		return entity
				.stream()
				.map(a -> DipendenteToDTO(a)).collect(Collectors.toList());
			
	}
	
	public static Collection<Dipendente> CollectionDipendenteDTOToEntity(Collection<DipendenteDTO> dto) {
		
		if (dto == null) return null;

		return dto
				.stream()
				.map(a -> DipendenteDTOToEntity(a))
				.collect(Collectors.toList());
			
	}

	
	
	public static PostoAuto PostoAutoDTOToEntity(PostoAutoDTO dto) {
		
		if ( dto == null) return null;
		
		PostoAuto entity = new PostoAuto();
		
		entity.setIdPostoAuto(dto.getIdPostoAuto());
		entity.setDipendenteAzienda(dto.getDipendenteAzienda());
		entity.setPosizione(dto.getPosizione());
		
		return entity;
		
	}
	
	public static PostoAutoDTO PostoAutoToDTO(PostoAuto entity) {
		
		if ( entity == null) return null;
		
		PostoAutoDTO dto = new PostoAutoDTO();
		
		dto.setIdPostoAuto(entity.getIdPostoAuto());
		dto.setDipendenteAzienda(entity.getDipendenteAzienda());
		dto.setPosizione(entity.getPosizione());
		
		return dto;
		
	
	}
	
	
	//Adding to convert any type of Collection in the service methods, same logic of the other
	public static Collection<PostoAutoDTO> CollectionPostoAutoToDTO (Collection<PostoAuto> entity) {
		
		if (entity == null) return null;

		return entity
				.stream()
				.map(a -> PostoAutoToDTO(a)).collect(Collectors.toList());
			
	}
	
	public static Collection<PostoAuto> CollectionPostoAutoDTOToEntity(Collection<PostoAutoDTO> dto) {
		
		if (dto == null) return null;

		return dto
				.stream()
				.map(a -> PostoAutoDTOToEntity(a))
				.collect(Collectors.toList());
			
	}
	
	

}
