package com.spring.rubrica.dto;

import java.util.Objects;

/* * ContattoTelefonicoDTO - Contact Data Transfer Object
    ? Represents the data structure for a phone contact as exchanged between the client and the server. It acts as a carrier for contact details, ensuring that JSON payloads are correctly mapped to Java objects.

    ! 1. Identity Definition (Equals & HashCode), explicitly overrides default object comparison. Two contacts are considered identical based solely on their Case-Insensitive Name and Surname, ignoring other fields like phone number or group.
    ! 2. Enforced Defaults, the parameterized constructor hardcodes specific initial states (Group = "default", Favorite = false), effectively ignoring those specific input arguments to ensure a standardized starting state for new instances.
    ! 3. Serialization Support, includes a no-args constructor with a log message, which is essential for libraries like Jackson to instantiate the object via reflection during JSON deserialization.
*/



public class ContattoTelefonicoDTO {
	


		private String nome,cognome,numero,gruppoAppartenenza,dataNascita;
		private boolean contattoPreferito;

		
		
		//Setted in the constructor the field gruppoAppartenenza and contattoPreferito as "default" and false.
		public ContattoTelefonicoDTO(String nome, String cognome, String numero, String gruppoAppartenenza, String dataNascita,
				boolean contattoPreferito) {
		
			this.nome = nome;
			this.cognome = cognome;
			this.numero = numero;
			this.gruppoAppartenenza = "default";
			this.dataNascita = dataNascita;
			this.contattoPreferito = false;
		}
		
		
		public ContattoTelefonicoDTO() {
			
			
			System.out.println("Spring sta costruendo il CONTATTO TELEFONICP");
			
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
			
			ContattoTelefonicoDTO contatto = (ContattoTelefonicoDTO) o ;
			
					
			return Objects.equals(nome.toLowerCase(), contatto.nome.toLowerCase()) && Objects.equals(cognome.toLowerCase(), contatto.cognome.toLowerCase());
		}
		
		
		//Doing the hash code to base it on name and surname 

		@Override
		public int hashCode() {
			
			return Objects.hash(nome.toLowerCase(), cognome.toLowerCase());
		}
		
		
		
		
		
		
		
		
		
		
		

	}


