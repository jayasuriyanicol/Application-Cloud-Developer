package Lezione_07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigurazioneReader {
	
	
	private final Path config = Path.of("src/Lezione_07/config.txt");
	
	
	public String leggiContenuto() throws IOException {
		
		return Files.readString(config);
	}
	

}
