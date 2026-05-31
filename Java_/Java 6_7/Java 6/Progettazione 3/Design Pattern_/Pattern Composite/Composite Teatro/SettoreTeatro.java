package PatternComposite;

import java.util.ArrayList;
import java.util.List;

/* * SettoreTeatro - The Recursive Composite Container
    ? This class represents a "Composite" node in the theater hierarchy. It is a container that can hold both individual Seats (Leafs) and other Sectors (Sub-Composites), allowing for an infinitely deep and flexible architectural structure such as Tiers, Galleries, or specific Rows.

    ! 1. Dynamic Child Management, maintains a 'List<ComponenteTeatro>' to hold its children. Through the 'aggiungi' method, the class can aggregate any object that implements the shared interface, enabling the construction of a complex tree-like theater map at runtime.
    ! 2. Recursive Traversal Orchestration, implements 'mostraDettagli' by first printing its own name and then delegating the task to its children. By appending "  " to the 'piantinaTeatro' string, it automatically creates a nested visual hierarchy, effectively mapping the theater's physical layout in the console.
    ! 3. Aggregate Logic Delegation, calculates 'getNumeroPostiTotali' by summing the results of the same method called on its children. This is the hallmark of the Composite pattern: the sector doesn't need to know if it's counting a single seat or a whole sub-sector; it simply relies on the uniform interface to provide the correct sub-total.
*/


public class SettoreTeatro implements ComponenteTeatro {
	

	    private String nomeTeatro;

		//List to hold the children of the composite, in this case the components of the theater.
	    private List<ComponenteTeatro> listaComponentiTeatro = new ArrayList<>();

	    public SettoreTeatro(String nome) {
	    	this.nomeTeatro = nome;
	    }

	    public void aggiungi(ComponenteTeatro componente) { 
	    	listaComponentiTeatro.add(componente); 
	    }

         
		//Showing the details of the sector and then delegating to the children
	    @Override
	    public void mostraDettagli(String piantinaTeatro) {
	        System.out.println(piantinaTeatro + "Settore/Zona: " + nomeTeatro);
	        
	        for (ComponenteTeatro componente : listaComponentiTeatro) {
	        	
	            componente.mostraDettagli(piantinaTeatro + "  ");
	        }
	    }

	    @Override
	    public int getNumeroPostiTotali() {
	        int totalePosti = 0;
	        
	        for (ComponenteTeatro componente : listaComponentiTeatro ) {
	            totalePosti += componente.getNumeroPostiTotali();
	        }
	        
	        return totalePosti;
	    }
	}


