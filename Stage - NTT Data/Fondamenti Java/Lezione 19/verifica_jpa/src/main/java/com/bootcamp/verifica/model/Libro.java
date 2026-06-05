package com.bootcamp.verifica.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
// Per una gestione più accurata nel db inseriamo il @Table name
@Table(name= "libro")
public class Libro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String titolo;

    private String autore;

    @Enumerated(EnumType.STRING)
    private CategoriaLibro categoria;

    private BigDecimal prezzo;


    //Utilizziamo il protected come BEST PRACTISE invece del costruttore privato
    protected  Libro(){}



    public Libro(String titolo, String autore, CategoriaLibro categoria, BigDecimal prezzo) {

        this.titolo = titolo;
        this.autore = autore;
        this.categoria = categoria;
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

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public CategoriaLibro getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaLibro categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
}
