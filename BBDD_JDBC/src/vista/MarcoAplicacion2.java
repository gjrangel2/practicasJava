package vista;
import controlador.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import controlador.*;

public class MarcoAplicacion2 extends JFrame{
	
	public MarcoAplicacion2() {
		
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
			
			
// poner a la escucha lo que se programó dentro de controladorcargasecciones
			
			addWindowListener(new ControladorCargaMenus(this));
			botonConsulta.addActionListener(new ControlaBotonEjecuta(this));
			
		}
	
	public JComboBox secciones;
	public JComboBox paises;
	public JTextArea resultado;
}
