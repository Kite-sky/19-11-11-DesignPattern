
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class FacadeGUI extends JFrame implements ItemListener
{
  private JScrollPane showInfoPane;
  private JSplitPane  bigSplitPane;
  private Dimension   minimumSize;
  private JTextArea infoTxt;
  private JPanel checkBoxPanel;
  private JPanel btnPanel;
  private JPanel choicePanel;
  private SecurityFacade secuFacade;
  private JCheckBox  activateCkBox, deactivateCkBox, sendDataCkBox, callCkBox;
  private int[] states;

  public final int SELECTED = ItemEvent.SELECTED;
  public final int DESELECTED = ItemEvent.DESELECTED;

  public FacadeGUI() {
     super("Facade Pattern-Safe Home System");
     minimumSize = new Dimension(130, 100);
     states = new int[4];

     secuFacade=new SecurityFacade() ;
     setUpChoicePanel();
     setUpScrollPanes();
   }

   private void setUpChoicePanel()
   {
      JButton submit = new JButton("Submit");
      submit.addActionListener( new ButtonActionListener());
      JButton exitBtn = new JButton("Exit");
      exitBtn.addActionListener( new ButtonActionListener());

      btnPanel =new JPanel();
      btnPanel.add(submit);
      btnPanel.add(exitBtn);

      activateCkBox = new JCheckBox("Activate");
      deactivateCkBox  = new JCheckBox("Deactivate");
      sendDataCkBox  = new JCheckBox("SendData");
      callCkBox = new JCheckBox("Call");

      activateCkBox.setMnemonic(KeyEvent.VK_C);
      deactivateCkBox.setMnemonic(KeyEvent.VK_C);
      deactivateCkBox.setMnemonic(KeyEvent.VK_C);
      callCkBox.setMnemonic(KeyEvent.VK_C);

      activateCkBox.addItemListener(this);
      deactivateCkBox.addItemListener(this);
      sendDataCkBox.addItemListener(this);
      callCkBox.addItemListener(this);

      checkBoxPanel = new JPanel();
      checkBoxPanel.setLayout(new GridLayout(4,1));
      checkBoxPanel.add(activateCkBox);
      checkBoxPanel.add(deactivateCkBox);
      checkBoxPanel.add(sendDataCkBox);
      checkBoxPanel.add(callCkBox);

      choicePanel = new JPanel();
      choicePanel.setMinimumSize(new Dimension(500, 300));
      choicePanel.setLayout(new BorderLayout());

      choicePanel.add(checkBoxPanel, "Center");
      choicePanel.add(btnPanel, "South");
   }

   private void setUpScrollPanes()
   {
   	  Border raisedbevel = BorderFactory.createRaisedBevelBorder();

  	  infoTxt = new JTextArea("The information for SafeHome information will be shown here. ", 23,33);
  	  infoTxt.setBackground(Color.pink);
  	  infoTxt.setBorder(raisedbevel);
  	  infoTxt.setFont(new Font("Arial", Font.BOLD, 15));

  	  showInfoPane = new JScrollPane(infoTxt);

  	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, showInfoPane, choicePanel );
  	  bigSplitPane.setDividerLocation(250);

      getContentPane().add(bigSplitPane);
  	  setSize(new Dimension(500, 300));
      setVisible(true);
   }

   class ButtonActionListener implements ActionListener
   {
      public void actionPerformed(ActionEvent ae)
      {
         String act = ae.getActionCommand();
	     if(act.equals("Submit")) {
			infoTxt.setText("");
		    if(states[0] == SELECTED) {
		       String activate = secuFacade.activate();
		       System.out.println(activate);
		       infoTxt.append(activate);
		       infoTxt.append("\n");
		    }
		    if(states[1] == SELECTED) {
		       String deact = secuFacade.deactivate();
		       infoTxt.append(deact);
		       infoTxt.append("\n");
			}
		    if(states[2] == SELECTED) {
		       String aquire = secuFacade.aquireData();
		       infoTxt.append(aquire);
		       infoTxt.append("\n");
			}
		    if(states[3] == SELECTED) {
		       String cal = secuFacade.call();
		       infoTxt.append(cal);
		       infoTxt.append("\n");
			}
	     }
	    if(act.equals("Exit"))
	    {
		   System.exit(1);
	    }
      }
  }

  public void itemStateChanged(ItemEvent e)
  {
     Object source = e.getItemSelectable();
	 int state = e.getStateChange();

     if (source == activateCkBox) {
	    states[0]=state;
     }
     else if (source == deactivateCkBox) {
		states[1]=state;
     }
     else if (source == sendDataCkBox) {
	    states[2]=state;
     }
     else if (source == callCkBox) {
	 	states[3]=state;
     }
  }

   public static void main(String args[])
   {
      try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      }
      catch (Exception evt) {}

      FacadeGUI frame = new FacadeGUI();
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

