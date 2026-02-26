package it.demo.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{idDomanda}")
	public ResponseEntity<DomandaConRisposteDTO> leggiDomanda(@PathVariable Integer idDomanda) {
		DomandaConRisposteDTO dto = serviceD.leggiDomanda(idDomanda);
		dto.add(linkTo(methodOn(DomandaController.class).leggiDomanda(idDomanda)).withSelfRel());
		
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/{idDomanda}/risposte")
	public List<RispostaDTO> leggiRisposte(@PathVariable Integer idDomanda){
		return serviceD.leggiRisposte(idDomanda);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> errore(Throwable t){
		System.out.println(t);
		return new ResponseEntity<String>(t.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
