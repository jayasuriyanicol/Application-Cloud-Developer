package progettosb.dto;

import java.time.LocalDateTime;

public class ErroreDTO {

    private final LocalDateTime timestamp;
    private final Integer statusCodice;
    private final String messaggioErr;
    private final String errore;



    public ErroreDTO(Integer statusCode, String messaggioErr, String errore) {

        this.timestamp = LocalDateTime.now();
        this.statusCodice = statusCode;
        this.messaggioErr = messaggioErr;
        this.errore = errore;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatusCodice() {
        return statusCodice;
    }

    public String getMessaggioErr() {
        return messaggioErr;
    }

    public String getErrore() {
        return errore;
    }



}
