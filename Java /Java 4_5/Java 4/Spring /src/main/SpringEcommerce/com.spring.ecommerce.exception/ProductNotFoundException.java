package com.spring.ecommerce.exception;

/* * ProductNotFoundException - Specialized Resource Exception
    ? A domain-specific exception used to signal the absence of a Product in the catalog. It refines the generic 'NotFoundException' to provide precise context when a search by ID or name fails in the ProductDAO.

    ! 1. Granular Exception Handling, allows the application to distinguish between a missing Order and a missing Product. This specificity enables the global ErrorHandler to provide more tailored feedback, such as suggesting similar products or refreshing the catalog view.
    ! 2. Inheritance Strategy, by extending 'NotFoundException', it adheres to the "is-a" relationship, ensuring it is automatically caught by any generic catch-all for 404-style errors while maintaining its own unique type identity for logging.
    ! 3. Resource Integrity, typically thrown by the Service layer during order creation if a requested Product ID does not exist, acting as a critical safety check before calculating totals or deducting stock levels.
*/


@SuppressWarnings("serial")
public class ProductNotFoundException extends NotFoundException {
	public ProductNotFoundException() {
	}

	public ProductNotFoundException(String message) {
		super(message);
	}

	public ProductNotFoundException(Throwable cause) {
		super(cause);
	}

	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}