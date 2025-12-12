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

import java.util.Date;

public class Savings extends BankAccount {
    
    private double tassoInteresse; 
    private double tettoMassimo;

    public Savings(String intestatario, String numeroConto, double depositoIniziale, double tassoInteresse, double tettoMassimo) {
        super(intestatario, numeroConto, depositoIniziale);
        this.tassoInteresse = tassoInteresse;
        this.tettoMassimo = tettoMassimo;
    }

    public Savings(String intestatario, String numeroConto, double tassoInteresse, double tettoMassimo) {
        super(intestatario, numeroConto);
        this.tassoInteresse = tassoInteresse;
        this.tettoMassimo = tettoMassimo;
    }

    @Override
    public void gestioneMovimento(Movimento movimento) {
        
        if(movimento.getTipologiaOperazione().equals(Movimento.tipologiaOperazione.PRELIEVO)) {
            
            if(movimento.getImporto() > tettoMassimo) {
                System.out.println("ATTENZIONE ! L'importo supera il Tetto Massimo consentito!");
                return; 
            }
        }
        
        super.gestioneMovimento(movimento);
    }
    
    public void applicaInteresse() {
        double importoInteressi = saldo * tassoInteresse;
        
        if (importoInteressi > 0) {
            Movimento accreditoInteressi = new Movimento(Movimento.tipologiaOperazione.VERSAMENTO, new Date(), importoInteressi);
            super.gestioneMovimento(accreditoInteressi);
            System.out.println("Interessi applicati: " + importoInteressi);
        }
    }

    @Override
    public String toString() {
        return "\n|CONTO SAVINGS RIEPILOGO |\n" +
               "INTESTATARIO: " + intestatario + "\n" +
               "NUMERO DEL CONTO: " + numeroConto + "\n" +
               "SALDO ATTUALE: " + saldo + "\n" +
               "DEPOSITO INIZIALE: " + depositoIniziale + "\n" +
               "TASSO INTERESSE: " + tassoInteresse + "\n" +
               "TETTO MASSIMO: " + tettoMassimo;
    }
}
	
	
    
    
    
	
    
    
	
	

