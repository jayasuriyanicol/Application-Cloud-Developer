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
@Transactional
public class SchedulerService {
	

	    @Autowired
	     EntityOutboxRepository outboxRepo;

	    @Autowired
	     KafkaTemplate<String, String> kafkaTemplate;

	    @Scheduled(fixedDelay = 5000) 
	    @Transactional
	    public void inviaMessaggi() {
	        
			//Adding a syso to have into console the massage of ACTIVE SCHEDULER
			System.out.println(">>> SCHEDULER ATTIVO: Searching PENDING state ...");

	        List<EntityOutbox> eventi = outboxRepo.findByStato(EntityOutbox.TipoStato.PENDING);

	        for (EntityOutbox evento : eventi) {
	            
	            
	            if (evento.getNumeroTentativi() >= 5) {
	                evento.setStato(EntityOutbox.TipoStato.FAIL); 
	                evento.setDataUltimaModifica(LocalDateTime.now());
	                outboxRepo.save(evento);
	                continue;
	            }

				//In this case will be always TRUE, to check the MAX insertion times do it external from the Try - Catch
	            try {
	               
	                kafkaTemplate.send("prodotto-stream-catalog", evento.getPayload()).get(); 

	            
	                evento.setStato(EntityOutbox.TipoStato.SEND); 
	                
	            } catch (Exception e) {
	                
	                evento.setNumeroTentativi(evento.getNumeroTentativi() + 1);
	                
	                System.err.println("ATTENZIONE ! Errore nell'invio Kafka per l'evento con ID -> " + evento.getIdEvento() + ":\nERRORE: " + e.getMessage());
	            }
	            
	            evento.setDataUltimaModifica(LocalDateTime.now()); 
	            outboxRepo.save(evento);
	        }
	    }
	}
