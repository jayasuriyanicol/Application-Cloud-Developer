package GestioneUtenti;

/* * SameUsernameException - Custom Constraint Exception
    ? A custom checked exception thrown during user registration or update processes to indicate that the desired username violates a uniqueness constraint (i.e., it is already taken).

    ! 1. SameUsernameException(String motivazione), constructor that propagates the specific conflict details to the superclass to inform the user why the operation failed.
*/


@SuppressWarnings("serial")
public class SameUsernameException extends Exception {
	
	public SameUsernameException() {

		super();
	}
	
	
	public SameUsernameException (String motivazione) {
			
		super(motivazione);
		
	}

	
}
