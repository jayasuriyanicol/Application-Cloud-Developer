package corsoBase;

import java.util.Date;

public class Impiegato {

	
	
	private String nome;
	private double salario;
	private Date dataAssunzione;
	
	
		
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
		return "Impiegato [nome=" + nome + ", salario=" + salario + "]";
	}
	
	
	public int getAnnoAssunzione() {
		
		
		//Addign 1900 for deprecate problem
		return this.dataAssunzione.getYear() + 1900;
		
	}
	
	public void incrSalario(double aumento) {
		
		this.salario += aumento;
		
	}
	
	
	

	
	}
	
