import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/*---------------------------------------*/
/* This Pipe class encapsulates piped    */
/* reader and piped writer               */
/*---------------------------------------*/
public class Pipe {
   private PipedOutputStream pOut;
   private PipedInputStream pIn;

  /*-------------------------------------------*/
  /* The constructor connects input character  */
  /* stream with output character stream.      */
  /*-------------------------------------------*/
  public Pipe() throws IOException{
     pOut = new PipedOutputStream();
     pIn = new PipedInputStream(pOut);
  }

  public void write(int c) throws IOException{
     pOut.write(c);
  }

  public void write(byte[] c) throws IOException{
       pOut.write(c, 0, 4);
  }

  public int read() throws IOException{
     int c = pIn.read();
     return c;
  }

  //Returns the number of bytes that can be read from
  //this input stream without blocking
  public int inStreamAvailable() throws IOException{
     return pIn.available();
  }


  /*---------------------------------------------*/
  // Flush of the output stream will cause the   */
  // contents that have already been written     */
  // by the pOut.write(c) returning back to the  */
  // buffer privided by the object "pIn" of      */
  // PipedInputStream                            */
  /*---------------------------------------------*/
  public void closePipedOutputStream() throws IOException{
     pOut.flush();
     pOut.close();
  }

  public void closePipedInputStream() throws IOException{
     pIn.close();
  }
}
