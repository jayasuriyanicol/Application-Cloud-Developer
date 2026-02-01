package eserciziLezione6;
import java.util.Date;
public class Manager extends Impiegato{
	
	private String segretaria;

	public Manager(String nome, double salario, Date dataAssunzione, String segretaria) {
		super(nome,salario,dataAssunzione);
		
		this.segretaria = segretaria;
		
	
	}

	public String getSegretaria() {
		return segretaria;
	}

	public void setSegretaria(String segretaria) {
		this.segretaria = segretaria;
	}

	@Override
	public String toString() {
		//Using the pre-defined super toString concatenating the 'segretaria'
		return super.toString() + ", Segretaria = " + segretaria;
	}

	@Override
	public void incrSalario(double aumento) {
		// Calculate the bonus of the manager, we can use for getAnnoAssunzione or this or super is the same
		Date oggi = new Date();
		double bonusManager = 0.5*(oggi.getYear() + 1900 - super.getAnnoAssunzione());
		super.incrSalario(aumento + bonusManager);
		super.incrSalario(aumento);
	}
	
	
	
	
	

}
