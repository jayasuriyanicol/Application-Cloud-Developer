package com.bootcamp.verifica.dto;

import com.bootcamp.verifica.model.CategoriaLibro;

import java.math.BigDecimal;

public class LibroRequest {


    private String titolo;
    private String autore;
    private CategoriaLibro categoria;
    private BigDecimal prezzo;


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
