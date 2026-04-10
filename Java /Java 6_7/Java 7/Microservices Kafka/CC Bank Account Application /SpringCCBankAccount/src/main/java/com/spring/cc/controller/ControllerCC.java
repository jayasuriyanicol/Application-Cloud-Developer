package com.spring.cc.controller;

import com.spring.cc.entity.ContoCorrente;
import com.spring.cc.dto.CCRichiestaDTO;
import com.spring.cc.dto.CCAggiornaSaldoDTO;
import com.spring.cc.service.GestioneContoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestioneCC/conti")
public class ControllerCC {
	
 @Autowired
 private GestioneContoService gestione;
	    
	    
 // ? Creation of a new CC on bank
 @PostMapping(consumes = "application/json", produces = "application/json")
 public ResponseEntity<?> aperturaCC(@RequestBody CCRichiestaDTO richiesta) {
	    	
	        try {
	            ContoCorrente nuovoCC = gestione.registraNuovoConto(
	            		
	            	richiesta.saldoIniziale(), 
	            	richiesta.idIntestatario(), 
	            	richiesta.idCointestatario()
	            	
	            );
	            
	            return new  ResponseEntity<> (nuovoCC, HttpStatus.CREATED);
	            
	        } catch (RuntimeException e) {
	        	
	            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }

	   
 //  ? Deposit or Withdrawal (Change Balance) using the CC bank
 @PutMapping(path= "/{numeroConto}", consumes = "application/json", produces = "application/json")
 public ResponseEntity<?> aggiornaCC( @PathVariable Integer numeroCC, @RequestBody CCAggiornaSaldoDTO richiesta) {
	        
	         try {
	            ContoCorrente CCAggiornato = gestione.aggiornaSaldo(
	                numeroCC, 
	                richiesta.nuovoSaldo(), 
	                richiesta.idOperatore()
	            );
	           
	            return new  ResponseEntity<> (CCAggiornato, HttpStatus.OK);
	            
		        } catch (RuntimeException e) {
		        	
		            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
		        }
	    }

//  ? Unhook joint account holder from bank account
	    
 @DeleteMapping(path = "/{numeroConto}/eliminaCointestatario/{idCointestatario}", produces = "application/json")
 public ResponseEntity<?> eliminaCoinCC (@PathVariable Integer numeroCC, @PathVariable Integer idCointestatario) {
	       
	       try {
	            ContoCorrente CCModificato = gestione.sganciaCointestatario(numeroCC, idCointestatario);
	            
	            return new  ResponseEntity<> (CCModificato, HttpStatus.OK);
	            
	        } catch (RuntimeException e) {
	        	
	            return new ResponseEntity<> (e.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }
	

// ? Deleting a current account, only if the balance is zero, here no produces because the task dosen't ask to return anything
 @DeleteMapping(value = "/{numeroConto}")
 public ResponseEntity<?> eliminaCC(@PathVariable Integer numeroCC) {
	 
    try {
    	// ! I'm going to call the business logic present in the service to manage this
    	gestione.eliminaCC(numeroCC);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	
    } catch (Exception e) {
    	
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

}