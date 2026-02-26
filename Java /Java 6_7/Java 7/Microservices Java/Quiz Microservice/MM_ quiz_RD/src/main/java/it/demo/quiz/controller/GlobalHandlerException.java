package it.demo.quiz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;

@RestControllerAdvice
public class GlobalHandlerException {
	public String fallbackAfterRetry(Integer i, Exception ex) {
	    return "all retries have exhausted";
	}
	
	
	@ExceptionHandler({CallNotPermittedException.class})
	@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
	public ResponseEntity<String> handleCallNotPermittedException(Exception e) {
		e.printStackTrace();
		return ResponseEntity.internalServerError().body(e.getMessage());
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> catchException(Throwable t){
		t.printStackTrace();
		return ResponseEntity.internalServerError().body(t.getMessage());
	}
	
}
