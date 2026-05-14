package Lezione_07;

public class Prodotto {
	
    private String nome, descrizione;
    private Double prezzo;
    
	public Prodotto(String nome, String descrizione, Double prezzo) {
		
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	@Override
	public String toString() {
		return "PRODOTTO -> \nNOME: " + nome + "\nDESCRIZIONE: " + descrizione + "\nPREZZO: " + prezzo ;
	}
    
    
    

}
