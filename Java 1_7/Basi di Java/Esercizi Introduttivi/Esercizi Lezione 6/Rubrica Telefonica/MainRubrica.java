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

public class MainRubrica {

	public static void main(String[] args) {

		
		Rubrica rubrica = new Rubrica(3);

		System.out.println("Posti liberi: " + rubrica.numeroPostiLiberi()); 

	
		rubrica.inserisciContatto("Giacomo", "Coccodrillini", "39 3210983729"); 
		rubrica.inserisciContatto("Armadillo", "Sventurini", "39 3321344926"); 
		rubrica.inserisciContatto("Franco", "Balestra", "39 3532414586"); 

		System.out.println("\nNumero contatti registrati: " + rubrica.numeroContattiRegistrati()); 
		System.out.println("Posti liberi: " + rubrica.numeroPostiLiberi()); 

		
		rubrica.inserisciContatto("David", "Divano", "39 3422409518");

		rubrica.mostraTuttiContatti();

	
		rubrica.mostraContattoPosizione(1); 
		rubrica.mostraContattoPosizione(5); 

	
		rubrica.contattoNome("giacomo"); 
		rubrica.contattoNumeroTelefonico("39 3321344926");
		rubrica.contattoNome("cristiano"); 
	}
}