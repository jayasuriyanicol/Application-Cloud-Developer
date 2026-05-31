package Biblioteca;

import java.time.LocalDate;

/* * Prestito - Loan Transaction Entity
    ? Represents the state of a lending transaction, tracking the timeframe (start/end dates), the specific item borrowed (Pubblicazione), and the final calculated cost.

    ! 1. Prestito(...), constructor that establishes the valid period and links the specific publication to this loan.
    ! 2. setPrezzoFinale(Double prezzoFinale), allows external logic (like the User's discount calculation) to inject the final determined price into the transaction record.
    ! 3. getGiorniPrestati(), currently returns a static value (1), intended to be a utility method for calculating the actual duration of the loan.
*/

public class Prestito {

    private LocalDate dataInizio;
    private LocalDate dataFine;
    private Pubblicazione pubblicazione;
    private Double prezzoFinale;

    public Prestito(LocalDate dataInizio, LocalDate dataFine, Pubblicazione pubblicazione) {
    	
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.pubblicazione = pubblicazione;
    }

	public void setPubblicazionePrestito (Pubblicazione pubblicazione) {
		this.pubblicazione = pubblicazione;
	}
	
    public Pubblicazione getPubblicazionePrestito() {
		return pubblicazione;
	}


	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	public LocalDate getDataInizio() {
		return dataInizio;
	}



	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}


	public LocalDate getDataFine() {
		return dataFine;
	}



	public void setPrezzoFinale(Double prezzoFinale) {
		this.prezzoFinale = prezzoFinale;
	}
	
	public Double getPrezzoFinale() {
		return prezzoFinale;
	}



	int getGiorniPrestati(){
        return 1;
    }


	@Override
	public String toString() {
		return "|PRESTITO|\n\nDATA INIZIO -> " + dataInizio + "\n\nDATA FINE -> " + dataFine + "\n\nPUBBLICAZIONE -> " + pubblicazione
				+ "\n\nPREZZO FINALE -> " + prezzoFinale;
	}
}

	




