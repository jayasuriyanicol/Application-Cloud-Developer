package Lezione_06;

public class MainEsito {
	
	
	public static void main(String[] args) {
		
		Accesso a1 = new LoginRiuscito("SUCCESSO ! Sei dentro !");
		Accesso a2 = new CredenzialiErrate("ERRORE ! Credenziali errate tentativi rimanenti -> 2");
		Accesso a3  = new UtenteBloccato("UTENTE BLOCCATO ! Contattare l'amministratore");
	
		
		esito(a1);
		esito(a2);
		esito(a3);
		
		
	
		
	
	}
	
	
	public static void esito(Accesso a) {
		
		
		if(a instanceof LoginRiuscito l) {
			
			System.out.println(l.getMessaggio());
			
		} else if(a instanceof CredenzialiErrate c) {
			
			System.out.println(c.getMessaggio());
			
		} else if(a instanceof UtenteBloccato b) {
			
			System.out.println(b.getMessaggio());
		}
		
		
	}

}
