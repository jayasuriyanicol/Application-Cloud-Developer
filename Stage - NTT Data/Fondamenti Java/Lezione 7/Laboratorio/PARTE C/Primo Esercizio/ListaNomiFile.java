package Lezione_07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

public class ListaNomiFile {
	
	public static void main(String[] args) {

	
	Path nomi = Path.of("src/Lezione_07/nomi.txt");
	Path stampa = Path.of("src/Lezione_07/nomi.txt");
	
	
	try {
		
		List<String> righe = Files.readAllLines(nomi);
		
		Files.write(stampa, righe);
	
		
		for(String i: righe) {
			
		    System.out.println(i);			
		}
		System.out.println("SUCCESSO ! File elaborato correttamente !");
		
		
	}catch(IOException e) {
		
		System.out.println("ATTENZIONE ! Errore nell'elaborazione del contenuto.\nERRORE: " + e.getMessage());
	}
	
	
	}
}
