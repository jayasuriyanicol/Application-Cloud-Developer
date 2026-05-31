package com.spring.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.spring.entity.Professore;

/* * ProfessoriDAO - Data Access Layer (In-Memory)
    ? Manages the persistence of 'Professore' entities using a HashMap to simulate a database. It provides standard CRUD operations alongside advanced filtering and sorting using Java Streams.

    ! 1. registraProfessore(Professore), enforces a unique constraint on the ID before adding the professor to the internal map to prevent duplicates.
    ! 2. nuovaMateriaProfessore(...), implements a specific update logic: it retrieves and removes the entity from the map, modifies its subject locally, and returns the modified object.
    ! 3. Advanced Streams, methods like 'insegnamentoProfessoreMateria' and 'professoriOrdinatiCognome' utilize Java 8 Streams (filter, map, sorted) to perform queries and data transformation directly on the memory collection.
*/


public class ProfessoriDAO {
	
	private Map<Integer,Professore> mappaProfessore = new HashMap<>();
	
	
	
	
	public boolean registraProfessore(Professore professore) {
		
		if (mappaProfessore.containsKey(professore.getId())) {
			
			return false;
		
			
		}
		else {
			
			mappaProfessore.put(professore.getId(), professore);
			return true;
		}
		
	
	}

	public Professore cercaProfessoreID(Integer idProf) {
		
		return mappaProfessore.get(idProf);
		
		
	}
	
	public List<Professore> listaProfessori() {
		
		return new ArrayList<Professore>(mappaProfessore.values());
	}
	
	public Professore cancellaProfessore(Integer idProf) {
		
	
		Professore p = mappaProfessore.remove(idProf);
		return p;
	}
	
	
	public Professore nuovaMateriaProfessore(Integer idProf, String nuovaMateriaInsegnamento) {
		
		
		if (cercaProfessoreID(idProf)== null) {
			
			return null;
		}
		
		
		Professore profEliminato =  mappaProfessore.remove(idProf);
		
		profEliminato.setMateriaInsegnamento(nuovaMateriaInsegnamento);
		
		return profEliminato;
		
		

	}
	
	
	
	//ADVANCED FUNCTIONALITIES, that are not required at all but for completeness we do it 	
	
	
	public List<Professore> insegnamentoProfessoreMateria(String materia) {
		
		return listaProfessori().stream()

				.filter(p -> p.getMateriaInsegnamento().equals(materia))
						
				.collect(Collectors.toList());
				
					
	}
	
	
	public List<String> professoriOrdinatiCognome(){
		
		return listaProfessori().stream()
				
				.map(Professore::getCognome)
				.sorted()
				.collect(Collectors.toList());
		
	}
	
	
	
	public List <String> tutteMaterieInsegnate() {
		
		
		return listaProfessori().stream()	
				
				.map(Professore::getMateriaInsegnamento)
				.collect(Collectors.toList());
	
	}
	
	
	
	
	
	
	

}

