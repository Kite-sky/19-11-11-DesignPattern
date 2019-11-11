import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.geom.Ellipse2D;

// Represents a Piece of the Wuzi Qi Game
class GChessPiece extends Canvas {
	 Color color = null;
	 Ellipse2D circle = new Ellipse2D.Double(0.0d, 0.0d, 26.0d, 26.0d);

	 GChessPiece(Color color) {
		  this.color=color;
	      setSize(26, 26);
	 }
	 public void paint(Graphics g) {
		  Graphics2D g2 = (Graphics2D)g;
	      g2.setColor(color);
	      g2.fill(circle);
	 }
}

