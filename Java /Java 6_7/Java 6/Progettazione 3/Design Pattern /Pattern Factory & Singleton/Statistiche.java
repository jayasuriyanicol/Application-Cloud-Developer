package PatternFactorySingleton;



/* * Statistiche - The Pattern Consumer & Bridge
    ? Acting as the 'Consumer' in your pattern schema, this class serves as the high-level coordinator. It bridges the gap between the raw relational database (JDBC) and the abstract export strategies, fulfilling the "Dependency Inversion Principle" by depending on the 'DataExport' interface rather than concrete implementations.

    ! 1. Meta-Driven Data Extraction, utilizes 'ResultSetMetaData' to dynamically discover table structures at runtime. By iterating through 'getColumnCount' and 'getColumnName', the class can process any database table without knowing its schema in advance, making it a truly generic data-gathering engine.
    ! 2. Strategy Injection (Setter), implements 'setExporter' to allow the dynamic swapping of export behaviors. This is the hallmark of the Strategy Pattern; the 'Statistiche' object doesn't care if it's exporting to CSV or JSON—it simply delegates the final formatting task to whichever 'DataExport' instance was injected.
    ! 3. Resource-Aware Querying, employs the 'try-with-resources' block for the JDBC Connection, Statement, and ResultSet. This ensures that database cursors and network sockets are automatically closed even if a SQL error occurs, preventing connection leaks that could eventually crash the 'reflection' database.

   ? |PATTERN SCHEMA| 

     * FACTOR -> FACTORY
     * CONSUMER -> STATISTICHE 
     * PRODUCT -> DATAEXPORT
     * CONCRETE PRODUCT -> CSVEXPORTER, JSONEXPORTER 
*/

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Statistiche {
    private DataExport exporter;


    public void setExporter(DataExport exporter) {
        this.exporter = exporter;
    }

    public void exportTable(String tableName, String fileName) {
        List<String> data = new ArrayList<>();
        
        String query = "SELECT * FROM " + tableName;

        try (Connection conn = JDBCFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    
                    data.add(rsmd.getColumnName(i) + ": " + rs.getString(i));
                }
            }
            
           
            if (exporter != null) {
                exporter.export(data, fileName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}