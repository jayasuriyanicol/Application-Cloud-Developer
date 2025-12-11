package eserciziLezione8;

public class MainArca {

	public static void main(String[] args) {
		
		System.out.println("\nARCA CREATA");
		
		Arca arca = new Arca();
			
		Cane c1 = new Cane();
		Cane c3 = new Cane();
		Canarino c2 = new Canarino();
		
		
		System.out.println("\nGLI ANIMALI SONO STATI SALVATI");
		arca.salva(c1);
		arca.salva(c2);
		arca.salva(c3);
		
		
		
		System.out.println("\nCONTEGGIO ANIMALI");
		
		int numeroAnimali = arca.getNumeroAnimali();
		
		System.out.println("Sono stati salvati : " + numeroAnimali + " Animali");
		
		
		
		System.out.println("\nANTIAMO TUTTI IN CORO SULL'ARCA");
		
		String cantaCoro = arca.coro();
		
		System.out.println("Tutti cantano il coro: " + cantaCoro);
		
		
		System.out.println("\nAPPELLO ANIMALI");
		
		System.out.println("\nAnimali presenti all'APPELLO: " + arca.toString());
		
	

	}

}
