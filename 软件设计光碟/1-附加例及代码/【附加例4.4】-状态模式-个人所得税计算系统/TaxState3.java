/*========================================*/
/* A concrete state in the state pattern  */
/*========================================*/

public class TaxState3 extends TaxState{

   private final static double TAXRATE = 0.15;
   private static double taxAmount = 0.0;

   String SINGLE = "Single";
   String FAMILY = "Family";

   public TaxState3(TaxContext context){
   	  super(context);
   	  state = STATE3;
   }
   public double calculateTax(String kind, double amount){
	  if(kind.equals(SINGLE))
	     taxAmount = TAXRATE*amount-125;
	  else if (kind.equals(FAMILY))
	     taxAmount = 0.9*(TAXRATE*amount-125);

      context.saveTaxInfoToDB(taxAmount);
	  return  taxAmount;
   }
}