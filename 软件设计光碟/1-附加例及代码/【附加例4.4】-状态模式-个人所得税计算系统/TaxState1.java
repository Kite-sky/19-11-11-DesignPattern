

/*========================================*/
/* A concrete state in the state pattern  */
/*========================================*/

public class TaxState1 extends TaxState{

   private final static double TAXRATE = 0.05;
   private double taxAmount = 0.0;

   String SINGLE = "Single";
   String FAMILY = "Family";

   public TaxState1(TaxContext context){
	  super(context);
	  state = STATE1;
   }

   public double calculateTax(String kind, double amount){
	  if(kind.equals(SINGLE))
	     taxAmount = TAXRATE*amount;
	  else if (kind.equals(FAMILY))
	     taxAmount = 0.9*TAXRATE*amount;

	  context.saveTaxInfoToDB(taxAmount);
	  return  taxAmount;
   }
}

