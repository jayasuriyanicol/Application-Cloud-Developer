package it.demo.quiz.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.demo.quiz.dto.DomandaConRisposteDTO;
import it.demo.quiz.dto.DomandaDTO;
import it.demo.quiz.dto.RispostaDTO;
import it.demo.quiz.service.DomandaService;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/domande")
public class DomandaController {

	@Autowired
	private DomandaService serviceD;
	
	@PatchMapping(path="/{idDomanda}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DomandaConRisposteDTO> modificaDomanda(@PathVariable Integer idDomanda,@RequestBody DomandaDTO dto) {
		dto.setIdDomanda(idDomanda);
		return ResponseEntity.ok(serviceD.modificaDomanda(dto));
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> inserisciDomanda(@RequestBody DomandaConRisposteDTO dto) {
		serviceD.registraDomanda(dto);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping(path="/{idDomanda}/risposta", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DomandaConRisposteDTO> modificaRisposta(@PathVariable Integer idDomanda, @RequestBody RispostaDTO dto){
		return ResponseEntity.ok(serviceD.modificaRispostaDomanda(idDomanda, dto));
	}
	
	@GetMapping(path="/{idDomanda}/versione")
	public Integer checkVersioneDomanda(@PathVariable Integer idDomanda) {
	
//		try {
//			int n = r.nextInt(5000);
//			System.out.println("servizio degrada per >>>>>>>>>>>>>> ["+ Thread.currentThread().getName()+ "]" + n +" secondi");
//			Thread.sleep(n);
//			System.out.println("servizio ripristinato ["+ Thread.currentThread().getName()+ "]");
//		} catch (InterruptedException e) {
//		}
		return serviceD.getVersioneDomanda(idDomanda);
	}
	
	@GetMapping(path="/{idDomanda}")
	public DomandaConRisposteDTO getDomanda(@PathVariable Integer idDomanda) {
		System.out.println("servizio getDomanda invocato " + idDomanda);
		return serviceD.leggiDomanda(idDomanda);
	}
}

