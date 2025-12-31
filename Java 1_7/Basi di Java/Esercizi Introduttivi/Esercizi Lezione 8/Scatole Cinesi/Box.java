package eserciziLezione8;

public class Box implements Comparable<Box> {
	
	private double altezza;
	private double larghezza;
	private double spessore;
	
	
	public Box(double altezza, double larghezza, double spessore) {
		
		
		this.altezza = altezza;
		this.larghezza = larghezza;
		this.spessore = spessore;
	}
	
	
	public double getAltezza() {
		
		return altezza;
	}
	
	public double getLarghezza() {
		
		return larghezza;
	}
	
	public double getSpessore() {
		
		return spessore;
	}
	
	public double getVolume() {
		
		return altezza * larghezza *spessore;
	}
	
	@Override 
	public boolean equals(Object obj) {
		
		
		if (this == obj) {
			
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			
			return false;
			
		}
		
		Box analisiBox = (Box) obj;
		
		return Double.compare(this.altezza, analisiBox.altezza) == 0 &&
			   Double.compare(this.larghezza,analisiBox.larghezza) == 0 &&
			   Double.compare(this.spessore, analisiBox.spessore) == 0;
	}
	
	@Override
	public int compareTo(Box analisiBox) {
		return Double.compare(this.getVolume(), analisiBox.getVolume());
	
		
	}
	
	
	public boolean fitsIn(Box analisiBox ) {
	
	 return  this.altezza <= analisiBox.altezza &&
			 this.larghezza <= analisiBox.larghezza &&
			 this.spessore <= analisiBox.spessore;
	}
	
	
	@Override
	public String toString() {
	
		return "\nDATI BOX\n\nALTEZZA: " + altezza + "\nLARGHEZZA: " + larghezza + "\nSPESSORE: " +spessore + "\nVOLUME: " + getVolume();
	}
		
	
	

	

}
