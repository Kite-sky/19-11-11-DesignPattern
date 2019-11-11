import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.awt.event.*;
import com.sun.java.swing.plaf.windows.*;

public class CarAuctionGUI extends JPanel {
   private JTextField bitInputText;
   private JLabel lblCarModel;
   private JPanel buttonPanel;
   private String[] carList;
   private JComboBox cmbCarList;
   private static CarModel cm;
   private static CarGUIView civ;
   private static CarBitView cb;
   public static final String SEARCH = "Search";
   public static final String BIT = "Bit";
   public static final String EXIT = "Exit";

   public CarAuctionGUI(){
   	   super(new GridLayout(1,0));
	   setUpGUI();
   }
   private void setUpGUI(){
      cmbCarList = new JComboBox();
      String[] cl = getCarList();
      setUpCarList(cl);
      lblCarModel = new JLabel("Cars on auction:");

      //Create the open button
      JButton srchButton = new JButton(SEARCH);
      srchButton.setMnemonic(KeyEvent.VK_S);
      JButton exitButton = new JButton(EXIT);
      exitButton.setMnemonic(KeyEvent.VK_X);
      JButton bitButton = new JButton(BIT);
      bitButton.setMnemonic(KeyEvent.VK_X);
      bitInputText = new JTextField("Offer your bit price",12);
      buttonPanel = new JPanel();

      //****************************************************
      GridBagLayout gridbag = new GridBagLayout();
      buttonPanel.setLayout(gridbag);
      GridBagConstraints gbc = new GridBagConstraints();

      buttonPanel.add(lblCarModel);
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
      gridbag.setConstraints(lblCarModel, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridbag.setConstraints(cmbCarList, gbc);
      gbc.anchor = GridBagConstraints.EAST;
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
      Controller objButtonHandler = new Controller(this,cm,civ,cb);
      srchButton.addActionListener(objButtonHandler);
      exitButton.addActionListener(objButtonHandler);
      bitButton.addActionListener(objButtonHandler);

      add(buttonPanel);
	  setSize(new Dimension(800, 450));
      setVisible(true);
    }

    public String getSelectedCar() {
	   return (String) cmbCarList.getSelectedItem();
	}

	public String getBitPrice(){
	   return	bitInputText.getText();
	}

	// get the names of all the .html files in a directory
	public String[] getCarList(){
	   File f = new File("CarFiles");
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

  private static void createAndShowGUI() {
     JFrame.setDefaultLookAndFeelDecorated(true);
     JFrame frame = new JFrame("MVC pattern demo");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     CarAuctionGUI newContentPane = new CarAuctionGUI();
     newContentPane.setOpaque(true);
     frame.setContentPane(newContentPane);

     //Display the window.
     frame.pack();
     frame.setVisible(true);
  }

  static public void main(String argv[]) {
	 javax.swing.SwingUtilities.invokeLater(new Runnable() {
     public void run() {
	    cm = new CarModel();
	    civ= new CarGUIView(cm);
	    cb = new CarBitView(cm);
        createAndShowGUI();
	 }
        });
  }
}

