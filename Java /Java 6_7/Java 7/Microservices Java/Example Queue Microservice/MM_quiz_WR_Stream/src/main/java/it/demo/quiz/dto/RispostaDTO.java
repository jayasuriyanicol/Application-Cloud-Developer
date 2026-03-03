package it.demo.quiz.dto;

public class RispostaDTO {

	private Integer idRisposta;
	private Integer indice;
	private String testoRisposta;
	private Boolean corretta;
	private String spiegazione;

	public RispostaDTO() {}

	public RispostaDTO(Integer indice, String testoRisposta, Boolean corretta, String spiegazione) {
		this.indice = indice;
		this.testoRisposta = testoRisposta;
		this.corretta = corretta;
		this.spiegazione = spiegazione;
	}

	public Integer getIdRisposta() {
		return idRisposta;
	}

	public void setIdRisposta(Integer idRisposta) {
		this.idRisposta = idRisposta;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public String getTestoRisposta() {
		return testoRisposta;
	}

	public void setTestoRisposta(String testoRisposta) {
		this.testoRisposta = testoRisposta;
	}

	public Boolean getCorretta() {
		return corretta;
	}

	public void setCorretta(Boolean corretta) {
		this.corretta = corretta;
	}

	public String getSpiegazione() {
		return spiegazione;
	}

	public void setSpiegazione(String spiegazione) {
		this.spiegazione = spiegazione;
	}

	@Override
	public String toString() {
		return "RispostaDTO [idRisposta=" + idRisposta + ", indice=" + indice + ", testoRisposta=" + testoRisposta
				+ ", corretta=" + corretta + ", spiegazione=" + spiegazione + "]";
	}


}
