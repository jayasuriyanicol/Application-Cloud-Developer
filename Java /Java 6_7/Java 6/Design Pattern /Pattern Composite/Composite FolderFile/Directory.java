package PatternComposite;

import java.util.ArrayList;
import java.util.List;


/* * PatternComposite - Hierarchical Tree Structure
    ? An elegant implementation of the Composite Design Pattern, allowing the application to treat individual objects (Files) and compositions of objects (Directories) uniformly. This structure is the industry standard for modeling tree-like hierarchies where components can contain other components.

    ! 1. Unified Component Interface, uses the abstract 'FileSystemElement' to define a common 'misura()' method. This abstraction ensures that the client code doesn't need to check whether it is dealing with a single file or a folder; it simply calls the method and receives a result, promoting highly decoupled logic.
    ! 2. Base-Level Leaf Implementation, defines the 'File' class as the terminal node of the tree. Since a file cannot contain other elements, its implementation of 'misura()' is straightforward—returning its own primitive byte value—serving as the "base case" for the recursive calculations performed by the parent nodes.
    ! 3. Recursive Composition Logic, the 'Directory' class acts as the 'Composite' by maintaining a list of 'FileSystemElement' references. Its 'misura()' method uses a "Depth-First" accumulation strategy, where it sums the results of its children. Because those children could be other Directories, the calculation naturally ripples down the entire sub-tree until every Leaf is accounted for.
*/

//Rappresenting the COMPONENT CLASS 'FileSystemElement', with only one abstract method
public abstract class FileSystemElement {
    protected String nome;

    public abstract int misura(); 
}

//Rappresenting the LEAF CLASS 'File'
public class File extends FileSystemElement {
	
    private int bytes; 

    public File(int bytes) {
    	this.bytes = bytes;
    }

    @Override
    public int misura() {
        return this.bytes;
    }
}

//Rappresentinf the COMPOSITE CLASS 'Directory'
public class Directory extends FileSystemElement {
    
    private List<FileSystemElement> elementi = new ArrayList<>();

    public Directory() {}

    @Override
    public int misura() {
    	
    	//Cycling on the list to get the mesure of each element and sum and return it
        int totale = 0;
        for (FileSystemElement e : elementi) {
            totale += e.misura();
        }
        return totale;
    }
}