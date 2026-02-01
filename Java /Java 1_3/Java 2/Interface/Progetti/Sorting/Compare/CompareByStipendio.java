package corsoBase;

import java.util.Comparator;

public class CompareByStipendio implements Comparator<Impiegato> {

	@Override
	public int compare(Impiegato o1, Impiegato o2) {
		return (int) (o1.getSalario() - o2.getSalario());
	}

}