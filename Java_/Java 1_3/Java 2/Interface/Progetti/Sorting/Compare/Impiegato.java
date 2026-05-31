package corsoBase;

import java.util.Date;

public class Impiegato implements Comparable<Impiegato> {
	private String nome;
	private double salario;
	private Date dataAssunzione;
	public Impiegato(String nome, double salario, Date dataAssunzione) {
		this.nome = nome;
		this.salario = salario;
		this.dataAssunzione = dataAssunzione;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	@Override
	public String toString() {
		return "Nome impiegato =" + nome + ", salario=" + salario + ", dataAssunzione=" + dataAssunzione;
	}
	
	public int getAnnoAssunzione() {
		return this.dataAssunzione.getYear() + 1900;
	}
	
	public void incrSalario(double aumento) {
		this.salario += aumento;
	}

	@Override
	public int compareTo(Impiegato o) {
		// Criterio che induce l'ordinamento crescente per nome
		return this.nome.compareTo(o.nome);
	}
}