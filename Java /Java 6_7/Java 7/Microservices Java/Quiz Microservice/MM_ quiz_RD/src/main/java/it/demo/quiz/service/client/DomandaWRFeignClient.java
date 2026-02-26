package it.demo.quiz.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.demo.quiz.dto.DomandaConRisposteDTO;

//@FeignClient("MM-quiz-WR-Stream")
@FeignClient("MM-quiz-WR")
public interface DomandaWRFeignClient {

//metodi che servono per impostare la chiamata ai servizi di MM-quiz-WR
@GetMapping(value="/domande/{idDomanda}/versione", consumes="application/json")
Integer getNumeroVersione(@PathVariable Integer idDomanda); 

@GetMapping(value="/domande/{idDomanda}", consumes="application/json")
DomandaConRisposteDTO getDomanda(@PathVariable Integer idDomanda);



}
