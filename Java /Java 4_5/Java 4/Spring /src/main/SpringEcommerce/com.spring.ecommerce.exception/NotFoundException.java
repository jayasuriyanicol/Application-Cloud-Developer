package com.spring.ecommerce.exception;

/* * NotFoundException - Resource Absence Exception
    ? A custom unchecked exception used to signal that a requested resource (like an Order or Product) does not exist in the system. It allows the service layer to halt execution gracefully when a lookup fails.

    ! 1. Semantic Error Handling, specifically designed to be intercepted by a `@RestControllerAdvice`. When caught, it is typically mapped to an HTTP 404 (Not Found) status code, providing the client with clear, standardized feedback that the specific ID or resource is missing.
    ! 2. Control Flow Management, by extending `RuntimeException`, it allows the application to "short-circuit" deep logic chains. Instead of returning null and risking a `NullPointerException` later, throwing this exception ensures the error is handled immediately and safely.
    ! 3. Constructor Parity, implements the full suite of `Throwable` constructors. This allows for wrapping lower-level persistence errors or passing custom business messages, which is essential for meaningful API error logging.
*/

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {


	public IdDuplicatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IdDuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public IdDuplicatedException(String message) {
		super(message);
	}

	public IdDuplicatedException(Throwable cause) {
		super(cause);
	}
}