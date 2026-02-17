package com.spring.ecommerce.exception;

/* * IdDuplicatedException - Primary Key Violation Exception
    ? A custom unchecked exception specifically used to handle scenarios where an operation attempts to insert a record with an identifier that already exists in the system. It enforces unique identity constraints within the business logic.

    ! 1. Data Integrity Enforcement, acts as a specific guard against duplicate entries. While relational databases often handle this via unique constraints, this exception allows the Service layer to catch and signal the collision early, providing a more descriptive business-level error.
    ! 2. Exception Hierarchy, extends `RuntimeException`, allowing it to bypass the "catch or specify" requirement. This is ideal for modern Spring applications where a global Interceptor or `@RestControllerAdvice` is expected to catch the error and translate it into a specific HTTP status code (typically 409 Conflict).
    ! 3. Robust Error Context, through its multiple constructors, it can carry specific error messages or wrap underlying persistence exceptions. This ensures that the root cause of the ID collision is preserved for logging and debugging purposes.
*/

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