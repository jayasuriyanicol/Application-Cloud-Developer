package eserciziLezione13;

public class Prodotto {
	
	private String nome;
	private int quantitàOrdinata;
	private double prezzoUnitario;
	
	
	
	
	public Prodotto(String nome, int quantitàOrdinata, double prezzoUnitario) {
		this.nome = nome;
		this.quantitàOrdinata = quantitàOrdinata;
		this.prezzoUnitario = prezzoUnitario;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setQuantitàOrdinata(int quantitàOrdinata) {
		this.quantitàOrdinata = quantitàOrdinata;
	}
	
	public void setPrezzoUnitario(int prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getQuantitàOrdinata() {
		return quantitàOrdinata;
	}

	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}


	
	
}
