package eserciziLezione9;

public class Tir extends Veicoli{
	
	
	public double prezzoTonnellate;
	
	
	public Tir(String targa, double prezzoTonnellate) {
		
		super(targa);
		this.prezzoTonnellate = prezzoTonnellate;
	}
	
	
	
	@Override
	public void aggiungiPasseggero(Persone p) {
		
		if (passeggeri.size() < 3) {
			
			super.aggiungiPasseggero(p);
			
		}
		else {
			System.out.println("ATTENZIONE ! Il TIR può accettare massimo 2 persone in cabina compreso il CONDUCENTE");
		}
		
		
	}
	
	
	@Override
	public double calcolaTariffa() {
		
		return 12.5 + calcolaCostoPassegeri() + (prezzoTonnellate * 0.5);
		
	}

}



