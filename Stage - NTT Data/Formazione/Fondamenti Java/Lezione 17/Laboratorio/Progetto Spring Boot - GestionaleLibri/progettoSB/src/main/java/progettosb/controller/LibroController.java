package progettosb.controller;

import org.springframework.web.bind.annotation.*;

import progettosb.dto.LibroRequest;
import progettosb.dto.LibroResponse;
import progettosb.service.LibroService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }


    @GetMapping("/restituisci")
    public List<LibroResponse> restituisci() {

        return service.trovaTutti();
    }


    @GetMapping("/trovaperId/{id}")
    public LibroResponse trovaId(@PathVariable Long id) {

        return service.trovaPerId(id);
    }


    @PostMapping("/creaLibro")
    public LibroResponse creaLibro(@RequestBody LibroRequest request) {

        return service.creaLibro(request);
    }


    @DeleteMapping("/eliminaperId/{id}")
    public void eliminaLibro(@PathVariable Long id) {

        service.rimuoviPerId(id);
    }




}
