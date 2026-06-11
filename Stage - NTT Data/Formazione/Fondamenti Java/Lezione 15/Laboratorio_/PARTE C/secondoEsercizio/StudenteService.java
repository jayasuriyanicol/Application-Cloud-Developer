package it.corso.bootcamp.service;

import java.util.List;

import it.corso.bootcamp.dto.StudenteResponseDTO;

public class StudenteService {

	private final List<StudenteResponseDTO> studenti = List.of(
			new StudenteResponseDTO("Dragoncelli Simone", "RM0023", 30.0),
			new StudenteResponseDTO("Fiutini Franco", "MI0302", 22.2),
			new StudenteResponseDTO("Miele Drago", "RM0323", 18.2));

	public List<StudenteResponseDTO> getAllStudenti() {
		return studenti;
	}

	public StudenteResponseDTO getPrimoStudente() {

		if (studenti.isEmpty()) {
			return null;
		}
		return studenti.get(0);
	}

}
