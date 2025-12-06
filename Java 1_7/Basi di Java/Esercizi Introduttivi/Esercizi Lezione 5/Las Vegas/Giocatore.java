package eserciziLezione5;

public class Giocatore1 {

	
	private  String nome;
	private double budgetIniziale;
	private double puntata;
	private int numeroGiocato;
	
	
	public Giocatore1 (String nome, double budgetIniziale) {
		
		this.nome = nome;
		this.budgetIniziale = budgetIniziale;
		this.puntata = 0;
		this.numeroGiocato = 0;
				
	}
	
	
	public void setNome(String nome) {
		
		this.nome = nome;
	}
	
	public void setBudgetIniziale(double budgetIniziale) {
		
		this.budgetIniziale = budgetIniziale;
	}
	

	public String getNome() {
		return nome;
	}


	public double getBudgetIniziale() {
		return budgetIniziale;
	}


	public double getPuntata() {
		return puntata;
	}


	public int getNumeroGiocato() {
		return numeroGiocato;
	}


	@Override
	public String toString() {
		return "\nNOME: " + nome + "\nBUDGET: " + budgetIniziale + "\nSOLDI PUNTATI: " + puntata
				+ "\nNUMERO GIOCATO: " + numeroGiocato;
	}
	
	
	public void punta(int puntata, int numero) {
		
		if (puntata <= budgetIniziale) {
			this.puntata = puntata;
			this.numeroGiocato = numero;
			
			budgetIniziale -= puntata;
		}
		else {
			
			System.out.println("ATTENZIONE ! Non è possibile proseguire con la richiesta dato che la puntata è maggiora al saldo disponibile");
				
			}
	
		
		
	}
		
		public void incassa() {
			
			this.ricaricaBudget(Dado.ricarico * puntata);
			this.resetGiocate();
			
		}
		
		public void resetGiocate() {
			
			this.puntata = 0;
			this.numeroGiocato = 0;
		}
		
		public void ricaricaBudget(double importo) {
			
			budgetIniziale += importo;
			
			
		}
		
		public void recuperaPuntata() {
			
			this.ricaricaBudget(puntata);
			this.resetGiocate();
		}
		
		

		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

