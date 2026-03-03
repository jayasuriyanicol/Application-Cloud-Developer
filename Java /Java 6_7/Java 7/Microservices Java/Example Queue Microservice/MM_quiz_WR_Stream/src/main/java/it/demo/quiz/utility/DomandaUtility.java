package it.demo.quiz.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import it.demo.quiz.dto.DomandaConRisposteDTO;
import it.demo.quiz.dto.DomandaDTO;
import it.demo.quiz.dto.RispostaDTO;
import it.demo.quiz.entity.Domanda;
import it.demo.quiz.entity.Risposta;
import it.demo.quiz.entity.TipoDomanda;

@Component
public class DomandaUtility {
	
	public Domanda daDomandaConRispostaDTOADomanda(DomandaConRisposteDTO dto) {
		Domanda d = new Domanda();
		d.setTipo(TipoDomanda.valueOf(dto.getTipoDomanda()));
		d.setDifficolta(dto.getDifficolta());
		d.setTestoDomanda(dto.getTestoDomanda());
		d.setListaRisposte(daListRispostaDTOAListRisposta(dto.getRisposte()));
		return d;
	}
	
	public Risposta daRispostaDTOARisposta(RispostaDTO dto) {
		if(dto==null) return null;
		
		Risposta r = new Risposta();
		r.setIndice(dto.getIndice());
		r.setCorretta(dto.getCorretta());
		r.setSpiegazione(dto.getSpiegazione());
		r.setTestoRisposta(dto.getTestoRisposta());
		
		return r;
	}
	
	public List<RispostaDTO> daListRispostaAListRispostDTO(List<Risposta> lista){
		List<RispostaDTO> l = new ArrayList<>();
		for (Risposta risposta : lista) 
			l.add(daRispostaARispostaDTO(risposta));
		return l;
	}
	
	public DomandaConRisposteDTO daDomandaADomandaConRispostaDTO(Domanda d) {
		if(d==null) return null;
		
		DomandaConRisposteDTO dto = new DomandaConRisposteDTO();
		dto.setIdDomanda(d.getIdDomanda());
		dto.setDifficolta(d.getDifficolta());
		dto.setTestoDomanda(d.getTestoDomanda());
		dto.setTipoDomanda(d.getTipo().toString());
		dto.setRisposte(daListRispostaAListRispostaDTO(d.getListaRisposte()));
		return dto;
	}
	
	public DomandaDTO daDomandaADomandaDTO(Domanda d) {
		if(d==null) return null;
		
		DomandaDTO dto = new DomandaDTO();
		dto.setIdDomanda(d.getIdDomanda());
		dto.setDifficolta(d.getDifficolta());
		dto.setTestoDomanda(d.getTestoDomanda());
		dto.setTestoDomanda(d.getTipo().toString());
		return dto;
	}
	
	public RispostaDTO daRispostaARispostaDTO(Risposta r) {
		if(r==null) return null;
		
		RispostaDTO dto = new RispostaDTO();
		dto.setIdRisposta(r.getIdRisposta());
		dto.setIndice(r.getIndice());
		dto.setCorretta(r.isCorretta());
		dto.setSpiegazione(r.getSpiegazione());
		dto.setTestoRisposta(r.getTestoRisposta());
		
		return dto;
	}
	
	public List<DomandaDTO> daListDomandaAListDomandaDTO(List<Domanda> l) {
		return l.stream().map(d -> daDomandaADomandaDTO(d)).collect(Collectors.toList());
	}
	
	public List<RispostaDTO> daListRispostaAListRispostaDTO(List<Risposta> l) {
		return l.stream().map(r -> daRispostaARispostaDTO(r)).collect(Collectors.toList());
	}
	
	public List<Risposta> daListRispostaDTOAListRisposta(List<RispostaDTO> l) {
		return l.stream().map(r -> daRispostaDTOARisposta(r)).collect(Collectors.toList());
	}
}
