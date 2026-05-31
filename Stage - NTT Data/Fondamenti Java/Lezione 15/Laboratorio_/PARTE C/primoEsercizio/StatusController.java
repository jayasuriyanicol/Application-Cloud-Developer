package it.corso.bootcamp.controller;

import it.corso.bootcamp.service.StatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusService statusService;

  
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public String status() {
        return statusService.getStatus();
    }

    @GetMapping("/versione")
    public String versione() {
        return statusService.getVersione();
    }

    @GetMapping("/autore")
    public String autore() {
        return statusService.getAutore();
    }
}
