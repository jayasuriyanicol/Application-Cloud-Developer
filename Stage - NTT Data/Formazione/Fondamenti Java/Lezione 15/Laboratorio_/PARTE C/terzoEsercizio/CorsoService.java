package it.corso.bootcamp.service;

import it.corso.bootcamp.dto.CorsoResponseDTO;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CorsoService {

	public List<CorsoResponseDTO> getAllCorsi() {
		return List.of(new CorsoResponseDTO("JAVA", "Java SE 17 Intensive Bootcamp", 80),
				new CorsoResponseDTO("SPRING", "Sviluppo Web con Spring Boot", 60));
	}

	public CorsoResponseDTO getCorsoJava() {
		return new CorsoResponseDTO("JAVA", "Java SE 17 Intensive Bootcamp", 80);
	}

	public CorsoResponseDTO getCorsoSpring() {
		return new CorsoResponseDTO("SPRING", "Sviluppo Web con Spring Boot", 60);
	}
}
