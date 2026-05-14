package Lezione_07;

public class MainRubrica {
	
	
	public static void main(String[] args) {
	Rubrica r = new Rubrica();
	
	Contatto c1 = new Contatto("Nicol", "Jayasuriya", "jayasuriyanicol28@gmail.com");
	Contatto c2 = new Contatto("Cristiano", "Scoccia", "cristiano.noob12@gmail.com");
	Contatto c3 = new Contatto("Leandro", "Impaziente", "impazinenza.inpersona67@gmail.com");

	
	
	   r.aggiungiContatto(c1);
	   r.aggiungiContatto(c2);
	   r.aggiungiContatto(c3);
	   
	   System.out.println(r.cercaPerEmail("jayasuriyanicol28@gmail.com") + "\n");
	   
	   System.out.println(r.getListaContatti() + "\n");
	   
	   r.stampaTuttiContatti();
	   
	   
	   
	   try {
		   
		   r.aggiungiContatto(new Contatto("Dockerina", "Hackerina", "cristiano.noob12@gmail.com"));
	   } catch(IllegalArgumentException e) {
		   
		   System.out.println("ERORRE:\n" + e.getMessage());
	   }
	 
	   

}
}
