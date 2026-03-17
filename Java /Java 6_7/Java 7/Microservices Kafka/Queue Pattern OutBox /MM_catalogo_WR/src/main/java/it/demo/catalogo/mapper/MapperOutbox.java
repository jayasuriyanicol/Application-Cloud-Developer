package it.demo.catalogo.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import it.demo.catalogo.dto.EntityOutboxDTO;

import it.demo.catalogo.entity.EntityOutbox;


@Component 
public class MapperOutbox { 
    

    public static EntityOutbox entityOutboxDTOToEntity(EntityOutboxDTO dto) { 
    	
        if (dto == null) return null; 

        EntityOutbox entity = new EntityOutbox(); 
        entity.setIdEvento(dto.getIdEvento()); 
   
        entity.setTipoEvento(EntityOutbox.TipoEvento.valueOf(dto.getTipoEvento().name()));
      
        entity.setDataCreazione(dto.getDataCreazione()); 
        entity.setDataUltimaModifica(dto.getDataUltimaModifica()); 
        entity.setNumeroTentativi(dto.getNumeroTentativi()); 
        
        entity.setStato(EntityOutbox.TipoStato.valueOf(dto.getStato().name()));
        
        entity.setPayload(dto.getPayload()); 
        entity.setIdProdotto(dto.getIdProdotto()); 
        entity.setVersione(dto.getVersione()); 
        
        return entity; 
    } 
    

    public static EntityOutboxDTO entityOutboxToDTO(EntityOutbox entity) { 
        if (entity == null) return null; 

        EntityOutboxDTO dto = new EntityOutboxDTO(); 
        dto.setIdEvento(entity.getIdEvento());
        
        dto.setTipoEvento(EntityOutboxDTO.TipoEvento.valueOf(entity.getTipoEvento().name()));
        
        dto.setDataCreazione(entity.getDataCreazione());
        dto.setDataUltimaModifica(entity.getDataUltimaModifica());
        dto.setNumeroTentativi(entity.getNumeroTentativi());
        
        dto.setStato(EntityOutboxDTO.TipoStato.valueOf(entity.getStato().name()));
       
        dto.setPayload(entity.getPayload());
        dto.setIdProdotto(entity.getIdProdotto());
        dto.setVersione(entity.getVersione());
        
        return dto; 
    } 

 
    public static Collection<EntityOutboxDTO> listEntityToDTO(Collection<EntityOutbox> lista) { 
        return lista.stream()
                    .map(MapperOutbox::entityOutboxToDTO) 
                    .collect(Collectors.toList()); 
    } 
    
    public static Collection<EntityOutbox> listDTOToEntity(Collection<EntityOutboxDTO> lista) { 
        return lista.stream()
                    .map(MapperOutbox::entityOutboxDTOToEntity) 
                    .collect(Collectors.toList()); 
    } 
}