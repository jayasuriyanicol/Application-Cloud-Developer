package JDBC;
import java.sql.*;


/* * App - JDBC Entry Point
    ? Here is a demonstration class that establishes a database connection and executes a parameterized SQL query using PreparedStatement.

    ! 1. main(String [] args), connects to the DB via the helper class, prepares a SELECT query filtering by name ("Anna"), iterates through the resulting ResultSet to extract and print employee details (id, name, surname, position, salary), and handles potential SQLExceptions.
*/ 

public class App {
	
	public static void main(String [] args) {
		
		//QUERY 
		String sql = "SELECT * FROM Persona WHERE  nome =?";
		
		try {
			
		//Creation of connection, passing the static data
		Connection conn = DB.getConnection();
		System.out.println("Connesso al DB");

/*  * conn.prepareStatement(sql) - Statement Initialization
    ? Creates a PreparedStatement object for sending parameterized SQL statements to the database.

    ! 1. Security, serves as the primary defense against SQL Injection by separating the query structure from the data (using placeholders '?').
    ! 2. Performance, allows the database to pre-compile the SQL statement, optimizing execution speed if the query is run multiple times with different parameters.
*/

		PreparedStatement ps = conn.prepareStatement(sql);


		ps.setString(1,"Anna");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String posizione = rs.getString("posizione");
			double stipendio = rs.getDouble("stipendio");
			
			System.out.println("ID -> "+ id + "\nNOME -> " + nome + "\nCOGNOME -> " + cognome + "\nPOSIZIONE -> " + posizione + "\nSTIPENDIO -> "+ stipendio);
		}
		
		
		} catch(SQLException e) {
			
			System.out.println("ERRORE JDBC\nERRORE -> " + e.getMessage());
		}
		
	}

}
