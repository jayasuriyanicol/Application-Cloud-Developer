package multithread.cassetto.starter;


/*  
    * Simulazione - Normal Main class
    ? Simulazione Main class, example for the test  Main with Syncronize:

	! main(String[] arg): Instantiates a shared Cassetto object, creates two Figlio threads and two Genitore threads sharing that resource, and begins their concurrent execution by calling start() on each.

*/

public class Simulazione{
	
	public static void main(String[] arg)
	{
		Cassetto box = new Cassetto();
		
		Figlio f = new Figlio(box,12,"Guido");
		Figlio f2 = new Figlio(box,12,"Grazia");
		Genitore m = new Genitore(box,12,"madre",1);
		Genitore p = new Genitore(box,12,"padre",1);

		m.start();
		f.start();
		f2.start();
		p.start();
	}		
}