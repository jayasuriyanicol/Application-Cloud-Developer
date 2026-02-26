package com.spring.azienda.dto;

import com.spring.azienda.entity.Dipendente;

/* * PostoAutoDTO - Corporate Asset Data Carrier
    ? A specialized data transfer object representing the "PostoAuto" (Parking Spot) resource. It facilitates the management of secondary company assets by decoupling the physical location data from the complex JPA lifecycle of the associated employee.

    ! 1. Bidirectional Resource Mapping, includes a direct reference to the 'Dipendente' entity. This allows the API to return a "who is parked where" view in a single request, providing immediate visibility into the assignment of physical space within the company's infrastructure.
    ! 2. Spatial Asset Identification, utilizes the 'posizione' (String) attribute to store descriptive location data (e.g., "Level 1, Sector B"). By separating this from the primary key, the DTO allows for human-readable navigation of company facilities while maintaining a strict numeric 'idPostoAuto' for database operations.
    ! 3. Structured State Representation, provides a 'toString' override that bundles the ID, assigned employee, and physical position. This is particularly useful for logging administrative changes, such as when a parking spot is reassigned or vacated during the employee offboarding process.
*/

public class PostoAutoDTO {
		
		//PK
		private Integer idPostoAuto;
		
		
		//FK
		private Dipendente dipendenteAzienda;
		
		private String posizione;
		
		
		public PostoAutoDTO() {}

		public PostoAutoDTO(Integer idPostoAuto, Dipendente dipendenteAzienda, String posizione) {
			
			this.dipendenteAzienda = dipendenteAzienda;
			this.posizione = posizione;
		}

		public Integer getIdPostoAuto() {
			return idPostoAuto;
		}

		public void setIdPostoAuto(Integer idPostoAuto) {
			this.idPostoAuto = idPostoAuto;
		}

		public Dipendente getDipendenteAzienda() {
			return dipendenteAzienda;
		}

		public void setDipendenteAzienda(Dipendente dipendenteAzienda) {
			this.dipendenteAzienda = dipendenteAzienda;
		}

		public String getPosizione() {
			return posizione;
		}

		public void setPosizione(String posizione) {
			this.posizione = posizione;
		}

		@Override
		public String toString() {
			return "PostoAuto [IdPostoAuto=" + idPostoAuto + ", dipendenteAzienda=" + dipendenteAzienda + ", posizione="
					+ posizione + "]";
		}
		
		
		
		
		
		
		
		
	}


