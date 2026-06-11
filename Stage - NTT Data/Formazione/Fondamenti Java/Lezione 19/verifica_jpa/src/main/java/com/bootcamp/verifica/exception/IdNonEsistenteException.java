package com.bootcamp.verifica.exception;

// Simple Exception for Null ID on the Libro
public class IdNonEsistenteException extends RuntimeException {

    public IdNonEsistenteException(String m) {

        super(m);
    }
}
