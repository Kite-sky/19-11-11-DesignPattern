import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewAccountGUI extends GUIBuilder {
	  public static final String TRANS = "Transaction";
	  public static final String NEWACCOUNT = "New Account";
	  public static final String EXIT = "Exit";
	  private JTextField txtCustomerName;
	  private JTextField txtAcctNumber;
	  private JTextField txtTransAmount;
	  private JLabel labelCusName;
	  private JLabel labelAcctType;
	  private JLabel labelAcctNumber;
	  private JLabel labelTransAmount;
	  private JComboBox combAcctType;
	  private JLabel lblResult,lblResultValue;
	  private JButton exitButton;
	  private JButton newAcctButton;
	  private BankAccount account;
	  private double interestRate = 0;

	  String DEPOSIT ="Deposit";
	  private String SAVINGS = "Savings Account";
	  private String CHECKING ="Checking Account";

	  public void initialize() {
		  setupCalendar();
	  }
	  /*--------------------------------------------------------------------------*/
	  /* Create components needed by NewAccountGUI
	  /* with two buttons and Listener。
	  /*---------------------------------------------------------------------------*/
	  public void addGUIComponents() {
			bankUI = new JPanel();
			txtCustomerName = new JTextField(20);
			txtTransAmount = new JTextField(10);
			combAcctType = new JComboBox();
			combAcctType.addItem("Savings Account");
			combAcctType.addItem("Checking Account");
			combAcctType.setSelectedItem("Savings Account");
			labelCusName = new JLabel("Name:");
			labelAcctType = new JLabel("Account Type:");
			labelTransAmount = new JLabel("Initial Deposit Amount:");
			lblResult = new JLabel("Comment:");
			lblResultValue = new JLabel("Initial deposit is needed to open a new account");
			newAcctButton = new JButton(NewAccountGUI.NEWACCOUNT);
			newAcctButton.setBackground(Color.red);
			newAcctButton.setMnemonic(KeyEvent.VK_V);
			exitButton = new JButton(NewAccountGUI.EXIT);
			exitButton.setMnemonic(KeyEvent.VK_X);

			ButtonListener objButtonListener = new ButtonListener();
			newAcctButton.addActionListener(objButtonListener);
			exitButton.addActionListener(objButtonListener);

			//*********对UIPanel使用GridBag布局****************
			GridBagLayout gridbag = new GridBagLayout();
			bankUI.setLayout(gridbag);
			GridBagConstraints gbc = new GridBagConstraints();

			bankUI.add(labelCusName);
			bankUI.add(txtCustomerName);
			bankUI.add(labelAcctType);
			bankUI.add(combAcctType);
			bankUI.add(labelTransAmount);
			bankUI.add(txtTransAmount);
			bankUI.add(lblResult);
			bankUI.add(lblResultValue);
			bankUI.add(newAcctButton);
			bankUI.add(exitButton);
			gbc.insets.top = 5;
			gbc.insets.bottom = 5;
			gbc.insets.left = 5;
			gbc.insets.right = 5;
			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx = 0;
			gbc.gridy = 0;
			gridbag.setConstraints(labelCusName, gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			gridbag.setConstraints(txtCustomerName, gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gridbag.setConstraints(labelAcctType, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gridbag.setConstraints(combAcctType, gbc);
			gbc.gridx = 0;
			gbc.gridy = 4;
			gridbag.setConstraints(labelTransAmount, gbc);
			gbc.gridx = 1;
			gbc.gridy = 4;
			gridbag.setConstraints(txtTransAmount, gbc);
			gbc.gridx = 0;
			gbc.gridy = 5;
			gridbag.setConstraints(lblResult, gbc);
			gbc.gridx = 1;
			gbc.gridy = 5;
			gridbag.setConstraints(lblResultValue, gbc);
			gbc.insets.left = 2;
			gbc.insets.right = 2;
			gbc.insets.top = 40;

			JPanel buttonPanel = new JPanel();

			buttonPanel.add(newAcctButton);
			buttonPanel.add(exitButton);
			bankUI.add(buttonPanel);
			gbc.gridx = 1;
			gbc.gridy = 6;
			gridbag.setConstraints(buttonPanel, gbc);
	  }  // end addGUIComponents
	  public String getCustomerName()  {
		  return txtCustomerName.getText();
	  }
	  public String getTransAmount()  {
		  return txtTransAmount.getText();
	  }
	  public String getAcctType()  {
		  return (String) combAcctType.getSelectedItem();
	  }
	  class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e)  {
		String validationResult = null;

		if (e.getActionCommand().equals(NewAccountGUI.EXIT)) {
		  System.exit(1);
		}
		else if (e.getActionCommand().equals(NewAccountGUI.NEWACCOUNT))  {
			String custName = getCustomerName();
			String transAmount = getTransAmount();
			double transAmt=Double.parseDouble(transAmount);
			String acctType = getAcctType();

			if(acctType.equals(SAVINGS))
				  interestRate = SavingsAccount.getInterestRate();
			else if (acctType.equals(CHECKING))
                  interestRate = CheckingAccount.getInterestRate();

			String acctNum = BankAccount.generateAccountNumber(acctType);
			BankAccount.updateTransactionDB(custName, acctNum, acctType, DEPOSIT, transAmt, time);
            BankAccount.createNewAcct (custName, acctNum, acctType, interestRate, transAmt, time);

			lblResultValue.setText("New "+acctType+" (No. "+acctNum+" )" +" was created." );
		  }
	  }
	} // End of class ButtonListener
}
