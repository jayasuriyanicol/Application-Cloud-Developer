package it.demo.catalogo.config;

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
//	
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
