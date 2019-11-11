
import java.io.IOException;
import javax.swing.*;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;


public class OutputFilter extends Filter
{
   private JTextArea resultTextArea;
   //String file = "NewFiles/UpdatedFile.txt";
   String inputFileNM;

   public OutputFilter(Pipe input, JTextArea resultTxtA, String inFile) {
      super(input, null);
      resultTextArea = resultTxtA;
      inputFileNM = inFile;
   }

   /*--------------------------------------------------*/
   /* Read chars from the input pipe, and then write   */
   /* the resultant data into a file and console       */
   /*--------------------------------------------------*/
   protected void processData() {
      resultTextArea.append("\n");
      try {
		 String file = "UpdatedFiles/"+ "New" + inputFileNM;
	     readCharsFromUpperStreamAndWriteToFileAndOutputToConsol(file);
      }
      catch(IOException exc){
         exc.printStackTrace();
         System.err.println("Output Error");
         System.exit(1);
      }
   }//end transform method

   private void readCharsFromUpperStreamAndWriteToFileAndOutputToConsol(String file) throws IOException
   {
      CharArrayWriter writer = new CharArrayWriter();

	  PrintWriter prWriter
			     = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));

      int c = inPipe.read();
	  while(c != -1){
	     writer.write(c);

		 if(((char) c) == '\n'){ // got a complete line
		    String line = writer.toString();
		    prWriter.println(line);
			writer.reset(); //clear the writer
		 }
		 resultTextArea.append(""+(char)c);
		 c = inPipe.read();
	  }
	  resultTextArea.append("\n");
	  prWriter.close();
      inPipe.closePipedInputStream();
   }
}
