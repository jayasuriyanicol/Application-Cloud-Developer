package Lezione_03;

public class Calcolatrice {

    public static void main(String[] args) {
    
        System.out.println("Somma (int): " + somma(10, 5));
        System.out.println("Somma (double): " + somma(10.5, 11.9));
        System.out.println("Somma (3 int): " + somma(1, 2, 3));

        
        System.out.println("Sottrazione (int): " + sottrazione(10, 5));
        System.out.println("Sottrazione (double): " + sottrazione(11.9, 10.5));
        System.out.println("Sottrazione (3 int): " + sottrazione(3, 2, 1));

        System.out.println("Moltiplicazione (int): " + moltiplicazione(10, 5));
        System.out.println("Moltiplicazione (double): " + moltiplicazione(10.0, 5.0));
        System.out.println("Moltiplicazione (3 int): " + moltiplicazione(3, 2, 1));
    }

 
    public static int somma(int a, int b) { return a + b; }
    public static double somma(double a, double b) { return a + b; }
    public static int somma(int a, int b, int c) { return a + b + c; }

   
    public static int sottrazione(int a, int b) { return a - b; }
    public static double sottrazione(double a, double b) { return a - b; }
    public static int sottrazione(int a, int b, int c) { return a - b - c; }

    
    public static int moltiplicazione(int a, int b) { return a * b; }
    public static double moltiplicazione(double a, double b) { return a * b; }
    public static int moltiplicazione(int a, int b, int c) { return a * b * c; }
}
