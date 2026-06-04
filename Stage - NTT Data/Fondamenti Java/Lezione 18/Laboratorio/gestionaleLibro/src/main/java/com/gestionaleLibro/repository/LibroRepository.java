package com.gestionaleLibro.repository;

import com.gestionaleLibro.model.CategoriaLibro;
import com.gestionaleLibro.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByCategoria(CategoriaLibro c);
    List<Libro> findByPrezzoGreaterThan(BigDecimal prezzo);


}

