package JDBC.ReportAziendale;

import java.util.Objects;


/* * Mansione - Job Role Entity Model
    ? Represents the domain model for a specific job position, encapsulating the role's identity and its associated financial constraints (salary range).

    ! 1. Identity Semantics (equals/hashCode), relies strictly on the unique 'id' field for object comparison, ensuring that role distinctness is maintained regardless of changes to the name or salary bands.
    ! 2. Business Logic Data, stores 'stipendioMinimo' and 'stipendioMassimo' to define the valid compensation bracket for this specific role, serving as a reference for employee salary validation.
*/


public class Mansione {

	private final int id;
	private String nome;
	private double stipendioMinimo; 
	private double stipendioMassimo; 

	public Mansione(int id, String nome, double stipendioMinimo, double stipendioMassimo) {

		this.id = id;
		this.nome = nome;
		this.stipendioMinimo = stipendioMinimo;
		this.stipendioMassimo = stipendioMassimo;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getStipendioMinimo() {
		return stipendioMinimo;
	}

	public double getStipendioMassimo() {
		return stipendioMassimo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

    //Doing equals to check if there isn't another OBJ like the real one
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mansione other = (Mansione) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "|MANSIONE ID|:  " + id + "\n|NOME MANSIONE| -> " + nome;
	}

	
}