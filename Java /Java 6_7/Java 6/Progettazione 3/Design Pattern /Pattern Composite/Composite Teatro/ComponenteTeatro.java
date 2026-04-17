package PatternComposite;

/* * ComponenteTeatro - The Composite Pattern Base
    ? This interface serves as the "Uniform Contract" for the Composite design pattern. It defines a common set of operations that both individual objects (Leafs, like a single Seat) and groups of objects (Composites, like a Gallery or a Whole Theater) must implement.

    ! 1. Hierarchical Recursive Structure, defines the 'mostraDettagli' method with an 'indentazione' parameter. This allows the system to print the entire theater's tree-like structure (e.g., Theater -> Floor -> Row -> Seat) while visually representing the depth of each component through incremental spacing.
    ! 2. Aggregate Calculation Signature, includes 'getNumeroPostiTotali'. This is the core strength of the pattern: a client can call this method on a single row or the entire building without needing to know the difference. The composite objects will internally sum the values of their children, while leaf objects return their own value.
    ! 3. Polymorphic Transparency, ensures that the business logic can treat a single architectural unit and a complex collection of units identically. This decoupling simplifies the client code, as it doesn't need to perform 'instanceof' checks to determine if it is dealing with a simple 'Posto' or a complex 'Settore'.
*/

//Interface of the component Teatro, the comune INTERFACE 
public interface ComponenteTeatro {
	
    void mostraDettagli(String indentazione);
    
    int getNumeroPostiTotali();
}