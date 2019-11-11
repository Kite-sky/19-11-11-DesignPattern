
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/*===================================================*/
/* An instance of this class represents a JPanel     */
/* with an ellipse drawn on it. The ellipse is       */
/* drawn by the coordinates of the upper left corner */
/* and the width and height of the ellipse specified */
/*===================================================*/

public class EllipseGraph extends JPanel{
   private Shape ovalShape;
   private double xCorner, yCorner, xLen, yLen;

   public EllipseGraph(double xCorner, double yCorner, double xLen, double yLen){
	  this.xCorner = xCorner;
	  this.yCorner = yCorner;
	  this.xLen = xLen;
	  this.yLen = yLen;

      ovalShape = new Ellipse2D.Double(xCorner, yCorner, xLen, yLen);
      setBackground(Color.pink);
   }

   public void paintComponent(Graphics g){
	  super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                          RenderingHints.VALUE_ANTIALIAS_ON);
      g2.draw(ovalShape);
      return;
   }
}
