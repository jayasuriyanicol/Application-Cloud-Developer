package com.spring.azienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


/* * Dipendente - Core Relational Entity
    ? The central persistent model representing an employee within the organizational database. This class functions as the relational "bridge," linking individual personnel data to both their parent corporate entity (Azienda) and their assigned physical assets (PostoAuto) through JPA's association mapping.

    ! 1. Natural Key Enforcement, utilizes the '@Column(unique = true, nullable = false)' annotation on the 'matricola' field. While the database uses an auto-incrementing 'idDipendente' for internal indexing, this ensures that the business-facing employee ID remains globally unique and non-null, preventing duplicate records during the hiring process.
    ! 2. Hierarchical Many-to-One Linkage, establishes a formal '@ManyToOne' relationship with 'Azienda' via the 'FK_Dipendente' join column. This creates the "Many" side of the association, allowing multiple employees to be grouped under a single company while ensuring each employee belongs to exactly one corporate reference.
    ! 3. Optional One-to-One Resource Mapping, implements an '@OneToOne' association with 'PostoAuto'. By setting 'nullable = true' on the 'JoinColumn', the entity models the real-world scenario where a parking spot is an optional benefit—allowing the system to persist employees who may not yet have an assigned space without violating database constraints.
*/


@Entity
public class Dipendente {
	
	//Adding incremental value for the PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDipendente;
	
	@Column(unique = true, nullable = false)
	private String matricola;
	private String nome,cognome;
	private Double salarioDipendente;
	
	//Rapresenting the relationship between each other ->  1 .. 1 and the FK with FK_Dipendente
	@ManyToOne
	@JoinColumn(name = "FK_Dipendente")
	private Azienda aziendaRiferimento;
	
	//Rapresenting the relationship between each other ->  0 .. 1 and the FK with FK_PostoAuto
	@OneToOne
	@JoinColumn(name = "FK_PostoAuto", nullable = true)
	private PostoAuto postoAuto;
	
	public Dipendente() {}

	public Dipendente(String matricola, String nome, String cognome, Double salarioDipendente, PostoAuto postoAuto, Azienda aziendaRiferimento) {
		
		
		this.nome = nome;
		this.cognome = cognome;
		this.salarioDipendente = salarioDipendente;
		this.postoAuto = postoAuto;
		this.aziendaRiferimento = aziendaRiferimento;
	}
	
	
	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
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


	public Double getSalarioDipendente() {
		return salarioDipendente;
	}


	public void setSalarioDipendente(Double salarioDipendente) {
		this.salarioDipendente = salarioDipendente;
	}


	public PostoAuto getPostoAuto() {
		return postoAuto;
	}


	public void setPostoAuto(PostoAuto postoAuto) {
		this.postoAuto = postoAuto;
	}
	
	


	public Azienda getAziendaRiferimento() {
		return aziendaRiferimento;
	}


	public void setAziendaRiferimento(Azienda aziendaRiferimento) {
		this.aziendaRiferimento = aziendaRiferimento;
	}


	@Override
	public String toString() {
		return "Dipendente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", salarioDipendente="
				+ salarioDipendente + ", postoAuto=" + postoAuto + "]";
	}

	
	

}
