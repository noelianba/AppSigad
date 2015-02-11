package es.open4job.sigad.model.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean
@SessionScoped
public class MatriculaDAOBean  implements MatriculaDAOInterface, Serializable{

	//@Resource(name="jdbc/myoracle")
	private DataSource ds;
	
	public MatriculaDAOBean() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		}
	public void InsertarMatricula(int idMatricula, Date fecha, String centro,
			String tipoEnsenanza, String ensenanza, String curso) throws SQLException {
		Connection conn = ds.getConnection();
		PreparedStatement stmt = conn
				.prepareStatement("INSERT INTO matriculas (id, fecha_curso, centro, tipo_ensenanza, enseñanza, curso) VALUES (?,?,?,?,?,?");
		stmt.setInt(1, idMatricula);
		stmt.setDate(2, (java.sql.Date) fecha);
		stmt.setString(3, centro);
		stmt.setString(4, tipoEnsenanza);
		stmt.setString(5, ensenanza);
		stmt.setString(5, curso);
		stmt.executeUpdate();
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

	public void BorrarMatricula(int id) throws SQLException {
		
		Connection conn = ds.getConnection();
		PreparedStatement stmt = conn.prepareStatement("DELETE * FROM matriculas WHERE id=?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}
	
	public void ModificarMatricula (int idMatricula, Date fecha, String centro,
			String tipoEnsenanza, String ensenanza, String curso) throws SQLException{
		
		Connection conn = ds.getConnection();
		PreparedStatement stmt = conn.prepareStatement("UPDATE FROM matriculas SET fecha_curso=?, centro=?, tipo_ensenanza=?, enseñanza=?, curso=? WHERE id=? )");
		stmt.setDate(1, (java.sql.Date) fecha);
		stmt.setString(2, centro);
		stmt.setString(3, tipoEnsenanza);
		stmt.setString(4, ensenanza);
		stmt.setString(5, curso);
		stmt.setInt(6, idMatricula);
		stmt.executeUpdate();
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

}
