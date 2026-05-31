package eserciziLezione10;
import java.util.Objects;

public class Prodotti {
	
	
	private final String  id;
	private String Marca;
	private String Modello;
	private Double prezzoaVendita;
	private int tempiSpedizione;
	
	
	public Prodotti(String id, String Marca, String Modello, Double prezzoVendita, int tempiSpedizione) {
		
		this.id = id;
		this.Marca= Marca;
		this.Modello = Modello;
		this.prezzoaVendita = prezzoVendita;
		this.tempiSpedizione = tempiSpedizione;	
		
	}
	
	
	public void setMarca(String marca) {
		Marca = marca;
	}
	
	

	public void setModello(String modello) {
		Modello = modello;
	}

	


	public void setPrezzoaVendita(Double prezzoaVendita) {
		this.prezzoaVendita = prezzoaVendita;
	}
	
	
	
	public void setTempiSpedizione(int tempiSpedizione) {
		this.tempiSpedizione = tempiSpedizione;
	}

	

	public String getId() {
		return id;
	}
	
	
	

	public String getMarca() {
		return Marca;
	}


	

	public String getModello() {
		return Modello;
	}



	public Double getPrezzoaVendita() {
		return prezzoaVendita;
	}



	public int getTempiSpedizione() {
		return tempiSpedizione;
	}
 
	
	@Override
	public boolean equals(Object o) {
		
		if(this == o) {
			
			return true;
		}
		
		if (o == null || getClass() != o.getClass()){
			
			return false;
		}
		
		Prodotti prodotto = (Prodotti) o;
		return Objects.equals(id, prodotto.id);
		
	}
	
	
	@Override 
	public int hashCode() {
		
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "\nPRODOTTI \nID: " + id + "\nMARCA: " + Marca + "\nMODELLO: " + Modello + "\nPREZZO DI VENDITA: " + prezzoaVendita
				+ "\nTEMPI DI SPEDIZIONE: " + tempiSpedizione ;
	}


	
	
	



	
	
}
