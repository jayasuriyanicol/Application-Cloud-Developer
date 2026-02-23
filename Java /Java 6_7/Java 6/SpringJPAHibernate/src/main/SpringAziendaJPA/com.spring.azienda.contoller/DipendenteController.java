package com.spring.azienda.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.azienda.dto.DipendenteDTO;
import com.spring.azienda.service.DipendenteService;

@RestController
@RequestMapping(path="/dipendente")
public class DipendenteController {

	    @Autowired
	    private DipendenteService dipendenteService;

	   
	    @PostMapping(path = "/nuovoDipendente/{idAzienda}/{idPosto}", consumes = "application/json", produces = "application/json")
	    public void inserisciDipendente (@RequestBody DipendenteDTO dto,@PathVariable Integer idAzienda, @PathVariable Integer idPosto) {
	        
	        if (idPosto != null) {
	            dipendenteService.inserisciDipendenteAssegnaPostoAuto(idAzienda, idPosto, dto);
	            
	        } else {
	        	
	            dipendenteService.inserisciDipendenteSenzaPostoAuto(idAzienda, dto);
	        }
	    }

	   
	    @GetMapping(path = "/nomeCognDip", produces = "application/json")
	    public List<DipendenteDTO> visualizzaNomiCognDipendenti() {
	        return dipendenteService.visualizzaNomiCognDipendenti();
	    }

	    
	    @GetMapping(value = "/cercaPerSalario/{salario}", produces = "application/json")
	    public List<DipendenteDTO> visualizzaDipeDatoSalario(@PathVariable Double salario) {
	        return dipendenteService.visualizzaDipeDatoSalario(salario);
	    }

	   
	    @DeleteMapping(path = "/cancellaDip/{matricola}", produces = "application/json")
	    public DipendenteDTO cancellaImpiegatoMatricola(@PathVariable Integer matricola) {
	        return dipendenteService.cancellaImpiegatoMatricola(matricola);
	    }

	    
	    @PutMapping(path = "/modificaSalario/{matricola}/{nuovoSalario}", produces = "application/json")
	    public DipendenteDTO modificaSalarioDipendente( @PathVariable Integer matricola, @PathVariable Double nuovoSalario) {
	        return dipendenteService.modificaSalarioDipendente(matricola, nuovoSalario);
	    }
	}

