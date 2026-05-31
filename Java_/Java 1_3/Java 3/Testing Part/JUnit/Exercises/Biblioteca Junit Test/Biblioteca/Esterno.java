package Biblioteca;

/* * Esterno - Concrete User Implementation
    ? Represents a generic external library user, distinguishing between minors and adults to apply different discount policies.

    ! 1. Esterno(...), constructor initializing the base user data via super() and setting the minority status flag.
    ! 2. calcolaSconto(), implements the abstract discount policy using a ternary operator: returns 10.0% if the user is a minor, otherwise 0.0%.
*/


public class Esterno extends Ruolo{

    private boolean minorenne;

    public Esterno(int id, String nome, String cognome, boolean minorenne) {
        super(id, nome, cognome);
        this.minorenne = minorenne;
    }

    @Override
    double calcolaSconto() {
        return minorenne? 10.0 : 0.0;
    }

	public boolean isMinorenne() {
		return minorenne;
	}

	public void setMinorenne(boolean minorenne) {
		this.minorenne = minorenne;
	}


}