package graficos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;

import poo.coche;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.imageio.*;

public class campopassword{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		marcopassword mimarco= new marcopassword();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}

class marcopassword extends JFrame{
	
	public marcopassword() {
	
	setTitle("PRUEBAS ACCIONES");
		
	setBounds(600, 300,650,300);
	
	laminapassword lamina=new laminapassword();
	
    add(lamina);
    setVisible(true);
		
	}
	
	
}


class laminapassword extends JPanel{
	
	public laminapassword() {
		
		setLayout(new BorderLayout());
		
		JPanel laminasuperior=new JPanel();
		
		laminasuperior.setLayout(new GridLayout(2,2));
		
		add(laminasuperior, BorderLayout.NORTH);
		
		JLabel etiqueta1=new JLabel("Usuario");
		
		JLabel etiqueta2=new JLabel("Contraseña");
		
		JTextField cusuario=new JTextField(15);
		
		
		compruebapass mievento=new compruebapass();
		ccontra=new JPasswordField(15);
		ccontra.getDocument().addDocumentListener(mievento);
		
		laminasuperior.add(etiqueta1);
		laminasuperior.add(cusuario);
		laminasuperior.add(etiqueta2);
		laminasuperior.add(ccontra);
		
		JButton enviar=new JButton("Enviar");
		add(enviar, BorderLayout.SOUTH);
		
		
				
	}
	
	private class compruebapass implements DocumentListener{

		
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
		
			
			char [] contrasena;
			
			contrasena=ccontra.getPassword();
			
			if(contrasena.length<8 || contrasena.length>12) {
				
				ccontra.setBackground(Color.RED);
				
				}else {
					
					ccontra.setBackground(Color.WHITE);
				}
		}

		
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("has BORRADO texto");
		}

		
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	JPasswordField ccontra;
}