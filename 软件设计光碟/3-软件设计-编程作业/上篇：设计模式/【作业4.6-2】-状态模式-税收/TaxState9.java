
/*========================================*/
/* A concrete state in the state pattern  */
/*========================================*/

public class TaxState9 extends TaxState{

   private final static double TAXRATE = 0.45;
   private double taxAmount = 0.0;

   String SINGLE = "Single";
   String FAMILY = "Family";

   public TaxState9(TaxContext context){
   	  super(context);
   	  state = STATE9;
   }

   public double calculateTax(String kind,double amount){
	if(kind.equals(SINGLE))
	   taxAmount = TAXRATE*amount-15375;
	else if (kind.equals(FAMILY))
	   taxAmount = 0.9*(TAXRATE*amount-15375);

	context.saveTaxInfoToDB(taxAmount);
	return  taxAmount;
   }
}