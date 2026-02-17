package com.spring.ecommerce.entity;

/* * Status - Order Lifecycle Enumeration
    ? Defines the fixed set of states an Order can traverse within the E-commerce system. It serves as the backbone for the application's finite state machine, dictating the valid flow of a transaction from inception to completion.

    ! 1. Type Safety, replaces "magic strings" with compile-time constants. This eliminates common errors (like typos or case sensitivity issues) when comparing states in the Service layer (e.g., ensuring `CREATED` is distinct from `CONFIRMED`).
    ! 2. Workflow Control, these specific values are used by the `OrderService` to enforce business logic, validating that transitions occur in the correct sequence (e.g., an order must be `SHIPPED` before it can be `DELIVERED`).
*/

//Creation of a class STATUS to manipulate more simply the imports and creation of the status odf orders
public enum Status {
	
		CREATED,
		CONFIRMED,
		SHIPPED,
		DELIVERED,
		CANCELLED
	}


