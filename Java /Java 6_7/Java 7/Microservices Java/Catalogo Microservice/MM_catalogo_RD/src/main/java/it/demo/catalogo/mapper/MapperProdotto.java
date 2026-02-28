package it.demo.catalogo.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import it.demo.catalogo.dto.ProdottoDTO;
import it.demo.catalogo.entity.Prodotto;


@Component
public class MapperProdotto {
	
	public static Prodotto ProdottoDTOToEntity (ProdottoDTO dto) {
		
		if(dto==null) return null;

		
		Prodotto entity = new Prodotto();
		
		entity.setIdProdotto(dto.getIdProdotto());
		entity.setPrezzoUnitario(dto.getPrezzoUnitario());
		entity.setCategoria(dto.getCategoria());
		entity.setQuantitàProdotto(dto.getQuantitàProdotto());
		entity.setVersione(dto.getVersione());
		
		return entity;
	}
	
	public static ProdottoDTO ProdottoEntityToDTO (Prodotto entity) {
		
		if(entity==null) return null;

		
		ProdottoDTO dto = new ProdottoDTO();
		
		dto.setIdProdotto(entity.getIdProdotto());
		dto.setPrezzoUnitario(entity.getPrezzoUnitario());
		dto.setCategoria(entity.getCategoria());
		dto.setQuantitàProdotto(entity.getQuantitàProdotto());
		dto.setVersione(entity.getVersione());
		
		return dto;
	}
	
	public static Collection<ProdottoDTO> ListProdottoEntityToListProdottoDTO (Collection<Prodotto> listaProdotti) {
		return listaProdotti.stream().map(p -> ProdottoEntityToDTO(p)).collect(Collectors.toList());
		
	}
	
	
	public static List<Prodotto> ListProdottoDTOToListProdotto (List<ProdottoDTO> listaProdotti) {
		
		return listaProdotti.stream() .map(p -> ProdottoDTOToEntity(p)).collect(Collectors.toList());
	}
}
	
	