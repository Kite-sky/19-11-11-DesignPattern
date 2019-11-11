import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class TrafficLightGUI extends JPanel{
   private final int COORDX = 80, COORDY = 80,D = 50, d=8;
   private Context cxt;
   private Color color;

   public TrafficLightGUI(){
	  setBackground(Color.cyan);
	  setUpStateContext();
   }
   private void setUpStateContext(){
	  cxt = new Context();
   }
   private void runTrafficLights(){
	  color = cxt.getColor();
	  cxt.doAction();
   }
   public void paint(Graphics g){
	  super.paint(g);
      try{
	     runTrafficLights();
	     Graphics2D g2 = (Graphics2D) g;
	     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			               RenderingHints.VALUE_ANTIALIAS_ON);

	     // Draw a outline of the traffic light plate
	     g2.setPaint(Color.gray);
	     g2.fill(new RoundRectangle2D.Double(COORDX-20, COORDY-20, 160, 90, 12, 12));
	     // Draw camera
	     g2.setPaint(Color.yellow);
	     g2.fill(new Ellipse2D.Double(COORDX, COORDY-16, d, d));

	      // Draw traffic light
	      g2.setPaint(color);
		  g2.fill(new Ellipse2D.Double(COORDX+35, COORDY, D, D));

         Thread.sleep(2000);
         repaint();
	  }catch(InterruptedException e){
          e.printStackTrace();
	   }
    }
    private static void createAndShowGUI(){
        JFrame f = new JFrame("State Pattern-Traffic Light");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 250);
        TrafficLightGUI tf = new TrafficLightGUI();
        f.getContentPane().add(tf);
        f.setVisible(true);
    }
    public static void main(String args[]) {
        Runnable doCreateAndShowGUI = new Runnable() {
            public void run() {
              createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
    }
}
