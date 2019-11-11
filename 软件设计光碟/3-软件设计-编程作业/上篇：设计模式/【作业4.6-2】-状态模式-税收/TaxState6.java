/*========================================*/
/* A concrete state in the state pattern  */
/*========================================*/

public class TaxState6 extends TaxState{

   private final static double TAXRATE = 0.3;
   private double taxAmount = 0.0;

   String SINGLE = "Single";
   String FAMILY = "Family";

   public TaxState6(TaxContext context){
   	  super(context);
   	  state = STATE6;
   }
   public double calculateTax(String kind,double amount){
	  if(kind.equals(SINGLE))
		 taxAmount = TAXRATE*amount-3375;
	  else if (kind.equals(FAMILY))
		 taxAmount = 0.9*(TAXRATE*amount-3375);

      context.saveTaxInfoToDB(taxAmount);
	  return  taxAmount;
   }
}