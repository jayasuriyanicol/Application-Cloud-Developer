/* 
 Exercise #6
Read an integer n > 0 from the keyboard and perform the prime factorization, printing all divisors.
Example: Enter 12, and the prime factorization would be 22 * ​​3, or 4 * 3.
The program should print 2 * 2 * 3.
If the number is prime, the program will print "The number is prime.
*/

package corsoBase;

import java.util.Scanner;

public class Esercizio6_0 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("Inserisci un numero: ");

        do {
            n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Inserire un numero > 0");
            }

        } while (n <= 0);
        
        //I used this form to compare the n with him self, if is true is a FIRST NUMBER
        int numeroInserito = n;

        System.out.println("\nHai inserito " + n + ": ");

        //Special Case, because  1 <= n <= 2 is a FIRST NUMBER
        
        if (n== 1 || n == 2) {
            System.out.println("\nIl numero " + n + " è un numero primo");
        } else {
         
            while (n > 1) {
                for (int cont = 2; cont <= n; cont++) {
                    
                    
                    if (n % cont == 0) {

                        if (cont == numeroInserito) {
                            System.out.println("\nIl numero " + numeroInserito + " è un numero primo");
                            n = 1; 
                            break; 
                        }

                        
                        System.out.print(cont);
                        
                      
                        n /= cont;

                        
                        if (n > 1) {
                            System.out.print(" * ");
                        }
                        
                     
                        break; 
                    }
                }
            }
        }
        scanner.close();
    }
}