import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import com.sun.java.swing.plaf.windows.*;

public class TestingGUI extends JPanel{
   private JTextArea txtTestInfo, txtTestcase;
   private JLabel lblTestcases;
   private JPanel buttonPanel;
   private JComboBox cmbTestcases;

   private static final String CASE_BUBBLE= "TC1-Test Bubble Sort";
   private static final String CASE_HEAP= "TC2-Test Heap Sort";
   private static final String CASE_INSERTION= "TC3-Test Insertion Sort";
   private static final String EXECUTE = "Execute";
   private static final String EXIT = "Exit";

   public TestingGUI(){
	  txtTestInfo=new JTextArea("Test output from source shown here\n", 6, 20);
	  txtTestInfo.setLineWrap(true);
	  txtTestcase = new JTextArea("Testcase info and test validation shown here\n", 4, 15);
	  txtTestcase.setLineWrap(true);
      buildUpScrollGUI();
   }

   private void buildUpScrollGUI(){
      setUpButtonPanel();
	  JScrollPane btnPane = new JScrollPane(buttonPanel);
	  JScrollPane textPane = new JScrollPane(txtTestcase);
	  textPane.setMinimumSize(new Dimension(250, 150));
	  JScrollPane testDataPane = new JScrollPane(txtTestInfo);

	  JSplitPane upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  upSplitPane.setLeftComponent(btnPane);
	  upSplitPane.setRightComponent(testDataPane);
	  JScrollPane downPane = new JScrollPane(textPane);

	  Dimension minimumSize = new Dimension(130, 100);
	  btnPane.setMinimumSize(minimumSize);
	  textPane.setMinimumSize(new Dimension(100, 100));
	  upSplitPane.setDividerLocation(270);
	  upSplitPane.setPreferredSize(new Dimension(500, 300));

	  JSplitPane bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, downPane);
	  bigSplitPane.setDividerLocation(190);

	  add(bigSplitPane);
	  setSize(new Dimension(500, 400));
      setVisible(true);
  }

  private void setUpButtonPanel(){
	  lblTestcases = new JLabel("Test Cases:");
	  cmbTestcases = new JComboBox();
      cmbTestcases.addItem(CASE_BUBBLE);
      cmbTestcases.addItem(CASE_HEAP);
      cmbTestcases.addItem(CASE_INSERTION);

     //Create the open button
     JButton executeBtn = new JButton(EXECUTE);
     executeBtn.setMnemonic(KeyEvent.VK_S);
     JButton exitButton = new JButton(EXIT);
     exitButton.setMnemonic(KeyEvent.VK_X);

     BtnListener objButtonHandler = new BtnListener();
     // add action Listener
     executeBtn.addActionListener(objButtonHandler);
     exitButton.addActionListener(objButtonHandler);
     buttonPanel = new JPanel();

     GridBagLayout gridbag = new GridBagLayout();
     buttonPanel.setLayout(gridbag);
     GridBagConstraints gbc = new GridBagConstraints();

     buttonPanel.add(lblTestcases);
     buttonPanel.add(cmbTestcases);
     buttonPanel.add(executeBtn);
     buttonPanel.add(exitButton);
     gbc.insets.top = 5;
     gbc.insets.bottom = 5;
     gbc.insets.left = 5;
     gbc.insets.right = 5;

     gbc.anchor = GridBagConstraints.EAST;
     gbc.gridx = 0;
     gbc.gridy = 0;
     gridbag.setConstraints(lblTestcases, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
     gbc.gridy = 0;
     gridbag.setConstraints(cmbTestcases, gbc);
     gbc.anchor = GridBagConstraints.EAST;
     gbc.insets.left = 2;
     gbc.insets.right = 2;
     gbc.insets.top = 25;
     gbc.anchor = GridBagConstraints.EAST;
     gbc.gridx = 0;
     gbc.gridy = 7;
     gridbag.setConstraints(executeBtn, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
     gbc.gridy = 7;
     gridbag.setConstraints(exitButton, gbc);
  }
  public void showTestInfo(int[] str ){
	  txtTestInfo.setText("");
	  for(int n=0; n< str.length; n++)
	        txtTestInfo.append(""+str[n]+" ");
  }
  public void showErrors(String err){
	 txtTestcase.append(err+"\n");
  }
  public String getSelectedTestcase() {
  	    return (String) cmbTestcases.getSelectedItem();
  }

 class BtnListener implements ActionListener{
    private Testcase test;
    private String selectedTestcase;

    public void actionPerformed(ActionEvent e){
      String searchResult = null;
      int[] output=null;

      if (e.getActionCommand().equals(EXIT)){
         System.exit(1);
      }
      if (e.getActionCommand().equals(EXECUTE)){
				 selectedTestcase = getSelectedTestcase();
				 if(selectedTestcase.equals(CASE_BUBBLE))
					   test = new TestcaseBubble();
				 else if(selectedTestcase.equals(CASE_HEAP))
					   test = new TestcaseHeap();
				 else if(selectedTestcase.equals(CASE_INSERTION))
					   test = new TestcaseInsertion();
				 output = test.execute(50000);
				 showTestInfo(output);
         }
          showErrors(selectedTestcase);
          boolean result = ResultVerification.isResultCorrect(output );
          showErrors("No Error found = " +result);
          long timeTaken = test.getTimeTaken();
          showErrors("Testing Time takes = " + timeTaken+"\n");
   }
 } // End of class BtnListener

 private static void createAndShowGUI(){
     JFrame.setDefaultLookAndFeelDecorated(true);
     JFrame frame = new JFrame("Layered Architecture- Software Testing");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     TestingGUI newContentPane = new TestingGUI();
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

