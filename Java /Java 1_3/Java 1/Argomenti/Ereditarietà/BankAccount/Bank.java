package eserciziLezione7;

import java.util.ArrayList;
import java.util.Date;
public class Bank {
	
	private String nome;
	private double capitale;

	private ArrayList<BankAccount> listaConti;
	
	
	
	public Bank(String nome, double capitale) {
		
		this.nome = nome;
		this.capitale = capitale;
		this.listaConti = new ArrayList<BankAccount>();
	}
	
	
	
	public void open(BankAccount conto) {
		
		if (listaConti.contains(conto)) {
			System.out.println("ATTENZIONE ! Il conto " +conto + "  è presente già nei nostri sistemi");
		}
		else {
		listaConti.add(conto);
		System.out.println("SUCCESSO ! Il conto " +conto + " è stato APERTO con successo");
		
	}
	}
	
	public void close(BankAccount conto) {
		
		if(listaConti.contains(conto)) {
			
			
			listaConti.remove(conto);
			
			System.out.println("SUCCESSO ! Il conto " +conto + " è stato CHIUSO con successo");
			
		}
		else {
			System.out.println("ATTENZIONE ! Il conto " +conto + " non è presente nei nostri sistemi");
		}
	
	
	}
	
	
	
	public void trasferimento(BankAccount ordinante, BankAccount beneficiario, Date data,double ammontare) {
		
		
         if (ordinante.saldo >= ammontare ) {
			
           
			Movimento uscita = new Movimento(Movimento.tipologiaOperazione.PRELIEVO, data, ammontare);
			Movimento entrata = new Movimento(Movimento.tipologiaOperazione.VERSAMENTO, data, ammontare);
			
       
            ordinante.gestioneMovimento(uscita);
            beneficiario.gestioneMovimento(entrata);
			
			System.out.println("TRASFERIMENTO COMPLETATO DA: " + ordinante.intestatario + " A: " + beneficiario.intestatario);
		}
         else {
             System.out.println("ATTENZIONE ! Fondi insufficienti sul conto ordinante. Trasferimento annullato.");
         }
			
			
			System.out.println("TRASFERIMENTO INIZIO DA: " + ordinante.intestatario + "AD: " + beneficiario.intestatario );
			System.out.println("\nTRASFERIMENTO COMPLETATO");
	}
			
		
	
		
	
	
	public double calcoloPatrimonio() {
		
		double patrimonio = this.capitale;
		
		for(BankAccount conto : listaConti) {
			
			patrimonio += conto.saldo;
		}
		
		return patrimonio;
	}



	@Override
	public String toString() {
		return "\n|BANCA|\n\nNOME BANCA: " + nome + "\n\nCAPITALE: " + capitale + "\n\nLISTA CONTI: " + listaConti + "\n\nPATRIMONIO: " + calcoloPatrimonio();
				
	}
	
	
	
	
	
	
	
	}

