
package com.spring.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ecommerce.entity.Venditore;

/* * VenditoreDAO - Merchant Persistence Interface
    ? The specialized data access gateway for the 'Venditore' entity. It manages the persistence lifecycle of seller accounts, providing the necessary hooks for Spring Data JPA to handle the complex "One-to-Many" relationship with products at the database level.

    ! 1. Automated Aggregate Management, inherits advanced batch operations and transactional support from 'JpaRepository'. This allows the system to save or delete a seller along with their entire product catalog (via the Cascade logic defined in the Entity) using simple, standardized method calls.
    ! 2. Integrated Identifier Lookup, maps the 'Integer' primary key (idVenditore) to the database's auto-incrementing identity column. This provides high-performance retrieval of seller profiles, which is essential for the Controller's credential-checking and profile-viewing operations.
    ! 3. Extension-Ready Architecture, serves as the base for custom marketplace queries. By extending JpaRepository, this interface can be easily enhanced with derived query methods like 'findByUsername' or 'findByCittà' to support seller search and discovery features in the e-commerce frontend.
*/


public interface VenditoreDAO extends JpaRepository<Venditore,Integer>{
    


}