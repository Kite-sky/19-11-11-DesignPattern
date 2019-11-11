import java.sql.*;
import java.util.Random;

public class DBInteractions {
    public Connection conn = null;
    public ResultSet rs = null;
    private static final String DatabaseDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
    private static final String DatabaseConnStr = "jdbc:odbc:Bank";    //DataSource 数据源名称DSN

    public DBInteractions() {
	        try {
	           Class.forName(DatabaseDriver);
	        }
	        catch(java.lang.ClassNotFoundException e) {
	            System.err.println("Driver loading error: " + e.getMessage());
	        }
    }

    // Find whether an user is an existing user or not
	public boolean isExistingCustomer(String acctType, String acctHolder, String acctNum) {
		   rs = null;
		   String queryStr="";
		   boolean flag = false;

		   if(0==acctType.compareTo("Savings Account"))
		      queryStr = "SELECT * FROM SavingsAccount";
		   else if(0==acctType.compareTo("Checking Account"))
			  queryStr = "SELECT * FROM CheckingAccount";

		   try  {
		      conn = DriverManager.getConnection(DatabaseConnStr);
		      Statement stmt = conn.createStatement();
		      rs = stmt.executeQuery(queryStr);
		      // Loop through the result set
			  while( rs.next() ) {
				if( 0==acctNum.compareTo(rs.getString("AccountNumber")) &&
					     0==acctHolder.compareTo(rs.getString("Name")) )  {
					flag = true;
				}
		      }
		   }
		   catch(SQLException ex)  {
		        System.err.println("query edrror: " + ex.getMessage() + queryStr);
		   }
		  return flag;
    }

    // Find whether an user is an existing user or not
		public boolean isExistingAcctNum(String acctType, String acctNum){
			rs = null;
			String queryStr="";
			boolean flag = false;

			if(0==acctType.compareTo("Savings Account"))
			    queryStr = "SELECT * FROM SavingsAccount";
			else if(0==acctType.compareTo("Checking Account"))
			    queryStr = "SELECT * FROM CheckingAccount";

			try {
			   conn = DriverManager.getConnection(DatabaseConnStr);
			   Statement stmt = conn.createStatement();
			   rs = stmt.executeQuery(queryStr);
			   // Loop through the result set
			   while( rs.next() )  {
				   if( 0==acctNum.compareTo(rs.getString("AccountNumber")))  {
						flag = true;
				    }
			   }
			}
			catch(SQLException ex) {
			    System.err.println("Query error: " + ex.getMessage() + queryStr);
			}
			return flag;
    }

	public double getExistCustomerBalance(String acctType, String acctHolder, String acctNum){
	   rs = null;
	   String queryStr="";
	   double balance = Double.NEGATIVE_INFINITY;

	   if(0==acctType.compareTo("Savings Account"))
	        queryStr = "SELECT * FROM SavingsAccount";
	   else if(0==acctType.compareTo("Checking Account"))
		    queryStr = "SELECT * FROM CheckingAccount";

	   try {
	      conn = DriverManager.getConnection(DatabaseConnStr);
	      Statement stmt = conn.createStatement();
	      rs = stmt.executeQuery(queryStr);
	      // Loop through the result set
		  while( rs.next() ) {
			if( 0==acctNum.compareTo(rs.getString("AccountNumber")) &&
				     0==acctHolder.compareTo(rs.getString("Name")) ) {
				balance = rs.getDouble("Balance");
			}
	      }
	      rs.close();
		  stmt.close();
   	      conn.close();
	   }
	   catch(SQLException ex) {
		   System.err.println("Query error: " + ex.getMessage() + queryStr);
	   }
	   return balance;
    }

public String retrieveDate (String  tableName , String cusName, String acctNumber) {
	    String date = null;
	    try {
	               conn = DriverManager.getConnection(DatabaseConnStr);
	               Statement stmt = conn.createStatement();
	               String updateString = "SELECT * from  "+ tableName;
	               ResultSet rs = stmt.executeQuery(updateString);
	               while( rs.next() ) {
						if( 0==acctNumber.compareTo(rs.getString("AccountNumber")) &&
								 0==cusName.compareTo(rs.getString("Name")) ) {
							date = rs.getString("Date");
						}
	               }
	               rs.close();
				   stmt.close();
   			       conn.close();
	    }
	    catch(SQLException ex) {
	          System.err.println("query error: " + ex.getMessage());
	    }
	    return date;
   }
   public double retrieveInterestRate (String  tableName , String cusName, String acctNumber) {
   	    double interestRate = 0;
   	    try {
   	               conn = DriverManager.getConnection(DatabaseConnStr);
   	               Statement stmt = conn.createStatement();

   	               String updateString = "SELECT * from  "+ tableName;
   	               ResultSet rs = stmt.executeQuery(updateString);
   	               while( rs.next() ) {
   						if( 0==acctNumber.compareTo(rs.getString("AccountNumber")) &&
   								 0==cusName.compareTo(rs.getString("Name")) ) {
   							interestRate  = rs.getDouble("InterestRate");
   						}
   	               }
   	               rs.close();
   				   stmt.close();
      			   conn.close();
   	    }
   	    catch(SQLException ex) {
   	          System.err.println("query error: " + ex.getMessage());
   	    }
   	    return interestRate;
   }

   public double retrieveEarnedInterest (String  tableName , String cusName, String acctNumber) {
      	    double interestTotal = 0;
      	    try {
      	               conn = DriverManager.getConnection(DatabaseConnStr);
      	               Statement stmt = conn.createStatement();

      	               String updateString = "SELECT * from  "+ tableName;
      	               ResultSet rs = stmt.executeQuery(updateString);
      	               while( rs.next() ) {
      						if( 0==acctNumber.compareTo(rs.getString("AccountNumber")) &&
      								 0==cusName.compareTo(rs.getString("Name")) ) {
      							interestTotal  = rs.getDouble("AccumulatedInterest");
      						}
      	               }
      	               rs.close();
      				   stmt.close();
         			   conn.close();
      	    }
      	    catch(SQLException ex) {
      	          System.err.println("query error: " + ex.getMessage());
      	    }
      	    return interestTotal;
   }


   //-----------------------------------------------------------------
   //  Write each transaction to TransactionAccount
   //-----------------------------------------------------------------
   public void updateTransDB (String name, String acctNum,
                              String acctType,String transType,
                              double transAmount, String date) {
       try {
			conn = DriverManager.getConnection(DatabaseConnStr);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet uprs = stmt.executeQuery("SELECT * FROM TransactionAccount");

			uprs.moveToInsertRow();
			uprs.updateString("Name", name);
			uprs.updateString("AccountNumber", acctNum);
			uprs.updateString("AcctType",acctType );
			uprs.updateString("TransType", transType);
			uprs.updateDouble("TransAmount", transAmount);
			uprs.updateString("Date", date);
			uprs.insertRow();

			uprs.close();
			stmt.close();
			conn.close();
		} catch(SQLException ex) {
			System.err.println("**SQLException: " + ex.getMessage());
		}
   }
   //-----------------------------------------------------------------
      //  Write each transaction to TransactionAccount
      //-----------------------------------------------------------------
      public void createNewAcct (String name, String acctNum,String acctType,
                                                           double interestRate, double balance, String date) {
		   String DatabaseDriver = "sun.jdbc.odbc.JdbcOdbcDriver";

		   String queryStr="";
		   if(0==acctType.compareTo("Savings Account"))  {
				queryStr = "SELECT * FROM SavingsAccount";
		   }
		   else if(0==acctType.compareTo("Checking Account")) {
				queryStr = "SELECT * FROM CheckingAccount";
		   }
          try {
   			conn = DriverManager.getConnection(DatabaseConnStr);
   			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery(queryStr);

   			uprs.moveToInsertRow();
   			uprs.updateString("Name", name);
   			uprs.updateString("AccountNumber", acctNum);
   			uprs.updateDouble("InterestRate",interestRate );
   			uprs.updateDouble("Balance", balance);
   			uprs.updateString("Date", date);
   			uprs.insertRow();

   			uprs.close();
   			stmt.close();
   			conn.close();
   		} catch(SQLException ex) {
   			System.err.println("**SQLException: " + ex.getMessage());
   		}
   }
    public void executeDeposit (String cusName, String tableName, String acctNumber, double amount,
                                                 double interestRate, double nowInterestTotal, String date) {
   	    try{
			    conn = DriverManager.getConnection(DatabaseConnStr);
   				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
   			    ResultSet rs = stmt.executeQuery("SELECT * FROM " +  tableName);

                while( rs.next() ) {
						if( 0==acctNumber.compareTo(rs.getString("AccountNumber")) &&
								 0==cusName.compareTo(rs.getString("Name")) ) {
   				            rs.updateDouble("InterestRate", interestRate);
   				            rs.updateDouble("AccumulatedInterest", nowInterestTotal);
   				            rs.updateDouble("Balance", amount);
   				            rs.updateString("Date", date);
   				            rs.updateRow();
						}
	             }
   			    rs.close();
				stmt.close();
   			    conn.close();
   		 }
   		 catch(SQLException ex) {
   		   		System.err.println("**SQLException: " + ex.getMessage());
   		 }
   }

   public void executeWithdraw (String  tableName , String cusName, String acctNumber,
                                                   double nowInterestTotal, double amount) {
	    try {
	            conn = DriverManager.getConnection(DatabaseConnStr);
   				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
   			    ResultSet rs = stmt.executeQuery("SELECT * FROM " +  tableName);

                while( rs.next() ) {
						if( 0==acctNumber.compareTo(rs.getString("AccountNumber")) &&
								 0==cusName.compareTo(rs.getString("Name")) ) {
   				            rs.updateDouble("AccumulatedInterest", nowInterestTotal);
   				            rs.updateDouble("Balance", amount);
   				            rs.updateRow();
						}
	             }
   			    rs.close();
				stmt.close();
   			    conn.close();
	    }
	    catch(SQLException ex) {
	               System.err.println("Update error: " + ex.getMessage());
	    }
   }
    // delete data from a Database
    public int executeDelete(String sql)  {
        int num = 0;
        try  {
            conn = DriverManager.getConnection(DatabaseConnStr);
            Statement stmt = conn.createStatement();
            num = stmt.executeUpdate(sql);
        }
        catch(SQLException ex) {
            System.err.println("Deleting error: " + ex.getMessage());
        }
        CloseDataBase();
        return num;
    }

    public void CloseDataBase() {
        try{
            conn.close();
        }
        catch(Exception end){
            System.err.println("Database closing error: " + end.getMessage());
        }
    }

    // To guarantee the account number generated is unique
    // Account number is formed by 10 digits
    public String generateAcctNum(String acctType){
		Random rand = new Random();
	    long acctNum = 0;
	    String acnum="";
		int loopFlag=0;

		while (loopFlag==0){
		    acctNum = rand.nextInt(999999999) + 1000000000;
		    acnum = (new Long(acctNum)).toString();
		    if(isExistingAcctNum(acctType, acnum)==false) {
			   loopFlag=1;
		    }
	    }
		return acnum;
     }
}
