package Lezione_05;

public class Main {

	public static void main(String[] args) {
	
		Persona[] persone = {
				
				new Studente("Cristiano", "Coccia", "RM067"),
				new Docente("Nicol", "Jayasuriya", "Basi di Nani")
		};
		
		
		for(Persona p: persone) {
			
			System.out.println(p.presentati());
		}

	}

}
