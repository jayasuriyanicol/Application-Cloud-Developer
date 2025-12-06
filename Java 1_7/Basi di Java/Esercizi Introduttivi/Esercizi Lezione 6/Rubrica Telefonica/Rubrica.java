/*
PHONE BOOK

You want to create an address book to store telephone contacts.
The contact is defined by the first name, last name, and a telephone number.
The address book must provide the following features:
Insert contact
Show contact at specified location
Print all contacts
Show the number of registered contacts
Show the number of available spaces
Search for a contact by name
Search for a contact by number

Note: The address book is initially empty and will have a fixed size.
 */

package eserciziLezione6;

import java.util.ArrayList;

public class Rubrica {

	private int dimensioneMax;
	private ArrayList<Contatto> rubrica; 
	
	
	public Rubrica(int dimensione) {
		
		
		this.dimensioneMax = dimensione;
		//We initialize the array empty as new Rubrica, adding later the contacrs
		this.rubrica = new ArrayList<>();
		System.out.println("La RUBRICA è stata cretata con la capacità massima di " + dimensione + " contatti");
		
	}
	
	
	public int getDimensione() {
		return dimensioneMax;
	}
	

	
	
	public boolean inserisciContatto(String nome, String cognome, String numeroTelefonico){
		
		if (rubrica.size() < dimensioneMax){
			
			Contatto nuovoContatto = new Contatto(nome,cognome,numeroTelefonico);
		    rubrica.add(nuovoContatto);
			
			System.out.println("\n" + nuovoContatto + " è stato inserito correttamente nella RUBRICA");
			return true;
			
		}
		else{
			System.out.println("\nATTENZIONE ! la rubrica risulta essere piena, non è possibile registrare il nuovo contatto");
			return false;
		}
			
	}
	
	
	
	
	public void mostraContattoPosizione(int pos) {
		
		
		if ( pos >= 0 && pos < rubrica.size()) {
			
			System.out.println("\nIl contatto in posizione | " + pos + " | è : " + rubrica.get(pos));
		}else {
			
			System.out.println("\nATTENZIONE ! la posizione | " + pos + " | non è valida");
		}
		
		
	}
	
	
	
	public void mostraTuttiContatti() {
		if (rubrica.size() == 0) {
			System.out.println("\nATTENZIONE ! la rubrica è vuota.");
			return;
		}
		System.out.println("\nI Contatti nella Rubrica (Totale: " + rubrica.size() + " )");
		for (int i = 0; i < rubrica.size(); i++) {
			System.out.println("\n[ Posizione -> " + i + "] " + rubrica.get(i));
		}
	}


    public int numeroContattiRegistrati() {
		
    	return rubrica.size();
    	
    }
    

	

	public int numeroPostiLiberi() {
		
		return dimensioneMax - rubrica.size();

		
	}
	
	
	
	
	//We adding also to the research name and phone number, the boolen trovato to cycle all contacts until he found or he didn't found. If he found, syso and break otherwise cycling and if do not find syso with error message. 
	
	
	public void contattoNome(String nome) {
		
		boolean trovato = false;
		
		for (Contatto contatto : rubrica) {
			
			if (contatto.getNome().toLowerCase().equals(nome.toLowerCase())) {
				
				System.out.println("\n" + contatto);
				trovato = true;
				break;
								
			}
			
		}
			if(!trovato){			
				System.out.println("\nIl nome fornito -> | " + nome + " | NON risulta associato a NESSUN CONTATTO IN RUBRICA.");
			
				
			}
			
		}
		
		
	
	

	public void contattoNumeroTelefonico(String numeroTelefonico) {
		
		boolean trovato = false;
		
		for (Contatto contatto : rubrica) {
			
			if(contatto.getNumeroTelefonico().equals(numeroTelefonico)){
				
				System.out.println("\n"+ contatto);
				trovato = true;
				break;
				
			}
		}
			if(!trovato) {
				
				System.out.println("\nIl numero telefonico | " + numeroTelefonico + " | NON risulta associato a NESSUN CONTATTO IN RUBRICA.");
	
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
	


