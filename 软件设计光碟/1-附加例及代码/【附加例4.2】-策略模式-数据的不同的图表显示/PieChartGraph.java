

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Arc2D;


/*===============================================*/
/* An instance of this class represents a JPanel */
/* with a pie chart drawn on it.                 */
/*===============================================*/
public class PieChartGraph extends JPanel implements ChartGraph{
   private double[] slices;
   private Shape arcs[];
   private double total = 0.0D;
   private int inputLen;

   final static double X = 100.0D;
   final static double Y = 20.0D;
   final static double W = 100.0D;
   final static double H = 100.0D;

   public PieChartGraph(double[] slices){
	  this.slices = slices;
	  inputLen = slices.length;
      arcs = new Shape[inputLen];
      setBackground(Color.pink);
   }

   public void paintComponent(Graphics g){
	  super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                          RenderingHints.VALUE_ANTIALIAS_ON);

      for (int i=0; i<inputLen; i++) {
	     total += slices[i];
      }
      double curValue = 0.0D;
      int startAngle = 0;

      for(int i=0; i<inputLen; i++) {
         // Compute the start and end angles
         startAngle = (int)(curValue * 360 / total);
         int arcAngle = (int)(slices[i]* 360 / total);
         arcs[i] = new Arc2D.Double(X, Y, W, H, startAngle, arcAngle, Arc2D.PIE);

         // Ensure that no gap between the first and last slice
         if (i == inputLen-1) {
            arcAngle = 360 - startAngle;
         }

         // Set the color and draw a filled arc
         g2.setColor(ChartColor.getColor(slices[i]));
         g2.fill(arcs[i]);

         curValue += slices[i];
      }
      addGraphInfo(g2);
      return;
   }
   public void addGraphInfo(Graphics2D graph){
      graph.drawString("Pie chart expression of the production by month", 10, 10);
   }
}