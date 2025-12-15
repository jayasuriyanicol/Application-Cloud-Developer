package eserciziLezione9;

//We adding the @SuppressWarnings("serial") to evitate the warning ID on the CODE.
@SuppressWarnings("serial")
public class CodaVuota extends Exception {
	
	
	
	//In this, manner I go to call the super class of Execption as Execption
	public CodaVuota() {
		
		super();
		
	}
	
	
	public CodaVuota (String motivazione) {
		
		super(motivazione);
	}


}
