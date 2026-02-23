package com.spring.azienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Dipendente {
	
	//Adding incremental value for the PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDipendente;
	
	@Column(unique = true, nullable = false)
	private String matricola;
	private String nome,cognome;
	private Double salarioDipendente;
	
	//Rapresenting the relationship between each other ->  1 .. 1 and the FK with FK_Dipendente
	@ManyToOne
	@JoinColumn(name = "FK_Dipendente")
	private Azienda aziendaRiferimento;
	
	//Rapresenting the relationship between each other ->  0 .. 1 and the FK with FK_PostoAuto
	@OneToOne
	@JoinColumn(name = "FK_PostoAuto", nullable = true)
	private PostoAuto postoAuto;
	
	public Dipendente() {}

	public Dipendente(String matricola, String nome, String cognome, Double salarioDipendente, PostoAuto postoAuto, Azienda aziendaRiferimento) {
		
		
		this.nome = nome;
		this.cognome = cognome;
		this.salarioDipendente = salarioDipendente;
		this.postoAuto = postoAuto;
		this.aziendaRiferimento = aziendaRiferimento;
	}
	
	
	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Double getSalarioDipendente() {
		return salarioDipendente;
	}


	public void setSalarioDipendente(Double salarioDipendente) {
		this.salarioDipendente = salarioDipendente;
	}


	public PostoAuto getPostoAuto() {
		return postoAuto;
	}


	public void setPostoAuto(PostoAuto postoAuto) {
		this.postoAuto = postoAuto;
	}
	
	


	public Azienda getAziendaRiferimento() {
		return aziendaRiferimento;
	}


	public void setAziendaRiferimento(Azienda aziendaRiferimento) {
		this.aziendaRiferimento = aziendaRiferimento;
	}


	@Override
	public String toString() {
		return "Dipendente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", salarioDipendente="
				+ salarioDipendente + ", postoAuto=" + postoAuto + "]";
	}

	
	

}
