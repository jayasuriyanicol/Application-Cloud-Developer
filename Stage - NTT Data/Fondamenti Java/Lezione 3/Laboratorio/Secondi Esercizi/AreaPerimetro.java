package Lezione_03;

public class AreaPerimetro {

	
	public static void main(String[] args) {
		
		System.out.println("AREA QUADRATO: "+ areaQuadrato(2));
		System.out.println("AREA RETTANGOLO: "+ areaRettangolo(12, 3));
		System.out.println("AREA CERCHIO: " + areaCerchio(3));
	
		
		
		//OVERLOADING dei metodi di calcolo dell'AREA: Quadrato e Rettangolo
		System.out.println("OVER AREA QUADRATO: " + area(2));
		System.out.println("OVER AREA RETTANGOLO : " + area(13,4));
		
		
		//BONUS: Calcolo dei PERIMETRI
		System.out.println("PERIMETRO QUADRATO: "+ perimetroQuadrato(2.9));
		System.out.println("PERIMETRO RETTANGOLO: "+ perimetroCerchio(14.3));
		System.out.println("PERIMETRO CERCHIO: " + perimetroCerchio(3.5));
	
		
	}
	
	
	public static double areaQuadrato(double lato) {
		
		return lato*lato;
		
	}
	
	public static double areaRettangolo(double base, double altezza) {
		
		return base * altezza;
		
	}
	
	public static double areaCerchio(double raggio) {
		
		return 3.14 * (raggio*raggio);
		
	}
	
	//Overloading richiesti per il riuso per il calcolo dell'area di rettangolo e quadrato
	public static double area(double lato) {
		
	   return areaQuadrato(lato);
		
	}
	
	public static double area(double base, double altezza) {
		
		return areaRettangolo(base, altezza);
		
	}
	
	//Calcolo PERIMETRO 
    public static double perimetroQuadrato(double lato) {
        return lato * 4;
    }

    public static double perimetroRettangolo(double base, double altezza) {
        return (base + altezza) * 2;
    }

    public static double perimetroCerchio(double raggio) {
        return 2 * 3.14 * raggio;
    }

	}


