package eserciziLezione9;

import java.util.ArrayList;

public abstract class Veicoli implements Tariffabile {

	public String targa;
	
	ArrayList<Persone> passeggeri  = new ArrayList <> ();
	
	
	public Veicoli (String targa) {
		
		this.targa = targa;

	}
	
	
	public void aggiungiPasseggero(Persone p) {
		
		passeggeri.add(p);
		
	}
	
	public double calcolaCostoPassegeri() {
		
		double totaleCosto = 0.0;
		
		for(Persone p : passeggeri) {
			
			totaleCosto += p.calcolaTariffa();
		}
		
		return totaleCosto;
	}
	
	
	
	
	public boolean conducentePresente() {
		
		if(passeggeri.size() == 0) {
			
			return false;
		}
		else {
			
			return true;
		}
	
	
	
	}
}