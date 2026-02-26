package it.demo.quiz.dto;

import org.springframework.hateoas.RepresentationModel;

public class DomandaDTO extends RepresentationModel<DomandaDTO>{

	private Integer idDomanda;
	private String testoDomanda;
	private Integer difficolta;
	private String tipoDomanda;
	
	public DomandaDTO() {}

	public DomandaDTO(String testoDomanda, Integer difficolta, String tipoDomanda) {
		this.testoDomanda = testoDomanda;
		this.difficolta = difficolta;
		this.tipoDomanda = tipoDomanda;
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

	

	@Override
	public String toString() {
		return "DomandaDTO [idDomanda=" + idDomanda + ", testoDomanda=" + testoDomanda + ", difficolta=" + difficolta
				+ ", tipoDomanda=" + tipoDomanda + "]";
	}

}
