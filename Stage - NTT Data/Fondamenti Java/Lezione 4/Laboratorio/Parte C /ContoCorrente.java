package Lezione_04;

public class ContoCorrente {
	
	
	private String intestatario;
	private Double saldo;
	
	public ContoCorrente() {}

	public ContoCorrente(String intestatario, Double saldo ){
		
		this.intestatario = intestatario;
		this.saldo = saldo;
		
	}
	
	public Double deposita(double importo) {
		
	    if(importo > 0) {
	    	
	       saldo += importo;
	    	
	    } else {
	    	
	      System.out.println("ATTENZIONE ! L'importo deve essere maggiore di 0");
	    }
		
	    return importo;
	}
	
	
	public Double preleva(double importo) {
		
	    if(importo > 0 && importo <= saldo) {
	    	
		       saldo -= importo;
		    	
		    } else {
		    	
		      System.out.println("ATTENZIONE ! L'importo deve essere maggiore di 0 e non superiore al saldo disponibile -> " + saldo);
		    }
			
		    return importo;
		
	}
	
	public Double getSaldo() {
		return saldo;
		
	}
	
	
	
	
	}


