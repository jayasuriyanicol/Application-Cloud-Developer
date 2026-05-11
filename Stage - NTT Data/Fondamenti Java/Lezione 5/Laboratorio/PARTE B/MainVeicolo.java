package Lezione_05;

public class MainVeicolo {

	public static void main(String[] args) {
	
     Veicolo[] veicoli = {
    		 
    		new Auto(),
    		new Moto()
     };
     
     for(Veicolo v : veicoli) {
    	 
    	 System.out.println( v.muoviti());
     }
	
	}

}
