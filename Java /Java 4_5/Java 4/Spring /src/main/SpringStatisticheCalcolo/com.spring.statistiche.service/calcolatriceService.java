package com.spring.statistiche.service;

import org.springframework.stereotype.Service;


/* * calcolatriceService - Core Arithmetic Business Logic
    ? Encapsulates the fundamental mathematical operations used by the application. It serves as the pure business layer, free from HTTP concerns, and acts as the primary target for the AOP statistical interceptor.

    ! 1. Input Validation, enforces specific constraints directly within the business logic: 'sottrazione' strictly requires positive inputs (throwing an Error), and 'divisione' explicitly guards against division by zero (ArithmeticException) to prevent runtime crashes.
    ! 2. AOP Target, these methods serve as the "Join Points" for the 'AspectStatistiche'. Because the logic here is pure, the Aspect can cleanly wrap around these executions to record statistics without modifying the calculation code itself.
*/

@Service
public class calcolatriceService {

	public double somma(double a, double b) {
		
		double somma = 0;
		
		somma = a + b;
		
		return somma;
	}
	
	public double sottrazione(double a, double b) {
			
			double sottrazione = 0;
			
			if(a <0 || b<0) {
				
				throw new Error("ATTENZIONE ! I numeri devono essere positivi >= 0");
			}
			
			sottrazione = a - b;
			
			
			return sottrazione;
			
		

	}

		
		
		public double moltiplicazione(double a, double b) {
			
			double moltiplicazione = 0;
			
			moltiplicazione = a * b;
			
			return moltiplicazione;
		
		}
		
		
		public double divisione(double numeratore, double divisore) {
			
			
			if(divisore == 0) 
				throw new ArithmeticException("ATTENZIONE ! Errore divisione per zero : ZeroDivisionError");
			double divisione = 0;
			
			divisione = numeratore / divisore;
			
			return divisione;
		}
		
		
	}

	
	
	


