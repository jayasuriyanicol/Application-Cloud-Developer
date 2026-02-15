package com.spring.ecommerce.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
	
	private int id;
	private double totalAmount;
	private LocalDate createdAt;
	private ArrayList<Product> orderItemList;
	
	//Because is in the same folder, we can even do not import the enum class 'STATUS' in the class ORDER
	private Status status;
	
	public Order(int id, double totalAmount, LocalDate createdAt, ArrayList<Product> orderItemList,Status status) {
	
		this.id = id;
		this.totalAmount = totalAmount;
		this.createdAt = createdAt;
		this.orderItemList = orderItemList;
		this.status = status;
	}

	
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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
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
		return "Order [id=" + id + ", totalAmount=" + totalAmount + ", createdAt=" + createdAt + ", orderItemList="
				+ orderItemList + "]";
	};
	
	
	
	
	
	
	

	
	
	
}
