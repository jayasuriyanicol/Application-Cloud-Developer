package com.spring.azienda.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.azienda.dto.AziendaDTO;
import com.spring.azienda.dto.AziendaInfoDTO;
import com.spring.azienda.service.AziendaService;

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