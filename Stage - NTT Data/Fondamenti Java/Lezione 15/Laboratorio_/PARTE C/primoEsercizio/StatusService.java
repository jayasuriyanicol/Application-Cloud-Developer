package it.corso.bootcamp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.corso.bootcamp.dto.StuatusResponseDTO;

@Service
public class StatusService {

	public List<StuatusResponseDTO> findAll() {

		return List.of(new StuatusResponseDTO("ATTIVO", "12.0", "PAZIENZA"),
				new StuatusResponseDTO("INATTIVO", "1.32", "BANANA JOE"),
				new StuatusResponseDTO("IN MANUTENZIONE", "323.2", "CRIS_ATTA"));
	}

	public List<StuatusResponseDTO> findVesione(String versione) {

		return List.of(new StuatusResponseDTO("ATTIVO", "12.0", "PAZIENZA"),
				new StuatusResponseDTO("INATTIVO", "1.32", "BANANA JOE"),
				new StuatusResponseDTO("IN MANUTENZIONE", "323.2", "CRIS_ATTA"));

	}

	public String getStatus() {

		return findAll().get(0).status();
	}

	public String getVersione() {

		return findAll().get(0).versione();
	}

	public String getAutore() {

		return findAll().get(0).autore();
	}
}
