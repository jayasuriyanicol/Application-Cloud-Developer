package com.spring.ecommerce.exception;

/* * PasswordNotComunicatedException - Security Validation Fault
    ? A custom unchecked exception designed to signal a specific validation failure within the authentication or registration flow. It extends 'RuntimeException', allowing it to bubble up through the Spring stack until it is caught by the global Exception Handler.

    ! 1. Unchecked Exception Strategy, by extending 'RuntimeException', this class avoids the clutter of mandatory "throws" clauses in service signatures. This keeps the business logic clean while still allowing Spring's Transaction Manager to trigger an automatic rollback if a security check fails.
    ! 2. Standardized Constructor Suite, implements the full hierarchy of super-constructors from the 'Throwable' class. This flexibility allows developers to pass simple error messages, wrap root causes for debugging, or even suppress stack traces for performance optimization.
    ! 3. Integration with @RestControllerAdvice, acts as the "trigger" for the 'EcommerceExceptionHandler'. When this exception is thrown, the handler intercepts it and translates it into a '400 Bad Request' response, ensuring the client receives a clear explanation of the missing security credentials.
*/

@SuppressWarnings("serial")
public class PasswordNotComunicatedException extends RuntimeException{

	public PasswordNotComunicatedException() {
		super();
		
	}

	public PasswordNotComunicatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PasswordNotComunicatedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PasswordNotComunicatedException(String message) {
		super(message);
		
	}

	public PasswordNotComunicatedException(Throwable cause) {
		super(cause);
		
	}
	
	

}
