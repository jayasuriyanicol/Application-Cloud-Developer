package com.spring.azienda.dto;

import com.spring.azienda.entity.Azienda;
import com.spring.azienda.entity.PostoAuto;

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

