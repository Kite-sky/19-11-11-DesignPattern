import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ClientUI extends JFrame {
  private JSplitPane  bigSplitPane;
  private JScrollPane showInfoPane;
  private JPanel btnPanel;
  private JComboBox cmbCountry;
  private JLabel lblCountry;
  private Dimension minimumSize;
  private JTextArea txtForInfo;

  public static final String HELLO = "Say Hello";
  public static final String EXIT = "Exit";
  public static final String CHINA = "China";
  public static final String USA = "United States";
  public static final String ENGLAND = "England";
  public static final String FRANCE = "France";
  public static final String UN = "United Nations";

  public ClientUI() {
      super("Composite Pattern- Say Hello ");
      minimumSize = new Dimension(130, 100);
      setUpChoicePanel();
      setUpScrollPanes();
   }
  private void setUpChoicePanel() {
	  lblCountry = new JLabel("Country ");
	  cmbCountry = new JComboBox();
	  ButtonListener btnListener = new ButtonListener();

	  cmbCountry.addItem(CHINA);
	  cmbCountry.addItem(USA);
	  cmbCountry.addItem(ENGLAND);
	  cmbCountry.addItem(FRANCE);
	  cmbCountry.addItem(UN);

	  //Create button objects
	  JButton openButton = new JButton(HELLO);
	  JButton exitButton = new JButton(EXIT);
	  openButton.setMnemonic(KeyEvent.VK_S);
	  exitButton.setMnemonic(KeyEvent.VK_X);

	  //Add action Listener
	  openButton.addActionListener(btnListener);
	  exitButton.addActionListener(btnListener);
	  btnPanel = new JPanel();
	  GridBagLayout gridbag = new GridBagLayout();
	  btnPanel.setLayout(gridbag);
	  GridBagConstraints gbc = new GridBagConstraints();
	  btnPanel.add(lblCountry);
	  btnPanel.add(cmbCountry);
	  btnPanel.add(openButton);
	  btnPanel.add(exitButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;
      gbc.gridx = 0;
      gbc.gridy = 1;
      gridbag.setConstraints(lblCountry, gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gridbag.setConstraints(cmbCountry, gbc);
      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 15;
      gbc.gridx = 0;
      gbc.gridy = 5;
      gridbag.setConstraints(openButton, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 5;
      gridbag.setConstraints(exitButton, gbc);
   }
   private void setUpScrollPanes() {
   	  txtForInfo= new JTextArea("Greetings from countries will be shown here.", 20, 30);
  	  txtForInfo.setLineWrap(true);
  	  txtForInfo.setFont(new Font("Helvetica", Font.BOLD, 20));
  	  txtForInfo.setBackground(Color.cyan);

  	  showInfoPane = new JScrollPane(txtForInfo);
  	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, showInfoPane, btnPanel);
  	  bigSplitPane.setDividerLocation(150);

      getContentPane().add(bigSplitPane);
  	  setSize(new Dimension(500, 300));
      setVisible(true);
   }
   class ButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals(EXIT)) { System.exit(1); }
			if (ae.getActionCommand().equals(HELLO)) {
				 WorldOrganization wo = null;
				 int len = 0;
				 String type = (String) cmbCountry.getSelectedItem();
				 if (type.equals(CHINA))
				  	wo = new China();
				 if (type.equals(USA))
					wo = new USA();
				 if (type.equals(ENGLAND))
					wo = new England();
				 if (type.equals(FRANCE))
					wo = new France();
				 if (type.equals(UN))
					wo = new UnitedNations();
				 String hello = wo.say();
				 wo.add(new USA());
				 txtForInfo.setText(hello);
			}
      }
   }
   public static void main(String args[]) {
      try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      } catch (Exception evt) {}

      ClientUI frame = new ClientUI();
      frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) { System.exit(0);   }} );
      frame.setSize(500, 320);
      frame.setVisible(true);
   }
}

