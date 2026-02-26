package com.spring.azienda.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.spring.azienda.entity.Dipendente;


/* * AziendaDTO - Enterprise Data Transfer Object
    ? A decoupled data carrier designed to transport company information across application layers. It acts as a protective "contract" between the service layer and the API clients, ensuring that internal database entities remain hidden while providing a structured view of the company's financial and personnel state.

    ! 1. Relational Collection Mapping, uses a 'Set<Dipendente>' to represent the One-to-Many association with employees. By choosing a 'HashSet', the DTO enforces uniqueness at the transport level, mirroring the business rule that a single employee cannot be duplicated within the same corporate roster during data transit.
    ! 2. Intentional State Encapsulation, provides a comprehensive constructor and standard Java Bean accessors (Getters/Setters). This structure allows the 'Mapper' classes to cleanly hydrate the DTO from a JPA entity, facilitating a smooth transition from persistent database rows to a JSON-serializable format for the Controller.
    ! 3. Equality & Consistency Logic, overrides 'hashCode' and 'equals' specifically targeting the 'listaDipendenti'. This ensures that the DTO can be safely used in collections or comparison operations, preventing data incongruence when the application needs to synchronize or validate the employee list between different service calls.
*/

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


