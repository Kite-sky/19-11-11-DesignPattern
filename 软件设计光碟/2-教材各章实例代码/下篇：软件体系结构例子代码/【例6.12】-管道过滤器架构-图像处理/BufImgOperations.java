
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;


public class BufImgOperations {
   private static int INT_ARGB = BufferedImage.TYPE_INT_ARGB;
   private static int INT_RGB = BufferedImage.TYPE_INT_RGB;

   public static BufferedImage createCompatibleDestImage(BufferedImage src, ColorModel dstCM) {
      if ( dstCM == null )
         dstCM = src.getColorModel();

      int w = src.getWidth();
      int h = src.getHeight();

      WritableRaster wRaster = dstCM.createCompatibleWritableRaster(w, h);
      boolean transparency =  dstCM.isAlphaPremultiplied();

      BufferedImage bufImg = new BufferedImage(dstCM, wRaster, transparency, null);

      return bufImg;
   }

   public static BufferedImage setupImgPixels(int[] outPixels, BufferedImage bImg){
      int width = bImg.getWidth();
	  int height = bImg.getHeight();
      int type = bImg.getType();

	  WritableRaster raster = bImg.getRaster();

      if ( type == BufferedImage.TYPE_INT_ARGB ) {
	     raster.setDataElements( 0, 0, width, height, outPixels);
		 System.out.println("Output filter. This is TYPE_INT_ARGB.");
	  }
	  else {
         bImg.setRGB( 0, 0, width, height, outPixels, 0, width );
		 System.out.println("Output filter. This is NOT TYPE_INT_ARGB.");
	  }
	  return bImg;
   }

   // Fill inPixels with pixel data from the originalImg
   public static int[] fillUpImgArray (BufferedImage bImg, int[] pixelArr){
      int width = bImg.getWidth();
	  int height = bImg.getHeight();
      int type = bImg.getType();

	  WritableRaster raster = bImg.getRaster();

	  if ( type == BufferedImage.TYPE_INT_ARGB ){
	     raster.getDataElements( 0, 0, width, height, pixelArr );
	  }
	  else{
		 bImg.getRGB( 0, 0, width, height, pixelArr, 0, width );
      }
      return pixelArr;
    }

   /*=======================================*/
   /* Create an image icon from a dir used  */
   /* to show an image of the chosen car.   */
   /* The image is in the dir CARIMAGES     */
   /*=======================================*/
   public static ImageIcon produceImIcon(Image img){
      ImageIcon imgIcon = new ImageIcon(img);
      return imgIcon;
   }

   /*============================================*/
   /* put a user selected picture onto the GUI   */
   /*============================================*/
   public static void displayImage(JLabel imgLabel,ImageIcon imgIcon){
      imgLabel.setIcon(imgIcon);
      imgLabel.validate();
   }

   /*---------------------------------------------------------------*/
   /* TYPE_3BYTE_BGR Represents an image with 8-bit RGB              */
   /* color components, corresponding to a Windows-style            */
   /* BGR color model) with the colors Blue, Green, and Red         */
   /* stored in 3 bytes. There is no alpha. The image has a         */
   /* ComponentColorModel. When data with non-opaque alpha is       */
   /* stored in an image of this type, the color data must be       */
   /* adjusted to a non-premultiplied form and the alpha discarded, */
   /* as described in the AlphaComposite documentation.             */
   /*---------------------------------------------------------------*/
   public static byte[] intToByteArray(int value) {
      byte[] b = new byte[3];
      for (int i = 0; i < 3; i++) {
         int offset = (2 - i) * 8;
         b[i] = (byte) ((value >> offset) & 0xFF);
      }
      return b;
   }

   //Trim a value to the range 0..255
   public static int trim(int c) {
      if (c < 0){
         return 0;
   	  }
      if (c > 255){
      	 return 255;
   	  }
      return c;
   }
}
