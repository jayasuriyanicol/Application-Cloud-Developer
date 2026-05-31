package eserciziLezione13;

public class MainVoli {

	public static void main(String[] args) {
		
		Assegnatore assegnatore = new Assegnatore();
		
		System.out.println("\nPRENOTAZIONE BIGLIETTI\n\nI posti DISPONIBILI in totale sono: " + assegnatore.getTotalePosti() + " posti");
		
		
		ThreadClienti c1 = new ThreadClienti("Dario Manganellini", 4, assegnatore);
		ThreadClienti c2 = new ThreadClienti("Simone Dragoncelli",5, assegnatore);
		
		//Nel caso volessimo testare la non presenza di posti possiamo fare -> ThreadClienti c5 = new ThreadClienti("Dockerina Hackerina",16, assegnatore);
		
		ThreadClienti c3 = new ThreadClienti("David Divano", 9, assegnatore);
		ThreadClienti c4 = new ThreadClienti("Ludovico Cagnolini", 2, assegnatore);
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		//c5.start(); -> Per testare l'errore.
		
	}

}
