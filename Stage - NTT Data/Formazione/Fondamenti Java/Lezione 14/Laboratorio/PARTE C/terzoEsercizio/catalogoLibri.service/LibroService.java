package com.example.catalogo.service;

import com.example.catalogo.dto.LibroRequest;
import com.example.catalogo.dto.LibroResponse;
import com.example.catalogo.mapper.LibroMapper;
import com.example.catalogo.model.Libro;
import com.example.catalogo.repository.LibroRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LibroService {

    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public LibroResponse creaProdotto(LibroRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("ATTENZIONE ! La richiesta non può essere nulla");
        }
        
        Libro libro = LibroMapper.toModel(request);
        Libro libroSalvato = repository.save(libro);
        return LibroMapper.toResponse(libroSalvato);
    }

    public List<LibroResponse> trovaTutti() {
        
        return repository.findAll().stream()
                .map(LibroMapper::toResponse)
                .collect(Collectors.toList());
    }

    public LibroResponse trovaPerId(Long id) {

        Libro libro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Libro con ID " + id + " NON è STATO TROVATO !"));
        return LibroMapper.toResponse(libro);
    }
}
