package Biblioteca;

/* * Docente - Concrete User Implementation
    ? Represents a specific type of library user (Teacher) extending the abstract 'Ruolo' class, characterized by a specific discount rate.

    ! 1. Docente(int id, String nome, String cognome), constructor that delegates initialization to the superclass to set the ID and personal details.
    ! 2. calcolaSconto(), implements the abstract policy method by returning a fixed 20.0% discount applicable to all loans made by teachers.
*/

public class Docente extends Ruolo{


    private final int sconto = 20;

    public Docente(int id, String nome, String cognome) {
    	
        super(id, nome, cognome);
    }

    @Override
    double calcolaSconto() {
        return 20.0;
    }

    public int getSconto() {
        return sconto;
    }


}