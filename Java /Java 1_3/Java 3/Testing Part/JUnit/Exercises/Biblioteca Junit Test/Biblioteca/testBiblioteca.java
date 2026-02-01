package Biblioteca;


/* * testBiblioteca - Manual Test Driver
    ? A simulation class containing a main method to demonstrate and verify the functionality of the Library system, including success scenarios and error handling.

    ! 1. main(String[] args), orchestrates the simulation: initializes the Library, creates dummy data (Books, Users), and executes registration and lending workflows.
    ! 2. Exception Testing, intentionally triggers specific exceptions (SameIDException, SamePubblicationException) within try-catch blocks to verify constraint enforcement (e.g., duplicate IDs, double booking).
    ! 3. State Verification, retrieves and prints the status of a specific user to confirm that loans were correctly recorded in the system.
*/


public class testBiblioteca {

    public static void main(String[] args) {

        System.out.println("|BIBLIOTECA PROGRAMMA|");
        Biblioteca biblioteca = new Biblioteca("Guido Lampredotti", "Roma");

        
        Libro l1 = new Libro("JA01", "Java Spring & REST", "Richardison", 5, 45.20, 2);
        Libro l2 = new Libro("RF21", "La vita", "Mondadori", 10, 17.00, 1);
        Rivista r1 = new Rivista("CA93", "Teorie Vere", "Bartolini", 20, 70.78, 1);

        
        Studente s1 = new Studente(001, "Giacomo", "Coccodrillini", false);
      
      
        Studente s2 = new Studente(002, "Fabrizio", "Olfattini", true);
        
       
        Docente d1 = new Docente(901, "Stira", "Cani");

        Esterno hackerino = new Esterno(001, "Dockerina", "Hackerina", false);
        
        
        

        System.out.println("\n|REGISTRAZIONE LIBRI e UTENTI|");

        try {
            
            biblioteca.registraPubblicazioneNuova(l1);
            biblioteca.registraPubblicazioneNuova(l2);
            biblioteca.registraPubblicazioneNuova(r1);
            
            //If we want to test the duplicate error, we can do
            // biblioteca.registraPubblicazioneNuova(l2); 

            
            biblioteca.registraNuovoUtente(s1);
            biblioteca.registraNuovoUtente(s2);
            biblioteca.registraNuovoUtente(d1);

            //Testing the exception case,same id on another utente
            biblioteca.registraNuovoUtente(hackerino); 

        } catch (SameIDException | SamePubblicationException e) {
            System.err.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n|PRESTITI LIBRI & RIVISTE|");

        try {
           
          
            biblioteca.prestitoLibro("JA01", 001);

            biblioteca.prestitoLibro("RF21", 002);

            //Testing the exception on the book already taken
            biblioteca.prestitoLibro("JA01", 001);

        } catch (SamePubblicationException e) {
            System.err.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n|VERIFICA STATO UTENTE|");
        
        Ruolo GiacomoStatus = biblioteca.getUtente(001);
        if (GiacomoStatus != null) {
            System.out.println(GiacomoStatus);
        }
    }
}
