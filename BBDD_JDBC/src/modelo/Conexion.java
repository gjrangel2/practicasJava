package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	Connection miConexion=null;
	
	public Conexion() {
		
		
	}

	public Connection dameConexion() {
		
		try {
			miConexion=
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial","root","12345678");
		}catch(Exception e) {
			
			
		}
		
		return miConexion;
	}
	
	
}
