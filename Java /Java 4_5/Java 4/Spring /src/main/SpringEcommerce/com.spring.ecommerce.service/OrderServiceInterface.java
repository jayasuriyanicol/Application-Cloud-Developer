package com.spring.ecommerce.service;

import java.util.Collection;
import java.util.List;

import com.spring.ecommerce.dto.OrderCreateRequestDTO;
import com.spring.ecommerce.dto.OrderResponseDTO;



/* * OrderServiceInterface - Service Contract
    ? Defines the abstract contract for the Order Management System. It outlines the essential business operations—creation, retrieval, and state transitions—without exposing underlying implementation details like database logic or validation rules.

    ! 1. Dependency Inversion, facilitates loose coupling between the Controller and the Service layer. By defining these methods abstractly, the application allows for easier testing (via mocking) and future implementation swaps without affecting the client-facing API.
    ! 2. Lifecycle Modeling, the method signatures explicitly map to the specific stages of an order's lifecycle (Create -> Confirm -> Ship -> Deliver/Cancel), effectively enforcing the business workflow at the interface level.
    ! 3. DTO Enforced Boundary, strictly utilizes Data Transfer Objects for all inputs and outputs. This ensures that internal domain entities are never directly exposed, maintaining a secure and clean separation between the API contract and the persistence layer.
*/

public interface OrderServiceInterface {
	
	
	public OrderResponseDTO creaOrdine(OrderCreateRequestDTO ordine);
	
	List<OrderResponseDTO> creaListaOrdini(List<OrderCreateRequestDTO> listaOrdini);
	
	public OrderResponseDTO cercaOrdineID(int idOrdine);

	public Collection<OrderResponseDTO> cercaOrdineCreato();

	public Collection<OrderResponseDTO> ceracOrdineConfermato();

	public Collection<OrderResponseDTO> cercaOrdineSpedito();

	public OrderResponseDTO confermaOrdine(int idOrdine);

	public OrderResponseDTO spediciOrdine(int idOrdine);

	public OrderResponseDTO inviaOrdine(int idOrdine);

	public OrderResponseDTO cancellaOrdine(int idOrdine);
	
	

}
