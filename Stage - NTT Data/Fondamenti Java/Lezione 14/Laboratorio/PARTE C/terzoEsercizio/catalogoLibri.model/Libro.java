public class Libro {

    // Attributi
    private String titolo;
    private String autore;
    private int pagine;
    private double prezzo;

    // Costruttore completo
    public Libro(String titolo, String autore, int pagine, double prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.pagine = pagine;
        this.prezzo = prezzo;
    }

    // Costruttore vuoto (spesso utile per librerie come Jackson o Hibernate)
    public Libro() {
    }

    // Getter e Setter
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // Metodo toString personalizzato sulla tua sintassi
    @Override
    public String toString() {
        return "LIBRO -> \nTITOLO: " + titolo + "\nAUTORE: " + autore + "\nPAGINE: " + pagine + "\nPREZZO: " + prezzo;
    }
}
