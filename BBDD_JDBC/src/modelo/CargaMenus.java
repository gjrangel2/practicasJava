package modelo;

import java.sql.*;

import com.mysql.cj.protocol.Resultset;

import controlador.*;


public class CargaMenus {
	
	public CargaMenus() {
		
		miConexion= new Conexion();
	}
	
	/*public String ejecutaConsulta() {
		
		Productos miProducto=null;
		
		Connection accesoBBDD=miConexion.dameConexion();//estoy conectando con la base de datos
		
		try {
			
			Statement secciones=accesoBBDD.createStatement();
			
			rs=secciones.executeQuery("SELECT DISTINCTROW NOMBRE FROM ALUMNOS2");
			
		//	while(rs.next()) {
	//prescindimos del bucle while porque ya estamos recorriendo el rs en la clase controladorcargasecciones
				
				miProducto=new Productos();
				
				miProducto.setSeccion(rs.getString(1));//almacenar la seccion en miproducto y de inmediato
				//me lo devuelve--paso a otro producto diferente... empiezo el bucle nuevamente
				//almacena la siguinet seccion en mi producto y me lo devuelve
				
				//return miProducto.getSeccion();
			//}
			
			rs.close();
			
		}catch(Exception e) {
			
			
		}
		return miProducto.getSeccion();
		
	}*/
	
	public ResultSet ejecutaConsultas() {
		
		Productos miProducto=null;
		Connection accesoBBDD=miConexion.dameConexion();
		
		try {
			Statement secciones = accesoBBDD.createStatement();
			Statement apellidos = accesoBBDD.createStatement();
			rs= secciones.executeQuery("SELECT DISTINCTROW NOMBRE FROM ALUMNOS2");
			rs2= apellidos.executeQuery("SELECT DISTINCTROW APELLIDO FROM ALUMNOS2");
			
			miProducto=new Productos();
			
			miProducto.setSeccion(rs.getString(1));
			miProducto.setPais(rs2.getString(1));
			
			rs.close();
			rs2.close();
			
			accesoBBDD.close();
			
		}catch(Exception e) {
			
			
		}
		return null;
	}
	
	
	Conexion miConexion;
	public ResultSet rs, rs2;
	

}
