package multithread.cassetto.starter;

/*  
    * Figlio - Normal class
    ? Figlio class, example for the test with Syncronize:

	! Figlio(Cassetto cassetto, int mesi, String nome): Initializes the thread by setting its name via super, assigns the shared Cassetto instance, and defines the number of iterations (mesi).
	! run(): Executes a loop for mesi iterations where it prints the current thread's name and the amount retrieved from cassetto.ottieniPaghetta(), then pauses execution for a random duration up to 1000ms (handling any InterruptedException).

*/

public class Figlio extends Thread{
		
	private Cassetto cassetto;
	private int mesi;
	
	public Figlio(Cassetto cassetto,int mesi,String nome){
		super(nome);
		this.cassetto=cassetto;
		this.mesi = mesi;
	}	
	
	public void run()
	{
		for(int i=0;i<mesi;i++)
		{
			System.out.println(Thread.currentThread().getName() 
					+" ha preso : "+cassetto.ottieniPaghetta()+" dal cassetto");
			try
			{
				Thread.sleep((long)(1000*Math.random()));
			}	
			catch(InterruptedException e)
			{	
				System.out.println("Errore "+e.getMessage());	
			}	
		}
	}	
}