package Biblioteca;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;


/* * Ruolo - Abstract User Base Class
    ? Represents the generic contract for any library user (e.g., Student, Teacher). It manages personal details, the membership card ('Tessera'), and the history of active loans.

    ! 1. aperturaPrestito(Pubblicazione p), the core business logic for borrowing items. It prevents duplicate loans of the same item, calculates the expiration date (30 days), applies the subclass-specific discount via calcolaSconto(), and records the new 'Prestito'.
    ! 2. getPrestito(String codicePubblicazione), scans the user's current loans to find a specific transaction based on the publication code.
    ! 3. calcolaSconto(), an abstract method that enforces concrete subclasses to define their specific discount policy (polymorphism).
    ! 4. equals()/hashCode(), overrides object equality to ensure users are identified uniquely by their 'id'.
*/


public abstract class Ruolo {
	
	private int id;
	private String nome;
	private String cognome;
	private Tessera tessera;
	
	private LinkedList<Prestito> prestiti = new LinkedList<>();
	
	
	public Ruolo(int id, String nome, String cognome) {
		
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}

    void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}
	
	public Tessera getTessera() {
		return tessera;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public LinkedList<Prestito> getPrestiti() {
		return prestiti;
	}
	
    
	//We go to manage the case, where two Objects has the same class object
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ruolo ruolo = (Ruolo) o;
		return id == ruolo.id;
	}
    
    
	@Override 
	public int hashCode() {
		return Objects.hashCode(id);
	}
	 
	void aperturaPrestito(Pubblicazione p) throws SamePubblicationException {
		
		
		for (Prestito prestitoPresente : prestiti) {
			
			if(prestitoPresente.getPubblicazionePrestito().equals(p)) {
				
				throw new SamePubblicationException("ATTENZIONE ! L'utente ha già in prestito la pubblicazione ");
				
			}
		}
		
		//We creating the logic to populate the newLoan in order to elaborate correctly the object
		
		LocalDate dataCreazione = LocalDate.now();
		LocalDate dataScadenza =  dataCreazione.plusDays(30);
		double prezzoBase = p.getPrezzoBase();
		double scontoPercentuale = this.calcolaSconto();
		
		
		Prestito nuovoPrestito = new Prestito(dataCreazione,dataScadenza,p);
		
		double prezzoScontato = prezzoBase - (prezzoBase * scontoPercentuale / 100);
		
		//Before adding the Loan, we have to compile all the missing fields, in this case 'prezzoFinale' field on class 'Prestito'
		nuovoPrestito.setPrezzoFinale(prezzoScontato);
		prestiti.add(nuovoPrestito);
		
	
        System.out.println("SUCCESSO ! È stato APERTO un PRESTITO per: " + p.toString() + "\nSCONTO APPLICATO -> " + prezzoScontato);
	}
	
    
	Prestito getPrestito(String codicePubblicazione) {
		
        if (prestiti.isEmpty()) return null;

        for (Prestito p : prestiti) {
        
             if (p.getPubblicazionePrestito().getPubblicazione().equals(codicePubblicazione)) {
             return p;
            }
        }
        return null; 
    }

    
    abstract double calcolaSconto();
    
  

  	@Override
  	public String toString() {
  		return "|UTENTE |\n\nUTENTE ID -> " + id + "\n\nNOME-> " + nome + "\n\nCOGNOME -> " + cognome
  				+ "\n\nNUMERO TESSERA -> " + tessera + "\n\n -> ELENCO PRESTITI:\n" + prestiti;
  	}

}

