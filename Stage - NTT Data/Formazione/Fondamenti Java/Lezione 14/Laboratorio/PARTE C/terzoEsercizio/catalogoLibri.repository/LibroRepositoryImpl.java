package com.example.catalogo.repository;

import com.example.catalogo.model.Libro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryLibroRepository implements LibroRepository {

    private final Map<Long, Libro> database = new HashMap<>();
    private long idSequenziale = 1L;

    @Override
    public Libro save(Libro libro) {

        if (libro.getId() == null) {
            libro.setId(idSequenziale++);
        }
        
        database.put(libro.getId(), libro);
        return libro;
    }

    @Override
    public List<Libro> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<Libro> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }
}
