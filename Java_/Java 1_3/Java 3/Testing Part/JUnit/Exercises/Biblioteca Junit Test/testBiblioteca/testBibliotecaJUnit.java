package Biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;


/* * BibliotecaTest - JUnit Test Suite
    ? A comprehensive test class for the Library system, verifying business logic (discounts), constraints (unique IDs), and exception handling using JUnit 5 assertions.

    ! 1. setUp(), annotated with @BeforeEach, initializes a fresh Library instance with default users and books before every test to ensure isolation.
    ! 2. testRegistrazioneUtenteDuplicato(), asserts that attempting to register a user with an existing ID throws a SameIDException.
    ! 3. testCalcoloScontoStudente() / Docente(), verifies the polymorphic discount logic (25% for Students, 20% for Teachers) by checking the final loan price.
    ! 4. testEccezionePrestitoDuplicato(), ensures a user cannot borrow the same publication twice simultaneously, expecting a SamePubblicationException.
    ! 5. testRegistrazionePubblicazioneDuplicata(), verifies that the catalog rejects duplicate publication entries.
*/

class BibliotecaTest {

    private Biblioteca biblioteca;
    private Libro libroTest;
    private Studente studente;
    private Docente docente;

    //Initialize with @BeforeEach to setup all 
    @BeforeEach
    void setUp() throws Exception {
        biblioteca = new Biblioteca("Test Biblio", "Roma");

        libroTest = new Libro("L001", "Java Basics", "McGraw", 10, 100.0, 2);
        
        studente = new Studente(1, "Mario", "Rossi", false); 
        docente = new Docente(2, "Luigi", "Bianchi");        

        biblioteca.registraPubblicazioneNuova(libroTest);
        biblioteca.registraNuovoUtente(studente);
        biblioteca.registraNuovoUtente(docente);
    }

    @Test
    void testRegistrazioneUtenteDuplicato() {
        Esterno intruso = new Esterno(1, "Clone", "Neri", false);

        assertThrows(SameIDException.class, () -> {
            biblioteca.registraNuovoUtente(intruso);
        });
    }

    @Test
    void testCalcoloScontoStudente() throws SamePubblicationException {
        biblioteca.prestitoLibro("L001", 1);

        Ruolo utente = biblioteca.getUtente(1);
        LinkedList<Prestito> prestiti = utente.getPrestiti();
        Prestito p = prestiti.getLast();

        assertEquals(75.0, p.getPrezzoFinale(), 0.01);
    }

    @Test
    void testCalcoloScontoDocente() throws SamePubblicationException {
        biblioteca.prestitoLibro("L001", 2);

        Ruolo utente = biblioteca.getUtente(2);
        LinkedList<Prestito> prestiti = utente.getPrestiti();
        Prestito p = prestiti.getLast();

        assertEquals(80.0, p.getPrezzoFinale(), 0.01);
    }

    @Test
    void testEccezionePrestitoDuplicato() throws SamePubblicationException {
        biblioteca.prestitoLibro("L001", 1);

        assertThrows(SamePubblicationException.class, () -> {
            biblioteca.prestitoLibro("L001", 1);
        });
    }

    @Test
    void testRegistrazionePubblicazioneDuplicata() {
        assertThrows(SamePubblicationException.class, () -> {
            biblioteca.registraPubblicazioneNuova(libroTest);
        });
    }
}