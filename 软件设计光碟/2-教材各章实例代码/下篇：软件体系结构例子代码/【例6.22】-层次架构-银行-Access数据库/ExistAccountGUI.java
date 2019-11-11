import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExistAccountGUI extends GUIBuilder {
	  public static final String TRANS = "Transaction";
	  public static final String NEWACCOUNT = "New Account";
	  public static final String EXIT = "Exit";
	  private JTextField txtCustomerName;
	  private JTextField txtAcctNumber;
	  private JTextField txtTransAmount;
	  private JLabel labelCusName;
	  private JLabel labelAcctType;
	  private JLabel labelAcctNumber;
	  private JLabel labelTransType;
	  private JLabel labelTransAmount;
	  private JComboBox combAcctType;
	  private JComboBox combTransType;
	  private JLabel lblResult,lblResultValue;
	  private JButton exitButton;
	  private JButton validateButton;
	  private BankAccount account;
	  private double interestRate = 0;

	  public void initialize()  {
			setupCalendar();
	  }
	 /*--------------------------------------------------------------------------*/
	 /* Create components needed by ExistAccountGUI
	 /* with two buttons and Listener。
	  /*---------------------------------------------------------------------------*/
	  public void addGUIComponents() {
			bankUI = new JPanel();

			txtCustomerName = new JTextField(20);
			txtAcctNumber = new JTextField(20);
			txtTransAmount = new JTextField(10);

			combAcctType = new JComboBox();
			combAcctType.addItem("Savings Account");
			combAcctType.addItem("Checking Account");
			combAcctType.setSelectedItem("Savings Account");

			combTransType = new JComboBox();  // mike changed
			combTransType.addItem("Deposit");
			combTransType.addItem("Withdraw");
			combTransType.setSelectedItem("Deposit");

			labelCusName = new JLabel("Name:");
			labelAcctType = new JLabel("Account Type:");
			labelAcctNumber = new JLabel("Account number:");
			labelTransType = new JLabel("Transaction Type:");
			labelTransAmount = new JLabel("Transaction Amount:");
			lblResult = new JLabel("Result:");
			lblResultValue = new JLabel("Transaction for banking.");

			//Create three buttons using class JButton
			validateButton = new JButton(ExistAccountGUI.TRANS);
			validateButton.setMnemonic(KeyEvent.VK_V);

			exitButton = new JButton(ExistAccountGUI.EXIT);
			exitButton.setMnemonic(KeyEvent.VK_X);

			ButtonListener objButtonListener = new ButtonListener();
			validateButton.addActionListener(objButtonListener);
			exitButton.addActionListener(objButtonListener);

			//*********对UIPanel使用GridBag布局****************
			GridBagLayout gridbag = new GridBagLayout();
			 bankUI.setLayout(gridbag);
			GridBagConstraints gbc = new GridBagConstraints();

			bankUI.add(labelCusName);
			bankUI.add(txtCustomerName);
			bankUI.add(labelAcctType);
			bankUI.add(combAcctType);
			bankUI.add(labelAcctNumber);
			bankUI.add(txtAcctNumber);
			bankUI.add(labelTransType);
			bankUI.add(combTransType);
			bankUI.add(labelTransAmount);
			bankUI.add(txtTransAmount);
			bankUI.add(lblResult);
			bankUI.add(lblResultValue);
			bankUI.add(validateButton);
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
			gbc.gridy = 2;
			gridbag.setConstraints(labelAcctNumber, gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gridbag.setConstraints(txtAcctNumber, gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gridbag.setConstraints(labelTransType, gbc);
			gbc.gridx = 1;
			gbc.gridy = 3;
			gridbag.setConstraints(combTransType, gbc);
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
			buttonPanel.add(validateButton);
			buttonPanel.add(exitButton);
			bankUI.add(buttonPanel);
			gbc.gridx = 1;
			gbc.gridy = 6;
			gridbag.setConstraints(buttonPanel, gbc);
	  }  // end addGUIComponents
	  public String getCustomerName()  {
		  return txtCustomerName.getText();
	  }
	  public String getAcctNumber()  {
		  return txtAcctNumber.getText();
	  }
	  public String getTransAmount()  {
		  return txtTransAmount.getText();
	  }
	  public String getTransType()  {
		  return (String) combTransType.getSelectedItem();
	  }
	  public String getAcctType()  {
		  return (String) combAcctType.getSelectedItem();
	  }

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		String validationResult = null;

		if (e.getActionCommand().equals(EXIT)) {
		      System.exit(1);
		}
		else if (e.getActionCommand().equals(TRANS)) {
			  String custName = getCustomerName();
			  String acctNum = getAcctNumber();
			  String transAmount = getTransAmount();
			  double transAmt=Double.parseDouble(transAmount);
			  String transType = getTransType();
			  String acctType = getAcctType();

			  boolean b=BankAccount.isExistingCustomer(acctType, custName, acctNum);
			  if( b==false ) {
				   lblResultValue.setText("Wrong Customer name or account number ." );
				   lblResultValue.setForeground(Color.red);
				   return;
			  }
			  BankAccount.updateTransactionDB(custName, acctNum, acctType, transType, transAmt, time);

			  if(0 == acctType.compareTo("Savings Account") )  {
				  interestRate = SavingsAccount.getInterestRate();
				  account = new SavingsAccount(custName, acctNum);
			  }
			  else if(0 == acctType.compareTo("Checking Account") )  {
				  interestRate = CheckingAccount.getInterestRate();
				  account = new CheckingAccount(custName, acctNum);
			  }

			 if(0 == transType.compareTo("Deposit") ) {
					 //account.deposit (custName,acctType, acctNum, transAmt, interestRate, time);
					 // account.deposit (acctType, transAmt, interestRate, time);
					  account.deposit (transAmt, time);

					 lblResultValue.setText("Have depositted successfully: $" + transAmt + " to "+ acctType);
			 }
			 else if(0 == transType.compareTo("Withdraw") ) {
					 //account.withdraw(acctType,transAmt, time);
					  account.withdraw(transAmt, time);
					 lblResultValue.setText("Have withdrawn successfully: $" + transAmt+ " from "+ acctType);
			  }
		}
	  }
	} // End of class ButtonListener
}
