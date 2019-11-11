//-------------------------------------------------------------------------------
// This is the Sorting class  that inherits FileUpdateInterface
// The legacy file update system is designed by using
// traditional Object-oriented design
//-------------------------------------------------------------------------------



import java.util.ArrayList;
import java.util.Arrays;

public class Sorting implements FileUpdateInterface {
   private ArrayList inFile = null;

   public Sorting(ArrayList<String> inFile){
  	  this.inFile = inFile;
   }
   // Input an arrayList from the constructor, and sort the
   // data lines alphabetically, and then return the sorted arrayList
   public ArrayList<String>  update(){
	     Object[] sortedLines = sort(inFile);
	     for(int j=0; j < inFile.size(); j++){
			 inFile.remove(j);
			 inFile.add(j, (String)sortedLines[j]) ;
		 }
      return inFile;
   }

 private Object[] sort(ArrayList<String> lines){
      Object[] strArray = lines.toArray();
      Arrays.sort(strArray);
      return strArray;
   }
}