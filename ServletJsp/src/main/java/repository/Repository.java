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
	
	public void DeleteTable(String language){
		Connection conn = manager.open(jdbcUrl);
	    Statement stmt = null;
	
	    try {
	        Class.forName("org.h2.Driver");
			
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

	
}