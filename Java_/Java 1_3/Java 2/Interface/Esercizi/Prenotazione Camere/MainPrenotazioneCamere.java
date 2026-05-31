/*
The implementation must comply with the following usage example 
Rooms and Reservations Usage Example
Room r = new Room(103); 
Reservation p1 = r.reserve("mario rossi", 105, 120); 
Reservation p2 = r.reserve("anna bianchi", 5, 20); 
Reservation p3 = r.reserve("piero neri", 20, 22); 
Reservation p4 = r.reserve("gianna gialli", 200, 222); 
for (Reservation p: r.reservations())
System.out.println(p.getName()); 
Also run the test with the call:
Reservation p5 = r.reserve("tony blu", 21, 23); 
Which should fail because the room is occupied.

*/


package eserciziLezione8;
public class MainPrenotazioneCamere {

	public static void main(String[] args) {
		
		Room r = new Room(104);
		
		
		
		try {
			 System.out.println("\n\nPRENOTAZIONI:");
			 
			 Reservation r1 = r.reserve("David Divano", 105, 120);
			 System.out.println("\nGrazie, " + r1.getNome() + " per la tua PRENOTAZIONE !");
			 
			 /*
			 //In this, case we have the condition of OperazioneAusiliaria, commented to avoid the error.
			 Reservation r2 = r.reserve("Cris Atta", 106, 20);
			 System.out.println("\nGrazie, " + r2.getNome() + " per la tua PRENOTAZIONE !");
			 */
			 
			 Reservation r3 = r.reserve("Giacomo Coccodrillini", 21, 22);
			 System.out.println("\nGrazie, " + r3.getNome() + " per la tua PRENOTAZIONE !");
			 
			 Reservation r4 = r.reserve("Francesco Trotterellini", 200, 222);
			 System.out.println("\nGrazie, " + r4.getNome() + " per la tua PRENOTAZIONE !");
			
		
		}
		
		catch(OperazioneAusiliaria e) {
			
			System.out.println("ERRORE ! durante l'inserimento. CODICE ERRORE: " + e.getMessage());
			
			
		}

		
		System.out.println("\n\nLISTA PRENOTAZIONI: ");
		
		for(Reservation rp : r.reservations() ) {
			
			System.out.println("->  " + rp.getNome());
			
		}
		
		
		//Testing the Sovrapposta, same period in the same room for the reservartion, it will generate the error in the catch
		System.out.println("\n\nPRENOTAZIONE SOVRAPPOSTA: ");
		
		
			try {
				Reservation r5 = r.reserve("Dockerina Hackerina", 21, 23);
				 System.out.println("\nGrazie, " + r5.getNome() + " per la tua PRENOTAZIONE !");
			} 
			
			catch (OperazioneAusiliaria e) {
				
				System.out.println("\nPRENOTAZIONE SOVRAPPOSTA. Codice Errore: " + e.getMessage());
			}
		
		
		
		
	

	}

}
