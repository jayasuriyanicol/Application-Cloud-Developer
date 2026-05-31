package eserciziLezione8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class testScatoleCinesi {
	
	public static void main(String args[]) {
		
		Box boxGrande = new Box(20,30,40);
		Box boxGrande2 = new Box (30,20,40);
		Box boxPiccola = new Box(10,10,50);
		Box boxPiccola2 = new Box(10,10,30);
		
		
	
	
	System.out.println("SCATOLA GRANDE UGUALE ALLA SCATOLA GRANDE2 ? -> " + boxGrande.equals(boxGrande2));
	System.out.println("SCATOLA PICCOLA UGUALE ALLA PICCOLA GRANDE2 ? -> " + boxPiccola.equals(boxPiccola2));
	System.out.println("VOLUME SCATOLA GRANDE -> " + boxGrande.getVolume());
	System.out.println("VOLUME SCATOLA GRANDE2 -> " +boxGrande2.getVolume());
	System.out.println("VOLUME SCATOLA PICCOLA -> "+ boxPiccola.getVolume());
	System.out.println("VOLUME SCATOLA PICCOLA2 -> "+boxPiccola2.getVolume());
	
	
	System.out.println("VOLUME SCATOLA GRANDE UGUALE A QUELLA DI GRANDE2 ? -> " + boxGrande.compareTo(boxGrande2));
	System.out.println("VOLUME SCATOLA PICCOLA UGUALE A QUELLA DI PICCOLA2 ? -> " + boxPiccola.compareTo(boxPiccola2));
   
	
	System.out.println("VERIFICHIAMO CHE LA SCATOLA PICCOLA ENTRI NELLA PIÙ GRANDE -> " + boxPiccola.fitsIn(boxGrande));
	System.out.println("VERIFICHIAMO CHE LA SCATOLA PICCOLA2 ENTRI NELLA PIÙ GRANDE2 -> " + boxPiccola2.fitsIn(boxGrande2));
	
	
	
	System.out.println("| TEST COMPARAZIONE ALTEZZA BOX |");
	
	List<Box> listaBox = new ArrayList<>();
	
	listaBox.add(boxGrande);
	listaBox.add(boxGrande2);
	listaBox.add(boxPiccola);
	listaBox.add(boxPiccola2);
	
	
	Collections.sort(listaBox, new AltezzaComparator());
	
	listaBox.sort(new AltezzaComparator());
	
	for(Box b: listaBox) {
		
		System.out.println(b);
	}
	
	
	
}
}