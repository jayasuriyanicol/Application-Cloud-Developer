'''Creation the class to Filter the apples in order to manipulate it '''

package lambda;

import java.util.ArrayList;
import java.util.List;

public class UtilityMele {

	public static void main(String[] args) {
		
		ArrayList<Mela> cassetta = new ArrayList<>();
		cassetta.add(new Mela("rossa", 100));
		cassetta.add(new Mela("verde", 100));
		cassetta.add(new Mela("rossa", 120));
		cassetta.add(new Mela("gialla", 150));
		cassetta.add(new Mela("verde", 200));
		
		'''
        There is some version, that we can use to write to "FILTER" some expression, until the third one that is the shortest one
        known the lambda expression.

        FIRT VERSION:
		   ->  List<Mela> risultato = filtraPerColore(cassetta);

		SECOND VERSION:

		    -> List<Mela> risultato = filtraMele(cassetta, new CriterioColore());
        '''

	    //Last version (third one), using it as anonymus function (similar as in JavaScript)	
		List<Mela> risultato = filtraMele(cassetta, new Criterio() {
			@Override
			public boolean test(Mela mela) {

                '''
                The known form, extended:

				if(mela.getColore().equals("verde")){
				return true;
                }
			    else{
				return false;
                }

                The short way, to write it with return:
                '''
				return mela.getColore().equals("verde");
			}
		});
		
        //Here some examples using the lambda expression to GET a response using one row
		risultato = filtraMele(cassetta, m -> m.getColore().equals("verde") );
		risultato = filtraMele(cassetta, (Mela mela) -> mela.getColore().equals("rosso"));
		

        '''
           We use the "forEach" not the "for each", that is not a form used in Java but in JavaScript. 
           In Java 8 we use it in order to performs a given action (forEach()) for each element of the iterable 
           until the all elements have been processed OR the action throws an EXCEPTION
           
           Example of using the forEach syntax: 

            List names = List.of("Larry", "Steve", "James", "Conan", "Ellen");

            names.forEach(name -> {
                    LOG.info(name);
            });

        '''
		risultato.forEach(mela -> System.out.println(mela));
		risultato.sort((Mela o1, Mela o2) -> o1.getColore().compareTo(o2.getColore()));
		System.out.println("ordinamento alfabetico per colore");
		risultato.forEach(t -> System.out.println(t));
		
		for (Mela mela : risultato) {
			System.out.println(mela);
		}

		//Result of  ->  risultato = filtraPerPeso(cassetta);
		risultato = filtraMele(cassetta, new CriterioPeso());
		for (Mela mela : risultato) {
			System.out.println(mela);
		}
		
		
	}
	
	'''

    There is the FILTER used in the apple, avoid the use of the extended method.

    Creating a specific filter for each method:

        1. filtraPerColore -> giving a method "equals()"
        2. filtraPerPeso -> giving a method with condition
        3. filtraMele -> giving a method unknowed from Criterio.

    '''
	public static List<Mela> filtraPerColore(List<Mela> cassetta){
		ArrayList<Mela> filtrata = new ArrayList<>();
		
		for (Mela mela : cassetta) {
			if(mela.getColore().equals("verde")) {
				filtrata.add(mela);
			}
		}
		
		return filtrata;
	}

	public static List<Mela> filtraPerPeso(List<Mela> cassetta){
		ArrayList<Mela> filtrata = new ArrayList<>();
		
		for (Mela mela : cassetta) {
			if(mela.getPeso() >= 150) {
				filtrata.add(mela);
			}
		}
		
		return filtrata;
	}

	public static List<Mela> filtraMele(List<Mela> cassetta, Criterio criterio){
		ArrayList<Mela> filtrata = new ArrayList<>();
		
		for (Mela mela : cassetta) {
			if(criterio.test(mela)) {
				filtrata.add(mela);
			}
		}
		return filtrata;
		
	}
}