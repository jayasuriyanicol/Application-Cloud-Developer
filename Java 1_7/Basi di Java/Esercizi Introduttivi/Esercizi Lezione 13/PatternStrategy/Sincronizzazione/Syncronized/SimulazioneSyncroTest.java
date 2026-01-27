package multithread.cassetto.soluzione;

/*  
    * SimulazioneSyncro - Syncronized Main class
    ? SimulazioneSyncro class, test Main with Syncronize:

    ! main(String[] arg): Instantiates a shared Cassetto object, initializes two Figlio and two Genitore threads using that shared resource, and triggers their concurrent execution by calling start() on each instance.
*/
public class Simulazione{
	
	public static void main(String[] arg)
	{
		Cassetto box = new Cassetto();

		Figlio f1 = new Figlio(box,12,"Guido");
		Figlio f2 = new Figlio(box,12,"Grazia");
		Genitore mum = new Genitore(box,12,1,"madre");
		Genitore dad = new Genitore(box,12,1,"padre");
	
		mum.start();
		dad.start();
		f1.start();
		f2.start();
			
	}		
}