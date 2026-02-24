package eserciziLezione13;

public abstract class FileDataSource implements DataSource {
	
	private String file;
	
	
	public FileDataSource (String file) {
		
		this.file = file;
	}
	
	public void scriviDatiFile(String dati) {
		
		file = dati;
	
	}
	
	public String leggiDatiFile() {
		
		return file;
	}

}
