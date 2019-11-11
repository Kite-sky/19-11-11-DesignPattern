
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.Iterator;


public class AirlineGUI extends JFrame {
  private JSplitPane  bigSplitPane;
  private JScrollPane showInfoPane;
  private JPanel btnPanel;
  private JEditorPane editorPane;
  private JComboBox nationality;
  private JLabel lblName, lblID, nation;
  private JTextField nameText, iDText;
  private String cusName;
  private String cusID;
  private String cusNation;
  private JTextArea display;

  private Dimension size = new Dimension(600, 210);
  private static int divider = 370;
  public static final String AIR = "air";
  public static final String SUBMIT = "Submit";
  public static final String EXIT = "Exit";

  private BusinessMediator bMediator;
  private ArrayList<String> cusNames;
  private ArrayList<String> candidateCusNames;


  public AirlineGUI(BusinessMediator bMdtr) {
     super("Mediator Pattern- Airline ");
     bMediator = bMdtr;
     setUpChoicePanel();
     setUpScrollPanes();
     cusNames = new ArrayList<String>();
     candidateCusNames=new ArrayList<String>();
     bMediator.registerAirlineGUI(this);
  }

  private void setUpChoicePanel() {

      nameText = new JTextField(20);
      iDText = new JTextField(20);

      nationality = new JComboBox();
	  nationality.addItem("China");
	  nationality.addItem( "USA");
	  nationality.addItem("England");
	  nationality.addItem( "France");
	  nationality.addItem("Germany");
	  nationality.addItem( "Russia");
	  nationality.addItem("Japan");
	  nationality.addItem( "Korea");

	  lblName = new JLabel("Customer Name:");
	  lblID = new JLabel("Customer ID:");
	  nation = new JLabel("Nationality:");

	  //Create the open button
	  JButton submitBtn = new JButton(SUBMIT);
	  submitBtn.setMnemonic(KeyEvent.VK_S);
	  JButton exitButton = new JButton(EXIT);
	  exitButton.setMnemonic(KeyEvent.VK_X);

	  ButtonListener btnListener = new ButtonListener();

	  // add action Listener
	  submitBtn.addActionListener(btnListener);
	  exitButton.addActionListener(btnListener);

	  btnPanel = new JPanel();

	  //------------------------------------------------
	  GridBagLayout gridbag = new GridBagLayout();
	  btnPanel.setLayout(gridbag);
	  GridBagConstraints gbc = new GridBagConstraints();

	  btnPanel.add(lblName);
	  btnPanel.add(nameText);
	  btnPanel.add(lblID);
	  btnPanel.add(iDText);
      btnPanel.add(nation);
	  btnPanel.add(nationality);
	  btnPanel.add(submitBtn);
	  btnPanel.add(exitButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;

      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(lblName, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridbag.setConstraints(nameText, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      gridbag.setConstraints(lblID, gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gridbag.setConstraints(iDText, gbc);

      gbc.gridx = 0;
	  gbc.gridy = 2;
      gridbag.setConstraints(nation, gbc);
      gbc.gridx = 1;
	  gbc.gridy = 2;
      gridbag.setConstraints(nationality, gbc);

      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 15;
      gbc.gridx = 0;
      gbc.gridy = 5;
      gridbag.setConstraints(submitBtn, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 5;
      gridbag.setConstraints(exitButton, gbc);
      //-----------------------------------------------
   }

   private void setUpScrollPanes() {
   	  Border raisedbevel = BorderFactory.createRaisedBevelBorder();

  	  editorPane = new JEditorPane();

      display = new JTextArea(15, 15);
  	  showInfoPane = new JScrollPane(display);

  	  bigSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, btnPanel,showInfoPane);
  	  bigSplitPane.setDividerLocation(divider);

      getContentPane().add(bigSplitPane);
  	  setSize(size);
      setVisible(true);
   }

   public void setCusName(){
      cusName = nameText.getText();
   }
   public void setCusID(){
      cusID = iDText.getText();
   }
   public void setCusNation(){
      cusNation = (String)nationality.getSelectedItem();
   }

   public String getCusName(){
      return cusName;
   }
   public String getCusID(){
      return cusID;
   }
   public String getCusNation(){
      return cusNation;
   }
   public void addCustomer(String cus){
      cusNames.add(cus);
   }
   public void addCandidateCustomer(String cus){
      candidateCusNames.add(cus);
   }

   public void writeReservedCusToDB(){
      String s;
      Iterator e = cusNames.iterator();
      while (e.hasNext()){
          s = (String) e.next();
          //try to write data to DB
      }
   }
   public void writeCandidateCusToDB(){
      String s;
      Iterator e = cusNames.iterator();
      while (e.hasNext()){
         s = (String) e.next();
         //try to write data to DB
      }
   }


   class ButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent ae) {

		if (ae.getActionCommand().equals(EXIT)) {
		   System.exit(1);
		}
		if (ae.getActionCommand().equals(SUBMIT)) {
           setCusName();
           setCusID();
           setCusNation();

		   String nm = getCusName();
		   String id = getCusID();
		   String na = getCusNation();

		   displayInfoToScreen("\nAirline reserved:\n" + nm);
		   displayInfoToScreen("\n" + id );
		   displayInfoToScreen("\n" + na );

		   String hotelCus = "\n \nCustomer reserved air ticket: ";
		   String cusInfo = hotelCus+"\n Name: " + nm + ",\n ID: " + id + ",\n Nationality: " + na;

		   addCustomer(cusInfo);
		   bMediator.addAllCandidateCus(AIR,cusInfo);
           bMediator.updateALlGuis(AIR, cusInfo);
        }
      }
  }

  public void displayInfoToScreen(String txt) {
     display.append(txt);
  }
}



/* PRINT all the listed customers

   String s;
       Iterator e = nums.iterator();
       while (e.hasNext()) {
         s = (String) e.next();
         System.out.println(s);
       }
*/