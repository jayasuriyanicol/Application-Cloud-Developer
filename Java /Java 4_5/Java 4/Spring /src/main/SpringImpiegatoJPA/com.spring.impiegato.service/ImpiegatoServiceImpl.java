package com.spring.impiegati.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.impiegati.dto.ImpiegatoDTO;
import com.spring.impiegati.entity.Impiegato;
import com.spring.impiegati.mapper.MapperImpiegato;
import com.spring.impiegati.repository.ImpiegatoDAO;

import jakarta.transaction.Transactional;


/* * ImpiegatoServiceImpl - HR Logic & State Management
    ? The concrete execution engine for the Employee module. It bridges the gap between the REST API and the database, orchestrating the mapping of objects while ensuring that all operations—from hiring to firing—are processed with transactional integrity.

    ! 1. ACID-Compliant Lifecycle Management, utilizes the '@Transactional' annotation to wrap business methods. This is particularly vital for the 'assunzione' and 'cancellaID' methods, ensuring that if a database failure occurs, the system rolls back to a consistent state, preventing orphaned records.
    ! 2. Functional Stream Pipeline, implements the 'listaImpiegato' method using the Java Stream API. This provides a modern, declarative way to iterate through the entire database result set, transforming each 'Impiegato' entity into a secure 'ImpiegatoDTO' efficiently in a single processing chain.
    ! 3. State-Aware Updates, the 'aggiornaMatriSal' method leverages Hibernate's "Dirty Checking" mechanism. By retrieving an entity via 'Optional' and modifying its state within a transactional method, the service automatically synchronizes the new salary to the database without needing an explicit 'save()' call, optimizing the update cycle.
*/


@Service
@Transactional
public class ImpiegatoServiceImpl implements ImpiegatoService  {
	
	@Autowired
	private ImpiegatoDAO dao;

	@Override
	public void assunzione(ImpiegatoDTO dto) {
		
		Impiegato impiegato = MapperImpiegato.ImpiegatoDTOToEntity(dto);
		dao.save(impiegato);
		
		
	}

	@Override
	public ImpiegatoDTO cercaMatricola(int matricola) {
		
		Optional<Impiegato> opt = dao.findById(matricola);
		
		if(opt.isPresent()) {
			
			Impiegato trovato = opt.get();
			return MapperImpiegato.ImpiegatoEntityToDTO(trovato);
		}
		
		
		return null;
	}

	@Override
	public List<ImpiegatoDTO> listaImpiegato() {
		
		return dao.findAll()
			   .stream()
			   .map(imp -> MapperImpiegato.ImpiegatoEntityToDTO(imp))
			   .toList();
			   
			  
	}

	@Override
	public ImpiegatoDTO cancellaID(int matricola) {
		
		Optional<Impiegato> opt = dao.findById(matricola);
		
		if(opt.isPresent()) {
			
			dao.deleteById(matricola);
			Impiegato trovato = opt.get();
			return MapperImpiegato.ImpiegatoEntityToDTO(trovato);
		}
		
		return null;
		
	

	}

	@Override
	public ImpiegatoDTO aggiornaMatriSal(int matricola, double nuovoSalario) {
		
		Optional<Impiegato> opt = dao.findById(matricola);
		Impiegato trovato = opt.get();
		trovato.setSalarioMensile(nuovoSalario);
		return MapperImpiegato.ImpiegatoEntityToDTO(trovato);
		
	
		 
	}




	  //TODO: Integrate the not required method (EXTRA)

}
