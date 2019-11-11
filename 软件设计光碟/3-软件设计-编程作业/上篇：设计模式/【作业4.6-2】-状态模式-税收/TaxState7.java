/*========================================*/
/* A concrete state in the state pattern  */
/*========================================*/

public class TaxState7 extends TaxState{

   private final static double TAXRATE = 0.35;
   private double taxAmount = 0.0;

   String SINGLE = "Single";
   String FAMILY = "Family";

   public TaxState7(TaxContext context){
   	  super(context);
   	  state = STATE7;
   }

   public double calculateTax(String kind,double amount){
	if(kind.equals(SINGLE))
	   taxAmount = TAXRATE*amount-6375;
    else if (kind.equals(FAMILY))
	   taxAmount = 0.9*(TAXRATE*amount-6375);

	context.saveTaxInfoToDB(taxAmount);
	return  taxAmount;
   }
}