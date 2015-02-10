package es.open4job.sigad.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public interface MatriculaDAOInterface{
	
	public void InsertarMatricula(int idMatricula, Date fecha, String centro,
			String tipoEnsenanza, String ensenanza, String curso,
			Connection conn)throws SQLException;
	public void BorrarMatricula(int id, Connection conn)throws SQLException;
	public void ModificarMatricula (int idMatricula, Date fecha, String centro,
			String tipoEnsenanza, String ensenanza, String curso, Connection conn)throws SQLException;
	

	
}
