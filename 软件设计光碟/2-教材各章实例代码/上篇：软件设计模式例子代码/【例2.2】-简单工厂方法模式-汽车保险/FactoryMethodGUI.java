
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class FactoryMethodGUI extends JFrame{
   private JSplitPane  bigSplitPane;
   private JScrollPane showInfoPane;
   private JPanel btnPanel;
   private JComboBox cmbInsuranceType, cmbHouseType;
   private JLabel lblInsureType;
   private Dimension   minimumSize;
   private JTextArea txtForInfo;

   public static final String SHOW = "Show Info";
   public static final String EXIT = "Exit";
   public static final String BODYINJURE = "Body Injur Liability";
   public static final String COLLISION = "Collision Coverage";
   public static final String PERSONINJURE = "Personal Injury Protection";

   public FactoryMethodGUI(){
      super("Factory Method Pattern- Auto Insurance. ");
      minimumSize = new Dimension(130, 100);
      setUpChoicePanel();
      setUpScrollPanes();
   }

   private void setUpChoicePanel(){
      cmbInsuranceType = new JComboBox();
	  cmbInsuranceType.addItem(BODYINJURE);
	  cmbInsuranceType.addItem(COLLISION);
	  cmbInsuranceType.addItem(PERSONINJURE);

	  lblInsureType = new JLabel("Insurance Types");

	  //Create the open button
	  JButton showInfoBtn = new JButton(SHOW);
	  showInfoBtn.setMnemonic(KeyEvent.VK_S);
	  JButton exitButton = new JButton(EXIT);
	  exitButton.setMnemonic(KeyEvent.VK_X);

	  ButtonListener btnListener = new ButtonListener();

	  // add action Listener
	  showInfoBtn.addActionListener(btnListener);
	  exitButton.addActionListener(btnListener);

	  btnPanel = new JPanel();

	  //------------------------------------------------
	  GridBagLayout gridbag = new GridBagLayout();
	  btnPanel.setLayout(gridbag);
	  GridBagConstraints gbc = new GridBagConstraints();

	  btnPanel.add(lblInsureType);
	  btnPanel.add(cmbInsuranceType);
	  btnPanel.add(showInfoBtn);
	  btnPanel.add(exitButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;

      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(lblInsureType, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridbag.setConstraints(cmbInsuranceType, gbc);

      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 15;
      gbc.gridx = 0;
      gbc.gridy = 5;
      gridbag.setConstraints(showInfoBtn, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 5;
      gridbag.setConstraints(exitButton, gbc);
      //-----------------------------------------------
   }

   private void setUpScrollPanes(){
   	  txtForInfo = new JTextArea("Auto insurance information will be shown here.", 20, 30);
   	  txtForInfo.setFont(new Font("Helvetica", Font.BOLD, 15));

  	  txtForInfo.setLineWrap(true);
  	  txtForInfo.setBackground(Color.pink);

  	  showInfoPane = new JScrollPane(txtForInfo);

  	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, showInfoPane, btnPanel);
  	  bigSplitPane.setDividerLocation(220);

      getContentPane().add(bigSplitPane);
  	  setSize(new Dimension(500, 300));
      setVisible(true);
   }

   class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent ae){

		if (ae.getActionCommand().equals(EXIT)){
		    System.exit(1);
		}
		if (ae.getActionCommand().equals(SHOW)){
		   String type = (String) cmbInsuranceType.getSelectedItem();
		   PolicyProducer pp=null;
		   String option="";

		   if (type.equals(BODYINJURE)){
		      option="bodyInjure";
		   }
		   else if (type.equals(COLLISION)){
		      option="collision";
		   }
		   else if (type.equals(PERSONINJURE)){
		      option="personInjure";
		   }

           AutoInsurance ai = PolicyProducer.getPolicyObj(option);
		   String desc = ai.getInsurInfo();
		   txtForInfo.setText(desc);
        }
      }
   }

   public static void main(String args[])
   {
      try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      }
      catch (Exception evt) {}

      FactoryMethodGUI frame = new FactoryMethodGUI();
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

