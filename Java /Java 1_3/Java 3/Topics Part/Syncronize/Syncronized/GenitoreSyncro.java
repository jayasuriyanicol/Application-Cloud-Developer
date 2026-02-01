package multithread.cassetto.soluzione;

/*  
    * GenitoreSyncro - Syncronized class
    ? GenitoreSyncro class, test with Syncronize:

    ! Genitore(Cassetto cassetto, int mesi, int numFigli, String nome): Initializes the thread via super with the given name, assigns the shared Cassetto instance, and sets the duration parameters mesi and numFigli.
	! run(): Executes a loop for mesi * numFigli iterations where it generates a random allowance amount, loads it into cassetto via caricaPaghetta(), prints the action, pauses execution for a random duration up to 2000ms (handling interruptions), and prints a final message indicating the activity has ended.
	
*/

public class Genitore extends Thread{
	
	private Cassetto cassetto;
	private int mesi;
	private int numFigli;
	
	public Genitore(Cassetto cassetto,int mesi,int numFigli, String nome){
		super(nome);
		this.cassetto=cassetto;
		this.mesi = mesi;
		this.numFigli = numFigli;
	}		
	
	public void run()
	{
		for(int i=0;i<mesi*numFigli;i++)
		{
			int paghetta=(int)(10*Math.random()+1);
			cassetto.caricaPaghetta(paghetta);
			System.out.println(Thread.currentThread().getName() +" ha inserito: "+paghetta);
			
			try
			{
				Thread.sleep((long)(2000*Math.random()));
			}	
			catch(InterruptedException e)
			{	
				System.out.println("Errore "+e.getMessage());		
			}
		}
		System.out.println("fine attivita' del genitore:"+Thread.currentThread().getName());
	}	
}