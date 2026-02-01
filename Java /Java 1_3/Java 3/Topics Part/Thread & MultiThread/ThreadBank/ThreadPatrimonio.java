package eserciziLezione13;

public class ThreadPatrimonio extends Thread {


	private final Banca banca;

	public ThreadPatrimonio(Banca banca) {
		super();
		this.banca = banca;
	}

	public Banca getBank() {
		return banca;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				
				System.out.println("\nPatrimonio BANCA -> " + banca.getPatrimonio());
				System.out.println("\nConti Correnti LISTA -> " + Banca.listaContiCorrenti);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
