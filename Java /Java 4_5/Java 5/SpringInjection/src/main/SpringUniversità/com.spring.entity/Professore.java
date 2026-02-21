package com.spring.entity;


/* * Professore - Entity Model
    ? Rappresenta il modello dati (POJO) per un docente, funge da contenitore strutturato per le informazioni anagrafiche e professionali (materia insegnata) che attraversano i vari layer dell'applicazione.

    ! 1. Encapsulation, mantiene i dati privati (nome, cognome, materia) ed espone l'accesso solo tramite i metodi pubblici getter e setter.
    ! 2. Professore(), il costruttore vuoto è essenziale per permettere ai framework (es. Spring, Jackson) di istanziare l'oggetto tramite reflection prima del binding dei dati.
*/

public class Professore {
	
	private String nome,cognome,materiaInsegnamento;
	private int id;
	
	public Professore(int id,String nome,String cognome, String materiaInsegnamento) {
		
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.materiaInsegnamento = materiaInsegnamento;
		
	}
	
	public Professore() {
		
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

	public String getMateriaInsegnamento() {
		return materiaInsegnamento;
	}

	public void setMateriaInsegnamento(String materiaInsegnamento) {
		this.materiaInsegnamento = materiaInsegnamento;
	}

	public void setId(int IdProfessore) {
		
		this.id = IdProfessore;
		
		
	}

	public void setId(int id) {
			this.id = id;
	}

	
	public int getId() {
		return id;
	}
	
	

}
