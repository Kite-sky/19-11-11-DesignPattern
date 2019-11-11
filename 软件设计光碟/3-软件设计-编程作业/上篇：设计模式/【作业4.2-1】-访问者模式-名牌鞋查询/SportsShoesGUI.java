
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SportsShoesGUI extends JFrame implements ItemListener{
  private JScrollPane dataPane,textPane,checkBoxPane;
  private JSplitPane  bigSplitPane,upSplitPane;
  private JPanel      checkBoxPanel, btnPanel, choicePanel;
  private JButton     submitBtn, exitBtn;
  private JTextArea   txtAreaPrice, txtAreaData;
  private Dimension   minimumSize;
  private JCheckBox sport, walking, nike, mephisto, northFace,
                    running, adidas, ponyMexico, salomon,
                    skating,globeBlitz, globeAppleyard,dCShoesRover;

  public final int SELECTED = ItemEvent.SELECTED;
  public final int DESELECTED = ItemEvent.DESELECTED;
  private int[] states;
  private float total=0;


  public SportsShoesGUI(){
      super("Visitor Pattern Example with JCheckbox");
      minimumSize = new Dimension(130, 100);

      states = new int[20];
      setUpChoicePanel();
      setUpScrollPanes();
  }

  private void setUpChoicePanel(){
      submitBtn = new JButton("Submit");
      submitBtn.addActionListener( new ButtonActionListener());

      exitBtn = new JButton("Exit");
      exitBtn.addActionListener( new ButtonActionListener());

      JPanel btnPanel =new JPanel();
      btnPanel.add(submitBtn);
      btnPanel.add(exitBtn);

      //Create the check boxes.
      sport  = new JCheckBox("SportShoes");
      walking  = new JCheckBox("Walking");
      nike  = new JCheckBox("Nike");
	  mephisto  = new JCheckBox("Mephisto");
      northFace  = new JCheckBox("NorthFace");
      running   = new JCheckBox("Running");
      adidas  = new JCheckBox("Adidas");
	  ponyMexico  = new JCheckBox("PonyMexico");
      salomon  = new JCheckBox("Salomon");
      skating   = new JCheckBox("Skating");
      globeBlitz = new JCheckBox(" GlobeBlitz");
	  globeAppleyard  = new JCheckBox("GlobeAppleyard");
      dCShoesRover  = new JCheckBox("DCShoesRover");

      sport.setMnemonic(KeyEvent.VK_C);
      walking.setMnemonic(KeyEvent.VK_C);
      nike.setMnemonic(KeyEvent.VK_C);
      mephisto.setMnemonic(KeyEvent.VK_C);
      northFace.setMnemonic(KeyEvent.VK_C);
	  running.setMnemonic(KeyEvent.VK_C);
	  adidas.setMnemonic(KeyEvent.VK_C);
	  ponyMexico.setMnemonic(KeyEvent.VK_C);
	  salomon.setMnemonic(KeyEvent.VK_C);
      skating.setMnemonic(KeyEvent.VK_C);
      globeBlitz.setMnemonic(KeyEvent.VK_C);
      globeAppleyard.setMnemonic(KeyEvent.VK_C);
      dCShoesRover.setMnemonic(KeyEvent.VK_C);

      //Register a listener for the check boxes.
      sport.addItemListener(this);
      walking.addItemListener(this);
      nike.addItemListener(this);
      mephisto.addItemListener(this);
      northFace.addItemListener(this);
	  running.addItemListener(this);
	  adidas.addItemListener(this);
	  ponyMexico.addItemListener(this);
	  salomon.addItemListener(this);
      skating.addItemListener(this);
      globeBlitz.addItemListener(this);
      globeAppleyard.addItemListener(this);
      dCShoesRover.addItemListener(this);

      //Set up the picture label
      checkBoxPanel = new JPanel();

      // Use gridbag layout to place all buttons
      GridBagLayout gridbag = new GridBagLayout();
      checkBoxPanel.setLayout(gridbag);
      GridBagConstraints gbc = new GridBagConstraints();

      checkBoxPanel.add(sport);
      checkBoxPanel.add(walking);
      checkBoxPanel.add(nike);
      checkBoxPanel.add(mephisto);
      checkBoxPanel.add(northFace);
      checkBoxPanel.add(running);
      checkBoxPanel.add(adidas);
      checkBoxPanel.add(ponyMexico);
      checkBoxPanel.add(salomon);
	  checkBoxPanel.add(skating);
	  checkBoxPanel.add(globeBlitz);
	  checkBoxPanel.add(globeAppleyard);
      checkBoxPanel.add(dCShoesRover);

      gbc.insets.top = 0;
      gbc.insets.bottom = 0;
      gbc.insets.left = 0;
      gbc.insets.right = 0;

      gbc.anchor = GridBagConstraints.WEST;

      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(sport, gbc);

      gbc.gridx = 1;
      gbc.gridy = 1;
      gridbag.setConstraints(walking, gbc);
      gbc.gridx = 2;
	  gbc.gridy = 2;
      gridbag.setConstraints(nike, gbc);
      gbc.gridx = 2;
	  gbc.gridy = 3;
      gridbag.setConstraints(mephisto, gbc);
      gbc.gridx = 2;
	  gbc.gridy = 4;
      gridbag.setConstraints(northFace, gbc);
      gbc.gridx = 1;
      gbc.gridy = 5;
      gridbag.setConstraints(running, gbc);
      gbc.gridx = 2;
	  gbc.gridy = 6;
	  gridbag.setConstraints(adidas, gbc);
	  gbc.gridx = 2;
	  gbc.gridy = 7;
	  gridbag.setConstraints(ponyMexico, gbc);
	  gbc.gridx = 2;
	  gbc.gridy = 8;
      gridbag.setConstraints(salomon, gbc);
      gbc.gridx = 1;
	  gbc.gridy = 9;
	  gridbag.setConstraints(skating, gbc);
	  gbc.gridx = 2;
	  gbc.gridy = 10;
	  gridbag.setConstraints(globeBlitz, gbc);
	  gbc.gridx = 2;
	  gbc.gridy = 11;
	  gridbag.setConstraints(globeAppleyard, gbc);
	  gbc.gridx = 2;
	  gbc.gridy = 12;
      gridbag.setConstraints(dCShoesRover, gbc);

      choicePanel = new JPanel();
      choicePanel.setMinimumSize(new Dimension(500, 300));
      choicePanel.setLayout(new BorderLayout());

      choicePanel.add(checkBoxPanel, "Center");
      choicePanel.add(btnPanel, "South");
  }

   // All the scroll panes are set up
   private void setUpScrollPanes(){
	   txtAreaPrice = new JTextArea(3,10);
	   txtAreaData = new JTextArea(3,10);
       dataPane = new JScrollPane(txtAreaData);
       dataPane.setMinimumSize(minimumSize);
       checkBoxPane = new JScrollPane(choicePanel);
  	   checkBoxPane.getViewport().setBackground(Color.green);
  	   upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
  	   upSplitPane.setLeftComponent(checkBoxPane);
  	   upSplitPane.setRightComponent(dataPane);
  	   textPane = new JScrollPane(txtAreaPrice);
       textPane.setMinimumSize(new Dimension(100, 100));
  	   upSplitPane.setDividerLocation(300);
  	   upSplitPane.setPreferredSize(new Dimension(500, 200));
  	   bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, textPane);
  	   bigSplitPane.setDividerLocation(350);

       getContentPane().add(bigSplitPane);
  	   setSize(new Dimension(500, 300));
       setVisible(true);
    }

  //==========================================================
  // 同学们需要理解本监听器所涉及的createObjects(ActionEvent e)
  // 方法，并且只需要添加2行代码即可完成作业。
  //==========================================================
  class ButtonActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
		total=0;
		txtAreaPrice.append("\n============New Order ==============\n");
		createObjects(e);
    }
  }

   public void itemStateChanged(ItemEvent e){
        Object source = e.getItemSelectable();
	    int state = e.getStateChange();

	    if (source == sport) {
			if(state == SELECTED){
			   walking.setSelected(true);
			   running.setSelected(true);
			   skating.setSelected(true);
		    }
		    else if (state == DESELECTED){
			   walking.setSelected(false);
			   running.setSelected(false);
			   skating.setSelected(false);
		    }
			states[0]=state;
        }
        else if (source == walking) {
			if(state == SELECTED){
			   nike.setSelected(true);
			   mephisto.setSelected(true);
			   northFace.setSelected(true);
		    }
		    else if (state == DESELECTED){
			   nike.setSelected(false);
			   mephisto.setSelected(false);
			   northFace.setSelected(false);
		    }
            states[1]=state;
        }
        else if (source == nike)
		    states[2]=state;
        else if (source == mephisto)
			states[3]=state;
        else if (source == northFace)
			states[4] = state;
        else if (source == running) {
            if (state == SELECTED) {
			   adidas.setSelected(true);
			   ponyMexico.setSelected(true);
			   salomon.setSelected(true);
		    }
		    else if (state == DESELECTED){
			   adidas.setSelected(false);
			   ponyMexico.setSelected(false);
			   salomon.setSelected(false);
		    }
			states[5]=state;
		}
		else if (source == adidas)
			states[6]=state;
		else if (source == ponyMexico)
			states[7]=state;
        else if (source == salomon)
			states[8]=state;
        else if (source == skating) {
			if(state == SELECTED) {
			   globeBlitz.setSelected(true);
			   globeAppleyard.setSelected(true);
			   dCShoesRover.setSelected(true);
		    }
		    else if (state == DESELECTED){
			   globeBlitz.setSelected(false);
			   globeAppleyard.setSelected(false);
			   dCShoesRover.setSelected(false);
		    }
			states[9]=state;
        }
        else if (source == globeBlitz)
			states[10]=state;
        else if (source == globeAppleyard)
			states[11]=state;
        else if (source == dCShoesRover)
			states[12]=state;
  }

  private void createObjects(ActionEvent e){
	  PriceVisitor pv = new PriceVisitor();
	  ShoeInfoVisitor sv = new ShoeInfoVisitor();
	  SportShoes shoes = null;
	  int len = states.length;

      if (e.getActionCommand().equals("Submit")) {
		 for(int m = 0; m < len; m++ ){
            if ((m==0) && (states[0] == SELECTED)) {
  	           txtAreaPrice.append("/" + "Sport shoes; includes all type \n");
  	        }
  	        else if ((m==1) && (states[1] == SELECTED)) {
  		       txtAreaPrice.append("/" + "Walking Sheos \n");
  	        }
  	        else if ((m==2) && (states[2] == SELECTED)) {
  	   	       txtAreaPrice.append("/" + "Nike");
  	   	       shoes = new Nike();
  	        }
  	        else if  ((m==3) && (states[3] == SELECTED)) {
               txtAreaPrice.append("/" + "Mephisto");
  		       shoes = new Mephisto();
  	        }
  	        else if ((m==4) && (states[4] == SELECTED)) {
  		       txtAreaPrice.append("/" + "NorthFace");
  		       shoes = new NorthFace();
  	        }
  	        else if ((m==5) && (states[5] == SELECTED)) {
               txtAreaPrice.append("/" + "Running Shoes: \n");
  	        }
  	        else if ((m==6) && (states[6] == SELECTED)) {
  		       txtAreaPrice.append("/" + "Adidas");
  		       shoes = new Adidas();
  	        }
  	        else if ((m==7) && (states[7] == SELECTED)){
  	           txtAreaPrice.append("/" + "Pony Mexico");
  		       shoes = new PonyMexico();
            }
            else if ((m==8) && (states[8] == SELECTED)){
			   txtAreaPrice.append("/" + "Salomon");
			   shoes = new Salomon();
            }
            else if ((m==9) && (states[9] == SELECTED)) {
			    txtAreaPrice.append("/" + "Skating shoes include 3 items: \n");
			}
			else if ((m==10) && (states[10] == SELECTED)) {
			    txtAreaPrice.append("/" + "GlobeBlitz");
			    shoes = new GlobeBlitz();
			}
			else if ((m==11) && (states[11] == SELECTED)){
			  	txtAreaPrice.append("/" + "Globe Appleyard");
			    shoes = new GlobeAppleyard();
			}
			else if ((m==12) && (states[12] == SELECTED)){
				txtAreaPrice.append("/" + "DC Shoes Rover ");
				shoes = new DCShoesRover();
            }

            if(shoes != null){
			    shoes.accept(pv);
				shoes.accept(sv);
				txtAreaPrice.append(" Price: " + pv.getShoesPrice()+"\n");
				shoes = null;
			}
         }  //end for loop

          total = pv.getPriceTotal();
          txtAreaPrice.append("\n Total Price: " + total);

          //在这里添加两行代码，将所选定的鞋的信息显示到GUI的右上方的txtAreaData中
	  }
      else if (e.getActionCommand().equals("Exit")) {
  		        System.exit(1);
  	  }
    }

  //--------------------------------------------------------------
  public static void main(String args[]){
    try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }
    catch (Exception evt) {}

    SportsShoesGUI frame = new SportsShoesGUI();
    frame.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });
    frame.setSize(500, 600);
    frame.setVisible(true);
  }
}

