package eserciziLezione13;

public class ThreadClienti extends Thread {
	
	
	private String nome;
	private int numeroPostiRichiesti;
	private Assegnatore assegnatore;
	
	
	public ThreadClienti(String nome, int numeroPostiRichiesti, Assegnatore assegnatore) {
		this.nome = nome;
		this.numeroPostiRichiesti = numeroPostiRichiesti;
		this.assegnatore = assegnatore;
	}


	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumeroPostiRichiesti(int numeroPostiRichiesti) {
		this.numeroPostiRichiesti = numeroPostiRichiesti;
	}

	
	public void setAssegnatore(Assegnatore assegnatore) {
		this.assegnatore = assegnatore;
	}
	
	
	
	public String getNome() {
		return nome;
	}


	

	public int getNumeroPostiRichiesti() {
		return numeroPostiRichiesti;
	}


	

	public Assegnatore getAssegnatore() {
		return assegnatore;
	}

	
	

	public void run() {
		
		try {
			
			assegnatore.assegnaPosti(nome, numeroPostiRichiesti);
			System.out.println("POSTI PRENOTATI DA " + nome + " -> POSTI: " + numeroPostiRichiesti);
		}
		catch(PostiNonDispException e) {
			
			System.out.println("ERRORE ! cliente " + nome + " ci dispiace informarla che non è possibile proseguire con la sua richiesta.\nCODICE ERRORE: " + e.getMessage());
		}
		
		
	}
	
	}