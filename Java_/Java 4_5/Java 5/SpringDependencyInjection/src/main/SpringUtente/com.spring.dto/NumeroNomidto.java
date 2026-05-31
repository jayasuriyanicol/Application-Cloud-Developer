package com.spring.dto;

import java.util.List;

public class NumeroNomiUtentiDTO {
	
	
	private List<String> nomi;
	private int numeroNomi;
	
	
	public NumeroNomiUtentiDTO(int numeroNomi) {
		
		this.numeroNomi = numeroNomi;
		
	}


	public List<String> getNomi() {
		return nomi;
	}


	public void setNomi(List<String> nomi) {
		this.nomi = nomi;
	}


	public int getNumeroNomi() {
		return numeroNomi;
	}


	public void setNumeroNomi(int numeroNomi) {
		this.numeroNomi = numeroNomi;
	}
	
	
	

}
