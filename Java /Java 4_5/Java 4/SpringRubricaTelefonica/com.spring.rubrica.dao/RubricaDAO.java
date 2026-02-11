package com.spring.rubrica.dao;

	import java.util.*;
	import org.springframework.stereotype.Repository;
	import com.spring.rubrica.entity.rubrica;

/* * RubricaDAO - In-Memory Persistence Layer
    ? Serves as the data access component for the application, simulating a database using a Java Collection. It manages the lifecycle of 'rubrica' objects directly in memory without a persistent backing store.

    ! 1. @Repository, identifies this class as a Spring Bean dedicated to storage interaction, enabling automatic dependency injection into the Service layer and exception translation.
    ! 2. Volatile Storage, utilizes a `HashMap<Integer, rubrica>` to mimic a relational table (Key-Value store). Data is transient (lost on restart), and the `id` counter manually handles primary key generation (auto-increment).
    ! 3. CRUD Abstraction, exposes standard methods (`insert`, `getById`, `delete`) to manipulate the data, abstracting the underlying collection logic so the Service layer remains agnostic to the storage mechanism.
*/


@Repository
public class RubricaDAO {

		//We create the map to simulate the Database (searching the ID)-> Object Rubrica
	    private Map<Integer, rubrica> mappa = new HashMap<>();
	    private int id = 1;

	    public rubrica insert(rubrica r) {
	        r.setId(id++);
	        mappa.put(r.getId(), r);
	        return r;
	    }

	    public rubrica getById(int id) {
	        return mappa.get(id);
	    }

	    public List<rubrica> getAll() {
	        return new ArrayList<>(mappa.values());
	    }

	    public rubrica delete(int id) {
	        return mappa.remove(id);
	    }

	    public Map<Integer, rubrica> getMappa() {
	        return mappa;
	    }
	}

