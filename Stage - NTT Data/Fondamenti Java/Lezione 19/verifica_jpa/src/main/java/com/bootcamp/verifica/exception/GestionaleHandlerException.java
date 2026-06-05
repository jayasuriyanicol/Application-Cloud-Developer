package com.bootcamp.verifica.exception;

import com.bootcamp.verifica.dto.ErroreDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// Created the Manager Handler for manage the Controller Phases
@RestControllerAdvice
public class GestionaleHandlerException {



    @ExceptionHandler(IdNonEsistenteException.class)
    public ResponseEntity<ErroreDTO> IdNonEsistente(IdNonEsistenteException exc) {

        ErroreDTO err = new ErroreDTO(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                "ERRORE: La risorsa non è stata trovata all'interno del sistema\nDETTAGLI:\n"
        );

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

    }



    @ExceptionHandler(TitoloVuotoException.class)
    public ResponseEntity<ErroreDTO> TitoloNonVuoto(TitoloVuotoException exc) {


        ErroreDTO err = new ErroreDTO(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                "ERRORE: Il titolo del libro risulta essere vuoto\nDETTAGLI:\n"
        );

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }




    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroreDTO> gestioneErroreGenerico(Exception exc) {

        ErroreDTO err = new ErroreDTO(

                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exc.getMessage(),
                "ATTENZIONE! La richiesta riguarda l'interno del sistema, prego riprovare\nERRORE: " + exc.getMessage()

        );

        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
