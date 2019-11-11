


class InfoValidation {

   /*----------------------------------------------------*/
   /* The name should be at least one character long     */
   /* and digital numbers should not appear in the names */
   /*----------------------------------------------------*/
   public boolean isValidName(String name){
	   boolean isValid=true;
	   String ns = name.trim();
	   String nStr = ns.replaceAll("\\b\\s{1,}\\b", "");
	   int len = nStr.length();

	   System.out.println("******Length = " + len);

	   if(len != 0 ){
	      for(int m=0; m<len; m++){
	         if(Character.isDigit(nStr.charAt(m))==true)
	            isValid=false;
	      }
	      return isValid;
       }
       else{
	      return false;
	   }
   }
   /*----------------------------------------------------*/
   /* The address should be at least 10 character long   */
   /*----------------------------------------------------*/
   public boolean isValidAddress(String address){

	   char[] ca = address.trim().toCharArray();
	   int aLen = ca.length;

       if ( aLen < 10 ){
          return false;
	   }
       else{
	      return true;
	   }
   }
   /*-------------------------------------------------------*/
   /* The zip code should contain exactly 9 digital integer */
   /* numbers. Only digital numbers are allowed in the zip  */
   /* code. Spaces are allowed in the zip code              */
   /*-------------------------------------------------------*/
   public boolean isValidZipCode(String zipCode){

       boolean isValid=true;
	   String ns = zipCode.trim();
	   String nStr = ns.replaceAll("\\b\\s{1,}\\b", "");
	   int len = nStr.length();

	  if (len == 9){
	     for(int n=0; n<len; n++){
		    if(Character.isDigit(nStr.charAt(n))==false){
	           isValid = false;
	        }
         }
         return isValid;
	  }
      else{
		 System.out.println("Length is not 9");
	     return false;
	   }
   }

   /*--------------------------------------------------------*/
   /* The cellPhone number should contain exactly 11 digital */
   /* integer numbers. Only digital numbers are allowed in   */
   /* the zip code.Spaces are allowed in the zip code        */
   /*--------------------------------------------------------*/
   public boolean isValidCellPhoneNum(String phoneNum){

       boolean isValid=true;
	   String ns = phoneNum.trim();

	   String nStr = ns.replaceAll("\\b\\s{1,}\\b", "");
	   int len = nStr.length();

   	  if (len == 11 ){
   	     for(int n=0; n<len; n++){
			if(Character.isDigit(nStr.charAt(n))==false){
   	            isValid = false;
   	        }
		 }
   	     return isValid;
      }
      else{
		  System.out.println("Length is not 11");
   	      return false;
   	  }
   }
}// end of class
