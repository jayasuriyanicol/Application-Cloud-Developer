package com.spring.ecommerce.exception;

/* * StateOrderdNotValide - Business Logic State Exception
    ? A specialized exception that extends 'ConflictException', specifically designed to enforce the Order lifecycle rules. It is thrown when a requested state transition is illegal based on the current status of the order.

    ! 1. State Machine Guard, acts as the primary validator for the Order workflow. It prevents logical errors such as attempting to "Ship" an order that hasn't been "Confirmed" yet, or trying to "Cancel" an order that has already been "Delivered".
    ! 2. Conflict Hierarchy, by extending 'ConflictException', it semantically aligns with HTTP 409 (Conflict). This informs the client that while the request was understood, it cannot be completed because it conflicts with the current server-side state of the resource.
    ! 3. Unchecked enforcement, as a 'RuntimeException', it allows the service layer to immediately halt illegal operations without requiring complex conditional branching in the return types, ensuring the internal data remains consistent with business rules.
*/


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

