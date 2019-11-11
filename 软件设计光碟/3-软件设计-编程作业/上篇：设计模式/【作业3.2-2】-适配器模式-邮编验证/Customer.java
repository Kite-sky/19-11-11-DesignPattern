

public class Customer {
   public static final String US = "US";
   public static final String CANADA = "Canada";
   public static final String CHINA = "China";

   private String country, state,zip;

   public boolean isValidZip() {

      if (country.equals(Customer.US)) {
         USAZipCode us = new USAZipCode();

         return us.isValidZipCode(zip, state);
      }
      if (country.equals(Customer.CANADA)) {
         CanadianPostalCode objCAPCode = new CanadianPostalCode();
         ZipCodeValidator adapter = new CAPostalCodeAdapter(objCAPCode);

         return adapter.isValidZipCode(zip, state);
      }
      //if (country.equals(Customer.CHINA)){
      //}
      else
    	 return false;
   }

   public Customer( String inp_zip, String inp_state, String inp_country) {
      zip = inp_zip;
      state = inp_state;
      country = inp_country;
   }
}// end of class


