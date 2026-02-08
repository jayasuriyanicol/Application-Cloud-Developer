package com.spring.dto;

/* * StudentiDTO - Data Transfer Object
    ? A dedicated container for transferring student data between the REST Controller and the Service layer. It isolates the internal database entity ('Studente') from the external API contract.

    ! 1. StudentiDTO(), the no-argument constructor is essential for JSON deserialization libraries (like Jackson). It includes a log message ("Spring sta costruendo...") to trace exactly when the request payload is converted into a Java object.
    ! 2. Data Carrier, aggregates specific fields (matricola, address, enrollment year) that match the expected JSON structure for API requests and responses.
*/

public class StudentiDTO {

		
String nome, cognome,indirizzo;
int annoNascita, annoImmatricolazione;
int matricola;
		
	public StudentiDTO(int matricola, String nome, String cognome, String indirizzo, int annoNascita,
				int annoImmatricolazione) {
	
		super();
		
			this.matricola = matricola;
			this.nome = nome;
			this.cognome = cognome;
			this.indirizzo = indirizzo;
			this.annoNascita = annoNascita; 
			this.annoImmatricolazione = annoImmatricolazione;
		}	


		public StudentiDTO() {
			System.out.println("Spring sta costruendo lo STUDENTE");
			
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


        		
		public void setMatricola(int matricola) {
			
			this.matricola = matricola;
		}


		public Integer getMatricola() {
			return matricola;
		}
		
		
		
		
		
		

	}
