package eserciziLezione11;
import java.util.HashMap;
import java.io.*;
import java.util.*;


public class GestioneTabella {
	
	

	private File file;
	
	public GestioneTabellaTODO(){
		file = new File("tabella_studenti.txt");
	}
	
	@SuppressWarnings("unused")
	private void aggiornaTabella(HashMap<Integer, Studente> tab) {
		try {
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(tab);
			oos.close();
		} catch (FileNotFoundException e) {				
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@SuppressWarnings("unchecked")
	protected HashMap<Integer, Studente> leggiTabella() throws TabellaInesistenteException{
		try {
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fin);
		
			HashMap<Integer, Studente> tabella = (HashMap<Integer, Studente>) ois.readObject();
			ois.close();
			return tabella;
		}
		catch (Exception e) {
			throw new TabellaInesistenteException("ATTENZIONE ! non può esistere una tabella vuota ! CODICE ERRORE: " + e.getMessage());
		}
	}

	
	
	
	public void inserisci(Studente studente)  throws MatricolaException{
		
		
		 HashMap<Integer,Studente> tabella;
		
		
		try {
			
			tabella = leggiTabella();
			
		}
		catch(TabellaInesistenteException e) {
			
			
			tabella = new HashMap<>();
			
		
		}
		
		
		Integer key = studente.getMatricola();
		
		if(tabella.containsKey(key)) {
			
			throw new MatricolaException("ATTENZIONE ! La matricola è già presente nella TABELLA. MATRICOLA GIÀ PRESENTE: " + key);	
				
		}
		else {
			
			tabella.put(key, studente);
			aggiornaTabella(tabella);
		}
			
		}
		
	
	public ArrayList<Studente> visualizza() throws TabellaInesistenteException {
		
	
		
		try {
			
			HashMap<Integer, Studente> tabella = leggiTabella();
			return new ArrayList<>(tabella.values());
			
		}
		
		catch(TabellaInesistenteException e) {
			
			throw new TabellaInesistenteException("ATTENZIONE ! La tabella non esiste, nessuna tabella da mostrare. CODICE ERRORE: " + e.getMessage());
		}
		
	}

	
	
	
	
	public Studente cerca(int matricola) throws MatricolaException, TabellaInesistenteException{
		
		
		HashMap<Integer,Studente> tabella;
		
		
		try {
			
			tabella = leggiTabella();
			
		}
		catch(TabellaInesistenteException e) {
			
			throw new TabellaInesistenteException("ATTENZIONE ! La tabella non esiste, nessuna tabella da mostrare. CODICE ERRORE: " + e.getMessage());
		}
		
		
		Integer key = matricola;
		
		if (tabella.containsKey(key)) {
			
			 return tabella.get(key);
			
		}else {
				 
			
			throw new MatricolaException("ATTENZIONE ! La Matricola " + key + " risulta non essere presente nella tabella");
		
		}
	}
		
		
	

	public Studente rimuovi(int matricola) throws MatricolaException, TabellaInesistenteException{
		
		HashMap<Integer, Studente> tabella = leggiTabella();
		
		Integer key = matricola;
		
		
		if(tabella.containsKey(key)) {
			
			Studente rim = tabella.remove(key);
			
			aggiornaTabella(tabella);
			
			return rim;
			
			
			
		}
		else {
			
			throw new MatricolaException("ATTENZIONE ! La Matricola " + key + " risulta non essere presente nella tabella");

		}
		
		
		
	}


	public void modifica(Studente studente) throws TabellaInesistenteException {
		
		
		HashMap<Integer,Studente> tabella = leggiTabella();
		
		Integer key = studente.getMatricola();
		
		if(tabella.containsKey(key)) {
			
			
			tabella.put(key,studente);
			aggiornaTabella(tabella);
		}
		else {
			
		    throw new TabellaInesistenteException("ATTENZIONE ! La tabella non esiste, nessuna tabella da mostrare.");
			
		}
		
	}
	
	public ArrayList<Studente> ordinaByNome() throws TabellaInesistenteException{
		
		
		ArrayList<Studente> lista = visualizza();
		lista.sort(Comparator.comparing(Studente::getNome));
		return lista;
		
		
	}
	
	public ArrayList<Studente> ordinaByDate() throws TabellaInesistenteException{
		
		ArrayList<Studente> lista = visualizza();
		
		lista.sort(Comparator.comparing(Studente::getDataImmatricolazione));
		return lista;
	}
	
	public Studente getStudenteGiovane() throws TabellaInesistenteException {
		
		ArrayList<Studente> lista = visualizza();

		
		Studente ris = null;
		
		
		if(lista.isEmpty()) {
			
			return null;
		}
		
		for(Studente stu : lista) {
			
			if(ris == null) {
				
				ris = stu;
			}
			if(ris.getDataImmatricolazione().compareTo(stu.getDataImmatricolazione()) < 0) {
				
				ris =  stu;
			
				
			}
		
			
		}
		
		return ris;
		
		
	}
	
	public ArrayList<Studente> visualizzaByCorso(String corso) throws TabellaInesistenteException{
		
		
		ArrayList<Studente> lista = visualizza();	
		ArrayList<Studente> ris = new ArrayList <Studente>();
		
		if ( lista.isEmpty()) {
			
			return null;
			
		}
		
		for(Studente stu: lista) {
			
			if(stu.getCorsoLaurea().equals(corso)) {
				
				ris.add(stu);
			}
			
		}
			
			
		return ris;
		
		}

		
}
