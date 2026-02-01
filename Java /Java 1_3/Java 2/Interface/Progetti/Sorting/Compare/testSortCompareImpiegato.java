package corsoBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Test_Sort_Impiegato {
	public static void main(String[] args) {
		ArrayList<Impiegato> listaImp = new ArrayList<>();
		listaImp.add(new Impiegato("Giacomo Coccodrillini", 1500, new Date()));
		listaImp.add(new Impiegato("David Divano", 2100, new Date(120, 1, 1)));
		listaImp.add(new Impiegato("Mario Mela", 1850, new Date(125, 1, 1)));
		listaImp.add(new Impiegato("Ferdinando Mortadellini", 1620, new Date(123, 1, 1)));
		listaImp.add(new Impiegato("Drago Anonimo", 1315, new Date(114, 1, 1)));
		listaImp.add(new Impiegato("Anna Bianchi", 1105, new Date(118, 1, 1)));
		
		Collections.sort(listaImp);
		
		for (Impiegato imp : listaImp) {
			System.out.print(imp.getNome() + " | ");
		}
		
		System.out.println();
		Collections.sort(listaImp, new CompareByStipendio());
		for (Impiegato imp : listaImp) {
			System.out.print(imp.getNome() + ", Stipendio : " + imp.getSalario() + " | ");
		}
		
		System.out.println();
		Collections.sort(listaImp, new CompareByDate());
		for (Impiegato imp : listaImp) {
			System.out.print(imp.getNome() + ", Anno Assunzione : " + (imp.getDataAssunzione().getYear() + 1900) + " | ");
		}
	}
}