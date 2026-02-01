package eserciziLezione13;

public class MainThreadBanca {

	public static void main(String[] args) {
		
	
		Banca banca = new Banca();
		
		System.out.println("SALDO (TOT) BANCA -> " + banca.getPatrimonio());

		
		ThreadPatrimonio monitorPatrimonio = new ThreadPatrimonio(banca);
		monitorPatrimonio.start();
		
		for (int i = 0; i < 10; i++) {
			ThreadConto t = new ThreadConto(i, banca);
			t.start();
		}
		
		System.out.println("|AVVIO PROGRAMMA BANCA THREAD|");
	}
}