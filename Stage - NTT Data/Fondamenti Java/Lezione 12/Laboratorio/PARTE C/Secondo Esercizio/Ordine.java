public class Ordine {


    private String codice,cliente;
    private Double totale;

    public Ordine(String codice, String cliente, Double totale) {
        this.codice = codice;
        this.cliente = cliente;
        this.totale = totale;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getTotale() {
        return totale;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }


    @Override
    public String toString() {

        return "CLIENTE : \nNOME: " + getCliente() + "\nCODICE: " + getCodice() + "\nTOTALE: " +getTotale();

    }
}