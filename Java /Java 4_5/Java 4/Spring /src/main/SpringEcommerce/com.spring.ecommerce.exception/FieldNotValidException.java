package com.spring.ecommerce.exception;

/* * FieldNotValidException - Data Validation Exception
    ? A custom unchecked exception utilized to signal that an input field or parameter fails to meet the application's required criteria. It serves as a specialized validation tool to interrupt the execution flow when "bad data" is detected.

    ! 1. Runtime Signaling, as a `RuntimeException`, it allows the application to halt processing immediately without forcing every calling method to declare a `throws` clause. This results in cleaner, more readable business logic in the Service and Controller layers.
    ! 2. Contextual Flexibility, by providing the full suite of constructors—including those that accept a `Throwable cause`—it enables "exception chaining." This allows developers to wrap low-level errors into a high-level, field-specific context for better debugging.
    ! 3. API Integration, specifically designed to be intercepted by a `RestControllerAdvice`. When thrown, it typically triggers a "400 Bad Request" response, informing the client that the specific field values provided are logically or syntactically incorrect.
*/
@SuppressWarnings("serial")
public class FieldNotValidException extends RuntimeException {
	
	public FieldNotValidException() {
		
		super();
	}
	

	public FieldNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FieldNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public FieldNotValidException(String message) {
		super(message);
	}

	public FieldNotValidException(Throwable cause) {
		super(cause);
	}
}


