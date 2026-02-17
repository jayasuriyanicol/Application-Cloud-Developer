package com.spring.ecommerce.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.ecommerce.SpringECommerceApplication;
import com.spring.ecommerce.dao.OrderDAO;
import com.spring.ecommerce.dao.ProductDAO;
import com.spring.ecommerce.dto.OrderCreateRequestDTO;
import com.spring.ecommerce.dto.OrderItemDTO;
import com.spring.ecommerce.dto.OrderResponseDTO;
import com.spring.ecommerce.entity.Order;
import com.spring.ecommerce.entity.OrderItem;
import com.spring.ecommerce.entity.Product;
import com.spring.ecommerce.entity.Status;
import com.spring.ecommerce.exception.StateOrderdNotValide;
import com.spring.ecommerce.exception.StockInsufficientException;



/* * OrderService - Order Lifecycle Management
    ? The core business logic component for the E-commerce module. It orchestrates the entire lifespan of an order, enforcing state transitions, managing inventory deductions, and handling the conversion between database entities and API Data Transfer Objects.

    ! 1. State Machine Enforcement, strictly controls the order workflow (Created -> Confirmed -> Shipped -> Delivered). It acts as a gatekeeper, throwing `StateOrderdNotValide` exceptions to prevent illegal transitions (e.g., shipping an unconfirmed order).
    ! 2. Manual DTO Mapping, contains extensive static utility methods to transform internal Entities (`Order`, `OrderItem`) into client-facing DTOs. This decouples the database schema from the JSON response format without relying on external mapping libraries.
    ! 3. Inventory Integration, tightly coupled with `ProductDAO` to ensure data integrity. It validates stock availability before confirmation and executes logic to restore stock levels (rollback) if a confirmed order is subsequently cancelled.
*/


@Repository
public class OrderService implements OrderServiceInterface{

    @SuppressWarnings("unused")
	private final SpringECommerceApplication springECommerceApplication;
	
	@Autowired 
	OrderDAO ordineDAO;
	
	@Autowired
	ProductDAO prodottoDAO;


    OrderService(SpringECommerceApplication springECommerceApplication) {
        this.springECommerceApplication = springECommerceApplication;
    }
	
	
	
	//Conversion from Entity ORDER to ORDER DTO
	public static OrderResponseDTO OrdertoDTO(Order ordine) {
	    
	    if (ordine == null)
	        return null;

	    OrderResponseDTO dto = new OrderResponseDTO();
	    
	    dto.setId(ordine.getId());
	    dto.setTotalAmount(ordine.getTotalAmount());
	    dto.setStatus(ordine.getStatus());
	    dto.setCreatedAt(ordine.getCreatedAt());

	    //For the order we do a condition to set the items and to avoid the NullPointerException if the list is empty
	    if (ordine.getOrderItemList() != null) {
	        dto.setItems(
	            ordine.getOrderItemList().stream()
	            .map(e -> orderItemDTO(e)) 
	            .collect(Collectors.toSet())
	        );
	    }

	    return dto;
	}

	
	public static OrderItemDTO orderItemDTO(OrderItem item) {
		
	    OrderItemDTO itemDTO = new OrderItemDTO();
	    
	   
	    	itemDTO.setProductId(item.getProductId());
	    	itemDTO.setQuantity(item.getQuantity());
	    	itemDTO.setUnitPrice(item.getUnitPrice());
	    

	    return itemDTO;
	}
	
	
	
	//Conversion from ORDER DTO to the Entity ORDER
	
	public static Order OrdertoEntity (OrderResponseDTO responseDTO) {
	    if (responseDTO == null)
	        return null;

	    Order ordine = new Order(0, 0, null, null, null);
	    ordine.setId(responseDTO.getId());
	    ordine.setTotalAmount(responseDTO.getTotalAmount());
	    ordine.setStatus(responseDTO.getStatus());
	    ordine.setCreatedAt(responseDTO.getCreatedAt());
	    
	    if (responseDTO.getItems() != null) {
	        ordine.setOrderItemList(responseDTO.getItems().stream()
	            .map(d -> toItemEntity(d))
	            .collect(Collectors.toSet()));
	    }

	    return ordine;
	}
	
	
	public static OrderItem toItemEntity(OrderItemDTO dto) {
	    OrderItem item = new OrderItem(0, 0, 0);
	
	    item.setProductId(dto.getProductId());
	    item.setQuantity(dto.getQuantity());
	    item.setUnitPrice(dto.getUnitPrice());
	    
	  
	    
	    return item;
	}


	
	
	
	//Conversion from the Entity OrderItem to the OrderItemDTO
	public static OrderItemDTO OrderItemtoDTO (OrderItem orderItem) {
		
		if (orderItem == null)
			return null;

		OrderItemDTO orderDTO = new OrderItemDTO();
		orderDTO.setProductId(orderItem.getProductId());
		orderDTO.setQuantity(orderItem.getQuantity());
		orderDTO.setUnitPrice(orderItem.getUnitPrice());

		return orderDTO;
	}

	
	//Conversion drom the OrderItemDTO to the Entity OrderItem
	public static OrderItem itemOrderItemtoEntity (OrderItemDTO orderItemDTO) {
		
	    if (orderItemDTO == null)
	        return null;

	    OrderItem orderItem = new OrderItem(0, 0, 0);
	    orderItem.setProductId(orderItemDTO.getProductId());
	    orderItem.setQuantity(orderItemDTO.getQuantity());
	    orderItem.setUnitPrice(orderItemDTO.getUnitPrice());

	    return orderItem;
	}

	
	


	@Override
	public OrderResponseDTO creaOrdine(OrderCreateRequestDTO ordine) {
		
		Set<OrderItem> setOrderItems = ordine.getListaProdottiOrdinati().stream().map(d -> itemOrderItemtoEntity(d)).collect(Collectors.toSet());

		for (OrderItem ordinato : setOrderItems) {
			
			Product prodotto = prodottoDAO.selezionaID(ordinato.getProductId());
		
			int stock = Integer.parseInt(prodotto.getStock());
			
			if ( stock < ordinato.getQuantity())
				throw new StockInsufficientException("ATTENZIONE ! Per il prodotto " + prodotto.getName() + " non vi è abbastanza disponibilità per avviare l'ordine !");
		
			ordinato.setUnitPrice(prodotto.getPrice());
		}

		Order newOrder = new Order(0, 0, null, setOrderItems, null);
		ordineDAO.aggiungiOrdine(newOrder);
		return OrdertoDTO(newOrder);
		
		
		
	}



	@Override
	public List<OrderResponseDTO> creaListaOrdini(List<OrderCreateRequestDTO> listaOrdini) {
		
		List<OrderResponseDTO> lista = new ArrayList<>();

		for (OrderCreateRequestDTO ord : listaOrdini)
			lista.add(creaOrdine(ord));

		return lista;
	}



	@Override
	public OrderResponseDTO cercaOrdineID(int idOrdine) {
		

		return OrdertoDTO(ordineDAO.selezionaId(idOrdine));
	}



	@Override
	public Collection<OrderResponseDTO> cercaOrdineCreato() {
		
	
		return ordineDAO.mostraTuttiOrdini().stream()
				.map(ord -> OrdertoDTO(ord))
				.filter(ord -> ord.getStatus().equals(Status.CREATED))
				.toList();
	}



	@Override
	public Collection<OrderResponseDTO> ceracOrdineConfermato() {
		
	
		return ordineDAO.mostraTuttiOrdini().stream()
				.map(ord -> OrdertoDTO(ord))
				.filter(ord -> ord.getStatus().equals(Status.CONFIRMED))
				.toList();
	}



	@Override
	public Collection<OrderResponseDTO> cercaOrdineSpedito() {
		
	
		return ordineDAO.mostraTuttiOrdini().stream()
				.map(ord -> OrdertoDTO(ord))
				.filter(ord -> ord.getStatus().equals(Status.SHIPPED))
				.toList();
	}



	@Override
	public OrderResponseDTO confermaOrdine(int idOrdine) {
		
	
		Order ordine = ordineDAO.selezionaId(idOrdine);

		if (!ordine.getStatus().equals(Status.CREATED))
			throw new StateOrderdNotValide("ATTENZIONE ! Solo gli ordini creati possono essere CONFERMATI");

		for (OrderItem item : ordine.getOrderItemList()) {
			

			Product prodotto = prodottoDAO.selezionaID(item.getProductId());

			int stock = Integer.parseInt(prodotto.getStock());

			if (stock  < item.getQuantity())
				throw new StockInsufficientException("ATTENZIONE ! Per lo Stock del PRODOTTO " + prodotto.getName() + " NON è SUFFCIENTE per confermare l'ordine |");

			
			String quantità = "" + (stock - item.getQuantity());
			
			prodottoDAO.aggiornaIDStock(prodotto.getId(), quantità);
		}

		ordine.setStatus(Status.CONFIRMED);
		return OrdertoDTO(ordine);
	}



	@Override
	public OrderResponseDTO spediciOrdine(int idOrdine) {
		
		Order ordine = ordineDAO.selezionaId(idOrdine);

		if (!ordine.getStatus().equals(Status.CONFIRMED))
			throw new StateOrderdNotValide ("ATTENZIONE ! Solo gli ordini CONFERMATI possono essere SPEDITI !");

		ordine.setStatus(Status.SHIPPED);
		
		return OrdertoDTO(ordine);
	}


	@Override
	public OrderResponseDTO inviaOrdine(int idOrdine) {
		
		Order ordine = ordineDAO.selezionaId(idOrdine);

		if (!ordine.getStatus().equals(Status.SHIPPED))
			throw new StateOrderdNotValide("ATTENZIONE ! Solo gli ordini SPEDITI possono essere CONFERMATI  ");

		ordine.setStatus(Status.DELIVERED);
		return OrdertoDTO(ordine);
	}



	@Override
	public OrderResponseDTO cancellaOrdine(int idOrdine) {
		Order ordine = ordineDAO.selezionaId(idOrdine);

		if (ordine.getStatus().equals(Status.SHIPPED) || ordine.getStatus().equals(Status.DELIVERED) || ordine.getStatus().equals(Status.CANCELLED))
			throw new StateOrderdNotValide("ATTENZIONE ! Solo gli ordini CREATI possono essere effettivamente CANCELLATI !");

		if (ordine.getStatus().equals(Status.CONFIRMED)) {
			for (OrderItem item : ordine.getOrderItemList()) {
				Product prodotto = prodottoDAO.selezionaID(item.getProductId());
				
				int stock = Integer.parseInt(prodotto.getStock());
				String quantità = "" + (stock - item.getQuantity());
				
				prodottoDAO.aggiornaIDStock(prodotto.getId(), quantità);
			}
		}

		ordine.setStatus(Status.CANCELLED);
		return OrdertoDTO(ordine);
	}
	
	
	
	
	
}