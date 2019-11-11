
import java.io.IOException;
import javax.swing.*;
import java.awt.image.*;

public class ThreshHoldFilter extends Filter{
   private JLabel imageLabel;
   private BufferedImage dstImage;
   private BufferedImage originalImg;
   private int[] outPixels;
   private Pipe input, output;

   public ThreshHoldFilter(Pipe input, Pipe output, JLabel imLabel,BufferedImage originalImg){
      super(input, output);
      this.input = input;
      this.output= output;
      this.originalImg=originalImg;
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
      dstImage = BufImgOperations.createCompatibleDestImage( originalImg, null );

      int width = originalImg.getWidth();
 	  int height = originalImg.getHeight();
 	  int len = width*height;
 	  outPixels = new int[len];
      byte[][] byteValue = new byte[len][3];

	  try{
         for(int k=0;k<len;k++){
		    int r = inPipe.read();
			int g = inPipe.read();
			int b = inPipe.read();

            int p = (r << 16) | (g << 8) | b;

		    int rgb = filterRGB(p);
			outPixels[k] = rgb;
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
      int loThreshold = 20;
	  int hiThreshold = 200;
	  int white = 0xffffff;
	  int black = 0x000000;

	  int r = (rgb >> 16) & 0xff; //shift right 16 bits
	  int g = (rgb >> 8) & 0xff;
	  int b = rgb & 0xff;
	  int ave = (r + g + b)/3;

	  if (ave < loThreshold)
	     return black;
	  else if (ave > hiThreshold)
	     return white;
	  return rgb;
   }
}


