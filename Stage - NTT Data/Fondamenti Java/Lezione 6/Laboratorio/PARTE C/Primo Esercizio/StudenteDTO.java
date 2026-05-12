package Lezione_06;

public record StudenteDTO(String nome,String cognome,Double media) {
	
	public StudenteDTO{
		
		if(media == null || media < 0 || media > 30) {
			
			throw new IllegalArgumentException("ATTENZIONE ! Non è possibile inserire una media null o maggiore trenta o inferiore a zero ");
			
		}
	
	}
	
	public Boolean isPromosso() {
		
		if(media >= 18) {
			
			return true;
		}
		
		System.out.println("ATTENZIONE ! La media è sotto il 18 sei BOCCIATO !");
		return false;
		
	}

}
