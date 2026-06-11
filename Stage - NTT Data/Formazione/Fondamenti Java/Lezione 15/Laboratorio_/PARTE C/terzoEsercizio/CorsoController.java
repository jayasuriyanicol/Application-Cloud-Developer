package it.corso.bootcamp.controller;

import it.corso.bootcamp.dto.CorsoResponseDTO;
import it.corso.bootcamp.service.CorsoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/corsi")
public class CorsoController {

    private final CorsoService corsoService;

    public CorsoController(CorsoService corsoService) {
        this.corsoService = corsoService;
    }

    @GetMapping
    public List<CorsoResponseDTO> getAll() {
        return corsoService.getAllCorsi();
    }

    @GetMapping("/java")
    public CorsoResponseDTO getJava() {
        return corsoService.getCorsoJava();
    }

    @GetMapping("/spring")
    public CorsoResponseDTO getSpring() {
        return corsoService.getCorsoSpring();
    }
}
