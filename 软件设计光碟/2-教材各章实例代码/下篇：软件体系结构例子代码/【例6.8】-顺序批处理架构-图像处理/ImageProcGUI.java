import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageProcGUI extends JPanel{

   private JComboBox cmbImageList;
   private JCheckBox blur, brighting,edge, sharp;

   private JButton srchButton, resetButton, exitButton;
   private JPanel buttonPanel;
   private JScrollPane btnPane;

   private JTextArea filterInfoTxt;
   private JScrollPane filterInfoPane;
   private JSplitPane upSplitPane;

   private JScrollPane[] imagePane;
   private JPanel downPanel;
   private JSplitPane bigSplitPane;

   private ArrayList<String> ftrs;
   private JLabel imlbl, filterlbl;
   private JLabel[] imgLabel;

   static final String PROCESS = "Process";
   static final String RESET = "Reset";
   static final String EXIT = "Exit";
   static final String IMAGES = "Images/";
   static final Dimension minimumSize = new Dimension(230, 200);
   static final int SELECTED = ItemEvent.SELECTED;
   static final int DESELECTED = ItemEvent.DESELECTED;

   public ImageProcGUI(){
      super(new GridLayout(1,0));
      ftrs = new ArrayList<String>();
	  filterInfoTxt=new JTextArea(6, 20);

	  setUpButtonPanel();
      buildUpScrollGUI();
   }

   private void buildUpScrollGUI(){
      imgLabel = new JLabel[4];
      imagePane = new JScrollPane[4];

	  for(int m=0;m<4; m++){
	     imgLabel[m] = new JLabel();
	     imgLabel[m].setMinimumSize(new Dimension(250, 300));
	     imagePane[m] = new JScrollPane(imgLabel[m]);
	  }

	  btnPane = new JScrollPane(buttonPanel);
	  btnPane.setMinimumSize(minimumSize);
	  filterInfoPane = new JScrollPane(filterInfoTxt);

	  upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  upSplitPane.setDividerLocation(400);
	  upSplitPane.setPreferredSize(new Dimension(800, 350));
	  upSplitPane.setLeftComponent(btnPane);
	  upSplitPane.setRightComponent(filterInfoPane);

	  downPanel = new JPanel();
	  downPanel.setLayout(new GridLayout(1,0));
	  downPanel.add(imagePane[0]);
	  downPanel.add(imagePane[1]);
	  downPanel.add(imagePane[2]);
	  downPanel.add(imagePane[3]);

	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, downPanel);
	  bigSplitPane.setDividerLocation(190);

	  add(bigSplitPane);
	  setSize(new Dimension(800, 500));
      setVisible(true);
  }

  private void setUpButtonPanel(){

	 cmbImageList = new JComboBox();
	 String[] cl = extractImageList();
     setupImageList(cmbImageList,cl);

     imlbl = new JLabel("Images:");
     filterlbl = new JLabel("Choose 3 Filters:");

     blur  = new JCheckBox("BlurFilter");
     brighting  = new JCheckBox("BrighteningFilter");
     edge  = new JCheckBox("EdgeDetectionFilter");
     sharp  = new JCheckBox("SharpenFilter");

     CheckboxListener listener = new CheckboxListener();

     blur.addItemListener(listener);
     brighting.addItemListener(listener);
     edge.addItemListener(listener);
     sharp.addItemListener(listener);

     //Create buttons
     srchButton = new JButton(PROCESS);
     srchButton.setMnemonic(KeyEvent.VK_S);

     resetButton = new JButton(RESET);
     resetButton.setMnemonic(KeyEvent.VK_S);

     exitButton = new JButton(EXIT);
     exitButton.setMnemonic(KeyEvent.VK_X);

     ButnListener objButtonHandler = new ButnListener();

     // add action Listener
     srchButton.addActionListener(objButtonHandler);
     resetButton.addActionListener(objButtonHandler);
     exitButton.addActionListener(objButtonHandler);

     buttonPanel = new JPanel();

     GridBagLayout gridbag = new GridBagLayout();
     buttonPanel.setLayout(gridbag);
     GridBagConstraints gbc = new GridBagConstraints();

     buttonPanel.add(imlbl);
     buttonPanel.add(cmbImageList);
     buttonPanel.add(filterlbl);

     buttonPanel.add(blur);
     buttonPanel.add(brighting);
	 buttonPanel.add(edge);
     buttonPanel.add(sharp);

     buttonPanel.add(srchButton);
     buttonPanel.add(resetButton);
     buttonPanel.add(exitButton);

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
	 gridbag.setConstraints(blur, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
	 gbc.gridy = 2;
	 gridbag.setConstraints(brighting, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
	 gbc.gridy = 3;
	 gridbag.setConstraints(edge, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
	 gbc.gridy = 4;
	 gridbag.setConstraints(sharp, gbc);
     gbc.anchor = GridBagConstraints.WEST;

     gbc.gridx = 0;
     gbc.gridy = 1;
     gbc.insets.left = 2;
     gbc.insets.right = 2;
     gbc.insets.top = 25;
     gbc.anchor = GridBagConstraints.EAST;

     gbc.gridx = 0;
     gbc.gridy = 7;
     gridbag.setConstraints(srchButton, gbc);
     gbc.anchor = GridBagConstraints.WEST;

     gbc.gridx = 1;
	 gbc.gridy = 7;
	 gridbag.setConstraints(resetButton, gbc);
     gbc.anchor = GridBagConstraints.WEST;

     gbc.gridx = 2;
     gbc.gridy = 7;
     gridbag.setConstraints(exitButton, gbc);
  }

  /*===========================================*/
  /* Get a selected image name from user input   */
  /*===========================================*/
  public String getSelectedImage() {
     return (String) cmbImageList.getSelectedItem();
  }

  /*================================================*/
  /* Extract image names from a diectory on your    */
  /* computer                                       */
  /*================================================*/
  public String[] extractImageList(){
     File f = new File(IMAGES);
     String [] fileNames = f.list();
     return fileNames;
  }

  /*==============================================*/
  /* Add image list to combox cmbCarList. Both      */
  /* objects imgList and cmbImageList are passed    */
  /* in from parameters.                          */
  /*==============================================*/
  public void setupImageList(JComboBox cmbImageList,String[] imgList){
     for(int k=0; k<imgList.length; k++){
        cmbImageList.addItem(imgList[k]);
     }
  }

  /*------------------------------------------------------*/
  /* This listener is used for adding a filter name to or */
  /* deleting a filter name from a filter list, which is  */
  /* implemented as an ArrayList                          */
  /*------------------------------------------------------*/
  class CheckboxListener implements ItemListener {

     public void itemStateChanged(ItemEvent e){
        Object source = e.getItemSelectable();
  	    int state = e.getStateChange();
  	    System.out.println("state" + " = "+state);

 	    if (source == blur) {
		   if(state==SELECTED)
		      ftrs.add("BlurFilter");
		   else if(state==DESELECTED)
		      ftrs.remove("BlurFilter");
		}
		else if (source == brighting) {
		   if(state == SELECTED)
		      ftrs.add("BrighteningFilter");
		   else if(state == DESELECTED)
		      ftrs.remove("BrighteningFilter");
		}
		else if (source == edge) {
	       if(state == SELECTED)
		      ftrs.add("EdgeDetectionFilter");
		   else if(state == DESELECTED)
		      ftrs.remove("EdgeDetectionFilter");
		}
		else if (source == sharp) {
		   if(state == SELECTED)
		      ftrs.add("SharpenFilter");
		   else if(state == DESELECTED)
		      ftrs.remove("SharpenFilter");
		}
	 }
  }

  class ButnListener implements ActionListener{
      public void actionPerformed(ActionEvent e){

        if (e.getActionCommand().equals(ImageProcGUI.EXIT)){
           System.exit(1);
        }
        if (e.getActionCommand().equals(ImageProcGUI.RESET)){
		   clearLabels();
        }
        if (e.getActionCommand().equals(ImageProcGUI.PROCESS)){
           clearLabels();
           String selectedImg = getSelectedImage();
           String originImg = IMAGES + selectedImg;

           try{
		      PipeLineBuilder plb = new PipeLineBuilder(ftrs, imgLabel, filterInfoTxt);
		      plb.processImage(originImg, selectedImg);
		   }
		   catch (IOException e1){
		      e1.printStackTrace();
   	       }
       }
     }
  } // End of class ButnListener

  private static void createAndShowGUI(){
     JFrame.setDefaultLookAndFeelDecorated(true);
     JFrame frame = new JFrame("Batch Sequential Software Architecture-Image Processing");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     ImageProcGUI newContentPane = new ImageProcGUI();
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