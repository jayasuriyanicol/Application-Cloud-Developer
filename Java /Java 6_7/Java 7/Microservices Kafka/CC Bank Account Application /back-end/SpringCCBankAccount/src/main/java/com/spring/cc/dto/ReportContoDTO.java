package com.spring.cc.dto;

// * Creating a record to return a report information about the CC data at controller time
public record ReportContoDTO(Integer numeroConto, Double saldo, String nomeIntestatario, String cognomeIntestatario, int numeroMovimenti) {}