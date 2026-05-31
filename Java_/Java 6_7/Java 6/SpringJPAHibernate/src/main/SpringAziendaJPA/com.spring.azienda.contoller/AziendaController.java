package com.spring.azienda.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.azienda.dto.AziendaDTO;
import com.spring.azienda.dto.AziendaInfoDTO;
import com.spring.azienda.service.AziendaService;

/* * AziendaController - Enterprise Management Gateway
    ? This REST controller serves as the primary entry point for managing the "Azienda" (Company) ecosystem. It provides a comprehensive set of endpoints to handle administrative tasks, from company registration to complex analytical queries regarding capital and employee distribution.

    ! 1. Granular Data Exposure, offers multiple GET strategies to optimize performance. By separating 'visualizzaDatiCompleti' from 'visualizzaDatiBase', the controller allows the client to choose between a full object graph (including employees) and a lightweight metadata view, reducing unnecessary network payload.
    ! 2. Specialized DTO Projections, utilizes the 'AziendaInfoDTO' for specific analytical endpoints like 'visualizzaAziendaTopCapitale'. This design pattern ensures that sensitive or complex calculations performed at the service layer are delivered in a simplified, flattened format tailored for dashboard-style views.
    ! 3. Resource Lifecycle Orchestration, implements a full suite of HTTP verbs (POST, GET, PUT, DELETE) to manage company state. This includes targeted updates for capital and headings, as well as a conditional deletion strategy that ensures data integrity by preventing the removal of companies with active employees.
*/

@RestController
@RequestMapping(path="/azienda")
public class AziendaController {

    @Autowired
    private AziendaService aziendaService;

    

    @PostMapping(path = "/inserisciAzienda", consumes = "application/json", produces = "application/json")
    public void inserisciNuovaAzienda(@RequestBody AziendaDTO aziendaDTO) {
        aziendaService.inserisciNuovaAzienda(aziendaDTO);
    }
    
    @GetMapping(path = "/mostraAziId/{idAzienda}", produces = "application/json")
    public AziendaDTO visualizzaDatiCompleti(@PathVariable Integer idAzienda) {
        return aziendaService.visualizzaDatiAzienda(idAzienda);
    }
    
    @GetMapping(path = "/mostraAziBaseId/{idAzienda}", produces = "application/json")
    public AziendaDTO visualizzaDatiBase(@PathVariable Integer idAzienda) {
        return aziendaService.visualizzaDatiBase(idAzienda);
    }
    
    @GetMapping(path= "/mostraAziende", produces = "application/json")
    public List<AziendaDTO> visualizzaTutteAziende() {
        return aziendaService.visualizzaTutteAziende();
    }
  
    
    @GetMapping(path = "/mostraAziNomDip/{idAzienda}", produces = "application/json")
    public AziendaInfoDTO visualizzaNomeNumDip(@PathVariable Integer idAzienda) {
        return aziendaService.visualizzaNomeNumDip(idAzienda); 
    }
    
    @GetMapping(path = "/mostraAziCapMax", produces = "application/json")
    public AziendaInfoDTO visualizzaAziendaTopCapitale() {
        return aziendaService.visualizzaMaggioreCapitaleAzienda();
    }
    
 
    @PutMapping(path = "/modificaCapAziId/{idAzienda}/{nuovoCapitale}", produces = "application/json")
    public AziendaDTO modificaCapitale(@PathVariable Integer idAzienda,  @PathVariable Double nuovoCapitale) {
        return aziendaService.modificaCapitaleAzienda(idAzienda, nuovoCapitale);
    }

    
    @PutMapping(path = "/modificaIntestAziId/{idAzienda}/{nuovaIntestazione}", produces = "application/json")
    public AziendaDTO modificaIntestazione( @PathVariable Integer idAzienda, @PathVariable String nuovaIntestazione) {
        return aziendaService.modificaIntestazioneAzienda(idAzienda, nuovaIntestazione);
    }
    
    @DeleteMapping(path = "/cancellaAzi/{idAzienda}", produces = "application/json")
    public AziendaDTO cancellaAziendaNoDipendenti(@PathVariable Integer idAzienda) {
        return aziendaService.cancellaAziendaNoDipendenti(idAzienda);
    }
}