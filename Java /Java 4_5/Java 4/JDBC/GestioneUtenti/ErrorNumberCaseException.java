package GestioneUtenti;

/* * ErrorNumberCaseException - Custom Exception
    ? A custom checked exception designed to handle specific errors related to invalid numeric inputs or constraints (e.g., invalid age, ID format) within the user management system.

    ! 1. ErrorNumberCaseException(String motivazione), constructor that passes a specific error message to the superclass to describe the nature of the numeric violation.
*/

@SuppressWarnings("serial")
public class ErrorNumberCaseException extends Exception {
	
	public ErrorNumberCaseException() {
		
		super();
		
	}
	
	public ErrorNumberCaseException (String motivazione) {
		
		super(motivazione);
	}
		
}
