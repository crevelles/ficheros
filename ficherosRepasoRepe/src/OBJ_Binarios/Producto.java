package OBJ_Binarios;

import java.io.Serializable;

public class Producto implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -5097591394697307810L;

//	Crea una clase Producto en el proyecto con los siguientes atributos: id
//	(int), nombre (String), medidas (String), precio (float). Crea también sus
//	constructores, getters y setters. Ten en cuenta que objetos de esta clase
//	serán almacenados en ficheros binarios.
//	Crea una clase InsertarProductos que mediante un array de objetos
//	Producto introduzca 10 productos en un fichero binario productos.dat.
//	Almacena el fichero dentro de la carpeta del proyecto
	
	int id;
	String nombre, medidas;
	float precio;
	
	public Producto(int id, String nombre, String medidas, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.medidas = medidas;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMedidas() {
		return medidas;
	}
	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
