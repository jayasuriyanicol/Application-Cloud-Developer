package Lezione_07;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Rubrica {
	
	
	private List<Contatto> contatti = new ArrayList<>();
	
	private Set<String> registroEmail = new HashSet<>();
	
	private Map<String,Contatto> registroContatti = new HashMap<>();
	
	
	
	public void aggiungiContatto(Contatto c) {
		
	   if (registroEmail.contains(c.getEmail()) && c.getEmail().contains("@")) {
		   
		   throw new IllegalArgumentException("ATTENZIONE ! Non è possibile registrare un utente dato che risulta già registrato con questa email !");
		   
	   }
	   
	   contatti.add(c);
	   registroEmail.add(c.getEmail());
	   registroContatti.put(c.getEmail(),c);
	  
	   
	   
	}

	
	
	public Contatto cercaPerEmail(String email) {
		
		
		
			if (!registroContatti.containsKey(email)) {
			
				System.out.println("ATTENZIONE ! Non risulta essere presente nessuna EMAIL associata");
			}
			
			
			
			return registroContatti.get(email);
			

	}
	
	
	public List<Contatto> getListaContatti(){
		
		return contatti;
		
		
	}
	
	
	public void stampaTuttiContatti() {
		
		for(Contatto c : contatti) {
			
			System.out.println(c.toString());
		}
	}
}
