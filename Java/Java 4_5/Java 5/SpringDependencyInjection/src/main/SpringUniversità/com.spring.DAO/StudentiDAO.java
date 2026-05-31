package com.spring.dao;
import com.spring.entity.Studente;
import java.util.*;
import java.util.stream.Collectors;


/* * StudentiDAO - Data Access Layer (In-Memory)
    ? Manages the lifecycle and storage of 'Studente' entities using a generic HashMap. It combines standard CRUD functionality with advanced analytical methods using Java 8 Streams.

    ! 1. inserisciUtente(Studente), validates the uniqueness of the student ID ('matricola') before storing the object to ensure data integrity.
    ! 2. modificaIndirizzo(...), retrieves a student, updates their address field, and returns the modified instance (simulating a database update).
    ! 3. Stream Aggregations, methods like 'listaCognomeAnnoStudenteGiovane' use `stream().max()` with custom Comparators to isolate specific records (e.g., youngest student) and transform the result into a simplified Map structure.
*/


public class StudentiDAO {
	
	
	private Map<Integer, Studente> mappaStudente = new HashMap<>();
	
	
	public boolean inserisciUtente(Studente studente) {
		
		if (mappaStudente.containsKey(studente.getMatricola())) {
				
			return false;
			
		}	
		else {
			
	
		mappaStudente.put(studente.getMatricola(), studente);
		return true;
		}
		
	}
	
	
	public Studente cercaPerMatricola(Integer matricola) {

		return mappaStudente.get(matricola);
	}
	
	
	
	public List<Studente> tuttiStudenti() {
		
		return new ArrayList<Studente>(mappaStudente.values());
	}
	
	
	public Studente cancellaStudente(Integer matricola) {
		
		Studente s = mappaStudente.remove(matricola);
		return s;
	}
	
	
	public Studente modificaIndirizzo(Integer matricola, String nuovoIndirizzo) {
		
		if (cercaPerMatricola(matricola)== null) 
				return null;
		
		
		Studente studenteEliminato = mappaStudente.remove(matricola);
		studenteEliminato.setIndirizzo(nuovoIndirizzo);
		
		return studenteEliminato;
		
	}
	
	
	//ADVANCED FUNCTIONALITES, that are not required at all but for completeness we do it 
	
	
	public List<String> listaNomi () {
		
		return tuttiStudenti().stream()
			
		        .map(s -> s.getNome()) 
		        .collect(Collectors.toList()); 
		}
				

	
	//Here we pass in input a list of student as input 
	public HashMap<String,String> listaCognomeAnnoStudenteGiovane() {
		return tuttiStudenti().stream()
			.max(Comparator.comparingInt(s -> s.getAnnoNascita()))
			.map(s -> {
				HashMap<String, String> map = new HashMap<> ();
				map.put("cognome", s.getCognome());
				//Casting it from int value to a String format
				map.put("annoNascita", String.valueOf(s.getAnnoNascita()));
				return map;
			})
			//In this case if we haven't nothing we throw a simple empty HashMap
			.orElse(new HashMap<>());
			
	}
	
	
	public HashMap<String,String> listaCognomeAnnoIscrizioneStudenteVecchio() {
		
		return tuttiStudenti().stream() 
				.max(Comparator.comparingInt(i -> i.getAnnoImmatricolazione()))
				.map( s -> {
					
					HashMap<String,String> map = new HashMap<> ();
					map.put("cognome", s.getCognome());
					map.put("AnnoImmatricolazione", String.valueOf(s.getAnnoImmatricolazione()));
					return map;
					
				})
				
				.orElse(new HashMap<>());
		
	
	}
}
