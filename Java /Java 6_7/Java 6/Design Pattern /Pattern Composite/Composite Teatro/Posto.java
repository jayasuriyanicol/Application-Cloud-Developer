package PatternComposite;

/* * Posto - The Leaf Component
    ? This class represents the "Leaf" node in the Composite Design Pattern. It is the most basic, indivisible unit of the theater structure. Unlike composite objects, a 'Posto' contains no children and performs its operations directly based on its own specific state.

    ! 1. Atomic Data Representation, encapsulates the 'codicePosto' (e.g., "A-12"). As the final destination of the theater hierarchy, this class provides the actual content that the user eventually interacts with, such as a specific seat assignment or a ticket booking location.
    ! 2. Base-Case Recursive Implementation, provides the concrete logic for the 'mostraDettagli' method. Instead of iterating through a list, it simply prints its own ID with the provided 'piantinaTeatro' indentation, serving as the "terminating condition" for any recursive traversal of the theater tree.
    ! 3. Unity Value Calculation, implements 'getNumeroPostiTotali' by returning a constant value of '1'. This ensures that when a higher-level Composite (like a Row or a Sector) sums its children's values, it accurately counts each individual seat as a single unit without needing to know the internal structure of the leaf.
*/


public class Posto implements ComponenteTeatro {
	
    private String codicePosto;

    public Posto(String codicePosto) { 
    	
    	this.codicePosto = codicePosto;
    }

    @Override
    public void mostraDettagli(String piantinaTeatro) {
    	
        System.out.println(piantinaTeatro + "Posto: " + codicePosto);
    }
    

    //Instead of iterating through a list, it simply returns 1
    @Override
    public int getNumeroPostiTotali() { 
    	return 1;
    	}
}
