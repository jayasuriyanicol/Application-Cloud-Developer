package PatternComposite;

import java.util.ArrayList;
import java.util.List;

//Comune interface the CLASS COMPONENT 'ComponenteTeatro' 
public abstract class ComponenteTeatro {
	
	
    protected String nome;

    public ComponenteTeatro(String nome) {
        this.nome = nome;
    }

    public abstract String getDettagli(String specificaPiantina);
}

//Creating the LEAF CLASS 'Zona'
public class Zona extends ComponenteTeatro {
	
    private int numeroPosti;

    public Zona(String nome, int numeroPosti) {
    	
    	//Calling the protected name, not need it 
        super(nome);
        this.numeroPosti = numeroPosti;
    }

    @Override
    public String getDettagli(String specificaPiantina) {
        return specificaPiantina + "\n|ZONA TEATRO|: " + nome + "\nNUMERO POSTI TOTALE -> " + numeroPosti + " POSTI";
    }
}

//Creating the COMPOSITE CLASS 'SottoSettore' 
public class SottoSettore extends ComponenteTeatro {
	
	//Containg as quite often tht list of father class abstract
    private List<ComponenteTeatro> listaDettagli = new ArrayList<>();

    public SottoSettore(String nome) {
        super(nome);
    }

    public void aggiungi(ComponenteTeatro componente) {
    	listaDettagli.add(componente);
    }

    @Override
    public String getDettagli(String specificaPiantina) {
    	
    	//Creating a StringBuilder to concanate the details of the Teatro
        StringBuilder specifica = new StringBuilder();
        specifica.append(specificaPiantina).append("\n|SOTTOSETTORE| ").append(nome).append("\n");
        
        //Recorsive for each printing the details of the list 
        for (ComponenteTeatro c : listaDettagli) {
        	specifica.append(c.getDettagli(listaDettagli + "  "));
        }
        return specifica.toString();
    }
}