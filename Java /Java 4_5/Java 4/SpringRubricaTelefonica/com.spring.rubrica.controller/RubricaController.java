package com.spring.rubrica.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.rubrica.entity.contattoTelefonico;
import com.spring.rubrica.entity.rubrica;
import com.spring.rubrica.service.RubricaService;



/* * RubricaController - Phonebook REST API Endpoint
    ? Acts as the central HTTP interface for the application, managing the lifecycle of 'Rubrica' (Phonebook) entities and their associated 'ContattoTelefonico' (Contacts). It routes incoming web requests to the underlying business service.

    ! 1. Unified GET Strategy, utilizes `@GetMapping` for all operations, including state-changing actions like creation ('/nuova'), deletion ('/cancella'), and updates. While convenient for browser testing, standard REST design typically separates these into POST, PUT, and DELETE methods.
    ! 2. Resource Hierarchy, manages a two-level domain structure: it handles operations on the Phonebook itself (the aggregate root) and deeply nested operations on specific Contacts (e.g., '/preferito', '/gruppo') by passing the parent ID.
    ! 3. Parameter Binding, demonstrates mixed input strategies by using `@PathVariable` to identify resources (IDs) and implicit query parameters to capture data payloads (as seen in `inserisciContatto` and `nuova`).
*/


@RestController
@RequestMapping("/rubriche")
public class RubricaController {

    @Autowired
    private RubricaService service;

 
    
    

    @GetMapping("/nuova")
    public rubrica nuova( String proprietario, String anno) {
        return service.nuovaRubrica(proprietario, anno);
    }

    @GetMapping("/get/{id}")
    public rubrica get(@PathVariable int id) {
        return service.getRubrica(id);
    }

    @GetMapping("/tutte")
    public List<rubrica> tutte() {
        return service.tutteRubriche();
    }

    @GetMapping("/cancella/{id}")
    public rubrica cancella(@PathVariable int id) {
        return service.cancellaRubrica(id);
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable int id) {
        return service.proprietarioAnno(id);
    }

    @GetMapping("/modificaProprietario/{id}/{nome}")
    public rubrica modificaNome(@PathVariable int id,@PathVariable String nome) {
        return service.modificaProprietario(id, nome);
    }

    @GetMapping("/modificaAnno/{id}/{nome}")
    public rubrica modificaAnno(@PathVariable int id, @PathVariable String anno) {
        return service.modificaAnno(id, anno);
    }

    @GetMapping("/proprietari")
    public Map<String, Integer> proprietari() {
        return service.nomiProprietariTotale();
    }

    @GetMapping("/piuVecchia")
    public rubrica piuVecchia() {
        return service.rubricaPiuVecchia();
    }

    @GetMapping("/anni")
    public List<String> anni() {
        return service.anniCrescente();
    }

    @GetMapping("/numContatti/{id}")
    public String numContatti(@PathVariable int id) {
        return service.proprietarioNumeroContatti(id);
    }

  

    @GetMapping("/inserisciContatto")
    public boolean inserisci( int id,String nome,String cognome,String numero, String data) {
    	
        return service.inserisciContatto(id,new contattoTelefonico(nome, cognome, numero, "default", data, false));
    }

    @GetMapping("/contatti/{id}")
    public Set<contattoTelefonico> contatti(@PathVariable int id) {
        return service.tuttiContatti(id);
    }

    @GetMapping("/numeroContatti/{id}")
    public int numero(@PathVariable int id) {
        return service.numeroContatti(id);
    }

    @GetMapping("/cercaNumero/{id}/{numero}")
    public contattoTelefonico cerca (@PathVariable int id, @PathVariable String numero) {
        return service.cercaNumero(id, numero);
    }

    @GetMapping("/gruppo/{id}/{gruppo}")
    public List<contattoTelefonico> gruppo( int id, String gruppo) {
        return service.ricercaGruppo(id, gruppo);
    }

    @GetMapping("/preferito/{id}/{nome}/{cognome}")
    public contattoTelefonico preferito(@PathVariable int id,@PathVariable String nome,@PathVariable String cognome) {
        return service.setPreferito(id, nome, cognome);
    }

    @GetMapping("/preferiti/{id}")
    public List<contattoTelefonico> preferiti(@PathVariable int id) {
        return service.preferiti(id);
    }
}
