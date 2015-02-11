package es.open4job.sigad.model.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.open4job.jsf.model.vo.EstacionServicio;
import es.open4job.sigad.model.vo.MatriculaVO;




@ManagedBean
@SessionScoped
public class MatriculaDAOBean  implements MatriculaDAOInterface, Serializable{

	//@Resource(name="jdbc/opensigad")
	private DataSource ds;
	
	String insert = "insertarMatricula";
	String borrar = "borrarMatricula";
	String modificar = "modificarMatricula";
	
	public MatriculaDAOBean() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		}
	public String InsertarMatricula(int idMatricula, Date fecha, String centro,
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
		return insert;
	}

	public String BorrarMatricula(int id) throws SQLException {
		
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
		return borrar;
	}
	
	public String ModificarMatricula (int idMatricula, Date fecha, String centro,
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
	return modificar;
	}
	
	public ArrayList<MatriculaVO> getListadoMatricula() throws Exception {
		
		Connection conn = ds.getConnection();
		ArrayList<MatriculaVO> lista = new ArrayList<MatriculaVO>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM matriculas");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			lista.add (new MatriculaVO(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	return lista;
	}
}
