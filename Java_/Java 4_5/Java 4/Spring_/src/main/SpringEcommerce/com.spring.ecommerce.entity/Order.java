package com.spring.ecommerce.entity;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/* * Order - E-commerce Transaction Entity
    ? Represents the central aggregate root for a customer's purchase. It groups multiple line items, tracks the total financial value, and manages the current lifecycle state (Status) of the transaction.

    ! 1. Defensive Copying, implements robust encapsulation for the `orderItemList`. Both the getter and setter create a `new HashSet<>`, preventing external references from directly modifying the internal collection structure and ensuring data integrity.
    ! 2. Aggregate Composition, serves as the parent entity that binds individual `OrderItem` objects together. By holding a `Set`, it ensures that the collection of items contains unique entries (though uniqueness relies on the `OrderItem` implementation).
    ! 3. Lifecycle State, integrates the `Status` enum directly to track the order's progress (e.g., CREATED -> SHIPPED), serving as the state indicator for the Service layer's transition logic.
*/

public class Order {
	
	private int id;
	private double totalAmount;
	private LocalDateTime createdAt;
	private Set<OrderItem> orderItemList;
	
	//Because is in the same folder, we can even do not import the enum class 'STATUS' in the class ORDER
	private Status status;
	
	public Order(int id, double totalAmount, LocalDateTime createdAt, Set<OrderItem> orderItemList,Status status) {
	
		this.id = id;
		this.totalAmount = totalAmount;
		this.createdAt = createdAt;
		this.orderItemList = orderItemList;
		this.status = status;
	}

	
	public Order(Set<OrderItem> setOrderItems) {}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime localDateTime) {
		this.createdAt = localDateTime;
	}

	public Set<OrderItem> getOrderItemList() {
		return new HashSet<> (orderItemList);
	}

	public void setOrderItemList(Set<OrderItem> orderItemList) {
		this.orderItemList = new HashSet<>(orderItemList);
	}
	
    public Status getStatus() { 
    	return status; 
    	}
    
    public void setStatus(Status status) { 
    	this.status = status;
    	}
    
    @Override
    public String toString() {
        return "|DETTAGLIO ORDINE|\n  ID -> " + id +  "\n  TOTALE -> " + totalAmount + "€" + "\n  DATA -> " + createdAt + "\n  STATO -> " + status + 
               "\n  LISTA PRODOTTI -> " + orderItemList;
    }
	
}
