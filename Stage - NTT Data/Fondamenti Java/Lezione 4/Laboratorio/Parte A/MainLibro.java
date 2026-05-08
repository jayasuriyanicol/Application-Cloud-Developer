package Lezione_04;

public class Libro {
	
	private String titolo,autore;
	private Integer pagine;
	private Double prezzo;
	
	public Libro() {}
	
	
	public Libro(String titolo, String autore, Integer pagine,Double prezzo) {
		
		
		this.titolo = titolo;
		this.autore = autore;
		this.pagine = pagine;
		this.prezzo = prezzo;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public Integer getPagine() {
		return pagine;
	}


	public void setPagine(Integer pagine) {
		
		try {
			
			if(pagine > 0) {
				
				this.pagine = pagine;
				
			}
		} catch (Exception e) {
			
			throw new IllegalArgumentException("ATTENZIONE ! Il libro deve avere per forza almeno una pagina !");
		}
			
	}


	public Double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(Double prezzo) {
		
		try{
			if(prezzo >=0) {
				
				this.prezzo = prezzo;
			}
		}catch(Exception e) {
			
			throw new IllegalArgumentException("ATTENZIONE ! Il prezzo deve essere maggiore o uguale a zero !");
		}
		
	}
	
	
	public void stampaDettagli() {
		
		System.out.println("TITOLO: " + titolo);
		System.out.println("AUTORE: " + autore);
		System.out.println("PAGINE: " + pagine);
		System.out.println("PREZZO: " + prezzo);
	}
	
	public Boolean isCostoso() {
		
		return prezzo > 50.0;
	}
	

}
