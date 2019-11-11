
import java.io.IOException;
import javax.swing.*;
import java.awt.image.*;


public class TransFilter extends Filter {
   private JLabel imageLabel;
   private BufferedImage dstImage;
   private BufferedImage originalImg;
   private WritableRaster dstRaster;
   private int[] outPixels;
   private Pipe input, output;

   public TransFilter(Pipe input, Pipe output,JLabel imLabel,BufferedImage originalImg){
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
  /* put together and form an integer of a pixel,      */
  /* for image processing. After a pixel is processed  */
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
            int p = (r << 16) | (g << 8) | b;

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
   		int r = (rgb >> 16) & 0xff;
   		int g = (rgb >> 8) & 0xff;
   		int b = rgb & 0xff;

   		int red = r/2;
   		int green = g;
   		int blue = b;

   		int pixValue = (red << 16) | (green << 8) | blue;
   		return pixValue;
	}
}
