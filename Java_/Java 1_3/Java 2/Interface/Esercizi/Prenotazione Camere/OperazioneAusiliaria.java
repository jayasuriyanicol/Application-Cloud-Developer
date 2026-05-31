/*

OPERAZIONE AUSILIARIA:
 
 A custom exception thrown when a room reservation cannot be completed. This typically occurs
 when the requested dates overlap with an existing reservation, meaning the room is already
 occupied for the specified period.
 
*/

package eserciziLezione8;

//Added to supperss the "error" on 'OperazioneAusiliaria'
@SuppressWarnings("serial")
public class OperazioneAusiliaria extends Exception{
	
	public OperazioneAusiliaria() {
		
		super();
	}
	
	
	public OperazioneAusiliaria(String motivazione) {
		
		super(motivazione);
	}
	
	
	
	

}
