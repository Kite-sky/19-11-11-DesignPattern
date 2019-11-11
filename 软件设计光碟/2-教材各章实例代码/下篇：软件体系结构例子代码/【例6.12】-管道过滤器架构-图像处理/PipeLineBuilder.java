import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.IOException;


public class PipeLineBuilder{
   private Filter[] filter ={null, null, null};
   private JLabel[] imLabel;
   private Pipe[] p;
   private ArrayList ftrs;
   private JTextArea filterInfoTxt;
   private static final String IMAGES = "Images/";
   private static final String PROCIMAGES = "ProcessedImages/";

   public PipeLineBuilder(ArrayList ftrStr, JLabel[] imLbl, JTextArea infoTxt) throws IOException{
	  imLabel= imLbl;
	  ftrs = ftrStr;
	  filterInfoTxt = infoTxt;
   }

   public void buildAndRunPipeFilters(String inFile) throws IOException{

      String originImg = IMAGES + inFile;
      String desImg = PROCIMAGES + "Processed_" + inFile;

      BufferedImage originalImg = null;
	  originalImg = ImageIO.read(new File(originImg));
      int len = ftrs.size();
	  int type = originalImg.getType();

      showFilterErrMsg(len);
	  showTypeErrMsg(type);

      try{
         //Create pipe objects
         p = new Pipe[len + 1];
         for(int i = 0; i < len+1; i++){
	        p[i] = new Pipe();
	     }

	     Iterator etr = ftrs.iterator();

	     Filter input = new InputFilter(originalImg, p[0], imLabel[0]);

	     for(int i=0; i<len; i++){
	        if(etr.hasNext()){
	           String s = (String) etr.next();
	           String des = getFilterDescription(s);
	           showFilterInfo(filterInfoTxt, des);

	           if(s.compareTo("RGBFilter")==0)
	              filter[i] = new RGBFilter(p[i], p[i+1], imLabel[i+1],originalImg);
	           else if(s.compareTo("ThresholdFilter")==0)
	              filter[i] = new ThreshHoldFilter(p[i], p[i+1], imLabel[i+1],originalImg);
	           else if(s.compareTo("TransFilter")==0)
	              filter[i] = new TransFilter(p[i], p[i+1], imLabel[i+1],originalImg);
	           else if(s.compareTo("GrayOutFilter")==0)
	              filter[i] = new GrayOutFilter(p[i], p[i+1], imLabel[i+1],originalImg);
	        }
	     }

         Filter output = new OutputFilter(p[len], originalImg, desImg );

         //Start all the filter threads
         input.start();
         for(int i=0;i<len;i++){
	        filter[i].start();
	     }
	     output.start();
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

      if ( filtor.compareTo("RGBFilter")==0 ) {
         filterDesc = "RGBFilter: do RGBFilter Filtering...\n";
      }
      else if ( filtor.compareTo("ThresholdFilter")==0 ) {
         filterDesc = "ThresholdFilter: do ThresholdFilter Filtering...\n";
      }
      else if ( filtor.compareTo("TransFilter")==0 ) {
	     filterDesc = "TransFilter: do TransFilter Filtering...\n";
      }
      else if ( filtor.compareTo("GrayOutFilter")==0 ) {
	     filterDesc = "GrayOutFilter: do GrayOutFilter Filtering...\n";
      }
   	  return filterDesc;
   }

   private void showFilterErrMsg(int len){
      if((len > 3) || (len == 0)){
  	     filterInfoTxt.append("You need to select at least "+
  		                      "1 and no more than 3 filters");
  		 return;
	  }
   }

   private void showTypeErrMsg(int type){
   	  if(type != BufferedImage.TYPE_3BYTE_BGR){
         filterInfoTxt.append("Wrong image type. "  +
                              "Only TYPE_3BYTE_BGR "+
                              "can be processed properly.");
   		 return;
	  }
   }
}
