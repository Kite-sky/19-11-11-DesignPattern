import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.IOException;


public class PipeLineBuilder{
   private JLabel[] imgLabel=new JLabel[6];
   private ArrayList filterNms;
   private JTextArea filterInfoTxt;
   private static final String IMAGES = "Images/";
   private static final String PROCIMAGES = "ProcessedImages/";

   /*===============================================*/
   /* Parameters: ftrStr: a list of filter names.   */
   /* imLbl: a list of labels used for adding image */
   /* on each one. infoTxt is for displaying filter */
   /* information                                   */
   /*===============================================*/
   public PipeLineBuilder(ArrayList ftrStr, JLabel[] imLbl, JTextArea infoTxt) throws IOException{
	  imgLabel = imLbl;
	  filterNms = ftrStr;
	  filterInfoTxt = infoTxt;
   }

   public void processImage(String originalImg, String chosenImg){

     int len = filterNms.size();
     if((len > 3) || (len == 0)){
	    filterInfoTxt.append("You need to select at least 1 and no more than 3 filters");
	 	return;
	 }
	 String[] midImg = new String[len];

   	 for(int m=0;m<len;m++){
   	    midImg[m] = PROCIMAGES+"Mid_"+ (m+1) + chosenImg;
	 }

   	 BufferedImage[] img = new BufferedImage[len+1];
   	 ImageIcon[] imgIcon;
   	 imgIcon = new ImageIcon[len+1];

   	 try{
   	    img[0] = ImageIO.read(new File(originalImg));
   	 }
   	 catch (IOException e1){
   	    e1.printStackTrace();
   	 }

   	 imgIcon[0] = produceImIcon(img[0]);
   	 displayImage(imgLabel[0],imgIcon[0]);

   	 String s = null;
   	 Iterator etr = filterNms.iterator();

   	 for(int i=0; i<len; i++){
   	    if(etr.hasNext()){
   	       s = (String) etr.next();
   	       BufferedImgOperations ftr = createObj(s);

   	       img[i+1] = ftr.filter(img[i], img[i+1]);

   	       try{
   	          ImageIO.write(img[i+1], "JPEG", new File(midImg[i]));// 输出到文件流
   	 	   }
   	 	   catch (IOException e){
   	 	      e.printStackTrace();
   	       }
   	       imgIcon[i+1] = produceImIcon(img[i+1]);
   	       displayImage(imgLabel[i+1],imgIcon[i+1]);

           /*=======================================================*/
           /* Read content of midImg[i] to get image img[i+1]       */
           /* Actually in this program you don't need the read      */
           /* image part below. Now we put the read image part      */
           /* as below for the reason that we need to show that     */
           /* this program is written as batch sequential software  */
           /* architecture                                          */
           /*=======================================================*/
   	       try{
   	          img[i+1] = ImageIO.read(new File(midImg[i]));
   	 	   }
   	       catch (IOException e7) {
   	 	      e7.printStackTrace();
   	       }
   	 	}
           String ftrStr = getFilterDescription(s);
   	    showFilterInfo(filterInfoTxt, ftrStr);
   	 }//end for
  }

 public BufferedImgOperations createObj(String node){
   	  BufferedImgOperations filterObj = null;

   	  if ( node.compareTo("BlurFilter")==0 ) {
   		  filterObj = new ImageBluring();
       }
       else if ( node.compareTo("BrighteningFilter")==0 ) {
   	  	  filterObj = new ImageBrightening();
       }
       else if ( node.compareTo("EdgeDetectionFilter")==0 ) {
   	  	  filterObj = new ImageEdgeDetection();
   	  }
   	  else if ( node.compareTo("SharpenFilter")==0 ) {
 	  	  filterObj = new ImageSharpening();
   	  }

   	  return  filterObj;
    }


  /*==========================================*/
  /* Get the description of a selected filter */
  /*==========================================*/
  public String getFilterDescription(String filtor ){
	 String filterDesc = null;

      if ( filtor.compareTo("BlurFilter")==0 ) {
  	     filterDesc = "BlurFilter: do Blur Filtering...\n";
      }
      else if ( filtor.compareTo("BrighteningFilter")==0 ) {
  	  	 filterDesc = "BrighteningFilter: do Brightening Filter...\n";
      }
      else if ( filtor.compareTo("EdgeDetectionFilter")==0 ) {
  	  	 filterDesc = "EdgeDetectionFilter: do EdgeDetectionFilter Filtering...\n";
  	  }
  	  else if ( filtor.compareTo("SharpenFilter")==0 ) {
	  	 filterDesc = "SharpenFilter: do SharpenFilter Filtering...\n";
  	  }

	  return filterDesc;
  }
  /*============================================*/
  /* Display the selected filter's description  */
  /* to the upper right coner of the screen     */
  /*============================================*/
    public void showFilterInfo(JTextArea filterInfoTxt, String filterInfo ){
       filterInfoTxt.append(filterInfo);
  }

  /*=======================================*/
  /* Create an image icon from a dir used  */
  /* to show an chosen image               */
  /*=======================================*/
  public ImageIcon produceImIcon(Image img){
     ImageIcon imgIcon = new ImageIcon(img);
     return imgIcon;
  }

  /*================================*/
  /* Display an image to the Gui    */
  /*================================*/
  public void displayImage(JLabel imgLabel,ImageIcon imgIcon){
     imgLabel.setIcon(imgIcon);
     imgLabel.validate();
  }
}
