
package com.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.entity.Utente;


/* * DAOUtenteMappa - In-Memory Data Access Object
    ? Implements the persistence layer using a Java `HashMap` to simulate a database. It stores `Utente` entities in volatile memory, acting as a mock repository for rapid testing or prototyping without SQL overhead.

    ! 1. insert(Utente utente), manages data entry by checking for key existence (ID collision) before committing the object to the internal map.
    ! 2. cercaPerNome(String nomeDaCercare), performs a manual linear search over the collection values to filter results, handling case-insensitive string matching.
    ! 3. selectAll() / selectById(), provides standard retrieval mechanisms by extracting values directly from the key-value store.
*/


public class DAOUtenteMappa {

	private Map<Integer, Utente> mappa = new HashMap<>();

	public boolean insert(Utente utente) {
		if(mappa.containsKey(utente.getIdUtente()))
			return false;
		
		mappa.put(utente.getIdUtente(), utente);
		return true;

	}
	public List<Utente> selectAll(){
		return new ArrayList<>(mappa.values());
	}

	public Utente selectById(Integer idUtente) {
		return mappa.get(idUtente);
	}
	
	public Utente delete(Integer idUtente) {
		Utente utente = mappa.remove(idUtente);
		return utente;
	}
}