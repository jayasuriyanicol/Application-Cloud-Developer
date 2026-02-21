package com.spring.dto;

/* * ProfessoriDTO - Data Transfer Object
    ? A lightweight object designed to transport data between the Service layer and the external API (Controller), ensuring that the internal database entity is not directly exposed to the client.

    ! 1. Decoupling, acts as a buffer between the public interface and the domain model, allowing the internal structure to evolve independently of the external contract.
    ! 2. Serialization Tracing, the no-argument constructor includes a console log ("Spring sta costruendo...") to visually confirm when the framework (e.g., Jackson) instantiates the object during JSON deserialization.
*/


public class ProfessoriDTO {
	

		private String nome,cognome,materiaInsegnamento;
		private int id;
		
		public ProfessoriDTO(int id,String nome,String cognome, String materiaInsegnamento) {
			
			this.id = id;
			this.nome = nome;
			this.cognome = cognome;
			this.materiaInsegnamento = materiaInsegnamento;
			
		}
		
		public ProfessoriDTO() {
		
		System.out.println("Spring sta costruendo il PROFESSORE");
		
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

		public String getMateriaInsegnamento() {
			return materiaInsegnamento;
		}

		public void setMateriaInsegnamento(String materiaInsegnamento) {
			this.materiaInsegnamento = materiaInsegnamento;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public int getId() {
			return id;
		}
		
		

	}


	
