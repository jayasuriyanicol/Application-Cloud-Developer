package Biblioteca;

import java.util.Objects;


/* * Tessera - Membership Card Entity
    ? Represents the library card associated with a user, acting as a wallet that holds a unique identification code and a monetary balance.

    ! 1. ricarica(double importo), a placeholder method intended to top up the card's available balance.
    ! 2. scala(double importo), a placeholder method intended to deduct funds from the balance, likely for paying rental fees or fines.
    ! 3. equals()/hashCode(), enforces identity based strictly on the 'codiceTessera', ensuring that cards with the same code are treated as the same object.
*/

public class Tessera {

    private String codiceTessera;
    private double importoTessera;

    public Tessera(String codice, double importo) {
    	
        this.codiceTessera = codice;
        this.importoTessera = importo;
    }



	public void setCodiceTessera(String codiceTessera) {
		this.codiceTessera = codiceTessera;
	}
	
	public String getCodiceTessera() {
    	
        return codiceTessera;
    }


	public void setImportoTessera(double importoTessera) {
		this.importoTessera = importoTessera;
	}



    public double getImportoTessera() {
        return importoTessera;
    }

    
    @Override
    public boolean equals(Object o) {
    	
        if (o == null || getClass() != o.getClass()) return false;
        
        Tessera tessera = (Tessera) o;
        return Objects.equals(codiceTessera, tessera.codiceTessera);
    }

    @Override
    public int hashCode() {
    	
        return Objects.hashCode(codiceTessera);
        
    }

    void ricarica(double importo){
    	
   

    }

    void scala(double importo){

    	
    }

}
