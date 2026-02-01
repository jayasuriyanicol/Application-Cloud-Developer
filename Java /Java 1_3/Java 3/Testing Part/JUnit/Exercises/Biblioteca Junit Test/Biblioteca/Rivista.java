package Biblioteca;

/* * Rivista - Concrete Publication Implementation
    ? Represents a magazine resource extending 'Pubblicazione', tracking a specific attribute for physical condition ('statoUsura') alongside standard metadata.

    ! 1. Rivista(...), constructor that delegates base attribute initialization to super() and captures the specific wear-and-tear level.
    ! 2. calcolaPrezzo(int giorniPrestato), implements a flat pricing logic that relies solely on the inventory count and base price, intentionally ignoring the loan duration (unlike 'Libro').
*/

public class Rivista extends Pubblicazione{

    private int statoUsura;

    public Rivista(String codicePub, String titolo, String casaEditrice, int numCopie, double prezzoBase, int statoUsura) {
    	
        super(codicePub, titolo, casaEditrice, numCopie, prezzoBase);
        this.statoUsura = statoUsura;
    }
    
    
	public void setStatoUsura(int statoUsura) {
		this.statoUsura = statoUsura;
	}
    
    public int getStatoUsura() {
		return statoUsura;
	}

	@Override
    double calcolaPrezzo(int giorniPrestato ) {
        return getNumeroCopie() * getPrezzoBase();
    }

}