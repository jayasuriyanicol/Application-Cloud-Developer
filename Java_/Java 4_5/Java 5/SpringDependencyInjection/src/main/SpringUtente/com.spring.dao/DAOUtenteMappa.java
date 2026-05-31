package com.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.entity.Utente;

/* * DAOUtenteMappa - In-Memory User Persistence
    ? Acts as the data access layer for `Utente` entities, simulating a database environment using a Java Map. It manages the lifecycle of users with standard CRUD operations entirely in memory.

    ! 1. Primary Key Simulation, the `insert` method enforces data integrity by manually checking for existing IDs (`containsKey`). It mimics a database constraint violation by throwing a `RuntimeException` if a duplicate ID is detected.
    ! 2. Volatile Data Store, relies on a `HashMap` for storage. While this provides efficient O(1) lookups by ID, the data is transient and exists only for the duration of the application execution.
*/

public class DAOUtenteMappa {

	private Map<Integer, Utente> mappa = new HashMap<>();

	public void insert(Utente utente)  {
		if(mappa.containsKey(utente.getIdUtente()))
			
		throw new RuntimeException("ERRORE: Non è possibile creare due volte lo stesso utente con lo stesso ID !");
		mappa.put(utente.getIdUtente(), utente);
		

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

