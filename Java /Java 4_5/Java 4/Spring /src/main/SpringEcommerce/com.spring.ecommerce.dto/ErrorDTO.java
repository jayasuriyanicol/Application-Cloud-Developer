package com.spring.ecommerce.dto;

import java.time.LocalDate;
import com.spring.ecommerce.entity.Status;

public class ErrorDTO {
	
	private LocalDate timestamp;
	private Status status;
	private String error;
	private String message;
	
	
	
	//We go to create 3 type of constructor in other to rapresent all the format JSON needed for the Errors
	
	
	//Empty constructor as DTO need it
	public ErrorDTO() {
		
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
