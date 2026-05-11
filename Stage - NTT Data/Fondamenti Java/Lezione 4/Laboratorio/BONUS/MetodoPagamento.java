package Lezione_05;

public abstract class MetodoPagamento {
	
	
	// ! In questo caso non stiamo andando a rappresentare una classe a OBJ ma un modello astratto.
	protected String valuta = "EUR";
	
	// ? Dopo aver associato un attributo, dobbiamo  per forza avere in una 
	// ? classe astratta almeno un metodo abstract.
	
	public abstract void paga(double importo);
	
	
	public void stampaRicevuta() {
		
		System.out.println("SUCCESSO! Il pagamento è andato a buon fine !\nDi seguito la ricevuta:");
	}

}
