package com.spring.ecommerce.exception;

@SuppressWarnings("serial")
public class StateOrderdNotValide extends ConflictException {
		
		public StateOrderdNotValide() {
		}

		public StateOrderdNotValide(String message) {
			super(message);
		}

		public StateOrderdNotValide(Throwable cause) {
			super(cause);
		}

		public StateOrderdNotValide(String message, Throwable cause) {
			super(message, cause);
		}

		public StateOrderdNotValide(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}
	}

