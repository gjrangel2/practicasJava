package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;
import vista.*;

public class ControlaBotonEjecuta implements ActionListener {


	public ControlaBotonEjecuta(MarcoAplicacion2 elmarco) {
		
		this.elmarco=elmarco;
	//vamos a decirle al constructor que almacene en este campo de clase llamado elmarco-
		//el marco que le voy a pasar por parametro
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String seleccionSeccion=(String)elmarco.secciones.getSelectedItem();//hemos almacenado en selseccion lo que el usuario escoio en el  primer jcombobox
		String seleccionpais=(String)elmarco.paises.getSelectedItem();//seleccion del 2do jcombobox
		
		resultadoConsulta=obj.filtraBBDD(seleccionSeccion, seleccionpais);
//en este resultset se almacena el resultado de ejecutar el metodo filtrra bbdd, pasandole por parametro
//lo que ha escogido en los dos desplegable, con lo cual se pasa a la clase ejecutaConsulta  y almacena
		// en seccion y en pais lo que se escogio en los desplegables y luego conecta con la BBDD
		
		try {
			
			elmarco.resultado.setText("");
			while(resultadoConsulta.next()) {
				
				elmarco.resultado.append(resultadoConsulta.getString(1));
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(2));
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(3));
				elmarco.resultado.append("\n");
				
				//elmarco.resultado.append(resultadoConsulta.getString(4));
				//elmarco.resultado.append("\n");
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private MarcoAplicacion2 elmarco;
	EjecutaConsultas obj=new EjecutaConsultas();//instancia de EjecutaConsultas
	//del paquete modelo
	private ResultSet resultadoConsulta;

}
