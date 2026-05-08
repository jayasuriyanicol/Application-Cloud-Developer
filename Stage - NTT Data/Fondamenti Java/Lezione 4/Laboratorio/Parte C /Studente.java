package Lezione_04;

public class Studente {

    private String nome, cognome, matricola;
    private Double mediaVoti;

    public Studente() {}

    public Studente(String nome, String cognome, String matricola, Double mediaVoti) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        setMediaVoti(mediaVoti);
    }

   
   
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Double getMediaVoti() {
		return mediaVoti;
	}

	public void setMediaVoti(Double mediaVoti) {
        if (mediaVoti != null && mediaVoti >= 0.0 && mediaVoti <= 30.0) {
            this.mediaVoti = mediaVoti;
        } else {
            System.out.println("ATTENZIONE! La media deve essere fra 0.0 e 30.0");
        }
    }

    
    public void stampaScheda() {
        System.out.println("NOME: " + nome);
        System.out.println("COGNOME: " + cognome);
        System.out.println("MATRICOLA: " + matricola);
        System.out.println("MEDIA VOTI: " + mediaVoti);
    }

    
    public Boolean isPromosso() {
        if (mediaVoti != null && mediaVoti >= 18.0) {
            return true;
        }
        return false;
    }
}
