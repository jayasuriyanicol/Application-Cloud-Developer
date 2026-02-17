package com.spring.ecommerce.dao;

import java.util.List;

import com.spring.ecommerce.entity.Product;

/* * ProductInterfaceDAO - Inventory Access Contract
    ? A strategic abstraction layer that defines the mandatory operations for interacting with the product catalog. It establishes a standard protocol for retrieving product details and managing stock levels across the application.

    ! 1. Decoupled Architecture, by defining an interface, the business logic remains agnostic of the storage mechanism. This allows the system to switch from the current In-Memory HashMap to a persistent SQL/NoSQL database with zero impact on the `OrderService`.
    ! 2. Stock Management Protocol, specifically dictates the methods for both reading (`selezionaIDStock`) and modifying (`aggiornaIDStock`) inventory levels. This ensures that any implementation provides the necessary hooks for the order confirmation logic to verify and deduct availability.
    ! 3. Type-Safe Integration, utilizes the `Product` entity and standard Java Collections. This ensures that any data returned to the service layer is structured and predictable, facilitating clean stream processing and DTO mapping.
*/

public interface ProductInterfaceDAO {
	
	
	public Product selezionaID(int id);
	
	public int selezionaIDStock(int idStock);
	
	public void aggiornaIDStock(int idStock, int nuovoStock);
	
	public List<Product> mostraTutto();


}
