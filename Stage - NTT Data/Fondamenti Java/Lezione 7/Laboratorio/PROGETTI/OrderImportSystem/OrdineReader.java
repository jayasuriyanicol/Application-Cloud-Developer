package Lezione_07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OrdineReader {
	
	private final Path accessoFile = Path.of("src/Lezione_07/ordine.txt");
	
	// ? Andiamo a lanciare eventuali eccezzioni per la Exception personalizzata e l'altra riguardo l'IO
	public Ordine leggiOrdine() throws IOException, OrdineNonValidoException {
		
	String testoGrezzo = Files.readString(accessoFile);
	
	String[] campi = testoGrezzo.replaceAll("\\r?\\n", "").trim().split(",");
	
	
	
	if (campi.length != 4) {
		
		throw new OrdineNonValidoException("ATTENZIONE ! I campio inseriti devono essere esattamnete 4 ");
	}

	// ? Andiamo con la stesura dei dati grezzi
	String cliente  = campi[0].trim();
	String prodotto = campi[1].trim();
	Integer quantità = Integer.parseInt(campi[2].trim());
	Double prezzoUnitario = Double.parseDouble(campi[3].trim());
	
	
	
	// * Ritorniamo il dato vero da quello grezzo
	return new Ordine(cliente,prodotto,quantità,prezzoUnitario);
	}
	
	
	

}
