package com.spring.azienda.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.spring.azienda.entity.Dipendente;


/* * AziendaInfoDTO - Analytical Data Projection
    ? A specialized version of the company DTO designed specifically for reporting and statistical views. Unlike the standard DTO, this object includes aggregated metadata—such as the total count of employees—allowing the frontend to display key performance indicators (KPIs) without performing manual calculations on the client side.

    ! 1. Calculated Field Integration, introduces the 'numeroDipendenti' attribute. This field is essential for summary dashboards, as it provides an immediate numerical snapshot of the workforce size that can be populated directly via a JPA constructor expression or a specialized service method, optimizing data delivery for overview screens.
    ! 2. Comprehensive State Representation, maintains the core identity of the company ('intestazione', 'capitaleSociale') while grouping it with the detailed 'listaDipendenti'. This makes the DTO a "one-stop-shop" for UI components that need to show a header with company stats followed by a detailed list of personnel.
    ! 3. Robust Identity Management, inherits the same 'hashCode' and 'equals' logic focused on the employee set. This ensures that even when used in complex UI frameworks or caching layers, the object maintains its integrity based on the unique collection of people it represents, preventing duplicate rendering in analytical views.
*/

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




