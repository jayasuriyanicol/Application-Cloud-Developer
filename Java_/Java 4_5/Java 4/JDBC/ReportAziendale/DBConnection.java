package JDBC.ReportAziendale;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/* * Database - Property-Driven Connection Factory
    ? A utility class designed to establish JDBC connections by dynamically loading configuration details (URL, User, Password) from an external properties file ('/dbReportAziendale.properties'), ensuring security by avoiding hardcoded credentials.

    ! 1. getConnection(), retrieves the configuration file via the class loader, validates the existence of required keys, and initiates the connection using the DriverManager.
    ! 2. Exception Handling, wraps checked IOExceptions into unchecked RuntimeExceptions to force a "fail-fast" behavior if critical configuration files are missing or unreadable.
*/

public class Database {

    /*  | DB STATIC ISSUE |
        private static final String URL="jdbc:postgresql://localhost:5432/gestioneutenti";
        private static final String USER="postgres";
        private static final String PASS="postgres";
    */

    private static final String PROPS_FILE="/dbReportAziendale.properties";
    private static final Properties props=new Properties();

    public static Connection getConnection() throws SQLException {
        try {
            InputStream in = Database.class.getResourceAsStream(PROPS_FILE);
            if(in==null) {
                throw new RuntimeException("ATTENZIONE ! Errore nella lettura delle properties: " + PROPS_FILE);
            }
            props.load(in);
        } catch(IOException e) {
             throw new RuntimeException("ATTENZIONE !  Errore nella lettura delle properties: " + PROPS_FILE, e);
        }

        String URL = props.getProperty("db.url");
        String USER = props.getProperty("db.user");
        String PASS = props.getProperty("db.password");
        if(URL == null || USER == null || PASS == null)
        	 throw new RuntimeException("ATTENZIONE ! Errore nelle getProperties: " + PROPS_FILE);

        return DriverManager.getConnection(URL, USER, PASS);
    }
}