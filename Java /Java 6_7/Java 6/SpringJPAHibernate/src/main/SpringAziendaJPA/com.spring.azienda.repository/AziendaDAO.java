package com.spring.azienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.azienda.entity.Azienda;


/* * AziendaDAO - Corporate Data Access Object
    ? A Spring Data JPA repository interface that acts as the primary data access layer for the 'Azienda' entity. By extending JpaRepository, it abstracts the complex JDBC boilerplate into a clean, high-level API for interacting with the corporate database.

    ! 1. Automated Persistence Operations, leverages the 'JpaRepository' inheritance to provide out-of-the-box methods for managing the Azienda lifecycle. This includes 'save' for new company registrations, 'findById' for targeted lookups, and 'findAll' for retrieving the entire corporate directory.
    ! 2. Integrated Relationship Management, handles the persistent state of the 'idAzienda' primary key (Integer). Because it is typed to the 'Azienda' entity, Spring Data automatically manages the cascading logic and orphan removal for the associated employee list during database transactions.
    ! 3. Declarative Query Foundation, serves as a extensible base for custom business logic. You can easily add derived query methods like 'findByIntestazioneContaining' or 'findByCapitaleSocialeGreaterThan' without writing a single line of SQL, allowing the repository to grow with the application's analytical needs.
*/

public interface AziendaDAO extends JpaRepository<Azienda, Integer> {

}
