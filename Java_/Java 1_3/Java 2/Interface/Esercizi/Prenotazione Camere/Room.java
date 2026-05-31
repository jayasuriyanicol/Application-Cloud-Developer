/*Rooms and Reservations Description
 Create the Room and Reservation classes, which represent a hotel room
and a reservation for the room.
 A room has a number from 100 to 599.
Room's reservations method returns a list of reservations,
possibly sorted by check-in date.
*/

package eserciziLezione8;
import java.util.ArrayList;
import java.util.Collections;

public class Room {
	
	private int camera = (int)(Math.random() * 600);
	private ArrayList<Reservation> listaPrenotazione = new ArrayList<>();
	
	
	public Room(int camera) {
		
		
		if (camera < 100 || camera > 599 ) {
			
			throw new Error("ATTENZIONE ! La camera deve essere compresa fra 100 e 599 inclusi");
		}
		
		else {
			
			this.camera = camera;
		
		}

	}
	
	
	
	public int getCamera() {
		
		return camera;
	}
	
	
	
	public ArrayList <Reservation> reservations() {
		
	    ArrayList<Reservation> pr = new ArrayList<>(listaPrenotazione);
	    
	    
	    
	   Collections.sort(pr);
	   return pr;
		
	}
	
	
	public Reservation reserve (String nome, int dataInizio, int dataFine) throws OperazioneAusiliaria{
		
		Reservation pr1 = new Reservation(nome,dataInizio, dataFine);
		
		
		for (Reservation r : listaPrenotazione) {
			
			if(dataInizio < r.getDataFine() && dataFine > r.getDataInizio()) {
				
				throw new OperazioneAusiliaria("ATTENZIONE ! La stanza risulta già occupata !");
			}
			
			
			}

		listaPrenotazione.add(pr1);
		return pr1;
		
	}

}
