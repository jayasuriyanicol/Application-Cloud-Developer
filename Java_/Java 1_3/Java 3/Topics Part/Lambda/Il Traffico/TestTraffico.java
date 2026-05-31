'''

Then write a class with the main that, after generating a
Traffic object, determines which cars are allowed to circulate based on these criteria:
When the CO2 level in the air exceeds the limit of 700, only Euro 5 cars will be allowed to
circulate.

When the number of cars exceeds 10,000, measures will be triggered that
use alternating license plates: odd or even, the opposite of the previous ordinance.
(value stored in the Traffic class)

'''
package eserciziLezione12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestTraffico {

    public static void main(String[] args) {
        Random r = new Random();
        
      
        int dimensioneCasuale = r.nextInt(1, 21);
        List<Traffico> automobili = new ArrayList<>();
        
        for (int i = 0; i < dimensioneCasuale; i++) {
       
            automobili.add(Traffico.randomVehicle());
        }

        System.out.println("\n\nTOTALE VEICOLI PRESENTI NEL TRAFFICO -> " + automobili.size());
        
        for (Traffico t : automobili) {
           
            System.out.println("\n\nRIEPILOGO VEICOLO | " + t.getTarga() + " |");
            System.out.println("TARGA: " + t.getTarga());
            System.out.println("MARCA: " + t.getMarca());
            System.out.println("MODELLO: " + t.getModello());
            System.out.println("Livello CO2: " + t.getC02() + " ppm"); 
            System.out.println("Prima Ordinanza: " + t.getPrimaOrdinanza()); 
            System.out.println("Ordinanza Attuale: " + t.getOrdinanzaAttuale()); 
            System.out.println("Euro 5: " + t.geteuro5()); 
        }
        
        
        System.out.println("\n\nCIRCOLAZIONE CONSENTITA VEICOLI");
        
        for (Traffico t : automobili) {
            if (t.getC02() > 700) {
                if (t.geteuro5()) {
                    System.out.println("Auto " + t.getTarga() + ": CIRCOLA (Euro5 con CO2 alto)");
                } else {
                    System.out.println("Auto " + t.getTarga() + ": BLOCCATA (Non Euro5 con CO2 > 700)");
                }
            }
        }
    }
}