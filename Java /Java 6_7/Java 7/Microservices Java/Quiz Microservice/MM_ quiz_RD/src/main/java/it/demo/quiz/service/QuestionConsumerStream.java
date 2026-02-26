package it.demo.quiz.service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import it.demo.quiz.dto.DomandaConRisposteDTO;
//import it.demo.quiz.entity.Domanda;
//import it.demo.quiz.repository.DomandaRepository;
//import it.demo.quiz.service.client.DomandaWRFeignClient;
//import it.demo.quiz.utility.DomandaUtility;
//
//@Service
//@Transactional
//public class QuestionConsumerStream implements ConsumerStream {
//
//	@Autowired
//	private DomandaRepository daoD;
//	
//	@Autowired
//	private DomandaUtility utilD;
//	
//	//INTERFACCIA CHE DEFINISCE L'INVOCAZIONE AI SERVIZI CON OPEN FEIGN
//	@Autowired
//	private DomandaWRFeignClient dfd;
//	
//	private ObjectMapper objectMapper = new ObjectMapper();
//	
//	@Override
//	@KafkaListener(topics = "my-topic", groupId = "consumer")
//	public void consume(String msg) {
//		System.out.println("messaggio consumato dal servizio 1: " + msg);
//		try {
//			int idDomanda = objectMapper.readValue(msg, Integer.class);
//			DomandaConRisposteDTO dto = dfd.getDomanda(idDomanda);
//			//aggiorno il DB locale
//			Domanda dom = utilD.daDomandaConRispostaDTOADomanda(dto);
//			daoD.save(dom);
//			
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//			throw new RuntimeException(e.getMessage());
//		}  
//		
//	}
//
//}
