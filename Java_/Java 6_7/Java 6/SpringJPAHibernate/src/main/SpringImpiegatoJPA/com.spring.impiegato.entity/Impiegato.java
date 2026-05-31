package com.spring.impiegati.entity;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;
import tools.jackson.databind.ext.javatime.ser.LocalDateTimeSerializer;


/* * Impiegato - Persistent Employee Entity with Temporal Mapping
    ? The core domain model representing an employee in the database. This class utilizes Jakarta Persistence (JPA) for ORM mapping and incorporates advanced Jackson annotations to handle complex date-time serialization specifically for HR record-keeping.

    ! 1. Specialized Temporal Handling, uses '@JsonFormat' along with custom serializers and deserializers for 'LocalDateTime'. This ensures that the hiring date is precisely formatted as "dd-MM-yyyy HH:mm:ss" when moving between the Java backend and the JSON-based web interface, preventing common timezone or parsing errors.
    ! 2. Corporate ID Primary Key, identifies the 'matricola' (employee ID) as the unique '@Id'. In an industrial context, this ensures that every employee record is indexed by their official company serial number, facilitating fast lookups and strictly preventing duplicate personnel entries.
    ! 3. Persistence Context Integration, as a registered '@Entity', this class acts as a direct blueprint for the database table. It allows Hibernate to manage the employee's lifecycle—from initial hire (persist) to salary adjustments (merge) and termination (remove)—while maintaining state synchronization.
*/

@Entity
public class Impiegato {
	
	
	private String nome,cognome;
	
	@Id
	private Integer matricola;
	private Double  salarioMensile;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime dataAssunzione;
	
	public Impiegato() {}
	
	public Impiegato(String nome, String cognome, Integer matricola, Double salarioMensile,
			LocalDateTime dataAssunzione) {
	
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.salarioMensile = salarioMensile;
		this.dataAssunzione = dataAssunzione;
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



	public Integer getMatricola() {
		return matricola;
	}



	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}



	public Double getSalarioMensile() {
		return salarioMensile;
	}



	public void setSalarioMensile(Double salarioMensile) {
		this.salarioMensile = salarioMensile;
	}



	public LocalDateTime getDataAssunzione() {
		return dataAssunzione;
	}



	public void setDataAssunzione(LocalDateTime dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}



	@Override
	public String toString() {
		return "Impiegato [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", salarioMensile="
				+ salarioMensile + ", dataAssunzione=" + dataAssunzione + "]";
	}
	
	
	
	
	
	
	
	

}
