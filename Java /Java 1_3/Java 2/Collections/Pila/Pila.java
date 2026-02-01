/*
 
 Create a Stack class that models a LIFO structure
(use LinkedList)
– Suggested methods:
• add(Object ob)
• remove(Object ob)
with optional exception handling for the empty stack


 */

package eserciziLezione10;
import java.util.LinkedList;

public class Pila<E> {
	

	private LinkedList<E> listaElementi = new LinkedList<>();
	
	
	public Pila() {
		
	
	}



	public void addOb( E ob) {
		
		listaElementi.addLast(ob);
			
	}
	

	
	
	public void removeOb() {
		
		
		listaElementi.removeLast();		
	}



	@Override
	public String toString() {
		return "Pila [listaElementi=" + listaElementi ;
	}

	
	
}
