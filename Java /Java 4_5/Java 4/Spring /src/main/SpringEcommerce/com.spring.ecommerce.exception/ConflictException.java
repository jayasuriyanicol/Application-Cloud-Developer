package com.spring.ecommerce.exception;

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
	

