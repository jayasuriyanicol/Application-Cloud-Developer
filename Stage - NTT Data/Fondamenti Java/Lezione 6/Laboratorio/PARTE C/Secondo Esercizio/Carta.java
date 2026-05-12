package Lezione_06;

public final class Carta extends MetodoPagamento {
	
	private final String numeroCarta;
	private final String email;
	private final String IBAN;
	
	
	public Carta(String numeroCarta, String email, String IBAN) {
		
		this.numeroCarta = numeroCarta;
		this.email = email;
		this.IBAN = IBAN;
	}
	
	
	public String getNumeroCarta() {
		
		return numeroCarta;
	}
	
	public String getEmail() {
		
		return email;
	}
	public String getIBAN() {
		
		return IBAN;
	}
	
	
	
	
	
}
