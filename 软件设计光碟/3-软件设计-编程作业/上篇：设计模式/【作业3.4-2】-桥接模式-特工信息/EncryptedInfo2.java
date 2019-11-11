/*-------------------------------------------------*/
/* This is a subclass to implement interface       */
/* Encryption.                                     */
/* a) This class keeps a reference logger of       */
/*    MessageWriter.                               */
/* b) This logger is used to call logMsg in        */
/*    class MessageLogger                          */
/* c) The object is created from the Client        */
/*    file, like, logger = new FileLogger();       */
/*    Then logger is passed into THIS class        */
/*    TextMessage by                               */
/*    Message msg = new EncryptedMessage(logger);  */
/*-------------------------------------------------*/


import java.util.*;

public class EncryptedInfo2 implements AgentInfo {

  private MessageWriter writer;
  private char[] chars;
  private int length;
  private int len;

  public EncryptedInfo2(MessageWriter w) {
    writer = w;
  }
  public void log(String lastNm, String firstNm, String code){
     String lName = encryptName(lastNm);
     String fName = encryptName(firstNm);
     String codeStr = encryptCode(code);

     writer.logMsg(lName, fName, codeStr);
  }

  public String encryptName(String inputStr){
     chars = inputStr.toCharArray();

     length = chars.length;
     len = chars.length/2;

     for (int i = 0; i < len; i++)
     {
	    if( Character.isLowerCase(chars[2*i])==true )
	    {
			shiftEvenChar(i);
		}
		if( Character.isLowerCase(chars[2*i+1])==true )
		{
		  	shiftOddChar(i);
		}

		if( Character.isUpperCase(chars[2*i]) == true)
		{
			chars[2*i] = Character.toLowerCase(chars[2*i]);
		  	shiftEvenChar(i);
		  	chars[2*i] = Character.toUpperCase(chars[2*i]);
		}
		if( Character.isUpperCase(chars[2*i+1]) == true)
		{
		   chars[2*i+1] = Character.toLowerCase(chars[2*i+1]);
		   shiftOddChar(i);
		   chars[2*i+1] = Character.toUpperCase(chars[2*i+1]);
		}
     }

	 shiftEndChar();
     System.out.println(new String(chars));
     return new String(chars);
  }

   public String encryptCode (String code) {
      char[] digitArr = getDigitArray();
	  char[] codeChars = code.toCharArray();
	  char[] alphabet = getAlphabetArray();

	  if(codeChars.length != 12){
	     System.out.println("Incorrect code length.");
	  }
	  else{
	     for (int m = 0; m < codeChars.length; m++){
		    for(int n = 0; n < 26; n++){
	           if ( codeChars[m] == alphabet[n]){
	              codeChars[m] = alphabet[25-n];
	        	  break;
	           }
	           else if ( codeChars[m] == Character.toUpperCase(alphabet[n]) ){
			      codeChars[m] = Character.toUpperCase(alphabet[25-n]);
				  break;
	           }
	        }

            for(int j = 0; j < 10; j++){
	           if ( codeChars[m] == digitArr[j]){
	              codeChars[m] = digitArr[9-j];
	        	  break;
	           }
	        }
	     }
	   }
       System.out.println(new String(codeChars));
	   return new String(codeChars);
   }

  private char[] getAlphabetArray(){
	   String str = "abcdefghijklmnopqrstuvwxyz";
	   char[] chArray = str.toCharArray();
	   return chArray;
  }
  private char[] getDigitArray(){
  	   String str = "0123456789";
  	   char[] chArray = str.toCharArray();
  	   return chArray;
  }

  private void shiftEvenChar(int m){
     char charEven = chars[2*m];

     if (charEven == 'z') {
        charEven = 'a';
     }
     else if ((charEven >= 'a') && (charEven < 'z')){
        ++charEven;
     }
     chars[2*m] = charEven;
  }

  private void shiftOddChar(int m){
     char charOdd = chars[2*m+1];

     if (charOdd == 'a') {
  	    charOdd = 'z';
  	 }
     else if ((charOdd > 'a') && (charOdd <= 'z')) {
  		--charOdd;
  	 }
     chars[2*m+1] = charOdd;
  }

  private void shiftEndChar(){
     if(2*len+1 == length){
	    char end = chars[length-1];

	   	if (end == 'z'){
	   	     end = 'a';
	   	}
	   	if (end == 'Z'){
		  	 end = 'A';
	   	}
	   	if ((end >= 'a') && (end < 'z')){
	       ++end;
	   	}
	   	if ((end >= 'A') && (end < 'Z')){
		   ++end;
	   	}
	   	chars[length-1] = end;
     }
   }
}
