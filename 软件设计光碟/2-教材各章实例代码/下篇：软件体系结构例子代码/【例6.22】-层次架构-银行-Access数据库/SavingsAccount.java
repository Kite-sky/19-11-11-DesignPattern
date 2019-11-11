//********************************************************************
//  SavingsAccount.java       Author: Yushan Sun
//  Represents a bank account with basic services such as deposit
//  and withdraw.
//********************************************************************
public class SavingsAccount extends BankAccount {
   private double balance;
   private static double INTEREST_RATE = 0.006;
   //private double interest;
   private static final String SAVINGS_TABLE = "SavingsAccount";
   private DBInteractions db;
   private static final String ACCT_TYPE ="Savings Account";

   //-----------------------------------------------------------------
   //  Sets up the account by defining its owner, account number.
   //-----------------------------------------------------------------
   public SavingsAccount (String owner, String account) {
      super(owner, account);
   }
   //-----------------------------------------------------------------
   //  Sets up the account by defining its owner, account number,
   //  and initial balance.
   //-----------------------------------------------------------------
   public SavingsAccount (String owner, String account, double initial)   {
      super(owner, account, initial);
   }

   //--------------------------------------------------------------------------------------------------
   //  Validates the transaction, then deposits the specified amount
   //  into the account.
   //---------------------------------------------------------------------------------------------------
   public void deposit (double amount, String nowDate) {
   	    if (amount < 0)  {
   	            System.out.println ("Error: Deposit amount must be nonnegative.");
   	            return;
         }

   	    db = new DBInteractions();
   	    double dbBalance = db.getExistCustomerBalance(ACCT_TYPE, custName, acctNumber);

   	    String depositedDate = db.retrieveDate (SAVINGS_TABLE, custName, acctNumber);
        double oldInterestRate = db.retrieveInterestRate (SAVINGS_TABLE, custName, acctNumber);
   	    double interestFromOriginalBanlance = calculateInterest( dbBalance, depositedDate, nowDate, oldInterestRate);
   	    double earnedInterest = db.retrieveEarnedInterest (SAVINGS_TABLE, custName, acctNumber);
   	    double nowInterestTotal = earnedInterest + interestFromOriginalBanlance;

   	    balance = dbBalance + interestFromOriginalBanlance + amount;
   	    db.executeDeposit (custName, SAVINGS_TABLE, acctNumber, balance, INTEREST_RATE, nowInterestTotal, nowDate);
   }

    //-----------------------------------------------------------------
    //  Validates the transaction, then withdraws the specified amount
    //  from the account.
    //-----------------------------------------------------------------
	public void withdraw (double amount, String nowDate) {
            if (amount < 0) {
                  System.out.println ("Error: Withdraw amount must be nonnegative.");
                  return;
            }
   		 db = new DBInteractions();
   		 double dbBalance = db.getExistCustomerBalance(ACCT_TYPE, custName, acctNumber);

            if (amount > dbBalance)  {// withdraw value exceeds balance
               System.out.println ("Error: Insufficient balance.");
            }
            else {
   			String depositedDate = db.retrieveDate (SAVINGS_TABLE, custName, acctNumber);
   			double oldInterestRate = db.retrieveInterestRate (SAVINGS_TABLE , custName, acctNumber);
   	        double interestFromOriginalBanlance = calculateInterest( amount, depositedDate, nowDate, oldInterestRate);
            double earnedInterest = db.retrieveEarnedInterest (SAVINGS_TABLE , custName, acctNumber);
   	        double nowInterestTotal = earnedInterest + interestFromOriginalBanlance;

   	        balance = dbBalance + interestFromOriginalBanlance- amount;
   		    db.executeWithdraw(SAVINGS_TABLE , custName, acctNumber, nowInterestTotal, balance) ;
   	     }
   }

   public static double getInterestRate(){
   	   return INTEREST_RATE;
   }
   public double getBalance(){
      	   return  balance;
   }
}

