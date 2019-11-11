import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ClientGUI extends JFrame {
  private JSplitPane  bigSplitPane;
  private JScrollPane showInfoPane;
  private JPanel btnPanel;
  private JComboBox cmbAlgorithm, cmbHouseType;
  private JLabel lblFirstName;
  private JLabel lblLastName;
  private JLabel lblSerialNum;
  private Dimension   minimumSize;
  private JTextArea txtStudentInfo;
  private JTextField  txtFirstName;
  private JTextField txtLastName;
  private JTextField txtSerialNum;

  private StudentInfoFacade infoFacade;

  public static final String PRINT = "Print";
  public static final String EXIT = "Exit";

  public ClientGUI() {
     super("Facade Pattern- Student information system ");
     minimumSize = new Dimension(130, 100);
     setUpChoicePanel();
     setUpScrollPanes();
   }

  private void setUpChoicePanel() {
	  JLabel lblToBeSorted = new JLabel ("Input Integers");
	  txtFirstName = new JTextField(20);
      txtLastName = new JTextField(20);
      txtSerialNum = new JTextField(20);

	  lblFirstName= new JLabel("First Name");
	  lblLastName= new JLabel("Last Name");
      lblSerialNum= new JLabel("Serial Number");

	  //Create buttons
	  JButton openButton = new JButton(PRINT);
	  openButton.setMnemonic(KeyEvent.VK_S);
	  JButton exitButton = new JButton(EXIT);
	  exitButton.setMnemonic(KeyEvent.VK_X);

	  ButtonListener btnListener = new ButtonListener();

	  // add action Listener
	  openButton.addActionListener(btnListener);
	  exitButton.addActionListener(btnListener);

	  btnPanel = new JPanel();

	  //------------------------------------------------
	  GridBagLayout gridbag = new GridBagLayout();
	  btnPanel.setLayout(gridbag);
	  GridBagConstraints gbc = new GridBagConstraints();

	  btnPanel.add(lblFirstName);
	  btnPanel.add(lblLastName);
	  btnPanel.add(lblSerialNum);

	  btnPanel.add(txtFirstName);
	  btnPanel.add(txtLastName);
	  btnPanel.add(txtSerialNum);
	  btnPanel.add(openButton);
	  btnPanel.add(exitButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;

      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(lblFirstName, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridbag.setConstraints(txtFirstName, gbc);
      gbc.gridx = 0;
	  gbc.gridy = 1;
      gridbag.setConstraints(lblLastName, gbc);
      gbc.gridx = 1;
	  gbc.gridy = 1;
      gridbag.setConstraints(txtLastName, gbc);
      gbc.gridx = 0;
	  gbc.gridy = 2;
	  gridbag.setConstraints(lblSerialNum, gbc);
	  gbc.gridx = 1;
	  gbc.gridy = 2;
      gridbag.setConstraints(txtSerialNum, gbc);

      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 15;
      gbc.gridx = 0;
      gbc.gridy = 7;
      gridbag.setConstraints(openButton, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 7;
      gridbag.setConstraints(exitButton, gbc);
      //-----------------------------------------------
   }

   private void setUpScrollPanes() {
   	  Border raisedbevel = BorderFactory.createRaisedBevelBorder();

   	  txtStudentInfo= new JTextArea("Student report: \n", 20, 30);
  	  txtStudentInfo.setFont(new Font("Helvetica", Font.BOLD, 12));
  	  txtStudentInfo.setBackground(Color.cyan);

  	  showInfoPane = new JScrollPane(txtStudentInfo);

  	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, btnPanel, showInfoPane );
  	  bigSplitPane.setDividerLocation(230);

      getContentPane().add(bigSplitPane);
  	  setSize(new Dimension(500, 400));
      setVisible(true);
   }

   class ButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent ae) {

		if (ae.getActionCommand().equals(EXIT)) {
		    System.exit(1);
		}

		if (ae.getActionCommand().equals(PRINT)) {
            String firstName = txtFirstName.getText().trim();
            String lastName =  txtLastName.getText().trim();
            String studentNum = txtSerialNum.getText().trim();

            infoFacade = new StudentInfoFacade(firstName, lastName, studentNum);
            String studentInfo = infoFacade.getStudentInfo();
			txtStudentInfo.append(" "+ studentInfo + " \n");

          }
      }
   }
   public static void main(String args[]) {
      try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      }
      catch (Exception evt) {}

      ClientGUI frame = new ClientGUI();
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e)
         {
            System.exit(0);
         }
      }
      );
      frame.setSize(500, 400);
      frame.setVisible(true);
   }
}

