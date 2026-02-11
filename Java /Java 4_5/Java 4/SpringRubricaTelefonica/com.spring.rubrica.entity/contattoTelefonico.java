package com.spring.rubrica.entity;

import java.util.Objects;


/* * contattoTelefonico - Domain Entity
    ? Represents the fundamental unit of data in the phonebook application, modeling a single person's contact details. It defines the business rules for contact identity and initialization.

    ! 1. Identity Definition (Equals/HashCode), overrides object comparison to establish uniqueness based solely on Case-Insensitive Name and Surname. Consequently, two contacts with the same name but different phone numbers are treated as duplicates within a Set.
    ! 2. Enforced Defaults, the constructor acts as a gatekeeper, explicitly ignoring the input arguments for 'Group' and 'Favorite' status, forcing them to "default" and false respectively to ensure a consistent initial state.
*/


public class contattoTelefonico {
	
	
	private String nome,cognome,numero,gruppoAppartenenza,dataNascita;
	private boolean contattoPreferito;

	
	
	//Setted in the constructor the field gruppoAppartenenza and contattoPreferito as "default" and false.
	public contattoTelefonico(String nome, String cognome, String numero, String gruppoAppartenenza, String dataNascita,
			boolean contattoPreferito) {
	
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppoAppartenenza = "default";
		this.dataNascita = dataNascita;
		this.contattoPreferito = false;
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



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getGruppoAppartenenza() {
		return gruppoAppartenenza;
	}



	public void setGruppoAppartenenza(String gruppoAppartenenza) {
		this.gruppoAppartenenza = gruppoAppartenenza;
	}



	public String getDataNascita() {
		return dataNascita;
	}



	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}



	public boolean getContattoPreferito() {
		return contattoPreferito;
	}



	public void setContattoPreferito(boolean contattoPreferito) {
		this.contattoPreferito = contattoPreferito;
	}
	
	
	
	//Doing the equals to get if are the same one, pointing on the same memory location
	@Override 
	public boolean equals(Object o) {
		
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		contattoTelefonico contatto = (contattoTelefonico) o ;
		
				
		return Objects.equals(nome.toLowerCase(), contatto.nome.toLowerCase()) && Objects.equals(cognome.toLowerCase(), contatto.cognome.toLowerCase());
	}
	
	
	//Doing the hash code to base it on name and surname 

	@Override
	public int hashCode() {
		
		return Objects.hash(nome.toLowerCase(), cognome.toLowerCase());
	}
	
	
	
	
	
	
	
	
	
	
	

}
