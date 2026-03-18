package it.demo.catalogo.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import it.demo.catalogo.entity.EntityOutbox;
import it.demo.catalogo.repository.EntityOutboxRepository;
import jakarta.transaction.Transactional;


import org.springframework.kafka.core.KafkaTemplate;

@Service
public class SchedulerService {
	


	    @Autowired
	     EntityOutboxRepository outboxRepo;

	    @Autowired
	     KafkaTemplate<String, String> kafkaTemplate;

	    @Scheduled(fixedDelay = 5000) 
	    @Transactional
	    public void inviaMessaggi() {
	      
	        List<EntityOutbox> eventi = outboxRepo.findPendingForUpdate();

	        for (EntityOutbox evento : eventi) {
	           
	            if (evento.getNumeroTentativi() > 5) {
	                evento.setStato(EntityOutbox.TipoStato.FAIL); 
	                outboxRepo.save(evento);
	                continue;
	            }

	            try {
	               
	                kafkaTemplate.send("topic_prodotti", evento.getPayload()).get(); 

	                
	                evento.setStato(EntityOutbox.TipoStato.SEND); 
	                evento.setNumeroTentativi(evento.getNumeroTentativi() + 1); 
	            } catch (Exception e) {
	                
	                evento.setNumeroTentativi(evento.getNumeroTentativi() + 1); 
	            }
	            
	            evento.setDataUltimaModifica(LocalDateTime.now()); 
	            outboxRepo.save(evento);
	        }
	    }
	}

