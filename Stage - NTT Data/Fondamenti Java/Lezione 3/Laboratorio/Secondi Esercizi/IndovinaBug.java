package Lezione_03;


public class IndovinaBug { 
    public static void main(String[] args) { 
        int risultato = somma(5, 10); 
        System.out.println("Risultato: " + risultato); 
    } 
   
   
    // PROBLEMA: L'iteratore antecedentemente andava a sommare i numeri senza considerare il 10 
    //SOLUZIONE più banale possibile applicare un + 1 alla b così da poter considerare anche la b
   
    public static int somma(int a, int b) { 
        int risultato = 0; 
        for (int i = a; i < b+1; i++) { 
            risultato += i; 
        } 
        return risultato; 
    } 
}