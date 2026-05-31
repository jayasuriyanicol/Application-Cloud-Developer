
/*


* Create a class with the main method to work with geometric figures.


* The program currently includes the management of rectangles and circles. Start


* asking the user which figure he wants to create: Rectangle or Circle After


* dimensions are asked: In the case of the rectangle, the user will have to


* type 2 integers (base and height) In the case of the circle, the user


* will only have to type one number (the radius of the circle) Now the program asks


* if you want to know the area or perimeter of the newly created figure. He comes


* calculated and printed only the requested value Finally the user is asked


* if it wants to exit or repeat again, creating a new geometric figure

 Example of using the class:


a first rectangle is born and I attach it to its 'remote control' ret

 Rectangle ret = new Rectangle(10, 5);

a second rectangle is born and I attach it to its 'remote control' ret2

new Rectangle(1, 6);

 int x = 8;
 System.out.println("perimeter is " + ret.calculatePerimeter());
 */

package eserciziLezione4;
import java.util.Scanner;

public class Geometria {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		//Creating all the variables: f -> form input user | o = option for 2p o Perimeter | b = number of base | h = number of height | d = number of radius
		int f = 0;
		int o = 0;
		int b = 0;
		int h = 0;
		double r;
		
		
		//Insert by the user of what form he want to analyze and calculate
		do {
			System.out.println("\nBenvenuto, inserisci una delle seguenti forme\n0 -> Cerchio\n1-> Rettangolo\nLa tua scelta: ");
			f = scan.nextInt();
			
			if (f!= 0 && f != 1) {
				System.out.println("\nATTENZIONE ! Scegli una delle due forme date !");
			}
		} while (f != 0 && f != 1);
		
		
		
		//Case, of Circle option, insertion of r -> radius
		if (f == 0) {
			
			do {
				System.out.println("\nBenvenuto, inserire il raggio del cerchio: ");
				r= scan.nextDouble();
				
				if (r <= 0) {
					System.out.println("\nATTENZIONE ! il numero deve essere INTERO POSITIVO ");
				}
			} while (r <= 0);
			
			
			
			
			//Keep, calling rhe file name 'Cerchio' that have all the methods to calculate the operation: 2p and Perimeter
			Cerchio cerc = new Cerchio(r);
			
	
			do {
				System.out.println("\nScegli una delle opzioni di calcolo qui di seguito:\n 0. PERIMETRO\n1. AREA\nScelta: ");
				o = scan.nextInt();
				
				if (o != 0 && o != 1) {
					System.out.println("\nATTENZIONE ! Scegli una delle due opzioni date !");
				}
			} while (o != 0 && o != 1);
			
			if (o == 0) {
				System.out.println("\nPERIMETRO Cerchio " + cerc.calcolaPerimetro());
			} else {
				System.out.println("\nAREA Cerchio " + cerc.calcolaArea());
			}
		} else {

			
			//Case, of Rectangule option, insertion of b -> base
			do {
				System.out.println("\nBenvenuto, inserire la base del Rettangolo:  ");
				b = scan.nextInt();
				
				if (b <= 0) {
					System.out.println("\nATTENZIONE ! il numero deve essere INTERO POSITIVO ");
				}
			} while (b <= 0);
			
			
			//Same case, of Rectangule option, insertion of h -> height
			do {
				System.out.println("\nBenvenuto, inserire l'altezza del Rettangolo:");
				h = scan.nextInt();
				
				if (h <= 0) {
					System.out.println("\nATTENZIONE ! il numero deve essere INTERO POSITIVO  ");
				}
			} while (h <= 0);
			
			
			
			
			//Keep, calling rhe file name 'Rettangolo' that have all the methods to calculate the operation: 2p and Perimeter
			Rettangolo rett = new Rettangolo(b, h);
			
			
			do {
				System.out.println("\nScegli una delle opzioni di calcolo qui di seguito:\n 0. PERIMETRO\n1. AREA\nScelta: ");
				o = scan.nextInt();
				
				if (o != 0 && o != 1) {
					System.out.println("\nATTENZIONE ! Scegli una delle due opzioni date !");
				}
			} while (o != 0 && o != 1);
			
			if (o == 0) {
				System.out.println("\nPERIMETRO Rettangolo " + rett.calcolaPerimetro());
			} else {
				System.out.println("\nAREA Rettangolo " + rett.calcolaArea());
			}
		}
	}
}