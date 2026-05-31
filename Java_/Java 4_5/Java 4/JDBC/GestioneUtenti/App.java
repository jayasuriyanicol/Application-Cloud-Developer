package GestioneUtenti;


import java.sql.*;

/* * App - Database Query Execution
    ? A demonstration class serving as the entry point to fetch and display user information from the 'utente' table using JDBC.

    ! 1. main(String[] args), establishes a database connection, prepares a SQL SELECT statement to filter users by name, executes the query, and iterates through the ResultSet to print user details (username, name, surname, birth year).
*/

public class App {

	public static void main(String[] args) {
		
		
		String sql = "SELECT * FROM utente WHERE nome=?";
		
		try {
			
			Connection connessione = DB.getConnection();
			System.out.println("SUCCESSO ! Si è correttamnete connessi al DB");
			PreparedStatement ps = connessione.prepareStatement(sql);
			
			ps.setString(3, "Giacomo");
			
			ResultSet result = ps.executeQuery();
			
			
			while(result.next()) {
				
				String username = result.getString("username");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				int anno_nascita = result.getInt("anno_nascita");
				
				System.out.println("USERNAME -> "+ username + "\nNOME -> " + nome + "\nCOGNOME -> " + cognome + "\nANNO NASCITA -> " + anno_nascita );
			}
			
			
		} catch(SQLException e) {
			
			System.out.println("ATTENZIONE ! Errore connessione al DB.\n ERRORE JBDC -> " + e.getMessage());
			
			
		}
		


	}

}
 