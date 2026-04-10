package com.spring.cc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.cc.dto.ReportUtenteDTO;
import com.spring.cc.entity.Utente;
import com.spring.cc.service.GestioneContoService;
import com.spring.cc.service.GestioneValiditaService;

@RestController
@RequestMapping("/gestioneUtenti/utenti")
public class ControllerUtente {
    
    @Autowired
    private GestioneContoService cc;
    
    @Autowired
    private GestioneValiditaService validita;

    // ! Here CRUD user registration & manipulation to the Persistence Layer
    @PostMapping(consumes ="application/json")
    public ResponseEntity<Utente> registraUtente(@RequestBody Utente utente) {
    	
        return new ResponseEntity<>(cc.registraUtente(utente), HttpStatus.CREATED);
    }
    
    
    
    public ResponseEntity<Utente> modifica(@PathVariable Integer idUtente, @RequestBody Utente nuoviDati) {
        try {
            Utente aggiornato = cc.modificaDatiUtente(idUtente, nuoviDati);
            return new ResponseEntity<>(aggiornato, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    

   
    @GetMapping(value = "/{idUtente}", produces = "application/json")
    public ResponseEntity<Utente> getUtente(@PathVariable Integer idUtente) {
        Utente trovato = validita.getSingoloUtente(idUtente);
        return trovato != null ? ResponseEntity.ok(trovato) : ResponseEntity.notFound().build();
    }
 
    
    
    @DeleteMapping(value = "/{idUtente}")
    public ResponseEntity<?> cancella(@PathVariable Integer idUtente) {
        try {
            
            cc.cancellaUtente(idUtente);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (RuntimeException e) {
            
        	// * Specified the FORBIDDEN value, not BAD_REQUEST as always
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
    
    

    // ? Generating a report of students
    @GetMapping(value = "/report", produces = "application/json")
    public ResponseEntity<List<ReportUtenteDTO>> getReportUtenti() {
      
    	// * Calling the method on validità service bsuiness logic
        return new ResponseEntity<>(validita.generaReportUtenti(), HttpStatus.OK);
    }
}