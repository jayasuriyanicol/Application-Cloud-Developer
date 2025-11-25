/*Exercise number 2 (summation)
  Write the program that read two integer numbers n>0 and k>0 and print out the result of summation -> k + k2+ k3+...+ k_n.*/


package corsoBase;
import java.util.Scanner;
public class Esercizio2_0 {
	public static void main(String[] args) {
		
		int n =  0;
		int k =  0;
		int risultato = 0;
		
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Inserisci il primo numero (n):");
		        n = scanner.nextInt();

		        System.out.println("Inserisci il secondo numero (k):");
		        k = scanner.nextInt();
		        
		        scanner.close();

		        risultato = calcolaSommatoria(n, k);

		        System.out.println("La sommatoria dei numeri tra " + n + " e " + k + " (inclusi) è: " + risultato);
		    }




public static int calcolaSommatoria(int n, int k) {
    int somma = 0;
   
    int min = Math.min(n, k);
    int max = Math.max(n, k);


    for (int i = min; i <= max; i++) {
        somma += i; 
    }

    return somma;
}
}
