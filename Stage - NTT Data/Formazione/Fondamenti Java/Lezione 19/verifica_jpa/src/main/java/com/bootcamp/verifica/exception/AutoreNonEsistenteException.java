package com.bootcamp.verifica.exception;

// Simple Exception for Author not found or null on the catalogo system Libro
public class AutoreNonEsistenteException extends RuntimeException {

    public AutoreNonEsistenteException(String m) {

        super(m);
    }
}