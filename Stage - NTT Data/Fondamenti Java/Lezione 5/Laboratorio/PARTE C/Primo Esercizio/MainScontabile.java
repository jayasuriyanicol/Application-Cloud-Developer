package Lezione_05;

public class MainScontabile {
	
	
	public static void main(String[] args) {
		
		ProdottoFisico pf = new ProdottoFisico();
		ProdottoDigitale pd = new ProdottoDigitale();
		
		// ? Here we using a format method, the first one is calling the String.format
		// ? then in the second one we gonna apply the printf method, with a simple format
		System.out.println(String.format("%.2f",pf.applicaSconto(0.10)));
		System.out.printf("%.2f\n", pd.applicaSconto(0.20));
	}
}
