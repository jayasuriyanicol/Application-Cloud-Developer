package corsoBase;

import java.util.Comparator;

public class CompareByDate implements Comparator<Impiegato> {
	@Override
	public int compare(Impiegato o1, Impiegato o2) {
		return o1.getDataAssunzione().compareTo(o2.getDataAssunzione());
	}

}