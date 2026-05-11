package Lezione_05;

public class MainScontabile {
	
	
	public static void main(String[] args) {
		
		ProdottoFisico pf = new ProdottoFisico();
		ProdottoDigitale pd = new ProdottoDigitale();
		
		System.out.println(String.format("%.2f",pf.applicaSconto(0.10)));
		System.out.printf("%.2f\n", pd.applicaSconto(0.20));
	}
}
