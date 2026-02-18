package com.spring.ecommerce.exception;

/* * NotAuthorizedAccessException - Security Violation Exception
    ? A custom unchecked exception used to signal that a user or process has failed the authentication check. In this E-commerce system, it is specifically triggered when administrative credentials provided in a 'ManagementProductDTO' do not match the authorized records in the 'AdminManagerDAO'.

    ! 1. Security Enforcement, acts as a "hard stop" for unauthorized operations. By throwing this exception, the system immediately terminates the execution of sensitive methods (like adding or deleting products) the moment a credential mismatch is detected, preventing illegal state changes.
    ! 2. HTTP Semantic Mapping, designed to be intercepted by a global exception handler and translated into an HTTP 401 (Unauthorized) or 403 (Forbidden) response. This provides a clear, standardized signal to the client that the request lacked valid administrative permissions.
    ! 3. Lean Stack Management, as a 'RuntimeException', it allows the security logic to remain decoupled from the business signatures. This means the 'AdminService' can verify identity and fail silently regarding method signatures, keeping the code clean while maintaining robust protection.
*/


	@SuppressWarnings("serial")
	public class NotAuthorizedAccessException extends RuntimeException {
		
		public NotAuthorizedAccessException() {
			super();
		}

		public NotAuthorizedAccessException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public NotAuthorizedAccessException(String message, Throwable cause) {
			super(message, cause);
		}

		public NotAuthorizedAccessException(String message) {
			super(message);
		}

		public NotAuthorizedAccessException(Throwable cause) {
			super(cause);
		}
	}

