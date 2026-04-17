package PatternObserver;

import java.util.Scanner;


/* * TestAllievo - System Orchestrator & Simulation Entry Point
    ? This class acts as the "Bootstrap" for the multithreaded Observer simulation. It coordinates the lifecycle of the Subject (TimerDomande) and multiple Observers (Allievi), demonstrating how independent threads can be synchronized through a centralized notification system.

    ! 1. Temporal Conversion Logic, transforms user-friendly "seconds" into system-level "milliseconds". By multiplying the 'Scanner' input by 1000, it bridges the gap between human perception and the 'Thread.sleep()' requirement, ensuring the simulation duration is precisely controlled.
    ! 2. Pattern Subscription Registry, performs the manual "Wiring" of the architecture. By calling 'timer.aggiungiObserver()', it establishes the relational links required for the 'TimerDomande' to know exactly which 'Allievo' instances must be notified when the countdown reaches zero.
    ! 3. Concurrent Thread Ignition, launches multiple parallel execution paths using 'new Thread().start()'. This demonstrates the power of the Runnable interface, where the timer and the three students run simultaneously in the background, only re-converging when the Timer's 'update()' signal forces a synchronized termination.
*/

public class TestAllievo {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//To test insert under 5 not more, you will have to wait too long
		System.out.println("Benvenuto, inserire la durata in SECONDI voluta del TIMER : ");
		Scanner sc = new Scanner(System.in);
		Integer secondi = sc.nextInt();
		
		//Here why -> 8*1000 equals to 8000 seconds convert to hours are 2.5 !
		TimerDomande timer = new TimerDomande(secondi * 1000);
		
		Allievo al1 = new Allievo("Paolo Fiumi");
		Allievo al2 = new Allievo("Francesco Belli");
		Allievo al3 = new Allievo("Sara Granieri");
		
		timer.aggiungiObserver(al1);
		timer.aggiungiObserver(al2);
		timer.aggiungiObserver(al3);
		
		new Thread(al1).start();
		new Thread(al2).start();
		new Thread(al3).start();
		
		new Thread(timer).start();
	}

}
