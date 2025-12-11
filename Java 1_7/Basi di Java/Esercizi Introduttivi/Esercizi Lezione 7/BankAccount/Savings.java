/*
 CLASSE SAVINGS
 Un conto saving è un conto di risparmio che accredita gli interessi.
E’ come il conto base, ma contiene l’interesse applicato e il numero massimo di prelievi giornalieri consentiti
Prevedere 2 costruttori come per il conto base (con saldo iniziale positivo o nullo)
La funzionalità che movimenta il conto funziona in questo modo:
Per il versamenti è identica al conto base
Per i prelievi invece sono consentiti solo se non superano il numero massimo consentito al giorno (e ovviamente non superano il saldo disponibile)
Inoltre si richiede una funzione che calcola l’interesse sul saldo e lo aggiunge al saldo attuale.

Si prevede infine un metodo per stampare i dati del conto

 */
package eserciziLezione7;

import java.util.ArrayList;

import eserciziLezione7.Movimento.tipologiaOperazione;

public class Savings {
	
	private final String intestatario;
	private final String numeroConto;
	private double saldo;
    ArrayList<Movimento> listaMovimenti = new ArrayList<Movimento>();
    private double depositoIniziale;
    private double interesseApplicato;
    private double tettoMassimo;
    
    
    
    

	
	
	public Savings(String intestatario, String numeroConto, double saldo, ArrayList<Movimento> listaMovimenti,
			double depositoIniziale, double interesseApplicato, double tettoMassimo) {

		this.intestatario = intestatario;
		this.numeroConto = numeroConto;
		this.saldo = saldo;
		this.listaMovimenti = listaMovimenti;
		this.depositoIniziale = depositoIniziale;
		this.interesseApplicato = interesseApplicato;
		this.tettoMassimo = tettoMassimo;
	}

	
	




	public Savings(String intestatario, String numeroConto, double saldo, ArrayList<Movimento> listaMovimenti,
			double interesseApplicato, double tettoMassimo) {
	
		this.intestatario = intestatario;
		this.numeroConto = numeroConto;
		this.saldo = saldo;
		this.listaMovimenti = listaMovimenti;
		this.interesseApplicato = interesseApplicato;
		this.tettoMassimo = tettoMassimo;
	}









	public void gestioneMovimento(Movimento movimento, double ammontare) {
		
		
		if(movimento.getTipologiaOperazione().equals(tipologiaOperazione.PRELIEVO)) {
			
			if(movimento.getImporto() <= tettoMassimo && movimento.getImporto() <= saldo) {
				
				
				saldo -= ammontare;
			}
			else {
			
				
				System.out.println("ATTENZIONE ! L'importo supera quello del Tetto massimo stabilito oppure quella del SALDO, NON DISPENSABILE !");
			}
			
		}
		
		
		else if (movimento.getTipologiaOperazione().equals(tipologiaOperazione.VERSAMENTO)) {
			
			
			saldo += ammontare;
			
		
			
		}
		
		else {
			
			System.out.println("ATTENZIONE ! Il movimento inserito è ERRATO ! Sia o PRELIEVO oppure VERSAMENTO ");
		}
	}
	
	
	public double calcoloInteresse() {
		
		double somma = this.depositoIniziale;
		
		somma = saldo + interesseApplicato;
		
		return somma;
		
		
		
	}



	@Override
	public String toString() {
		return "\n|CONTO RIEPILOGO |\n\nINTESTATARIO: " + intestatario + "\n\nNUMERO DEL CONTO: " + numeroConto + "\n\nSALDO ATTUALE: " + saldo
				+ "\n\nLISTA MOVIMENTI: " + listaMovimenti + "\n\nDEPOSITO INIZIALE: " + depositoIniziale 
				+ "\n\nINTERESSE APPLICATO: " + interesseApplicato + "\n\nTETTO MASSIMO: " + tettoMassimo;
		
	}
	
	

	  
	
	
    
    
    
	
    
    
	
	

}
