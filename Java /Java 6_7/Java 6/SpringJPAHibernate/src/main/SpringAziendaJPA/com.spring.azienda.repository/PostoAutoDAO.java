package com.spring.azienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.azienda.entity.PostoAuto;

/* * PostoAutoDAO - Asset Management Repository
    ? A specialized data access interface for the 'PostoAuto' (Parking Spot) entity. By extending 'JpaRepository', it provides a robust abstraction layer that handles the persistence of physical corporate resources without requiring custom SQL or JDBC implementation.

    ! 1. Resource Lifecycle Automation, provides the necessary infrastructure to manage the creation, retrieval, and deletion of parking assets. This allows the service layer to perform critical operations, such as checking if a spot is available or assigning a specific location to an employee, using standard Spring Data methods like 'findById'.
    ! 2. Relational Integrity Support, plays a vital role in the One-to-One mapping between employees and their parking spaces. Because the 'PostoAuto' is linked to a 'Dipendente' entity, this DAO ensures that when a spot is updated, the relational state is correctly synchronized in the database.
    ! 3. Zero-Code Persistence Layer, follows the "Convention over Configuration" principle of Spring Boot. By defining this interface, the system automatically implements the logic needed to query the 'PostoAuto' table, allowing you to focus on the business logic of resource allocation rather than database connectivity.
*/

public interface PostoAutoDAO extends JpaRepository<PostoAuto, Integer> {

}
