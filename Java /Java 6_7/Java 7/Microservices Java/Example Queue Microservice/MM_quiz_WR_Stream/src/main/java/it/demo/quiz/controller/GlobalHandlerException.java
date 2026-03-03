package it.demo.quiz.controller;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> gestisciAssensaDelDato(NoSuchElementException e){
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> gestisciAssensaDelDato(Throwable e){
		return ResponseEntity.internalServerError().body(e.getMessage());
	}
}
