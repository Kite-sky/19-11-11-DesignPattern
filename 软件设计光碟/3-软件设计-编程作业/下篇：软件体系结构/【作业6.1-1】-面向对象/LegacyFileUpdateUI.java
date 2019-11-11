import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LegacyFileUpdateUI extends JPanel{
   private JComboBox cmbFileList;
   private JButton srchButton;
   private JButton resetButton;
   private JButton exitButton;
   private JPanel buttonPanel;
   private JScrollPane btnPane;
   private JTextArea[] txtArea;
   private JTextArea filterInfoTxt;
   private JScrollPane filterInfoPane;
   private JSplitPane upSplitPane;
   private JScrollPane[] txtPane;
   private JPanel downPanel;
   private JSplitPane bigSplitPane;
   private JLabel lblFile;
   private static final String PROCESS = "Process";
   private static final String RESET = "Reset";
   private static final String EXIT = "Exit";
   private static final String TEXTFILES = "TextFiles/";
   private static final Dimension minimumSize = new Dimension(230, 200);
   private static final String UPDATEDFILES = "UpdatedFiles/";

   public LegacyFileUpdateUI(){
      super(new GridLayout(1,0));
	  filterInfoTxt=new JTextArea(6, 20);
	  filterInfoTxt.setText("Input text is displayed in the 1st text area below\n");
	  filterInfoTxt.append("Political correction text is displayed in the 2nd text area below\n");
	  filterInfoTxt.append("Y2K correction text is displayed in the 3rd text area below\n");
	  filterInfoTxt.append("Sorted text is displayed in the 4th text area below");
	  setUpButtonPanel();
      buildUpScrollGUI();
   }

   private void buildUpScrollGUI(){
      txtArea = new JTextArea[4];
	  txtPane = new JScrollPane[4];
	  for(int m=0;m<txtArea.length; m++){
	     txtArea[m] = new JTextArea();
	  	 txtArea[m].setMinimumSize(new Dimension(250, 300));
	  	 txtPane[m] = new JScrollPane(txtArea[m]);
	  }
	  btnPane = new JScrollPane(buttonPanel);
	  btnPane.setMinimumSize(minimumSize);
	  filterInfoPane = new JScrollPane(filterInfoTxt);

	  upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  upSplitPane.setDividerLocation(300);
	  upSplitPane.setPreferredSize(new Dimension(600, 350));
	  upSplitPane.setLeftComponent(btnPane);
	  upSplitPane.setRightComponent(filterInfoPane);

	  downPanel = new JPanel();
	  downPanel.setLayout(new GridLayout(1,0));
	  for(int m=0; m<txtPane.length;m++)
	      downPanel.add(txtPane[m]);

	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, downPanel);
	  bigSplitPane.setDividerLocation(180);

	  add(bigSplitPane);
	  setSize(new Dimension(600, 400));
      setVisible(true);
  }

  private void setUpButtonPanel(){
	 cmbFileList = new JComboBox();
	 String[] cl = extractFileList();
     setupFileList(cmbFileList,cl);

     lblFile = new JLabel("Choose A FIle:");
     srchButton = new JButton(PROCESS);
     srchButton.setMnemonic(KeyEvent.VK_S);
     resetButton = new JButton(RESET);
     resetButton.setMnemonic(KeyEvent.VK_S);
     exitButton = new JButton(EXIT);
     exitButton.setMnemonic(KeyEvent.VK_X);
     ButnListener objButtonHandler = new ButnListener();
     srchButton.addActionListener(objButtonHandler);
     resetButton.addActionListener(objButtonHandler);
     exitButton.addActionListener(objButtonHandler);

     buttonPanel = new JPanel();
     GridBagLayout gridbag = new GridBagLayout();
     buttonPanel.setLayout(gridbag);
     GridBagConstraints gbc = new GridBagConstraints();

     buttonPanel.add(lblFile);
     buttonPanel.add(cmbFileList);
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
     gridbag.setConstraints(lblFile, gbc);
     gbc.gridx = 1;
     gbc.gridy = 0;
     gridbag.setConstraints(cmbFileList, gbc);

     gbc.insets.left = 2;
     gbc.insets.right = 2;
     gbc.insets.top = 20;
     gbc.gridx = 0;
     gbc.gridy = 9;
     gridbag.setConstraints(srchButton, gbc);
     gbc.gridx = 1;
     gbc.gridy = 9;
     gridbag.setConstraints(resetButton, gbc);
     gbc.gridx = 2;
	 gbc.gridy = 9;
     gridbag.setConstraints(exitButton, gbc);
  }
  // Get a selected file name from user input
  public String getSelectedFile() {
     String fileName = (String)cmbFileList.getSelectedItem();
     return fileName;
  }
  // Extract file names from a diectory on your computer
  public String[] extractFileList(){
     File f = new File(TEXTFILES);
     String [] fileNames = f.list();
     return fileNames;
  }
  // Add file list to combox cmbCarList.
  public void setupFileList(JComboBox cmbFileList,String[] fileList){
     for(int k=0; k<fileList.length; k++){
        cmbFileList.addItem(fileList[k]);
     }
  }
  // Display file process information to text area
  public void displayFileProcInfo(JTextArea txtArea, ArrayList<String> a ){
	   for(int n=0;n<a.size(); n++)
			txtArea.append(a.get(n));
  }
  // Clean the display areas
  public void resetTextArea(JTextArea[] ta){
	    for(int m=0;m<ta.length; m++)
		      ta[m].setText("");
  }
  class ButnListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          if (e.getActionCommand().equals(EXIT)){
               System.exit(1);
          }
          if (e.getActionCommand().equals(RESET)){
			  resetTextArea( txtArea);
          }
          if (e.getActionCommand().equals(PROCESS)){
			   resetTextArea( txtArea);
               String selectedFile = getSelectedFile();
		       try{
					  String inFileStr=TEXTFILES+selectedFile;
					  Input in = new Input(inFileStr);
					  ArrayList<String> txtInFile = in.update();
					  displayFileProcInfo(txtArea[0], txtInFile );

					  PoliticalIssue poli = new PoliticalIssue(txtInFile) ;
					  ArrayList<String> txtPoliFile = poli.update();
					  displayFileProcInfo(txtArea[1], txtPoliFile);

					  //Students write code about Y2KFixer. The result can be
					  //displayed onto the 3rd screen of the lower part of the GUI

					  Sorting st = new  Sorting(txtPoliFile) ;
					  ArrayList<String> txtSortFile = st.update();
					  displayFileProcInfo(txtArea[3], txtSortFile);

					  String updatedFileNM = UPDATEDFILES+"Updated_"+selectedFile;
					  Output out = new Output(txtSortFile, updatedFileNM) ;
					  ArrayList<String> txtOutFile = out.update();
	         }
	         catch (java.io.IOException ioe){
			      System.out.println("IO error" );
			      ioe.printStackTrace();
	         }
       }
     }
  } // End of class ButnListener
  private static void createAndShowGUI(){
     JFrame.setDefaultLookAndFeelDecorated(true);
     JFrame frame = new JFrame("Object Oriented Software Architecture-Legacy File Update");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     LegacyFileUpdateUI newContentPane = new LegacyFileUpdateUI();
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