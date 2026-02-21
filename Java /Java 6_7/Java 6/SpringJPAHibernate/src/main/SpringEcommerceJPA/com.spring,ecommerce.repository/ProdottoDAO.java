package com.spring.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ecommerce.entity.Prodotto;


/* * ProdottoDAO - Inventory Persistence Interface
    ? A Spring Data JPA repository that serves as the specialized data access object for the 'Prodotto' entity. It abstracts the underlying SQL complexity, allowing the e-commerce system to perform high-speed inventory operations and relational lookups using the primary key.

    ! 1. Automated CRUD Lifecycle, by extending 'JpaRepository', this interface immediately provides the service layer with standard methods to manage products. This includes 'save' for new stock arrivals, 'findById' for specific product views, and 'delete' for removing discontinued items from the marketplace.
    ! 2. Entity-Relational Mapping (ORM), specifically typed for the 'Prodotto' entity and 'Integer' ID. This ensures that Spring Data correctly interprets the @ManyToOne relationship with the Seller, managing the 'FK_Venditore' column during database transactions without manual query writing.
    ! 3. Scalable Query Infrastructure, provides the foundation for future "Query Methods." Because it is an interface, you can easily add methods like 'findByCategoria' or 'findByPrezzoUnitarioLessThan' to enable complex product filtering and search features with zero implementation code.
*/

public interface ProdottoDAO extends JpaRepository<Prodotto, Integer>{

}
