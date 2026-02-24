package PatternFactorySingleton;

import java.util.List;

/* * DataExport - Strategy & Factory Pattern Interface
    ? A functional contract defining the standard behavior for data extraction modules. This interface serves as the "Product" in a Factory Pattern, allowing the application to handle various file formats (CSV, PDF, JSON) through a unified set of methods regardless of the underlying implementation.

    ! 1. Polymorphic Export Logic, defines a consistent 'export' signature that accepts generic string data and a destination filename. This allows the high-level business logic to trigger exports without needing to know the specific technical details of file headers, delimiters, or document structures.
    ! 2. Metadata Self-Description, includes the 'getMime' method to ensure that every export implementation can identify its own media type (e.g., "text/csv"). This is critical for web-based systems to correctly set the HTTP 'Content-Type' header so browsers handle the downloaded file appropriately.
    ! 3. Extension-Friendly Design, by using an interface, the system adheres to the Open/Closed Principle. New export formats can be added to the ecosystem simply by implementing this contract, without requiring any modifications to the existing Factory or Controller code.
*/

public interface DataExport {
	
	void export (List<String> data, String fileName);
	String getMime();
}
