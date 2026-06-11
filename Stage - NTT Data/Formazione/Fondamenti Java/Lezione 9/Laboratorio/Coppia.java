package Lezione_09;

import java.util.List;

public class Coppia<A,B> {
	
	private A primo;
	private B secondo;
	
	
	public Coppia(A primo, B secondo) {
		
		this.primo = primo;
		this.secondo = secondo;
	}
	
	
	public static <T> void swap(T[] array,int i, int j) {
		
		T a = array[i];
		
		array[i] = array[j];
		array[j]= a;
		
	}
	
	
	public static Double sommaTutti(List<? extends Number> lista){
	
	   Double somma = 0.0;
	   
	   for(Number i : lista) {
		   
		   somma += i.doubleValue();
	   }
	   
	   return somma;
		
	}
	
	
	public static void riempi(List<? super Integer> lista,int quanti) {
	
		
		for(int i=1; i<= quanti; i++) {
			
			lista.add(i);
			
		}
			
			
		}
	
	
	


	public A getPrimo() {
		return primo;
	}


	public void setPrimo(A primo) {
		this.primo = primo;
	}


	

	public B getSecondo() {
		return secondo;
	}


	public void setSecondo(B secondo) {
		this.secondo = secondo;
	}
	
	
	@Override
	public String toString() {
		return "Coppia ->\nPRIMO: " + primo + "\nSECONDO: " + secondo;
	}
	
	
	

	
	
	
	
	

}
