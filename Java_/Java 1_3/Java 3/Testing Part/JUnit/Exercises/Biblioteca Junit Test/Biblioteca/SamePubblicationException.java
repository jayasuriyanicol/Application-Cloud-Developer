package Biblioteca;


/* * SamePubblicationException - Custom Exception
    ? A custom checked exception thrown when a constraint violation occurs involving a publication, such as attempting to add a duplicate item to the catalog or borrowing an item already on loan.

    ! 1. SamePubblicationException(String motivazione), constructor that passes the specific error message to the superclass to explain the nature of the publication conflict.
*/


@SuppressWarnings("serial")
public class SamePubblicationException extends Exception {
	
	public SamePubblicationException() {
		
		super();
	}
	
public SamePubblicationException(String motivazione) {
	
	super(motivazione);
	
}

}

