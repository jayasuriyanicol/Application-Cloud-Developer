/*Exercise number 2 (summation)
  Write the program that read two integer numbers n>0 and k>0 and print out the result of summation -> k + k2+ k3+...+ k_n.*/


package corsoBase;
import java.util.Scanner;

public class Esercizio2_0 {
    public static void main(String[] args) {
        
        int n = 0;
        int k = 0;
        int potenza = 1; 
        int risultato = 0;
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci l'esponente massimo (n):");
        n = scanner.nextInt();

        System.out.println("Inserisci la base (k):");
        k = scanner.nextInt();
        
        scanner.close();
        
        
        for (int i = 1; i <= n; i++) {
            
            
            potenza *= k;
            
            risultato += potenza; 
        }
        
     
		        System.out.println("La sommatoria dei numeri tra " + n + " e " + k + " (inclusi) è: " + risultato);
		    }



}