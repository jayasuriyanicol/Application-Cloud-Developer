package eserciziLezione13;

import java.util.ArrayList;

public class Banca {
	
	
	final static ArrayList<Integer> listaContiCorrenti = new ArrayList<>(10);
	
	public Banca() {
		
		super();
	
	

		for (int i = 0; i < 10; i++) {
			listaContiCorrenti.add(5000);
		}
	}

	static void bonifico(int contoOrdinante, int contoBeneficiario,int importo) throws Error, IndexOutOfBoundsException {
		
		if (listaContiCorrenti.get(contoOrdinante) - importo < 0) {
			
			throw new Error("ATTENZIONE ! La disponibilità nel conto è insufficiente !");
			
		}
		else {
		listaContiCorrenti.set(contoOrdinante, listaContiCorrenti.get(contoOrdinante) - importo);
		listaContiCorrenti.set(contoBeneficiario, listaContiCorrenti.get(contoBeneficiario) + importo);
		}
	}

	int getPatrimonio() {
		
		int tot=0;
		for (Integer conto : listaContiCorrenti)
			tot += conto;

		return tot;
	}
}
	
	
	