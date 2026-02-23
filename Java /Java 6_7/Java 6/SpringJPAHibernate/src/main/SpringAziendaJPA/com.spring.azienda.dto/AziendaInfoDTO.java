package com.spring.azienda.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.spring.azienda.entity.Dipendente;

public class AziendaInfoDTO {

		
			//PK
			private Integer IdAzienda;
			
			private String intestazione;
			private Double capitaleSociale;
			private Integer numeroDipendenti;
			
			//FK
			private Set<Dipendente> listaDipendenti= new HashSet<>();

			
		
			public AziendaInfoDTO() {}
			
			
			public AziendaInfoDTO(Integer idAzienda, String intestazione, Double capitaleSociale, Set<Dipendente> listaDipendenti, Integer numeroDipendenti) {
				
				
				this.intestazione = intestazione;
				this.capitaleSociale = capitaleSociale;
				this.listaDipendenti = listaDipendenti;
				this.numeroDipendenti = numeroDipendenti;
				
				
			}


			public Integer getIdAzienda() {
				return IdAzienda;
			}


			public void setIdAzienda(Integer idAzienda) {
				IdAzienda = idAzienda;
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
			
			

			public Integer getNumeroDipendenti() {
				return numeroDipendenti;
			}


			public void setNumeroDipendenti(Integer numeroDipendenti) {
				this.numeroDipendenti = numeroDipendenti;
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




