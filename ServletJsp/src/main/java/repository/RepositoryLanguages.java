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

public class RepositoryLanguages {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();
	
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
	
	public  List<Languages> listLanguages(){
    	Connection conn = manager.open(jdbcUrl);
    	List<Languages> listLanguages2 = new ArrayList<Languages>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Statement stmt = null;

        try {
            Class.forName("org.h2.Driver");
		   
		    stmt = conn.createStatement();
			
			prepareStatement = conn.prepareStatement("SELECT * FROM Idiomas");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Languages datesInDatabase = new Languages();
				datesInDatabase.setLanguages(resultSet.getString(1));
				
				listLanguages2.add(datesInDatabase);
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

	public  void insertTableLanguages(String language){
		   Connection conn = manager.open(jdbcUrl);
	       Statement stmt = null;

	       try {
	           Class.forName("org.h2.Driver");
			 
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