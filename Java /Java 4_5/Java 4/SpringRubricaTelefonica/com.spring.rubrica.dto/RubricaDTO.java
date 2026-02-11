package com.spring.rubrica.dto;

import java.util.HashSet;

import com.spring.rubrica.entity.contattoTelefonico;

/* * RubricaDTO - Phonebook Container
    ? Represents the Data Transfer Object for a specific Phonebook ("Rubrica"). It groups the owner's metadata with a collection of unique contacts to be sent to or received from the client.

    ! 1. Collection Uniqueness, utilizes a `HashSet` for the `contatto` field, ensuring that the list of contacts transferred is free of duplicates (relying on the Contact's `equals` and `hashCode` logic).
    ! 2. Serialization Lifecycle, the no-args constructor includes a print statement ("Spring sta costruendo..."), providing a runtime trace to confirm when the JSON deserializer or Spring framework instantiates this object.
    ! 3. Naming Distinction, the field `idContatto` actually backs the `getId()` method, serving as the identifier for the *Phonebook itself*, not a specific contact, which is critical for correct data mapping.
*/


public class RubricaDTO {

		
	

		private int idContatto;
		private String proprietario, annoCreazione;
		private HashSet<contattoTelefonico> contatto = new HashSet<>();

		public RubricaDTO(String proprietario, String annoCreazione) {
			
		
			this.proprietario = proprietario;
			this.annoCreazione = annoCreazione;
		}

		
		public RubricaDTO() {
			
			System.out.println("Spring sta costruendo la RUBRICA");
		
		}

		
		public void setId(int id) {
			
			this.idContatto = id;
		}
		
		public int getId() {
			
			return idContatto;
		}
		
		
		public String getProprietario() {
			return proprietario;
		}

		public void setProprietario(String proprietario) {
			this.proprietario = proprietario;
		}

		public String getAnnoCreazione() {
			return annoCreazione;
		}

		public void setAnnoCreazione(String annoCreazione) {
			this.annoCreazione = annoCreazione;
		}
		
		
		public HashSet<contattoTelefonico> getContatti() {
			return contatto;
		
		}
		
		public void setContatti(HashSet<contattoTelefonico> contatto) {
			this.contatto = contatto;
		}
		
		
		
		
			

	}


		