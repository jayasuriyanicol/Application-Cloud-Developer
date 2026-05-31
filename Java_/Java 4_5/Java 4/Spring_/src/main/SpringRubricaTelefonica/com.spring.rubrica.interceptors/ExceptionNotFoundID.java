package com.spring.rubrica.interceptor;


/* * ExcpetionNotFoundID - Custom Resource Exception
    ? A user-defined unchecked exception designed to handle "Not Found" scenarios specifically when querying by ID. It allows the service layer to signal missing data semantically rather than throwing generic errors.

    ! 1. Runtime Inheritance, extends `RuntimeException`, classifying it as an "unchecked" exception. This indicates that the error is likely due to a specific state (missing data) rather than a system failure, and explicit try-catch blocks are not mandatory during compilation.
    ! 2. Constructor Parity, mirrors the superclass constructors completely, offering flexibility to throw the exception with a simple message, a wrapped cause (chaining), or complex suppression settings.
*/





public class ExcpetionNotFoundID extends RuntimeException {



	private static final long serialVersionUID = 1L;

	public ExcpetionNotFoundID() {
		super();
		
	}

	public ExcpetionNotFoundID(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ExcpetionNotFoundID(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ExcpetionNotFoundID(String message) {
		super(message);
		
	}

	public ExcpetionNotFoundID(Throwable cause) {
		super(cause);
	
	}
	

	
	


}
