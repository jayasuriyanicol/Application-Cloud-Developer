package it.demo.quiz.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.demo.quiz.dto.DomandaConRisposteDTO;
import it.demo.quiz.dto.DomandaDTO;
import it.demo.quiz.dto.RispostaDTO;
import it.demo.quiz.entity.Domanda;
import it.demo.quiz.entity.Risposta;
import it.demo.quiz.repository.DomandaRepository;
import it.demo.quiz.utility.DomandaUtility;

@Service
@Transactional
public class DomandaServiceImpl implements DomandaService {

	@Autowired
	private DomandaRepository daoD;
	
	@Autowired
	private DomandaUtility utilD;

	@Override
	public DomandaConRisposteDTO modificaDomanda(DomandaDTO dto) {
		Domanda d = daoD.findById(dto.getIdDomanda()).orElseThrow(()-> new NoSuchElementException("la domanda richiesta non è presente: " + dto.getIdDomanda()));
		d.setDifficolta(dto.getDifficolta());
		d.setTestoDomanda(dto.getTestoDomanda());
		
		return utilD.daDomandaADomandaConRispostaDTO(d);
	}

	@Override
	public DomandaConRisposteDTO modificaRispostaDomanda(int idDomanda, RispostaDTO dto) {
		Domanda d = daoD.findById(idDomanda).orElseThrow(()-> new NoSuchElementException("la domanda richiesta non è presente: " + idDomanda));
		Risposta r = d.getRisposta(dto.getIndice());
		r.setSpiegazione(dto.getSpiegazione());
		r.setTestoRisposta(dto.getTestoRisposta());
		d.setVersione(d.getVersione()+1);
		return utilD.daDomandaADomandaConRispostaDTO(d);
	}

	@Override
	public DomandaConRisposteDTO leggiDomanda(int idDomanda) {
		Domanda d = daoD.findById(idDomanda).orElseThrow(()-> new NoSuchElementException("la domanda richiesta non è presente: " + idDomanda));
		System.out.println(d);
		return utilD.daDomandaADomandaConRispostaDTO(d);
	}

	@Override
	public List<RispostaDTO> leggiRisposte(int idDomanda) {
		Domanda d = daoD.findById(idDomanda).orElseThrow(()-> new NoSuchElementException("la domanda richiesta non è presente: " + idDomanda));
		List<Risposta> risposte = d.getListaRisposte();
		return utilD.daListRispostaAListRispostaDTO(risposte);
	}

	@Override
	public int getVersioneDomanda(int idDomanda) {
		Domanda d = daoD.findById(idDomanda).orElseThrow(()-> new NoSuchElementException("la domanda richiesta non è presente: " + idDomanda));
		return d.getVersione();
	}

	@Override
	public void registraDomanda(DomandaConRisposteDTO dto) {
		Domanda d = utilD.daDomandaConRispostaDTOADomanda(dto);
		daoD.save(d);
	}
	
	

}
