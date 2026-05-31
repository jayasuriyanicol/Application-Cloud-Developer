package com.example.catalogo.mapper;

import com.example.catalogo.dto.LibroRequest;
import com.example.catalogo.dto.LibroResponse;
import com.example.catalogo.model.Libro;

public class LibroMapper {

    public static Libro toModel(LibroRequest r) {

        return new Libro(
			r.getTitolo(), 
			r.getAutore(), 
			r.getPagine(), 
			r.getPrezzo());
    }

    public static LibroResponse toResponse(Libro m) {
		
        return new LibroResponse(m.getId(),
		 m.getTitolo(),
		 m.getAutore(), 
	     m.getPagine(),
		 m.getPrezzo());
    }
}
