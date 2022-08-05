
package controlador;

import java.awt.event.*;

import modelo.*;
import vista.*;

public class ControladorCargaMenus extends WindowAdapter {
	
	public ControladorCargaMenus(MarcoAplicacion2 elmarco) {
		
		this.elmarco=elmarco;
		
	}

	
	public void windowOpened(WindowEvent e) {
		
		obj.ejecutaConsultas();//necesito ejecutar el metodo ejecuta consulas de la clase marcoaplicacion2
		
		//--recorrer el resultset de la clase carga secciones  por lo que debo usar la instancia
		//perteneciente a esa clase  
		
		try {
			
			while(obj.rs.next()) { //el recordset rs existe porque previamente ejecutamos el metodo que lo construye ejecutaconsulta
				
			elmarco.secciones.addItem(obj.rs.getString(1));//agregar dentro del parentesis lo que haya dentro del resultset
//a cada vuelta del bucle while cogemos cada elemento del rs y lo metemos  en el jcombobox de marcoaplicacion2
	//para eso usamos la instancia de la clase donde se encuentra el jcombobox(elmarco.secciones	)
			}
			
			while(obj.rs2.next()) {
				
				elmarco.paises.addItem(obj.rs2.getString(1));
				
				
			}
			
		}catch(Exception e2) {
			
			e2.printStackTrace();
		}
		
	}
	
	CargaMenus obj=new CargaMenus();
	
	private MarcoAplicacion2 elmarco;
}
