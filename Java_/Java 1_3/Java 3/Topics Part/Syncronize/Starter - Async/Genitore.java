package multithread.cassetto.starter;


/*  
    * Genitore - Normal class
    ? Genitore class, example for the test with Syncronize:

	! Genitore(Cassetto cassetto, int mesi, String nome, int numFigli): Initializes the thread via super with the given name and assigns the shared Cassetto instance, the duration in mesi, and the total number of children numFigli.
	! run(): Executes a loop for mesi * numFigli iterations where it generates a random allowance amount, loads it into cassetto via caricaPaghetta(), prints the action, and pauses execution for a random duration up to 1000ms (catching generic exceptions).

*/
public class Genitore extends Thread{
	
	private Cassetto cassetto;
	private int mesi;
	private int numFigli;
	
	public Genitore(Cassetto cassetto,int mesi,String nome,int numFigli){
		super(nome);
		this.cassetto=cassetto;
		this.mesi = mesi;
		this.numFigli = numFigli;
	}		
	
	public void run()
	{
		for(int i=0;i<this.mesi * this.numFigli;i++)
		{
			int paghetta=(int)(10*Math.random()+1);
			cassetto.caricaPaghetta(paghetta);
			System.out.println(Thread.currentThread().getName() +" ha inserito: "+paghetta);
			try
			{
				Thread.sleep((long)(1000*Math.random()));
			}	
			catch(Exception e)
			{	
				System.out.println("Errore "+e.getMessage());		
			}	
		}
	}	
}