package eserciziLezione13;

import java.util.Random;


public class ThreadConto extends Thread {
	
	
	private final int numeroContoCorrente;
	private Banca banca;
	
	
	public ThreadConto(int numeroContoCorrente, Banca banca) {
		
		this.numeroContoCorrente = numeroContoCorrente;
		this.banca = banca;
		
	}
	
	
	public int getNumeroContoCorrente() {
		
		return numeroContoCorrente;
	}
	
	public Banca getBanca() {
		
		return banca;
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
				
				int contoSorgente = this.numeroContoCorrente;
				int contoDestinazione = new Random().nextInt(0,10);
				
				banca.bonifico(contoSorgente, contoDestinazione,500);
			}catch ( Error e) {
				throw new Error("ERRORE ! è stato inserito un valore negativo.\nCODICE ERRORE -> " + e.getMessage());
			}catch (InterruptedException e) {
            
            System.out.println("ATTENZIONE ! Thread Interrotto !");
            
        }
		}
			
			
		}
	}



