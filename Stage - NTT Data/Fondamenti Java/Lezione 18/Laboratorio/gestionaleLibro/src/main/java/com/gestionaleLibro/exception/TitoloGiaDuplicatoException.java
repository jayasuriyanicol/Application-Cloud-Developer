package com.gestionaleLibro.exception;

@SuppressWarnings("serial")
public class TitoloGiaDuplicatoException extends RuntimeException {




    public TitoloGiaDuplicatoException(String titolo) {

        super("ATTENZIONE ! \nLIBRO -> " + titolo + " già è presente nel sistema");
    }
}

