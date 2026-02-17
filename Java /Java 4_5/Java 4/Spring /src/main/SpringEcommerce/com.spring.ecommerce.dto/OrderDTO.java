package com.spring.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.spring.ecommerce.entity.Product;

import ch.qos.logback.core.status.Status;

/* * OrderDTO - Comprehensive Order View
    ? A Data Transfer Object designed to provide a full, human-readable summary of an order. It aggregates the order's metadata with a complete list of product details to be sent to the presentation layer or client.

    ! 1. Data Aggregation, unlike the simplified 'OrderCreateRequestDTO', this object includes the full `Product` objects within its `orderItemList`. This allows the front-end to display names, descriptions, and images without making additional API calls for each item.
    ! 2. Temporal Tracking, utilizes `LocalDateTime` to capture the exact timestamp of the order creation, ensuring that the history of transactions is recorded with high precision for auditing and customer support.
    ! 3. Formatted Reporting, features a specialized `toString()` override that acts as a "Textual Receipt." It provides a clean, vertically aligned summary of the order ID, total amount (with currency symbol), and status, which is highly useful for console debugging and logging.
*/

public class OrderDTO {
	

		private int id;
		private double totalAmount;
		private LocalDateTime createdAt;
		private ArrayList<Product> orderItemList;
		private Status status;
		
		public OrderDTO(int id, double totalAmount, LocalDateTime createdAt, ArrayList<Product> orderItemList,Status status) {
		
			this.id = id;
			this.totalAmount = totalAmount;
			this.createdAt = createdAt;
			this.orderItemList = orderItemList;
			this.status = status;
		}
		
		public OrderDTO() {}
		
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

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public ArrayList<Product> getOrderItemList() {
			return orderItemList;
		}

		public void setOrderItemList(ArrayList<Product> orderItemList) {
			this.orderItemList = orderItemList;
		}
		
	    public Status getStatus() { 
	    	return status; 
	    	}
	    public void setStatus(Status status) { 
	    	this.status = status;
	    	}


	    @Override
	    public String toString() {
	        return  
	               "|       RIEPILOGO ORDINE     |\n" +
	    
	               "  ID ORDINE  -> " + id + "\n" +
	               "  TOTALE     -> " + totalAmount + " €\n" +
	               "  DATA       -> " + createdAt + "\n" +
	               "  STATO      -> " + (status != null ? status : "N/D") + "\n" +
	               "------------------------------\n" +
	               "  PRODOTTI INCLUSI:\n" + orderItemList;
	    }
		
		
		

		
		
		
	}


