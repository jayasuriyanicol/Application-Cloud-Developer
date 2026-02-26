package it.demo.quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Risposta {

	@Id
	private int idRisposta;
	private int indice;
	private String testoRisposta;
	private String spiegazione;
	private boolean corretta;
	
	public Risposta() {}
	
	public Risposta(int indice, String testoRisposta, String spiegazione, boolean corretta) {
		this.indice = indice;
		this.testoRisposta = testoRisposta;
		this.spiegazione = spiegazione;
		this.corretta = corretta;
	}

	public int getIdRisposta() {
		return idRisposta;
	}

	public void setIdRisposta(int idRisposta) {
		this.idRisposta = idRisposta;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public String getTestoRisposta() {
		return testoRisposta;
	}

	public void setTestoRisposta(String testoRisposta) {
		this.testoRisposta = testoRisposta;
	}

	public String getSpiegazione() {
		return spiegazione;
	}

	public void setSpiegazione(String spiegazione) {
		this.spiegazione = spiegazione;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	@Override
	public String toString() {
		return "Risposta [idRisposta=" + idRisposta + ", indice=" + indice + ", testoRisposta=" + testoRisposta
				+ ", spiegazione=" + spiegazione + ", corretta=" + corretta + "]";
	}
}
