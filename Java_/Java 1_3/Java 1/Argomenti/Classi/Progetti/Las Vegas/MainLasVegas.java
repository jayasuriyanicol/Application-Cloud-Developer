package eserciziLezione5;

public class TestLasVegas {

	public static void main(String[] args) {
		
		
		Casino casino = new Casino("Monte Carlo", 1000000.23);
		Dado dado;
		Giocatore1 giocatore1 = new Giocatore1("Giacomo", 500.00);
		Giocatore1 giocatore2 = new Giocatore1("Nicol", 1000.00);
		
		giocatore1.punta(100, 7);
		giocatore2.punta(213, 28);
		
		System.out.println("\nNome CASINÒ:\n" + casino);
		System.out.printf("\nRIEPILOGO GIOCATORI:\n\nPRIMO giocatore: " + giocatore1);
		System.out.println("\n\nSECONDO giocatore: " + giocatore2);
		
		
		int [] soldi = { (int)giocatore1.getPuntata(), (int)giocatore2.getPuntata()};	
		
		boolean esito = casino.valutaPuntate(soldi);
		
		if (esito) {
			
			System.out.println("\nSUCCESSO ! Il CASINÒ ha accettato le puntate ! ");
			
			int numero = Dado.estrai();
			
			System.out.println("\nIl numero ESTRATTO È -> " + numero);
			
			
			if(giocatore1.getNumeroGiocato() == numero) {
				
				casino.paga((int)giocatore1.getPuntata());
				giocatore1.incassa();
				
				System.out.println("\n\nVITTORIA ! " + giocatore1.getNome() + " hai VINTO !");
	
			} else {
				
				System.out.println("\n\nSCONFITTA ! " + giocatore1.getNome() + " hai PERSO !\n\nIl numero da te puntato è : " + giocatore1.getNumeroGiocato() + " , mentre il numero che è uscito fuori è : " + numero );
			}
			
			
			
			
			if(giocatore2.getNumeroGiocato() == numero) {
				
				casino.paga((int)giocatore2.getPuntata());
				giocatore2.incassa();
				
				System.out.println("\n\nVITTORIA ! " + giocatore2.getNome() + " hai VINTO !");
	
			} else {
				
				System.out.println("\n\nSCONFITTA ! " + giocatore2.getNome() + " hai PERSO !\n\nIl numero da te puntato è : " + giocatore2.getNumeroGiocato() + " , mentre il numero che è uscito fuori è : " + numero );
			}
			
		} 
		
		else {
			
			System.out.println("\nERRORE ! Il CASINÒ non può accettare le tue puntate, FALLIREBBE :-( ! ");
		}
	
		
		
		
		
		 
	}

}

