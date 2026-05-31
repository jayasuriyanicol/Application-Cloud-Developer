package Biblioteca;

import java.util.HashMap;


/* * Biblioteca - Library Management Core
    ? The central class representing the library entity, managing the database of users (utenti) and the catalog of publications (catalogo) via HashMaps.

    ! 1. registraNuovoUtente(Ruolo nuovoUtente), handles user registration by checking for duplicates, generating and assigning a new 'Tessera' (membership card) with default credits, and storing the user in the map.
    ! 2. registraPubblicazioneNuova(Pubblicazione p), adds a new item to the library catalog using the publication code as the unique key, ensuring no duplicates exist.
    ! 3. prestitoLibro(String CP, int IDUTENTE), orchestrates the lending process by verifying the existence of both the user and the publication ID before delegating the transaction logic to the specific User object.
*/



public class Biblioteca {

    private String nomeBiblioteca;
    private String localitaBiblioteca;
    private final HashMap<Integer, Ruolo> utenti = new HashMap<>();
    private final HashMap<String, Pubblicazione> catalogo = new HashMap<>();

    public Biblioteca(String nomeBiblioteca, String localitaBiblioteca) {
    	
        this.nomeBiblioteca = nomeBiblioteca;
        this.localitaBiblioteca = localitaBiblioteca;
    }

   
    public void registraNuovoUtente(Ruolo nuovoUtente) throws SameIDException{
    	
    	
        if (!utenti.containsValue(nuovoUtente)){
        	
        	String messaggioUtenteRegistrato = "SUCCESSO !\nÈ stato REGISTRATO l'utente\nCODICE:" + nuovoUtente.getId()+"\nNOME: "+ nuovoUtente.getNome()+"\nCOGNOME: "+ nuovoUtente.getCognome();
            String utenteRegistrato = "CODICE:" + nuovoUtente.getId()+"NOME: "+ nuovoUtente.getNome()+"COGNOME: "+ nuovoUtente.getCognome();
            Tessera tessera = new Tessera(utenteRegistrato, 100);
            nuovoUtente.setTessera(tessera);
            utenti.put(nuovoUtente.getId(), nuovoUtente);

            System.out.println(messaggioUtenteRegistrato);
        }
        
        else {
        	
        	throw new SameIDException("ATTENZIONE ! Esiste già un utente REGISTRATO con lo stesso ID ! -> " + nuovoUtente.getId());
    
         }

    }
    
    
    
    public void registraPubblicazioneNuova (Pubblicazione p) throws SamePubblicationException{
    	
        if (!catalogo.containsValue(p)){
        	
        	String messaggioPubblicazioneRegistrata = "SUCCESSO !\nÈ stato REGISTRATA la PUBBLICAZIONE \nCODICE:" + p.getPubblicazione()+"\nTITOLO: "+ p.getTitolo()+"\nCASE EDITRICE: "+ p.getCasaEditrice() + "\nCASE EDITRICE: " + p.getNumeroCopie() + "\nNUMERO COPIE: " + p.getNumeroCopie() + "\nPREZZO BASE: " + p.getPrezzoBase();
            catalogo.put(p.getPubblicazione(), p);
            
            System.out.println(messaggioPubblicazioneRegistrata);
        }
        else {
        	
        	throw new SamePubblicationException("ATTENZIONE ! Esiste già un LIBRO REGISTRATO con la stessa PUBBLICAZIONE ! -> " + p.getPubblicazione());
        }
    }


    public void prestitoLibro(String CP, int IDUTENTE) throws SamePubblicationException{
    	
        if (utenti.containsKey(IDUTENTE) && catalogo.containsKey(CP)){
            utenti.get(IDUTENTE).aperturaPrestito(catalogo.get(CP));
        }
    }
    
    
    public void riconsegnaLibro (String CP, int IDUTENTE){

    }

    
    
    
    //GETTER ID, were show the ruolo of utente and the pubblicatio 
    
    Ruolo getUtente(int IDUTENTE){
        return utenti.get(IDUTENTE);
    }

    Pubblicazione getPubblicazione(String CP){
        return catalogo.get(CP);
    }



	@Override
	public String toString() {
		return "|BIBLIOTECA|\n\nNOME -> " + nomeBiblioteca + "\n\nPOSIZIONE -> " + localitaBiblioteca + "\n\nUTENTI -> " + utenti
				+ "\n\nCATALOGO -> " + catalogo;
	}
}

	
	
	
	
