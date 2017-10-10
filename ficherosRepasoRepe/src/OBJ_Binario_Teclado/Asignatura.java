package OBJ_Binario_Teclado;

import java.io.Serializable;

public class Asignatura implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8991570554508287952L;
	int codAsignatura;
	String nombreAsignatura;
	String nombreProfesor;
	int nHoras;
	
	
	
	public Asignatura(int codAsignatura, String nombreAsignatura,
			String nombreProfesor, int nHoras) {
		this.codAsignatura = codAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.nombreProfesor = nombreProfesor;
		this.nHoras = nHoras;
	}
	
	
	public int getCodAsignatura() {
		return codAsignatura;
	}


	public void setCodAsignatura(int codAsignatura) {
		this.codAsignatura = codAsignatura;
	}


	public String getNombreAsignatura() {
		return nombreAsignatura;
	}


	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}


	public String getNombreProfesor() {
		return nombreProfesor;
	}


	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}


	public int getnHoras() {
		return nHoras;
	}


	public void setnHoras(int nHoras) {
		this.nHoras = nHoras;
	}


	
	
	

}
