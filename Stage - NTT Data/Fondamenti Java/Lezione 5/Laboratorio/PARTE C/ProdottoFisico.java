package Lezione_05;

public class ProdottoFisico implements Scontabile {

	
	public ProdottoFisico() {}
	
	
	@Override
	public Double applicaSconto(double sconto) {
		
		return 12.0*sconto;
	}
}
