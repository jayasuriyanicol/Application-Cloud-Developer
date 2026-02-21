package com.spring.squirell.dto;

/* * SquirellDTO - Data Transfer Object for Squirrel Entities
    ? A lightweight data carrier used to shuttle information between the web layer and the service layer. It acts as a sanitized version of the Squirrel domain model, containing only the properties necessary for API communication.

    ! 1. Client-Side Decoupling, by separating the DTO from the Hibernate Entity, the API structure is protected from changes in the database schema. This allows you to rename columns or change internal data types without forcing users of your API to update their integration.
    ! 2. Optimized Serialization, contains basic Java types (int, String) that map perfectly to JSON fields. This simplicity ensures that the Jackson library can quickly convert the object into an HTTP response body, maximizing performance for mobile and web clients.
    ! 3. POJO Compliance, follows the standard Plain Old Java Object pattern with a default no-args constructor and standard getters/setters. This makes it fully compatible with Spring’s data binding and reflection-based frameworks.
*/

	public class SquirellDTO {
		
		private int id;
		private String nome;
		private String tipo;

		public SquirellDTO() {}

		public SquirellDTO(int id, String nome, String tipo) {
	
			this.id= id;
			this.nome = nome;
			this.tipo = tipo;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id	= id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
	} 

	

