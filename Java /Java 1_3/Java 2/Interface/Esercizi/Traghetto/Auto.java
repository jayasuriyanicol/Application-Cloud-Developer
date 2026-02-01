package eserciziLezione9;

public class Auto extends Veicoli{
	
	
	public enum modello {
		
		MINI,
		STANDARD,
		SUV
		
	}

	private modello tipo;;
	
	
	public Auto (String targa, modello tipo) {
		
		super(targa);
		this.tipo = tipo;
	}
	
	
	@Override
	public void aggiungiPasseggero(Persone p) {
		
		if (passeggeri.size() < 5) {
			
			super.aggiungiPasseggero(p);
			
		} else {
			
			System.out.println("ATTENZIONE ! L'AUTO risulta piena massimo 5 persone compreso il conducente !");
		}
		
	}
	
	@Override
	public double calcolaTariffa() {
		
		double prezzo = 0;
		
		switch (tipo) {
		
		case MINI:
			prezzo = 4.0;
			break;
			
			
		case STANDARD:
			prezzo = 5.0;
			break;
		
		case SUV:
			prezzo= 8.5;
			break;
			
			
		}
		
		return prezzo + calcolaCostoPassegeri();
	}

	
}



