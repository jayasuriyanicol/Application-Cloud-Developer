package PatternComposite;


/* * TestTeatro - Composite Pattern Orchestrator
    ? This class serves as the Client in the Composite design pattern. It demonstrates the structural power of the pattern by building a multi-layered hierarchy—from the entire building down to individual seats—and interacting with the complex tree through a single, unified interface.

    ! 1. Hierarchical Tree Construction, manually wires the 'Teatro -> Sottosettore -> Zona -> Posti' relationship. By nesting 'SettoreTeatro' instances within each other and adding 'Posto' leaves at the end, it models the physical reality of a theater's architecture where smaller units are contained within larger ones.
    ! 2. Recursive Execution Trigger, invokes 'mostraDettagli("")' on the root element. This single call sets off a chain reaction across the entire structure, where each composite node prints its header and then delegates the work to its children, resulting in a perfectly indented visual map of the "Teatro Brancaccio".
    ! 3. Aggregate Query Transparency, demonstrates the "Uniformity" of the pattern by calling 'getNumeroPostiTotali'. The client doesn't need to manually traverse lists or check object types; it asks the top-level 'piantaIntera' for a sum, and the pattern's recursive nature ensures that every single leaf seat is counted and bubbled up to the final total.
*/

public class TestTeatro {

	    public static void main(String[] args) {
	    	
	        //In the main create the gerarchy: Teatro -> Sottosettore -> Zona -> Posti
	        SettoreTeatro piantaIntera = new SettoreTeatro("Teatro Brancaccio Roma");
	        
	        SettoreTeatro salaPrincipaleInferiore  = new SettoreTeatro("SalPrincSup");
	        SettoreTeatro primaFila =  new SettoreTeatro("A");
	        
	        primaFila.aggiungi(new Posto("A1"));
	        primaFila.aggiungi(new Posto("A2"));
	        
	        salaPrincipaleInferiore.aggiungi(primaFila);
	        piantaIntera.aggiungi(salaPrincipaleInferiore);
	        
	        
	        piantaIntera.mostraDettagli("");
	        System.out.println("Totale posti: " + piantaIntera.getNumeroPostiTotali());
	    }
	}

