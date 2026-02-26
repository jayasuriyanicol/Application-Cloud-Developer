package it.demo.quiz.dto;

import org.springframework.hateoas.RepresentationModel;

public class DomandaDTO extends RepresentationModel<DomandaDTO>{

	private Integer idDomanda;
	private String testoDomanda;
	private Integer difficolta;
	
	public DomandaDTO() {}
	
	public DomandaDTO(Integer idDomanda, String testoDomanda, Integer difficolta) {
		this.idDomanda = idDomanda;
		this.testoDomanda = testoDomanda;
		this.difficolta = difficolta;
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
				+  "]";
	}

}
