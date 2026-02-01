package eserciziLezione8;
import java.util.Comparator;

public class AltezzaComparator implements Comparator<Box> {
	
	@Override
	public int compare(Box b1, Box b2) {
		
		return Double.compare(b1.getAltezza(), b2.getAltezza());
	}

}
