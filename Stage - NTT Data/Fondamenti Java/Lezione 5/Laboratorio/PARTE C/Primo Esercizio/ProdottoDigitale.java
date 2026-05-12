package Lezione_05;

public class ProdottoDigitale implements Scontabile{

	public ProdottoDigitale() {}
	
	
	@Override
	public Double applicaSconto(double sconto) {
		
		return 15.0 * sconto;
	}
}
