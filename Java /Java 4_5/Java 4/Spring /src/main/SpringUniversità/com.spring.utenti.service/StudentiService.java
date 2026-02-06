package com.spring.service;

import java.util.HashMap;
import java.util.List;

import com.spring.dao.StudentiDAO;
import com.spring.dto.StudentiDTO;
import com.spring.entity.Studente;

/* * StudentiService - Business Logic & Data Transformation
    ? Serves as the intermediary layer between the REST Controller and the Persistence Layer (DAO), ensuring that business rules are applied and data is correctly formatted.

    ! 1. DTO Conversion, explicitly manages the mapping between Data Transfer Objects (StudentiDTO) and Domain Entities (Studente) in methods like 'registraStudente' and 'cercaPerMatricola'. This isolates the API structure from the internal database model.
    ! 2. aggiornaEmail(...), implements a transactional-like update process: it verifies the student's existence, removes the obsolete record, updates the specific field (address/email), and re-inserts the updated entity.
    ! 3. Reporting Delegation, acts as a pass-through for analytical queries (e.g., 'listaCognomeAnnoStudenteGiovane'), retrieving pre-aggregated data (HashMaps) directly from the DAO.
*/


public class StudentiService {
	
	private StudentiDAO daoStudente = new StudentiDAO();
	
	
	
	
	public boolean registraStudente(StudentiDTO dto) {
		
		if(dto == null) return false;
		
		Studente studente = new Studente();
		studente.setCognome(dto.getCognome());
		studente.setMatricola(dto.getMatricola());
		studente.setIndirizzo(dto.getIndirizzo());
		studente.setNome(dto.getNome());
		studente.setAnnoNascita(dto.getAnnoNascita());
		studente.setAnnoImmatricolazione(dto.getAnnoImmatricolazione());
		

		return daoStudente.inserisciUtente(studente);
		
		
	}
	
	
	public StudentiDTO cercaPerMatricola(int matricolaStudente) {
		
		Studente s = daoStudente.cercaPerMatricola(matricolaStudente);
		
		return new StudentiDTO(s.getMatricola(), s.getNome(), s.getCognome(), s.getIndirizzo(), s.getAnnoNascita(), s.getAnnoImmatricolazione());
		
	}
	
	

	public List<Studente> tuttiStudenti() {
		
		return daoStudente.tuttiStudenti();
		
	}

	public Studente eliminaStudente(int idStudente) {
		
		return daoStudente.cancellaStudente(idStudente);
	}

	
	public Studente aggiornaEmail(int idStudente, String nuovoIndirizzo) {
		
		if (cercaPerMatricola(idStudente) == null)
			return null;
		
		Studente studenteCancellato = daoStudente.cancellaStudente(idStudente);
		studenteCancellato.setIndirizzo(nuovoIndirizzo);
		daoStudente.inserisciUtente(studenteCancellato);
		
		
		return studenteCancellato;
	}

	public List<String> elencoNomiStudenti() {
		
		return daoStudente.listaNomi();
	}

	public HashMap<String,String> listaCognomeAnnoStudenteGiovane () {
		
		return daoStudente.listaCognomeAnnoStudenteGiovane();
	}

	
	public HashMap<String,String> listaCognomeAnnoIscrizioneStudenteVecchio () {
		
		return daoStudente.listaCognomeAnnoIscrizioneStudenteVecchio();
	}

}
	
	
	
	
	
	
	
	
	
	