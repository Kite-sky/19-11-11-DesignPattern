import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.net.URI;
import java.awt.event.*;
import com.sun.java.swing.plaf.windows.*;

public class CarAuctionGUI extends JPanel{
   private JEditorPane editorPane;
   private JScrollPane btnPane;
   private JScrollPane imagePane;
   private JScrollPane textPane;
   private JSplitPane upSplitPane;
   private JSplitPane downSplitPane;

   private JTextField bitInputText;
   private JTextArea bitShownText;
   private JScrollPane bitInfo;
   private String fileName;

   private JLabel carlbl;
   private JLabel imgLabel;
   private JSplitPane bigSplitPane;
   private JPanel buttonPanel;
   private JComboBox cmbCarList;

   static final String SEARCH = "Search";
   static final String BIT = "Bit";
   static final String EXIT = "Exit";
   static final String CARFILES = "CarFiles/";
   static final String CARIMAGES = "CarImages/";


   public CarAuctionGUI(){
      super(new GridLayout(1,0));
	  bitShownText=new JTextArea("Bit price for each car will be shown here", 6, 20);
      buildUpScrollGUI();
   }

   private void buildUpScrollGUI(){
      setUpButtonPanel();

	  imgLabel = new JLabel();
      imgLabel.setBackground(Color.green);
	  imgLabel.setMinimumSize(new Dimension(250, 200));

      editorPane = new JEditorPane();
	  editorPane.setEditable(false);

      imagePane = new JScrollPane(imgLabel);

	  btnPane = new JScrollPane(buttonPanel);
	  textPane = new JScrollPane(editorPane);
	  textPane.setMinimumSize(new Dimension(250, 200));

	  bitInfo = new JScrollPane(bitShownText);

	  upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  upSplitPane.setLeftComponent(btnPane);
	  upSplitPane.setRightComponent(bitInfo);

	  downSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  downSplitPane.setLeftComponent(imagePane);
	  downSplitPane.setRightComponent(textPane);
	  downSplitPane.setDividerLocation(150);

	  Dimension minimumSize = new Dimension(130, 100);
	  imagePane.setMinimumSize(minimumSize);
	  btnPane.setMinimumSize(minimumSize);
	  textPane.setMinimumSize(new Dimension(100, 100));
	  upSplitPane.setDividerLocation(270);
	  upSplitPane.setPreferredSize(new Dimension(500, 300));

	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, downSplitPane);
	  bigSplitPane.setDividerLocation(190);

	  add(bigSplitPane);
	  setSize(new Dimension(500, 400));
      setVisible(true);
  }

  private void setUpButtonPanel(){

	 cmbCarList = new JComboBox();
	 String[] cl = extractCarList();
     setUpCarList(cmbCarList,cl);

     carlbl = new JLabel("Cars:");

     //Create buttons
     JButton srchButton = new JButton(SEARCH);
     srchButton.setMnemonic(KeyEvent.VK_S);
     JButton exitButton = new JButton(EXIT);
     exitButton.setMnemonic(KeyEvent.VK_X);

     Controller objButtonHandler = new Controller();

     JButton bitButton = new JButton(BIT);
     bitButton.setMnemonic(KeyEvent.VK_X);

     // add action Listener
     srchButton.addActionListener(objButtonHandler);
     exitButton.addActionListener(objButtonHandler);
     bitButton.addActionListener(objButtonHandler);

     bitInputText = new JTextField("Offer your bit price",12);
     bitInputText.setBackground(Color.green);
     buttonPanel = new JPanel();

     GridBagLayout gridbag = new GridBagLayout();
     buttonPanel.setLayout(gridbag);
     GridBagConstraints gbc = new GridBagConstraints();

     buttonPanel.add(carlbl);
     buttonPanel.add(cmbCarList);
     buttonPanel.add(srchButton);
     buttonPanel.add(bitButton);
     buttonPanel.add(exitButton);
     buttonPanel.add(bitInputText);

     gbc.insets.top = 5;
     gbc.insets.bottom = 5;
     gbc.insets.left = 5;
     gbc.insets.right = 5;

     gbc.anchor = GridBagConstraints.EAST;
     gbc.gridx = 0;
     gbc.gridy = 0;
     gridbag.setConstraints(carlbl, gbc);
     gbc.anchor = GridBagConstraints.WEST;

     gbc.gridx = 1;
     gbc.gridy = 0;
     gridbag.setConstraints(cmbCarList, gbc);
     gbc.anchor = GridBagConstraints.EAST;

     gbc.gridx = 0;
     gbc.gridy = 1;

     gbc.insets.left = 2;
     gbc.insets.right = 2;
     gbc.insets.top = 25;
     gbc.anchor = GridBagConstraints.EAST;

     gbc.gridx = 0;
     gbc.gridy = 3;
     gridbag.setConstraints(srchButton, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
     gbc.gridy = 3;
     gridbag.setConstraints(exitButton, gbc);

     gbc.gridx = 0;
	 gbc.gridy = 4;
     gridbag.setConstraints(bitButton, gbc);

     gbc.gridx = 1;
	 gbc.gridy = 4;
     gridbag.setConstraints(bitInputText, gbc);
  }

  /*===========================================*/
  /* Get a selected car name from user input   */
  /*===========================================*/
  public String getSelectedCar() {
     return (String) cmbCarList.getSelectedItem();
  }

  /*=================================*/
  /* Get bit price from user input   */
  /*=================================*/
  public String getBitPrice(){
     return	bitInputText.getText();
  }


  /*================================================*/
  /* Extract car file names from a diectory on your */
  /* computer                                       */
  /*================================================*/
  public String[] extractCarList(){
     File f = new File(CARFILES);
     String [] fileNames = f.list();

     for(int i=0; i<fileNames.length; i++ ){
        int len = fileNames[i].length();
        fileNames[i]=fileNames[i].substring(0,len-5);
     }
     return fileNames;
  }

  /*==============================================*/
  /* Add car list to combox cmbCarList. Both      */
  /* objects carList and cmbCarList are passed    */
  /* in from parameters.                          */
  /*==============================================*/
  public void setUpCarList(JComboBox cmbCarList,String[] carList){
     for(int k=0; k<carList.length; k++){
        cmbCarList.addItem(carList[k]);
     }
  }

  /*===========================================*/
  /* Setup a path string and convert it to url */
  /*===========================================*/
  public URL constructCarFileUrl(String carChosen){
     URL url = null;
     try{
        String fileURLStr = CARFILES + carChosen + ".html";
        URI uri = (new File(fileURLStr)).toURI();
		url = uri.toURL();
     }
     catch (IOException e){
        e.printStackTrace();
     }
     return url;
  }

  /*=========================================*/
  /* Add car-descriptions page to editorPane */
  /*=========================================*/
  public void updateCarDescription(JEditorPane editorPane, URL url){
     try{
  	    editorPane.setPage(url);
  	           //validate();
  	 }
  	 catch (IOException e) {
  	    e.printStackTrace();
     }
  }

  /*=============================================*/
  /* Display car bit prices offered by users     */
  /* to text area                                */
  /*=============================================*/
  public void showBitPrice(JTextArea bitShownText, String price ){
     bitShownText.append(price);
  }

  /*=======================================*/
  /* Create an image icon from a dir used  */
  /* to show an image of the chosen car.   */
  /* The image is in the dir CARIMAGES     */
  /*=======================================*/
  public ImageIcon produceCarImaIcon(String carChosen){
     String iconStr = CARIMAGES + carChosen +".jpg";
     ImageIcon imgIcon = createImageIcon(iconStr);
     return imgIcon;
  }

  /*============================================*/
  /* put a user selected picture onto the GUI   */
  /*============================================*/
  public void updateCarPicture(JLabel imgLabel,ImageIcon imgIcon){
     imgLabel.setIcon(imgIcon);
     imgLabel.validate();
  }

  /*================================================*/
  /* For a given path, actually create and return   */
  /* an ImageIcon, or null if the path was invalid. */
  /*================================================*/
  protected ImageIcon createImageIcon(String path){
     URL imgURL = getClass().getResource(path);
     if (imgURL != null) {
        return new ImageIcon(imgURL);
     }
     else{
        System.err.println("Couldn't find file: " + path);
        return null;
     }
  }

  class Controller implements ActionListener{
     String carPrice;

     public void actionPerformed(ActionEvent e){
        String searchResult = null;

        if (e.getActionCommand().equals(CarAuctionGUI.EXIT)){
           System.exit(1);
        }
        if (e.getActionCommand().equals(CarAuctionGUI.SEARCH)){
           String selectedCar = getSelectedCar();

  		   ImageIcon imgIcon = produceCarImaIcon(selectedCar);
  		   URL url = constructCarFileUrl(selectedCar);

           updateCarPicture(imgLabel,imgIcon);
           updateCarDescription(editorPane, url);
        }
        if (e.getActionCommand().equals(CarAuctionGUI.BIT)){
  		   String sCar = getSelectedCar();
		   String pr = getBitPrice();
           String prc ="\n Bit price for "+ sCar + " : "+ pr;

           showBitPrice(bitShownText, prc);
  	  }
     }
  } // End of class Controller

  private static void createAndShowGUI(){
     JFrame.setDefaultLookAndFeelDecorated(true);
     JFrame frame = new JFrame("MVC pattern demo-Car auction");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     CarAuctionGUI newContentPane = new CarAuctionGUI();
     newContentPane.setOpaque(true);
     frame.setContentPane(newContentPane);

     frame.pack();
     frame.setVisible(true);
  }

  static public void main(String argv[]) {
	 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		   createAndShowGUI();
		}
        });
  }
}

