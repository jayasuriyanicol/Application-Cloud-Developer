package com.spring.azienda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.azienda.entity.Dipendente;


/* * DipendenteDAO - Workforce Data Access Object
    ? A specialized Spring Data JPA repository that serves as the interface for all "Dipendente" (Employee) persistence operations. It abstracts the complex SQL required to manage personnel records and introduces custom "Query Methods" to support business-specific lookups.

    ! 1. Natural Key Resolution, defines 'findByMatricola' to bridge the gap between internal database IDs and business-facing identifiers. By returning an 'Optional', the repository safely handles scenarios where a matricola might not exist, preventing null pointer exceptions in the service layer during employee verification.
    ! 2. Financial Query Capability, implements 'findBySalarioDipendente' to allow the system to perform targeted payroll analysis. This method automatically generates the necessary "SELECT * FROM Dipendente WHERE salario = ?" query at runtime, enabling the application to filter employees by specific salary brackets without manual coding.
    ! 3. Standardized CRUD Integration, inherits a full suite of management tools from 'JpaRepository', including batch deletes and paginated results. This ensures that the workforce can be managed efficiently, from single-record updates to large-scale data migrations, while maintaining strict relational integrity with the associated 'Azienda' and 'PostoAuto' entities.

*/
@Repository
public interface DipendenteDAO extends JpaRepository<Dipendente, Integer> {
	
	
	List<Dipendente> findBySalarioDipendente(Double salario);

    Optional<Dipendente> findByMatricola(String idMatricola);

}
