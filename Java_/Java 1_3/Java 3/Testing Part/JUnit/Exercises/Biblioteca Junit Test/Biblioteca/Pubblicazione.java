package Biblioteca;

import java.util.Objects;


/* * Pubblicazione - Abstract Resource Entity
    ? The foundational abstract class for all library catalog items, managing core metadata (ID, title, publisher), base pricing, and inventory stock levels.

    ! 1. incrementaNumeroCopie(int n) / decrementaNumeroCopie(int n), manage the physical inventory of the item, with safety checks to prevent negative stock levels.
    ! 2. calcolaPrezzo(int giorniPrestato), an abstract method compelling subclasses to define their specific rental pricing logic based on the loan duration.
    ! 3. equals() / hashCode(), enforces identity based solely on the unique 'codicePubblicazione', ensuring proper behavior in collections like HashMaps.
*/

public abstract class Pubblicazione {

    private String codicePubblicazione;
    private String titolo;
    private String casaEditrice;
    private int numeroCopie;
    private double prezzoBase;

    public Pubblicazione(String codicePubblicazione, String titolo, String casaEditrice, int numeroCopie, double prezzoBase) {
        this.codicePubblicazione = codicePubblicazione;
        this.titolo = titolo;
        this.casaEditrice = casaEditrice;
        this.numeroCopie = numeroCopie;
        this.prezzoBase = prezzoBase;
    }

    public String getPubblicazione() {
        return codicePubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public int getNumeroCopie() {
        return numeroCopie;
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    @Override
    public boolean equals(Object o) {
    	
        if (o == null || getClass() != o.getClass()) return false;
        Pubblicazione that = (Pubblicazione) o;
        return Objects.equals(codicePubblicazione, that.codicePubblicazione);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codicePubblicazione);
    }

    void incrementaNumeroCopie(int n){
        numeroCopie += n;
    }

    void decrementaNumeroCopie(int n){
        if (numeroCopie - n >= 0){
             numeroCopie -= n;
        }
    }

    abstract double calcolaPrezzo(int giorniPrestato);

}

