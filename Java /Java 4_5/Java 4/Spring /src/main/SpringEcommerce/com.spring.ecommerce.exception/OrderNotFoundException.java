package com.spring.ecommerce.exception;

/* * OrderNotFoundException - Specialized Resource Exception
    ? A domain-specific exception that extends the generic 'NotFoundException'. It is used exclusively to signal that a requested Order ID does not exist in the persistence layer, allowing for granular error handling.

    ! 1. Hierarchical Inheritance, by extending a base 'NotFoundException', this class benefits from any global handling logic already defined for 404 errors while still providing a specific type that can be caught individually if different logic is needed for orders versus other entities.
    ! 2. Semantic Error Reporting, serves as a clear signal to the Service layer and the Global Interceptor. Instead of a generic "Not Found" message, this type explicitly identifies that the missing resource is an Order, facilitating more precise logging and client feedback.
    ! 3. Unchecked Exception Lifecycle, inherits the 'RuntimeException' behavior from its parent hierarchy. This allows the application to halt processing and trigger a rollback or error response without requiring boilerplate 'throws' declarations in every method signature.
*/

@SuppressWarnings("serial")
public class OrderNotFoundException extends NotFoundException {
	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OrderNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderNotFoundException(String message) {
		super(message);
	}

	public OrderNotFoundException(Throwable cause) {
		super(cause);
	}
}