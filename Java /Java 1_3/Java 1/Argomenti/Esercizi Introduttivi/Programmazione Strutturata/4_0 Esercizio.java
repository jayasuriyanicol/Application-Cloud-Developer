/*Exercise number 4
  
  Given two points of Cartesian Plan A(x1,y1) and B(x2,y2).
  
  Consider the parallelogram that it is obtained by adding point C (x1, y2) and point D (x2, y1) and joining the 4 points in the order A, C, B, D.
  Write a program that reads the values ​​x1, y1 and x2, y2 as input and checks whether it can be formed into a square or a generic rectangle.
  Print this result and, based on the resulting figure, calculate and print the 2P and area of ​​the figure.
  Note: Use the Math library functions to calculate powers, square roots, etc.
 
  */

package corsoBase;

import java.util.Scanner;

public class Esercizio4_0 {

	public static void main(String[] args) {
		
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
	    double base;
	    double altezza;
	    double perimetro;
	    double area;

	 
	  
		
		Scanner scanner  = new Scanner(System.in);
		
		System.out.println("Inserisci il punto x1 delle coordinate di A: ");
		x1 = scanner.nextInt();
		
		System.out.println("Inserisci il punto y1 delle coordinate di A: ");
		y1 = scanner.nextInt();
		
		
		System.out.println("Inserisci il punto di x2 delle coordinate di B: ");
		x2 = scanner.nextInt();
		
		
		System.out.println("Inserisci il punto di y2 delle coordinate di B: ");
		y2 = scanner.nextInt();
		
		
	   scanner.close();
	   
	   
	   base = Math.abs(x2 - x1);
       altezza = Math.abs(y2 - y1);
       
       String tipoFigura;
      
       
       if (base == 0 || altezza == 0) {
           tipoFigura = "NON UNA FIGURA VALIDA (Punti coincidenti o allineati)";
           System.out.println("\nRisultato: " + tipoFigura);
           return;
       } 
       
      
       if (base == altezza) {
           tipoFigura = "QUADRATO";
       } else {
           tipoFigura = "RETTANGOLO GENERICO";
       }
       
    
       perimetro = 2 * (base + altezza);
       

       area = base * altezza;
       
       
       System.out.println("\n-----------------------------------------------------");
       System.out.println("Risultati dell'Analisi Geometrica");
       System.out.println("-----------------------------------------------------");
       System.out.println("Punto A: (" + x1 + ", " + y1 + ")");
       System.out.println("Punto B: (" + x2 + ", " + y2 + ")");
       System.out.println("Punti derivati: C(" + x1 + ", " + y2 + "), D(" + x2 + ", " + y1 + ")");
       System.out.println("Tipo di Figura Formata: " + tipoFigura);
       System.out.println("-----------------------------------------------------");
       System.out.printf("Lunghezza Base (b): %.2f\n", base);
       System.out.printf("Lunghezza Altezza (h): %.2f\n", altezza);
       System.out.printf("Perimetro (2P): %.2f\n", perimetro);
       System.out.printf("Area: %.2f\n", area);
       System.out.println("-----------------------------------------------------");
	}
	
		
		
		

	}

