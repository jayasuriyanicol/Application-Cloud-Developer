package com.gestionaleLibro.service;


import com.gestionaleLibro.dto.LibroRequest;
import com.gestionaleLibro.dto.LibroResponse;
import com.gestionaleLibro.exception.LibroNonTrovatoException;
import com.gestionaleLibro.exception.TitoloGiaDuplicatoException;
import com.gestionaleLibro.mapper.LibroMapper;
import com.gestionaleLibro.model.CategoriaLibro;
import com.gestionaleLibro.model.Libro;
import com.gestionaleLibro.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {


    private final LibroRepository repository;
    private final LibroMapper mapper;
    private long nextid = 1L;



    public LibroService(LibroRepository repository, LibroMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }



    public LibroResponse creaLibro(LibroRequest r) {



        if (r.titolo() == null || r.titolo().isBlank()) {

            throw new IllegalArgumentException("ATTENZIONE ! Il titolo è obbligatorio");

        }

        if (r.autore() == null || r.autore().isBlank()) {

            throw new IllegalArgumentException("ATTENZIONE ! l'autore del libro è obbligatorio");

        }

        if (r.categoria() == null) {

            throw new IllegalArgumentException(
                    "ATTENZIONE ! la categoria è obbligatoria e deve rispecchiare gli enum disponibili");

        }

        if (r.pagine() <= 0) {

            throw new IllegalArgumentException("ATTENZIONE ! le pagine totali devo essere maggiori di 0");

        }

        if (r.prezzo() < 0) {

            throw new IllegalArgumentException("ATTENZIONE ! Il prezzo NON PUO' essere minore di zero !");

        }


        boolean verificaTitolo = repository.findAll().stream()

                .anyMatch(l -> l.getTitolo().equalsIgnoreCase(r.titolo()));

        if(verificaTitolo) {

            throw new TitoloGiaDuplicatoException(r.titolo());
        }


        Libro nuovoLibro = mapper.toModel(r);
        Libro libroCreato = repository.save(nuovoLibro);

        return mapper.toResponse(libroCreato);

    }

    public LibroResponse trovaPerId(Long id) {

        return repository.findById(id)

                .map(mapper::toResponse)
                .orElseThrow(() -> new LibroNonTrovatoException(id));
    }


    public List<LibroResponse> trovaTutti() {

        return mapper.toResponseList(repository.findAll());

    }


    public List<LibroResponse> trovaPerCategoria(CategoriaLibro cl)	{

        return mapper.toResponseList(repository.findByCategoria(cl));

    }


    public List<LibroResponse> trovaLibriCostosi(double c){


        return repository.findAll().stream()

                .filter(l -> l.isCostoso(c))
                .map(mapper::toResponse)
                .toList();

    }


    public void rimuoviPerId(Long id) {

        if(repository.existsById(id)) {

            repository.deleteById(id);
        }

        throw new LibroNonTrovatoException(id);


    }





}
