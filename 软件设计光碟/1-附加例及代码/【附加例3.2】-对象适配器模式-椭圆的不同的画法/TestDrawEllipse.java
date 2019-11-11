
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.awt.Container;

public class TestDrawEllipse implements ItemListener
{
   private JFrame frame;
   private JComboBox drawOptions;
   private EllipseGUIAdapter ellipAdapt;
   private Container contentPane;
   private JPanel comboBoxPanel;
   private final String DRAWBYCORNER="Draw Ellpse by Corner Point, Width and height.";
   private final String DRAWBYCENTER="Draw Ellpse by Center Point and Radius.";

   public TestDrawEllipse () {
	   frame = new JFrame();

	   contentPane = frame.getContentPane();
       contentPane.setLayout(new BorderLayout());

	   drawOptions = new JComboBox();
	   drawOptions.addItem("Choose a way to draw an ellipse");
	   drawOptions.addItem(DRAWBYCORNER);
	   drawOptions.addItem(DRAWBYCENTER);
	   drawOptions.addItemListener(this);

       comboBoxPanel = new JPanel();
       comboBoxPanel.setBackground(Color.pink);
	   comboBoxPanel.add(drawOptions);

	   contentPane.add(comboBoxPanel, "South");

       ellipAdapt = new EllipseGUIAdapter();

       frame.setSize(300, 400);
       frame.setVisible(true);
  }

   public void itemStateChanged(ItemEvent ie) {
      String selected = (String)drawOptions.getSelectedItem();

  	  if(selected.compareTo(DRAWBYCORNER)==0){
	     contentPane.removeAll();
  		 JPanel panel1 = ellipAdapt.drawOvalByCorner(20, 20, 200, 130);

  		 contentPane.add(comboBoxPanel, "South");
	     contentPane.add(panel1, "Center");

  	     frame.repaint();
         frame.setVisible(true);
  	  }
      else if(selected.compareTo(DRAWBYCENTER)==0) {
		 contentPane.removeAll();  //(jpanel);
  		 JPanel panel2 = ellipAdapt.drawOvalByCenter(150, 150, 100, 76);

  	     contentPane.add(comboBoxPanel, "South");
	     contentPane.add(panel2, "Center");

  	     frame.repaint();
         frame.setVisible(true);
  	  }
   }

	public static void main(String[] args) {
		new TestDrawEllipse();
	}
}


