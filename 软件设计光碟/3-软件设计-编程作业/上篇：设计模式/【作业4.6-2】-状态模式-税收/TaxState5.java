/*========================================*/
/* A concrete state in the state pattern  */
/*========================================*/

public class TaxState5 extends TaxState{

   private final static double TAXRATE = 0.25;
   private double taxAmount = 0.0;

   String SINGLE = "Single";
   String FAMILY = "Family";

   public TaxState5(TaxContext context){
   	  super(context);
   	  state = STATE5;
   }

   public double calculateTax(String kind,double amount){
	 if(kind.equals(SINGLE))
		taxAmount = TAXRATE*amount-1375;
     else if (kind.equals(FAMILY))
		taxAmount = 0.9*(TAXRATE*amount-1375);

     context.saveTaxInfoToDB(taxAmount);
	 return  taxAmount;
   }
}