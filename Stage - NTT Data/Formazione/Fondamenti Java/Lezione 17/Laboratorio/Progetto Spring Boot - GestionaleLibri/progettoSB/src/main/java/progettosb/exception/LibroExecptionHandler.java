package progettosb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import progettosb.dto.ErroreDTO;

@RestControllerAdvice
public class LibroExceptionHandler {


    @ExceptionHandler(LibroNonTrovatoException.class)
    public ResponseEntity<ErroreDTO> gestioneLibroNonTrovato(LibroNonTrovatoException ex) {

        ErroreDTO errore = new ErroreDTO(

                HttpStatus.NOT_FOUND.value(),
                "ATTENZIONE ! La richiesta non risulta valida",
                "Il libro non è stato trovato nel sistema\nERRORE: " + ex.getMessage()
        );

        return new  ResponseEntity<>(errore, HttpStatus.NOT_FOUND);


    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroreDTO> gestioneLibroNonValido(IllegalArgumentException ex) {

        ErroreDTO errore = new ErroreDTO(

                HttpStatus.BAD_REQUEST.value(),
                "ATTENZIONE! Sembra esserci qualcosa che non va",
                "La richiesta non soddisfa i parametri prestabiliti dal sistema\nERRORE: " + ex.getMessage()
        );

        return new  ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(TitoloGiaDuplicatoException.class)

    public ResponseEntity<ErroreDTO> gestioneLibroDuplicato(TitoloGiaDuplicatoException ex) {

        ErroreDTO errore = new ErroreDTO(

                // ? In this case we use a HttpsStatus of value of CONFLICT
                HttpStatus.CONFLICT.value(),
                "ATTENZIONE ! E' stato rinvenuto un duplicato nel sistema",
                ex.getMessage()

        );

        return new  ResponseEntity<>(errore, HttpStatus.CONFLICT);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroreDTO> gestioneErroreGenerico(Exception ex) {

        ErroreDTO errore = new ErroreDTO(

                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "ATTENZIONE ! Errore generico all'interno del sistema",
                "La richiesta riguarda l'interno del sistema, prego riprovare\nERRORE: " + ex.getMessage()

        );

        return new ResponseEntity<>(errore, HttpStatus.INTERNAL_SERVER_ERROR);
    }





}
