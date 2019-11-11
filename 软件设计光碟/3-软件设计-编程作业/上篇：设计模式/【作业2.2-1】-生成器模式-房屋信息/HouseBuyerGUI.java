
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class HouseBuyerGUI extends JPanel{
   private JScrollPane btnPane;
   private JScrollPane houseInfoPane;
   private JTextArea txtHouseInfo;
   private JSplitPane bigSplitPane;
   private JSplitPane upSplitPane;
   private JPanel downPanel;
   private JComboBox cmbHouseType;
   private JPanel buttonPanel;
   private JPanel houseOptPanel;
   private ButtonHandler bh;

   static final Dimension minimumSize = new Dimension(230, 200);
   public static final String SUBMIT= "Submit";
   public static final String EXIT = "Exit";
   //public static final String ECONOMY_HOUSE = "Economy House";
   public static final String NORMAL_HOUSE = "Normal House";
   public static final String LUXURY_HOUSE = "Luxury House";
   public static final String BLANK = "Choose House Type";

   public HouseBuyerGUI(){
      super(new GridLayout(1,0));
	  txtHouseInfo=new JTextArea(6, 20);
	  txtHouseInfo.setFont(new Font("Arial", Font.BOLD, 14));
	  txtHouseInfo.setLineWrap(true);
      txtHouseInfo.setBackground(Color.pink);
      txtHouseInfo.setText("House Information");

      bh = new ButtonHandler();

      setupLowerPanel();
	  setupUpperLeftPanel();
      buildUpScrollGUI();
   }

   private void setupLowerPanel(){
      downPanel = new JPanel();
      downPanel.setBackground(Color.gray);
	  JButton btnSubmit = new JButton(HouseBuyerGUI.SUBMIT);
	  btnSubmit.setMnemonic(KeyEvent.VK_G);
	  JButton btnExit = new JButton(HouseBuyerGUI.EXIT);
	  btnExit.setMnemonic(KeyEvent.VK_X);
	  btnSubmit.addActionListener(bh);
	  btnExit.addActionListener(bh);

      downPanel.add(btnSubmit);
      downPanel.add(btnExit);
   }
   private void setupUpperLeftPanel(){
      cmbHouseType = new JComboBox();
      cmbHouseType.addItem(BLANK);

      cmbHouseType.addItem(NORMAL_HOUSE);
      cmbHouseType.addItem(LUXURY_HOUSE);

      JLabel lblHouseType = new JLabel("House Type:");
      JLabel lblHouseOptions = new JLabel("Options:");
      cmbHouseType.addActionListener(bh);

      //For layout purposes, put the buttons in a separate panel
      buttonPanel = new JPanel();
      // houseOptPanel is an empty panel for holding a HouseGUI dynamically
      // houseOptPanel will be put on buttonPanel
      houseOptPanel = new JPanel();
      houseOptPanel.setPreferredSize(new Dimension(360, 180));

      //****************************************************
      GridBagLayout gridbag = new GridBagLayout();

      buttonPanel.setLayout(gridbag);
      GridBagConstraints gbc = new GridBagConstraints();

      buttonPanel.add(cmbHouseType);
      buttonPanel.add(houseOptPanel);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;

      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(cmbHouseType, gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gridbag.setConstraints(houseOptPanel, gbc);
   }

   public void showHouseInfo(String str){
      txtHouseInfo.setText(str);
   }
   public String getHouseType(){
      return (String) cmbHouseType.getSelectedItem();
   }
   public JComboBox getHouseTypeCombox(){
      return cmbHouseType;
   }
   public void displayNewGUI(JPanel panel){
      houseOptPanel.removeAll();
      houseOptPanel.add(panel);
      houseOptPanel.validate();
      validate();
   }
   private void buildUpScrollGUI(){
      btnPane = new JScrollPane(buttonPanel);
	  btnPane.setMinimumSize(minimumSize);
	  houseInfoPane = new JScrollPane(txtHouseInfo);

	  upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  upSplitPane.setDividerLocation(390);
	  upSplitPane.setPreferredSize(new Dimension(600, 280));

	  upSplitPane.setLeftComponent(btnPane);
	  upSplitPane.setRightComponent(houseInfoPane);
	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, downPanel);
	  bigSplitPane.setDividerLocation(280);

	  add(bigSplitPane);
	  setSize(new Dimension(600, 300));
      setVisible(true);
  }

  private static void createAndShowGUI(){
     JFrame.setDefaultLookAndFeelDecorated(true);
     JFrame frame = new JFrame("Builder Pattern-House Sale Software");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     HouseBuyerGUI newContentPane = new HouseBuyerGUI();
     newContentPane.setOpaque(true);
     frame.setContentPane(newContentPane);

     frame.pack();
     frame.setVisible(true);
  }

  static public void main(String argv[]){
	 javax.swing.SwingUtilities.invokeLater(new Runnable(){
	    public void run() {
		   createAndShowGUI();
		}
        });
  }
  class ButtonHandler implements ActionListener{
     HouseBuilder builder;

     public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(EXIT)) {
           System.exit(1);
        }
        if (e.getActionCommand().equals(SUBMIT)) {
		   if(builder != null){
              //For displaying user's request
              String usrRequest = builder.getUserRequest();
              showHouseInfo(usrRequest);


		      Director director = new Director();

		      //decide which builder to use
		      director.setHouseBuilder(builder);

		      //For constructing the whole House object
		      director.constructWholeHouseObj();

		      //get a House object
		      House hsObj = director.getHouse();

		      //Show house object
		      int housePrice = hsObj.getHousePrice();
		      txtHouseInfo.append("\n House Price: "+housePrice);
	       }
        }
	    if (e.getSource() == getHouseTypeCombox()) {
           String selection = getHouseType();
           if ( (selection.equals("") == false) && (selection.equals(BLANK) == false)) {
              BuilderFactory factory = new BuilderFactory();

              //Get a concrete builder,eg., Object NormHouseBuilder
              //and add this component to the GUI
              builder = factory.getUIBuilder(selection);
              builder.addUIComponents();

              //Get and display the currently chosen Gui component
              JPanel UIObj = builder.getSearchUI();
              displayNewGUI(UIObj);
              buttonPanel.repaint();
           }
        }
     }
  }
}

class BuilderFactory{
   public HouseBuilder getUIBuilder(String str){
      HouseBuilder builder = null;

      if (str.equals(HouseBuyerGUI.NORMAL_HOUSE)){
         builder = new NormHouseBuilder();
      }
      else if (str.equals(HouseBuyerGUI.LUXURY_HOUSE)){
	     builder = new LuxHouseBuilder();
      }
      return builder;
   }
}