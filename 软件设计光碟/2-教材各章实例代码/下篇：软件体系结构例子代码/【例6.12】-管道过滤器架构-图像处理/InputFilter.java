
import java.io.IOException;
import javax.swing.*;
import java.awt.image.*;
import java.lang.Thread;


public class InputFilter extends Filter {
  private BufferedImage originalImg;
  private int[] inPixels;
  private JLabel imageLabel;


  public InputFilter(BufferedImage oriImg, Pipe output, JLabel imLabel){
    super(null, output);
    originalImg = oriImg;
    imageLabel = imLabel;
  }

/*-----------------------------------------------*/
/* This method reads and parses an input file.   */
/* The parsed data is written to the output pipe.*/
/*-----------------------------------------------*/
  protected void filter() {
	 int width = originalImg.getWidth();
	 int height = originalImg.getHeight();
	 int len = width*height;

     inPixels = new int[len];

     // Fill inPixels with pixel data from the originalImg
     inPixels = BufImgOperations.fillUpImgArray (originalImg, inPixels);

     byte[][] b = new byte[len][3];

     for( int m = 0; m < len; m++ ){
        b[m] = BufImgOperations.intToByteArray(inPixels[m]);
     }

     try{
        for(int j=0; j< len; j++){
		   for(int i=0; i<3; i++){
		      outPipe.write(b[j][i]);
		   }
	    }

	    int ENDFILE = -1;
	    outPipe.write(ENDFILE);
        outPipe.closePipedOutputStream();
     }
     catch(IOException exc){
        exc.printStackTrace();
        System.err.println("Error: Could not read the input file.");
        System.exit(1);
     }

     ImageIcon icon = BufImgOperations.produceImIcon(originalImg);
     BufImgOperations.displayImage(imageLabel,icon);
  }
}
