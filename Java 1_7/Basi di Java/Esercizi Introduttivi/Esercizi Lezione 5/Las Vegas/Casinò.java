package eserciziLezione5;

public class Casino {
	
	private String nome;
	private double capitaleIniziale;
	
	public Casino(String nome, double capitaleIniziale) {
		
		this.nome = nome;
		this.capitaleIniziale = capitaleIniziale;
	}

	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public double getCapitaleIniziale() {
		return capitaleIniziale;
	}


	@Override
	public String toString() {
		
		return "Casino:  " + nome + ", Capitale Disponibile : " + capitaleIniziale;
	}

	public boolean valutaPuntate (int[] puntate) {
		
		
		int totalePuntate = 0;
		
		for (int p : puntate) {
			
			totalePuntate += p;
		}
		
		double vincitaMassima = totalePuntate * Dado.ricarico;
		
		if(this.capitaleIniziale >= vincitaMassima) {
			
			this.incassa(totalePuntate);
			return true;
		}
		else {
			
			return false;
		}
		
	}
	
	
	public void incassa (int importo) {
		
		capitaleIniziale += importo;
	}

	public void paga (int importo) {
		
		double importoDaPagare =  Dado.ricarico * importo;
		if (capitaleIniziale >= importoDaPagare) 
			capitaleIniziale -= importoDaPagare;
		
		else
			System.out.println("ATTENZIONE ! Saldo non dispensabile dal Casino");
}
}
