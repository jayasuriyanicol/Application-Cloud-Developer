package com.bootcamp.verifica.exception;

// Simple Exception for Categoria not found on enum catalogo system Libro
public class CategoriaNonIdoneaException extends RuntimeException {

    public CategoriaNonIdoneaException(String m) {

        super(m);
    }
}