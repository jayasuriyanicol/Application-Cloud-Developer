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
import java.util.Date;

public class BankAccount {
    
    protected String intestatario;
    public String numeroConto;
    protected double saldo;
    protected ArrayList<Movimento> listaMovimenti;
    protected double depositoIniziale;
    
    public BankAccount(String intestatario, String numeroConto, double depositoIniziale) {
        this.intestatario = intestatario;
        this.numeroConto = numeroConto;
        this.saldo = depositoIniziale;
        this.depositoIniziale = depositoIniziale;
        this.listaMovimenti = new ArrayList<Movimento>();
        
        Movimento iniziale = new Movimento(Movimento.tipologiaOperazione.VERSAMENTO, new Date(), depositoIniziale);
        listaMovimenti.add(iniziale);
    }
    
    public BankAccount(String intestatario, String numeroConto) {
        this.intestatario = intestatario;
        this.numeroConto = numeroConto;
        this.saldo = 0.0;
        this.depositoIniziale = 0.0;
        this.listaMovimenti = new ArrayList<Movimento>();
    }
    
    public void gestioneMovimento(Movimento movimento) {
        
        if(movimento.getTipologiaOperazione().equals(Movimento.tipologiaOperazione.PRELIEVO)) {
            if(saldo >= movimento.getImporto()) {
                saldo -= movimento.getImporto();
                listaMovimenti.add(movimento);
            }
            else {
                System.out.println("ATTENZIONE ! Saldo insufficiente.");
            }
        }
        else if (movimento.getTipologiaOperazione().equals(Movimento.tipologiaOperazione.VERSAMENTO)) {
            saldo += movimento.getImporto();
            listaMovimenti.add(movimento);
        }
        else {
            System.out.println("ATTENZIONE ! Tipo operazione errato.");
        }
    }
    
    public boolean checkBalance() {
        double somma = this.depositoIniziale;
        
        for (Movimento m : listaMovimenti) {
            if(m.getTipologiaOperazione().equals(Movimento.tipologiaOperazione.PRELIEVO)) {
                somma -= m.getImporto();
            }
            else {
                somma += m.getImporto();
            }
        }
        
        if (Math.abs(saldo - somma) < 0.001) {
            return true;
        }
        else {
            System.out.println("ATTENZIONE ! Incoerenza saldo.");
            return false;
        }
    }

    public void stampaDati() {
        System.out.println("Intestatario: " + intestatario);
        System.out.println("Conto: " + numeroConto);
        System.out.println("Saldo: " + saldo);
    }
}


	
	
	
	
    
    
    
    
    
    
	 
	
 

	




