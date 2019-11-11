import java.io.IOException;
import javax.swing.*;
import java.awt.image.*;


public class RGBFilter extends Filter{
   private JLabel imageLabel;
   private BufferedImage originalImg;
   private BufferedImage dstImage;
   private int[] outPixels;
   private Pipe input, output;
   private int width;
   private int height;


   public RGBFilter(Pipe input, Pipe output, JLabel imLabel,BufferedImage originalImg){
      super(input, output);
      this.input = input;
      this.output= output;
      this.originalImg = originalImg;
      imageLabel = imLabel;
   }

   /*---------------------------------------------------*/
   /* Read from the input pipe, each time 1 bye of      */
   /* image data is read, and for any pixel, 3 times    */
   /* of read operations are needed. The 3 bytes are    */
   /* put together and form an integer of a pixel for   */
   /* image processing. After a pixel is processed,     */
   /* the pixel is again be splitted into 3 byes, and   */
   /* then write them 3 times, each time a byte to the  */
   /* outpipe                                           */
   /*---------------------------------------------------*/
   protected void filter(){
      int width = originalImg.getWidth();
	  int height = originalImg.getHeight();
	  int len = width*height;

	  dstImage = BufImgOperations.createCompatibleDestImage( originalImg, null );

	  outPixels = new int[len];
      int rgbValue;

      byte[][] byteValue = new byte[len][3];

       try{
		  for(int k=0;k<len;k++){
			 int r = inPipe.read();
			 int g = inPipe.read();
			 int b = inPipe.read();

			 int p = (r << 16) |(g << 8) | b;

		     rgbValue = filterRGB(p);
		     outPixels[k] = rgbValue;

		     byteValue[k] = BufImgOperations.intToByteArray(outPixels[k]);

		     for(int i=0; i<3; i++)
			    outPipe.write(byteValue[k][i]);
		  }

		  int ENDFILE = -1;
	      outPipe.write(ENDFILE);
		  outPipe.closePipedOutputStream();

          //Setup pixels for dstImage from outPixels
          dstImage = BufImgOperations.setupImgPixels(outPixels, dstImage);
          ImageIcon  icon = BufImgOperations.produceImIcon(dstImage);
	      BufImgOperations.displayImage(imageLabel,icon);
      }
      catch(IOException exc) {
         exc.printStackTrace();
         System.exit(1);
      }
   }

   public int filterRGB(int rgb) {
       float rFactor = 1+(0.15f);
	   float gFactor = 1+(-0.15f);
	   float bFactor = 1+(-0.15f);

	   int r = (rgb >> 16) & 0xff;
	   int g = (rgb >> 8) & 0xff;
	   int b = rgb & 0xff;

	   int red = (int)(r * rFactor);
	   int green = (int)(g * gFactor);
	   int blue = (int)(b * bFactor);

	   int redPix = BufImgOperations.trim(red);
	   int greenPix = BufImgOperations.trim(green);
	   int bluePix = BufImgOperations.trim(blue);

	   int rgbPix = (redPix << 16) | (greenPix << 8) | bluePix;
	   return rgbPix;
	}
}
