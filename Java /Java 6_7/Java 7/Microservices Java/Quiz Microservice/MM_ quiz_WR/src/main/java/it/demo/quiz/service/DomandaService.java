package it.demo.quiz.service;

import java.util.List;

import it.demo.quiz.dto.DomandaConRisposteDTO;
import it.demo.quiz.dto.DomandaDTO;
import it.demo.quiz.dto.RispostaDTO;

public interface DomandaService {

	public void registraDomanda(DomandaConRisposteDTO dto);
	public DomandaConRisposteDTO modificaDomanda(DomandaDTO dto);
	public DomandaConRisposteDTO modificaRispostaDomanda(int idDomanda, RispostaDTO dto);
	
	public DomandaConRisposteDTO leggiDomanda(int idDomanda);
	public List<RispostaDTO> leggiRisposte(int idDomanda);
	public int getVersioneDomanda(int idDomanda);
	
	
}
