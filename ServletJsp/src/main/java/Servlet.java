import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class Servlet extends HttpServlet{
	
	private ConnectionManager manager = new ConnectionH2();
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Paises paises = assemblePaisesFromRequest(req);
		Idiomas idiomas = assembleIdiomasFromRequest(req);
		try {
			if(existeEnBaseDeDatos(paises)){
				actualizar(paises);
			}else{
				insertar(paises);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(existeEnBaseDeDatos2(idiomas)){
				actualizar(idiomas);
			}else{
				insertar(idiomas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		redirect(req,resp);	
	}

	private void insertar(Paises paises) {
		Connection conn = manager.open(jdbcUrl);
		manager.close(conn);
	}
	
	private void insertar(Idiomas idiomas) {
		Connection conn = manager.open(jdbcUrl);
		manager.close(conn);
	}

	private void actualizar(Paises paises) {
		Connection conn = manager.open(jdbcUrl);
		manager.close(conn);
	}
	
	private void actualizar(Idiomas idiomas) {
		Connection conn = manager.open(jdbcUrl);
		manager.close(conn);
	}

	private boolean existeEnBaseDeDatos(Paises paises) throws SQLException{
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement prepareStatement;
		prepareStatement = conn.prepareStatement("SELECT * FROM PAISES WHERE PAIS = '" + paises.getPais()+"'");
		ResultSet rs = prepareStatement.executeQuery();
		
		if (rs.next()) {/*
			System.out.println("Update");
			prepareStatement.close();
			
			prepareStatement = conn.prepareStatement("UPDATE PAISES where PAIS = '" + paises.getPais() +"'");
			
			prepareStatement.execute();
			prepareStatement.close();
			System.out.println("Updated");
			manager.close(conn);
			return true;
		} else {*/
			System.out.println("Insert");
			prepareStatement.close();
			String sql = "INSERT INTO PAISES(PAIS) VALUES('" + paises.getPais() + "')";
			try {
				prepareStatement = conn.prepareStatement(sql);
				prepareStatement.execute();
				prepareStatement.close();
				System.out.println("insertado");
			} catch (SQLException e) {

				throw new RuntimeException(e);
			}
			try {
				prepareStatement.close();
			} catch (SQLException e) {

			}
		}
		manager.close(conn);
		return false;
	}
	
	private boolean existeEnBaseDeDatos2(Idiomas idiomas) throws SQLException{
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement prepareStatement;
		prepareStatement = conn.prepareStatement("SELECT * FROM IDIOMAS WHERE IDIOMA = '" + idiomas.getIdioma()+"'");
		ResultSet rs = prepareStatement.executeQuery();
		
		
		if (rs.next()) {/*
			System.out.println("Update");
			prepareStatement.close();
			
			prepareStatement = conn.prepareStatement("UPDATE IDIOMAS where IDIOMA = '" + idiomas.getIdioma() +"'");
			
			prepareStatement.execute();
			prepareStatement.close();
			System.out.println("Updated");
			manager.close(conn);
			return true;
		} else {*/
			System.out.println("Insert");
			prepareStatement.close();
			String sql = "INSERT INTO PAISES(NOMBRE) VALUES('" + idiomas.getIdioma() + "')";
			try {
				prepareStatement = conn.prepareStatement(sql);
				prepareStatement.execute();
				prepareStatement.close();
				System.out.println("insertado");
			} catch (SQLException e) {

				throw new RuntimeException(e);
			}
			try {
				prepareStatement.close();
			} catch (SQLException e) {

			}
		}
		manager.close(conn);
		return false;
	}

	private Paises assemblePaisesFromRequest(HttpServletRequest req) {
		Paises paises = new Paises();
		String nombre = req.getParameter("nombre");
		paises.setPais(nombre);
		return paises;
	}
	
	private Idiomas assembleIdiomasFromRequest(HttpServletRequest req) {
		Idiomas idiomas = new Idiomas();
		String idioma = req.getParameter("idioma");
		idiomas.setIdioma(idioma);
		return idiomas;
	}

	private void closeConnection(Connection connectToDatabase) {
		try {
			connectToDatabase.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	private void executeSqlQuery(Connection connectToDatabase, String sql)  {
		PreparedStatement prepareStatement;
		try {
			prepareStatement = connectToDatabase.prepareStatement(sql);
			prepareStatement.execute();
			prepareStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Connection connectToDatabase()  {
		Connection conn ;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:./src/main/resources/test.mv", "sa", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		return conn;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		redirect(req,resp);
	}
	

	private void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/fin.jsp");
		dispatcher.forward(req,resp);
	}
}