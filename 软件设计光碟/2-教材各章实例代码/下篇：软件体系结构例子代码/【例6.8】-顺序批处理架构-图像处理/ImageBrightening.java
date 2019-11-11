
import java.awt.image.RescaleOp;
import java.awt.image.BufferedImage;


public class ImageBrightening implements BufferedImgOperations{
   private RescaleOp rescaleObj;

   public ImageBrightening(){
      float a = 1.0005f; //for multiplication of the pixel values
	  float b = -1.0f; // for adding a const
      rescaleObj = new RescaleOp(a, b, null);
   }

   public BufferedImage filter(BufferedImage src, BufferedImage dst){

       int width = src.getWidth();
	   int height = src.getHeight();
	   int type = src.getType();

	   if ( dst == null )
          dst = new BufferedImage( width, height, type );

      BufferedImage scaledImg = rescaleObj.filter(src, dst);
      return scaledImg;
   }
}