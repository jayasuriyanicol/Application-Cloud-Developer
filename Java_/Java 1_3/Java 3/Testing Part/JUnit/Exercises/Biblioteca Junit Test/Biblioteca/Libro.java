package Biblioteca;

/* * Libro - Concrete Publication Implementation
    ? Represents a book resource extending 'Pubblicazione', adding specific logic for late fees (mora) and duration-based pricing.

    ! 1. Libro(...), constructor that delegates base attribute initialization to super() and assigns the specific book fine value.
    ! 2. calcolaPrezzo(int giorniPrestato), implements the pricing logic: returns the standard rate (copies * base price) for the first 5 days, but applies a progressive 25% surcharge for every day exceeding that limit.
*/

public class Libro extends Pubblicazione{

    private int moraLibro;

    public Libro(String codicePub, String titolo, String casaEditrice, int numeroCopie, double prezzoBase,int moraLibro) {
    	
        super(codicePub, titolo, casaEditrice, numeroCopie, prezzoBase);
        this.moraLibro = moraLibro;
    }

    public void setMoraLibro(int m) {
		this.moraLibro = m;
	}
	
	public int getMoraLibro() {
		return moraLibro;
	}

	
    @Override
    double calcolaPrezzo(int giorniPrestato) {

        double prezzoIniziale = getNumeroCopie() * getPrezzoBase();

        if (giorniPrestato <= 5) return prezzoIniziale;
        return prezzoIniziale * (1 + (double) ((giorniPrestato - 5) * 25) / 100);
    }

}