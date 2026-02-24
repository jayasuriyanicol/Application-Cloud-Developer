package PatternFactorySingleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/* * JsonExporter - Structured Data Strategy
    ? A concrete implementation of the 'DataExport' interface that serializes data into JSON format. It transforms flat list elements into a structured, key-value style string, enabling the application to generate machine-readable output compatible with modern web APIs and NoSQL environments.

    ! 1. Functional Stream Serialization, leverages the 'Stream.reduce' method to aggregate the list elements into a single formatted string. By injecting newline and tab characters during the reduction process, it produces a "pretty-printed" JSON structure that remains human-readable while maintaining strict formatting rules.
    ! 2. Resource-Efficient Appending, utilizes 'BufferedWriter' with the append flag set to 'true', similar to the CsvExporter. This allows the system to build large JSON collections incrementally over time without loading the entire file into memory, which is essential for handling large dataset exports.
    ! 3. Standardized Media Type, implements 'getMime' to return "application/json". This precisely identifies the content type for external systems, ensuring that any downstream application or browser knows exactly how to parse and interpret the resulting file.
*/

public class JsonExporter implements DataExport {

	@Override
	public void export(List<String> data, String fileName) {
		
		String testo = "{\n\t" + data.stream().reduce("", (a, b) -> a + "\n\t" + b) + "\n}";;
		
		
		try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(fileName, true));
            bf.write(testo);
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public String getMime() {
	
		return "application/json";
	}

}
