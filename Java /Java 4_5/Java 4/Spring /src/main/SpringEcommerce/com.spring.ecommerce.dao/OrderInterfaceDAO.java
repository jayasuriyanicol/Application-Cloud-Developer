package com.spring.ecommerce.dao;

import java.util.List;

import com.spring.ecommerce.entity.Order;
import com.spring.ecommerce.entity.Status;


/* * OrderInterfaceDAO - Data Access Contract
    ? An abstraction layer that defines the standard CRUD (Create, Read, Update, Delete) operations for the Order entity. It decouples the business logic from the specific persistence technology (like MySQL, MongoDB, or an In-Memory List).

    ! 1. Persistence Abstraction, by defining signatures like `aggiungiOrdine` and `selezionaId`, the application remains flexible. The underlying storage can be swapped without needing to modify the `OrderService` logic, adhering to the Dependency Inversion Principle.
    ! 2. Status Synchronization, the `cambiaIdOrdine` method provides a direct way to synchronize the database state with the business lifecycle. This ensures that when an order moves from `CREATED` to `SHIPPED`, the change is immediately made durable in the data store.
    ! 3. Bulk Retrieval, includes `mostraTuttiOrdini`, which allows the service layer to perform stream-based filtering or reporting, such as fetching all orders currently in a "Pending" state for administrative dashboards.
*/


//Creation of an INTERFACE to manipulate the CRUD DAO of ORDERS 
public interface OrderInterfaceDAO {
	
	public void aggiungiOrdine(Order ordine);
	

	public Order selezionaId(int id);

	
	public List<Order> mostraTuttiOrdini();
	
	public Order rimuoviOrdine(int idOrd);

	
	public void cambiaIdOrdine(int idOrd, Status newStatus);
	
	

	

}
