package JDBC.ReportAziendale;

import java.sql.*;

public class Report {



	    public static double getTotaleStipendiMensili() {
	        double totale = 0;
	        Connection con = null;
	        
	        try {
	            con = DBconnection.getConnection();
	            
	            
	            String sqlCalc = "SELECT SUM(salarioMensile) FROM Impiegati";
	            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sqlCalc)) {
	                if (rs.next()) {
	                    totale = rs.getDouble(1);
	                }
	            }
	            
	           
	            String sqlUpdate = "UPDATE ReportValori SET valore = ? WHERE descrizione = 'totaleStipendiMensili'";
	            try (PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
	                ps.setDouble(1, totale); 
	                ps.executeUpdate();
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	             try { if (con != null) con.close(); } catch (SQLException ex) { ex.printStackTrace(); }
	        }
	        
	        return totale;
	    }

	   
	    public static int getNumImpiegatiConBonus() {
	        int count = 0;
	        Connection con = null;
	        
	        try {
	            con = DBconnection.getConnection();
	            
	           
	            String sqlCount = "SELECT COUNT(*) FROM Impiegati WHERE bonusAnnuale > 0";
	            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sqlCount)) {
	                if (rs.next()) {
	                    count = rs.getInt(1);
	                }
	            }
	            
	            
	            String sqlUpdate = "UPDATE ReportValori SET valore = ? WHERE descrizione = 'numeroImpConBonus'";
	            try (PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
	                ps.setInt(1, count);
	                ps.executeUpdate();
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	             try { if (con != null) con.close(); } catch (SQLException ex) { ex.printStackTrace(); }
	        }
	        
	        return count;
	    }

	   
	    public static boolean checkRangeStipendio(String matricola) {
	        boolean isCorrect = false;
	        
	        
	        String sql = "SELECT i.salarioMensile, m.stipendioMin, m.stipendioMax " +
	                     "FROM Impiegati i JOIN Mansioni m ON i.mansione = m.mansione " +
	                     "WHERE i.matricola = ?";
	                     
	        try (Connection con = DBconnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            
	            ps.setString(1, matricola);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    int salario = rs.getInt("salarioMensile");
	                    int min = rs.getInt("stipendioMin");
	                    int max = rs.getInt("stipendioMax");
	                    
	                    if (salario >= min && salario <= max) {
	                        isCorrect = true;
	                    }
	                }
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return isCorrect;
	    }
	}

