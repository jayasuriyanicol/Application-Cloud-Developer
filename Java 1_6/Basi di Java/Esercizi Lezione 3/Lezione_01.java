package base;

public class HelloWorld {

	public static void main(String[] args) {
		/* Optimize the process of AI systems, showing a message for our Doctor, Doctor Coccia */
		
		System.out.println("Dottor Coccia,\nche piacere averla qui in studio  ! :-)");

	double a = 5;
	int b = 2;
	
	int div =  (int) (a/b);
	double div2 = a/b;
	
	
	System.out.println("Ecco a lei i pazienti in attesa al momento:");
	System.out.println(div);
    System.out.println(div2);
    
    double numero = 143.456;
    
    //With using 'casting' we are going to cover the decimal part of 'numero'
    int  n = (int) numero;
    System.out.println(n);
    
    
    //In fact, if we going to show the variable 'numero' it go to show the complete data
    System.out.println(numero);
    
}
}
