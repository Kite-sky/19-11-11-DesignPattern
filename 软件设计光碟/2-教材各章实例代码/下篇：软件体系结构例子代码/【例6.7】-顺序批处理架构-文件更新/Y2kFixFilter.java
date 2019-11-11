
import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Y2kFixFilter implements BatchSeqFilter {
   private JTextArea resultTxt;
   private BufferedReader input = null;
   private BufferedWriter output = null;

   public Y2kFixFilter(String inFile, String outFile, JTextArea resultTxtA)throws IOException{
      input = new BufferedReader(new FileReader(inFile));
	  output = new BufferedWriter(new FileWriter(outFile));
	  resultTxt=resultTxtA;
   }

   /*-------------------------------------------*/
   /* Read from the input pipe, fix Y2k problem,*/
   /* e.g, change 96-12-09 into 1996-12-09      */
   /* and then write as chars into outpipe      */
   /*-------------------------------------------*/
   public void processData(){
      try{
         String line = input.readLine();
         while(line != null){ //not end of file
            String[] words = line.split("\\s");
            words = fixY2kInALine(words);
		    writeALineToFile(words);
            line = input.readLine();
         }

         if (input != null){
		    input.close();
		 }
		 if (output != null){
		    output.close();
         }
      }
      catch(IOException exc){
         exc.printStackTrace();
         System.err.println("Error: failed to make y2k update");
         System.exit(1);
      }
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

   private void  writeALineToFile(String[] aLine) throws java.io.IOException{
      int len = aLine.length;
      String y2kStr = "";

      for(int m=0; m<len; m++){
  	     y2kStr = y2kStr + " " + aLine[m];

  	  }
      y2kStr += "\n";
      resultTxt.append(""+y2kStr);
      System.out.println("line = "+ y2kStr);

      output.write(y2kStr);
   }
}


