import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ObservableGUI extends JFrame {
     private JTextArea infoTxt;
     public static String RED= "Red";
     public static String GREEN = "Green";
     public static String BLUE = "Blue";

     public ObservableGUI() {
           super(" Event based system demo");
           infoTxt = new JTextArea(" An observer/observable test . ", 23, 33);
	       infoTxt.setFont(new Font("Arial", Font.BOLD, 15));

           ButtonObserver btnObserver = new ButtonObserver(infoTxt);
           JButton redBtn = new JButton(RED);
           JButton greenBtn = new JButton(GREEN );
           JButton blueBtn = new JButton(BLUE);
	       redBtn.addActionListener(btnObserver );
	       greenBtn.addActionListener( btnObserver);
	       blueBtn.addActionListener( btnObserver);

	       JPanel btnPanel =new JPanel();
	       btnPanel.add(redBtn);
           btnPanel.add(greenBtn);
           btnPanel.add(blueBtn);

	       JSplitPane bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, infoTxt , btnPanel);
	       bigSplitPane.setDividerLocation(100);

	        getContentPane().add(bigSplitPane);
	    	setSize(new Dimension(350, 200));
            setVisible(true);
   }
  public static void main(String args[]) {
      try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      }
      catch (Exception evt) {}
      ObservableGUI frame = new ObservableGUI();
      frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)  {
                  System.exit(0);
            }
      }  );
      frame.setVisible(true);
   }
}

