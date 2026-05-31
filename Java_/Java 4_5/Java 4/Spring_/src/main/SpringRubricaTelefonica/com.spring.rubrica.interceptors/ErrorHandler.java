package com.spring.rubrica.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.rubrica.dto.ErroreDTO;

/* * ErrorHandler - Global Exception Handler
    ? A centralized component for handling exceptions across the entire application. It acts as an interceptor that catches specific exceptions thrown by any controller, translating them into standard HTTP responses.

    ! 1. @RestControllerAdvice, combines `@ControllerAdvice` and `@ResponseBody`, enabling this class to provide global exception handling for RESTful APIs without needing to duplicate try-catch blocks in every controller.
    ! 2. Type-Safe Trapping, the `@ExceptionHandler` annotation binds the `idNotFound` method specifically to `ExcpetionNotFoundID`. This ensures that only missing ID errors trigger this specific 404 Not Found response path.
    ! 3. Semantic Status Codes, manually constructs a `ResponseEntity` with `HttpStatus.NOT_FOUND`. This maps the internal Java error state directly to the correct HTTP protocol semantic (404), which is critical for REST compliance.
*/

@RestControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> idNotFound(ExcpetionNotFoundID e) {
		
		ErroreDTO errore = new ErroreDTO("");
		
		errore.setMessaggioErrore(e.getMessage());
		
		ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(errore, HttpStatus.NOT_FOUND);
		
		return response;
		
		
	}

}
