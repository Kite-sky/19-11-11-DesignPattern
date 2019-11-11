
import javax.swing.*;
import java.io.*;
import java.net.URL;

public class AuctionFunctions{

   static final String CARFILES = "CarFiles/";
   static final String CARIMAGES = "CarImages/";

   public AuctionFunctions(){

   }

   /*================================================*/
   /* Extract car file names from a diectory on your */
   /* computer                                       */
   /*================================================*/
   public String[] extractCarList(){
      File f = new File(CARFILES);
      String [] fileNames = f.list();

      for(int i=0; i<fileNames.length; i++ ){
         int len = fileNames[i].length();
         fileNames[i]=fileNames[i].substring(0,len-5);
      }
      return fileNames;
   }

   /*==============================================*/
   /* Add car list to combox cmbCarList. Both      */
   /* objects carList and cmbCarList are passed    */
   /* in from parameters.                          */
   /*==============================================*/
   public void setUpCarList(JComboBox cmbCarList,String[] carList){
      for(int k=0; k<carList.length; k++){
        cmbCarList.addItem(carList[k]);
      }
   }

   /*===========================================*/
   /* Setup a path string and convert it to url */
   /*===========================================*/
   public URL constructCarFileUrl(String carChosen){
   	  URL url = null;
         try{
            String fileURLStr = CARFILES + carChosen + ".html";
            url=(new File(fileURLStr)).toURL();
         }
         catch (IOException e){
            e.printStackTrace();
         }
         return url;
   }

   /*=========================================*/
   /* Add car-descriptions page to editorPane */
   /*=========================================*/
   public void updateCarDescription(JEditorPane editorPane, URL url){
  	  try{
	     editorPane.setPage(url);
	           //validate();
	  }
	  catch (IOException e) {
	     e.printStackTrace();
      }
   }

   /*=============================================*/
   /* Display car bit prices offered by users     */
   /* to text area                                */
   /*=============================================*/
   public void showBitPrice(JTextArea bitShownText, String price ){
      bitShownText.append(price);
   }

   /*=======================================*/
   /* Create an image icon from a dir used  */
   /* to show an image of the chosen car.   */
   /* The image is in the dir CARIMAGES     */
   /*=======================================*/
   public ImageIcon produceCarImaIcon(String carChosen){
      String iconStr = CARIMAGES + carChosen +".jpg";
      ImageIcon imgIcon = createImageIcon(iconStr);
      return imgIcon;
   }

   /*============================================*/
   /* put a user selected picture onto the GUI   */
   /*============================================*/
   public void updateCarPicture(JLabel imgLabel,ImageIcon imgIcon){
      imgLabel.setIcon(imgIcon);
      imgLabel.validate();
   }

   /*================================================*/
   /* For a given path, actually create and return   */
   /* an ImageIcon, or null if the path was invalid. */
   /*================================================*/
   protected ImageIcon createImageIcon(String path){
      URL imgURL = getClass().getResource(path);
      if (imgURL != null) {
         return new ImageIcon(imgURL);
      }
      else{
         System.err.println("Couldn't find file: " + path);
         return null;
      }
   }
}

