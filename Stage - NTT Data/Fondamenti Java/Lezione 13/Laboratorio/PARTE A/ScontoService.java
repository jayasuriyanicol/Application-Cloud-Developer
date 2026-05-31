
public class ScontoService {

	public double applicaSconto(double prezzo, double percentuale) {
		
		if (prezzo < 0)
			
			throw new IllegalArgumentException("ATTENZIONE ! Il prezzo non valido");
		
		if (percentuale < 0 || percentuale > 1)
			
			throw new IllegalArgumentException("ATTENZIONE ! La percentuale non valida");
		
		return prezzo - (prezzo * percentuale);
	}

}
