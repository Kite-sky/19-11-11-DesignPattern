import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class PFImgProcGUI extends JPanel{
   private JComboBox cmbImageList;
   private JCheckBox rgbAdjust, threshold, trans, gray;
   private JPanel btnPanel;
   private JTextArea filterInfoTxt;
   private ArrayList<String> ftrs;
   private JLabel[] imgLabel;

   static final String PROCESS = "Process";
   static final String RESET = "Reset";
   static final String EXIT = "Exit";
   static final String IMAGES = "Images/";
   static final Dimension minimumSize = new Dimension(230, 200);
   static final int SELECTED = ItemEvent.SELECTED;
   static final int DESELECTED = ItemEvent.DESELECTED;

   public PFImgProcGUI(){
      super(new GridLayout(1,0));
      ftrs = new ArrayList<String>();
	  filterInfoTxt=new JTextArea(6, 20);

	  setUpButtonPanel();
      buildUpScrollGUI();
   }

   private void buildUpScrollGUI(){
      imgLabel = new JLabel[4];
      JScrollPane[] imgPane = new JScrollPane[4];

	  for(int m=0;m<4; m++){
	     imgLabel[m] = new JLabel();
	     imgLabel[m].setMinimumSize(new Dimension(250, 300));
	     imgPane[m] = new JScrollPane(imgLabel[m]);
	  }

	  JScrollPane btnPane = new JScrollPane(btnPanel);
	  btnPane.setMinimumSize(minimumSize);
	  JScrollPane filterInfoPane = new JScrollPane(filterInfoTxt);

	  JSplitPane upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  upSplitPane.setDividerLocation(400);
	  upSplitPane.setPreferredSize(new Dimension(800, 350));
	  upSplitPane.setLeftComponent(btnPane);
	  upSplitPane.setRightComponent(filterInfoPane);

	  JPanel downPanel = new JPanel();
	  downPanel.setLayout(new GridLayout(1,0));
	  downPanel.add(imgPane[0]);
	  downPanel.add(imgPane[1]);
	  downPanel.add(imgPane[2]);
	  downPanel.add(imgPane[3]);

	  JSplitPane bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, downPanel);
	  bigSplitPane.setDividerLocation(190);

	  add(bigSplitPane);
	  setSize(new Dimension(800, 500));
      setVisible(true);
  }

  private void setUpButtonPanel(){

	 cmbImageList = new JComboBox();
	 String[] cl = extractImageList();
     setupImageList(cmbImageList,cl);

     JLabel imlbl = new JLabel("Images:");
     JLabel filterlbl = new JLabel("Choose 3 Filters:");

     rgbAdjust = new JCheckBox("RGBFilter");
     threshold = new JCheckBox("ThresholdFilter");
     trans = new JCheckBox("TransFilter");
     gray = new JCheckBox("GrayOutFilter");

     CheckboxListener listener = new CheckboxListener();

     rgbAdjust.addItemListener(listener);
     threshold.addItemListener(listener);
     trans.addItemListener(listener);
     gray.addItemListener(listener);

     //Create buttons
     JButton srchButton = new JButton(PROCESS);
     srchButton.setMnemonic(KeyEvent.VK_S);

     JButton resetButton = new JButton(RESET);
     resetButton.setMnemonic(KeyEvent.VK_S);

     JButton exitButton = new JButton(EXIT);
     exitButton.setMnemonic(KeyEvent.VK_X);

     ButnListener objButtonHandler = new ButnListener();

     // add action Listener
     srchButton.addActionListener(objButtonHandler);
     resetButton.addActionListener(objButtonHandler);
     exitButton.addActionListener(objButtonHandler);

     btnPanel = new JPanel();

     GridBagLayout gridbag = new GridBagLayout();
     btnPanel.setLayout(gridbag);
     GridBagConstraints gbc = new GridBagConstraints();

     btnPanel.add(imlbl);
     btnPanel.add(cmbImageList);
     btnPanel.add(filterlbl);

     btnPanel.add(rgbAdjust);
     btnPanel.add(threshold);
     btnPanel.add(trans);
     btnPanel.add(gray);

     btnPanel.add(srchButton);
     btnPanel.add(resetButton);
     btnPanel.add(exitButton);

     gbc.insets.top = 5;
	 gbc.insets.bottom = 5;
	 gbc.insets.left = 5;
     gbc.insets.right = 5;

     gbc.anchor = GridBagConstraints.EAST;

     gbc.gridx = 0;
     gbc.gridy = 0;
     gridbag.setConstraints(imlbl, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
     gbc.gridy = 0;
     gridbag.setConstraints(cmbImageList, gbc);
     gbc.anchor = GridBagConstraints.EAST;
     gbc.gridx = 0;
	 gbc.gridy = 1;
	 gridbag.setConstraints(filterlbl, gbc);
	 gbc.anchor = GridBagConstraints.WEST;
	 gbc.gridx = 1;
	 gbc.gridy = 1;
	 gridbag.setConstraints(rgbAdjust, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
	 gbc.gridy = 2;
	 gridbag.setConstraints(threshold, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
	 gbc.gridy = 3;
	 gridbag.setConstraints(trans, gbc);
	 gbc.anchor = GridBagConstraints.WEST;
	 gbc.gridx = 1;
	 gbc.gridy = 4;
	 gridbag.setConstraints(gray, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 0;
     gbc.gridy = 1;
     gbc.insets.left = 2;
     gbc.insets.right = 2;
     gbc.insets.top = 25;
     gbc.anchor = GridBagConstraints.EAST;
     gbc.gridx = 0;
     gbc.gridy = 9;
     gridbag.setConstraints(srchButton, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
	 gbc.gridy = 9;
	 gridbag.setConstraints(resetButton, gbc);
	 gbc.anchor = GridBagConstraints.WEST;
	 gbc.gridx = 2;
	 gbc.gridy = 9;
     gridbag.setConstraints(exitButton, gbc);
  }

  /*==================================================*/
  /* Extract image file names from a diectory on your */
  /* computer                                         */
  /*==================================================*/
  private String[] extractImageList(){
     File f = new File(IMAGES);
     String [] fileNames = f.list();
     return fileNames;
  }

  /*==========================================*/
  /* Setup image list to combox cmbImageList. */
  /*==========================================*/
  private void setupImageList(JComboBox cmbImageList,String[] imList){
     for(int k=0; k<imList.length; k++){
        cmbImageList.addItem(imList[k]);
     }
  }

  /*===========================================*/
  /* Get a selected image name from user input */
  /*===========================================*/
  private String getSelectedImage() {
     return (String) cmbImageList.getSelectedItem();
  }

  class CheckboxListener implements ItemListener {

     public void itemStateChanged(ItemEvent e)  {
        Object source = e.getItemSelectable();
  	    int state = e.getStateChange();
  	    System.out.println("state" + " = "+state);

 	    if (source == rgbAdjust) {
		   if(state==SELECTED)
		      ftrs.add("RGBFilter");
		   else if(state==DESELECTED)
		      ftrs.remove("RGBFilter");
		}
		else if (source == threshold) {
		   if(state==SELECTED)
		      ftrs.add("ThresholdFilter");
		   else if(state==DESELECTED)
		      ftrs.remove("ThresholdFilter");
		}
		else if (source == trans) {
		   if(state==SELECTED)
		      ftrs.add("TransFilter");
		   else if(state==DESELECTED)
			  ftrs.remove("TransFilter");
		}
		else if (source == gray) {
		   if(state==SELECTED)
		      ftrs.add("GrayOutFilter");
		   else if(state==DESELECTED)
		      ftrs.remove("GrayOutFilter");
		}
	 }
  }

  class ButnListener implements ActionListener{
      public void actionPerformed(ActionEvent e){

        if (e.getActionCommand().equals(EXIT)){
           System.exit(1);
        }
        if (e.getActionCommand().equals(RESET)){
		   clearLabels();
        }
        if (e.getActionCommand().equals(PROCESS)){
           clearLabels();
           String selectedImg = getSelectedImage();

           try{
                 PipeLineBuilder apline
	                         = new PipeLineBuilder(ftrs, imgLabel,filterInfoTxt );

		         apline.buildAndRunPipeFilters(selectedImg);
		   }
		   catch (IOException ex){
		         ex.printStackTrace();
		         System.err.println("IO Error: failed building pipelines.");
                 System.exit(1);
		   }
           filterInfoTxt.append("\n\n");
        }
     }
  } // End of class ButnListener

  private static void createAndShowGUI(){
     JFrame.setDefaultLookAndFeelDecorated(true);
     JFrame frame = new JFrame("Pipes and Filters Software Architecture-Image Processing");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     PFImgProcGUI newContentPane = new PFImgProcGUI();
     newContentPane.setOpaque(true);
     frame.setContentPane(newContentPane);

     frame.pack();
     frame.setVisible(true);
  }

  private void clearLabels(){
       for(int i = 0; i< imgLabel.length; i++){
  	    imgLabel[i].setIcon(null);
  	 }
  }

  static public void main(String argv[]) {
	 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		   createAndShowGUI();
		}
        });
  }
}