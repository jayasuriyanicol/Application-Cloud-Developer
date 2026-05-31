package PatternFactorySingleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/* * JDBCFactory - Static Connection Provider
    ? A utility class that centralizes database access configuration. It acts as a specialized Factory for 'Connection' objects, ensuring that sensitive database credentials and driver URLs are managed in a single location rather than being scattered across the DAO layer.

    ! 1. External Configuration Encapsulation, hardcodes the PostgreSQL connection string and credentials within private static constants. This provides a clean abstraction for the rest of the application; other classes simply call 'getConnection()' without needing to know the specific port, database name ("reflection"), or authentication details.
    ! 2. Just-In-Time Connectivity, leverages the 'DriverManager.getConnection' method to establish a new session only when requested. This avoids holding an open database connection when the application is idle, which is a critical practice for preserving server-side resources in small-to-medium scale applications.
    ! 3. Standardized Exception Contract, explicitly throws 'SQLException' back to the caller. This ensures that the calling method (like the 'Setting' class) is forced to handle connectivity issues—such as a downed server or invalid password—allowing for graceful error reporting or retry logic.
*/


public class JDBCFactory {
	
	    private static final String URL = "jdbc:postgresql://localhost:5432/reflection";
	    private static final String USER = "postgres";
	    private static final String PASSWORD = "postgres";

	    public static Connection getConnection() throws SQLException {
	    	
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	}
