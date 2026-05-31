package GestioneUtenti;

/* * ExceptionWrongCredentials - Custom Security Exception
    ? A custom checked exception raised during login or verification attempts to indicate that the provided credentials (username/password) are invalid.

    ! 1. ExceptionWrongCredentials(String motivazione), constructor that conveys the specific authentication failure reason (e.g., "Password errata") to the superclass.
*/

@SuppressWarnings("serial")
public class ExceptionWrongCredentials extends Exception {

	public ExceptionWrongCredentials() {
		
		super();
	
	}
	
	public ExceptionWrongCredentials(String motivazione) {
		
		super(motivazione);
	}
}
