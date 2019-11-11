import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

class GFan extends Canvas{
	  JPanel panel =null;
	  static final int DELAY = 500;
	  static final int X = 5;
	  static final int Y = 5;
	  Color COLOR[] = { Color.red, Color.cyan, Color.orange,
	                               Color.magenta, Color.yellow, Color.blue };
      int startAngle = 0;
	  int NUM_ARCS = COLOR.length;
	  int arcAngle = (360 / NUM_ARCS)-10;
	  int width, height;

	  GFan(JPanel panel) {
			this.panel = panel;
			setSize(500, 350);
		    width = getWidth()-50;
		    height = getHeight()-50;
	  }
	  public void paint(Graphics g) {
		    Graphics2D  g2 = (Graphics2D)g;
		    super.paint(g2);
            //Draw the original Fan
            synchronized (COLOR) {
				 for (int i = 0; i < NUM_ARCS; i++) {
					  g2.setColor(COLOR[i]);
					  g2.fillArc(X, Y, width, height, startAngle, arcAngle);
					  startAngle += arcAngle+10;
				 }
		    }
	  }
	  public void keepRunning() {
	       TimerTask task = new TimerTask() {
	            public void run() {
					  shiftColor();
					  repaint();
		        }
	       };
	       Timer timer = new Timer();
	       timer.schedule(task, 0, DELAY);
      }
      // shift color by 1 position
      private void shiftColor(){
		    Color c = COLOR[0];
		    for(int k=0; k< COLOR.length-1; k++){
		   	     Color temp = COLOR[k+1];
			     COLOR[k] = temp;
		     }
             COLOR[COLOR.length - 1] = c;
	  }
	  public void startRotate() {
		  setVisible(true);
		  keepRunning();
		  panel.add(this);
		  repaint();
	  }
	  public void stopRotate() {
		  panel.add(this);
		  repaint();
	}
}
