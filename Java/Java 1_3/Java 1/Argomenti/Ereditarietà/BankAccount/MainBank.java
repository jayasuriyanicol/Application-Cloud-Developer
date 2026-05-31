package eserciziLezione7;

import java.util.Date;

public class MainBank {

	public static void main(String[] args) {
		
		
		System.out.println("\nGESTIONALE BANCA");
		Date dataOdierna = new Date();

		
		Bank banca = new Bank("BancaCoccia", 1342433.00);
		System.out.println("SUCCESSO ! La banca è stata creata: " + banca);

		
		BankAccount c1 = new BankAccount("David Divano", "IT183823828BDAHH22", 100.0);
		
		Savings c2 = new Savings("Cristiano Coccia", "IT29372943BJDBAJB22", 1000.0, 1000.0, 0.05);

		
		
		System.out.println("CONTI CREAZIONE");
		banca.open(c1);
		banca.open(c2);

		
		
		System.out.println("\n\nOPERAZIONE CONTO: David Divano");
		
		
		Movimento cd = new Movimento(Movimento.tipologiaOperazione.VERSAMENTO, dataOdierna, 50.0);
		c1.gestioneMovimento(cd);
		System.out.println("Versamento effettuato. Saldo David: " + c1.saldo);
		
		
		Movimento cd2 = new Movimento(Movimento.tipologiaOperazione.PRELIEVO, dataOdierna, 20.0);
		c1.gestioneMovimento(cd2);
		System.out.println("Prelievo effettuato. Saldo David: " + c1.saldo); 

		
		
		System.out.println("\n\nOPERAZIONE CONTO: Cristiano Coccia");
		
		
		System.out.print("\nTENTATIVO PRELIEVO 600 EURO (LIMITE 500): ");
		Movimento cr = new Movimento(Movimento.tipologiaOperazione.PRELIEVO, dataOdierna, 600.0);
		c2.gestioneMovimento(cr); 
		
		
		Movimento cr2 = new Movimento(Movimento.tipologiaOperazione.PRELIEVO, dataOdierna, 100.0);
		c2.gestioneMovimento(cr2);
		System.out.println("Prelievo 100 riuscito. Saldo Cristiano: " + c2.saldo); 
		
		
		
	
		System.out.print("\nCALCOLO INTERESSI ");
		c2.applicaInteresse();
		System.out.println("Saldo Cristiano: " + c2.saldo);

		
		
		System.out.println("\nTRASFERIMENTO ---");
		
		banca.trasferimento(c1, c2, dataOdierna, 30.0);
		
		System.out.println("Saldo David Finale: " + c1.saldo); 
		System.out.println("Saldo Cristiano Finale: " + c2.saldo); 

		
		
		System.out.println("\nVERIFICA COERENZA");
		
		boolean checkDavid = c1.checkBalance();
		System.out.println("Coerenza Conto Mario: " + (checkDavid ? "OK CORRETTO" : "ERRORE"));
		
		boolean checkCristiano = c2.checkBalance();
		System.out.println("Coerenza Conto Luigi: " + (checkCristiano ? "OK CORRETTO" : "ERRORE"));

		
		
		System.out.println("\nRIEPILOGO FINALE");
		
		System.out.println(banca.toString());
		
		
		System.out.println("\nCHIUSURA CONTO");
		banca.close(c2);
	}

}