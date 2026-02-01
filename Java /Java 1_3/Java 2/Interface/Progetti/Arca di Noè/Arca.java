/*
 L’arca viene creata vuota.
 Metodi dell’arca:
 public void salva(Animale a)
 public int getNumeroAnimali()
 public String coro()
 Torna una stringa con tutti i versi concatenati
 public String toString()
 Torna una stringa con tutti i toString() concatenati

Non svolta:
 Opzionale  il metodo salva, può salvare al massimo 2 esemplari per
specie
 */

package eserciziLezione8;
import java.util.ArrayList;
public class Arca {
	
	//In this case we do not create attributes, because we do not almost created the animals
	
	ArrayList<Animale> animali = new ArrayList<> ();
	
	//Going with methods
	
	public void salva(Animale a) {
		animali.add(a);
		System.out.println("È stato salvato: " + a.toString());
	}
	
	public int getNumeroAnimali() {
		return animali.size();
	}
	
	
	public String coro() {
		
		String coro = "";
		for (Animale a : animali) {
			
			coro += a.verso() + " | ";
		}
		return coro;
		

	}
	@Override
	public String toString() {
		
		String elencoAnimali = "";
		
		for (Animale a: animali) {
			
			elencoAnimali += a.toString() + "\n";
			
		}
		return elencoAnimali;
	
		
	}
	
}
