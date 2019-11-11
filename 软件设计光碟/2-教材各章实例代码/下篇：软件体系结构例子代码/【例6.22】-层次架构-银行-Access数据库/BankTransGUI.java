import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankTransGUI extends JFrame{
	  public static final String EXIT = "Exit";
	  public static final String NEWACCT = "Open A New Account";
	  public static final String EXISTACCT = "Banking with an Existing Account";
	  public static final String TRANSFER = "Transfer Between Two Accounts";
	  public static final String BLANK = "";
	  private JComboBox cmbBankingType;
	  private JPanel bankInterfaceSwitchPanel;

	  public BankTransGUI() throws Exception {
		super("Layered Architecture Demo -  Banking System");
		bankInterfaceSwitchPanel = new JPanel();

		//Combox used to switch GUIs
		cmbBankingType = new JComboBox();
		cmbBankingType.addItem(BLANK);
		cmbBankingType.addItem(NEWACCT);
		cmbBankingType.addItem(EXISTACCT);
		cmbBankingType.addItem(TRANSFER);

		JLabel lblBankingType = new JLabel("Banking Options :");
		ButtonListener vf = new ButtonListener();
		cmbBankingType.addActionListener(vf);

		//For layout purposes, put the buttons in a separate panel
		JPanel bankInterfacePanel = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		bankInterfacePanel.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();

		bankInterfacePanel.add(lblBankingType);
		bankInterfacePanel.add(cmbBankingType);
		bankInterfacePanel.add(bankInterfaceSwitchPanel);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.right = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gridbag.setConstraints(lblBankingType, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gridbag.setConstraints(cmbBankingType, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gridbag.setConstraints(bankInterfaceSwitchPanel, gbc);

		//Add the buttons and the log to the frame
		Container contentPane = getContentPane();
		contentPane.add(bankInterfacePanel, BorderLayout.CENTER);
		JLabel lblBank = new JLabel("Sun Commercial Bank-Banking System");
		lblBank.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 24));
		lblBank.setForeground(Color.pink);
		contentPane.add(lblBank, BorderLayout.NORTH);

		try {
		  JFrame.setDefaultLookAndFeelDecorated(true);
		   SwingUtilities.updateComponentTreeUI(BankTransGUI.this);
		}
		catch (Exception ex) {
		  System.out.println(ex);
		}
	  }
	  public String getBankingType() {
		return (String) cmbBankingType.getSelectedItem();
	  }
	  public JComboBox getBankTypeControl() {
		return cmbBankingType;
	  }
	  public void displayNewUI(JPanel panel) {
		bankInterfaceSwitchPanel.removeAll();
		bankInterfaceSwitchPanel.add(panel);
		bankInterfaceSwitchPanel.validate();
		validate();
	  }

  public static void main(String[] args) throws Exception {
    JFrame frame = new BankTransGUI();
    frame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }  }  );
     frame.pack();
     frame.setSize(600, 400);
    frame.setVisible(true);
  }
  class ButtonListener implements ActionListener {
	  GUIBuilder builder;
	  public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(EXIT)) {
		  System.exit(1);
		}
		if (e.getSource() == getBankTypeControl()){
		  String selection = getBankingType();

		  if (selection.equals("") == false) {
			BuilderFactory factory = new BuilderFactory();
			builder = factory.getUIBuilder(selection);
			GUIDirector director = new GUIDirector(builder);
			director.build();

			JPanel UIObj = builder.getBankUI();
			displayNewUI(UIObj);
		  }
		}
	  }
  }
}  //end class BankTransGUI

class BuilderFactory {
	  public GUIBuilder getUIBuilder(String str) {
		GUIBuilder builder = null;
		if (str.equals(BankTransGUI.NEWACCT)) {
		  builder = new NewAccountGUI();
		}
		else if (str.equals(BankTransGUI.EXISTACCT)) {
		  builder = new ExistAccountGUI();
		}
		else if (str.equals(BankTransGUI.TRANSFER)) {
		  builder = new TransferGUI();
		}

		return builder;
	  }
}
