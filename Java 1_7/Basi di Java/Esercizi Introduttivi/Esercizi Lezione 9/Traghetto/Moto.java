package eserciziLezione9;

public class Moto extends Veicoli {
	
	
	public Moto(String targa) {
		
		super(targa);
	}
	

	
	@Override
	public void aggiungiPasseggero(Persone p) {
		
		if(passeggeri.size() < 2) {
			
			super.aggiungiPasseggero(p);
		}
		else {
			
			System.out.println("ATTENZIONE ! La MOTO è piena massimo una persona compreso il conducente");
		}
		
		
	}
	
	
	public double calcolaTariffa() {
		
		return 3.5 + calcolaCostoPassegeri();
		
		
	}
	
	
	
	
}
