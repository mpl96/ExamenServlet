package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionH2;
import connection.ConnectionManager;
import model.*;

public class Repository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();
	static final String USER = "sa";
	static final String PASS = "";
	
	public void DeleteTable(String language){
		Connection conn = null;
	    Statement stmt = null;
	
	    try {
	        Class.forName("org.h2.Driver");
	
			conn = DriverManager.getConnection(jdbcUrl, USER, PASS);
			
			stmt = conn.createStatement();
			
			String sql = "DELETE FROM Paises WHERE idiomaPaises = '" + language + "'";
			String sql2 = "DELETE FROM Idiomas WHERE idioma = '" + language + "'";
	
	        stmt.executeUpdate(sql);
	        stmt.executeUpdate(sql2);
	
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeStm(conn, stmt);
	        closeCon(conn);
	    } 
	} 
	
	private void closeCon(Connection conn) {
		try {
		    if (conn!= null)
		        conn.close();
		} catch (SQLException se) {
		    se.printStackTrace();
		} 
	}
	
	private void closeStm(Connection conn, Statement stmt) {
		try {
		    if (stmt!=null)
		        conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} 
	}
	
	public  List<Countries> listCountries(){
		Connection conn = null;
		List<Countries> listCountries2= new ArrayList<Countries>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Statement stmt = null;
	
	    try {
		        Class.forName("org.h2.Driver");
		
			    conn = DriverManager.getConnection(jdbcUrl, USER, PASS);
			   
			    stmt = conn.createStatement();
				
				prepareStatement = conn.prepareStatement("SELECT * FROM Paises");
				resultSet = prepareStatement.executeQuery();
				while(resultSet.next()){
					Countries userInDatabase = new Countries();
					userInDatabase.setCountry(resultSet.getString(1));
					userInDatabase.setLanguage(resultSet.getString(2));
					
					listCountries2.add(userInDatabase);
				}
	
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
            closeRs(resultSet);
        } 
	    return listCountries2;
	}
	
	public  List<Languages> listLanguages(){
    	Connection conn = null;
    	List<Languages> listLanguages2 = new ArrayList<Languages>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Statement stmt = null;

        try {
            Class.forName("org.h2.Driver");

		    conn = DriverManager.getConnection(jdbcUrl, USER, PASS);
		   
		    stmt = conn.createStatement();
			
			prepareStatement = conn.prepareStatement("SELECT * FROM Idiomas");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Languages userInDatabase = new Languages();
				userInDatabase.setLanguages(resultSet.getString(1));
				
				listLanguages2.add(userInDatabase);
			}

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
            closeRs(resultSet);
        } 
        return listLanguages2;
   }
	
	private void closeRs(ResultSet resultSet) {
		if(
			resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	public void insertTableCountries(String country, String language){
    	Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.h2.Driver");

		    conn = DriverManager.getConnection(jdbcUrl, USER, PASS);
		  
		    stmt = conn.createStatement();
		
		    String sql = "REPLACE INTO Paises (pais,idiomaPaises) VALUES ('" + country + "', '" + language + "')";
                   
            stmt.executeUpdate(sql);
        } catch (SQLException se) {            
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
        } 
    }

	public  void insertTableLanguages(String language){
		   Connection conn = null;
	       Statement stmt = null;

	       try {
	           Class.forName("org.h2.Driver");

			   conn = DriverManager.getConnection(jdbcUrl, USER, PASS);
			 
			   stmt = conn.createStatement();
			
			   String sql = "REPLACE INTO Idiomas (idioma) VALUES ('" + language + "')";
	                  
	           stmt.executeUpdate(sql);
	       } catch (SQLException se) {            
	           se.printStackTrace();
	       } catch (Exception e) {
	           e.printStackTrace();
	       } finally {
	           closeStm(conn, stmt);
	           closeCon(conn);
	       } 
	   }
	
}