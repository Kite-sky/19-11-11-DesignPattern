

public class USAZipCode implements ZipCodeValidator {

	private boolean digitFlag = true;
	private String zip;
	private int zipLength = 0;
	private final int ZIPLEN = 10;
	private final int HYPHEN_POSITION = 5;


	/*=================================================*/
    /* US zip code has the form ddddd-dddd, where d    */
	/* is any digit from 0 to 9. A hyphen is required  */
	/* after the 5th digit. Some spaces are allowed in */
	/* the zip code.                                   */
	/*=================================================*/
	public boolean isValidZipCode(String zip,String state) {

		char[] zp = toNonBlankCharArray(zip);

		if(zp.length != 10)
		   return false;

		if(zp[HYPHEN_POSITION] != '-')
		   return false;

		for(int i=0; i<HYPHEN_POSITION; i++){
		   if( Character.isDigit(zp[i]) == false){
		       digitFlag = false;
		   }
	    }

		for(int i=HYPHEN_POSITION+1; i< ZIPLEN; i++){
		   if( Character.isDigit(zp[i]) == false){
			   digitFlag = false;
		   }
	    }
	    return digitFlag;
   }

    /*====================================================*/
    /* Get rid of all the spaces from the user input      */
    /*====================================================*/
      public char[] toNonBlankCharArray(String postalCode){
         int m=0;

         for (int k=0;k<postalCode.length(); k++){
   		 if (Character.isSpaceChar(postalCode.charAt(k)) == false ){
   		    m++;
   		 }
   	  }

   	  char[] p = new char[m];

   	  int n = 0;
   	  for (int k=0;k<postalCode.length(); k++){
   	     if (Character.isSpaceChar(postalCode.charAt(k)) == false ){
   	  	    p[n] =  postalCode.charAt(k);
   	  	    n++;
   	  	 }
   	  }
   	  return p;
   }
}// end of class

