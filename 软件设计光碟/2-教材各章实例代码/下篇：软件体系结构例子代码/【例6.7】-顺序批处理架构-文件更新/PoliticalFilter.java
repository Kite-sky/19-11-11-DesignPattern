
import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PoliticalFilter implements BatchSeqFilter {
   private JTextArea resultTxt;
   private BufferedReader input = null;
   private BufferedWriter output = null;

   public PoliticalFilter(String inFile, String outFile, JTextArea resultTxtA)throws IOException{
      input = new BufferedReader(new FileReader(inFile));
	  output = new BufferedWriter(new FileWriter(outFile));
      resultTxt=resultTxtA;
   }

   /*--------------------------------------------------*/
   /* Read from the inFile, and fix all the political  */
   /* isues, namely, change "Republic of China" into   */
   /* "Taiwan" and write to outFile                    */
   /*--------------------------------------------------*/
   public void processData(){
      try{
         String line = input.readLine();
	     while ( line != null){ //not end of file
	        String[] words = line.split("\\s");
	        findPoliticalWordsInALineAndReplaceThemWithCorrectOne(words);

	        writeALineToFile(words);
	        line = input.readLine();
	     }

	     if (input != null){
		    input.close();
		 }
		 if (output != null) {
		    output.close();
         }
      }
      catch(IOException exc){
         exc.printStackTrace();
         System.err.println("Error: failed to deal with political issues.");
         System.exit(1);
      }
   }

   private void findPoliticalWordsInALineAndReplaceThemWithCorrectOne(String[] strArr){
     for(int k=0; k< strArr.length; k++){
	    if((strArr[k].compareToIgnoreCase("Republic")==0)   &&
		   (strArr[k+1].compareToIgnoreCase("of")==0) &&
		   (strArr[k+2].compareToIgnoreCase("China")==0)){
		   strArr[k] = "Taiwan";
		   strArr[k+1] = "";
		   strArr[k+2] = "";
	    }
	 }
   }

   private void writeALineToFile(String[] aLine ) throws IOException{
      int len = aLine.length;
      String poliStr = "";

      for(int m=0; m<len; m++){
		 if(aLine[m] != ""){
		    poliStr = poliStr + " " + aLine[m];
	     }
	  }
      poliStr += "\n";
      resultTxt.append(""+poliStr);

      output.write(poliStr);
   }
}
