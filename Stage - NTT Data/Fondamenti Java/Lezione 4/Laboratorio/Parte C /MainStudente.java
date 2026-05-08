package Lezione_04;

public class MainStudente {

	public static void main(String[] args) {
		
		
		//Creazione dello studente senza l'ausilio di GET o SETTER
		Studente st1 = new Studente("Nicol","Jayasuriya","00123",19.4);
		
		st1.isPromosso();
		st1.stampaScheda();
		
		//GETTER e SETTER 
		Studente st2 = new Studente();
		
		st2.setNome("Franco");
		st2.setCognome("Franchini");
		st2.setMatricola("00131");
		st2.setMediaVoti(19.2);
		
		st2.isPromosso();
		st2.stampaScheda();
		
		

		
	}

}
