'''
Description
• If you want to perform a series of operations on a list of products.
• The Product is defined by:
• Code (numeric)
• Description
• Category (food, media, clothing, electronics)
• Quantity
• Availability (Boolean)
• Price
• Discount (percentage)

'''
package eserciziLezione12;

public class Prodotto {

	private final int codice;
	private String descrizione;
	
	private String categoria;
	private int quantita;
	private Boolean disponibilita;
	private Double prezzo;
	private int percentuale;
	
	public Prodotto(int codice, String descrizione,String categoria , int quantita, Boolean disponibilita, Double prezzo,
			int percentuale) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.quantita = quantita;
		this.disponibilita = disponibilita;
		this.prezzo = prezzo;
		this.percentuale = percentuale;
	}
	
	


	public void setDescrizione(String descrizione) {
		
		this.descrizione = descrizione;
	}
	
	
	public void setCategoria(String categoria) {
		
		this.categoria = categoria;
	}
	public void setQuantita(int quantita) {
		
		this.quantita = quantita;
	}
	
    public void setDisponibilita(Boolean disponibilita) {
    	
    	
    	this.disponibilita = disponibilita;
    	
    }
    
    public void setPrezzo(Double prezzo) {
    	
    	this.prezzo = prezzo;
    }
    
    public void setPercentuale(int numero) {
    	
    	this.percentuale = numero;
    	
    	
    }


	public double getCodice() {
		return codice;
	}


	public String getDescrizione() {
		return descrizione;
	}

   public String getCategoria() {
	   
	   return categoria;
   }
   
	public int getQuantita() {
		return quantita;
	}


	public Boolean getDisponibilita() {
		return disponibilita;
	}

	
	public Double getPrezzo() {
		return prezzo;
	}


	public int getPercentuale() {
		return percentuale;
	}


	@Override
	public String toString() {
		return "\n\n| PRODOTTO -> " + descrizione.toUpperCase() + " | " +  "\n\nCODICE: " + codice + "\n\nDESCRIZIONE: " + descrizione  +"\n\nCATEGORIA: " + categoria + "\n\nQUANTITÀ: " + quantita
				+ "\n\nDISPONIBILITÀ: " + disponibilita + "\n\nPREZZO: " + prezzo + "\n\nPERCENTUALE: " + percentuale;
	}
    
	
	
    
    
    
    
	
	
}
