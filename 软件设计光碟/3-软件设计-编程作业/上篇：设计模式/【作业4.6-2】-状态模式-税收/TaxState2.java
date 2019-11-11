/*========================================*/
/* A concrete state in the state pattern  */
/*========================================*/

public class TaxState2 extends TaxState{

   private final static double TAXRATE = 0.1;
   private double taxAmount = 0.0;

   String SINGLE = "Single";
   String FAMILY = "Family";

   public TaxState2(TaxContext context){
   	  super(context);
   	  state = STATE2;
   }

   public double calculateTax(String kind, double amount){
	   if(kind.equals(SINGLE))
	   	  taxAmount = TAXRATE*amount-25;
	   else if (kind.equals(FAMILY))
	   	  taxAmount = 0.9*(TAXRATE*amount-25);

	   context.saveTaxInfoToDB(taxAmount);
	   return  taxAmount;
   }
}