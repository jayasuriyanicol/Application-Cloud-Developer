package PatternFactorySingleton;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;


/* * Setting - Dynamic Runtime Orchestrator
    ? The execution entry point that bridges database-driven configuration with design pattern flexibility. It demonstrates a truly dynamic architecture where the available export formats are not hardcoded, but instead discovered at runtime via JDBC and instantiated through the Factory.

    ! 1. Data-Driven Feature Discovery, utilizes a SQL query to populate the 'availableExporters' list. This allows the application to support new file formats simply by adding a row to the 'ExportType' database table, effectively decoupling the user interface from the underlying Java implementation.
    ! 2. Pattern Integration Workflow, showcases the seamless collaboration between the 'JDBCFactory' (for data sourcing), 'FactoryDataExport' (for object creation), and 'Statistiche' (for business logic). This "Chain of Responsibility" ensures that each class has a single, clear purpose.
    ! 3. Dependency Injection Simulation, by using 'stats.setExporter(exporter)', the code manually performs Dependency Injection. This makes the 'Statistiche' object format-agnostic, allowing it to process data without knowing whether the final output will be CSV, PDF, or Plain Text until the user makes a choice.
*/

public class Setting {
	
	
	    public static void main(String[] args) {
	    	
	    	Scanner scanner = new Scanner(System.in);
	        
	      
	        System.out.println("Available Export Options:");
	        List<String> availableExporters = new ArrayList<>();
	        
	        try (Connection conn = JDBCFactory.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT exporterName FROM ExportType")) {
	            
	            int count = 1;
	            while (rs.next()) {
	                String name = rs.getString("exporterName");
	                availableExporters.add(name);
	                System.out.println(count + ". " + name);
	                count++;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	       
	        System.out.print("\nSelect the export format (number): ");
	        int choice = scanner.nextInt();
	        String selectedClassName = availableExporters.get(choice - 1);

	        
	        DataExport exporter = FactoryDataExport.getExporter(selectedClassName);

	       
	        List<String> dataToExport = new ArrayList<>();
	        dataToExport.add("ID: 101");
	        dataToExport.add("Product: Coffee");
	        dataToExport.add("Price: 5.50");

	        
	        Statistiche stats = new Statistiche();
	        stats.setExporter(exporter);
	        
	        
	        String tabellaDaEsportare = "Category";
	        String nomeFileOutput = "exportx _ " + tabellaDaEsportare.toLowerCase() + ".txt";
	        
	        stats.exportTable(tabellaDaEsportare, nomeFileOutput);
	        System.out.println("Export completed using " + exporter.getMime());
	    }
	}

