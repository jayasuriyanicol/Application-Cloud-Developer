package com.spring.impiegati.service;

import java.util.List;

import com.spring.impiegati.dto.ImpiegatoDTO;


/* * ImpiegatoService - HR Business Logic Contract
    ? A functional interface that defines the core "Human Resources" operations for the application. It acts as a formal contract that ensures all employee management implementations—regardless of the underlying storage—adhere to standard corporate procedures like hiring, salary adjustments, and terminations.

    ! 1. Domain-Specific Language (DSL), uses industry-standard terminology like 'assunzione' (hiring) and 'matricola' (employee serial number). This bridges the gap between technical code and business requirements, making the API's purpose clear to both developers and stakeholders.
    ! 2. Comprehensive Lifecycle Coverage, provides a complete set of methods to manage an employee from their first day ('assunzione') through salary growth ('aggiornaMatriSal') to their eventual departure ('cancellaID'), ensuring full lifecycle management within a single service.
    ! 3. DTO-First Strategy, enforces the use of 'ImpiegatoDTO' for all input and output. This ensures that the implementation layer can perform complex calculations or database transactions while providing the Controller with a clean, decoupled data structure that is safe for JSON serialization.
*/

public interface ImpiegatoService {
	
	public void assunzione(ImpiegatoDTO dto);
	public ImpiegatoDTO cercaMatricola(int matricola);
	public List<ImpiegatoDTO> listaImpiegato();
	public ImpiegatoDTO cancellaID(int matricola);
	public ImpiegatoDTO aggiornaMatriSal(int matricola, double nuovoSalario );
	
	
    //TODO: Integrate the not required method (EXTRA)

}
