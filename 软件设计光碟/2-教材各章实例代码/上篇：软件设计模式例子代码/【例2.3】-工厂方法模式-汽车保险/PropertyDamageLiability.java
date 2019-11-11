





public class PropertyDamageLiability implements AutoInsurance
{
   private String description;

   public String getInsuranceDescription()
   {
	   description = "Property Damage Liability: \n\nThis coverage pays for the repair and"+
	                 "replacement of vehicles and other "+
	                 "property damaged when you or another"+
	                 "authorized driver causes an accident.";
	   return description;
   }
}
