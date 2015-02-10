package es.open4job.sigad.model.vo;

import java.sql.Date;

public class MatriculaVO {
	
	private int id;
	private Date fechaCurso;
	private String tipoEnsenanza;
	private String ensenanza;
	private String curso;
	private int idAlumno;
	
	public MatriculaVO(int id,Date fechaCurso,String tipoEnsenanza, String ensenanza,
			String curso,int idAlumno){
		
		this.id=id;
		this.fechaCurso=fechaCurso;
		this.tipoEnsenanza=tipoEnsenanza;
		this.ensenanza=ensenanza;
		this.curso=curso;
		this.idAlumno=idAlumno;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaCurso() {
		return fechaCurso;
	}

	public void setFechaCurso(Date fechaCurso) {
		this.fechaCurso = fechaCurso;
	}

	public String getTipoEnsenanza() {
		return tipoEnsenanza;
	}

	public void setTipoEnsenanza(String tipoEnsenanza) {
		this.tipoEnsenanza = tipoEnsenanza;
	}

	public String getEnsenanza() {
		return ensenanza;
	}

	public void setEnsenanza(String ensenanza) {
		this.ensenanza = ensenanza;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	@Override
	public String toString() {
		return "MatriculaVO [id=" + id + ", fechaCurso=" + fechaCurso
				+ ", tipoEnsenanza=" + tipoEnsenanza + ", ensenanza="
				+ ensenanza + ", curso=" + curso + ", idAlumno=" + idAlumno
				+ "]";
	}

	
	
	
	
}
