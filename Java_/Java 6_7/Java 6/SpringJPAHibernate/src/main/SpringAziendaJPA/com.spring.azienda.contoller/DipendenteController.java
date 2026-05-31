package com.spring.azienda.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.azienda.dto.DipendenteDTO;
import com.spring.azienda.service.DipendenteService;

/* * DipendenteController - Workforce & Resource Orchestration
    ? A complex REST controller that manages the lifecycle of employees (Dipendenti) and their associated corporate assets, such as parking spots (Posti Auto) and company affiliations. It acts as the operational hub for human resources logic within the "Azienda" ecosystem.

    ! 1. Polymorphic Registration Strategy, provides multiple entry points for employee onboarding. By utilizing optional path variables and conditional logic in 'inserisciDipendente', the controller gracefully handles three distinct scenarios: basic hiring, hiring with a pre-assigned parking spot, or hiring without specific resource allocation.
    ! 2. Corporate Mobility Management, implements the 'spostaImpiegato' method to handle internal transfers. This logic ensures that when an employee moves between companies, the relational foreign keys are updated correctly through the service layer, maintaining organizational integrity across the database.
    ! 3. Resource Linkage & Querying, features specialized endpoints like 'visualizzaPosto' and 'modificaPosto'. These methods demonstrate the controller's role in managing auxiliary relationships, allowing for the dynamic reassignment of physical company resources based on an employee's unique identification (matricola).
*/

@RestController
@RequestMapping(path="/dipendente")
public class DipendenteController {

	    @Autowired
	    private DipendenteService dipendenteService;

	   
	    @PostMapping("/nuovoSenzaPosto/{idAzienda}")
	    public void inserisciSenzaPosto(@PathVariable Integer idAzienda, @RequestBody DipendenteDTO dto) {
	        dipendenteService.inserisciDipendenteSenzaPostoAuto(idAzienda, dto);
	    }
	    
	    @PostMapping(path = {"/nuovoDipendente/{idAzienda}/{idPosto}", "/nuovoDipendente/{idAzienda}"})
	    public void inserisciDipendente(@RequestBody DipendenteDTO dto,@PathVariable Integer idAzienda,@PathVariable(required = false) Integer idPosto) {
	        

			//If the idPosto is provided and valid, assign the parking spot to the emplyee, otherwise insert the employee without that
	        if (idPosto != null && idPosto > 0) {
	            dipendenteService.inserisciDipendenteAssegnaPostoAuto(idAzienda, idPosto, dto);
	        } else {
	            dipendenteService.inserisciDipendenteSenzaPostoAuto(idAzienda, dto);
	        }
	    }
	    
	    @PostMapping("/nuovoConPosto/{idAzienda}/{idPosto}")
	    public void inserisciConPosto(@PathVariable Integer idAzienda, @PathVariable Integer idPosto, @RequestBody DipendenteDTO dto) {
	        dipendenteService.inserisciDipendenteAssegnaPostoAuto(idAzienda, idPosto, dto);
	    }
	    
	    @GetMapping("/mostraTuttiDip")
	    public List<DipendenteDTO> visualizzaTutti() {
	        return dipendenteService.visualizzaDipendenti();
	    }
	   
	    @GetMapping(path = "/nomeCognDip", produces = "application/json")
	    public List<DipendenteDTO> visualizzaNomiCognDipendenti() {
	        return dipendenteService.visualizzaNomiCognDipendenti();
	    }

	    
	    @GetMapping(value = "/cercaPerSalario/{salario}", produces = "application/json")
	    public List<DipendenteDTO> visualizzaDipeDatoSalario(@PathVariable Double salario) {
	        return dipendenteService.visualizzaDipeDatoSalario(salario);
	    }

	   
	    @DeleteMapping(path = "/cancellaDipMatrBase/{matricola}", produces = "application/json")
	    public DipendenteDTO cancellaImpiegatoMatricola(@PathVariable String matricola) {
	        return dipendenteService.cancellaImpiegatoMatricola(matricola);
	    }
	    
	    @DeleteMapping("/cancellaDipMatrNomCogn/{matricola}")
	    public DipendenteDTO cancellaPerMatricola(@PathVariable String matricola) {
	 
	        return dipendenteService.cancellaImpiegatoMatricola(matricola);
	    }
	    
	    
	    @PutMapping("/spostaImpAzi/{matricola}/{idNuovaAzienda}")
	    public DipendenteDTO spostaImpiegato(@PathVariable String matricola, @PathVariable Integer idNuovaAzienda) {
	        return dipendenteService.spostaImpiegatoAzienda(matricola, idNuovaAzienda);
	    }

	    
	    @PutMapping(path = "/modificaSalarioDip/{matricola}/{nuovoSalario}", produces = "application/json")
	    public DipendenteDTO modificaSalarioDipendente( @PathVariable String matricola, @PathVariable Double nuovoSalario) {
	        return dipendenteService.modificaSalarioDipendente(matricola, nuovoSalario);
	    }
	    
	    @PutMapping("/modificaPosto/{matricola}/{idNuovoPosto}")
	    public DipendenteDTO modificaPosto(@PathVariable String matricola, @PathVariable Integer idNuovoPosto) {
	        return dipendenteService.modificaPostoAuto(matricola, idNuovoPosto);
	    }

	    @GetMapping("/visualizzaPostoEsi/{matricola}")
	    public DipendenteDTO visualizzaPosto(@PathVariable String matricola) {
	        return dipendenteService.visualizzaSeEsistePostoAuto(matricola);
	    }
	    
	}

