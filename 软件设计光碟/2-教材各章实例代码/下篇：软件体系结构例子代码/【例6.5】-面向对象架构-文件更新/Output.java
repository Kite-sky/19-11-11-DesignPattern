//-------------------------------------------------------------------------------
// This is the Output class  that inherits FileUpdateInterface
// The legacy file update system is designed by using
// traditional Object-oriented design
//-------------------------------------------------------------------------------


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output implements FileUpdateInterface{
   private BufferedWriter outputStream = null;
   private ArrayList inFile = null;

   public Output(ArrayList<String> inFile, String outFile) throws IOException{
      outputStream = new BufferedWriter(new FileWriter(outFile));
      this.inFile=inFile;
   }

 // Input an arrayList from the constructor, and write its contents to
 // an output file and finally return the input file to the caller
   public ArrayList<String>  update(){
      try{
	     for(int k = 0; k < inFile.size(); k++){
			 outputStream.write(inFile.get(k)+" \n");
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
      return inFile;
    }
}