package es.open4job.sigad.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class MatriculaDAO  implements MatriculaDAOInterface{

	public void InsertarMatricula(int idMatricula, Date fecha, String centro,
			String tipoEnsenanza, String ensenanza, String curso,
			Connection conn) throws SQLException {
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

	public void BorrarMatricula(int id, Connection conn) throws SQLException {
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
			String tipoEnsenanza, String ensenanza, String curso, Connection conn) throws SQLException{
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
