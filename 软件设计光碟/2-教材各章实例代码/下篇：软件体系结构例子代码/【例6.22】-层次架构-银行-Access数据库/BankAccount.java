//--------------------------------------------------------------------------------------------------
//  BankAccount.java       Author: Yushan Sun
//  Represents a bank account with basic services such as deposit
//  and withdraw.
//--------------------------------------------------------------------------------------------------
import java.sql.*;

public abstract class BankAccount {
   protected String custName;
   protected String acctNumber;
   protected double  balance;
   private DBInteractions db;

   //----------------------------------------------------------
   //  Used by accessing existing account
   //----------------------------------------------------------
   public BankAccount (String owner, String account) {
      custName = owner;
      acctNumber = account;
   }
   //--------------------------------------------------------------------------------
   //  This constructor is used to open a new account.
   //-------------------------------------------------------------------------------
   public BankAccount (String owner, String account, double initial) {
      custName = owner;
      acctNumber = account;
      balance = initial;
   }
   //--------------------------------------------------------------------------------------------------
   //  Validates the transaction, then deposits the specified amount
   //  into the account.
   //---------------------------------------------------------------------------------------------------
   public abstract void deposit (double amount, String nowDate);

   //-----------------------------------------------------------------
   //  Validates the transaction, then withdraws the specified amount
   //  from the account.
   //-----------------------------------------------------------------
   public abstract void withdraw (double amount, String nowDate) ;

   //-------------------------------------------------------------------------------------------------
   // Transfer transAmount of money from one account to another
   //-------------------------------------------------------------------------------------------------
   public void transfer( String cusName, String fromAcct, String fromAcctNum,
                                       String toAcct, String toAcctNum, double amount,
                                       double toMonthInterestRate, String currentDate) {
            //withdraw
            if (amount < 0) {
                  System.out.println ("Error: Transfer amount must be nonnegative.");
                  return;
            }
   		 db = new DBInteractions();
   		 double dbBalance = db.getExistCustomerBalance(fromAcct, cusName, fromAcctNum);

            if (amount > dbBalance)  {// withdraw value exceeds balance
               System.out.println ("Error: Insufficient balance.");
                return;
            }

             String tableName = "";
   		  if(0 == fromAcct.compareTo("Checking Account"))
   			  tableName = "CheckingAccount";
   		  else if(0 == fromAcct.compareTo("Savings Account"))
   	          tableName = "SavingsAccount";

          String depositedDate = db.retrieveDate (tableName, cusName, fromAcctNum);
   		  double oldInterestRate = db.retrieveInterestRate (tableName , cusName, fromAcctNum);
   	      double interestFromOriginalBanlance = calculateInterest( amount, depositedDate, currentDate, oldInterestRate);
          double earnedInterest = db.retrieveEarnedInterest (tableName , cusName, fromAcctNum);
   	      double nowInterestTotal = earnedInterest + interestFromOriginalBanlance;
   	      double newBalance = dbBalance + interestFromOriginalBanlance- amount;
          db.executeWithdraw(tableName , cusName, fromAcctNum, nowInterestTotal, newBalance) ;

          //deposit
   		  double dbBalance2 = db.getExistCustomerBalance(toAcct, cusName, toAcctNum);

   		  String tableName2 = "";
   		  if(0 == toAcct.compareTo("Checking Account"))
   			  tableName2 = "CheckingAccount";
   		  else if(0 == toAcct.compareTo("Savings Account"))
   			  tableName2 = "SavingsAccount";

   		 String depositedDate2 = db.retrieveDate (tableName2, cusName, toAcctNum);
   		 double oldInterestRate2 = db.retrieveInterestRate (tableName2 , cusName, toAcctNum);
   		 double interestFromOriginalBanlance2 = calculateInterest( dbBalance2, depositedDate2, currentDate,
   		                                                                                            oldInterestRate2);
   		 double earnedInterest2 = db.retrieveEarnedInterest (tableName2 , cusName, toAcctNum);
   		 double nowInterestTotal2 = earnedInterest2 + interestFromOriginalBanlance2;

   		 double newBalance2 = dbBalance2 + interestFromOriginalBanlance2 + amount;
   	     db.executeDeposit (cusName, tableName2, toAcctNum, newBalance2, toMonthInterestRate,
   	                                    nowInterestTotal2, currentDate);
      }

   // store every transaction information
   public static void updateTransactionDB (String custName, String acctNum,
                                                                    String acctType,String transType,
                                                                    double transAmount, String date) {
		DBInteractions db = new DBInteractions();
		db.updateTransDB (custName, acctNum, acctType, transType, transAmount, date);
	}
	// Create a new account, which maybe an savings or checking account
    public static void createNewAcct (String custName, String acctNum,String acctType,
                                                         double interestRate, double balance, String date)  {
    	DBInteractions db = new DBInteractions();
		db.createNewAcct (custName, acctNum, acctType, interestRate, balance, date);

	}
	// Check if the customer is an existing customer or not
    public static boolean isExistingCustomer(String acctType, String acctHolder, String acctNum) {
		DBInteractions db = new DBInteractions();
		return db.isExistingCustomer(acctType, acctHolder, acctNum);
	}
	// Rodomly generate a unique account number
	public static String generateAccountNumber(String acctType){
		 DBInteractions db = new DBInteractions();
		 String acctNum = db.generateAcctNum(acctType);
		 return acctNum;
	 }
    // Calculate interest total from an account
	 protected double calculateInterest( double currentBalance, String depositDate,
	                                                              String currentDate, double monthInterestRate){
     		String depositYear = depositDate.substring(0, 4);
     		String depositMonth = depositDate.substring(4, 6);
     		String currentYear = currentDate.substring(0, 4);
     		String currentMonth = currentDate.substring(4, 6);

     		int dYear = Integer.parseInt(depositYear);
     		int dMonth = Integer.parseInt(depositMonth);
     		int cYear = Integer.parseInt(currentYear);
     		int cMonth = Integer.parseInt(currentMonth);

     		int numMonthDeposit = (12*cYear+cMonth)-(12*dYear+dMonth);
     		double netInterest = monthInterestRate*numMonthDeposit*currentBalance;
     		return netInterest;
      }

     //-----------------------------------------------------------------
     //  Returns the account owner's name
     //-----------------------------------------------------------------
     public String getName () {
           return custName;
     }
     //-----------------------------------------------------------------
	 //  Returns the current balance of the account.
	 //-----------------------------------------------------------------
	      public double getBalance ()  {
	 	    return balance;
     }
      //-----------------------------------------------------------------
      // Returns the account number
      //-----------------------------------------------------------------
      public String getAccountNumber () {
	    	 return acctNumber;
      }
}

