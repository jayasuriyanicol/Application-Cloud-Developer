package com.spring.ecommerce.dto;

import com.spring.ecommerce.entity.Status;

/* * OrderStatusUpdateDTO - State Transition Payload
    ? A specialized, lightweight Data Transfer Object used exclusively for updating the status of an existing order. It isolates the status field to prevent accidental modifications to other immutable order data like prices or product IDs.

    ! 1. Focused Mutability, by encapsulating only the `Status` enum, this DTO enforces a "least privilege" approach to API design. It ensures that PATCH or PUT requests intended for status changes cannot inadvertently alter the financial or chronological data of an order.
    ! 2. Defensive Retrieval, the `getStatus()` method includes a built-in null check that logs a warning to the console. This serves as an immediate developer-facing alert during the integration phase, flagging instances where a client might be sending an empty or malformed payload.
    ! 3. Protocol Efficiency, its minimal structure reduces the network overhead of state-change requests. Rather than sending a full Order object, the client sends a tiny JSON snippet (e.g., `{"status": "SHIPPED"}`), optimizing performance for high-frequency status updates.
*/


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
