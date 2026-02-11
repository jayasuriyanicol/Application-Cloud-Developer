package com.spring.statistiche.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;


/* * StatisticheDAO - In-Memory Data Access Object
    ? Serves as the persistence layer for tracking calculator usage statistics. Instead of a relational database, it utilizes a `HashMap` as a volatile, in-memory data store to record the frequency of arithmetic operations.

    ! 1. @Repository, designates this class as a Spring-managed data access component. This makes it eligible for component scanning and allows Spring to handle persistence-specific exceptions.
    ! 2. Schema Definition, the constructor explicitly initializes the `HashMap` with specific keys ("somma", "sottrazione", etc.), effectively defining the valid "columns" or record types allowed in this storage system.
    ! 3. Data Integrity, the `incrementoOccorrenze` method includes validation logic (`containsKey`) to ensure that only pre-defined operations are tracked, preventing the insertion of invalid or unknown keys into the statistics map.
*/



@Repository
public class StatisticheDAO {
	
	HashMap<String,Integer> repositoryStatistiche = new HashMap<>();
	
	
	public StatisticheDAO() {
		
		repositoryStatistiche.put("somma", 0);
		repositoryStatistiche.put("sottrazione", 0);
		repositoryStatistiche.put("moltiplicazione", 0);
		repositoryStatistiche.put("divisione", 0);
		
	}
	
	public int selezionaOperazione(String tipoOperazione) {
		
		return repositoryStatistiche.get(tipoOperazione);
	}
	
	
	
	public HashMap<String, Integer> mostraTutto() {
		
		return repositoryStatistiche;
		
		
	}
	
	public boolean incrementoOccorrenze(String tipoOperazione) {
		
		if (repositoryStatistiche.containsKey(tipoOperazione)) {
			
			repositoryStatistiche.put(tipoOperazione, repositoryStatistiche.get(tipoOperazione) + 1);
			
			System.out.println("L'operazione: " + tipoOperazione + " è stata incrementata di: " + repositoryStatistiche.get(tipoOperazione));
			return true;
			
			
		}
		System.out.println("ATTENZIONE ! DATA L'operazione: " + tipoOperazione + " NON È STATO POSSIBILE INCREMENTARE, SVOLTE ATTUALI -> " + repositoryStatistiche.get(tipoOperazione));
		return false;
		
		
	}
	
	
	
	
	
	
	
	

}
