package Lezione_07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportWriter {
	
	
	
	private final Path percorsoReport = Path.of("src/Lezione_07/report-ordine.txt");
	
	
	public void scritturaFile(String contenuto) throws OrdineNonValidoException, IOException {
		
		Files.writeString(percorsoReport, contenuto);
		
	}
}
