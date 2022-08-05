package modelo;

import java.sql.*;

public class EjecutaConsultas {
	
	public EjecutaConsultas() {
		
		miConexion=new Conexion();
	}
	
	public ResultSet filtraBBDD(String seccion, String pais) {
		
		//pruebas="";
		Connection conecta=miConexion.dameConexion();
		
		rs=null;
		
		try {
		if(!seccion.equals("TODOS")&&pais.equals("TODO")) {
			
				//pruebas="has escogido seccion";
					
			enviaConsultaSeccion= conecta.prepareStatement(consultaSeccion);
			
			enviaConsultaSeccion.setString(1, seccion);
			
			rs=enviaConsultaSeccion.executeQuery();
			
		}else if(seccion.equals("TODOS")&& !pais.equals("TODO")) {
			
			//pruebas="Has escogido PAis";
			
			enviaConsultaPais= conecta.prepareStatement(consultaPais);
			
			enviaConsultaPais.setString(1, pais);
			
			rs=enviaConsultaPais.executeQuery();
			
			
		}else {
			
			//pruebas="has escogido ambos";
			enviaConsultaTodos= conecta.prepareStatement(consultaTodos);
			
			enviaConsultaTodos.setString(1, seccion);
			enviaConsultaTodos.setString(2, pais);
			
			rs=enviaConsultaTodos.executeQuery();
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	return pruebas;
		
		return rs;
		
	}
	
	//private String pruebas;
	private Conexion miConexion;
	
	private ResultSet rs;
	
	private PreparedStatement enviaConsultaSeccion;
	private PreparedStatement enviaConsultaPais;
	private PreparedStatement enviaConsultaTodos;
	
	private final String consultaSeccion="SELECT NOMBRE, EDAD,  APELLIDO FROM ALUMNOS2 WHERE NOMBRE=?";
	private final String consultaPais="SELECT NOMBRE, EDAD,  APELLIDO FROM ALUMNOS2 WHERE APELLIDO=?";
	private final String consultaTodos="SELECT NOMBRE, EDAD,  APELLIDO FROM ALUMNOS2 WHERE NOMBRE=? AND APELLIDO=?";
}
