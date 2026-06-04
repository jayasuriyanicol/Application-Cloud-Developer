package com.gestionaleLibro.mapper;

import com.gestionaleLibro.dto.LibroRequest;
import com.gestionaleLibro.dto.LibroResponse;
import com.gestionaleLibro.model.Libro;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class LibroMapper {

    public Libro toModel(LibroRequest request) {
        // Passiamo 'null' come primo parametro (l'ID).
        // In questo modo diciamo a Hibernate che si tratta di un NUOVO libro e MySQL gli assegnerà l'ID corretto.
        return new Libro(
                null,
                request.titolo(),
                request.autore(),
                request.categoria(),
                request.pagine(),
                request.prezzo(),
                LocalDate.now()
        );
    }

    public LibroResponse toResponse(Libro libro) {
        if (libro == null) {
            return null;
        }

        return new LibroResponse(
                libro.getId(),
                libro.getTitolo(),
                libro.getAutore(),
                libro.getCategoria().name(),
                libro.getPagine(),
                libro.getPrezzo(),
                libro.getDataInserimento()
        );
    }

    public List<LibroResponse> toResponseList(List<Libro> libri) {
        if (libri == null) {
            return List.of();
        }

        return libri.stream()
                .map(this::toResponse)
                .toList();
    }
}
