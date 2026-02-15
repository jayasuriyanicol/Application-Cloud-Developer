package com.spring.ecommerce.exception;

@SuppressWarnings("serial")
public class IdDuplicatedException extends RuntimeException {


	public IdDuplicatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IdDuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public IdDuplicatedException(String message) {
		super(message);
	}

	public IdDuplicatedException(Throwable cause) {
		super(cause);
	}
}