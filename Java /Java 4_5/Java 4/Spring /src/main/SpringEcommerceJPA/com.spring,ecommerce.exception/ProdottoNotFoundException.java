package com.spring.ecommerce.exception;

/* * ProdottoNotFoundException - Catalog Integrity Error
    ? A specialized RuntimeException used to indicate that a requested product does not exist in the marketplace database. It acts as a semantic signal for the service layer to halt execution when a lookup by ID fails.

    ! 1. Precise Error Semantics, by creating a dedicated exception for "Product Not Found," the application avoids using generic "NullPointerExceptions." This makes the codebase significantly easier to debug and ensures that the logs clearly reflect business-specific failures.
    ! 2. RESTful Integration, designed to be intercepted by the `EcommerceExceptionHandler`. Once thrown, it triggers a `404 Not Found` HTTP response, providing the frontend with a clear status that the item might have been deleted or the ID provided in the URL is incorrect.
    ! 3. Resource-Specific Identity, this exception allows for granular error handling. For instance, in a complex transaction, you can distinguish between a missing Vendor and a missing Product, enabling the system to provide more helpful feedback to the user or API consumer.
*/

@SuppressWarnings("serial")
public class ProdottoNotFoundException extends RuntimeException{

	public ProdottoNotFoundException() {
		super();
		
	}

	public ProdottoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ProdottoNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ProdottoNotFoundException(String message) {
		super(message);
		
	}

	public ProdottoNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	
	

}
