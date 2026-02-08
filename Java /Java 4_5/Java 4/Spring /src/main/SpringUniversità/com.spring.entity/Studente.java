package com.spring.entity;

/* * Studente - Student Entity Model
    ? A POJO (Plain Old Java Object) representing the student data structure, holding personal details (name, address, birth year) and academic info (matriculation year, ID).

    ! 1. Studente(), the no-argument constructor is provided to ensure compatibility with frameworks like Spring or Jackson, which require it for object instantiation via reflection.
    ! 2. Matricola (ID), serves as the unique identifier for the student within the system, exposed via specific accessors.
*/


public class Studente {
	
	String nome, cognome,indirizzo;
	int annoNascita, annoImmatricolazione;

	int matricola;
	
	public Studente(int matricola, String nome, String cognome, String indirizzo, int annoNascita,
			int annoImmatricolazione) {
	
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.annoNascita = annoNascita;
		this.annoImmatricolazione = annoImmatricolazione;
	}


	public Studente() {
		
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



	public String getIndirizzo() {
		return indirizzo;
	}



	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}



	public int getAnnoNascita() {
		return annoNascita;
	}



	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}



	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}



	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}


	public void setMatricola(Integer matricola) {
		
		this.matricola = matricola;
		
		
	}
	public Integer getMatricola() {
		return matricola;
	}
	
	
	
	
	
	

}
