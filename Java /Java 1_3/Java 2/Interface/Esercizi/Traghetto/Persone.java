package eserciziLezione9;

import java.util.ArrayList;

public class Persone implements Tariffabile{

	public String nome;
	public String cognome;
	ArrayList<Persone> personeBordo = new ArrayList <>();
	
	public Persone(String nome, String cognome) {
		
		this.nome = nome;
		this.cognome = cognome;
	}
	
	
    @Override
    public double calcolaTariffa(){
    	
    	return 2.5;
    }
	
	
}
