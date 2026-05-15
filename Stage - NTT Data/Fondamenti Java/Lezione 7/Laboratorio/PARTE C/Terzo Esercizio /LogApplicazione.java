package Lezione_07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class LogApplicazione {



	    public static void main(String[] args) {
	       
	        Path directoryLogs = Path.of("output/logs");

			// ? Creazione della directory per inserire i file di log
	        Path fileLog = directoryLogs.resolve("app-log.txt");

	        

	        List<String> messaggiLog = List.of(
	        		
	            "[INFO] SUCCESSO ! Avvio dell'applicazione riuscito.",
	            "[WARNING] ATTENZIONE ! Spazio su disco quasi esaurito.",
	            "[ERROR] ERRORE ! Errore di connessione al database."
	        );

	        try {
	            
	            Files.createDirectories(directoryLogs);
	            System.out.println("SUCCESSO ! Cartella verificata/creata in: " + directoryLogs.toAbsolutePath());

	         
	            Files.write(fileLog, messaggiLog, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	            
	            System.out.println("SUCCESSO! Messaggi registrati in: " + fileLog.toAbsolutePath());

	        } catch (IOException e) {
	          
	            System.out.println("ATTENZIONE! Errore critico durante la gestione del file di log.\nERRORE: " + e.getMessage());
	           
	        }
	    }
	}

