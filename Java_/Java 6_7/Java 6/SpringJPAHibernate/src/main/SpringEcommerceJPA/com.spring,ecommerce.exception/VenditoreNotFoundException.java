package com.spring.ecommerce.exception;

/* * VenditoreNotFoundException - Domain Identity Fault
    ? A targeted RuntimeException that signals a failure to locate a specific Seller within the persistence context. It serves as a vital signal for the service layer, indicating that a requested operation (like adding a product or updating a profile) cannot proceed because the parent entity is missing.

    ! 1. Defensive Programming Hook, allows the service layer to perform clean checks using `Optional.orElseThrow()`. This prevents downstream "NullPointerExceptions" by halting the execution immediately and providing a meaningful business context for the failure.
    ! 2. Hierarchical Exception Separation, by existing as a distinct class from `ProdottoNotFoundException`, it allows the `EcommerceExceptionHandler` to apply specific logic or logging levels tailored for Vendor-related failures versus Catalog-related failures.
    ! 3. Unchecked Propagation, extends 'RuntimeException' to avoid the "Checked Exception" tax. This allows the exception to travel through the Spring AOP layers and Transaction Interceptors without requiring explicit 'throws' declarations in every interface method, maintaining a clean and modern API.
*/


@SuppressWarnings("serial")
public class VenditoreNotFoundException extends RuntimeException{

	public VenditoreNotFoundException() {
		super();
		
	}

	public VenditoreNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public VenditoreNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public VenditoreNotFoundException(String message) {
		super(message);
	
	}

	public VenditoreNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	

}
