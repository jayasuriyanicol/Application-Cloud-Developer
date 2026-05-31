package com.spring.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.spring.dto.UtenteDTO;
import com.spring.entity.Utente;

import DAO.DAOUtenteMappa;

/* * UtenteService - Business Logic Layer
    ? Represents the service layer responsible for managing User business logic, acting as an intermediary between external requests and the persistence layer (DAOUtenteMappa).

    ! 1. registra(Utente utente), handles the "sign-up" process by logging the event and delegating the persistence task to the DAO.
    ! 2. modificaMail(...), implements a specific update strategy by removing the user, modifying the email in-memory, and re-inserting the updated entity to persist the change.
    ! 3. CRUD Delegation, methods like cercaPerId, selectAll, and cancellaUtente primarily act as wrappers that forward calls directly to the underlying DAO implementation.
*/


public class UtenteService {

	private DAOUtenteMappa dao = new DAOUtenteMappa();
	
	public boolean registra(UtenteDTO dto) {
		
		Utente utente = new Utente();
		utente.setCognome(dto.getCognome());
		utente.setIdUtente(dto.getIdUtente());
		utente.setMail(dto.getMail());
		utente.setNome(dto.getNome());
		utente.setTelefono(dto.getTelefono());

		return dao.insert(utente);
	}

	public UtenteDTO cercaPerId(int idUtente) {
		// return dao.selectById(idUtente);
		Utente u = dao.selectById(idUtente);

		return new UtenteDTO(u.getNome(), u.getCognome(), u.getMail(), u.getTelefono(), u.getIdUtente());
	}

	public List<Utente> listaUtenti() {
		return dao.selectAll();
	}

	public Utente eliminaUtente(int idUtente) {
		return dao.delete(idUtente);
	}

	public Utente aggiornaEmail(int idUtente, String nuovaEmail) {
		if (cercaPerId(idUtente) == null)
			return null;
		Utente utenteCancellato = dao.delete(idUtente);
		utenteCancellato.setMail(nuovaEmail);
		dao.insert(utenteCancellato);
		return utenteCancellato;
	}

	public int getNumeroUtenti() {
		return dao.selectAll().size();
	}

	public List<String>  getNomiUtenti() {
		ArrayList<String> res = new ArrayList<>();

		for (Utente ut : dao.selectAll())
			res.add(ut.getNome());

		return res;
	}

	public List<Utente> cercaPerNome(String nome) {
		ArrayList<Utente> res = new ArrayList<>();

		for (Utente ut : dao.selectAll())
			if (ut.getNome().equals(nome))
				res.add(ut);

		return res;
	}

	public List<String> getNomiUtenti() {
		
        List<String> nomi = new ArrayList<>();
        
        for (Utente u : mappa.values()) {
            nomi.add(u.getNome());
        }
        return nomi;
    }

}