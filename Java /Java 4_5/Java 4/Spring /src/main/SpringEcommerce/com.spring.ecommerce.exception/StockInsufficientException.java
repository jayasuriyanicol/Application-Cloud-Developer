package com.spring.ecommerce.exception;

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
