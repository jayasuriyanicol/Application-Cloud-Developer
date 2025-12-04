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

public class Contatto {
	


		private String nome;
		private String cognome;
		private String numeroTelefonico;
		
		
		//Initialize the constructor with all the variables
		public Contatto(String nome, String cognome, String numeroTelefonico) {
			this.nome = nome;
			this.cognome = cognome;
			this.numeroTelefonico = numeroTelefonico;
		   
		}


	   
		public void setNome(String nome) {
			this.nome = nome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		
		
		public void setNumeroTelefonico(String numeroTelefonico) {
			this.numeroTelefonico = numeroTelefonico;
		}

		
		
		public String getNome() {
			return nome;
		}
		
		
		public String getCognome() {
			return cognome;
		}
		 
		
		public String getNumeroTelefonico() {
			return numeroTelefonico;
		}



		@Override
		public String toString() {
			return " NOME : " + nome + " | COGNOME : " + cognome + " || NUMERO  -> " + numeroTelefonico + "";
		}
		
		
		
		

		



		
	}

