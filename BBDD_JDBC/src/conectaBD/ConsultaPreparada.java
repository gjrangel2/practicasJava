package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. ESTABLECER LA CONEXION
		
		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial","root","");
		
		//2. PREPARAR LA COSNULTA
			
			PreparedStatement miSentencia=miConexion.prepareStatement("SELECT NOMBREARTICULO, NOMBRE, APELLIDO FROM ALUMNOS2 WHERE EDAD=? AND APELLIDO=?");
		
			//3.ESTABLECER PARAMETROS DE CONSULTA
			
			miSentencia.setInt(1, 80);
			miSentencia.setString(2, "RANGEL");
			
			//4. EJECUTAR Y RECORRER LA CONSULTA
			
			ResultSet rs=miSentencia.executeQuery();
			
			
			while(rs.next()) {
				
				System.out.println(rs.getString(1)+ " " + rs.getString(2)+" " + rs.getString(3));
				
			}
			
			rs.close(); //cerrar para liberar memoria
			
		//REUTILIZACION DE CONSULTA SQL
			
			System.out.println("EJECUCION SEGUNDA CONSULTA");
			System.out.println("");
			
			miSentencia.setInt(1, 16);
			miSentencia.setString(2, "ORTEGA");
			
			//4. EJECUTAR Y RECORRER LA CONSULTA
			
			rs=miSentencia.executeQuery();
			
			
			while(rs.next()) {
				
				System.out.println(rs.getString(1)+ " " + rs.getString(2)+" " + rs.getString(3));
				
			}
			
			rs.close(); //cerrar para liberar memoria
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//CONTRASEÑA DEL SQL

	}

}
