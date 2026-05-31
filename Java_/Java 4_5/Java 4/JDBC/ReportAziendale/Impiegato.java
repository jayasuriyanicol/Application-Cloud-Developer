package JDBC.ReportAziendale;

import java.util.Objects;

/* * Impiegato - Employee Entity Model
    ? Represents the core employee domain object within the reporting system. It encapsulates personal details, financial data, and a structural relationship to a specific job role ('Mansione').

    ! 1. Identity Management (equals/hashCode), overrides object equality based strictly on the unique 'matricola' field. This ensures that two employee instances representing the same database record are treated as identical, regardless of mutable field changes.
    ! 2. Association, maintains a direct reference to a 'Mansione' object, modeling a Many-to-One relationship (Many Employees -> One Role) directly in the object graph.
*/


public class Impiegato {

	private final int matricola;
	private String nome;
	private double salarioMensile; 
	private double bonusAnnuale; 
	private Mansione mansione;

	public Impiegato(int matricola, String nome, double salarioMensile, double bonusAnnuale, Mansione mansione) {
	
		this.matricola = matricola;
		this.nome = nome;
		this.salarioMensile = salarioMensile;
		this.bonusAnnuale = bonusAnnuale;
		this.mansione = mansione;
	}

	public int getMatricola() {
		return matricola;
	}

	public String getNome() {
		return nome;
	}

	public double getSalarioMensile() {
		return salarioMensile;
	}

	public double getBonusAnnuale() {
		return bonusAnnuale;
	}

	public Mansione getMansione() {
		return mansione;
	}

	@Override
	public String toString() {
		return matricola + " | " + nome + ", guadagna: " + salarioMensile + "€";
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricola);
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
		Impiegato other = (Impiegato) obj;
		return Objects.equals(matricola, other.matricola);
	}
}