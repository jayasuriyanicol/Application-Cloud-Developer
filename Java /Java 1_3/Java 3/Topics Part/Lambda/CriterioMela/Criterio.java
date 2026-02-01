'''Creation of the the file CRITERIO, a standard file that it can be modified'''

package lambda;

//The 'FunctionalInterface' it can be used or unsed, is good practise using it for avoid Excpetion
@FunctionalInterface
public interface Criterio {

	public boolean test(Mela mela);
	//public boolean test2(Mela mela);
}