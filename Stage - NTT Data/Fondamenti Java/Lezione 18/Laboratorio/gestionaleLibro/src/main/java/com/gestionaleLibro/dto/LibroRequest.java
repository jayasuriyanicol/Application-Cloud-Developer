package com.gestionaleLibro.dto;


import com.gestionaleLibro.model.CategoriaLibro;

public record LibroRequest(String titolo, String autore, CategoriaLibro categoria, int pagine, double prezzo) {}

