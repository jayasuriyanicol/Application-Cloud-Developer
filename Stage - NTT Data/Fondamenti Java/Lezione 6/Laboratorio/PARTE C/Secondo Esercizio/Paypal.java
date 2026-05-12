package Lezione_06;

public final class Paypal extends MetodoPagamento{
	
	private final String numeroCarta;
	private final String email;
	
	
	
	public Paypal(String numeroCarta, String email) {
		
		this.numeroCarta = numeroCarta;
		this.email = email;
		
	}
	
	
	public String getNumeroCarta() {
		
		return numeroCarta;
	}
	
	public String getEmail() {
		
		return email;
	}
	
	
	
	
	
	
}
