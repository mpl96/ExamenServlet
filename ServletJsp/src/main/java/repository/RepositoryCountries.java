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

public class RepositoryCountries {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();
	private Repository repository = new Repository();
	/*
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
	*/
	public  List<Countries> listCountries(){
		Connection conn = manager.open(jdbcUrl);
		List<Countries> listCountries2= new ArrayList<Countries>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Statement stmt = null;
	
	    try {
			    stmt = conn.createStatement();
				
				prepareStatement = conn.prepareStatement("SELECT * FROM Countries");
				resultSet = prepareStatement.executeQuery();
				while(resultSet.next()){
					Countries datesInDatabase = new Countries();
					datesInDatabase.setCountry(resultSet.getString(1));
					datesInDatabase.setLanguage(resultSet.getString(2));
					
					listCountries2.add(datesInDatabase);
				}
	
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	repository.closeStm(conn, stmt);
        	repository.closeRs(resultSet);
        	repository.closeCon(conn);
        } 
	    return listCountries2;
	}
	/*
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
	*/
	public void insertTableCountries(String country, String language){
    	Connection conn = manager.open(jdbcUrl);
        Statement stmt = null;

        try {
		    stmt = conn.createStatement();
		
		    String sql = "REPLACE INTO Countries (country,languageCountry) VALUES ('" + country + "', '" + language + "')";
                   
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	repository.closeStm(conn, stmt);
        	repository.closeCon(conn);
        } 
    }
	
}