
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class AdapterClient extends JFrame
{
  private JScrollPane showInfoPane;
  private JSplitPane  bigSplitPane;
  private Dimension   minimumSize;
  private JTextArea infoTxt;
  private JPanel txtPanel;
  private JPanel btnPanel;
  private JPanel lowerPanel;
  private JTextField txtField;

  public AdapterClient() {
     super("Adapter Pattern-Sort String Arrays. ");
     minimumSize = new Dimension(130, 100);
     setUpChoicePanel();
     setUpScrollPanes();
   }

   private void setUpChoicePanel() {
      JButton sortBtn = new JButton("Sort");
      sortBtn.addActionListener( new ButtonActionListener());
      JButton exitBtn = new JButton("Exit");
      exitBtn.addActionListener( new ButtonActionListener());

      btnPanel =new JPanel();
      btnPanel.add(sortBtn);
      btnPanel.add(exitBtn);

      txtField = new JTextField();
      txtField.setBackground(Color.cyan);

      JLabel lb = new  JLabel("Input Text File Name.");
      txtPanel = new JPanel();

      txtPanel.setLayout(new BorderLayout());
      txtPanel.add(lb, "West");
      txtPanel.add(txtField, "Center");

      lowerPanel = new JPanel();
      lowerPanel.setMinimumSize(new Dimension(500, 300));
      lowerPanel.setLayout(new BorderLayout());
      lowerPanel.add(txtPanel, "Center");
      lowerPanel.add(btnPanel, "South");
   }

   private void setUpScrollPanes() {
   	  Border raisedbevel = BorderFactory.createRaisedBevelBorder();

  	  infoTxt = new JTextArea("Sorting Result Will be Shown Here. ", 23,33);
  	  infoTxt.setBackground(Color.pink);
  	  infoTxt.setBorder(raisedbevel);
  	  infoTxt.setFont(new Font("Arial", Font.BOLD, 15));

  	  showInfoPane = new JScrollPane(infoTxt);

  	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, showInfoPane, lowerPanel );
  	  bigSplitPane.setDividerLocation(320);

      getContentPane().add(bigSplitPane);
  	  setSize(new Dimension(500, 300));
      setVisible(true);
   }

   class ButtonActionListener implements ActionListener {
      public void actionPerformed(ActionEvent ae) {
		 infoTxt.setText( "");
		 String file = txtField.getText();
         String act = ae.getActionCommand();

	     if(act.equals("Sort")) {
			StrArraySortAdapter adapt = new StrArraySortAdapter();
            String[] input = adapt.inputFromFile(file);
	        String[] sorted = adapt.sortStringArray(input);

	        for ( int k = 0; k < sorted.length; k++ )
	           infoTxt.append( "\n" + sorted[k]);
	     }
	     if(act.equals("Exit")) {
		    System.exit(1);
	     }
      }
  }

   public static void main(String args[])
   {
      try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      }
      catch (Exception evt) {}

      AdapterClient frame = new AdapterClient();
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e)
         {
            System.exit(0);
         }
      }
      );
      frame.setSize(500, 420);
      frame.setVisible(true);
   }
}

