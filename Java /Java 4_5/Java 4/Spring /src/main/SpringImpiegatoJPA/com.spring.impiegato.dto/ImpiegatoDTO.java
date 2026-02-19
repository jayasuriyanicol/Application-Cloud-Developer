package com.spring.impiegati.dto;
import java.time.LocalDateTime;

/* * ImpiegatoDTO - Human Resources Data Transfer Object
    ? A comprehensive data carrier representing an employee within the HR module. It decouples the API's external contract from the internal database schema, providing a structured way to transfer personal, professional, and temporal data (like hiring dates) across system layers.

    ! 1. Temporal Data Management, utilizes 'LocalDateTime' for the 'dataAssunzione' field. This allows the API to communicate precise hiring timestamps in a standardized ISO format, which is essential for payroll calculations and seniority tracking.
    ! 2. Professional Identity Mapping, uses 'matricola' (Employee ID) as the primary logical identifier. By defining this in the DTO, the system can ensure that search and update operations are performed against a specific corporate record rather than just a name.
    ! 3. Precision Financial Formatting, employs 'Double' for 'salarioMensile' to accommodate decimal currency values. This ensures that salary-related logic—such as the updates seen in the Controller—maintains numerical precision during JSON serialization and deserialization.
*/

public class ImpiegatoDTO {
		
		
		private String nome,cognome;
		private Integer matricola;
		private Double  salarioMensile;
		private LocalDateTime dataAssunzione;
		
		public ImpiegatoDTO() {}
		
		
		public ImpiegatoDTO(String nome, String cognome, Integer matricola, Double salarioMensile,
				LocalDateTime dataAssunzione) {
		
			this.nome = nome;
			this.cognome = cognome;
			this.matricola = matricola;
			this.salarioMensile = salarioMensile;
			this.dataAssunzione = dataAssunzione;
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



		public Integer getMatricola() {
			return matricola;
		}



		public void setMatricola(Integer matricola) {
			this.matricola = matricola;
		}



		public Double getSalarioMensile() {
			return salarioMensile;
		}



		public void setSalarioMensile(Double salarioMensile) {
			this.salarioMensile = salarioMensile;
		}



		public LocalDateTime getDataAssunzione() {
			return dataAssunzione;
		}



		public void setDataAssunzione(LocalDateTime dataAssunzione) {
			this.dataAssunzione = dataAssunzione;
		}



		@Override
		public String toString() {
			return "Impiegato [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", salarioMensile="
					+ salarioMensile + ", dataAssunzione=" + dataAssunzione + "]";
		}
		
		
		

	}


