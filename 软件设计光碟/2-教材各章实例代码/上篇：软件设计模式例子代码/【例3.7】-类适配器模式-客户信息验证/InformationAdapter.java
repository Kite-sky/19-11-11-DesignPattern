
/*---------------------------------------------------------*/
/* This adapter class extends InfoValidation and           */
/* implements CusInfoValidator, and so the first           */
/* 4 functionalities listed in class CusInfoValidator      */
/* are automatically inherited from class InfoValidation,  */
/* and in this addapter class, isValidSSNNum(String SSNNum)*/
/* is emplemented.                                         */
/*---------------------------------------------------------*/


class InformationAdapter extends InfoValidation implements CusInfoValidator{

    /*------------------------------------------*/
	/* The Social Security number is a 9-digit  */
	/* number in the format "AAA-GG-SSSS".      */
	/*------------------------------------------*/
	public boolean isValidSSNNum(String SSNNum){
	   boolean isValid=true;
       String ns = SSNNum.trim();
	   String nStr = ns.replaceAll("\\s{1,}", "");
	   int len = nStr.length();

	   if ( (nStr.charAt(3) == '-') && (nStr.charAt(6) == '-') && (len==11) ) {
	      for(int m=0; m<len; m++){
		     if(  (m != 3) && (m !=6) && ( Character.isDigit(nStr.charAt(m))==false) ){
		        isValid=false;
		     }
	      }
	      return isValid;
	   }
	   else{
		  return false;
	   }
	}
}


