package com.spring.impiegati.repository;

import com.spring.impiegati.entity.Impiegato;
import org.springframework.data.jpa.repository.JpaRepository;

/* * ImpiegatoDAO - HR Persistence Gateway
    ? A Spring Data JPA repository interface that acts as the automated data access layer for the Employee module. By extending JpaRepository, it provides a sophisticated abstraction over the database, allowing for complex HR data management without the need for manual SQL implementation.

    ! 1. Zero-Boilerplate Persistence, inherits the full suite of CRUD operations (Create, Read, Update, Delete) specifically for the 'Impiegato' entity. This enables the service layer to perform advanced tasks like bulk employee retrieval or specific record deletion by simply invoking inherited methods like 'findAll()' or 'deleteById()'.
    ! 2. Integrated Transactional Support, leverages the built-in Spring Data infrastructure to ensure that database operations are handled within a managed transaction. This is critical for HR applications where data integrity during salary updates or new hiring records is non-negotiable.
    ! 3. Integer-Based ID Mapping, explicitly identifies the 'Integer' type (representing the 'matricola') as the lookup key. This alignment with the Entity's '@Id' ensures that the underlying Hibernate engine can efficiently index and retrieve employee records using corporate serial numbers.
*/


public interface ImpiegatoDAO extends JpaRepository<Impiegato,Integer> {
	
	
	
	//Only EREDITO the methods of JPARepository
	
}
