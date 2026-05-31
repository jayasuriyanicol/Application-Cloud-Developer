package multithread.cassetto.soluzione;

/*  
    * CassettoSyncro - Syncronized class
    ? CassettoSyncro class, test with Syncronize:

    ! Cassetto(): Initializes the paghetta to 0 and sets the availability flag disponibile to false.
	! ottieniPaghetta(): A synchronized method that waits in a loop (releasing the lock via wait()) while the drawer is empty; once available, it retrieves the value, resets the drawer to empty, notifies all waiting threads using notifyAll(), and returns the amount.
	! caricaPaghetta(int v): A synchronized method that waits in a loop (using wait()) if the drawer is already full; once empty, it updates paghetta with the new value, marks it as available, and wakes up all waiting threads using notifyAll().
*/

public class Cassetto{

	private int paghetta;
	private boolean disponibile; 
	
	public Cassetto()
	{
		paghetta=0;
		disponibile=false;
		
	}	
	
	public synchronized int ottieniPaghetta()
	{
		while(!disponibile)
		{
			try
			{
				System.out.println("cassetto bloccato, "+Thread.currentThread().getName()
						+" ha tentato di aprire \n"+Thread.currentThread().getName()
						+" deve aspettare!!!!!");
				this.wait();	 //Rilascio del lock sull'oggetto this (cioè il cassetto)			
			}catch(InterruptedException e){}
		}

		//Prelevamento paghetta
		
		int val= paghetta;
		paghetta=0;
		disponibile = false;
		System.out.println("cassetto sbloccato da "+Thread.currentThread().getName());
		//Notifica per tutti gli altri thread in attesa sul cassetto
		this.notifyAll();
		return val;
	}
	
	public synchronized void caricaPaghetta(int v)
	{
		
		while(disponibile)
		{
			try 
			{
				System.out.println("cassetto bloccato,la paghetta deve essere ancora ritirata \n"+Thread.currentThread().getName()+" deve aspettare!!!!!");
				this.wait();				
			}catch(InterruptedException e){}
		}
		//Caricamento paghetta
		paghetta=v;
		disponibile = true;
		
		//Notifica per tutti gli altri thread
		this.notifyAll();	
		System.out.println("cassetto sbloccato da "+Thread.currentThread().getName());	
	}

}