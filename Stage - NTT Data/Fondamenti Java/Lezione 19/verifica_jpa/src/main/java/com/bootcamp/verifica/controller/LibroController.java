package com.bootcamp.verifica.controller;

import com.bootcamp.verifica.dto.LibroRequest;
import com.bootcamp.verifica.dto.LibroResponse;
import com.bootcamp.verifica.model.CategoriaLibro;
import com.bootcamp.verifica.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/libri")
public class LibroController {


    private final LibroService service;

    public LibroController(LibroService service){

        this.service = service;
    }


    @PostMapping
    public ResponseEntity<LibroResponse> creaLibro(@RequestBody LibroRequest lr){

        LibroResponse r = service.creaLibro(lr);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }


    @GetMapping("/trovaTutti")
    public ResponseEntity<List<LibroResponse>> trovaTutti(){

        List<LibroResponse> ll = service.trovaTutti();

        // Or simply 'ResponseEntity.ok(ll)'
        return new ResponseEntity<>(ll, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LibroResponse> trovaPerId(@PathVariable Long id){

            LibroResponse r = service.trovaPerId(id);
            return new ResponseEntity<>(r, HttpStatus.OK);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaLibro(@PathVariable Long id) {

      service.eliminaLibro(id);

      // In this case, we do not need the ResponseEntity because 'NO_CONTENT'
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/trovaPerCategoria/{c}")
    public ResponseEntity<List<LibroResponse>> trovaPerCategoria(@PathVariable CategoriaLibro c) {

        List<LibroResponse> l = service.trovaPerCategoria(c);
          return new ResponseEntity<>(l,HttpStatus.OK);
    }


    @PutMapping("/aggiornaLibro/{id}")
    public ResponseEntity<LibroResponse> aggiornaLibro(@PathVariable Long id, @RequestBody LibroRequest r) {

        LibroResponse re = service.aggiornaLibro(id, r);

        // Here we can manage with two cases or return a HttpStatus -> GONE or a more correct OK
        return new ResponseEntity<>(re,HttpStatus.OK);
    }



}
