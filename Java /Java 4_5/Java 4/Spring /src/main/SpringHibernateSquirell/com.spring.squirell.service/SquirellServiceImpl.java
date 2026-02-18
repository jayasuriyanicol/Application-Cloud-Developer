package com.spring.squirell.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.squirell.dto.SquirellDTO;
import com.spring.squirell.entity.Squirell;
import com.spring.squirell.mapper.MapperSquirell;
import com.spring.squirell.repository.SquirellDAO;

import jakarta.transaction.Transactional;

/* * SquirellServiceImpl - Business Orchestrator & Transaction Manager
    ? The concrete implementation of the `SquirellService` interface. It coordinates the data flow between the web-tier DTOs and the persistent database records, ensuring that every operation is executed within a secure transactional context.

    ! 1. Transactional Integrity, utilizes the `@Transactional` annotation to manage the unit of work. This ensures that any interaction with the database—especially `save` and `delete`—is ACID-compliant, meaning changes are either fully committed or completely rolled back in case of a system failure.
    ! 2. Defensive Data Retrieval, handles the `Optional<Squirell>` returned by Spring Data JPA's `findById` method. By checking `isPresent()` before mapping, the service avoids potential runtime errors, providing a safe bridge between the raw database result and the final `SquirellDTO`.
    ! 3. Functional Stream Pipeline, implements a modern, declarative approach in `cercaTutti`. By converting the list of entities into a Stream and applying the `Mapper`, the service efficiently transforms raw database rows into a filtered, client-ready list in a single, readable line of code.
*/


//We add the Suppress unsued to the Collectors, because there is a case we use it     
@SuppressWarnings("unused")
@Service
@Transactional
public class SquirellServiceImpl implements SquirellService {

	@Autowired
	private SquirellDAO dao;
	
	@Override
	public void registra(SquirellDTO dto) {
		Squirell p = Mapper.SquirellDTOToSquirell(dto);
		
		dao.save(p);
		
	}
	

	@Override
	public SquirellDTO cercaPerID(int id) {
		
		//FindById, return the Optional. getByID() -> return the Object
		Optional<Squirell> opt = dao.findById(id);
		
		if(opt.isPresent()) {
			
			Squirell trovato = opt.get();
			
			return Mapper.SquirellToSquirellDTO(trovato);
			
		}
		return null;
		
	}
	
	@Override
	public List<SquirellDTO> cercaTutti() {
		
		return dao.findAll()	
				.stream()
				//Or -> collect(Collectors.toList());
				.map(p -> Mapper.SquirellToSquirellDTO(p))
				.toList();
			
		
		
		
	}
	public void eliminaPerId(int id) {
		
		dao.deleteById(id);
	}
	
	

}
