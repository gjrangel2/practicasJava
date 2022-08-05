package graficos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

public class ejemploarea{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		marcoarea mimarco= new marcoarea();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}

class marcoarea extends JFrame{
	
	public marcoarea() {
	
	setTitle("PRUEBAS ACCIONES");
		
	setBounds(600, 300,650,300);
	
	laminaarea lamina=new laminaarea();
	
    add(lamina);
    setVisible(true);
		
	}
	
	
}


class laminaarea extends JPanel{
	
	public laminaarea() {
		
		miarea=new JTextArea(8, 20);
		
		JScrollPane laminabarras=new JScrollPane(miarea);//crea barras de desplazamiento
		
		JButton miboton=new JButton("Dale");
		
		
		
		miboton.addActionListener(new gestionarea());
		
		miarea.setLineWrap(true);
				
		add(laminabarras);
		
		add(miboton);
	}
	
	private class gestionarea implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			System.out.println(miarea.getText());
			
		}
		
		
	}
	private JTextArea miarea;
		
		
	
}