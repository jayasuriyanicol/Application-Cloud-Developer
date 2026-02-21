package com.spring.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/* * EcommerceExceptionHandler - Centralized Error Management
    ? A global interceptor that captures and processes exceptions across the entire E-commerce module. By using `@RestControllerAdvice`, it decouples error-handling logic from business services, ensuring the API returns consistent, readable, and meaningful HTTP responses to the client.

    ! 1. Semantic Status Mapping, translates specific Java exceptions into standardized HTTP status codes. It distinguishes between a "404 Not Found" for missing resources (Vendors/Products) and a "400 Bad Request" for logic failures (Password issues), allowing the client-side application to react appropriately to different failure scenarios.
    ! 2. Global Aspect-Oriented Handling, the `@ExceptionHandler` methods act as a safety net. Regardless of which Controller or Service throws the error, this class intercepts the execution flow, extracts the custom message from the exception object, and packages it into a clean `ResponseEntity`.
    ! 3. Robust API Contract, ensures that the end-user never sees a "raw" stack trace or a generic 500 Internal Server Error. By providing targeted messages for `PasswordNotComunicatedException` or missing entities, it improves the developer experience for those integrating with your API.
*/

@RestControllerAdvice
public class EcommerceExceptionHandler {
	
	
	@ExceptionHandler(PasswordNotComunicatedException.class)
    public ResponseEntity<String> handlePassword(PasswordNotComunicatedException ps) {
        return new ResponseEntity<>(ps.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VenditoreNotFoundException.class)
    public ResponseEntity<String> handleVenditore(VenditoreNotFoundException vend) {
        return new ResponseEntity<>(vend.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProdottoNotFoundException.class)
    public ResponseEntity<String> handleProdotto(ProdottoNotFoundException prod) {
        return new ResponseEntity<>(prod.getMessage(), HttpStatus.NOT_FOUND);
    }
}

