
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class ImageSharpening implements BufferedImgOperations{
   private ConvolveOp convolveObj;

   public ImageSharpening(){
      float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 5.f, -1.0f, 0.0f, -1.0f, 0.0f };

      Kernel kernel = new Kernel(3, 3, elements);
      convolveObj = new ConvolveOp(kernel);
   }

   public BufferedImage filter(BufferedImage src, BufferedImage dst){

      int width = src.getWidth();
	  int height = src.getHeight();
	  int type = src.getType();

	  if ( dst == null )
         dst = new BufferedImage( width, height, type );

      BufferedImage scaledImg = convolveObj.filter(src, dst);
      return scaledImg;
   }
}