package it.demo.catalogo.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.demo.catalogo.dto.EntityOutboxDTO;
import it.demo.catalogo.entity.EntityOutbox;
import it.demo.catalogo.mapper.MapperOutbox;
import it.demo.catalogo.repository.EntityOutboxRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EntityOutboxImpl implements EntityOutboxService {
	
	@Autowired
	EntityOutboxRepository dao;

	@Override
	public EntityOutboxDTO registraOutbox(EntityOutboxDTO outboxDto) {
	
		EntityOutbox entity = MapperOutbox.entityOutboxDTOToEntity(outboxDto);

		entity.setStato(EntityOutbox.TipoStato.PENDING);
		entity.setNumeroTentativi(0); 
		entity.setDataCreazione(LocalDateTime.now()); 
		
	
        return MapperOutbox.entityOutboxToDTO(dao.save(entity));
	}

	
	// Questo metodo può essere implementato se serve recuperare un log
    // o lasciato vuoto se la lettura avviene solo tramite lo Scheduler
	@Override
	public EntityOutboxDTO getOutbox() {
		return null;
	}
}