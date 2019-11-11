
/*========================================================*/
/* This is the Context class in the State pattern. This   */
/* class together with the state class hierarchy are      */
/* so organized that the TaxContext uses the state class  */
/* hierarchy and the state class hierarchy will also call */
/* the Context class TaxContext.                          */
/*========================================================*/

public class TaxContext {

  private TaxState objState;
  private String accountNumber;
  private double taxAmount;
  private String state;
  private String name;
  private String taxType;
  private double taxable;

  public TaxContext(String name, String taxType, double taxable){
     this.name = name;
     this.taxType = taxType;
     this.taxable =taxable;
     objState = new TaxState1(this);
  }

  public String getState() {
	state = objState.getState();
    return state;
  }
  public double getTax() {
    objState.changeState(taxable);
	objState = objState.getStateObj();
    taxAmount = objState.calculateTax(taxType, taxable);

    return taxAmount;
  }

  public void putTaxInfoToDB(String name, String taxType, double taxable, double taxPaid){
	 System.out.println("The following tax information has been saved to DB\n"+
	                    "\n Name: " + name +
	                    "\n Tax Type: " + taxType +
	                    "\n Taxable amount: " + taxable +
	                    "\n Tax Paid: " + taxPaid);
  }
  public void saveTaxInfoToDB(double taxPaid){
	 putTaxInfoToDB(name, taxType, taxable, taxPaid);
  }

}
