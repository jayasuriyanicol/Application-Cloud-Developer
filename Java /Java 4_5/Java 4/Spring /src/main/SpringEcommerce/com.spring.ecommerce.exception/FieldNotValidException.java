package com.spring.ecommerce.exception;

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


