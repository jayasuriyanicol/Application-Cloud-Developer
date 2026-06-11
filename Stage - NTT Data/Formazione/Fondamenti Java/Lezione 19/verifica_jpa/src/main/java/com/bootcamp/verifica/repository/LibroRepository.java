package com.bootcamp.verifica.repository;


import com.bootcamp.verifica.model.CategoriaLibro;
import com.bootcamp.verifica.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // BONUS here the search of categoria
    List<Libro> findByCategoria(CategoriaLibro categoria);
}
