package com.spring.rubrica.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.rubrica.dao.RubricaDAO;
import com.spring.rubrica.dto.ContattoTelefonicoDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.ContattoTelefonico;
import com.spring.rubrica.entity.Rubrica;

/* * RubricaService - Business Logic Layer
    ? Orchestrates the core functionality of the application, acting as the bridge between the REST Controller and the Data Access Layer. It implements complex operations on Phonebooks and their nested Contacts using functional programming styles.

    ! 1. Functional Data Processing, extensively utilizes the Java Stream API (`filter`, `map`, `sorted`, `min`) to perform in-memory querying and sorting. This allows for logic like finding the "oldest phonebook" or "filtering by group" without creating complex DAO methods.
    ! 2. Aggregate Root Manipulation, treats the `rubrica` entity as the primary access point. Operations on Contacts (insertion, search, marking as favorite) are executed by first retrieving the parent Phonebook and then modifying its internal state, reinforcing the encapsulation of the domain model.
    ! 3. State Mutation, performs direct object modification (e.g., `setContattoPreferito`, `setProprietario`) on entities retrieved from the DAO, relying on the reference-based nature of Java objects to ensure these changes persist in the in-memory map.
*/

@Service
public class RubricaService {

    @Autowired
    private RubricaDAO dao;

   

    public Rubrica nuovaRubrica(RubricaDTO dto) {

        if (dto == null)
            throw new IllegalArgumentException("DTO rubrica nullo");

        if (dto.getProprietario() == null || dto.getProprietario().isBlank())
            throw new IllegalArgumentException("Proprietario mancante");

        if (dto.getAnnoCreazione() == null || dto.getAnnoCreazione().isBlank())
            throw new IllegalArgumentException("Anno creazione mancante");

        Rubrica r = new Rubrica(
                dto.getProprietario(),
                dto.getAnnoCreazione()
        );

        dao.insert(r);
        return r;
    }

    

    public Rubrica getRubrica(int id) {
        return dao.getById(id);
    }

    public List<Rubrica> tutteRubriche() {
        return dao.getAll();
    }

    public Rubrica cancellaRubrica(int id) {
        return dao.delete(id);
    }

    public String proprietarioAnno(int id) {
        Rubrica r = dao.getById(id);
        return r.getProprietario() + " - " + r.getAnnoCreazione();
    }

    public Rubrica modificaProprietarioNome(int id, String nuovoNome) {
        Rubrica r = dao.getById(id);
        r.setProprietario(nuovoNome);
        return r;
    }

    public Rubrica modificaAnno(int id, String nuovoAnno) {
        Rubrica r = dao.getById(id);
        r.setAnnoCreazione(nuovoAnno);
        return r;
    }

    public Map<String, Integer> nomiProprietariTotale() {
        Map<String, Integer> res = new HashMap<>();
        for (Rubrica r : dao.getAll()) {
            res.put(r.getProprietario(), r.getContatti().size());
        }
        return res;
    }

    public Rubrica rubricaPiuVecchia() {
    	
    	//To format correctly the data pattern, and avoid the '/' problem
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return dao.getAll().stream()
                .min(Comparator.comparing(r -> LocalDate.parse(r.getAnnoCreazione(), formatter)))
                .orElse(null);
    }

    public List<String> anniCrescente() {
        return dao.getAll().stream()
                .map(r -> r.getAnnoCreazione())
                .sorted()
                .collect(Collectors.toList());
    }

    public String proprietarioNumeroContatti(int id) {
        Rubrica r = dao.getById(id);
        return r.getProprietario() + " - " + r.getContatti().size();
    }
   

    public void inserisciContatto( int r, ContattoTelefonicoDTO dto) {
    	
    	if (dto == null) 
            throw new IllegalArgumentException("DTO rubrica nullo");

        ContattoTelefonico conct = new ContattoTelefonico(
                dto.getNome(),
                dto.getCognome(),
                dto.getDataNascita(),
                dto.getNumero(),
                dto.getGruppoAppartenenza(),
                dto.getContattoPreferito()
        );
        

        dao.insertContact(r,conct);
        
    }

    public ContattoTelefonico getContatto(int idRubrica, String nome, String cognome) {
        return dao.getById(idRubrica).getContatti().stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome)
                        && c.getCognome().equalsIgnoreCase(cognome))
                .findFirst().orElse(null);
    }

    public boolean eliminaContatto(int idRubrica, String nome, String cognome) {
        ContattoTelefonico c = getContatto(idRubrica, nome, cognome);
        return dao.getById(idRubrica).getContatti().remove(c);
    }

    public Set<ContattoTelefonico> tuttiContatti(int idRubrica) {
        return dao.getById(idRubrica).getContatti();
    }

    public int numeroContatti(int idRubrica) {
        return dao.getById(idRubrica).getContatti().size();
    }

    public ContattoTelefonico cercaNumero(int idRubrica, String numero) {
        return dao.getById(idRubrica).getContatti().stream()
                .filter(c -> c.getNumero().equals(numero))
                .findFirst().orElse(null);
    }

    public List<ContattoTelefonico> ricercaGruppo(int idRubrica, String gruppo) {
        return dao.getById(idRubrica).getContatti().stream()
                .filter(c -> c.getGruppoAppartenenza().equalsIgnoreCase(gruppo))
                .collect(Collectors.toList());
    }

    public int contaGruppo(int idRubrica, String gruppo) {
        return (int) dao.getById(idRubrica).getContatti().stream()
                .filter(c -> c.getGruppoAppartenenza().equalsIgnoreCase(gruppo))
                .count();
    }

    public void eliminaGruppo(int idRubrica, String gruppo) {
        dao.getById(idRubrica).getContatti()
                .removeIf(c -> c.getGruppoAppartenenza().equalsIgnoreCase(gruppo));
    }

    public ContattoTelefonico setPreferito(int idRubrica, String nome, String cognome) {
        ContattoTelefonico c = getContatto(idRubrica, nome, cognome);
        c.setContattoPreferito(true);
        return c;
    }

    public List<ContattoTelefonico> preferiti(int idRubrica) {
        return dao.getById(idRubrica).getContatti().stream()
                .filter(ContattoTelefonico::getContattoPreferito)
                .collect(Collectors.toList());
    }
}
