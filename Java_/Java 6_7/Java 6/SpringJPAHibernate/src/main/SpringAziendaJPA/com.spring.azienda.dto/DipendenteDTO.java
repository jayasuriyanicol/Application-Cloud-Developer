package com.spring.azienda.dto;

import com.spring.azienda.entity.Azienda;
import com.spring.azienda.entity.PostoAuto;

/* * DipendenteDTO - Professional Resource Data Carrier
    ? A specialized data transfer object representing the "Dipendente" (Employee) entity. It acts as a comprehensive container for personal details, financial status, and organizational links, allowing the service layer to move employee data across the system without exposing the heavy JPA persistence logic.

    ! 1. Relational Entity Embedding, directly includes 'Azienda' and 'PostoAuto' objects. This ensures that when an employee's profile is sent to the client, it carries the full context of their assigned workplace and parking resources, providing a "complete" view of the employee's corporate footprint in a single network trip.
    ! 2. Identification Logic via Natural Key, utilizes the 'matricola' (String) as the primary identifier. By mirroring the business-level identification system used in real companies, this DTO simplifies front-end lookups and makes the data more readable for administrative users compared to a standard numeric ID.
    ! 3. Strategic State Visualization, provides a custom 'toString' method that focuses on the core identity and resources (Matricola, Salary, Parking) while omitting the full 'Azienda' details. This prevents infinite recursion loops during logging or debugging when both the Employee and Company reference each other.
*/

public class DipendenteDTO {
		
		//PK
		private String matricola;
		
		private String nome,cognome;
		private Double salarioDipendente;
		
		//PK Azienda

		private Azienda aziendaRiferimento;
		
		//PK PostoAuto
		private PostoAuto postoAuto;
		
		public DipendenteDTO() {}

		public DipendenteDTO(String matricola, String nome, String cognome, Double salarioDipendente, PostoAuto postoAuto, Azienda aziendaRiferimento) {
			
			this.matricola = matricola;
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

