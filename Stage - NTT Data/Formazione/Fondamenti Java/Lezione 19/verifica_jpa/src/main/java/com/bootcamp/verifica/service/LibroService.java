package com.bootcamp.verifica.service;

import com.bootcamp.verifica.dto.LibroRequest;
import com.bootcamp.verifica.dto.LibroResponse;
import com.bootcamp.verifica.exception.IdNonEsistenteException;
import com.bootcamp.verifica.exception.TitoloVuotoException;
import com.bootcamp.verifica.mapper.LibroMapper;
import com.bootcamp.verifica.model.CategoriaLibro;
import com.bootcamp.verifica.model.Libro;
import com.bootcamp.verifica.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class LibroService {

    private final LibroRepository repo;
    private final LibroMapper mapper;


    public LibroService(LibroRepository repo, LibroMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }


    public LibroResponse creaLibro(LibroRequest r){

        // If the ID is DB-generated, it MUST be null, or at least a positive number if validated
        if (r.getId() == null || r.getId() <= 0) {
            throw new IdNonValidoException("ATTENZIONE! L'ID del Libro deve essere coerente e non può essere inserito manualmente !");
        }


        if(r.getTitolo() == null || r.getTitolo().trim().isEmpty()){

            throw new TitoloVuotoException("ATTENZIONE! il titolo risulta mancante !");
        }

        if(r.getAutore() == null || r.getAutore().trim().isEmpty()){

            throw new AutoreNonEsistenteException("ATTENZIONE! l'autore risulta mancante !");
        }
        if(r.getPrezzo() < 0.00){

            throw new PrezzoNonIdoneoException("ATTENZIONE! il prezzo deve essere positivo !");
        }

        if(r.getCategoria() == null || r.getCategoria().trim().isEmpty()){

            throw new CategoriaNonIdoneaException("ATTENZIONE! la categoria risulta mancante o non è idonea quelle registrate !");
        }
-

        Libro l = new Libro(

                r.getTitolo(),
                r.getAutore(),
                r.getCategoria(),
                r.getPrezzo()
        );


        Libro lNuovo = repo.save(l);

        return mapper.toResponse(lNuovo);
    }


    public List<LibroResponse> trovaTutti(){

        return repo.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }


    public LibroResponse trovaPerId(Long id){

        Libro l = repo.findById(id)
                .orElseThrow(() -> new IdNonEsistenteException("ATTENZIONE! l'ID inserito non risulta nel sistema !"));
        return mapper.toResponse(l);
    }



    public void eliminaLibro(Long id) {

        if (!repo.existsById(id)) {
            throw new IdNonEsistenteException("ATTENZIONE! Impossibile eliminare, l'ID inserito non esiste: " + id);
        }

        repo.deleteById(id);
    }


    public List<LibroResponse> trovaPerCategoria(CategoriaLibro categoria) {

        return repo.findByCategoria(categoria).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }


    public LibroResponse aggiornaLibro(Long id, LibroRequest r) {

        if (r.getTitolo() == null || r.getTitolo().trim().isEmpty()) {

            throw new TitoloVuotoException("ATTENZIONE! Impossibile aggiornare, il titolo non può essere vuoto !");
        }

        Libro le = repo.findById(id)
                .orElseThrow(() -> new IdNonEsistenteException("ATTENZIONE! Impossibile aggiornare, l'ID inserito non esiste: " + id));


        mapper.toUpdate(r, le);
        Libro la = repo.save(le);

        return mapper.toResponse(la);
    }
}




