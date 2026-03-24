package it.demo.catalogo.config;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.demo.catalogo.controller.ProdottoController;
import it.demo.catalogo.entity.Prodotto;
import it.demo.catalogo.repository.ProdottoRepository;


//Here the MessageConsumer class is responsible the consuming from the Kafka topic and saving the received messages into the RD DB Catalogo.
@Configuration
public class MessageConsumer {

	@Autowired
	private ProdottoRepository prodottoRepository;

	
	@Bean
	public Consumer<String> input() {
		
        //"messaggio" is the payload received from Kafka, which is expected to be a JSON to represent a Prodotto OBJ on RD DB Catalogo.
		return messaggio ->  {
			try { 
				
				ObjectMapper mapper = new ObjectMapper();
				
				Prodotto prodottoRicevuto = mapper.readValue(messaggio, Prodotto.class);
				System.out.println("\nPRODOTTO ID -> " + prodottoRicevuto.getIdProdotto());

                //To avoid any potential issue we set the version to 0, on the other hand the same thing is to eliminate/comment the  annotation on Entity Product.
			    prodottoRicevuto.setVersione(0);
				prodottoRepository.save(prodottoRicevuto);
								
			
            //Success message of RECEIVED and SYNCHRONIZED message on RD DB Catalogo.
			System.out.println("SUCCESSO SINCRONIZZATA ! Il DB RD ha ricevuto il messaggio\n" + messaggio);
			System.out.println("\nPRODOTTO ID -> " + prodottoRicevuto.getIdProdotto());
			System.out.println("\nDETTAGLI del PRODOTTO " + prodottoRicevuto.getIdProdotto());
			System.out.println("\n" + prodottoRicevuto.toString());
			}
			catch (Exception e) {
				
                //Excpetion message to advise the user on the terminal that th message is NOT RECEIVED and NOT SYNCHRONIZED.
				System.err.println("ATTENZIONE ERRORE ! Errore nella sincronizzazione del DB RD, non abbiamo ricevuto nessun messaggio\nRIPROVARE\n" + e.getMessage());
				e.printStackTrace();
				
			}
			
			
		};
	}
}





/** ? Here the DEFAULT code of configuration that can be usefull in future for other purpose.

//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.function.Consumer;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Configuration //NON FUNZIONA
//public class MessageConsumer{
//    
//	@Bean
//    public NewTopic createTopic() {
//		System.out.println("configurazione partizione my-topic");
//        return new NewTopic("my-topic", 3, (short) 1);  // 3 partizioni, 1 replica
//    }
**/
////	@Bean("myConsumer")
////	//@KafkaListener(topics = "my-topic", groupId = "consumer")
////    public Consumer<String> myConsumer() {
////		
////        return message -> System.out.println("Messaggio ricevuto: " + message);
////    }
////    
////    @Bean
////    public Consumer<String> errorChannel() {
////        return message -> System.out.println("messaggio error Channel: " + message);
////    }
//    
//}
