package bootcamp.catalogo.dto;

import bootcamp.catalogo.model.CategoriaLibro;

public record LibroRequest(String titolo,String autore,CategoriaLibro categoria,int pagine,double prezzo) {}
