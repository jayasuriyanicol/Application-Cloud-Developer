package it.demo.quiz.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class DomandaConRisposteDTO extends RepresentationModel<DomandaDTO>{

	private Integer idDomanda;
	private String testoDomanda;
	private Integer difficolta;
	private String tipoDomanda;
	
	private List<RispostaDTO> risposte = new ArrayList<>();
	
	public DomandaConRisposteDTO() {}

	public DomandaConRisposteDTO(Integer idDomanda, String testoDomanda, Integer difficolta, String tipoDomanda,
			List<RispostaDTO> risposte) {
		this.idDomanda = idDomanda;
		this.testoDomanda = testoDomanda;
		this.difficolta = difficolta;
		this.tipoDomanda = tipoDomanda;
		this.risposte = risposte;
	}

	public String getTipoDomanda() {
		return tipoDomanda;
	}

	public void setTipoDomanda(String tipoDomanda) {
		this.tipoDomanda = tipoDomanda;
	}

	public Integer getIdDomanda() {
		return idDomanda;
	}

	public void setIdDomanda(Integer idDomanda) {
		this.idDomanda = idDomanda;
	}

	public String getTestoDomanda() {
		return testoDomanda;
	}

	public void setTestoDomanda(String testoDomanda) {
		this.testoDomanda = testoDomanda;
	}

	public Integer getDifficolta() {
		return difficolta;
	}

	public void setDifficolta(Integer difficolta) {
		this.difficolta = difficolta;
	}

	public List<RispostaDTO> getRisposte() {
		return risposte;
	}

	public void setRisposte(List<RispostaDTO> risposte) {
		this.risposte = risposte;
	}

	@Override
	public String toString() {
		return "DomandaConRisposteDTO [idDomanda=" + idDomanda + ", testoDomanda=" + testoDomanda + ", difficolta="
				+ difficolta + ", tipoDomanda=" + tipoDomanda + ", risposte=" + risposte + "]";
	}
}
