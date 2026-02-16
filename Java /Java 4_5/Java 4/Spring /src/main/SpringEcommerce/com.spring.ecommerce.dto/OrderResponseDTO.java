package com.spring.ecommerce.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.spring.ecommerce.entity.Status;

public class OrderResponseDTO {
		
	private int id;
	private Set<OrderItemDTO> items;
	private double totalAmount;
	private Status status;
	private LocalDate createdAt;
	
	
	public OrderResponseDTO(int id, Set<OrderItemDTO> items, double totalAmount, Status status,
			LocalDate createdAt) {
		
		this.id = id;
		this.items = items;
		this.totalAmount = totalAmount;
		this.status = status;
		this.createdAt = createdAt;

	}
	
	public OrderResponseDTO() {
		
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<OrderItemDTO> getItems() {
		return items;
	}
	
	//Initialize a HashSet fot the ORDERED ITEMS in order to get a HashSet initialized with this params
	@SuppressWarnings("null")
	public void setItems(Set<OrderItemDTO> items) {
		
		this.id = (Integer)null;
		this.items = new HashSet<>(items);
		
		//Using the STREAMS to get the TOTAL AMOUNT more easier linked to lambda expressions
		this.totalAmount = items.stream().mapToDouble(it -> it.getUnitPrice() * it.getQuantity()).sum();
		
		this.status = Status.CREATED;
		this.createdAt = LocalDate.now();		
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}
	
	
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	//Verifying all the data with HASH CODE and EQUALS to do not get identical product, to prevent incongruence in the HashSet

	@Override
	public int hashCode() {
		
		//For us we have to know only the id because is the identificator of the OBJ, the other params is nothing.
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		OrderResponseDTO other = (OrderResponseDTO) obj;
		
		return  Objects.equals(id, other.id);
				
	}
	
	
	@Override
	public String toString() {
		return "\n|PRODOTTO|\nID -> " + id + "\nTOTALE -> " + totalAmount + "€\nSTATUS -> " + status + "\nDATA CREAZIONE -> " + createdAt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
