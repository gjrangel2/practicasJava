package conectaBD;

import java.sql.*;

public class ConectaPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			//1. CREAR CONEXION
			
			Connection miConexion =DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial","root","12345678");//CONTRASEÑA DEL SQL
		
			
			//2. CREAR OBJETO STATEMENT
			
			Statement miStatement= miConexion.createStatement();
			
			// 3. EJECUTAR SQL
			
			ResultSet miResultset=miStatement.executeQuery("SELECT * FROM ALUMNOS2");//NOMBRE DE TABLA
			
			//4. RECORRER EL RESULTSET
			
			while(miResultset.next()) {
				
				/*System.out.println(miResultset.getString("NOMBREARTICULO")+ " " 
				+ miResultset.getString("APELLIDO")+ " "+ miResultset.getString("EDAD"));*/
				
				System.out.println(miResultset.getString(1)+ " " 
						+ miResultset.getString(3)+ " "+ miResultset.getInt(4));
			}
		
		}catch(Exception e) {
			
			System.out.println("no conecta");
			
			e.printStackTrace();
			
			
		}

	}

}
