package com.spring.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.ecommerce.entity.Status;


/* * OrderResponseDTO - Client-Facing Order Summary
    ? A Data Transfer Object used to send order details back to the client. It acts as a filtered view of the Order entity, ensuring that only relevant, formatted data is exposed through the API.

    ! 1. JSON Presentation Control, utilizes the `@JsonFormat` annotation to transform the internal `LocalDateTime` into a human-readable string ("dd-MM-yyyy HH:mm:ss"). This ensures the API consumer receives a professional timestamp rather than a complex, machine-oriented ISO object.
    ! 2. Null-Safe Collection Management, the `setItems` method implements a defensive check. By initializing an empty `HashSet` if the input is null, it prevents `NullPointerExceptions` during JSON serialization or when the UI attempts to iterate over the order items.
    ! 3. Flat Hierarchy Integration, mirrors the structure of the Order entity but uses `OrderItemDTO` instead of the internal persistence model. This decoupling allows the backend to change its database schema without breaking the contract with the frontend.
*/


public class OrderResponseDTO {

    private int id;
    private Double totalAmount; 
    private Status status;
    
    //Using this pattern associted to che variable createdAt, to have a good response on JSON output TIMESTAMP more good than the machine timestamp that is not clear
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    
  
    private Set<OrderItemDTO> items = new HashSet<>();

    public OrderResponseDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(Set<OrderItemDTO> items) {
    	
        //To avoid type of Exception we always check if there are some type of null Objects
        if (items == null) {
            this.items = new HashSet<>();
        } else {
            this.items = items;
        }
    }
	
	@Override
	public String toString() {
		return "\n|PRODOTTO|\nID -> " + id + "\nTOTALE -> " + totalAmount + "€\nSTATUS -> " + status + "\nDATA CREAZIONE -> " + createdAt;
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
