package Lezione_07;


public class ConfigurazioneValidator {
	
  public static void validazioneContenuto(ConfigurazioneApp config) throws ConfigurazioneNonValidaException{
	
	  

	 
	  if(config.nomeApplicazione() ==  null || config.nomeApplicazione().isBlank()) {
		  
		  throw new ConfigurazioneNonValidaException("ATTENZIONE ! il campo del nome dell'applicazione non risulta inserito o vuoto !");
		  
	  }
	  
	  if(config.versione() == null  || config.versione().isBlank() ) {
		  
		  throw new ConfigurazioneNonValidaException("ATTENZIONE ! il campo della versione dell'applicazione non risulta inserito o vuoto !");
		  
		  
	  }
	  
	  
	  String ambiente = config.ambiente();
	  if(ambiente == null || (!ambiente.equals("DEV") && !ambiente.equals("TEST") &&!ambiente.equals("PROD"))) {
		  
		  throw new ConfigurazioneNonValidaException("ATTENZIONE ! il campo dell'ambiente dell'applicazione non risulta idoneo a quelli ammessi: (PROD,DEV o TEST) oppure risulta vuoto !") ;
		  
		  
	  }
	  
	  Integer porta = Integer.parseInt(config.porta());
	  
	  if(porta == null || porta < 1 || porta > 65555) {
		  
		  
		  throw new ConfigurazioneNonValidaException("ATTENZIONE ! il campo della porta dell'applicazione non risulta idoneo deve essere compreso fra 1 e 65555 !");
	  }
	 

		 
		 
	 }
	  
}

