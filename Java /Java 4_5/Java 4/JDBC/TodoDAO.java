package JDBC;

import java.sql.*;
import java.util.ArrayList;

/* * TodoDAO - Data Access Object
    ? Handles the persistence layer for 'Todo' entities, abstracting raw JDBC calls to perform database operations like inserting and retrieving tasks.

    ! 1. inserimentoTask(String task), connects to the database to insert a new task string. It returns true if the insertion affects 1 row, and wraps any SQL exceptions into a RuntimeException.
    ! 2. inserimentoDati(), despite the name (which suggests insertion), this method performs a retrieval (SELECT *). It fetches all records, maps the ResultSet to a list of Todo objects, logs the found IDs to the console, and returns the list.

    * DAO -> Data Access Object, where we access to the DB
    * DTO -> Data Trasfer Object, trasport data to layer in the app

*/




public class TodoDAO {
	
		
	public static boolean inserimentoTask(String task) {
		
		String sql = "INSERT INTO todo (task) VALUES (?)";
		
		try {
			
			Connection conn = DB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,task);
			
			
			return ps.executeUpdate() == 1;
		
		}catch(SQLException e) {
			System.err.println("ERRORE JDBC\n ERRORE -> " + e.getMessage());
			
			throw new RuntimeException("ERRORE INSERIMENTO TODO", e);
		}
		
		

	}
	
	public static ArrayList<Todo> inserimentoDati() {
	    
	    
	    ArrayList<Todo> tasks = new ArrayList<>();
	    
	    String sql = "SELECT * FROM todo";
	    
	    try {
	        Connection conn = DB.getConnection();
	        System.out.println("Connesso al DB");
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        
	        while(rs.next()) {
	            
	            int id = rs.getInt("id");
	            String taskText = rs.getString("task");
	            boolean done = rs.getString("done") != null;
	            
	          
	            Todo t = new Todo(id, taskText, done);
	               tasks.add(t);
	            
	            System.out.println("Aggiunto ID -> " + id);
	        }
	        
	    } catch(SQLException e) {
	        System.out.println("ERRORE JDBC -> " + e.getMessage());
	    }
	
	    return tasks;
	}


		
		
		
		
		
		
	}
	
	