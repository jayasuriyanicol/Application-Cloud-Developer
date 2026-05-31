package com.spring.ecommerce.exception;

/* * ConflictException - Resource State Conflict
    ? A custom unchecked exception designed to signal that a request cannot be processed due to the current state of the target resource. It is typically used to indicate collisions, such as attempting to create a duplicate entity or modifying a record that has changed.

    ! 1. Runtime Semantics, extends `RuntimeException`, classifying it as an "unchecked" exception. This indicates a client-side logic error (e.g., sending duplicate data) rather than a system failure, removing the need for explicit try-catch blocks in the service layer.
    ! 2. Constructor Parity, mirrors the standard `Exception` constructors, providing full flexibility to propagate error messages, wrap underlying causes (exception chaining), or control stack trace suppression.
    ! 3. HTTP Mapping Target, while the class itself is plain Java, it is architecturally intended to be caught by the `InterceptorError` and mapped to HTTP Status 409 (Conflict), providing semantic feedback to the API client.
*/


@SuppressWarnings("serial")
public class ConflictException  extends RuntimeException {
	
	
		public ConflictException() {
		}

		public ConflictException(String message) {
			super(message);
		}

		public ConflictException(Throwable cause) {
			super(cause);
		}

		public ConflictException(String message, Throwable cause) {
			super(message, cause);
		}

		public ConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}
	}
	

