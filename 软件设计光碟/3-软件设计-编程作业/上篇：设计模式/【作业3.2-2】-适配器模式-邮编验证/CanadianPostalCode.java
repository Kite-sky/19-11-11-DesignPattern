

public class CanadianPostalCode {

	private boolean digitFlag = true;
	private boolean characterFlag = true;


    /*=======================================================*/
    /* Canadian postal code has the form CDC DCD, where      */
    /* C is an English character and D is any digit from     */
    /* 0 to 9. A space is required after the 3rd character,  */
    /* but this is not checked in this program. And any      */
    /* number of spaces is allowed in the user input postal  */
    /* code.                                                 */
    /*=======================================================*/
	public boolean isValidCanadianPcode(String postalCode, String province) {

       char[] pCode = toNonBlankCharArray(postalCode);

       if (pCode.length != 6)
          return false;

       for(int i=0; i<pCode.length/2; i++){
		  if( Character.isLetter(pCode[2*i]) == false)
		     characterFlag = false;
          if(Character.isDigit(pCode[2*i+1]) == false)
             digitFlag = false;
	   }

	   if ( (digitFlag == false) || (characterFlag==false))
	      return false;
	   else
	      return true;
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
}


