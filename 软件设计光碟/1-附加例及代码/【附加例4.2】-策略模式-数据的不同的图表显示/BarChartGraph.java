

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Rectangle2D;


/*===============================================*/
/* An instance of this class represents a JPanel */
/* with a bar chart drawn on it.                 */
/*===============================================*/

public class BarChartGraph extends JPanel implements ChartGraph{
   private Shape rectangle[];
   private double[] height;
   private int inputLen;

   public BarChartGraph(double[] height){
	  this.height = height;
      setBackground(Color.pink);
      inputLen = height.length;
      rectangle = new Shape[inputLen];
   }

   public void paintComponent(Graphics g){
	  super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                          RenderingHints.VALUE_ANTIALIAS_ON);

      int len = height.length;

 	  for(int k=0; k< inputLen; k++){
 	     rectangle[k] = new Rectangle2D.Double(50+25.0*k, 140-height[k], 20.0, height[k]);
	  }

      for(int k=0; k< len; k++){
		 g2.setColor( ChartColor.getColor(height[k]));
         g2.fill(rectangle[k]);
	  }
	  addGraphInfo(g2);
      return;
   }
   public void addGraphInfo(Graphics2D graph){
      graph.drawString("Bar chart expression of the production by month", 10, 10);
   }
}