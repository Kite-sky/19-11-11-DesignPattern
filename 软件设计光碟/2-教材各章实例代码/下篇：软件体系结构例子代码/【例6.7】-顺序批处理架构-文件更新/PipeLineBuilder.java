import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.IOException;


public class PipeLineBuilder{
   private BatchSeqFilter[] filter ={null, null, null};
   //private Pipe[] p = new Pipe[6];
   private ArrayList ftrs;
   private JTextArea filterInfoTxt;
   private JTextArea[] txtInfo = new JTextArea[4];
   private static final String TEXTFILES = "TextFiles/";
   private static final String UPDATEDFILES = "UpdatedFiles/";

   public PipeLineBuilder(ArrayList ftrStr, JTextArea[] txt, JTextArea infoTxt) throws IOException{
	  txtInfo = txt;
	  ftrs = ftrStr;
	  filterInfoTxt = infoTxt;
   }

   public void buildAndRunPipeFilters(String inFile) throws IOException{

      String originFileNM = TEXTFILES + inFile;
      String updatedFileNM = UPDATEDFILES+"Updated_"+inFile;

      int len = ftrs.size();
      if(len == 0){
	     filterInfoTxt.append("You need to select at least 1 filter");
	     return;
	  }

      String[] mf = new  String[len+1];        //{null, null, null, null}; //some mid processed files

      for(int k=0; k<len+1; k++){
         mf[k] = UPDATEDFILES + "Mid_"+ k + inFile;
      }


      try{
        Iterator etr = ftrs.iterator();

	    BatchSeqFilter input = new InputFilter(originFileNM, mf[0], txtInfo[0]);

	    for(int i=0; i<len; i++){
	       if(etr.hasNext()){
	          String s = (String) etr.next();
	          String des = getFilterDescription(s);
	          showFilterInfo(filterInfoTxt, des);

	          if(s.compareTo("PoliticalFilter")==0)
	             filter[i] = new PoliticalFilter(mf[i], mf[i+1], txtInfo[i+1]);
	          else if(s.compareTo("Y2KFilter")==0)
	             filter[i] = new Y2kFixFilter(mf[i], mf[i+1], txtInfo[i+1] );
	          else if(s.compareTo("SortFilter")==0)
	             filter[i] = new SortingFilter(mf[i], mf[i+1], txtInfo[i+1] );
	       }
	    }

        BatchSeqFilter output = new OutputFilter(mf[len], updatedFileNM,txtInfo[len+1]);

        //Start all the filter threads
        input.processData();
        for(int i=0;i<len;i++){
	       filter[i].processData();
	    }
	    output.processData();
      }
      catch(IOException exc) {
         exc.printStackTrace();
      }
   }

   /*=============================================*/
   /* Display filter information to text area     */
   /*=============================================*/
   public void showFilterInfo(JTextArea filterInfoTxt, String filterInfo ){
      filterInfoTxt.append(filterInfo);
   }

   public String getFilterDescription(String filtor ){
   	  String filterDesc = null;

      if ( filtor.compareTo("PoliticalFilter")==0 ) {
         filterDesc = "PoliticalFilter: do PoliticalFilter Filtering...\n";
      }
      else if ( filtor.compareTo("Y2KFilter")==0 ) {
         filterDesc = "Y2KFilter: do Y2kFixFilter Filtering...\n";
      }
      else if ( filtor.compareTo("SortFilter")==0 ) {
	     filterDesc = "SortFilter: do SortingFilter Filtering...\n";
      }

   	  return filterDesc;
  }
}
