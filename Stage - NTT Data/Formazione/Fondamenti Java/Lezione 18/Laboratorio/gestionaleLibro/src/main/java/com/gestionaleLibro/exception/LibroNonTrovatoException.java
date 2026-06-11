package com.gestionaleLibro.exception;

@SuppressWarnings("serial")
public class LibroNonTrovatoException extends RuntimeException {



    public LibroNonTrovatoException(Long id) {

        super("ATTENZIONE !\nIl libro con ID -> " + id + " non è stato trovato nel sistema !");

    }

}
