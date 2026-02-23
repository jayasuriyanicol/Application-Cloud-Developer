package com.spring.azienda.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.spring.azienda.entity.Dipendente;


public class AziendaDTO {
	
		//PK
		private Integer idAzienda;
		
		private String intestazione;
		private Double capitaleSociale;
		
		//FK
		Set<Dipendente> listaDipendenti= new HashSet<>();

		
		
		public AziendaDTO() {}
		
		
		public AziendaDTO(Integer idAzienda, String intestazione, Double capitaleSociale, Set<Dipendente> listaDipendenti) {
			
			this.idAzienda = idAzienda;
			this.intestazione = intestazione;
			this.capitaleSociale = capitaleSociale;
			this.listaDipendenti = listaDipendenti;
			
			
		}


		public Integer getIdAzienda() {
			return idAzienda;
		}


		public void setIdAzienda(Integer idAzienda) {
			this.idAzienda = idAzienda;
		}


		public String getIntestazione() {
			return intestazione;
		}


		public void setIntestazione(String intestazione) {
			this.intestazione = intestazione;
		}


		public Double getCapitaleSociale() {
			return capitaleSociale;
		}


		public void setCapitaleSociale(Double capitaleSociale) {
			this.capitaleSociale = capitaleSociale;
		}


		public Set<Dipendente> getListaDipendenti() {
			return listaDipendenti;
		}


		public void setListaDipendenti(Set<Dipendente> listaDipendenti) {
			this.listaDipendenti = listaDipendenti;
		}
		
		

		
		//Doing the Hash and Equals to prevent any inconguence in the list of Dipendenti
		@Override
		public int hashCode() {
			return Objects.hash(listaDipendenti);
		}


		@Override
		public boolean equals(Object obj) {
			
			if (this == obj)
				return true;
			
			if (obj == null)
				return false;
			
			if (getClass() != obj.getClass())
				return false;
			
			
			AziendaDTO other = (AziendaDTO) obj;
			return Objects.equals(listaDipendenti, other.listaDipendenti);
		}


		
	

		
		
	}


