package GestioneUtenti;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/* * DB - Property-Driven Connection Factory
    ? A utility class that establishes database connections by dynamically loading credentials and configuration details from an external 'db.properties' file on the classpath, avoiding hardcoded secrets.

    ! 1. getConnection(), reads the configuration file via input stream, validates the presence of required keys (db.url, db.user, db.password), and returns a specific JDBC Connection.
    ! 2. Error Handling, wraps standard IOExceptions into RuntimeExceptions to ensure the application fails fast if critical configuration files or properties are missing.
*/


public class DB {
	
	
	private static final String PROPS_FILE = "/db.properties";
	private static final Properties props = new Properties();
	
	
	public static Connection getConnection() throws SQLException {
		
		try {
			
			InputStream in = DB.class.getResourceAsStream(PROPS_FILE);
			if(in==null) {
				throw new RuntimeException("Errore nella lettura delle properties: "+PROPS_FILE);
			}
			props.load(in);
		}
		catch(IOException e) {
			
			throw new RuntimeException("Errore nella lettura delle properties: "+PROPS_FILE,e);
		}
		
		String URL = props.getProperty("db.url");
		String USER = props.getProperty("db.user");
		String PASS = props.getProperty("db.password");
		
		
		if(URL == null || USER == null || PASS == null) {
			
			throw new RuntimeException("Errore nelle getProperties: " + PROPS_FILE);
		}
	 return  DriverManager.getConnection(URL,USER,PASS);
	}
}