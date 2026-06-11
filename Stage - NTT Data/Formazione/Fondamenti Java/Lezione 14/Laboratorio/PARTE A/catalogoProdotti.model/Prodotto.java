package catalogoProdotti.model;

public class Prodotto {
	
	private String nome;
	private Double prezzo;
	private Long id;
	
	
	
	public Prodotto() {}



	public Prodotto(String nome, Double prezzo, Long id) {
		
		this.nome = nome;
		this.prezzo = prezzo;
		this.id = id;
		
		if(nome == null || nome.isBlank()) { throw new IllegalArgumentException("ATTENZIONE ! il nome risulta incompleto o mancante");}
		if(prezzo == null || prezzo < 0) { throw new IllegalArgumentException("ATTENZIONE ! il risulta risulta minore di 0 o mancante");}
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Double getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

	
	


	@Override
	public String toString() {
		return "PRODOTTO -> \nNOME: " + nome + "\nPREZZO: " + prezzo + "\nID PRODOTTO: " + id;
	}
	
	
	
	
	
	
	
	
	
	

}
