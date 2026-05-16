package Lezione_07;

public record Ordine (String cliente, String prodotto, Integer quantità, Double prezzoUnitario) {


public Double calcolaTotale() {
	
	return this.quantità * this.prezzoUnitario; 
}

public String riepilogo() {
	
	
	return "ORDINE:" + this.cliente + "\nPRODOTTO: " + this.prodotto  + "\nQUANTITA': " + this.quantità + "\nPREZZO UNITARIO: " + this.prezzoUnitario;
}

	
	
	
}