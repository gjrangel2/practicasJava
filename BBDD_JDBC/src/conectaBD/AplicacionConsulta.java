package conectaBD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.mysql.cj.protocol.Resultset;

public class AplicacionConsulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new MarcoAplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}
	
	}

class MarcoAplicacion extends JFrame{
	
	public MarcoAplicacion() {
		
		setTitle ("CONSULTA BBDD");
		
		setBounds(500, 300, 400, 400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		secciones.setEditable(false);
		secciones.addItem("TODOS");
		
		paises=new JComboBox();
		paises.setEditable(false);
		paises.addItem("TODO");
		
		resultado=new JTextArea(4,50);
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		menus.add(paises);
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta= new JButton("CONSULTA");
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		botonConsulta.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ejecutaConsulta();
				
			}
		
		});
		
		//-------CONEXION CON BBDD------------
		
		try {
			miConexion=
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial","root","");
		
			
			Statement sentencia= miConexion.createStatement();
		
			//-----CARGA JCOMBOBOX GENERO
			String consulta="SELECT DISTINCTROW SECCION FROM ALUMNOS2 ";//sentencia sql
			 			
			ResultSet rs=sentencia.executeQuery(consulta);//crear el resultset
			
			while(rs.next()) {
				
				secciones.addItem(rs.getString(1));
							
				
			}
			
			rs.close();
			
			//---JCOMBOBOX PAISES
			
			consulta="SELECT DISTINCTROW PAIS FROM ALUMNOS2";
			
			rs=sentencia.executeQuery(consulta);//crear el resultset
			
			while(rs.next()) {
				
				paises.addItem(rs.getString(1));
							
				
			}
			
			rs.close();
			
			
			
		}catch(Exception e) {
			
		}
		
		
	}
	
	private void ejecutaConsulta() {
		
		ResultSet rs=null;
		
		try {
			
			resultado.setText("");
		
			String seccion=(String) secciones.getSelectedItem();
			String pais=(String) paises.getSelectedItem();
			
			if(!seccion.equals("TODOS")&& pais.equals("TODO")) {
					
			enviaConsultaSeccion= miConexion.prepareStatement(consultaSeccion);
						
			enviaConsultaSeccion.setString(1, seccion);
			
			rs=enviaConsultaSeccion.executeQuery();
			
			}else if(seccion.equals("TODOS")&& !pais.equals("TODO")){
				
				enviaConsultaPais= miConexion.prepareStatement(consultaPais);
				
				enviaConsultaPais.setString(1, pais);
				
				rs=enviaConsultaPais.executeQuery();	
				
			}else if(!seccion.equals("TODOS") && !pais.equals("TODO")) {
				
				enviaConsultaTodos= miConexion.prepareStatement(consultaTodos);
				
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				
				rs=enviaConsultaTodos.executeQuery();
				System.out.println(enviaConsultaTodos);
			}
			
			while(rs.next()) {
				
			resultado.append(rs.getString(1));	
			resultado.append(", ");
			resultado.append(rs.getString(2));	
			resultado.append(", ");
			resultado.append(rs.getString(3));	
			resultado.append(", ");
			resultado.append(rs.getString(4));	
			
			resultado.append("\n ");
				
				
			}			
			
		}catch(Exception e) {
			
			
		}
	}
	
		
	private Connection miConexion;
	private PreparedStatement enviaConsultaSeccion;
	private PreparedStatement enviaConsultaPais;
	private PreparedStatement enviaConsultaTodos;
	private JComboBox secciones;	
	private final String consultaSeccion="SELECT NOMBREARTICULO, NOMBRE, GENERO, PAIS FROM ALUMNOS2 WHERE SECCION=?";
	private final String consultaPais="SELECT NOMBREARTICULO, NOMBRE, GENERO, PAIS FROM ALUMNOS2 WHERE PAIS=?";
	private final String consultaTodos="SELECT NOMBREARTICULO, NOMBRE, GENERO, PAIS FROM ALUMNOS2 WHERE SECCION=? AND"
			+ " PAIS=?";
	private JComboBox paises;
	private JTextArea resultado;
	
	
}