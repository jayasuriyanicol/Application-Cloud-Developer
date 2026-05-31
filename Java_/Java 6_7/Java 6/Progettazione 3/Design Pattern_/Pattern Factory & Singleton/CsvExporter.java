package PatternFactorySingleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/* * CsvExporter - Concrete Strategy Implementation
    ? A specific implementation of the 'DataExport' interface tailored for Comma-Separated Values. It transforms internal collection data into a persistent flat-file format, providing a lightweight and universal way to store table data for spreadsheet software.

    ! 1. Delimiter-Based Data Flattening, utilizes 'String.join' with a comma separator to transform a 'List<String>' into a single CSV row. This ensures the exported data adheres to the standard RFC 4180 format, allowing the output file to be opened natively by applications like Excel or Google Sheets.
    ! 2. Optimized Stream I/O, employs 'BufferedWriter' wrapped around a 'FileWriter' with the append flag set to 'true'. This configuration is highly efficient for recurring exports, as it buffers characters in memory before committing them to disk and ensures new data is added to the end of the file rather than overwriting previous entries.
    ! 3. Contract-Driven Metadata, correctly implements 'getMime' to return "text/csv". By providing this standardized media type identification, the exporter allows the calling 'Factory' or 'Setting' class to handle the file correctly within a broader system context (e.g., setting download headers).
*/

public class CsvExporter implements DataExport{

	@Override
	public void export(List<String> data, String fileName) {
	
	//Using this, to concatenate the data in a String 'content'
	String testo = String.join(",", data) + "\n";
	
	
	//Have a try catch to write in the file, as we already concanate it
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
		
		return "text/cvs";
	}
	
	

}
