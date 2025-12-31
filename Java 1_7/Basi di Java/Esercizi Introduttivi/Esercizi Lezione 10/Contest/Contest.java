package eserciziLezione10;
import java.util.LinkedList;
import eserciziLezione10.Eccezioni.*;

public class Contest {
	
	
	private LinkedList<Performer> listaIscrizioni = new LinkedList<>();
	
	
	
	public void signUp(Performer nome) throws PerformerDuplicatoException{
		
		
		if (listaIscrizioni.contains(nome)) {
				
				
				throw new PerformerDuplicatoException(nome.getNome());
			}
			
			else {
				
				listaIscrizioni.add(nome);
			}
		
		}
		
	
	
	
	public void registerVoteFor(Performer nome) throws PerformerInesistenteException{
		
		int index = listaIscrizioni.indexOf(nome);
		
		if (index == -1) {
			
			
				
				
				throw new PerformerInesistenteException("ATTENZIONE ! il PERFORMER -> " + nome.getNome() + "non risulta ISCRITTO NELLA GARA");
			}
			
			else {
				
				listaIscrizioni.get(index).incrementaVoti();
				
			}
	}
	
	
	
		
	public Performer getWinner() {
		
		if (listaIscrizioni.isEmpty()) {
			
			return null;
		
		}
		
		else {
			
			Performer vincitore = listaIscrizioni.getFirst()
;
			for(Performer p : listaIscrizioni) {
				
				if(p.getVoti()> vincitore.getVoti()) {
					
					vincitore = p;
			
		}
				

		
		
		
	}
			
			return vincitore;
		
		
		
		
}
		
	
	
}
	
	@Override
    public String toString() {
        return listaIscrizioni.toString();
    }
	



}
