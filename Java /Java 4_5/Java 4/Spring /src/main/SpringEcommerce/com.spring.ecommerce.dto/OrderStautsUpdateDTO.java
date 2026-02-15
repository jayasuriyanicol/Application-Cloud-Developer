package com.spring.ecommerce.dto;

import com.spring.ecommerce.entity.Status;

public class OrderStatusUpdateDTO {
	
	private Status status;
	
	public OrderStatusUpdateDTO(Status status) {
		
		this.status = status;
		
	}
	
	public OrderStatusUpdateDTO() {
		
	}

	public Status getStatus() {
		
		if(status == null)
			
			System.out.println("ATTENZIONE ! Inserire uno STATUS dato che è nullo !");
		
		return status;
	}

	public void setStatus(Status status) {
	
		this.status = status;
	}
	
	
	
}
