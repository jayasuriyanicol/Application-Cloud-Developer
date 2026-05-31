package com.spring.dto;

public class UtenteDTO {

	private String nome,cognome,mail,telefono;
	private int idUtente;
	

	
	
	public UtenteDTO(String nome, String cognome, String mail, String telefono, int idUtente) {
		super();
		
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.telefono = telefono;
		this.idUtente = idUtente;
	}




	public UtenteDTO() {
		
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
