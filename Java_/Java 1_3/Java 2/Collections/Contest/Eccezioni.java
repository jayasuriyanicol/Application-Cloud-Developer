package eserciziLezione10;

public class Eccezioni {
	
	
	public static class PerformerDuplicatoException extends Exception {
		
		private static final long serialVersionUID = 1L;

		public PerformerDuplicatoException(String messaggio) {
			
			super(messaggio);
		}
	

	}
	
	
	public static class PerformerInesistenteException extends Exception {
	    private static final long serialVersionUID = 1L;

		public PerformerInesistenteException(String message) {
	        super(message);
	    }
	}

}
