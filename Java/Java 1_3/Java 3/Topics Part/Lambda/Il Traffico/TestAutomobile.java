'''
Write the class with the main command to set the following criteria, using lambda syntax:

Only Fiat cars are allowed to circulate

Only cars with even license plates are allowed to circulate

Only cars with odd license plates are allowed to circulate

'''

package eserciziLezione12;
import java.util.ArrayList;
import java.util.List;
import eserciziLezione12.Automobile;

@SuppressWarnings("unused")
public class TestAutomobile {

	public static void main(String[] args) {
		
		List<Automobile> listaMacchine = new ArrayList<Automobile>();
		
		Automobile primaAuto = new Automobile("Fiat", "Panda Cross", 2, true);
		Automobile secondaAuto = new Automobile("Renault", "Australe",3,false);
		Automobile terzaAuto = new Automobile("Citroen", "C5 Hybrid", 8,true);
		
		listaMacchine.add(primaAuto);
		listaMacchine.add(secondaAuto);
		listaMacchine.add(terzaAuto);
		
		
		Object firstTest = Automobile.filtroAutomobile(listaMacchine,(Automobile a) -> a.getMarca() == "Fiat");
		Object secondTest =Automobile.filtroAutomobile(listaMacchine,(Automobile a) -> a.getTarga()%2 == 0);
		Object thirdTest =Automobile.filtroAutomobile(listaMacchine, (Automobile a)-> a.getTarga()%2 !=0);

		System.out.println("1. circolano solo le auto di marca Fiat\n" + firstTest);
		System.out.println("\n\n2. circolano solo le auto con targhe pari\n" + secondTest);
		System.out.println("\n\n3. circolano solo le auto con targhe dispari\n" + thirdTest);

	}

}
