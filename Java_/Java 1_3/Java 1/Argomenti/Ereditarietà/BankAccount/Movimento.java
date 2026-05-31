/*
 CLASSE Movimento 
 
 Un movimento contiene il tipo di operazione,  la data e l’importo relativo all’operazione
 L’importo è sempre positivo

 I movimenti non prevedono la modifica dei dati (né tipo, né data, né ammontare)
 I movimenti prevedono la stampa
 
 */


package eserciziLezione7;

import java.util.Date;
public class Movimento {
	
	
	

	
	private final Date dataOperazione;
	private final double importo;
	public tipologiaOperazione tipo;
	
   
        public enum tipologiaOperazione {
		
		PRELIEVO("Operazione di PRELIEVO"),
		VERSAMENTO("Operazione di VERSAMENTO ");
    	
    	 
        private String operazione;
        	
        	
        private tipologiaOperazione(String operazione) {
        	
        	this.operazione = operazione;
        
        }
        
        
        public String getOperazione() {
        	
        	return operazione;
        }
        

	}

	public Movimento (tipologiaOperazione tipo,Date dataOperazione, double importo) {
		
		this.tipo = tipo;
		this.dataOperazione = dataOperazione;
		this.importo = importo;
		
		
	}
	
	

	public double getImporto() {
		
		if (importo >=0 ) {
			
			return importo;
		}
		else {
			
		
				System.out.println("ATTENZIONE ! l'importo non è dispensabile o non si può procedere con l'operazione !");
				return 0;
		}		
	}
	
	
	
	public Date getDataOperazione() {
		
		return dataOperazione;


	}
	
	
	
	
	public tipologiaOperazione getTipologiaOperazione() {
		
		return tipo;
	}
   
	
	



	
	
	

	

	
	
	

	
	
	
	

}
