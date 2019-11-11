//-------------------------------------------------------------------------------
// This is the PoliticalIssue class  that inherits FileUpdateInterface
// The legacy file update system is designed by using
// traditional Object-oriented design
//-------------------------------------------------------------------------------


import java.util.ArrayList;

public class PoliticalIssue implements FileUpdateInterface {
   private ArrayList<String> inFile;

   public PoliticalIssue(ArrayList<String> inFile)  {
	  this.inFile = inFile;
   }
   // Input an ArrayList named inFile from constructor, and fix all
   // the political errors, namely, change "Republic of China" into
   // "Taiwan" and return the corrected ArrayList to the caller
   public ArrayList<String>  update(){
	   for(int m=0; m<inFile.size(); m++ ){
	       String line = inFile.get(m);
	       String[] words = line.split("\\s");
	       replacePoliticalWord(words);
	       String strLine = makeAStringLine(words );
	       inFile.remove(m);
	       inFile.add(m, strLine);
	   }
	   return inFile;
   }
  // find Political Words In A Line And Replace Them With Correct One
   private void replacePoliticalWord(String[] strArr){
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
   private String makeAStringLine(String[] aLine ) {
      int len = aLine.length;
      String poliStr = "";
      for(int m=0; m<len; m++){
		 if(aLine[m] != ""){
		    poliStr = poliStr + " " + aLine[m];
	     }
	  }
      poliStr += "\n";
      return poliStr;
   }
}
