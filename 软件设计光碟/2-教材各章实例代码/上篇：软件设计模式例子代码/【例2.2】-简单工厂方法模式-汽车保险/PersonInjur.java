


public class PersonInjur implements AutoInsurance{
   private String description;

   public String getInsurInfo(){
	  description = "Personal Injury Protection \n\nPays medical expenses and some percentage"+
	                "of lost wages to you or anyone authorized"+
	                "to drive your car, no matter who caused the accident.";
	  return description;
   }
}
