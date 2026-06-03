package progettosb.dto;

import java.time.LocalDate;

public record LibroResponse(Long id, String titolo, String autore, String categoria, int pagine, double prezzo, LocalDate dataInserimento) {}