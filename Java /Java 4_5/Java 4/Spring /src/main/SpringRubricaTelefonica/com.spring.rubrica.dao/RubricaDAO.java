package com.spring.rubrica.dao;

import java.util.*;
import org.springframework.stereotype.Repository;
import com.spring.rubrica.interceptor.ExcpetionNotFoundID;
import com.spring.rubrica.entity.ContattoTelefonico;
import com.spring.rubrica.entity.Rubrica;



/* * RubricaDAO - In-Memory Persistence Layer
    ? Serves as the data access component for the application, simulating a database using a Java Collection. It manages the lifecycle of 'rubrica' objects directly in memory without a persistent backing store.

    ! 1. @Repository, identifies this class as a Spring Bean dedicated to storage interaction, enabling automatic dependency injection into the Service layer and exception translation.
    ! 2. Volatile Storage, utilizes a `HashMap<Integer, rubrica>` to mimic a relational table (Key-Value store). Data is transient (lost on restart), and the `id` counter manually handles primary key generation (auto-increment).
    ! 3. CRUD Abstraction, exposes standard methods (`insert`, `getById`, `delete`) to manipulate the data, abstracting the underlying collection logic so the Service layer remains agnostic to the storage mechanism.
*/



@Repository
public class RubricaDAO {

		//We create the map to simulate the Database (searching the ID)-> Object Rubrica
	    private Map<Integer, Rubrica> mappa = new HashMap<>();
	    private int id = 1;

	    
	    
	    //Insertion of the error of duplicated ID, setted to void
	    public void insert(Rubrica r) {
	    	
	    	if(mappa.containsKey(r.getId()))
	    		
	    		throw new RuntimeException("ERRORE: Non è possibile creare due volte lo stesso utente con lo stesso ID !");
	        r.setId(id++);
	        mappa.put(r.getId(), r);
	      
	    }
	    
	    
	    
	    //Insertion of the error of duplicated ID, setted to void
	    public void insertContact(int idRubrica, ContattoTelefonico c) {

	    	    if (!mappa.containsKey(idRubrica))
	    	    	
	    	        throw new RuntimeException("ATTENZIONE: Non è stato possibile individuare la rubrica di appartenza: RUBRICA NON ESISTENTE !");

	    	    Rubrica r = mappa.get(idRubrica);

	    	    boolean inserito = r.getContatti().add(c);

	    	    if (!inserito)
	    	        throw new RuntimeException("ATTENZIONE: Contatto già presente NOME e COGNOME duplicati");
	    	}

	
	        
	      
	   

	  

	    public Rubrica getById(int id) {
	    	
	    	if(mappa.containsKey(id))
	    		
	    		
	    		return mappa.get(id);

	   
	    	
	    	throw new ExcpetionNotFoundID("ERRORE: Attenzione non è possibile proseguire con la richiesta, ID non esistente");
	    }

	    public List<Rubrica> getAll() {
	        return new ArrayList<>(mappa.values());
	    }

	    public Rubrica delete(int id) {
	        return mappa.remove(id);
	    }

	    public Map<Integer, Rubrica> getMappa() {
	        return mappa;
	    }
	}

