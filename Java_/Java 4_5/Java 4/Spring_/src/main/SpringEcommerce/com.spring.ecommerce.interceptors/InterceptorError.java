package com.spring.ecommerce.interceptors;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import  com.spring.ecommerce.dto.ErrorDTO;
import  com.spring.ecommerce.exception.ConflictException;
import com.spring.ecommerce.exception.FieldNotValidException;
import  com.spring.ecommerce.exception.NotFoundException;



/* * InterceptorError - Centralized E-commerce Exception Handler
    ? A dedicated `RestControllerAdvice` component that standardizes error responses for the entire e-commerce module. It intercepts specific business exceptions and translates them into uniform JSON error payloads.

    ! 1. Granular Exception Mapping, defines separate `@ExceptionHandler` methods for distinct error types (`NotFoundException`, `ConflictException`, `FieldNotValidException`). This allows the API to return precise HTTP status codes (404, 409, 400) tailored to the exact nature of the failure.
    ! 2. DTO Encapsulation, wraps raw exception messages into a structured `ErrorDTO` object. This ensures that clients always receive a consistent error format (including both a numeric code and a descriptive message) regardless of where the error originated.
    ! 3. Conflict Resolution, specifically handles `ConflictException` (HTTP 409), which is crucial in e-commerce scenarios to manage race conditions, such as double-booking inventory or duplicate order submissions.
*/



@RestControllerAdvice
public class InterceptorError {

	@ExceptionHandler
	public ResponseEntity<ErrorDTO> notFoundHandler(NotFoundException ERRORE404) {
		ErrorDTO printErrore = new ErrorDTO(404, ERRORE404.getMessage());
		return new ResponseEntity<ErrorDTO>(printErrore, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorDTO> conflictHandler(ConflictException ERRORE409) {
		ErrorDTO printErrore = new ErrorDTO(409, ERRORE409.getMessage());
		return new ResponseEntity<ErrorDTO>(printErrore, HttpStatus.CONFLICT);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorDTO> invalidQueryStringHandler(FieldNotValidException ERRORE400) {
		ErrorDTO printErrore = new ErrorDTO(400, ERRORE400.getMessage());
		return new ResponseEntity<ErrorDTO>(printErrore, HttpStatus.BAD_REQUEST);
	}
	
	 

}
