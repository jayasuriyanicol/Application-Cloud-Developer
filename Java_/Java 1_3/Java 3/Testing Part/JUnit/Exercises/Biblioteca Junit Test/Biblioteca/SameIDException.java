package Biblioteca;

/* * SameIDException - Custom Exception
    ? A custom checked exception thrown during registration processes to indicate that a provided Identifier (ID) is already in use by another entity.

    ! 1. SameIDException(String motivazione), constructor that passes a specific error message to the superclass to detail the context of the duplication error.
*/

@SuppressWarnings("serial")
public class SameIDException extends Exception {
	
	
	public SameIDException(){
		super();
	}
	
	
public SameIDException(String motivazione) {
		
		super(motivazione);
	}
}
