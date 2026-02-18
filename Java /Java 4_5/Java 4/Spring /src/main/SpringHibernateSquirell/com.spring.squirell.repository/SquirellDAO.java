package com.spring.squirell.repository;

import com.spring.squirell.entity.Squirell;
import org.springframework.data.jpa.repository.JpaRepository;


/* * SquirellDAO - JPA Repository Abstraction
    ? An interface that extends `JpaRepository`, leveraging Spring Data JPA to provide a complete, out-of-the-box persistence solution. It eliminates the need for manual boilerplate DAO implementations by generating the necessary SQL at runtime.

    ! 1. Automated CRUD Operations, by inheriting from `JpaRepository<Squirell, Integer>`, this interface instantly gains access to standard methods like `save()`, `findById()`, `findAll()`, and `deleteById()`. You no longer need to write a single line of JDBC or EntityManager code.
    ! 2. Type-Safe Persistence, explicitly binds the repository to the `Squirell` entity and its `Integer` Primary Key. This ensures that the underlying Hibernate provider understands exactly how to map result sets to your domain objects and enforce ID constraints.
    ! 3. Advanced Feature Access, provides more than just basic storage. Because it extends the JPA specification, it implicitly supports pagination, sorting, and the ability to define "Query Methods" (e.g., `findByNome`) simply by declaring the method signature.
*/


public interface SquirellDAO extends JpaRepository<Squirell,Integer>{
	
	//here I inherited only the solantato JPAREPOSITORY methods, nothing more we do not need anymore the DAO, as we call the folder as Repository
	
}
