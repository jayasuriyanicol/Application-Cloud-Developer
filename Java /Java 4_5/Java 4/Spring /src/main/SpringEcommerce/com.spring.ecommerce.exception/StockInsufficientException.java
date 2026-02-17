package com.spring.ecommerce.exception;

/* * StockInsufficientException - Inventory Availability Exception
    ? A specialized domain exception extending 'ConflictException' that triggers when a requested quantity of a product exceeds the currently available stock. It acts as a final safeguard during the order creation or confirmation process.

    ! 1. Transactional Integrity, prevents the system from entering an inconsistent state where more items are promised to a customer than are physically present in the warehouse. It is the primary trigger for halting the "Confirm Order" workflow.
    ! 2. Conflict Classification, by inheriting from 'ConflictException', it semantically maps to an HTTP 409 Conflict. This tells the client that the request is valid but cannot be fulfilled due to a clash with the current real-time inventory levels.
    ! 3. User-Centric Feedback, typically carries a dynamic message detailing which specific product failed the stock check, allowing the UI to inform the user exactly why their purchase cannot proceed.
*/


@SuppressWarnings("serial")
public class StockInsufficientException extends ConflictException {
	
	
	public StockInsufficientException() {
	}

	public StockInsufficientException(String message) {
		super(message);
	}

	public StockInsufficientException(Throwable cause) {
		super(cause);
	}

	public StockInsufficientException(String message, Throwable cause) {
		super(message, cause);
	}

	public StockInsufficientException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
