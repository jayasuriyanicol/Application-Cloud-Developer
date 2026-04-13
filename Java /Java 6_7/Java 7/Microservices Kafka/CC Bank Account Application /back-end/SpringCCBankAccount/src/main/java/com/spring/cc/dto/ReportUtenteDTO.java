package com.spring.cc.dto;

// * Creating a record to return a report information about the Utente data at controller time
public record ReportUtenteDTO(Integer idUtente, String nome, String cognome, String citta, String provincia, Double saldoComplessivo) {}
