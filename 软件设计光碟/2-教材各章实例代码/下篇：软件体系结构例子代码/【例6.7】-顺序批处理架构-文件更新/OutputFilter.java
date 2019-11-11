
import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class OutputFilter implements BatchSeqFilter{
   private BufferedReader inputStream = null;
   private BufferedWriter outputStream = null;
   private JTextArea resultTxt;

   public OutputFilter(String inFile, String outFile, JTextArea resultTxtA)throws IOException{
      inputStream = new BufferedReader(new FileReader(inFile));
      outputStream = new BufferedWriter(new FileWriter(outFile));
      resultTxt = resultTxtA;
   }

   /*-----------------------------------------------*/
   /* This method reads and parses an input file.   */
   /* The parsed data is written to the output pipe.*/
   /*-----------------------------------------------*/
   public void processData(){
      try{
	     String line = inputStream.readLine();
	     while (line != null) {
	        outputStream.write(line+" \n");
	        resultTxt.append(""+line + "\n");
	        line = inputStream.readLine();
	     }

         if (inputStream != null) {
	        inputStream.close();
	     }
	     if (outputStream != null) {
	        outputStream.close();
	     }
	  }
	  catch(IOException exc){
	     exc.printStackTrace();
	  	 System.err.println("Error: failed to make y2k update");
	  	 System.exit(1);
      }
    }
}