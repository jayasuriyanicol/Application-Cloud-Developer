package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* * DB - Database Utility Class
    ? A helper class designed to manage database connectivity configurations and provide connection objects for the 'todo' PostgreSQL database.

    ! 1. getConnection(), establishes and returns a new java.sql.Connection instance using the defined static credentials (URL, USER, PASS), throwing an SQLException if the connection fails.
*/

public class DB {		
		private static final String URL = "jdbc:postgresql://localhost:5432/todo";
		private static final String USER = "postgres";
		private static final String PASS = "postgres";
		
		
		public static Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection(URL,USER,PASS);
		return conn;
		
		
		}
		
		
	}
