package com.spring.rubrica.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.rubrica.dto.ContattoTelefonicoDTO;
import com.spring.rubrica.dto.ErroreDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.ContattoTelefonico;
import com.spring.rubrica.entity.Rubrica;
import com.spring.rubrica.service.RubricaService;


/* * RubricaController - Phonebook REST API Endpoint
    ? Acts as the central HTTP interface for the application, managing the lifecycle of 'Rubrica' (Phonebook) entities and their associated 'ContattoTelefonico' (Contacts). It routes incoming web requests to the underlying business service.

    ! 1. Unified GET Strategy, utilizes `@GetMapping` for all operations, including state-changing actions like creation ('/nuova'), deletion ('/cancella'), and updates. While convenient for browser testing, standard REST design typically separates these into POST, PUT, and DELETE methods.
    ! 2. Resource Hierarchy, manages a two-level domain structure: it handles operations on the Phonebook itself (the aggregate root) and deeply nested operations on specific Contacts (e.g., '/preferito', '/gruppo') by passing the parent ID.
    ! 3. Parameter Binding, demonstrates mixed input strategies by using `@PathVariable` to identify resources (IDs) and implicit query parameters to capture data payloads (as seen in `inserisciContatto` and `nuova`).
*/


@RestController
@RequestMapping("/rubrica")
public class RubricaController {
	
	
	//To reduce the complexity and the creation of other types of CONTROLLER, we created only one CONTROLLER to manage all in.
	
	
	//CONTROLLER of RubricaTelefonica sector

    @Autowired
    private RubricaService service;

    @GetMapping(path= "/nuova", consumes="application/json")
    
    public void nuovaRubrica(@RequestBody RubricaDTO rubrica) {
        service.nuovaRubrica(rubrica);
    }

    @GetMapping(path = "/get/{id}")
    
    public Rubrica getRubrica(@PathVariable int id) {
        return service.getRubrica(id);
    }

    @GetMapping(path = "/tutte")
    
    public List<Rubrica> tutteRubriche() {
        return service.tutteRubriche();
    }

    @GetMapping(path = "/cancella/{id}", produces = "application/json")
    
    public Rubrica cancellaRubrica(@PathVariable int id) {
        return service.cancellaRubrica(id); 
    }

    @GetMapping(path =  "/info/{id}")
    
    public String proprietarioAnno (@PathVariable int id) {
        return service.proprietarioAnno(id);
    }

    @GetMapping(path = "/modificaProprietario/{id}/{nuovoNome}", produces = "application/json")
    
    public Rubrica modificaProprietarioNome(@PathVariable int id,@PathVariable String nuovoNome) {
        return service.modificaProprietarioNome(id, nuovoNome);
    }

    @GetMapping(path = "/modificaAnno/{id}/{nuovoAnno}", produces = "application/json")
    
    public Rubrica modificaAnno(@PathVariable int id, @PathVariable String nuovoAnno) {
        return service.modificaAnno(id, nuovoAnno);
    }

    @GetMapping(path = "/proprietari")
    
    public Map<String, Integer> nomiProprietariTotale() {
        return service.nomiProprietariTotale(); 
    }

    @GetMapping(path = "/piuVecchia")
    
    public Rubrica rubricaPiuVecchia() {
        return service.rubricaPiuVecchia();
    }

    @GetMapping(path = "/anni")
    
    public List<String> anniCrescente() {
        return service.anniCrescente();
    }

    @GetMapping(path = "/numContatti/{id}")
    
    public String proprietarioNumeroContatti(@PathVariable int id) {
        return service.proprietarioNumeroContatti(id);
    }

  

    // CONTROLLER of contattoTelefonico
    
    
    //Apply the PostMapping see it on lesson, REST level 2
    @PostMapping(path = "/inserisciContatto/{idRubrica}", consumes = "application/json")
    public ResponseEntity<ErroreDTO> inserisci(@PathVariable int idRubrica, @RequestBody ContattoTelefonicoDTO contattoDTO) {

        try {
            service.inserisciContatto(idRubrica, contattoDTO);
            return new ResponseEntity<ErroreDTO>(HttpStatus.OK);

   
            
        } catch (Exception e) {
        
        	return new ResponseEntity<ErroreDTO>(HttpStatus.BAD_REQUEST);
           
        }
    }


    
    @GetMapping(path = "/contatti/{id}")
    
    public Set<ContattoTelefonico> contatti(@PathVariable int id) {
        return service.tuttiContatti(id);
    }

    @GetMapping("/numeroContatti/{id}")
    
    public int numero(@PathVariable int id) {
        return service.numeroContatti(id);
    }

    @GetMapping(path = "/cercaNumero/{id}/{numero}")
    
    public ContattoTelefonico cerca (@PathVariable int id, @PathVariable String numero) {
        return service.cercaNumero(id, numero);
    }

    @GetMapping(path = "/gruppo/{id}/{gruppo}")
    
    public List<ContattoTelefonico> gruppo( int id, String gruppo) {
        return service.ricercaGruppo(id, gruppo);
    }

    @GetMapping(path = "/preferito/{id}/{nome}/{cognome}")
    
    public ContattoTelefonico preferito(@PathVariable int id, @PathVariable String nome, @PathVariable String cognome) {
        return service.setPreferito(id, nome, cognome);
    }

    @GetMapping(path = "/preferiti/{id}")
    
    public List<ContattoTelefonico> preferiti(@PathVariable int id) {
        return service.preferiti(id);
    }
    
    
   
    
    @ExceptionHandler
    public ResponseEntity<ErroreDTO> handlerSearch(RuntimeException e) {
    	
    	ErroreDTO errore = new ErroreDTO("");
    	
    	errore.setMessaggioErrore(e.getMessage());

    	return new ResponseEntity<ErroreDTO>(errore, HttpStatus.BAD_REQUEST);
    	
    	
    	
    }
}
	