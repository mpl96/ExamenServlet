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
    	List<Languages> listLanguages = new ArrayList<Languages>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Statement stmt = null;

        try {
		    stmt = conn.createStatement();
			
			prepareStatement = conn.prepareStatement("SELECT * FROM Languages");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Languages datesInDatabase = new Languages();
				datesInDatabase.setLanguages(resultSet.getString(1));
				
				listLanguages.add(datesInDatabase);
			}

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeRs(resultSet);
            closeCon(conn);
        } 
        return listLanguages;
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
			   stmt = conn.createStatement();
			
			   String sql = "REPLACE INTO Languages (language) VALUES ('" + language + "')";
	                  
	           stmt.executeUpdate(sql);
	       } catch (Exception e) {
	           e.printStackTrace();
	       } finally {
	           closeStm(conn, stmt);
	           closeCon(conn);
	       } 
	   }
	
}