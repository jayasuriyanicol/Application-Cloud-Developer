package Lezione_07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RegistroErrori {
	
	public static void main(String[] args) {
	
			Path input = Path.of("src/Lezione_07/input.txt");
			Path output = Path.of("src/Lezione_07/output.txt");
			
			
			try {
				
				String contenuto = Files.readString(input);
				String contenutoUp = contenuto.toUpperCase();
				Files.writeString(output, contenutoUp);
				
				
				System.out.println("SUCCESSO ! Il file è stato elaborato con successo !\nDi seguito il percorso assoluto:\n" + output.toAbsolutePath());
				
			} catch(IOException e) {
				
				System.out.println("ATTENZIONE ! Errore nella gestione del file\nERRORE: " + e.getMessage());
			}
	}
}
