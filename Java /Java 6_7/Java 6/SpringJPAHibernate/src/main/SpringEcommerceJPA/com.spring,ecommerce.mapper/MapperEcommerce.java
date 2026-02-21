package com.spring.ecommerce.mapper;

import com.spring.ecommerce.dto.ProdottoDTO;
import com.spring.ecommerce.dto.VenditoreDTO;
import com.spring.ecommerce.entity.Prodotto;
import com.spring.ecommerce.entity.Venditore;

/* * MapperEcommerce - Relational Object Transformer
    ? A sophisticated utility class designed to navigate and convert the complex relationships between E-commerce entities and their DTO counterparts. It serves as the logical bridge that flattens circular dependencies and ensures data is formatted correctly for the web layer.

    ! 1. Relational Flattening Strategy, solves the "Infinite Recursion" problem by converting the `Venditore` entity object into a simple `Integer` ID within the `ProdottoDTO`. This allows the client to see who owns a product without triggering a never-ending loop of serialized objects.
    ! 2. Functional Collection Mapping, utilizes Java Streams within the `VenditoreEntityToDTO` method to transform the `List<Prodotto>` into a `List<ProdottoDTO>`. This recursive mapping ensures that when a vendor profile is requested, their entire inventory is automatically translated into the correct client-side format.
    ! 3. Null-Safe Defensive Design, incorporates explicit null checks at the beginning of every static method. This "Fail-Safe" approach prevents `NullPointerExceptions` during the conversion process, ensuring that the service layer can handle empty database results gracefully without crashing the application.
*/

public class MapperEcommerce {
	
	public static Prodotto ProdottoDTOToEntity(ProdottoDTO dto) {
		
		if(dto == null) return null;
		
		Prodotto entity = new Prodotto();
		entity.setIdProdotto(dto.getIdProdotto());
		entity.setDescrizione(dto.getDescrizione());
		entity.setQuantità(dto.getQuantità());
		entity.setPrezzoUnitario(dto.getPrezzoUnitario());
		entity.setSconto(dto.getSconto());
		entity.setCategoria(dto.getCategoria());
	

		
		return entity;
		
	}
	
	public static ProdottoDTO ProdottoEntityToDTO(Prodotto entity) {
		
		
		if(entity == null) return null;
		
		ProdottoDTO dto = new ProdottoDTO();
		dto.setIdProdotto(entity.getIdProdotto());
		dto.setDescrizione(entity.getDescrizione());
		dto.setQuantità(entity.getQuantità());
		dto.setPrezzoUnitario(entity.getPrezzoUnitario());
		dto.setSconto(entity.getSconto());
		dto.setCategoria(entity.getCategoria());
	
		//Manage the case where ID problem Venditore -> Integer e vicervesa
		if(entity.getVenditore() != null) {
					
			dto.setVenditore(entity.getVenditore().getIdVenditore());
				}
		
		return dto;
		
	}
	
	
	
	public static Venditore VenditoreDTOToVenditore(VenditoreDTO dto) {
		
		if(dto == null) return null;
		
		Venditore entity = new Venditore();
		entity.setIdVenditore(dto.getIdVenditore());
		entity.setNome(dto.getNome());
		entity.setCognome(dto.getCognome());
		entity.setCittà(dto.getCittà());
		entity.setUsername(dto.getUsername());
		entity.setVia(dto.getVia());
	

		
		return entity;
		
	}
	
	
	public static VenditoreDTO VenditoreEntityToDTO(Venditore entity) {
		
		
		if(entity == null) return null;
		
		VenditoreDTO dto = new VenditoreDTO();
		dto.setIdVenditore(entity.getIdVenditore());
	    dto.setNome(entity.getNome());
	    dto.setCognome(entity.getCognome());
	    dto.setUsername(entity.getUsername());
	    dto.setVia(entity.getVia());
	    dto.setCittà(entity.getCittà());
	
		//Manage the case where ID problem Venditore -> Integer e vicervesa
		if(entity.getListaProdotti() != null) {
					
			dto.setListaProdotti(entity.getListaProdotti().stream()
					.map(MapperEcommerce:: ProdottoEntityToDTO)
					.toList());
				}
		
		return dto;
		
	}
		
		
	}
