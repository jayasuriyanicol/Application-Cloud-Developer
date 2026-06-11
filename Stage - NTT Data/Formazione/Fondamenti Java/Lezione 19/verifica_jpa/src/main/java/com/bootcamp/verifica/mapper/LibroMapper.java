package com.bootcamp.verifica.mapper;

import com.bootcamp.verifica.dto.LibroRequest;
import com.bootcamp.verifica.dto.LibroResponse;
import com.bootcamp.verifica.model.Libro;
import org.springframework.stereotype.Component;


// Bonus MAPPER to manage to Entity,Response & Update
@Component
public class LibroMapper {


    public Libro toEntity(LibroRequest request) {

        if (request == null) return null;
        return new Libro(
                request.getTitolo(),
                request.getAutore(),
                request.getCategoria(),
                request.getPrezzo()
        );
    }


    public LibroResponse toResponse(Libro libro) {

        if (libro == null) return null;
        LibroResponse response = new LibroResponse();
        response.setId(libro.getId());
        response.setTitolo(libro.getTitolo());
        response.setAutore(libro.getAutore());
        response.setCategoria(libro.getCategoria());
        response.setPrezzo(libro.getPrezzo());
        return response;
    }



    public void toUpdate(LibroRequest request, Libro libro) {

        if (request == null || libro == null) return;
        libro.setTitolo(request.getTitolo());
        libro.setAutore(request.getAutore());
        libro.setCategoria(request.getCategoria());
        libro.setPrezzo(request.getPrezzo());
    }

}
