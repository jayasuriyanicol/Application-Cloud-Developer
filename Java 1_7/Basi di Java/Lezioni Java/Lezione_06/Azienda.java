package corsoBase;
import java.util.ArrayList;

public class Azienda {
	
	
	private String nome;
	
	//Creation of arrayList of class Impiegato, named as 'elencoDipendenti'
	private  ArrayList<Impiegato> elencoDipendenti;
	
	
	/*Using also this form and avoid the recall in the costructor:
	    -> private ArrayList<Impiegato> elencoDipendent = new ArrayList<Impiegato>();
	 */
	
	//Generate only 'Azienda' not the new ArrayList, do not generate it automatically
	public Azienda(String nome) {
		
		this.nome = nome;
		
		//Increment the 'nome' to the elencoDipendenti. We can also eliminate the type 'Impiegato' the short form
		this.elencoDipendenti = new ArrayList<Impiegato>();
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


		
	public ArrayList<Impiegato> getElencoDipendenti() {
		return elencoDipendenti;
	}


	@Override
	public String toString() {
		
		/*
		 In order to create a good estetic sting, we avoid this form (for now)
		  -> AVOID IT : return "Azienda [nome=" + nome + ", elencoDipendenti=" + elencoDipendenti.toString() + "]";
		*/  
		
		
		String s  = "Nome Azienda: " + nome + "\n";
		
		//For the arrayList we prefer to use a for each, but not usefull in the normal array
		
		for (Impiegato impiegato : elencoDipendenti) {
			
			s += impiegato.toString() + "\n";
		}
		
		return s;

	}
	
	
	
	//Creation of variable impiegato as Impiegato object, adding it to the arrayList
	public void assume(Impiegato impiegato) {
		
		this.elencoDipendenti.add(impiegato);
		
	}
	
	
	public void incrementoSalario(double aumento) {
		
		
		/*Using with classic for
		for(int i = 0; i  < elencoDipendenti.size(); i++) {
			
			elencoDipendenti.get(i).incrSalario(aumento);
		*/
		
		for (Impiegato impiegato : elencoDipendenti) {
			
			
			impiegato.incrSalario(aumento);
			
		}
			
			
		}
	}
