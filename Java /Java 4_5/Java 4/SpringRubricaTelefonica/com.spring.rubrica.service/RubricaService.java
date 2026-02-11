package com.spring.rubrica.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rubrica.dao.RubricaDAO;
import com.spring.rubrica.entity.contattoTelefonico;
import com.spring.rubrica.entity.rubrica;

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

   
ADD - 11_02_2026 | Adding the CONTROLLER 'calcolatriceController' exercise of AOP Statiche Calcolo
    public rubrica nuovaRubrica(String proprietario, String anno) {
        return dao.insert(new rubrica(proprietario, anno));
    }

    public rubrica getRubrica(int id) {
        return dao.getById(id);
    }

    public List<rubrica> tutteRubriche() {
        return dao.getAll();
    }

    public rubrica cancellaRubrica(int id) {
        return dao.delete(id);
    }

    public String proprietarioAnno(int id) {
        rubrica r = dao.getById(id);
        return r.getProprietario() + " - " + r.getAnnoCreazione();
    }

    public rubrica modificaProprietario(int id, String nuovoNome) {
        rubrica r = dao.getById(id);
        r.setProprietario(nuovoNome);
        return r;
    }

    public rubrica modificaAnno(int id, String nuovoAnno) {
        rubrica r = dao.getById(id);
        r.setAnnoCreazione(nuovoAnno);
        return r;
    }

    public Map<String, Integer> nomiProprietariTotale() {
        Map<String, Integer> res = new HashMap<>();
        for (rubrica r : dao.getAll()) {
            res.put(r.getProprietario(), r.getContatti().size());
        }
        return res;
    }

    public rubrica rubricaPiuVecchia() {
        return dao.getAll().stream()
                .min(Comparator.comparing(r -> Integer.parseInt(r.getAnnoCreazione())))
                .orElse(null);
    }

    public List<String> anniCrescente() {
        return dao.getAll().stream()
                .map(r -> r.getAnnoCreazione())
                .sorted()
                .collect(Collectors.toList());
    }

    public String proprietarioNumeroContatti(int id) {
        rubrica r = dao.getById(id);
        return r.getProprietario() + " - " + r.getContatti().size();
    }
   

    public boolean inserisciContatto(int idRubrica, contattoTelefonico c) {
        return dao.getById(idRubrica).getContatti().add(c);
    }

    public contattoTelefonico getContatto(int idRubrica, String nome, String cognome) {
        return dao.getById(idRubrica).getContatti().stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome)
                        && c.getCognome().equalsIgnoreCase(cognome))
                .findFirst().orElse(null);
    }

    public boolean eliminaContatto(int idRubrica, String nome, String cognome) {
        contattoTelefonico c = getContatto(idRubrica, nome, cognome);
        return dao.getById(idRubrica).getContatti().remove(c);
    }

    public Set<contattoTelefonico> tuttiContatti(int idRubrica) {
        return dao.getById(idRubrica).getContatti();
    }

    public int numeroContatti(int idRubrica) {
        return dao.getById(idRubrica).getContatti().size();
    }

    public contattoTelefonico cercaNumero(int idRubrica, String numero) {
        return dao.getById(idRubrica).getContatti().stream()
                .filter(c -> c.getNumero().equals(numero))
                .findFirst().orElse(null);
    }

    public List<contattoTelefonico> ricercaGruppo(int idRubrica, String gruppo) {
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

    public contattoTelefonico setPreferito(int idRubrica, String nome, String cognome) {
        contattoTelefonico c = getContatto(idRubrica, nome, cognome);
        c.setContattoPreferito(true);
        return c;
    }

    public List<contattoTelefonico> preferiti(int idRubrica) {
        return dao.getById(idRubrica).getContatti().stream()
                .filter(contattoTelefonico::getContattoPreferito)
                .collect(Collectors.toList());
    }
}
