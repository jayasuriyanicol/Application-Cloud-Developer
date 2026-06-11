package com.bootcamp.verifica.exception;

// Simple Exception for Null Title on the Libro
public class TitoloVuotoException extends  RuntimeException{

    public TitoloVuotoException(String m) {
        super(m);
    }

}
