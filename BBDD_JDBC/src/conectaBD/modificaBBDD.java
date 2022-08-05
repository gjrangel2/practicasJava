package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class modificaBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
try {
			
			//1. CREAR CONEXION
			
			Connection miConexion =DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial","root","12345678");//CONTRASEÑA DEL SQL
		
			
			//2. CREAR OBJETO STATEMENT
			
			Statement miStatement= miConexion.createStatement();
			
//--------LA SIGUIENTE INSTRUCCIONSQL SE USA PARA AGREGAR DATOS A
			//------LAS TABLAS DE LA BASE DE DATOS
			/*String instruccionSql="INSERT INTO ALUMNOS2 (NOMBREARTICULO, NOMBRE, APELLIDO, EDAD, DIRECCION) VALUES ('201', 'MARTINEZ', 'ANAMILENA', '555', 'ALAMEDADELRIO' )";
			*/
			
			
//LA SIGUIENTE INSTRUCCION SE USA PARA ACTUALLIZAR O CAMBIAR DATOS EXISTENTE-------------
			
			/*String instruccionSql="UPDATE ALUMNOS2 SET EDAD=EDAD*2 WHERE NOMBREARTICULO= '102'";*/
			
//LA SIGUIENTE INSTRUCCION SE USA PARA BORRAR DATOS EXISTENTES-------------
			
			String instruccionSql="DELETE FROM ALUMNOS2 WHERE NOMBREARTICULO='201'";
			
			
			miStatement.executeUpdate(instruccionSql);
			
			System.out.println("datos BORRADOSs correctamente");
			
		}catch(Exception e) {
			
			System.out.println("no conecta 2");
			
			e.printStackTrace();
			
			
		}

	}


}
