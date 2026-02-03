package GestioneUtenti;

/* * Utente - User Entity Model
    ? A simple POJO (Plain Old Java Object) representing the user data structure, acting as a data carrier between the database and the application logic.

    ! 1. Encapsulation, maintains private access to user credentials (password) and personal details (username, name, birth year), exposing them only via public getter and setter methods.
*/

public class Utente {
	
	private String username;
	private String nome;
	private String cognome;
	private String password;
	private int anno_nascita;
	
	
	public Utente(String username, String nome, String cognome, String password, int anno_nascita) {
		
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.anno_nascita = anno_nascita;
		

	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAnno_nascita() {
		return anno_nascita;
	}


	public void setAnno_nascita(int anno_nascita) {
		this.anno_nascita = anno_nascita;
	}
}
