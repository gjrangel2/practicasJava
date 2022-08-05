package graficos;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
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

import javax.swing.JFrame;

import javax.swing.*;
import javax.imageio.*;
public class calculadora{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		marcocalculadora mimarco=new marcocalculadora();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
		
	}

}


class marcocalculadora extends JFrame{
	
	public marcocalculadora() {
		
		setTitle("calculadora");
		
		setBounds(500,300,450,300);
		
		laminacalculadora milamina=new laminacalculadora();
		
		add(milamina);
		
		pack();
		
	}
	
}

class laminacalculadora extends JPanel{
	
	public laminacalculadora(){
		
		principio =true;
		
		setLayout(new BorderLayout());
		
		pantalla=new JButton("CALCULADORA");
		
		pantalla.setEnabled(false);
		
		add(pantalla, BorderLayout.NORTH);
		
		milamina2=new JPanel();
		
		milamina2.setLayout(new GridLayout(4,4));
		
		ActionListener insertar=new insertanumero();//instancia clase insertar numero
		ActionListener orden=new Accionorden();
		
		
		
		ponerboton("7", insertar);
		ponerboton("8", insertar);
		ponerboton("9", insertar);
		ponerboton("/",orden);
		ponerboton("4", insertar);
		ponerboton("5", insertar);
		ponerboton("6", insertar);
		ponerboton("*",orden);
		ponerboton("1", insertar);
		ponerboton("2", insertar);
		ponerboton("3", insertar);
		ponerboton("-",orden);
		ponerboton("0", insertar);
		ponerboton(".", insertar);
		ponerboton("=",orden);
		ponerboton("+",orden);
		
		/*JButton boton1=new JButton("1");
		
		milamina2.add(boton1);
		
		JButton boton2=new JButton("2");
		
		milamina2.add(boton2);
		
		JButton boton3=new JButton("3");
		
		milamina2.add(boton3);
		
		JButton boton4=new JButton("4");
		
		milamina2.add(boton4);
		
		JButton boton5=new JButton("5");
		
		milamina2.add(boton5);
		
		JButton boton6=new JButton("6");
		
		milamina2.add(boton6);
		
		JButton boton7=new JButton("7");
		
		milamina2.add(boton7);
		
		JButton boton8=new JButton("8");
		
		milamina2.add(boton8);*/
		
		add(milamina2, BorderLayout.CENTER);
		
		ultimaoperacion="=";
	}
	
	private void ponerboton(String rotulo, ActionListener oyente) {//recibimos dos parametros uno de strin y otro de tipoactionlistener
		
		JButton boton=new JButton(rotulo);
		
		boton.addActionListener(oyente);//poner el boton a la escucha del evento cada uno de los botones
		
		milamina2.add(boton);
		
	}
	
	private class insertanumero implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			String entrada=e.getActionCommand();//almacenar en la variable de tipo string entrada el texto del
			//boton que ha desencadenado el evento
			
			if(principio) {
				
				pantalla.setText("");
				
				principio=false;
			}
			
			pantalla.setText(pantalla.getText()+entrada);//el metodo gettext captura el texto de la pantalla
			//y se concatena con lo que vayamos almacenando en la variable entrada
			
		}
		
		
				
	}
	private class Accionorden implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			String operacion=e.getActionCommand();
			
			
			//System.out.println(operacion);
			
			calcular(Double.parseDouble(pantalla.getText()));//se pone ese metodo para convertir el string en un double
			
			ultimaoperacion=operacion;
			
			principio=true;//se utiliza para resetear el display cuando se presione algun simbolo operacion
			
			
		}
		
		
		public void calcular(double x) {
			
			if(ultimaoperacion.equals("+")) {
				
				resultado+=x;//sumar a esta variable lo que le hayamos pasado por parametro .. pantalla
				
				System.out.println(resultado);
				
			}
			
			else if(ultimaoperacion.equals("-")) {
				
				resultado-=x;
			}
			
			else if(ultimaoperacion.equals("*")) {
				
				resultado*=x;
			}
			
			else if(ultimaoperacion.equals("/")) {
	
				resultado/=x;
			}
			else if(ultimaoperacion.equals("=")) {
				
				resultado=x;
			}
			
			
			pantalla.setText("" +resultado);//al concatenar  la variable resultado con una cadena vacia lo convertimos en un tipo String
		}
		
	}
	
	private JPanel milamina2;
	
	private JButton pantalla;
	
	private boolean principio;
	
	private double resultado;
	
	private String ultimaoperacion;
}
