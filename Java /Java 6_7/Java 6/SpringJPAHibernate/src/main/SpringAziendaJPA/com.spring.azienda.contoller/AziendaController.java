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

    
    @GetMapping(path= "/mostraAziende", produces = "application/json")
    public List<AziendaDTO> visualizzaTutteAziende() {
        return aziendaService.visualizzaTutteAziende();
    }

    
    @GetMapping(path = "/mostraAziCapMax", produces = "application/json")
    public AziendaInfoDTO visualizzaNomeNumDip() {
        return aziendaService.visualizzaNomeNumDip(null); 
    }

    
    @DeleteMapping(path = "/cancellaAzi/{idAzienda}", produces = "application/json")
    public AziendaDTO cancellaAziendaNoDipendenti(@PathVariable Integer idAzienda) {
        return aziendaService.cancellaAziendaNoDipendenti(idAzienda);
    }
}