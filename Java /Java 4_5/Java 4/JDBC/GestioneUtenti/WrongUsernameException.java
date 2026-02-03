package GestioneUtenti;

/* * WrongUsernameException - Custom Exception
    ? A custom checked exception thrown when an operation fails due to an invalid or non-existent username (e.g., during login or deletion).

    ! 1. WrongUsernameException(String motivazione), constructor that transmits the specific failure reason to the superclass for logging or user feedback.
*/

@SuppressWarnings("serial")
public class WrongUsernameException  extends Exception{
	
	public WrongUsernameException() {
		
		super();
	}
	
	
	public WrongUsernameException(String motivazione) {
		
		super(motivazione);
	}
	
	

}
