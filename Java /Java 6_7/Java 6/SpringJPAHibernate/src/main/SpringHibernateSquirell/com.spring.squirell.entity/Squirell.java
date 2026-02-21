package com.spring.squirell.entity;

	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;


    /* * Squirell - Jakarta Persistence Entity
    ? The core domain model representing the persistent state of a 'Squirell'. This class is mapped to a database table via Jakarta Persistence (JPA), allowing the Hibernate ORM to manage the synchronization between the Java object and the relational row.

    ! 1. JPA Metadata Mapping, utilizes the `@Entity` annotation to register this class with the persistence context. This informs Hibernate that it should generate a corresponding table (by default named 'Squirell') and handle all SQL translations for its fields.
    ! 2. Primary Key Definition, the `@Id` annotation marks the `id` field as the unique identifier for the table. This is the mandatory hook that allows the EntityManager to perform specific operations like `find()`, `merge()`, or `remove()` based on the record's unique identity.
    ! 3. Persistence Lifecycle Ready, includes a required no-args constructor and standard encapsulation. This structure allows JPA providers to instantiate the object through reflection when fetching data from the result set, ensuring the data is correctly hydrated into the Java environment.
    */



    //Adding the '@Entity' to mark that this is the main class, we can also create a link with the DB to mark is the name of the table with -> '@Table(name = nameDBtable)'
	@Entity
	public class Squirell {

        //Same to the '@Id' have to mark this is the PK(Primary Key ) of the class 
		@Id
		private int id;
		private String nome;
		private String tipo;

		public Squirell() {}

		public Squirell(int id, String nome, String tipo) {
			
			
	        this.id = id;
			this.nome = nome;
			this.tipo = tipo;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			
        	this.id= id;
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

	
