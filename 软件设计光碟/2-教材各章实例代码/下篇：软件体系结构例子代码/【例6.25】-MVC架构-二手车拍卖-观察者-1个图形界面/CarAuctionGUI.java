import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
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

   private JLabel carlbl;
   private JLabel imgLabel;
   private JSplitPane bigSplitPane;
   private JPanel buttonPanel;

   private JComboBox cmbCarList;

   private static CarModel carModel;
   private static CarPictureInfoView civ;
   private static CarBitInfoView cb;
   private static CarFileInfoView cf;

   static final String SEARCH = "Search";
   static final String BIT = "Bit";
   static final String EXIT = "Exit";
   static final String CARFILES = "CarFiles";

   public CarAuctionGUI(){
      super(new GridLayout(1,0));
	  bitShownText=new JTextArea("Bit price for each car will be shown here", 6, 20);

      carModel = new CarModel();
	  civ= new CarPictureInfoView(carModel,this);
	  cb = new CarBitInfoView(carModel, this);
	  cf = new CarFileInfoView(carModel, this);
      carModel.register(civ);
      carModel.register(cb);
      carModel.register(cf);

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
	 String[] cl = getCarList();
     setUpCarList(cl);

     carlbl = new JLabel("Cars:");

     //Create the open button
     JButton srchButton = new JButton(SEARCH);
     srchButton.setMnemonic(KeyEvent.VK_S);
     JButton exitButton = new JButton(EXIT);
     exitButton.setMnemonic(KeyEvent.VK_X);

     Controller objButtonHandler = new Controller(this,carModel);

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

  public void setImageInfo(ImageIcon imIcon){
     imgLabel.setIcon(imIcon);
     imgLabel.validate();
  }
  public void setCarFileToEditorPane(URL url){
     try{
        editorPane.setPage(url);
        validate();
     }
     catch (IOException e) {
	    e.printStackTrace();
     }
  }
  public String getBitPrice(){
     return	bitInputText.getText();
  }
  public void showBitPrice(String price ){
     bitShownText.append(price);
  }

  public String getSelectedCar() {
  	    return (String) cmbCarList.getSelectedItem();
  }
  public String[] getCarList(){

     File f = new File(CARFILES);
  	 String [] fileNames = f.list();

  	 for(int i=0; i<fileNames.length; i++ ){
  	    int len = fileNames[i].length();
  		fileNames[i]=fileNames[i].substring(0,len-5);
  	 }
  	 return fileNames;
  }
  public void setUpCarList(String[] carList){
     for(int k=0; k<carList.length; k++) {
  	    cmbCarList.addItem(carList[k]);
  	 }
  }

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

