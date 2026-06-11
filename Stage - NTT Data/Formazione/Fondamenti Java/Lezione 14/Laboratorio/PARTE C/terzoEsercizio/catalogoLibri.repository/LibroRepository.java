package com.example.catalogo.repository;

import com.example.catalogo.model.Libro;
import java.util.List;
import java.util.Optional;

public interface LibroRepository {
    
    Libro save(Libro libro);
    List<Libro> findAll();
    Optional<Libro> findById(Long id);
}
