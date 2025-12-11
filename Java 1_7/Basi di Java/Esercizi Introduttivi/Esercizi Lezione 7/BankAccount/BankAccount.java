/*
 Classe Conto
 
 Un conto standard è caratterizzato da un intestatario e un numero.
	Deve memorizzare anche il saldo e la lista dei movimenti.
	Prevedere 2 costruttori:
	Con deposito iniziale
	Senza deposito iniziale
	Sul conto si possono eseguire prelievi e versamenti, ma sarà fornito un solo metodo che riceve e gestisce un movimento (Movement)
	Il prelievo è fattibile solo se l’ammontare non supera il saldo
	Inoltre si richiede una funzione di verifica coerenza (checkBalance), la quale controlla se il saldo del conto coincide con la somma algebrica dei movimenti
	Si prevede infine un metodo per stampare i dati del conto ed un altro per stampare solo la lista dei movimenti.

 */


package eserciziLezione7;
import java.util.ArrayList;

import eserciziLezione7.Movimento.tipologiaOperazione;
public class BankAccount {
	
		
	public final String intestatario;
	private final String numeroConto;
	public double saldo;
    ArrayList<Movimento> listaMovimenti = new ArrayList<Movimento>();
    private double depositoIniziale;
    
    
    
    
	public BankAccount(String intestatario, String numeroConto, double saldo, ArrayList<Movimento> listaMovimenti, double depositoIniziale) {
		
		this.intestatario = intestatario;
		this.numeroConto = numeroConto;
		this.saldo = saldo;
		this.listaMovimenti = listaMovimenti;
		this.depositoIniziale = depositoIniziale;
	}
    
	
	
    
	public BankAccount(String intestatario, String numeroConto, double saldo, ArrayList<Movimento> listaMovimenti) {
		
		this.intestatario = intestatario;
		this.numeroConto = numeroConto;
		this.saldo = saldo;
		this.listaMovimenti = listaMovimenti;

	}
	

	
	public void gestioneMovimento(Movimento movimento) {
		
		
		if(movimento.getTipologiaOperazione().equals(tipologiaOperazione.PRELIEVO)) {
			
			if(movimento.getImporto() >= saldo) {
				
				
				saldo -= movimento.getImporto();
			}
			else {
			
				
				System.out.println("ATTENZIONE ! Importo maggiore di quello disponibile, NON DISPENSABILE !");
			}
			
		}
		
		
		else if (movimento.getTipologiaOperazione().equals(tipologiaOperazione.VERSAMENTO)) {
			
			
			saldo += movimento.getImporto();
			
		
			
		}
		
		else {
			
			System.out.println("ATTENZIONE ! Il movimento inserito è ERRATO ! Sia o PRELIEVO oppure VERSAMENTO ");
		}
	}
		

	  public boolean checkBalance(){
		  
		  double somma = this.depositoIniziale;
		  for (Movimento m: listaMovimenti) {
			  
			if(m.getTipologiaOperazione().equals(Movimento.tipologiaOperazione.PRELIEVO)) {
				
				somma -= m.getImporto();
				
				
			}
			else if (m.getTipologiaOperazione().equals(Movimento.tipologiaOperazione.VERSAMENTO)) {
				
				somma += m.getImporto();
			}
			
			else {
				
				System.out.println("ATTENZIONE ! Errore nel sistema.");
			}
			    
			  
		  }
		  
		  if (saldo == somma) {
			  
			  return true;
		  }
		  else {
			  
			  System.out.println("\nATTENZIONE ! I valori della LISTA MOVIMENTI e il saldo NON COINCIDONO");
			  System.out.println("Saldo attuale: " + saldo +"\nSomma Totale (Deposito e Movimenti): " + somma);
			  return false;
		  }
		  
		
		  
	  }

	  @Override
	  public String toString() {
		return "\n|CONTO RIEPILOGO |\n\nINTESTATARIO: " + intestatario + "\n\n NUMERO DEL CONTO: " + numeroConto + "\n\nSALDO ATTUALE: " + saldo
				+ "\n\nLISTA MOVIMENTI: " + listaMovimenti + "\n\nDEPOSITO INIZIALE: " + depositoIniziale;
	  }
	  
	  
	  
	  
	  
	  
	  
		
		
	}



	
	
	
	
    
    
    
    
    
    
	 
	
 

	




