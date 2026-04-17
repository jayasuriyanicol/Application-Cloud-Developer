package PatternObserver;

import java.util.ArrayList;
import java.util.List;


/* * TimerDomande - Threaded Subject & Time Coordinator
    ? This class acts as the 'Subject' in the Observer pattern, doubling as a 'Runnable' task that manages the duration of an event. It holds the authoritative list of observers and is responsible for broadcasting the termination signal once a specific time threshold is reached.

    ! 1. Encapsulated Observer Registry, maintains a private 'List<Observer>' to manage subscribers. Through the 'aggiungiObserver' and 'rimuoviObserver' methods, the class provides a dynamic way to attach or detach students (Allievi) at runtime, ensuring that only active participants receive the final notification.
    ! 2. Temporal Execution Logic, implements the 'run()' method to represent a countdown or duration. By utilizing 'Thread.sleep(tempoTotale)', the class pauses its own execution for the specified period, effectively acting as a master clock that dictates when the asynchronous activity of all observers must cease.
    ! 3. Synchronized Broadcast Mechanism, triggers the 'stopTempo()' method upon completion of the sleep cycle. This method iterates through the registry and invokes 'ob.update()', demonstrating the classic "push" notification style where the subject forces a state change across all registered listeners simultaneously.
*/


public class TimerDomande implements Runnable {
	
	private List<Observer> listaStudenti = new ArrayList<>();
	private Integer tempoTotale;
	
	public TimerDomande(Integer tempoTotale) {
		
		if(tempoTotale < 0) {
			
			throw new RuntimeException();
			
		}
		else {
			
			this.tempoTotale = tempoTotale;
		}
		
	}
	
	
	public void stopTempo() {
		
		for(Observer ob : listaStudenti)
		
			ob.update();
	}
	
	@Override
	public void run() {
		
		try {
			
			Thread.sleep(tempoTotale);
			
		}catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		stopTempo();
		
	}
	
	public void aggiungiObserver(Observer ob) {
		
		listaStudenti.add(ob);
	}
	
	public void rimuoviObserver(Observer ob) {
		
		listaStudenti.remove(ob);
	}
	
	

}
