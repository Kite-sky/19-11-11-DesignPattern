
import java.io.IOException;
import java.io.CharArrayWriter;
import java.lang.Character;


public class Y2kFixFilter extends Filter
{
   public Y2kFixFilter(Pipe input, Pipe output){
      super(input, output);
   }

   /*-------------------------------------------*/
   /* Read from the input pipe, fix Y2k problem,*/
   /* e.g, change 96-12-09 into 1996-12-09      */
   /* and then write as chars into outpipe      */
   /*-------------------------------------------*/
   protected void processData(){
      try{
         CharArrayWriter writer = new CharArrayWriter();
         int c = inPipe.read();

         while(c != -1){ //not end of file
            if(((char) c) == '\n'){ //got a complete line
               String[] words = getALine(writer);
               words = fixY2kInALine(words);
		       writeALineOfCharsToDownStream(words);
               writer.reset();
            }
            else{
               writer.write(c);
		    }
            c = inPipe.read();
         }
         outPipe.closePipedOutputStream();
         inPipe.closePipedInputStream();
      }
      catch(IOException exc){
         exc.printStackTrace();
         System.err.println("Error: failed to make y2k update");
         System.exit(1);
      }
   }

   private String[] getALine(CharArrayWriter writer){
      String line = writer.toString();
      String[] words = line.split("\\s");
      for(int m=0;m<words.length;m++)
      System.out.println("Line = "+ words[m]);

      return words;
   }

   private String[] fixY2kInALine(String[] words){
      for(int k=0; k< words.length; k++){  //One line
   	     if(words[k].length()==8)
   	        words[k] = fixY2kInAWord(words[k]);
	  }
	  return words;
   }

   private String fixY2kInAWord(String oneWord){
	  char[] wdArray = oneWord.toCharArray();
      char[] wdArray2= new char[10];
      String word = null;

	  if((Character.isDigit(wdArray[0])) &&
		 (Character.isDigit(wdArray[1])) &&
		 (wdArray[2] == '-')             &&
		 (Character.isDigit(wdArray[3])) &&
		 (Character.isDigit(wdArray[4])) &&
		 (wdArray[5] == '-')             &&
		 (Character.isDigit(wdArray[6])) &&
		 (Character.isDigit(wdArray[7]))
	   ){
	       wdArray2[0] = '1';
		   wdArray2[1] = '9';
		   wdArray2[2] = wdArray[0];
		   wdArray2[3] = wdArray[1];
		   wdArray2[4] = '-';
		   wdArray2[5] = wdArray[3];
		   wdArray2[6] = wdArray[4];
		   wdArray2[7] = '-';
		   wdArray2[8] = wdArray[6];
		   wdArray2[9] = wdArray[7];
		   word = new String(wdArray2);
		}
		else{
		   word = oneWord;
		}
	    return word;
   }

   private void writeALineOfCharsToDownStream(String[] aLine) throws java.io.IOException{
      int len = aLine.length;
      String y2kStr = "";

      for(int m=0; m<len; m++){
  	     y2kStr = y2kStr + " " + aLine[m];
  	  }
      y2kStr += '\n';

      char[] chars = y2kStr.toCharArray();

      for(int j = 0; j < chars.length; j++){
         outPipe.write(chars[j]);
      }
   }
}


