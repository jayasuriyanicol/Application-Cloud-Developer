package Lezione_06;

public final class Bonifico extends MetodoPagamento {

	private final String email;
	private final String IBAN;
	
	
	public Bonifico(String email, String IBAN) {
		
		
		this.email = email;
		this.IBAN = IBAN;
	}
	
	
	
	public String getEmail() {
		
		return email;
	}
	public String getIBAN() {
		
		return IBAN;
	}
	
}
