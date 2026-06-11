package com.example.catalogo.model;

public class Libro {
    private Long id;
    private String titolo;
    private String autore;
    private int pagine;
    private double prezzo;

    public Libro(String titolo, String autore, int pagine, double prezzo) {

        if (titolo == null || titolo.trim().isEmpty()) {
            throw new IllegalArgumentException("ATTENZIONE ! Il titolo non può essere vuoto");
        }
        if (autore == null || autore.trim().isEmpty()) {
            throw new IllegalArgumentException("ATTENZIONE ! L'autore non può essere vuoto");
        }
        if (pagine <= 0) {
            throw new IllegalArgumentException("ATTENZIONE ! Il numero di pagine deve essere maggiore di 0");
        }
        if (prezzo < 0) {
            throw new IllegalArgumentException(" ATTENZIONE ! Il prezzo non può essere negativo");
        }
        this.titolo = titolo;
        this.autore = autore;
        this.pagine = pagine;
        this.prezzo = prezzo;
    }


    public Long getId() {
		 return id; 
		 }
    public void setId(Long id) { 
		this.id = id; 
		}
    public String getTitolo() { 
		return titolo;
		 }
    public String getAutore() {
		 return autore; 
		 }
    public int getPagine() { r
	eturn pagine;
	 }
    public double getPrezzo() {
		 return prezzo;
		  }
}
