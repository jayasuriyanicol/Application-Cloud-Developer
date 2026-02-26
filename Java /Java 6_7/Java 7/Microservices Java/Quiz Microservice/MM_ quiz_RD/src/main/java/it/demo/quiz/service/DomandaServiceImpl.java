package it.demo.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.github.resilience4j.retry.annotation.Retry;
import it.demo.quiz.config.RibbonConfiguration;
import it.demo.quiz.dto.DomandaConRisposteDTO;
import it.demo.quiz.dto.DomandaDTO;
import it.demo.quiz.dto.RispostaDTO;
import it.demo.quiz.entity.Domanda;
import it.demo.quiz.entity.Risposta;
import it.demo.quiz.repository.DomandaRepository;
import it.demo.quiz.service.client.DomandaWRFeignClient;
import it.demo.quiz.utility.DomandaUtility;

@Service
@Transactional
@RibbonClient(name = "MM-quiz-label",configuration = RibbonConfiguration.class)
public class DomandaServiceImpl implements DomandaService {

	@Autowired
	private DomandaRepository daoD;
	
	@Autowired
	private DomandaUtility utilD;
	
	//INTERFACCIA CHE DEFINISCE L'INVOCAZIONE AI SERVIZI CON OPEN FEIGN
	@Autowired
	private DomandaWRFeignClient dfd;


	@Override
//	@CircuitBreaker(name="CircuitBreakerService")
//	@Retry(name="retryApi", fallbackMethod = "fallbackAfterRetry")
	public DomandaConRisposteDTO leggiDomanda(int idDomanda) {
		Domanda d = daoD.findById(idDomanda).orElse(null);
		Integer nVersione=-1;
		if(d!=null) {
			//utilizzo di REST TEMPLATE
			//la url fa riferimento alla il della applicazione registrata su Eureka (qui sarebbe MM-quiz-WR)
			//nVersione = template.getForObject("http://MM-quiz-WR/domande/{idDomanda}/versione", Integer.class, idDomanda);
			
			//UTILIZZO di OPENFEIGN 
			nVersione = dfd.getNumeroVersione(idDomanda); //chiamata di rete
			
			if(nVersione==null || nVersione<d.getVersione()) {
				System.out.println("scenario di incongruenza: il microservizio RW non ha la domanda ma noi si oppure il microservizio WR ha una domanda con numero di versione inferiore al nostro");
				return utilD.daDomandaADomandaConRispostaDTO(d);
			}
		}
		//invocazione al servizio che recupera la domanda dal microservizio Quiz_wr via REST TEMPLATE
		if(d==null || d.getVersione()!=nVersione) {
			DomandaConRisposteDTO dto  = dfd.getDomanda(idDomanda); //chiamata di rete
			if(dto==null)throw new NoSuchElementException("la domanda non esiste");
			
			//aggiorno il DB locale
			Domanda dom = utilD.daDomandaConRispostaDTOADomanda(dto);
			System.out.println("salvo la domanda localmente");
			dom.setVersione(dom.getVersione());
			daoD.save(dom);
			
			return dto;
		}
		return utilD.daDomandaADomandaConRispostaDTO(d);
	}

	@Override
	public List<RispostaDTO> leggiRisposte(int idDomanda) {
		List<Risposta> risp = daoD.findById(idDomanda).orElseThrow().getListaRisposte(); 
		
		return utilD.daListRispostaAListRispostaDTO(risp);
	}
	
	public DomandaConRisposteDTO fallbackAfterCircuitBreaker(int n, Throwable t) {
		System.out.println(">>>>>>>>>>>>> fallbackAfterCircuitBreaker ");
		return new DomandaConRisposteDTO();
	}
	public DomandaConRisposteDTO fallbackAfterRetry(int n, Throwable t) {
		System.out.println(">>>>>>>>>>>>> fallbackAfterRetry ");
		return new DomandaConRisposteDTO();
	}
}
