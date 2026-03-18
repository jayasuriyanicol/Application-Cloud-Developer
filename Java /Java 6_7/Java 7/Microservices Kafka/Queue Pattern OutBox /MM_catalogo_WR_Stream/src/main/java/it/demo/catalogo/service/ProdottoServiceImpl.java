package it.demo.catalogo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.demo.catalogo.dto.ProdottoDTO;
import it.demo.catalogo.entity.EntityOutbox;
import it.demo.catalogo.entity.Prodotto;
import it.demo.catalogo.mapper.MapperProdotto;
import it.demo.catalogo.repository.EntityOutboxRepository;
import it.demo.catalogo.repository.ProdottoRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional 
public class ProdottoServiceImpl implements ProdottoService {

    @Autowired
    private ProdottoRepository prodottoDao;

    @Autowired
    private EntityOutboxRepository outboxDao;

    @Autowired
    private com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @Override
    public ProdottoDTO registraProdotto(ProdottoDTO prodottoDto) {
       
        Prodotto p = MapperProdotto.ProdottoDTOToEntity(prodottoDto);
        prodottoDao.save(p);
        prodottoDao.flush();

      
        creaEventoOutbox(p, EntityOutbox.TipoEvento.INSERIMENTO);

        return MapperProdotto.ProdottoEntityToDTO(p);
    }

    @Override
    public ProdottoDTO modificaQuantita(Integer idProdotto, Integer nuovaQuantita) {
        Prodotto p = prodottoDao.findById(idProdotto)
            .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));
        
        p.setQuantitàProdotto(nuovaQuantita);
        
     
        creaEventoOutbox(p, EntityOutbox.TipoEvento.MODIFICA);
        
        return MapperProdotto.ProdottoEntityToDTO(p);
    }

    @Override
    public ProdottoDTO eliminaProdotto(Integer idProdotto) {
        Prodotto p = prodottoDao.findById(idProdotto)
            .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));
        
        
        creaEventoOutbox(p, EntityOutbox.TipoEvento.CANCELLAZIONE);
        
        prodottoDao.delete(p);
        return MapperProdotto.ProdottoEntityToDTO(p);
    }

    
    private void creaEventoOutbox(Prodotto p, EntityOutbox.TipoEvento tipo) {
        try {
            EntityOutbox evento = new EntityOutbox();
            evento.setIdProdotto(p.getIdProdotto()); 
            evento.setTipoEvento(tipo);
            evento.setDataCreazione(LocalDateTime.now()); 
            evento.setStato(EntityOutbox.TipoStato.PENDING); 
            evento.setNumeroTentativi(0); 

            
            String jsonPayload = objectMapper.writeValueAsString(MapperProdotto.ProdottoEntityToDTO(p));
            evento.setPayload(jsonPayload);

            outboxDao.save(evento);
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la creazione dell'evento Outbox", e);
        }
    }

	@Override
	public ProdottoDTO getProdotto(Integer idProdotto) {

	Prodotto p = prodottoDao.findById(idProdotto)
		        .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Prodotto con ID " + idProdotto + " non trovato"));
		    
		    
		    return MapperProdotto.ProdottoEntityToDTO(p);
		
	}
}