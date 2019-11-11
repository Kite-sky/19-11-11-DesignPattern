import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Iterator;

/*===================================================================*/
/* User interface for Testing the Composite design pattern program   */
/*===================================================================*/
public class AirforceGUI extends JFrame implements ItemListener{
  private JScrollPane checkBoxPane, textPane;
  private JSplitPane  splitPane;
  private JTextArea   txtAirMission;
  private JButton submitBtn, exitBtn;
  private JPanel checkBoxPanel, btnPanel, choicePanel;
  private JCheckBox[] airCheckBox;
  private JCheckBox[] airUnitCheckBox;
  private String[] airPlaneName ={"F-15E-Strike-Eagle","F-16C/D-Fighting-Falcon","F22A-Rapter",
				                  "B-1B-Lancer","B-2A-Spirit","B-52H-Stratofortress",
				                  "C-130E/H-Hercules","C-130J-Super-Hercules","CV-22B-Osprey",
				                  "E-9A",  "EC-130H/J-Compass", "AirForce","Fighters",
				                  "Bombers", "Transporters", "E-Planes"};
  private String[] AirForceUnit = {"SQUADRON", "GROUP", "WING"};

  public final int SELECTED = ItemEvent.SELECTED;
  public final int DESELECTED = ItemEvent.DESELECTED;
  private static final String[] OPTION = {"Solo", "Group"};
  private JComboBox[] optComoBox=new JComboBox[11];
  private int[] ckBoxStates;

  private GridBagLayout gridbag = new GridBagLayout();
  private GridBagConstraints gbc = new GridBagConstraints();

  public AirforceGUI(){
     super("Composite Pattern - Airforce");
     ckBoxStates = new int[50];
     setUpChoicePanel();
     setUpScrollPanes();
  }
  private void setUpChoicePanel(){
     submitBtn = new JButton("Submit");
     exitBtn = new JButton("Exit");
     submitBtn.addActionListener( new ButtonActionListener());
     exitBtn.addActionListener( new ButtonActionListener());
     JPanel btnPanel =new JPanel();
     btnPanel.add(submitBtn);
     btnPanel.add(exitBtn);
     int numCheckBox = airPlaneName.length;
     airCheckBox = new JCheckBox[numCheckBox];
     airUnitCheckBox = new JCheckBox[3];
     //Check boxes for selection of the airplanes
     for(int m=0; m<numCheckBox; m++){
	    airCheckBox[m]= new JCheckBox(airPlaneName[m]);
		airCheckBox[m].setMnemonic(KeyEvent.VK_C);
		airCheckBox[m].addItemListener(this);
	 }
	  //Check boxes for selection of air units
	  for(int m=0; m<3; m++){
		airUnitCheckBox[m]= new JCheckBox(AirForceUnit[m]);
		airUnitCheckBox[m].setMnemonic(KeyEvent.VK_C);
		airUnitCheckBox[m].addItemListener(this);
	 }
     //Combobox for deciding on solo flight or not
     for(int i=0;i<11;i++){
	    optComoBox[i]= new JComboBox(OPTION);
		optComoBox[i].addItemListener(this);
	 }
     checkBoxPanel = new JPanel();
     checkBoxPanel.setLayout(gridbag);

     for(int m=0; m<numCheckBox; m++)
	    checkBoxPanel.add(airCheckBox[m]);
	 for(int m=0; m<3; m++)
	    checkBoxPanel.add(airUnitCheckBox[m]);
	 for(int i=0;i<11;i++)
	    checkBoxPanel.add(optComoBox[i]);

     gbc.insets.top = 0;
     gbc.insets.bottom = 0;
     gbc.insets.left = 0;
     gbc.insets.right = 0;
     gbc.anchor = GridBagConstraints.WEST;
     add(0, 0, airCheckBox[11]);
     add(1, 1, airCheckBox[12]);
     add(2, 3, airCheckBox[0]);
     add(2, 4, airCheckBox[1]);
     add(2, 5, airCheckBox[2]);
     add(1, 6, airCheckBox[13]);
	 add(2, 7, airCheckBox[3]);
	 add(2, 8, airCheckBox[4]);
     add(2, 9, airCheckBox[5]);
	 add(1, 10, airCheckBox[14]);
	 add(2, 11, airCheckBox[6]);
	 add(2, 12, airCheckBox[7]);
     add(2, 13, airCheckBox[8]);
     add(1, 14, airCheckBox[15]);
     add(2, 15, airCheckBox[9]);
     add(2, 16, airCheckBox[10]);
	 add(3, 3, optComoBox[0]);
	 add(3, 4, optComoBox[1]);
     add(3, 5, optComoBox[2]);
	 add(3, 7, optComoBox[3]);
	 add(3, 8, optComoBox[4]);
     add(3, 9, optComoBox[5]);
	 add(3, 11, optComoBox[6]);
	 add(3, 12, optComoBox[7]);
     add(3, 13, optComoBox[8]);
	 add(3, 15, optComoBox[9]);
     add(3, 16, optComoBox[10]);
     add(0, 17, airUnitCheckBox[0]);
	 add(0, 18, airUnitCheckBox[1]);
     add(0, 19, airUnitCheckBox[2]);

     choicePanel = new JPanel();
     choicePanel.setMinimumSize(new Dimension(500, 300));
     choicePanel.setLayout(new BorderLayout());
     choicePanel.add(checkBoxPanel, "Center");
     choicePanel.add(btnPanel, "South");
  }
  private void add(int m, int n, JComponent com ){
	 gbc.gridx = m;
	 gbc.gridy = n;
     gridbag.setConstraints(com, gbc);
  }
  private void setUpScrollPanes(){
     txtAirMission = new JTextArea(3,10);
     txtAirMission.setBackground(Color.cyan);
     txtAirMission.setText("选择军事单位：空军中队(SQUADRON)，空军团(GROUP)或者空军大队(WING)"
                           + "\n组成固定单位的战斗力量。你也可以直接选择各种机型形成临时的编队"
                           +"\n飞行(在组合框中选Group)或者单飞（在组合框中选Solo）。");
     checkBoxPane = new JScrollPane(choicePanel);
     textPane = new JScrollPane(txtAirMission);
     textPane.setMinimumSize(new Dimension(500, 100));

     splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, checkBoxPane, textPane);
     splitPane.setDividerLocation(470);

     getContentPane().add(splitPane);
     setSize(new Dimension(500, 500));
     setVisible(true);
  }

  //========================================
  // 新增加功能，需要理解本监听器所涉及的方法。
  //========================================
  class ButtonActionListener implements ActionListener{
     public void actionPerformed(ActionEvent e) {
		txtAirMission.setText("\n===Airforce New Mission===\n");
		createAirGroup(e);
     }
  }
  public void itemStateChanged(ItemEvent e){
     Object source = e.getItemSelectable();
	 int state = e.getStateChange();

	 if (source == airCheckBox[11]) {
	    if(state == SELECTED){
		   for(int m=12; m<16; m++)
			  airCheckBox[m].setSelected(true);
		}
		else if (state == DESELECTED){
		   for(int m=12; m<16; m++)
			  airCheckBox[m].setSelected(false);
		}
	 }
	 else if (source ==  airCheckBox[12]) {
		if(state == SELECTED){
		   for(int m=0; m<3; m++)
			  airCheckBox[m].setSelected(true);
		}
		else if (state == DESELECTED){
		   for(int m=0; m<3; m++)
			  airCheckBox[m].setSelected(false);
		}
	 }
	 else if (source == airCheckBox[0])
		ckBoxStates[0]=state;
	 else if (source == airCheckBox[1])
		ckBoxStates[1]=state;
	 else if (source == airCheckBox[2])
		ckBoxStates[2]=state;
	 else if (source == airCheckBox[13]){
		if(state == SELECTED){
		   for(int m=3; m<6; m++)
			  airCheckBox[m].setSelected(true);
		}
		else if (state == DESELECTED){
		   for(int m=3; m<6; m++)
			  airCheckBox[m].setSelected(false);
		}
	 }
	 else if (source == airCheckBox[3])
		ckBoxStates[3]=state;
	 else if (source == airCheckBox[4])
		ckBoxStates[4]=state;
	 else if (source == airCheckBox[5])
		ckBoxStates[5]=state;
	 else if (source == airCheckBox[14]){
		if(state == SELECTED){
		   for(int m=6; m<9; m++)
			  airCheckBox[m].setSelected(true);
		}
		else if (state == DESELECTED){
		   for(int m=6; m<9; m++)
			  airCheckBox[m].setSelected(false);
		}
	 }
	 else if (source == airCheckBox[6])
		ckBoxStates[6]=state;
	 else if (source == airCheckBox[7])
		ckBoxStates[7] = state;
	 else if (source == airCheckBox[8])
		ckBoxStates[8]=state;
	 else if (source == airCheckBox[15]){
		if(state == SELECTED){
		   airCheckBox[9].setSelected(true);
		   airCheckBox[10].setSelected(true);
		}
		else if (state == DESELECTED){
		   airCheckBox[9].setSelected(false);
		   airCheckBox[10].setSelected(false);
		}
	 }
	 else if (source == airCheckBox[9])
		ckBoxStates[9]=state;
	 else if (source == airCheckBox[10])
		ckBoxStates[10]=state;
	 //== for air units
	 else if (source == airUnitCheckBox[0])
	 		ckBoxStates[11]=state;
	 else if (source == airUnitCheckBox[1])
		ckBoxStates[12]=state;
	 else if (source == airUnitCheckBox[2])
		ckBoxStates[13]=state;
  }
  private void createAirGroup(ActionEvent e){
	 Airforce airCraft = null;
	 Airforce unit = null;
	 AirUnit airGroup = new AirUnit();
	 AirUnit airUnits = new AirUnit();

	 boolean isSolo = false;
	 int len = ckBoxStates.length;
	 String unitInfo = null;

	 if (e.getActionCommand().equals("Submit")) {
		for(int m = 0; m < len; m++ ){
  	       if ((m==0) && (ckBoxStates[0] == SELECTED)) {
		      airCraft = new F15();
			  if(optComoBox[0].getSelectedItem().equals("Solo"))
			     isSolo = true;
		   }
		   else if ((m==1) && (ckBoxStates[1] == SELECTED)){
			  airCraft = new F16();
			  if(optComoBox[1].getSelectedItem().equals("Solo"))
			     isSolo = true;
		   }
		   else if ((m==2) && (ckBoxStates[2] == SELECTED)){
			  airCraft = new F22();
			  if(optComoBox[2].getSelectedItem().equals("Solo"))
			     isSolo = true;
           }
		   else if ((m==3) && (ckBoxStates[3] == SELECTED)){
			  airCraft = new B1B();
			  if(optComoBox[3].getSelectedItem().equals("Solo"))
			     isSolo = true;
		   }
           else if ((m==4) && (ckBoxStates[4] == SELECTED)) {
              airCraft = new B2A();
              if(optComoBox[4].getSelectedItem().equals("Solo"))
			     isSolo = true;
           }
  	       else if ((m==5) && (ckBoxStates[5] == SELECTED)){
  		      airCraft = new B52();
  		      if(optComoBox[5].getSelectedItem().equals("Solo"))
		      isSolo = true;
           }
           else if ((m==6) && (ckBoxStates[6] == SELECTED)) {
		      airCraft = new C130E();
			  if(optComoBox[6].getSelectedItem().equals("Solo"))
			     isSolo = true;
		   }
  	       else if ((m==7) && (ckBoxStates[7] == SELECTED)) {
  		      airCraft = new C130J();
  		      if(optComoBox[7].getSelectedItem().equals("Solo"))
			     isSolo = true;
  	       }
  	       else if ((m==8) && (ckBoxStates[8] == SELECTED)) {
  	   	      airCraft = new CV22();
  	   	      if(optComoBox[8].getSelectedItem().equals("Solo"))
			     isSolo = true;
  	       }
  	       else if ((m==9) && (ckBoxStates[9] == SELECTED)) {
			  airCraft = new E9A();
			  if(optComoBox[9].getSelectedItem().equals("Solo"))
			     isSolo = true;
		   }
		   else if ((m==10) && (ckBoxStates[10] == SELECTED)) {
			  airCraft = new EC130();
			  if(optComoBox[10].getSelectedItem().equals("Solo"))
			     isSolo = true;
		   }
		   //== for air units
           else if ((m==11) && (ckBoxStates[11] == SELECTED)){
  	   	      unit = new Squadron();
  	   	      airUnits.attach(unit);
  	   	      unitInfo = unit.getDescription();
		   }
  	       else if ((m==12) && (ckBoxStates[12] == SELECTED)){
			  unit = new Group();
			  airUnits.attach(unit);
			  unitInfo = unit.getDescription();
		   }
		   else if ((m==13) && (ckBoxStates[13] == SELECTED)){
			  unit = new Wing();
			  airUnits.attach(unit);
			  unitInfo = unit.getDescription();
		   }

           if( airCraft != null){
		      if(isSolo == false)
		         airGroup.attach(airCraft);
			  else{
			     String f = airCraft.fight();
			     txtAirMission.append("Solo Flight Mission: \n" + f + "\n");
			  }
			  airCraft = null;
			  isSolo = false;
           }
         }  //end for loop

         //Display Air Group Actions
         if(airGroup.getSize() > 0){
			 String str = airGroup.fight();
			 txtAirMission.append("Mission with newly-formed unit: \n" + str + "\n");
	     }
	     if(airUnits.getSize() > 0){
			 String str = airUnits.fight();
			 txtAirMission.append("Mission with fixed unit: \n" + unitInfo + " \n");
			 txtAirMission.append("Aircrafts in this mission: \n" + str + "\n");
	     }
	  }
      else if (e.getActionCommand().equals("Exit")) {
  		        System.exit(1);
  	  }
    }

  public static void main(String args[]){
    try {
		 JFrame.setDefaultLookAndFeelDecorated(true);
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }
    catch (Exception evt) {}

    AirforceGUI frame = new AirforceGUI();
    frame.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });
    frame.setSize(500, 600);
    frame.setVisible(true);
  }
}

