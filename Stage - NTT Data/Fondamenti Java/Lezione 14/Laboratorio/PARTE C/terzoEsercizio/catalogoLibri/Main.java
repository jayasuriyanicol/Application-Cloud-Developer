package com.example.catalogo;

import com.example.catalogo.dto.LibroRequest;
import com.example.catalogo.dto.LibroResponse;
import com.example.catalogo.repository.InMemoryLibroRepository;
import com.example.catalogo.repository.LibroRepository;
import com.example.catalogo.service.LibroService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       
        LibroRepository repository = new InMemoryLibroRepository();
        LibroService service = new LibroService(repository);

        
        try {
            LibroResponse l1 = service.creaProdotto(new LibroRequest("Il capo", "Giacomo Coccodrillini", 1200, 25.0));
            LibroResponse l2 = service.creaProdotto(new LibroRequest("AssertFalse", "Franco il gabbiano", 328, 12.50));
        
        } catch (Exception e) {
            System.out.println("ATTENZIONE ! errore inaspettato: " + e.getMessage());
        }

    
        List<LibroResponse> catalogo = service.trovaTutti();
        catalogo.forEach(System.out.println);

       
        try {
            LibroResponse trovato = service.trovaPerId(1L);
            System.out.println("SUCCESSO ! Trovato ID 1: " + trovato);
        } catch (Exception e) {
            System.out.println("ATTENZIONE ! Errore: " + e.getMessage());
        }

    
        try {
            service.creaProdotto(new LibroRequest("ExcpetionHandler", "Nico", 0, 10.0));
        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE ! Errore intercettato nella  Model: " + e.getMessage());
        }

        try {
            service.creaProdotto(new LibroRequest("Libro Gratis Fallito", "Autore Anonimo", 150, -5.0));
        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE! Errore intercettato nel Model: " + e.getMessage());
        }

    
        try {
            service.trovaPerId(99L);
        } catch (RuntimeException e) {
            System.out.println("ERRORE! Errore intercettato nel Service: " + e.getMessage());
        }
    }
}
