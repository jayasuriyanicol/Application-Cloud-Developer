public class Prodotto {

    private String nome, categoria;
    private Double prezzo;

    public Prodotto(String nome, String categoria, Double prezzo){

        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "PRODOTTO -> Nome: " + nome + "\nCategoria: " + categoria + "\nPrezzo: " + prezzo;

    }
}
