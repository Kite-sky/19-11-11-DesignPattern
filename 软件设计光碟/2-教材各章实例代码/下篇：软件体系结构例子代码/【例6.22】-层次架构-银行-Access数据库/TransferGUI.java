import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TransferGUI extends GUIBuilder {
	  public static final String TRANS = "Transaction";
	  public static final String NEWACCOUNT = "New Account";
	  public static final String EXIT = "Exit";
	  private JTextField txtCustomerName;
	  private JTextField txtAcctNumber1;
	  private JTextField txtAcctNumber2;

	  private JTextField txtTransAmount;
	  private JButton exitButton = new JButton(ExistAccountGUI.EXIT);
	  private JButton transButton = new JButton(ExistAccountGUI.TRANS);
	  private BankAccount account;
	  private double interestRate = 0;
	  private String accountChosen;
	  JLabel labelTransFrom = new JLabel("Transfer from:");
	  JLabel labelTransTo = new JLabel("Transfer to:");
	  JLabel lblCusName = new JLabel("Name:");
	  JLabel lblAcctNum1 = new JLabel("Account number 1:");
	  JLabel lblAcctNum2 = new JLabel("Account number 2:");
	  JLabel lblTransAmount = new JLabel("Transaction Amount:");
	  JLabel lblResult = new JLabel("Result:");
	  JLabel lblResultValue = new JLabel("Bank Transactions");
	  JRadioButton fromSavingsBtn = new JRadioButton(FROMSAVINGS);
	  JRadioButton fromCheckingBtn = new JRadioButton(FROMCHECKING);
	  JRadioButton toSavingsBtn  = new JRadioButton(TOSAVINGS);
	  JRadioButton toCheckingBtn = new JRadioButton(TOCHECKING);

	  private static String FROMSAVINGS="Savings Account";
	  private static String FROMCHECKING="Checking Account";
	  private static String TOSAVINGS="Savings Account";
	  private static String TOCHECKING="Checking Account";
	  private String fromAcctStr;
	  private String toAcctStr;

	  public void initialize()  {
			setupCalendar();
	  }
	 /*--------------------------------------------------------------------------*/
	 /* Create components needed by ExistAccountGUI
	 /* with two buttons and Listener?¡ê
	  /*---------------------------------------------------------------------------*/
	  public void addGUIComponents() {
			bankUI = new JPanel();
		    fromSavingsBtn.addActionListener(new  FromRadoiBtnListener());
		    fromCheckingBtn.addActionListener(new  FromRadoiBtnListener());
		    toSavingsBtn.setEnabled(false);
		    toCheckingBtn.setEnabled(false);

		    JPanel p1=new JPanel();
		    JPanel p2=new JPanel();
		    p1.add(fromSavingsBtn);
		    p1.add(fromCheckingBtn);
		    p2.add(toSavingsBtn);
		    p2.add(toCheckingBtn);

		    ButtonGroup fromGroup = new ButtonGroup();
		    ButtonGroup toGroup = new ButtonGroup();
		    fromGroup.add(fromSavingsBtn);
		    fromGroup.add(fromCheckingBtn);
		    toGroup.add(toSavingsBtn);
		    toGroup.add(toCheckingBtn);

			txtCustomerName = new JTextField(12);
			txtAcctNumber1 = new JTextField(12);
			txtAcctNumber2 = new JTextField(12);
			txtTransAmount = new JTextField(12);

			transButton.setMnemonic(KeyEvent.VK_V);
			exitButton.setMnemonic(KeyEvent.VK_X);

			ButtonListener objButtonListener = new ButtonListener();
			transButton.addActionListener(objButtonListener);
			exitButton.addActionListener(objButtonListener);

			GridBagLayout gridbag = new GridBagLayout();
			 bankUI.setLayout(gridbag);
			GridBagConstraints gbc = new GridBagConstraints();

			bankUI.add(lblCusName);
			bankUI.add(txtCustomerName);
			bankUI.add(labelTransFrom);
			bankUI.add(p1);
			bankUI.add(lblAcctNum1);
			bankUI.add(txtAcctNumber1);
		    bankUI.add(labelTransTo);
		    bankUI.add(p2);
		    bankUI.add(lblAcctNum2);
			bankUI.add(txtAcctNumber2);
			bankUI.add(lblTransAmount);
			bankUI.add(txtTransAmount);
			bankUI.add(lblResult);
			bankUI.add(lblResultValue);
			bankUI.add(transButton);
			bankUI.add(exitButton);

			gbc.insets.top = 2;
			gbc.insets.bottom = 2;
			gbc.insets.left = 0;
			gbc.insets.right = 0;
			gbc.anchor = GridBagConstraints.WEST;

			gbc.gridx = 0;
			gbc.gridy = 0;
			gridbag.setConstraints(lblCusName, gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			gridbag.setConstraints(txtCustomerName, gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gridbag.setConstraints(labelTransFrom, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gridbag.setConstraints(p1, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gridbag.setConstraints(lblAcctNum1, gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gridbag.setConstraints(txtAcctNumber1, gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gridbag.setConstraints(labelTransTo, gbc);
			gbc.gridx = 1;
			gbc.gridy = 3;
            gridbag.setConstraints(p2, gbc);
			gbc.gridx = 0;
			gbc.gridy = 4;
			gridbag.setConstraints(lblAcctNum2, gbc);
			gbc.gridx = 1;
			gbc.gridy = 4;
			gridbag.setConstraints(txtAcctNumber2, gbc);
			gbc.gridx = 0;
			gbc.gridy = 5;
			gridbag.setConstraints(lblTransAmount, gbc);
			gbc.gridx = 1;
			gbc.gridy = 5;
			gridbag.setConstraints(txtTransAmount, gbc);
			gbc.gridx = 0;
			gbc.gridy = 6;
			gridbag.setConstraints(lblResult, gbc);
			gbc.gridx = 1;
			gbc.gridy = 6;
			gridbag.setConstraints(lblResultValue, gbc);
			gbc.insets.left = 2;
			gbc.insets.right =2;
			gbc.insets.top = 40;
			JPanel buttonPanel = new JPanel();
			buttonPanel.add(transButton);
			buttonPanel.add(exitButton);
			bankUI.add(buttonPanel);
			gbc.gridx = 1;
			gbc.gridy = 7;
			gridbag.setConstraints(buttonPanel, gbc);
	  }  // end addGUIComponents
	  public String getCustomerName()  {
		    return txtCustomerName.getText();
	  }
	  public String getFromAcctNumber()  {
		    return txtAcctNumber1.getText();
	  }
	  public String getToAcctNumber()  {
	  	    return txtAcctNumber2.getText();
	  }
	  public String getTransAmount()  {
		    return txtTransAmount.getText();
	  }
	  public String getFromAcct()  {
	  		return fromAcctStr;
	  }
	  public String getToAcct()  {
	  		return toAcctStr;
	  }

      class FromRadoiBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           fromAcctStr = (String)e.getActionCommand();

           if(fromAcctStr.equals(FROMSAVINGS)){
           	     toCheckingBtn.setEnabled(true);
           	     toCheckingBtn.setSelected(true);
			     toSavingsBtn.setEnabled(false);
			     toAcctStr = TOCHECKING;
			}
           else if(fromAcctStr.equals(FROMCHECKING)){
			     toSavingsBtn.setEnabled(true);
           	     toSavingsBtn.setSelected(true);
			     toCheckingBtn.setEnabled(false);
			     toAcctStr = TOSAVINGS;
			}
            System.out.println(" fromAcctStr = "+ fromAcctStr);
            System.out.println(" toAcctStr = "+toAcctStr);
        }
     }

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		String validationResult = null;

		if (e.getActionCommand().equals(EXIT)) {
		      System.exit(1);
		}
		else if (e.getActionCommand().equals(TRANS)) {
			  String custName = getCustomerName();
			  String fromAcct = getFromAcct();
			  String toAcct = getToAcct();
			  String fromAcctNum = getFromAcctNumber();
			  String toAcctNum = getToAcctNumber();
			  String transAmount = getTransAmount();
			  double transAmt=Double.parseDouble(transAmount);

			  boolean person1=BankAccount.isExistingCustomer(fromAcct, custName, fromAcctNum );
			  boolean person2=BankAccount.isExistingCustomer(toAcct, custName, toAcctNum );

			  if( person1==false ) {
				   lblResultValue.setText("Wrong Customer for from account number." );
				   lblResultValue.setForeground(Color.red);
				   return;
			  }
			  if( person2==false ) {
				   lblResultValue.setText("Wrong Customer for to account number." );
				   lblResultValue.setForeground(Color.red);
				   return;
			  }

			  if(0 == fromAcct.compareTo("Savings Account") )  {
				  interestRate = SavingsAccount.getInterestRate();
				  account = new SavingsAccount(custName, fromAcctNum);
			  }
			  else if(0 == fromAcct.compareTo("Checking Account") )  {
				  interestRate = CheckingAccount.getInterestRate();
				  account = new CheckingAccount(custName, fromAcctNum);
			  }

             if(0 == toAcct.compareTo("Savings Account") )  {
				  interestRate = SavingsAccount.getInterestRate();
				  account = new SavingsAccount(custName, fromAcctNum);
			  }
			  else if(0 == toAcct.compareTo("Checking Account") )  {
				  interestRate = CheckingAccount.getInterestRate();
				  account = new CheckingAccount(custName, fromAcctNum);
			  }
			  account.transfer( custName, fromAcct, fromAcctNum, toAcct, toAcctNum, transAmt, interestRate, time);
			  BankAccount.updateTransactionDB(custName, fromAcctNum, fromAcct, "Withdraw", transAmt, time);
			  BankAccount.updateTransactionDB(custName, toAcctNum, toAcct, "Deposit", transAmt, time);
			  lblResultValue.setText("Transfered successfully: $" + transAmt + " from "+fromAcct+" to "+ toAcct);
		}
	  }
	} // End of class ButtonListener
}
