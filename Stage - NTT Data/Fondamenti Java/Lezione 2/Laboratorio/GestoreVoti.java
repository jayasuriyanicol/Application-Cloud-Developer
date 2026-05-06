package Lezione_02;

public class GestoreVoti {

    public static void main(String[] args) {
        
        Double voti1 = 10.0;
        Double voti2 = 8.0;
        Double voti3 = 5.0;
        Double voti4 = 7.0;
        Double voti5 = 9.0;
        
       
       
        
        Double media = (voti1 + voti2 + voti3 + voti4 + voti5) / 5;
        
        
        // Per determinare il MAX e il MIN senza l'ausilio della libreria .math procedo con prendere
        // un voto come riferimento e procedo a confrontarlo uno ad uno con i voti restanti
        
        Double votoAlto = voti1;
        if (voti2 > votoAlto) votoAlto = voti2;
        if (voti3 > votoAlto) votoAlto = voti3;
        if (voti4 > votoAlto) votoAlto = voti4;
        if (voti5 > votoAlto) votoAlto = voti5;
        
      
        Double votoBasso = voti1;
        if (voti2 < votoBasso) votoBasso = voti2;
        if (voti3 < votoBasso) votoBasso = voti3;
        if (voti4 < votoBasso) votoBasso = voti4;
        if (voti5 < votoBasso) votoBasso = voti5;

        String esitoMedia;
        
        if (media < 0 || media > 10) {
        	
            esitoMedia = "VOTO NON VALIDO";
        } else if (media < 6.0) {
        	
            esitoMedia = "INSUFFICIENTE";
        } else if (media < 7.0) {
        	
            esitoMedia = "SUFFICIENTE";
        } else if (media < 9.0) {
        	
            esitoMedia = "BUONO";
        } else {
        	
            esitoMedia = "OTTIMO";
        }
        
        System.out.println("Media: " + media + " (" + esitoMedia + ")");
        System.out.println("Voto più alto: " + votoAlto);
        System.out.println("Voto più basso: " + votoBasso);
    }
}
