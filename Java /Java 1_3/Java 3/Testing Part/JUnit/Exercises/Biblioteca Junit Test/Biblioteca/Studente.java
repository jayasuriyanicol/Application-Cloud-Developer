package Biblioteca;

/* * Studente - Concrete User Implementation
    ? Represents a student library user, extending 'Ruolo' to include academic status ('fuoriCorso') which directly impacts discount eligibility.

    ! 1. Studente(...), constructor initializing the base user identity via super() and the specific academic standing flag.
    ! 2. calcolaSconto(), implements the abstract policy: grants a 25.0% discount if the student is on schedule, but revokes it (returns 0.0%) if the student is 'fuoriCorso'.
*/


public class Studente extends Ruolo{

    private boolean fuoriCorso;
    private final int sconto = 25;

    public Studente(int id, String nome, String cognome, boolean fuoriCorso) {
    	
        super(id, nome, cognome);
        
        this.fuoriCorso = fuoriCorso;
    }
    

	public void setFuoriCorso(boolean fuoriCorso) {
		this.fuoriCorso = fuoriCorso;
	}
	
	 public boolean getFuoriCorso() {
			return fuoriCorso;
		}
	 
	 
	@Override
    double calcolaSconto() {
		
		return fuoriCorso ? 0.0 : 25.0;
    }

    public int getSconto() {
        return sconto;
    }

}