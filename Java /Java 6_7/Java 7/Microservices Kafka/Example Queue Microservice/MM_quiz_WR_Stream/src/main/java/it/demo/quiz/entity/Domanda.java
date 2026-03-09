package it.demo.quiz.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class Domanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDomanda;
	private String testoDomanda;
	private int difficolta;
	
	@Version
	private int versione;
	
	@Enumerated(EnumType.STRING)
	private TipoDomanda tipo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@MapsId("id_risposta")
	@JoinColumn(name="fk_risposta")
	private List<Risposta> listaRisposte = new ArrayList<>();
	
	public Domanda() {}

	public Domanda(int idDomanda, String testoDomanda, int difficolta, int versione, TipoDomanda tipo) {
		this.idDomanda = idDomanda;
		this.testoDomanda = testoDomanda;
		this.difficolta = difficolta;
		this.versione = versione;
		this.tipo = tipo;
	}

	public Domanda(String testoDomanda, int difficolta, TipoDomanda tipo) {
		this.testoDomanda = testoDomanda;
		this.difficolta = difficolta;
		this.tipo = tipo;
	}

	public Risposta getRisposta(int indice) {
		return this.getListaRisposte().stream()
									  .filter(d -> d.getIndice()==indice)
									  .findAny()
									  .orElseThrow();
	}
	
	public int getVersione() {
		return versione;
	}

	public void setVersione(int versione) {
		this.versione = versione;
	}

	public List<Risposta> getListaRisposte() {
		return listaRisposte;
	}

	public void setListaRisposte(List<Risposta> listaRisposte) {
		this.listaRisposte = listaRisposte;
	}

	public void addRisposta(Risposta r) {
		this.listaRisposte.add(r);
	}
	
	public int getIdDomanda() {
		return idDomanda;
	}

	public void setIdDomanda(int idDomanda) {
		this.idDomanda = idDomanda;
	}

	public String getTestoDomanda() {
		return testoDomanda;
	}

	public void setTestoDomanda(String testoDomanda) {
		this.testoDomanda = testoDomanda;
	}

	public int getDifficolta() {
		return difficolta;
	}

	public void setDifficolta(int difficolta) {
		this.difficolta = difficolta;
	}

	public TipoDomanda getTipo() {
		return tipo;
	}

	public void setTipo(TipoDomanda tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Domanda [idDomanda=" + idDomanda + ", testoDomanda=" + testoDomanda + ", difficolta=" + difficolta
				+ ", versione=" + versione + ", tipo=" + tipo + ", listaRisposte=" + listaRisposte + "]";
	}

}
