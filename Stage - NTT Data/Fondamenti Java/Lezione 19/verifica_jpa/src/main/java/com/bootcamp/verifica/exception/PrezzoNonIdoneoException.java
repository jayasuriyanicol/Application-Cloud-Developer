package com.bootcamp.verifica.exception;

// Simple Exception for Prezzo not equal to the standard on catalogo system Libro
public class PrezzoNonIdoneoException extends RuntimeException {

    public PrezzoNonIdoneoException(String m) {

        super(m);
    }
}