package eserciziLezione9;

import eserciziLezione9.Auto.modello;
public class MainTraghetto {
	
	
		public static void main(String[] args) {
			
			
			System.out.println("\nSIMULAZIONE MAIN Traghetto");
			
			
			
			Biglietteria biglietteria = new Biglietteria();
			
			
			Persone p1  = new Persone ("David", "Divano");
			Persone p2  = new Persone ("Giacomo", "Coccodrillini");
			Persone p3  = new Persone ("Anna", "Bianchi");
			Persone p4  = new Persone ("Cristiano", "Scoccia");
			Persone p5 =  new Persone ("Francesco", "Trotterellini");
			Persone p6 =  new Persone ("Gippitina", "Dockerina");
			
			
			System.out.println("\nAGGIUNTA DELLE PERSONE -> che vanno a piedi");
			
			biglietteria.aggiungiInCoda(p1);
			
			Auto suv = new Auto("CA321LA", modello.SUV);
			
			
			
			suv.aggiungiPasseggero(p2);
			suv.aggiungiPasseggero(p3);
			
			
			System.out.println("\nÈ stato creato un SUV, la tariffa stimata è di: " + suv.calcolaTariffa());
			biglietteria.aggiungiInCoda(suv);
			
			
			
			Tir tir = new Tir("TR213BD", 10.0);
			
			tir.aggiungiPasseggero(p4);
			
	
			System.out.println("\nÈ stato creato un TIR, la tariffa stimata è di: " + tir.calcolaTariffa());
			biglietteria.aggiungiInCoda(tir);
			
			
			Moto moto = new Moto("AD232TE" );
			
			moto.aggiungiPasseggero(p5);
			moto.aggiungiPasseggero(p6);
			
			
			System.out.println("\nÈ stata creata una MOTO, la tariffa stimata è di: " + moto.calcolaTariffa());
			biglietteria.aggiungiInCoda(moto);
			
			
			
			
			System.out.println("\n\nSISTEMA DI ELABORAZIONE DI PAGAMENTI");
			
			
			try {
				
				Tariffabile pag1 = biglietteria.riceviPagamento();
				System.out.println("SUCCESSO, Transito pagato da: " +pag1.getClass().getSimpleName() + " a PIEDI.");
				
				
				Tariffabile pag2 = biglietteria.riceviPagamento();
				System.out.println("SUCCESSO, Transito pagato da: " +pag2.getClass().getSimpleName() + " Veicolo TARGA: " + ((Veicoli)pag2).targa );
				
				
				Tariffabile pag3 = biglietteria.riceviPagamento();
				System.out.println("SUCCESSO, Transito pagato da: " +pag3.getClass().getSimpleName() + " con MERCE." );
				
			
			} catch(RuntimeException e) {
				
				
				System.out.println("Errore nell'elaborazione: " + e.getMessage());
			}

			
			
			System.out.println("\n\nRIEPILOGO TOTALE: ");
			
			System.out.println("\nTOTALE BIGLIETTERIA: " + biglietteria.getTotaleCassa());
		
			
			System.out.println("\nCODA VUOTA, tentativo pagamento: ");
			
			try {
				
				biglietteria.riceviPagamento();
				
			}
			
			catch (ArrayIndexOutOfBoundsException e) {
				
				System.out.println("La situazione di ERRORE : " + e.getMessage());
			}
			
			
			
			System.out.println("\n\nFINE RIEPILOGO TOTALE. ");
			
			
			
			
			
			
			
			
			
			
			
			
		
		}
	}