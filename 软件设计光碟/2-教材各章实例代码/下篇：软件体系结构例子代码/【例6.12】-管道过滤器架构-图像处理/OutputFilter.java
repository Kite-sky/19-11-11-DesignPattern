import java.io.IOException;
import javax.swing.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.*;

public class OutputFilter extends Filter {
   private JTextArea resultTextArea;
   private BufferedImage dstImage;
   private BufferedImage originalImg;
   private JLabel imageLabel;
   private Pipe input;
   private String outFileNM;

   public OutputFilter(Pipe input, BufferedImage originalImg, String fName){
      super(input, null);
      this.input = input;
      this.originalImg = originalImg;
      outFileNM = fName;
   }

   /*---------------------------------------------------*/
   /* Read from the input pipe, each time 1 bye of      */
   /* image data is read, and for any pixel, 3 times    */
   /* of read operations are needed. The 3 bytes are    */
   /* put together and form an integer of a pixel,      */
   /* for producing and displaying an image.            */
   /*---------------------------------------------------*/
   protected void filter() {
      int width = originalImg.getWidth();
	  int height = originalImg.getHeight();
	  int len = width*height;

	  dstImage = BufImgOperations.createCompatibleDestImage( originalImg, null );

	  int[] outPixels = new int[len];

      try {
		 for(int k=0;k<len;k++){
	        int r = inPipe.read();
			int g = inPipe.read();
			int b = inPipe.read();
            int p = (r << 16) | (g << 8) | b;

			outPixels[k] = p;
		 }

		//Setup pixels for dstImage from outPixels
		dstImage = BufImgOperations.setupImgPixels(outPixels, dstImage);

		//Write the processed image to an image file to hard disk
	    ImageIO.write(dstImage, "JPEG", new File(outFileNM));// 输出到文件流
      }
      catch(IOException exc){
         exc.printStackTrace();
         System.exit(1);
      }
   }//end transform method
}
