package es.open4job.sigad.model.bean;

import java.sql.SQLException;
import java.util.Date;

public interface MatriculaDAOInterface{
	
	public String InsertarMatricula(int idMatricula, Date fecha, String centro,
			String tipoEnsenanza, String ensenanza, String curso)throws SQLException;
	public String BorrarMatricula(int id)throws SQLException;
	public String ModificarMatricula (int idMatricula, Date fecha, String centro,
			String tipoEnsenanza, String ensenanza, String curso)throws SQLException;
	
}
