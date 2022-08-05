package graficos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JFrame;
import javax.swing.*;

public class trabajandocolores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		marcoconcolor mimarco= new marcoconcolor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class marcoconcolor extends JFrame{
	
	public marcoconcolor() {
	
	setTitle("prueba ccon colores");
	
	setSize(400, 400);
	
	laminaconcolor milamina=new laminaconcolor();
	
	add(milamina);
	
	milamina.setBackground(Color.YELLOW);
	
	}
}

class laminaconcolor extends JPanel{
	
	public void paintComponent(Graphics g) {//el metodo paintcomponent que sobreescribe
	//el metodo paincomponent de jpanel
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g; //casting de graphics2d para convertir nuestro
		//objeto g en un obbjeto de graphiscs2d que denomino g2
		
		
		//dibujo del rectangulo 
		
		Rectangle2D rectangulo=new Rectangle2D.Double(100, 100, 200, 150);
		
		g2.setPaint(Color.GREEN);
				
		g2.fill(rectangulo);
		
		g2.setPaint(Color.BLACK);
		
		g2.draw(rectangulo);
		
		//dibujo de la elipse
		
		Ellipse2D elipse= new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);
		
		//forma 1 de dar color
		
		Color micolor= new Color(125, 189,250);
		
		g2.setPaint(micolor);
		
		
		//forma 2 de dar color
		//g2.setPaint(new Color(100,140,255).brighter().brighter().darker());
		
		g2.fill(elipse);
		
		
		}
}
