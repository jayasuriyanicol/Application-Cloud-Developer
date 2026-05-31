package eserciziLezione11;

@SuppressWarnings("serial")
public class MatricolaException extends Exception {
	
	
	public MatricolaException() {
		
		super();
		
	}
	
	
	public  MatricolaException(String motivazione) {
		
		super(motivazione);
	}
}
