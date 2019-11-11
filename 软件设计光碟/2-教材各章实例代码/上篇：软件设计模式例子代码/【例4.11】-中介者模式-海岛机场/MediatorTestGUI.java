/*==============================================*/
/* This is the user interface class for testing */
/* the system designed using mediator pattern   */
/*==============================================*/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MediatorTestGUI extends JFrame implements ItemListener{
   private JScrollPane checkBoxPane;
   private JScrollPane orderPane;
   private JSplitPane downSplitPane;
   private JSplitPane bigSplitPane;
   private Dimension minimumSize;
   private JTextArea airHomeTxtArea;
   private JTextArea runwayTxtArea;
   private JTextArea airTxtArea;
   private JTextArea orderTxtArea;
   private JPanel checkBoxPanel;
   private JPanel btnPanel;
   private JPanel choicePanel;
   private JCheckBox battle;
   private JCheckBox bomber;
   private JCheckBox transporter;
   private JButton takeoffBtn;
   private JButton landBtn;
   private JButton exitBtn;
   private JPanel airHomePanel;
   private JPanel runwayPanel;
   private JPanel airPanel;
   private JPanel txtPanel;
   private Airplane battlePlane;
   private Airplane bomberPlane;
   private Airplane transporterPlane;
   private int[] states;
   private ControlTower med;
   public final int SELECTED = ItemEvent.SELECTED;
   public final int DESELECTED = ItemEvent.DESELECTED;
   String[] pHome;
   String[] pAirData;
   String   pRunwayData;

   public MediatorTestGUI(){
      super("Mediator Pattern- Island airport");
      minimumSize = new Dimension(130, 100);
      states = new int[3];
      orderTxtArea=new JTextArea("Order notes", 3,10);

      med = new ControlTower(orderTxtArea);
      battlePlane = new Battleplane("F17", "k00123", med,orderTxtArea);
      bomberPlane = new Bomber("B52", "b3825",med,orderTxtArea);
      transporterPlane = new Transporter("T700", "ty332",med,orderTxtArea);

      setUpChoicePanel();
      setUpScrollPanes();
   }

   private void setUpChoicePanel(){
      takeoffBtn = new JButton("Takeoff");
      takeoffBtn.addActionListener( new ButtonActionListener());
      landBtn = new JButton("Land");
      landBtn.addActionListener( new ButtonActionListener());
      exitBtn = new JButton("Exit");
      exitBtn.addActionListener( new ButtonActionListener());

      btnPanel =new JPanel();
      btnPanel.add(takeoffBtn);
      btnPanel.add(landBtn);
      btnPanel.add(exitBtn);

      battle  = new JCheckBox("battle");
      bomber  = new JCheckBox("bomber");
      transporter  = new JCheckBox("transporter");

      battle.setMnemonic(KeyEvent.VK_C);
      bomber.setMnemonic(KeyEvent.VK_C);
      transporter.setMnemonic(KeyEvent.VK_C);

      battle.addItemListener(this);
      bomber.addItemListener(this);
      transporter.addItemListener(this);

      checkBoxPanel = new JPanel();
      checkBoxPanel.setLayout(new GridLayout(3,1));
      checkBoxPanel.add(battle);
      checkBoxPanel.add(bomber);
      checkBoxPanel.add(transporter);

      choicePanel = new JPanel();
      choicePanel.setMinimumSize(new Dimension(500, 300));
      choicePanel.setLayout(new BorderLayout());

      choicePanel.add(checkBoxPanel, "Center");
      choicePanel.add(btnPanel, "South");
   }
   private void setUpScrollPanes(){
   	  checkBoxPane = new JScrollPane(choicePanel);
  	  checkBoxPane.getViewport().setBackground(Color.green);
  	  orderPane = new JScrollPane(orderTxtArea);
  	  orderPane.getViewport().setBackground(Color.cyan);

      downSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, checkBoxPane, orderPane);
      downSplitPane.setDividerLocation(250);

      Border raisedbevel = BorderFactory.createRaisedBevelBorder();

  	  airHomeTxtArea = new JTextArea("The Airplane Home", 3,10);
  	  runwayTxtArea = new JTextArea("Airplane Runway", 3,10);
  	  airTxtArea = new JTextArea("Airplanes in the Air",3,10);
  	  airHomeTxtArea.setBackground(Color.green);
  	  runwayTxtArea.setBackground(Color.yellow);
  	  airTxtArea.setBackground(Color.cyan);
  	  airHomeTxtArea.setBorder(raisedbevel);
  	  runwayTxtArea.setBorder(raisedbevel);
  	  airTxtArea.setBorder(raisedbevel);
  	  airHomeTxtArea.setFont(new Font("Arial", Font.BOLD, 14));
  	  runwayTxtArea.setFont(new Font("Arial", Font.BOLD, 14));
  	  airTxtArea.setFont(new Font("Arial", Font.BOLD, 14));

  	  txtPanel = new JPanel();
  	  txtPanel.setLayout(new GridLayout(1,3));
  	  txtPanel.setMinimumSize(new Dimension(500, 300));
  	  txtPanel.add(airHomeTxtArea);
  	  txtPanel.add(runwayTxtArea);
  	  txtPanel.add(airTxtArea);

  	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, txtPanel,downSplitPane);
  	  bigSplitPane.setDividerLocation(160);

      getContentPane().add(bigSplitPane);
  	  setSize(new Dimension(500, 300));
      setVisible(true);
      setAirInfo();
   }

   class ButtonActionListener implements ActionListener{
      public void actionPerformed(ActionEvent ae){
         String act = ae.getActionCommand();
	     if(act.equals("Takeoff")) {
		    if(states[2] == SELECTED)
		       battlePlane.executeTakeoff();
		    if(states[1] == SELECTED)
		       bomberPlane.executeTakeoff();
		    if(states[0] == SELECTED)
		       transporterPlane.executeTakeoff();
	     }
	     else if(act.equals("Land")) {
		    if(states[2] == SELECTED)
               battlePlane.executeLanding();
            if(states[1] == SELECTED)
		       bomberPlane.executeLanding();
		    if(states[0] == SELECTED)
		       transporterPlane.executeLanding();
	     }

	     if(act.equals("Exit")){
		    System.exit(1);
	     }
         setAirInfo();
      }
   }
   public void itemStateChanged(ItemEvent e){
      Object source = e.getItemSelectable();
	  int state = e.getStateChange();
      if (source == battle) {
	     states[2]=state;
      }
      else if (source == bomber) {
		 states[1]=state;
      }
      else if (source == transporter) {
	     states[0]=state;
      }
  }
  private void setAirInfo(){
     airHomeTxtArea.setText("The Airplane Home\n\n");
	 airTxtArea.setText("Airplanes in the Air \n\n");
     runwayTxtArea.setText("Airplane Runway \n\n");
	 pHome = med.getPlaneHomeData();
	 pAirData = med.getPlaneInAirData();
	 pRunwayData = med.getRunwayData();

	 if(pHome[0]!="") {
	    airHomeTxtArea.append ("\n"+ pHome[0]);
	 }
	 if(pHome[1]!="") {
	    airHomeTxtArea.append ("\n"+pHome[1]);
	 }
	 if(pHome[2]!="")  {
		airHomeTxtArea.append ("\n"+pHome[2]);
	 }
	 if(pAirData[0]!="") {
		airTxtArea.append ("\n"+pAirData[0]);
	 }
	 if(pAirData[1]!="") {
		airTxtArea.append ("\n"+pAirData[1]);
	 }
	 if(pAirData[2]!="") {
		airTxtArea.append ("\n"+pAirData[2]);
	 }
	 if(pRunwayData !="" )
		runwayTxtArea.append ("\n"+pRunwayData);
   }

   public static void main(String args[]){
      try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      }
      catch (Exception evt){
		 evt.printStackTrace();
	  }

      MediatorTestGUI frame = new MediatorTestGUI();
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e){
            System.exit(0);
         }
      }
      );
      frame.setSize(500, 310);
      frame.setVisible(true);
   }
}

