package com.spring.ecommerce.dto;

import java.time.LocalDate;
import com.spring.ecommerce.entity.Status;


/* * ErrorDTO - Standardized Error Response
    ? A Data Transfer Object specifically designed to unify the structure of error messages across the API. It ensures that when an exception occurs, the client receives a consistent JSON object containing diagnostic details rather than a raw stack trace.

    ! 1. Polymorphic Reporting, provides multiple constructor overloads to support different error scenarios. This flexibility allows the `InterceptorError` to instantiate a response with varying levels of detail—from a simple status code and message to a full diagnostic report including a timestamp and error category.
    ! 2. Temporal Context, automatically captures the `LocalDate.now()` in several constructors. This provides a clear "event horizon" for the error, helping frontend developers and system administrators correlate API failures with server-side logs.
    ! 3. Semantic Payload, maps internal application states (like `Status`) and custom error strings into a client-readable format. This translates technical failures into actionable information, such as distinguishing between a "Conflict" (409) and a generic "Bad Request" (400).
*/

public class ErrorDTO {
	
	private LocalDate timestamp;
	private Status status;
	private String error;
	private String message;
	
	
	
	//We go to create 3 type of constructor in other to rapresent all the format JSON needed for the Errors
	
	
	//Giving the constructor as the ERROR we need it
	public ErrorDTO(int i, String string) {
		
	}
	
	
	//Base CONSTRUCT base one, with all params
	public ErrorDTO(LocalDate timestamp, Status status,String error, String message) {
		
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		
	 } 
	
	
	public ErrorDTO(LocalDate timestamp, Status status, String message) {
		
		this.timestamp = LocalDate.now();
		this.status = status;
		this.error = "Conflict";
		this.message = message;
		
	 } 
	
	
	public ErrorDTO( Status status,String error, String message) {
		
		timestamp = LocalDate.now();
		this.status = status;
		this.error = error;
		this.message = message;
		
	 }


	public LocalDate getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	} 
	
	
	
	
	

	
	
	
	
}
