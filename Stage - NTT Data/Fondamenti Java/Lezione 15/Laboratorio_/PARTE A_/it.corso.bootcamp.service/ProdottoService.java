package it.corso.bootcamp.service;

import it.corso.bootcamp.dto.ProdottoResponseDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdottoService {


public List<ProdottoResponseDTO> findAll() {
		
	return List.of(
	new ProdottoResponseDTO(1L, "Mouse", 29.99),
	new ProdottoResponseDTO(2L, "Monitor", 180.00),
	new ProdottoResponseDTO(3L, "Tastiera", 49.99)
);
	
}
}