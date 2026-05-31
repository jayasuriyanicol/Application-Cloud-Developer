package PatternFactorySingleton;

import java.util.HashMap;
import java.util.Map;


/* * FactoryDataExport - Reflection-Based Registry Singleton
    ? A sophisticated hybrid pattern that combines the "Factory Method" with a "Registry of Singletons." It utilizes Java Reflection to dynamically instantiate exporter classes, ensuring that only one instance of each specific format (CSV, PDF, etc.) exists in the system to conserve memory and maintain global state.

    ! 1. Dynamic Reflection Instantiation, uses 'Class.forName' and 'getDeclaredConstructor' to create objects based on a string name. This decouples the Factory from its concrete classes—the code doesn't need a massive 'switch' statement, and new exporters can be added to the package without changing a single line in this Factory.
    ! 2. Instance Caching (Flyweight Strategy), employs a 'HashMap' to store and reuse exporter instances. By checking 'containsKey' before instantiation, the class ensures that if multiple parts of the application request a "CSVExporter," they all receive the exact same object reference, preventing redundant memory allocation.
    ! 3. Namespace Convention Enforcement, automatically prefixes the provided class name with the package path ("PatternFactorySingleton."). This standardization allows the caller to use short, readable names while the Factory handles the technical requirements of locating the class within the Java classpath.
*/

public class FactoryDataExport {

	
	    //Creation of a Map to store singleton instances into the HashMap
	    private static Map<String, DataExport> instances = new HashMap<>();

	    public static DataExport getExporter(String className) {
	    	
	        try {
	        	
	            //The check we need, to considerate if they have an INSTANCE 
	            if (!instances.containsKey(className)) {
	            	
	                //Creation of an instance via Reflection, and casting it as the correct one 
	                String fullName = "PatternFactorySingleton." + className;
	                
	                DataExport newExporter = (DataExport) Class.forName(fullName)
	                                              .getDeclaredConstructor()
	                                              .newInstance();
	                
	                instances.put(className, newExporter);
	            }
	            
	            return instances.get(className);
	            
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            return null;
	        }
	    }
	}
