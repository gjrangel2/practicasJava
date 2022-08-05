package modelo;

public class Productos {

	public Productos() {
		
		nArticulo="";
		seccion="";
		nombre="";
		pais="";
	}
	
	
	public String getnArticulo() {
		return nArticulo;
	}
	public void setnArticulo(String nArticulo) {
		this.nArticulo = nArticulo;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}


	private String nArticulo;
	private String seccion;
	private String nombre;
	private String pais;
}
