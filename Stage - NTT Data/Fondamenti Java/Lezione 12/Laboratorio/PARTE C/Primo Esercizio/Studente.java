
public class Studente {

    private String nome,corso;
    private Double media;

    public Studente(String nome, String corso, Double media) {
        this.nome = nome;
        this.corso = corso;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorso() {
        return corso;
    }

    public void setCorso(String corso) {
        this.corso = corso;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }


    @Override
    public String toString() {return "\nSTUDENTE: \nNOME: " + getNome() + "\nCORSO: " + getCorso() + "\nMEDIA: " + getMedia(); }
}