//-------------------------------------------------------------------------------
// This is the Iuput class  that inherits FileUpdateInterface
// The legacy file update system is designed by using
// traditional Object-oriented design
//-------------------------------------------------------------------------------

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input implements FileUpdateInterface{
   private BufferedReader inputStream = null;
   private ArrayList txtLines;
   private String inFile;

   public Input(String inFile) throws IOException{
	  this.inFile = inFile;
      inputStream = new BufferedReader(new FileReader(inFile));
      txtLines = new ArrayList<String>();
   }
   // This method simply reads input file line by line,  and
   // write each line read to the an arraylist, which will be
   // returned to the caller
   public ArrayList<String>  update(){
       try{
	     String line = inputStream.readLine();
	     txtLines.add(line);

	      while (line != null) {
			  txtLines.add(line+"\n");
			  line = inputStream.readLine();
		  }
		  if (inputStream != null) {
	         inputStream.close();
	      }
	   }
	   catch(IOException exc){
	      exc.printStackTrace();
	  	  System.err.println("Error: failed input.");
	  	  System.exit(1);
       }
       return txtLines;
    }
}