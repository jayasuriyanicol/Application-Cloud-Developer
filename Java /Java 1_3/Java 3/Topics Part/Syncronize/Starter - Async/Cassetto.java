package multithread.cassetto.starter;

/*  
    * Cassetto - Normal class
    ? Cassetto class, example for the test with Syncronize:

    ! Cassetto(): Constructor that initializes paghetta to 0 and sets disponibilita to false.
	! ottieniPaghetta(): Stores the current paghetta in a temporary variable, resets paghetta
	! caricaPaghetta(int valore): Updates paghetta with the given valore and sets disponibilita to true

*/

public class Cassetto{

	private int paghetta;
	private boolean disponibilita;
		
	public Cassetto()
	{
		paghetta=0;
		disponibilita = false;
		
	}	
	
	public int ottieniPaghetta()
	{
		int valore= paghetta;
		this.paghetta=0;
		disponibilita = false;
		return valore;
	}
	
	public void caricaPaghetta(int valore)
	{
		paghetta=valore;	
		disponibilita = true;
	
	}		
}