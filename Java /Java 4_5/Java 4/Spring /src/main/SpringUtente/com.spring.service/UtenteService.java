package com.spring.utenti.service;
import java.util.ArrayList;
import java.util.List;

import com.spring.utenti.entity.Utente;

import DAO.DAOUtenteMappa;


/* * UtenteService - Business Logic Layer
    ? Represents the service layer responsible for managing User business logic, acting as an intermediary between external requests and the persistence layer (DAOUtenteMappa).

    ! 1. registra(Utente utente), handles the "sign-up" process by logging the event and delegating the persistence task to the DAO.
    ! 2. modificaMail(...), implements a specific update strategy by removing the user, modifying the email in-memory, and re-inserting the updated entity to persist the change.
    ! 3. CRUD Delegation, methods like cercaPerId, selectAll, and cancellaUtente primarily act as wrappers that forward calls directly to the underlying DAO implementation.
*/

public class UtenteService {
	
	private DAOUtenteMappa dao = new DAOUtenteMappa();

	
	public UtenteService() {
		
		//TODO
	}
	
	
	//Method Sign - Up FAKE
	public boolean registra(Utente utente) {
		
		System.out.println("SUCCESSO ! Registrazione avvenuta con successo " + utente.toString());
		return dao.insert(utente);
		
	}
	
	
	public Utente cercaPerId(int idUtente) {
		
		//return new Utente("Mario", "Mela", "marioApple@gmail.com", "0001", idUtente);
		return dao.selectById(idUtente);
		
		
	}
	
	//As exercise we create the SELECTALL and DELETE and updateEmail from DAO.
	public ArrayList<Utente> selectAll() {
		
		return (ArrayList<Utente>) dao.selectAll();
	
	}
	
	public Utente cancellaUtente(Integer utente) {
		
		return dao.delete(null);
	}
	
	public Utente modificaMail (int idUtente, String email) {
		
		 Utente utentenuovo =  dao.delete(idUtente); 
		 utentenuovo.setMail(email);
		 dao.insert(utentenuovo);
		 
		 return utentenuovo;
		
		
	}
	
	
	public int numeroUtenti () {
		
		return dao.numeroUtenti();		
		
	}
	
	
   public List<String> getNomiUtenti() {
		
        return dao.getNomiUtenti();
    }

    
    public List<Utente> cercaPerNome(String nomeDaCercare) {
    	
        return dao.cercaPerNome(nomeDaCercare);
    }
		
	
	

}
