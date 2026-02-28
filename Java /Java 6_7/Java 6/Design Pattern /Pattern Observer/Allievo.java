package PatternObserver;

import java.util.Random;

/* * Allievo - Concurrent Observer Implementation
    ? A sophisticated class that represents a "Student" acting both as an Observer and a Runnable task. It simulates an asynchronous activity (answering questions) while remaining reactive to external signals (notifications from a Teacher or Subject) to stop its execution.

    ! 1. Asynchronous Simulation Loop, implements the 'run()' method to simulate continuous student activity. By using 'Thread.sleep' with a random interval and a probabilistic check (rand.nextInt < 50), the class models realistic, unpredictable behavior where the 'numeroRisposte' increment occurs independently of other threads.
    ! 2. Thread-Safe Termination Logic, utilizes a 'volatile boolean' for 'statoAllievo'. This ensures that changes to the student's state made by the 'update()' method (triggered by the Subject) are immediately visible to the running thread, allowing for a graceful and safe exit from the processing loop.
    ! 3. Observer Pattern Callback, implements the 'update()' method to handle notifications. Upon being notified, the student immediately stops their internal activity and reports their final statistics, demonstrating the pattern's ability to decouple the "stop" signal from the "work" logic without tight coupling between classes.
*/


//Comune CLASS COMPONENT 'Allievo' 
public class Allievo implements Observer, Runnable {
	
	
    private String nome;
    private Integer numeroRisposte = 0;
    private volatile boolean statoAllievo = true;

    public Allievo(String nome) {
    	
        this.nome = nome;
       
    }
    
    
	@Override
	public void run() {
		
		Random rand = new Random();
		while(statoAllievo) {
			
			try { 
				Thread.sleep(rand.nextLong(20,100));
				if(rand.nextInt(0,100)<50)
					numeroRisposte++;
				

			} catch(InterruptedException e) {
				
				e.printStackTrace();
				break;
			}
		}
		
	}


	@Override
	public void update() {
		Thread.interrupted();
		this.statoAllievo = false;
		System.out.println("L'allievo " + nome + " ha risposto ad " + numeroRisposte + " domande !");
		
	}

}