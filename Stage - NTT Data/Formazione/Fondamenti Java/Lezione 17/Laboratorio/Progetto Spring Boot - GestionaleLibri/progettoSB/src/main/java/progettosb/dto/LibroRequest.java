package progettosb.dto;


import progettosb.model.CategoriaLibro;

public record LibroRequest(String titolo, String autore, CategoriaLibro categoria, int pagine, double prezzo) {}

