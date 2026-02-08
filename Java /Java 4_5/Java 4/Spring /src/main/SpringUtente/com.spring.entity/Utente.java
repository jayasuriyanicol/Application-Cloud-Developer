package com.spring.entity;

/* * Utente - Domain Entity / POJO
    ? Represents the core user data model containing personal details and contact information. It is designed with logging inside constructors and accessors to demonstrate the object lifecycle and property injection within the Spring context.

    ! 1. Utente(), the no-argument constructor required by frameworks (like Spring or Jackson) for instantiation, modified here to log a confirmation message ("Spring sta costruendo...") to the console.
    ! 2. setIdUtente(int) / getIdUtente(), specific accessor methods instrumented with print statements to trace exactly when the ID property is written to or read from during execution.
*/



public class Utente {

	private String nome,cognome,mail,telefono;
	private int idUtente;
	

	
	public Utente(String nome, String cognome, String mail, String telefono, int idUtente) {
		super();
		
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.telefono = telefono;
		this.idUtente = idUtente;
	}




	public Utente() {
		
		System.out.println("Spring sta costruendo l'utente");
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getNome() {
		return nome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	
	public String getCognome() {
		return cognome;
	}





	public void setMail(String mail) {
		this.mail = mail;
	}
	

	public String getMail() {
		return mail;
	}






	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setIdUtente(int idUtente) {
		System.out.println("SET ID");
		
		this.idUtente = idUtente;
	}
	
	
	
	public int getIdUtente() {
		System.out.println("GET ID");
		return idUtente;
	}




	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + ", telefono=" + telefono
				+ ", idUtente=" + idUtente + "]";
	}
	
	

	
}
